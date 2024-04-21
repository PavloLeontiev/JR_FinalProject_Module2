package org.example.enums;

import lombok.Getter;
import org.example.organism.Organism;
import org.example.organism.animal.herbivory.Rabbit;
import org.example.organism.animal.predator.Bear;
import org.example.organism.animal.predator.Wolf;

public enum Organisms {
    BEAR(new Bear(150, 42.2, 2, 3, 3),3),
    RABBIT(new Rabbit(2, 0.4, 2, 3, 3),10),
    WOLF(new Wolf(50, 2, 3, 3, 3), 6);
    @Getter
    private final Organism organism;
    @Getter
    private final int maxInstance;

    Organisms(Organism organism, int maxInstance){
        this.organism = organism;
        this.maxInstance = maxInstance;
    }
}
