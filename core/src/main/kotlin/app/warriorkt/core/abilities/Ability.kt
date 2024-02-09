package app.warriorkt.core.abilities

import app.warriorkt.core.Orientation
import app.warriorkt.core.actor.Actor

sealed interface Ability {
  val description: String
  val type: Type
  val actor: Actor
  val name: String

  fun passTurn() {}

  enum class Type {
    ACTION,
    SENSE
  }

  interface Directional: Ability {
    fun perform(direction: Orientation)
  }

  interface Self: Ability {
    fun perform()
  }
}
