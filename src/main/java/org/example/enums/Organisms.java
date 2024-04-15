package org.example.enums;

import org.example.organism.Organism;
import org.example.organism.animal.herbivory.Rabbit;
import org.example.organism.animal.predator.Bear;
import org.example.organism.animal.predator.Wolf;

public enum Organisms {
    BEAR(new Bear(150, 42.2, 2, 3, 3, 3)),
    RABBIT(new Rabbit(2, 0.4, 2, 10, 3, 3)),
    WOLF(new Wolf(50, 2, 3, 6, 3, 3));

    private Organism organism;
    Organisms(Organism organism){
        this.organism = organism;
    }

    public Organism getAnimal(){ return organism;}
}
