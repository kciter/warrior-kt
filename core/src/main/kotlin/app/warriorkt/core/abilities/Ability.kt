package app.warriorkt.core.abilities

import app.warriorkt.core.RelativeDirection
import app.warriorkt.core.actors.Actor

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
    fun perform(direction: RelativeDirection)
  }

  interface Self: Ability {
    fun perform()
  }
}

//abstract class Ability {
//  abstract val description: String
//  abstract val type: AbilityType
//  var actor: Actor? = null
//
//  abstract fun <T> perform(arg: T)
//
//  fun passTurn() {}
//
//  val name: String get() = this.javaClass.simpleName
//
//  enum class AbilityType {
//    ACTION, SENSE
//  }
//}
