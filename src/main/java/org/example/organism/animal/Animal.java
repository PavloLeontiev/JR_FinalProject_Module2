package org.example.organism.animal;

import lombok.Getter;
import org.example.interfaces.DieBehavior;
import org.example.interfaces.EatBehavior;
import org.example.interfaces.MoveBehavior;
import org.example.organism.Organism;

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
    protected boolean isAlive;
    @Getter
    protected int xCellPosition;
    @Getter
    protected int yCellPosition;
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
//    protected ReproduceBehavior reproduceBehavior;
//    protected UtilMove utilMove = new UtilMove();
//    protected UtilReproduce utilReproduce = new UtilReproduce();

    public Animal(double weight, double satiety, int maxDistance, int maxInstance, int maxHeirs, int maxPostBreedingStep) {
        this.maxWeight = weight;
        this.maxSatiety = satiety;
        this.maxDistance = maxDistance;
        this.maxInstance = maxInstance;
        this.maxHeirs = maxHeirs;
        this.maxPostBreedingStep = maxPostBreedingStep;

        currentSatiety = 0.9 * maxSatiety;
        health = 100;
        isAlive = true;
    }

    public void setCell(int xCellPosition, int yCellPosition) {
        this.xCellPosition = xCellPosition;
        this.yCellPosition = yCellPosition;
    }
}
