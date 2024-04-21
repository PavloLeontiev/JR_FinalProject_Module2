package org.example.organism.animal.herbivory;

import org.example.interfaces.eat.HerbivoryEatBehavior;
import org.example.organism.animal.Animal;
import org.example.unit.ReproduceUtil;

public class Rabbit extends Animal {

    public Rabbit(double weight, double satiety, int maxDistance, int maxHeirs, int maxPostBreedingStep) {
        super(weight, satiety, maxDistance, maxHeirs, maxPostBreedingStep);
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
        System.out.println("Rabbit is eating");
    }

    @Override
    public void move() {
        System.out.println("Rabbit is moving");
    }

    @Override
    public void reproduce() {
        System.out.println("Rabbit was born");
        if(ReproduceUtil.isPossibleReproduce(this)){
            Rabbit rabbit = new Rabbit(this.maxWeight, this.maxSatiety, this.maxDistance, this.maxHeirs, this.maxPostBreedingStep);
            rabbit.setCell(this.getCell());
            ReproduceUtil.reproduce(rabbit);
        }
    }

    @Override
    public void die() {

    }
}
