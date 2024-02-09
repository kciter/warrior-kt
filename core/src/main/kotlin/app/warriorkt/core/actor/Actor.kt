package app.warriorkt.core.actor

import app.warriorkt.core.LogQueue
import app.warriorkt.core.Orientation
import app.warriorkt.core.Position
import app.warriorkt.core.Turn
import app.warriorkt.core.ability.Ability
import kotlin.reflect.KClass

abstract class Actor {
  abstract val maxHealth: Int
  abstract val attackPower: Int
  abstract val character: Char
  abstract var position: Position

  var orientation: Orientation = Orientation.FORWARD

  open val shootPower: Int = 0
  open val abilities: MutableMap<String, Ability> = mutableMapOf()

  var health: Int = this.maxHealth
  var currentTurn: Turn? = null

  fun takeDamage(amount: Int) {
    if (this.health > 0) {
      this.health -= amount

      if (health < 0) {
        this.health = 0
        // Die Log
      }
    }
  }

  fun <T: Ability> addAbility(abilityClass: KClass<T>) {
    val ability = abilityClass.constructors.first().call(this)
    this.abilities[ability.name] = ability
  }

  fun addAbilities(abilities: List<Ability>) {
    abilities.forEach { ability ->
      this.abilities[ability.name] = ability.let { ability ->
        ability
      }
    }
  }

  fun prepareTurn() {
    this.currentTurn = Turn(this.abilities.values.toList())
  }

  fun performTurn() {
    if (this.isAlive) {
      this.currentTurn?.action?.let { action ->
//        action.perform(this)
      }
    } else {
      LogQueue.add("${this.name} is dead and cannot perform a turn.")
    }
  }

  abstract fun playTurn()

  val isAlive: Boolean get() = health > 0
  val name: String get() = this.javaClass.simpleName
}
