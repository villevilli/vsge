package vsge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import processing.core.*;
import vsge.ui.*;

public class DialogScene implements Scene{
	public World parent;
	
	public Scene nextScene;
	
	private ArrayList<Dialog> dialogList; 
	private int dialogIndex;
	
	private DialogTextBox textBox;
	
	public DialogScene(World parent, BufferedReader dialogString, Scene nextScene) {
		this(parent, dialogString);
		
		this.nextScene = nextScene;
		
	}
	
	public DialogScene(World parent, BufferedReader dialogString) {
		this(parent, dialogString, 0);

	}
	/*
	public DialogScene(World parent, BufferedReader fileInput) throws Exception {
		System.out.println(fileInput);
		//	this(parent, fileInput.toString());
	}
	*/
	public DialogScene(World parent, BufferedReader dialogFile, int dialogIndex) {
		this.dialogIndex = dialogIndex;
		this.parent = parent;
		dialogList = new ArrayList<Dialog>();
		
		/*
		List<String> dialogStringLines = dialogString.lines().toList();
		
		if (dialogString.length() < 1) throw new Exception("String Input Needs Text");
		*/
		int i = 0;
		
		String line = null;
		try {
			line = dialogFile.readLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		while (line != null) {
			i++;
			String[] parts = line.split(";;");
		
			
			
			if (parts.length != 2)  System.err.println("Line: %s has an incorrect number of seperators".formatted(i));
						
			dialogList.add(new Dialog(parts[0], parts[1]));
			
			try {
				line = dialogFile.readLine();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		
		try {
			textBox = new DialogTextBox(parent.papplet, dialogList.get(dialogIndex));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void start() {
		
	}
	
	public void DialogIndex(int dialogIndex) {
		this.dialogIndex = dialogIndex;
		
		textBox.changeDialog(dialogList.get(dialogIndex));
	}
	
	public int DialogIndex() {
		return (dialogIndex);
	}
	
	public void nextDialog() {
		if (dialogIndex+1 < dialogList.size() ) {
			DialogIndex(dialogIndex += 1);			
		} else if (nextScene != null) {
			parent.changeScene(nextScene);
		}
	}
	
	@Override
	public void draw() {	
		Helpers.preDraw(parent.papplet);

		textBox.draw();
		
		Helpers.postDraw(parent.papplet);
	}
	
	

	@Override
	public void stop() {
		
	}
}
