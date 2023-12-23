package app.warriorkt.core.actors

import app.warriorkt.core.abilities.Ability

class Warrior(
  override val maxHealth: Int = 20,
  override val attackPower: Int = 5,
  override val character: Char = '@'
): Actor() {
  override val shootPower: Int = 3

  override fun playTurn() {
    TODO("Not yet implemented")
  }
}
