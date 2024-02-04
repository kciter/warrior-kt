package app.warriorkt.core

import app.warriorkt.core.actors.Actor
import app.warriorkt.core.actors.Warrior

class Floor {
  val width: Int
  val height: Int
  val stairsLocation: Coordinate
  val actors: MutableList<Actor> = mutableListOf()

  var warrior: Warrior? = null

  constructor(width: Int, height: Int, stairsLocation: Coordinate) {
    this.width = width
    this.height = height
    this.stairsLocation = stairsLocation
  }

  fun addActor(actor: Actor) {
    if (actor is Warrior) {
      this.warrior = actor
    } else {
      this.actors.add(actor)
    }
  }

  fun getAliveUnits(): List<Actor> =
    this.actors.filter { it.isAlive }

  fun isOutOfBounds(coordinate: Coordinate): Boolean =
    0 > coordinate.x || coordinate.x >= this.width || 0 > coordinate.y || coordinate.y >= this.height
}
