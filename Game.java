public class Game {

    public static final int WIDTH = 720, HEIGHT = 720;
    public static final int GRIDSIZE = 15;
    public static final int MINECOUNT = (int) Math.round(GRIDSIZE * GRIDSIZE * .1);

    private Handler handler = new Handler();

    public Game() {
        new Window(WIDTH, HEIGHT, GRIDSIZE, "Minesweeper - ", this, handler);
        Window.update(0);
    }

    public static void main(String[] args) {
        new Game();
    }

}
