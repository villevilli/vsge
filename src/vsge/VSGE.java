package vsge;

import processing.core.PApplet;

public class VSGE {
	public static final String VERSION = "0.0.1";
	
	public static PApplet parent;
	
	Scene current_scene;
		
	public VSGE(PApplet parent) {
		VSGE.parent = parent;
		
		parent.registerMethod("dispose", this);
	}
	
	public void changeScene(Scene target_scene) {
		current_scene.stop();
		current_scene = target_scene;
		current_scene.start();
	}

	public void draw() {
		current_scene.draw();
	}

	//Method is ran when parent sketch is closed
	public void Dispose() {

	}
}
