package app.warriorkt.core.actors

import app.warriorkt.core.LogQueue
import app.warriorkt.core.abilities.Ability

abstract class Actor {
  var health: Int = 0
  val maxHealth: Int = 0
  val power: Int = 0
  val abilities: MutableMap<String, Ability> = mutableMapOf()

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
      this.abilities[ability.name] = ability
    }
  }

  fun prepareTurn() {
  }

  fun performTurn() {
  }

  fun playTurn() {

  }

  val isAlive: Boolean get() = health > 0
  val name: String get() = this.javaClass.simpleName
}
