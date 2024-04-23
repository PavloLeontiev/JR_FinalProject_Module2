package org.example.unit;

import org.example.island.Cell;
import org.example.organism.Organism;
import org.example.organism.animal.Animal;

import java.util.Comparator;
import java.util.HashMap;

public class ReproduceUtil implements Comparator<Animal> {
    private static final ThreadService threadService = ThreadService.getInstance();

    public static boolean isPossibleReproduce(Animal animal) {
        // change names of methods in if
//        if (!checkAnimalState(animal)) {
//            return false;
//        }
//        if (!checkCellState(animal)) {
//            return false;
//        }
//        // changeStateOfAnimal(animal);
        return true;
    }

    public static boolean reproduce(Organism organism) {
//        HashMap<Class<? extends Organism>, LimitedHashSet<Organism>> organisms = organism.getCell().getOrganisms();
//        organisms.get(organism.getClass()).add(organism);
        Cell cell = organism.getCell();
        cell.addOrganism(organism);
        threadService.addThread(organism);
        return true;
    }

    private static boolean checkAnimalState(Animal animal) {
        if (!animal.getIsAlive()) {
            return false;
        } else if (animal.getHealth() <= 20) {
            return false;
        } else if (animal.getCurrentHeirs() >= animal.getMaxHeirs()) {
            return false;
        } else if (animal.getCurrentPostBreedingStep() <= animal.getMaxPostBreedingStep()) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkCellState(Organism organism) {
        HashMap<Class<? extends Organism>, LimitedHashSet<Organism>> organisms = organism.getCell().getOrganisms();
        LimitedHashSet<Organism> setOrganisms = organisms.get(organism.getClass());
        int capacity = setOrganisms.getCapacity();
        int size = setOrganisms.size();
        boolean hasPartner = false;

        if (size >= capacity || size == 0) {
            return false;
        }
//        for (Organism org : setOrganisms) {
//            if (compare() != 0) {
//                hasPartner = true;
//            }
//        }
        return true;
    }

//    private static void changeStateOfAnimal(Organism organism) {
//        int reduce = 5;
//        if (organism.getCurrentSatiety() >= reduce) {
//            organism.reduceCurrentSatiety(reduce));
//        } else {
//            organism.reduceHealth(reduce);
//        }
//        organism.increaseCurrentHeirs();
//        organism.resetCurrentPostBreedingStep();
//    }

    @Override
    public int compare(Animal firstAnimal, Animal secondAnimal) {
        return Integer.compare(firstAnimal.hashCode(), secondAnimal.hashCode()); // ToDo add compare here
    }
}
