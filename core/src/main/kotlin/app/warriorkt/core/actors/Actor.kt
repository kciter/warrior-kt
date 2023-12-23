package app.warriorkt.core.actors

import app.warriorkt.core.LogQueue
import app.warriorkt.core.Turn
import app.warriorkt.core.abilities.Ability
import kotlin.math.max

abstract class Actor {
  abstract val maxHealth: Int
  abstract val power: Int
  abstract val abilities: MutableMap<String, Ability>
  abstract val character: Char

  private var health: Int = this.maxHealth

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

  fun addAbilities(abilities: List<Ability>) {
    abilities.forEach { ability ->
      this.abilities[ability.name] = ability.let { ability ->
        ability.actor = this
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
