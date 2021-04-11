package in.sps_tech;

import java.util.LinkedList;
import java.util.List;

/**
 * The main class to launch the game.
 */
class GameLauncher {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        List<Cell> seeds = new LinkedList<>();
        seeds.add(new Cell(1, 1));
        seeds.add(new Cell(1, 2));
        seeds.add(new Cell(1, 3));
        seeds.add(new Cell(2, 2));
        seeds.add(new Cell(2, 3));
        seeds.add(new Cell(2, 4));
        Universe universe = new Universe(seeds);
        List<Cell> nextgeneration = universe.getNextGeneration();
        nextgeneration.forEach(System.out::println);
        System.out.println("======================================");

        seeds = new LinkedList<>();
        seeds.add(new Cell(0, 1));
        seeds.add(new Cell(1, 0));
        seeds.add(new Cell(2, 1));
        seeds.add(new Cell(2, 2));
        universe = new Universe(seeds);
        nextgeneration = universe.getNextGeneration();
        nextgeneration.forEach(System.out::println);
        System.out.println("======================================");

        seeds = new LinkedList<>();
        seeds.add(new Cell(0, 1));
        seeds.add(new Cell(1, 0));
        seeds.add(new Cell(2, 1));
        seeds.add(new Cell(0, 2));
        seeds.add(new Cell(1, 2));
        universe = new Universe(seeds);
        nextgeneration = universe.getNextGeneration();
        nextgeneration.forEach(System.out::println);
        System.out.println("======================================");

        seeds = new LinkedList<>();
        seeds.add(new Cell(1, 1));
        seeds.add(new Cell(1, 0));
        seeds.add(new Cell(1, 2));
        universe = new Universe(seeds);
        nextgeneration = universe.getNextGeneration();
        nextgeneration.forEach(System.out::println);
    }
}
