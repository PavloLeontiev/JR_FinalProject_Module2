package org.example.island;

import lombok.Getter;
import lombok.Setter;
import org.example.organism.Organism;
import org.example.unit.LimitedHashSet;

import java.util.HashMap;
import java.util.HashSet;

public class Cell {
    @Getter
    @Setter
    private HashMap<Class<? extends Organism>, LimitedHashSet<Organism>> organisms;
    @Getter
    private int width;
    @Getter
    private int height;

    public Cell(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // public synchronized void removeOrganism(Organism org){
    //     if(organisms.contains(org)){
    //         organisms.remove(org);
    //     }
    // }

     public void addOrganism(Organism org){
         if(!organisms.get(org.getClass()).contains(org)){
             organisms.get(org.getClass()).add(org);
         } else {
             try {
                 throw new Exception("Organism is already in this cell");
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }
         }
     }
}
