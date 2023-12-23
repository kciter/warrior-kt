package app.warriorkt.core.actors

import app.warriorkt.core.abilities.Ability

class Sludge(
  override val maxHealth: Int = 12,
  override val attackPower: Int = 3,
  override val character: Char = 's'
): Actor() {
  override val abilities: MutableMap<String, Ability> = mutableMapOf()

  override fun playTurn() {
    TODO("Not yet implemented")
  }
}
