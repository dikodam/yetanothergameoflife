package de.dikodam.gameoflife

import java.util.*

typealias State = Set<LivingCell>

class GameOfLifeKt(private var currentState: State = HashSet(),
                   private val history: MutableList<State> = ArrayList()) {

    public fun computeNextState()
//        : State
    {
        val allDeadNeighbors = constructAllDeadNeighbors()
    }

    public fun constructAllDeadNeighbors(): List<Cell> {
        return currentState.flatMap { cell: Cell -> constructNeighborsOf(cell) }
    }

    public fun constructNeighborsOf(cell: Cell): List<DeadCell> {
        val x = cell.x;
        val y = cell.y;
        return listOf(
            DeadCell(x - 1, y - 1),
            DeadCell(x - 1, y),
            DeadCell(x - 1, y + 1),
            DeadCell(x, y - 1),
            DeadCell(x, y + 1),
            DeadCell(x + 1, y - 1),
            DeadCell(x + 1, y),
            DeadCell(x + 1, y + 1)
        )
    }

    public fun Collection<Cell>.groupByCount(): Map<Coordinates, Int> {
        return this.groupBy { cell -> cell.getCoordinates() }
            .map { entry -> Pair(entry.key, entry.value.size) }
            .toMap()
    }

}