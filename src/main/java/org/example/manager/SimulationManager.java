package org.example.manager;

import org.example.island.Island;
import org.example.unit.ThreadService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationManager {
    private final Island island = Island.getInstance();
    private final IslandConfiguratorManager islandConfig = IslandConfiguratorManager.getInstance();
    private final ThreadService threadService = ThreadService.getInstance();

    private final ScheduledExecutorService plantGrowthSchedule = Executors.newScheduledThreadPool(1);
    private final ScheduledExecutorService animalLifeCycleSchedule = Executors.newScheduledThreadPool(3);
    private final ScheduledExecutorService statisticalOutputSchedule = Executors.newScheduledThreadPool(1);

    private final int period = 2;
    private final TimeUnit periodTimeUnit = TimeUnit.SECONDS;
    private int counter;

    public void startSimulation(){
        islandConfig.configure();
        System.out.println("Simulation is started");
        // startPlantGrowthSchedule();
        startAnimalLifeCycleSchedule();
    }

    private void startPlantGrowthSchedule() {
        // ToDo Add plants and add logic of growing
    }

    private void startAnimalLifeCycleSchedule() {
        Runnable animalLifeCycleTask = () -> {
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (Runnable runnable : threadService.getAnimalThreads()) {
                executor.execute(runnable);
            }
            startStatisticalOutputSchedule(); // ToDo full startStatisticalOutputSchedule
            if(++counter > 2) {
                stopSimulation();
            }
        };
        animalLifeCycleSchedule.scheduleAtFixedRate(animalLifeCycleTask, 0, period, periodTimeUnit);
    }

    private void startStatisticalOutputSchedule() {
        System.out.println("\n\n New step \n\n");
    }

    private void stopSimulation() {
        plantGrowthSchedule.shutdownNow();
        animalLifeCycleSchedule.shutdownNow();
        statisticalOutputSchedule.shutdownNow();
        System.out.println("\n\nSimulation is stopped\n");
    }
}
