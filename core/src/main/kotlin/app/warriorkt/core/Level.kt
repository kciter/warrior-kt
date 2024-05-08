package app.warriorkt.core

import kotlin.math.roundToInt

class Level(
  val description: String,
  val tip: String,
  val clue: String,
  var timeBonus: Int,
  val aceScore: Int,
  val floor: Floor
) {

//  fun getScore() = this.floor.warrior.score
//
//  fun getGrade(): String = when {
//    this.getScore() >= this.aceScore -> "S"
//    this.getScore() >= this.aceScore * 0.9 -> "A"
//    this.getScore() >= this.aceScore * 0.8 -> "B"
//    this.getScore() >= this.aceScore * 0.7 -> "C"
//    this.getScore() >= this.aceScore * 0.6 -> "D"
//    else -> "F"
//  }
//
//  fun clearBonus() = ((timeBonus).toDouble() * 0.2f).roundToInt()
}


data class Test(
  val a: Int
) {
  fun change(b: Int, callback: () -> Unit) {
    /* ... */
    callback()
  }
}

fun main() {
  val test = Test(1)
  test.change(2) {
    // Event logic
  }
}
