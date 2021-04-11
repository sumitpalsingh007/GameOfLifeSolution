package in.sps_tech;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * The type Universe.
 */
class Universe {

    private final List<Cell> seeds;

    /**
     * Instantiates a new Universe.
     *
     * @param seeds the seeds
     */
    Universe(List<Cell> seeds) {
        this.seeds = seeds;
    }

    /**
     * Gets next generation.
     *
     * @return the next generation
     */
    public List<Cell> getNextGeneration() {
        List<Cell> aliveCells = new LinkedList<>(seeds);
        for (Cell seed : seeds) {
            this.unPopulate(aliveCells, seed);
        }
        for (Cell seed : seeds) {
            this.populate(aliveCells, seed);
        }
        return aliveCells;
    }

    private void unPopulate(List<Cell> aliveCells, Cell seed) {
        int activeNeighbours = 0;
        List<Cell> neighbours = seed.getNeighbours();
        activeNeighbours = neighbours.stream()
                .filter(seeds::contains)
                .collect(toList())
                .size();
        if (activeNeighbours < 2 || activeNeighbours > 3) {
            aliveCells.remove(seed);
        }
    }

    private void populate(List<Cell> aliveCells, Cell seed) {
        int activeNeighbours = 0;
        List<Cell> neighbours = seed.getNeighbours();
        for (Cell cell : neighbours) {
            List<Cell> cellNeighbour = cell.getNeighbours();
            activeNeighbours = cellNeighbour.stream()
                    .filter(seeds::contains)
                    .collect(toList())
                    .size();
            if (activeNeighbours == 3) {
                if (!aliveCells.contains(cell)) {
                    aliveCells.add(cell);
                }
            }
        }
    }
}
