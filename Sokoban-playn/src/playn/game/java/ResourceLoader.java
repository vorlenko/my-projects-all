package playn.game.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import playn.core.Image;
import playn.core.PlayN;
import playn.game.core.Controls;
import playn.game.core.Game;
import playn.game.model.LevelsContainer;
import playn.java.JavaPlatform;

public class ResourceLoader implements ResourceChecker {

	private static HashMap<String,Image> images = new HashMap<String, Image>(){
		private static final long serialVersionUID = 1L;
		{
			put("block.png", null);
		}
	};
	
	public static LevelsContainer container = new LevelsContainer();

	private static ArrayList<String> fonts = new ArrayList<String>(){
		private static final long serialVersionUID = 3L;
		{
			add("ProggyTinySZ.ttf");
		}
	};

	public ResourceLoader(JavaPlatform platform) {
	    // fonts loading
	    for (String source:fonts) {
	    	platform.graphics().registerFont(source, source);
	    	System.out.println(source+" loaded");
	    }

	    
		// async maps loading
	    String mapsFileName="levels.json";
    	platform.assets().getText(mapsFileName, new MapsResourceCollector(container,this));
    	
	    // async images loading
		Iterator<Entry<String, Image>> imagesIterator = images.entrySet().iterator();
	    while (imagesIterator.hasNext()) {
	    	Entry <String,Image> element = imagesIterator.next();
	    	String source=element.getKey();
			Image image=platform.assets().getImage(source);
		    image.addCallback(new ImagesResourceCollector(images,source,this));
	    }

	    

	}

	@Override
	public void CheckAllResources() {

		boolean flag=true;
		
		Iterator<Entry<String, Image>> imagesIterator = images.entrySet().iterator();
	    while (imagesIterator.hasNext()) {
	    	Entry <String,Image> element = imagesIterator.next();
	    	
	    	if(element.getValue()==null){
	    		flag=false;
	    	} else if (!element.getValue().isReady()) {
	    		flag=false;
	    	}	    	
	    }

		if(container.levels==null){
			flag=false;
		}

	    if(flag){
			// if everything loaded start game
			System.out.println("starting game");
	    	Game game=new Game(new Controls(),container.levels,images);
		    PlayN.run(game);
	    }
	}

}
