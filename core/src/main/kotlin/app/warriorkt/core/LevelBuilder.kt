package app.warriorkt.core

import app.warriorkt.core.actors.Actor
import app.warriorkt.core.actors.Warrior
import kotlin.reflect.KClass

@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class LevelDsl

@LevelDsl
class LevelBuilder {
  var description: String = ""
  var tip: String = ""
  var clue: String = ""

  var width: Int = 0
  var height: Int = 0
  var timeBonus: Int = 0
  var aceScore: Int = 0

  private var stairs: Coordinate = Coordinate(0, 0)

  private var warrior: Warrior? = null

  private var actors: MutableList<Actor> = mutableListOf()

  companion object {
    operator fun invoke(block: LevelBuilder.() -> Unit): Level {
      val generator = LevelBuilder()
      generator.block()
      return generator.build()
    }
  }

  fun size(width: Int, height: Int) {
    this.width = width
    this.height = height
  }

  fun stairs(x: Int, y: Int) {
    this.stairs = Coordinate(x, y)
  }

  fun warrior(x: Int, y: Int, direction: Direction, block: Warrior.() -> Unit) {
    this.warrior = Warrior(Position(Coordinate(x, y), direction)).apply(block)
  }

  fun <T: Actor> actor(actorClass: KClass<T>, x: Int, y: Int, direction: Direction) {
    this.actors.add(actorClass.constructors.first().call(Position(Coordinate(x, y), direction)))
  }

  private fun build(): Level {
    // Create floor
    val floor = Floor(
      width = this.width,
      height = this.height,
      stairsLocation = this.stairs
    )

    // Add actors to floor
    floor.addActor(this.warrior!!)
    this.actors.forEach {
      floor.addActor(it)
    }

    return Level(
      description = description,
      tip = tip,
      clue = clue,
      timeBonus = timeBonus,
      aceScore = aceScore,
      floor = floor,
    )
  }
}
