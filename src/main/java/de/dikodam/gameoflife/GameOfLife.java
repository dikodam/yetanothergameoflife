package de.dikodam.gameoflife;

import java.util.*;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class GameOfLife {
    
    private Set<LivingCell> currentState;
    private List<Set<LivingCell>> history;
    
    public GameOfLife(Set<LivingCell> currentState, List<Set<LivingCell>> history) {
        this.currentState = currentState;
        this.history = history;
    }
    
    public GameOfLife(Set<LivingCell> currentState) {
        this.currentState = currentState;
        this.history = new ArrayList<>();
    }
    
    public GameOfLife(List<Set<LivingCell>> history) {
        this.currentState = new HashSet<>();
        this.history = history;
    }
    
    public GameOfLife() {
        this.currentState = new HashSet<>();
        this.history = new ArrayList<>();
    }
    
    public void addLivingCell(int x, int y) {
        currentState.add(new LivingCell(x, y));
    }
    
    public Set<LivingCell> computeNextState() {
        Collection<Cell> allDeadNeighbors = construct8DeadNeighborsForEachLivingCell();
        
        Map<Cell, Long> deadNeighborsWithLivingNeighborsCount = groupByCount(allDeadNeighbors);
        // get them all together
        
        currentState
            .stream();
//            .map()
        
        // map (cell, livingNeighbors) => cell.computeNextState(livingNeighbors)
        // 4. filter living
        // 5. to set
        return null;
    }
    
    private Collection<Cell> construct8DeadNeighborsForEachLivingCell() {
        return null;
    }
    
    Map<Cell, Long> groupByCount(Collection<Cell> candidates) {
        return candidates
            .stream()
            .collect(groupingBy(identity(), counting()));
    }
}
