package app.warriorkt.core.abilities

abstract class Ability {
  abstract val type: AbilityType
  val name: String = this.javaClass.simpleName

  enum class AbilityType {
    ACTION, SENSE
  }
}
