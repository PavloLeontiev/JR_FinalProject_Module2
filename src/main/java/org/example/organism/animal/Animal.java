package org.example.organism.animal;

import lombok.Getter;
import lombok.Setter;
import org.example.interfaces.DieBehavior;
import org.example.interfaces.EatBehavior;
import org.example.interfaces.MoveBehavior;
import org.example.interfaces.ReproduceBehavior;
import org.example.island.Cell;
import org.example.organism.Organism;
import org.example.unit.MoveUtil;
import org.example.unit.ReproduceUtil;

public abstract class Animal extends Organism implements EatBehavior, MoveBehavior, DieBehavior {
    @Getter
    protected double maxWeight;
    @Getter
    protected double maxSatiety;
    @Getter
    protected double currentSatiety;
    @Getter
    protected double health;
    @Getter
    protected int maxDistance;
    @Getter
    protected int maxInstance;
    @Getter
    protected Boolean isAlive;
    @Getter
    protected int currentHeirs;
    @Getter
    protected int maxHeirs;
    @Getter
    protected int currentPostBreedingStep;
    @Getter
    protected int maxPostBreedingStep;
    @Getter
    protected static String icon;
    @Getter
    protected EatBehavior eatBehavior;
    @Getter
    protected MoveBehavior moveBehavior;
    @Getter
    protected ReproduceBehavior reproduceBehavior;
    protected MoveUtil moveUtil = new MoveUtil();
    protected ReproduceUtil reproduceUtil = new ReproduceUtil();

    public Animal(double weight, double satiety, int maxDistance, int maxHeirs, int maxPostBreedingStep) {
        this.maxWeight = weight;
        this.maxSatiety = satiety;
        this.maxDistance = maxDistance;
        this.maxHeirs = maxHeirs;
        this.maxPostBreedingStep = maxPostBreedingStep;

        currentSatiety = 0.9 * maxSatiety;
        health = 100;
        isAlive = true;
    }

}
