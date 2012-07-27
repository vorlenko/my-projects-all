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
	          Game.level.left(true);
	          break;
	        case UP:
	          Game.level.up(true);
	          up = false;
	          break;
	        case RIGHT:
	          Game.level.right(true);
	          right = false;
	          break;
	        case DOWN:
 	          Game.level.down(true);
		      right = false;
		      break;
	        case ENTER:
	          Game.level.restore();
	          right = false;
		      break;
	        case A:
		      Game.prevoiusLevel();
		      right = false;
			  break;
	        case D:
		      Game.nextLevel();
		      right = false;
			  break;
	        case ESCAPE:
		      Game.saveAndExit();
		      right = false;
			  break;
	        case BACKSPACE:
		      Game.back();
		      right = false;
			  break;
	    }
	}

	public void onKeyTyped(TypedEvent event) {
	}


}
