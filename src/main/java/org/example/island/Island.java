package org.example.island;

public class Island {
    private static Island island;
    private Cell[][] cells;

    private Island() {
    }

    public static Island getInstance() {
        if(island == null) {
            island = new Island();
        }
        return island;
    }

    public void setCells(Cell[][] cells) {
        if(this.cells == null) {
            this.cells = cells;
        } else {
            System.out.println("Cells is already set");
        }
    }
}
