package vsge;

import processing.core.PApplet;

public class World{
	public PApplet papplet;
	
	Scene current_scene;
	
	public World(PApplet papplet) {
		this.papplet = papplet;
		
		papplet.registerMethod("dispose", this);
		//papplet.registerMethod("draw", this);
	}
	
	public void changeScene(Scene target_scene) {
		if (current_scene != null) {
			current_scene.stop();
		}
		current_scene = target_scene;
		current_scene.start();
	}

	public void draw() {
		if (current_scene != null) {
			current_scene.draw();
		}
	}

	//Method is ran when parent sketch is closed
	public void dispose() {

	}

}
