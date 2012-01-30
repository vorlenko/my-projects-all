package game;

import com.badlogic.gdx.backends.jogl.JoglApplication;
import game.Game;

public class GameDesktop {
	 public static void main (String[] argv) {
         new JoglApplication(new Game(), "Arkanoid", 480, 320, false);               
	 }
}
