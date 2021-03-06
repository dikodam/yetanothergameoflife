package de.dikodam.gameoflife

typealias Coordinates = Pair<Int, Int>

abstract class Cell(val x: Int, val y: Int) {

    fun getCoordinates(): Coordinates = Pair(x, y)

    abstract fun computeNextState(countOfLivingNeighbors: Int): Cell

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Cell) return false

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    override fun toString(): String = "Cell(x=$x, y=$y)"

    operator fun component1(): Int = x
    operator fun component2(): Int = y
}
