package pacman;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import pacman.Display;

public class Game {
    private Display display;
    public int width;
    public int height;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.display = new Display(title, width, height);
    }
}
