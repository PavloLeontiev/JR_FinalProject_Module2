package org.example.organism.animal.predator;

import org.example.interfaces.eat.PredationEatBehavior;
import org.example.organism.animal.Animal;
import org.example.organism.animal.herbivory.Rabbit;
import org.example.unit.ReproduceUtil;

public class Wolf extends Animal {

    public Wolf(double weight, double satiety, int maxDistance, int maxHeirs, int maxPostBreedingStep) {
        super(weight, satiety, maxDistance, maxHeirs, maxPostBreedingStep);
        eatBehavior = new PredationEatBehavior();
        icon = "\uD83D\uDC3A";
    }

    @Override
    public void run() {
        move();
        reproduce();
        eat();
    }

    @Override
    public void eat() {
        System.out.println("Wolf is eating");
    }

    @Override
    public void move() {
        System.out.println("Wolf is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("Wolf was born");
        if(ReproduceUtil.isPossibleReproduce(this)){
            Wolf wolf = new Wolf(this.maxWeight, this.maxSatiety, this.maxDistance, this.maxHeirs, this.maxPostBreedingStep);
            wolf.setCell(this.getCell());
            ReproduceUtil.reproduce(wolf);
        }
    }

    @Override
    public void die() {

    }
}
