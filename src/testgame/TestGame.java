package testgame;

import processing.core.PApplet;
import java.io.File;
import java.io.FileInputStream;

import vsge.*;


public class TestGame extends PApplet {	
	World world;
	DialogScene mainScene;
	
	public static void main(String[] args) {
		PApplet.main("testgame.TestGame");
	}
	
	@Override
	public void settings() {
		size(800,600);
	}
	
	@Override
	public void setup() {
		world = new World(this);
		try {
			mainScene = new DialogScene(world, createReader("story1.txt"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		world.changeScene(mainScene);
	}
	
	@Override
	public void mousePressed() {
		mainScene.nextDialog();
	}
	
	@Override
	public void draw() {
		background(255);
		world.draw();
	}
	
}
