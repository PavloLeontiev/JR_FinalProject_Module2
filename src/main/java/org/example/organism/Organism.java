package org.example.organism;

import lombok.Getter;
import lombok.Setter;
import org.example.interfaces.ReproduceBehavior;
import org.example.island.Cell;

public abstract class Organism implements ReproduceBehavior, Runnable {
    @Getter
    @Setter
    protected Cell cell;
}
