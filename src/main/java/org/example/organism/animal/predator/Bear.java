package org.example.organism.animal.predator;

import org.example.interfaces.eat.PredationEatBehavior;
import org.example.organism.animal.Animal;
import org.example.organism.animal.herbivory.Rabbit;
import org.example.unit.ReproduceUtil;

public class Bear extends Animal {

    public Bear(double weight, double satiety, int maxDistance, int maxHeirs, int maxPostBreedingStep) {
        super(weight, satiety, maxDistance, maxHeirs, maxPostBreedingStep);
        eatBehavior = new PredationEatBehavior();
        icon = "\uD83D\uDC3B";
    }

    @Override
    public void run() {
        move();
        reproduce();
        eat();
    }

    @Override
    public void eat() {
        System.out.println("Bear is eating");
    }

    @Override
    public void move() {
        System.out.println("Bear is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("Bear was born");
        if(ReproduceUtil.isPossibleReproduce(this)){
            Bear bear = new Bear(this.maxWeight, this.maxSatiety, this.maxDistance, this.maxHeirs, this.maxPostBreedingStep);
            bear.setCell(this.getCell());
            ReproduceUtil.reproduce(bear);
        }
    }

    @Override
    public void die() {

    }
}
