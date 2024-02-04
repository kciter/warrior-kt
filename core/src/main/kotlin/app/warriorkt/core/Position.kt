package app.warriorkt.core

class Position {
  var coordinate: Coordinate
  var direction: Direction

  constructor(coordinate: Coordinate, direction: Direction = Direction.NORTH) {
    this.coordinate = coordinate
    this.direction = direction
  }

  fun rotate(amount: Int) {
    val directions = Direction.entries.toTypedArray()
    var index = directions.indexOf(direction)
    index += amount
    while (index > 4) index -= 4
    while (index < 0) index += 4
    direction = directions[index]
  }
}
