package app.warriorkt.core.abilities

import app.warriorkt.core.actors.Actor
import kotlin.math.roundToInt

class Rest(
  override var actor: Actor
): Ability.Self {
  override val description: String = "Gain 10% of max health back, but do nothing more."
  override val type: Ability.Type = Ability.Type.ACTION
  override val name: String = this.javaClass.simpleName

  override fun perform() {
    if (actor.health < actor.maxHealth) {
      val amount = (actor.maxHealth * 0.1).roundToInt()
      actor.health = if (actor.health + amount > actor.maxHealth) {
        actor.maxHealth
      } else {
        actor.health + amount
      }
//      println("${actor.name} receives $amount health from resting, up to ${actor.health} health")
    } else {
      // is already fit as a fiddle
    }
  }
}
