package app.warriorkt.core.abilities

import app.warriorkt.core.Orientation
import app.warriorkt.core.actor.Actor

class Walk(
  override var actor: Actor
): Ability.Directional {
  override val description: String = "Move in the given direction (forward by default)."
  override val type: Ability.Type = Ability.Type.ACTION
  override val name: String = this.javaClass.simpleName

  override fun perform(direction: Orientation) {
    TODO("Not yet implemented")
  }
}
