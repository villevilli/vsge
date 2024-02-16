package vsge.ui;

import java.util.ArrayList;

import processing.core.*;
import vsge.Dialog;

public class DialogTextBox extends UiElement{
	
	public float dialogBoxHeight = 200;
	public int textSize = 24;
	public int currentRow = 0;
	public int margin = 30;
	public int nameSize = 28;
	
	private int currentDialogIndex = 0;
	private Dialog currentDialog;
	
	public DialogTextBox(PApplet papplet, Dialog dialog) throws Exception {
		super(papplet);
		
		currentDialog = dialog;
	}
	
	public void draw() {
		Helpers.preDraw(papplet);
		papplet.resetMatrix();
				
		papplet.fill(0);
		papplet.stroke(32,98,128,(float) 0.87);
		
		papplet.rect(0,papplet.height - dialogBoxHeight,papplet.width, dialogBoxHeight, 0);
		
		writeLines(currentDialog.dialog(), currentRow);
		
		papplet.fill(255);
		papplet.stroke(255);
		
		papplet.text(currentDialog.name() + " :", 8, papplet.height + textSize - dialogBoxHeight + 8);
		
		Helpers.postDraw(papplet);
	}
		
	public void changeDialog(Dialog dialog) {
		currentDialog = dialog;
	}
	
	private void writeLines(String text, int startLine) {
		Helpers.preDraw(papplet);
		
		papplet.rect(10, 10, 10, 10);
		
		papplet.textSize(textSize);
		papplet.fill(255);
		papplet.stroke(255);
		
		String[] words = text.split(" ");
		
		int currentLine = 0;
		int i = 0;
				
		while (lineY(currentLine) < papplet.height-margin) {
			String lineText = new String();

			try {
				while (papplet.textWidth(lineText + words[i] + " ") < papplet.width - (2*margin) && i < words.length) {
					lineText += words[i] + " ";
					i++;
				}
			} catch (ArrayIndexOutOfBoundsException e){}
			writeLine(lineText , currentLine);
			currentLine++;
		}

		Helpers.postDraw(papplet);

	}
	
	private float lineY(int lineNumber) {
		return ((papplet.height -dialogBoxHeight + margin) + ((lineNumber*textSize)) + nameSize + 8);
	}
	
	private void writeLine(String line, int lineNumber) {
		
		papplet.text(line, margin, lineY(lineNumber));
	}

}