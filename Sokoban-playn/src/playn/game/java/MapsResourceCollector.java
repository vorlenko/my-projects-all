package playn.game.java;

import com.google.gson.Gson;

import playn.game.model.LevelsContainer;
import playn.core.ResourceCallback;

public class MapsResourceCollector implements ResourceCallback<String>{
	private ResourceChecker checker;
	private LevelsContainer container;
	
	public MapsResourceCollector(LevelsContainer container, ResourceChecker checker){
		this.checker=checker;
		this.container=container;
	}
	 

	@Override
	public void done(String data) {
		Gson gson=new Gson();
		
		LevelsContainer container=gson.fromJson(data, LevelsContainer.class);
		
		this.container.levels=container.levels;
		
		
		checker.CheckAllResources();
	}

	@Override
	public void error(Throwable err) {
        System.out.println("error loading levels:"+err.getLocalizedMessage());
	}
	
}
