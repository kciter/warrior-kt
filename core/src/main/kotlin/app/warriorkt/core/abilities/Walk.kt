package app.warriorkt.core.abilities

import app.warriorkt.core.RelativeDirection
import app.warriorkt.core.actors.Actor

class Walk(
  override var actor: Actor
): Ability.Directional {
  override val description: String = "Move in the given direction (forward by default)."
  override val type: Ability.Type = Ability.Type.ACTION
  override val name: String = this.javaClass.simpleName

  override fun perform(direction: RelativeDirection) {
    TODO("Not yet implemented")
  }
}
