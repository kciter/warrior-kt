package app.warriorkt.core.actors

import app.warriorkt.core.abilities.Ability

class Sludge(
  override val maxHealth: Int = 12,
  override val power: Int = 3,
  override val abilities: MutableMap<String, Ability>,
  override val character: Char = 's'
): Actor() {
  override fun playTurn() {
    // TODO: Implement playTurn
  }
}
