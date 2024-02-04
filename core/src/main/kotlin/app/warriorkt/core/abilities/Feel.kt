package app.warriorkt.core.abilities

import app.warriorkt.core.Orientation
import app.warriorkt.core.actors.Actor

class Feel(
  override val actor: Actor
): Ability.Directional {
  override val description: String = "Attacks a unit in given direction (forward by default)."
  override val type: Ability.Type = Ability.Type.SENSE
  override val name: String = this.javaClass.simpleName

  override fun perform(direction: Orientation) {
    TODO("Not yet implemented")
  }
}
