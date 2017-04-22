
package pacman;//
//Source code recreated from a .class file by IntelliJ IDEA
//(powered by Fernflower decompiler)
//

import pacman.Odczytplanszy;

public class Game {
 private Odczytplanszy odczyt;
 public int width;
 public int height;

 public Game(String title, int width, int height) {
     this.width = width;
     this.height = height;
     this.odczyt = new Odczytplanszy();
 }
}