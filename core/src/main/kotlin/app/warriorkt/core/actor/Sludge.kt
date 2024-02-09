package app.warriorkt.core.actor

import app.warriorkt.core.Position
import app.warriorkt.core.abilities.Ability

class Sludge(
  override var position: Position
): Actor() {
  override val maxHealth: Int = 12
  override val attackPower: Int = 3
  override val character: Char = 's'
  override val abilities: MutableMap<String, Ability> = mutableMapOf()

  override fun playTurn() {
    TODO("Not yet implemented")
  }
}
