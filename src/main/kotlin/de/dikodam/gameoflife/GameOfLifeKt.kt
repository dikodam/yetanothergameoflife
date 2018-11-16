package de.dikodam.gameoflife

import java.util.*

typealias State = Set<LivingCell>

class GameOfLifeKt(private var currentState: State = HashSet(),
                   private val history: MutableList<State> = ArrayList()) {

    fun computeNextState(): State {
        val allDeadNeighbors = constructAllDeadNeighbors()
        val cellsPotentiallyLivingInNextState = listOf(allDeadNeighbors, currentState).flatten()
        val coordinateCountMap = cellsPotentiallyLivingInNextState.groupByCount()
        return cellsPotentiallyLivingInNextState.asSequence()
            .map { cell -> cell.computeNextState(coordinateCountMap[cell.getCoordinates()]!!) }
            .filter { it is LivingCell }
            .map { it as LivingCell }
            .toSet()
    }

    fun constructAllDeadNeighbors(): List<Cell> =
        currentState.flatMap { cell: Cell -> constructNeighborsOf(cell) }

    fun constructNeighborsOf(cell: Cell): List<DeadCell> {
        val (x, y) = cell
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

    fun Collection<Cell>.groupByCount(): Map<Coordinates, Int> {
        return this.groupBy { cell -> cell.getCoordinates() }
            .map { entry -> Pair(entry.key, entry.value.size) }
            .toMap()
    }
}