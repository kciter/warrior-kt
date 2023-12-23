package app.warriorkt.core

class Position {
  val floor: Floor
  var coordinate: Coordinate
  var direction: Direction

  constructor(floor: Floor, coordinate: Coordinate, direction: Direction = Direction.NORTH) {
    this.floor = floor
    this.coordinate = coordinate
    this.direction = direction
  }
}
