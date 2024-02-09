package app.warriorkt.core

import app.warriorkt.core.ability.Walk
import app.warriorkt.core.actor.Sludge


class WarriorKt {
  var level: Level? = null
  var turn: Int = 0

  fun loadLevel(level: Level) {
    this.level = level
  }

  fun playTurn() {
    if (this.level == null) {
      throw Exception("No level loaded")
    }

    this.level!!.floor.actors.forEach {
      it.prepareTurn()
      it.performTurn()
    }

    this.turn += 1
    this.level!!.timeBonus -= 1
  }
}

fun testLevel() =
  LevelBuilder {
    description = "You see before yourself a long hallway with stairs at the end. There is nothing in the way."
    tip = "Call warrior.walk! to walk forward in the Player 'play_turn' method."

    timeBonus = 15
    aceScore = 10

    size(8, 1)
    stairs(7, 0)

    warrior(0, 0, Direction.EAST) {
      addAbility(Walk::class)
    }

    actor(Sludge::class, 3, 0, Direction.WEST)
  }
