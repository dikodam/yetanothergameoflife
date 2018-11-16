package de.dikodam.gameoflife

class LivingCell(x: Int, y: Int) : Cell(x, y) {

    override fun computeNextState(countOfLivingNeighbors: Int): Cell {
        return if (countOfLivingNeighbors == 2 || countOfLivingNeighbors == 3) {
            LivingCell(x, y)
        } else {
            DeadCell(x, y)
        }
    }

    override fun toString(): String {
        return "LivingCell{" +
            "x=" + x +
            ", y=" + y +
            '}'.toString()
    }
}
