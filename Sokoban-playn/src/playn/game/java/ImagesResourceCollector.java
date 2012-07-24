package playn.game.java;

import java.util.HashMap;

import playn.core.Image;
import playn.core.ResourceCallback;

public class ImagesResourceCollector implements ResourceCallback<Image>{
	private HashMap<String,Image> images;
	private String currentKey;
	private ResourceChecker checker;
	
	public ImagesResourceCollector(HashMap<String,Image> images,String currentKey, ResourceChecker checker){
		this.images=images;
		this.currentKey=currentKey;
		this.checker=checker;
	}
	
	public void done(Image resource) {
		System.out.println(currentKey+" loaded");
		images.put(currentKey, resource);
		checker.CheckAllResources();
	}

	@Override
	public void error(Throwable err) {
		System.out.println(err.getMessage());
	}
	
}
