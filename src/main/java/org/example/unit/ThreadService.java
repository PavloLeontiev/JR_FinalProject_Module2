package org.example.unit;

import java.util.HashSet;

public class ThreadService {
    private static ThreadService threadService;
    private final HashSet<Runnable> animalThreads = new HashSet<>();

    private ThreadService() {}

    public static ThreadService getInstance() {
        if(threadService == null) {
            threadService = new ThreadService();
        }
        return threadService;
    }

    public void addThread(Runnable animal){
        if(animal instanceof Runnable){
            animalThreads.add(animal);
        }
    }

    public void removeThread(Runnable animal){
        if(animal instanceof Runnable && animalThreads.contains(animal)){
            animalThreads.remove(animal);
        }
    }

    public HashSet<Runnable> getAnimalThreads(){
        return animalThreads;
    }
}
