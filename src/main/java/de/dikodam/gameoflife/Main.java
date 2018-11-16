package de.dikodam.gameoflife;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();
        game.addLivingCell(0, 0);
        
        List<Cell> input = Arrays.asList(
//            new LivingCell(1, 1),
            new DeadCell(1, 0),
            new DeadCell(1, 2),
            new DeadCell(0, 0),
            new DeadCell(0, 1),
            new DeadCell(0, 2),
            new DeadCell(2, 0),
            new DeadCell(2, 1),
            new DeadCell(2, 2),
//            new LivingCell(1, 3),
            new DeadCell(1, 2),
            new DeadCell(1, 4),
            new DeadCell(0, 2),
            new DeadCell(0, 3),
            new DeadCell(0, 4),
            new DeadCell(2, 2),
            new DeadCell(2, 3),
            new DeadCell(2, 4),
//            new LivingCell(2, 2),
            new DeadCell(2, 1),
            new DeadCell(2, 3),
            new DeadCell(1, 1),
            new DeadCell(1, 2),
            new DeadCell(1, 3),
            new DeadCell(3, 1),
            new DeadCell(3, 2),
            new DeadCell(3, 3),
//            new LivingCell(3, 4),
            new DeadCell(3, 3),
            new DeadCell(3, 5),
            new DeadCell(2, 3),
            new DeadCell(2, 4),
            new DeadCell(2, 5),
            new DeadCell(4, 3),
            new DeadCell(4, 4),
            new DeadCell(4, 5)
        );
        
        Map<Cell, Long> candidates = game.groupByCount(input);
        candidates.forEach((cell, count) ->
                               System.out.println(cell.toString() + " exists " + count + " times."));
        System.out.println(candidates.get(new LivingCell(1,1)));
        System.out.println(candidates.get(new LivingCell(1,3)));
        System.out.println(candidates.get(new LivingCell(2,2)));
        System.out.println(candidates.get(new LivingCell(3,4)));
        System.out.println(candidates.get(new LivingCell(1,2)));
        System.out.println(candidates.get(new LivingCell(2,3)));
        System.out.println(candidates.get(new LivingCell(2,4)));
        
    }
    
}
