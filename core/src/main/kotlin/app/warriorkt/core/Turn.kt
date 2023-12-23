package app.warriorkt.core

import app.warriorkt.core.abilities.Ability

class Turn(abilities: List<Ability>) {
  private var action: Ability? = null
  private var senses: MutableList<Ability> = mutableListOf()

  init {
    abilities.forEach { ability ->
      if (ability.type == Ability.AbilityType.ACTION) {
        this.action = ability
      } else {
        this.senses.add(ability)
      }
    }
  }

  fun setAction(ability: Ability) {
    if (action != null) {
      LogQueue.add("You can only perform one action per turn.")
      throw Exception("You can only perform one action per turn.")
    }
    this.action = ability
  }
}
