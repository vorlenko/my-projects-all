package playn.game.core;


import playn.core.Keyboard;
import playn.core.Keyboard.Event;
import playn.core.Keyboard.TypedEvent;

public class Controls implements Keyboard.Listener {

	public boolean left=false;
	public boolean right=false;
	public boolean up=false;
	public boolean upReleased=true;
	
	public Controls(){
	}
		
	public void onKeyDown(Event event) {
		
	    switch (event.key()) {
	      case LEFT:
	          left = true;
	          break;
	        case UP:
	          up = true;
	          break;
	        case RIGHT:
	          right = true;
	          break;
	    }
	}

	public void onKeyUp(Event event) {
	    switch (event.key()) {
	      case LEFT:
	          left = false;
	          Game.level.left();
	          break;
	        case UP:
	          Game.level.up();
	          up = false;
	          break;
	        case RIGHT:
	          Game.level.right();
	          right = false;
	          break;
	        case DOWN:
 	          Game.level.down();
		      right = false;
		      break;
	        case ENTER:
	          System.out.println("restart");
	          right = false;
		      break;

	    }

	}

	public void onKeyTyped(TypedEvent event) {
	}


}
