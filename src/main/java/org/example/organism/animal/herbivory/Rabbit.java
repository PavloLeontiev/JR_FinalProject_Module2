package org.example.organism.animal.herbivory;

import org.example.interfaces.eat.HerbivoryEatBehavior;
import org.example.organism.animal.Animal;

public class Rabbit extends Animal {

    public Rabbit(double weight, double satiety, int maxDistance, int maxInstance, int maxHeirs, int maxPostBreedingStep) {
        super(weight, satiety, maxDistance, maxInstance, maxHeirs, maxPostBreedingStep);
        eatBehavior = new HerbivoryEatBehavior();
        icon = "\uD83D\uDC07";
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

    }

    @Override
    public void reproduce() {

    }

    @Override
    public void die() {

    }
}
