import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {

    private int bound = Game.GRIDSIZE * Game.GRIDSIZE;

    private boolean picked = false;

    private ArrayList<Integer> mines = new ArrayList<Integer>();

    public static ArrayList<Cell> cellGrid = new ArrayList<Cell>();

    public Grid(GridLayout g, Handler h) {
        super(g);
        createCells(h);
        addCells();
    }

    public void createCells(Handler h) {
        for(int i = 1; i <= Game.MINECOUNT; i++) {
            while(!picked) {
                int minePosition = (int) (Math.random() * bound);
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            picked = false;
        }

        for(int i = 0; i < bound; i++) {
            if(mines.contains(i)) {
                cellGrid.add(new Cell(1, i, false, false, h));
            } else if(i % Game.GRIDSIZE == 0){
                if(mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - Game.GRIDSIZE + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDSIZE) ||
                        mines.contains(i + Game.GRIDSIZE + 1)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            } else if(i % Game.GRIDSIZE == Game.GRIDSIZE - 1){
                if(mines.contains(i - Game.GRIDSIZE - 1) ||
                        mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Game.GRIDSIZE - 1) ||
                        mines.contains(i + Game.GRIDSIZE)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            }else {
                if(mines.contains(i - Game.GRIDSIZE - 1) ||
                        mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - Game.GRIDSIZE + 1) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDSIZE - 1) ||
                        mines.contains(i + Game.GRIDSIZE) ||
                        mines.contains(i + Game.GRIDSIZE + 1)) {
                    cellGrid.add(new Cell(2, i, false, false, h));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, h));
                }
            }
        }
    }

    private void addCells() {
        for(int i = 0; i < cellGrid.size(); i++) {
            add(cellGrid.get(i));
        }
    }
}
