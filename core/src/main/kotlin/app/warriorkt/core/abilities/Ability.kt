package app.warriorkt.core.abilities

import app.warriorkt.core.actors.Actor

abstract class Ability {
  abstract val description: String
  abstract val type: AbilityType
  var actor: Actor? = null

  abstract fun perform()

  val name: String get() = this.javaClass.simpleName

  enum class AbilityType {
    ACTION, SENSE
  }
}
