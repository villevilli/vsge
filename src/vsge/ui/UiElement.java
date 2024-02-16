package vsge.ui;

import processing.core.PApplet;

abstract class UiElement {
	public PApplet papplet;
	
	public UiElement(PApplet papplet) {
		this.papplet = papplet;
	}
	
	public abstract void draw() ;

}
