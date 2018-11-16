package de.dikodam.gameoflife

class DeadCell(x: Int, y: Int) : Cell(x, y) {

    override fun computeNextState(countOfLivingNeighbors: Int): Cell {
        return if (countOfLivingNeighbors == 3) {
            LivingCell(x, y)
        } else DeadCell(x, y)
    }

    override fun toString(): String {
        return "DeadCell{" +
            "x=" + x +
            ", y=" + y +
            '}'.toString()
    }
}
