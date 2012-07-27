package playn.game.java;

import playn.java.JavaPlatform;

public class Loader {
	
	
	
	public static void main(String[] args) throws Exception {

		JavaPlatform platform = JavaPlatform.register();
	    platform.graphics().setSize(640, 480);
	    platform.assets().setPathPrefix("playn/game/resources");
	    
	    new ResourceLoader(platform);
	}
}
