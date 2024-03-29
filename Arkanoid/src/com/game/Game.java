package com.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Game implements ApplicationListener {

	private OrthographicCamera camera;
	private TextureRegion region;
	private SpriteBatch batch;
	private Pixmap pixmap;
	private Texture texture;
	private FPSLogger fps = new FPSLogger();
	private Controls controls = new Controls();
	
	public void create() {
		batch=new SpriteBatch();
		Gdx.input.setInputProcessor(controls);
		
	}

	float x=0;
	public void render() {
		GL10 gl = Gdx.graphics.getGL10();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		camera.update();
        background.onUpdate(1);
        camera.apply(gl);

        pixmap.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        pixmap.fillRectangle(0, 0, width,height);
		
		float t=Gdx.graphics.getDeltaTime();
		x=x+t*300;
		if(x>300){x=0;};

		background.onDraw(pixmap);
		
		platform.setX(controls.getX()-width/2);
		platform.onDraw(pixmap);
		
        pixmap.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        pixmap.drawRectangle(10, 10, width-20,height+20);
        pixmap.drawRectangle(12, 12, width-24,height+24);

        pixmap.fillRectangle((int) x, (int) x, 10,10);


        batch.begin();
        texture.draw(pixmap, 0, 0);
        batch.draw (region, 0, 0);
        batch.end();

        
		fps.log();
	}

	Background background;
	Platform platform;
	private int width;
	private int height;
	public void resize(int width, int height) {
		Gdx.app.log("resize", "w="+width+" h="+height);
		this.width=width;
		this.height=height;
        pixmap=new Pixmap(powerOf2(width),powerOf2(height), Pixmap.Format.RGBA8888);
        texture = new Texture(pixmap);
		region = new TextureRegion(texture, 0, 0, width, height);
		camera = new OrthographicCamera(width, height);
		camera.position.set(width/2,height/2, 0);
		
		background = new Background(width,height);
		platform = new Platform(width,height);
	}

	public int powerOf2(int size){
		int p=1;
		while(p<size){
			p=p*2;
		}
		return(p);
	}
	
	public void resume() {}
	public void dispose() {}
	public void pause() {}
}
