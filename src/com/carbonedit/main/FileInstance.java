package com.carbonedit.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class FileInstance {
	private File currentFile;
	
	public FileInstance() {
		currentFile = null;
	}
	public FileInstance(File currentFile) {
		this.currentFile = currentFile;
	}
	
	public void save(JTextArea textArea) {
		if(currentFile == null) {
			saveAs(textArea);
		} else {
			FileWriter writer;
			try {
				if(!currentFile.getName().endsWith(".txt")) {
					writer = new FileWriter(currentFile + ".txt");
					
				} else {
					writer = new FileWriter(currentFile);
				}
				
				writer.write(textArea.getText().toString());
				
				writer.flush();
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void saveAs(JTextArea textArea) {
		JFileChooser fileChooser = new JFileChooser("f:");
		
		int option = fileChooser.showSaveDialog(null);
		
		if(option == JFileChooser.APPROVE_OPTION) {
			try {
				currentFile = fileChooser.getSelectedFile();
				FileWriter writer = new FileWriter(currentFile + ".txt");
				writer.write(textArea.getText().toString());
				
				writer.flush();
				writer.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
	public File getCurrentFile() {
		return currentFile;
	}
	public void setCurrentFile(File currentFile) {
		this.currentFile = currentFile;
	}
}
