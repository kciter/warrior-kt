package app.warriorkt.core.script

@KotlinScript(
  fileExtension = ".kts",
  compilationConfiguration = ScriptWithMavenDepsConfiguration::class
)
abstract class ScriptWithMavenDeps

object ScriptWithMavenDepsConfiguration : ScriptCompilationConfiguration(
  {
    // Implicit imports for all scripts of this type
    defaultImports(DependsOn::class, Repository::class)
    jvm {
      // Extract the whole classpath from context classloader and use it as dependencies
      dependenciesFromCurrentContext(wholeClasspath = true)
    }
    // Callbacks
    refineConfiguration {
      // Process specified annotations with the provided handler
      onAnnotations(DependsOn::class, Repository::class, handler = ::configureMavenDepsOnAnnotations)
    }
  }
)

fun configureMavenDepsOnAnnotations(context: ScriptConfigurationRefinementContext): ResultWithDiagnostics<ScriptCompilationConfiguration> {
  val annotations = context.collectedData?.get(ScriptCollectedData.collectedAnnotations)?.takeIf { it.isNotEmpty() }
    ?: return context.compilationConfiguration.asSuccess()
  return runBlocking {
    resolver.resolveFromScriptSourceAnnotations(annotations)
  }.onSuccess {
    context.compilationConfiguration.with {
      dependencies.append(JvmDependency(it))
    }.asSuccess()
  }
}

private val resolver = CompoundDependenciesResolver(FileSystemDependenciesResolver(), MavenDependenciesResolver())

fun evalFile(scriptFile: File): ResultWithDiagnostics<EvaluationResult> {
  val compilationConfiguration = createJvmCompilationConfigurationFromTemplate<ScriptWithMavenDeps>()
  return BasicJvmScriptingHost().eval(scriptFile.toScriptSource(), compilationConfiguration, null)
}
