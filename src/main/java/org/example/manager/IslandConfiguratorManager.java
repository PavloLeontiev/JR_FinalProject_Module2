package org.example.manager;

import org.example.enums.Organisms;
import org.example.island.Cell;
import org.example.island.Island;
import org.example.organism.Organism;
import org.example.unit.DeepCopyUtil;
import org.example.unit.LimitedHashSet;

import java.util.HashMap;
import java.util.Random;

public class IslandConfiguratorManager {
    private static IslandConfiguratorManager islandConfigurator;

    private final int width = 1;
    private final int height = 1;
    private final Cell[][] cells = new Cell[width][height];
    private final HashMap<Class<? extends Organism>, LimitedHashSet<Organism>> templateOrganisms = new HashMap<>();
    private final Random random = new Random();

    private IslandConfiguratorManager() {
    }

    public static IslandConfiguratorManager getInstance() {
        if (islandConfigurator == null) {
            islandConfigurator = new IslandConfiguratorManager();
        }
        return islandConfigurator;
    }

    public void configure() {

        configTemplateOrganisms();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                HashMap<Class<? extends Organism>, LimitedHashSet<Organism>> copyOrganisms =
                        DeepCopyUtil.deepCloneHashMap(templateOrganisms);
                cells[i][j] = new Cell(i, j);
                cells[i][j] .setOrganisms(copyOrganisms);
                fillOrganismCard(cells[i][j]);
            }
        }
        Island.getInstance().setCells(cells);
    }

    private void configTemplateOrganisms() {
        for (Organisms organism : Organisms.values()) {
            templateOrganisms.put(organism.getOrganism().getClass(), new LimitedHashSet<Organism>(organism.getMaxInstance()));
        }
    }

    private void fillOrganismCard(Cell cell) {
        HashMap<Class<? extends Organism>, LimitedHashSet<Organism>> organisms = cell.getOrganisms();
        for (Organisms organism : Organisms.values()) {
            for (int i = 0; i < random.nextInt(organism.getMaxInstance()); i++) {
                Organism instance = organism.getOrganism();
                instance.setCell(cell);
                instance.reproduce();
            }
        }
    }
}
