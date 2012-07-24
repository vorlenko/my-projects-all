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
	          break;
	        case UP:
	          up = false;
	          break;
	        case RIGHT:
	          right = false;
	          break;
	    }

	}

	public void onKeyTyped(TypedEvent event) {
	}


}
