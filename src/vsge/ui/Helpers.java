package vsge.ui;

import processing.core.PApplet;

public final class Helpers {
	public static void preDraw(PApplet papplet) {
		papplet.pushMatrix();
		papplet.pushStyle();
	}
	
	public static void postDraw(PApplet papplet) {
		papplet.popMatrix();
		papplet.popStyle();
	}
}