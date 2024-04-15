package org.example.organism.animal.predator;

import org.example.interfaces.eat.PredationEatBehavior;
import org.example.organism.animal.Animal;

public class Wolf extends Animal {

    public Wolf(double weight, double satiety, int maxDistance, int maxInstance, int maxHeirs, int maxPostBreedingStep) {
        super(weight, satiety, maxDistance, maxInstance, maxHeirs, maxPostBreedingStep);
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

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void die() {

    }
}
