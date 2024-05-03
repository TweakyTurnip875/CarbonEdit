package com.carbonedit.main;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;
import java.util.List;

public class Editor extends JFrame implements ActionListener {
	private JFrame frame;
	private JTextArea textArea;
	private File currentFile = null;
	public Editor() {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		frame = new JFrame("CarbonEdit");
		textArea = new JTextArea();
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem newFileMenuItem = new JMenuItem("New");
		JMenuItem openFileMenuItem = new JMenuItem("Open");
		JMenuItem saveFileMenuItem = new JMenuItem("Save");
		JMenuItem saveAsFileMenuItem = new JMenuItem("Save As");
		
		fileMenu.add(newFileMenuItem);
		fileMenu.add(openFileMenuItem);
		fileMenu.add(saveFileMenuItem);
		fileMenu.add(saveAsFileMenuItem);
		
		newFileMenuItem.addActionListener(this);
		openFileMenuItem.addActionListener(this);
		saveFileMenuItem.addActionListener(this);
		
		JMenu editMenu = new JMenu("Edit");
		
		JMenuItem cutEditMenuItem = new JMenuItem("Cut");
		JMenuItem copyEditMenuItem = new JMenuItem("Copy");
		JMenuItem pasteEditMenuItem = new JMenuItem("Paste");
		
		editMenu.add(cutEditMenuItem);
		editMenu.add(copyEditMenuItem);
		editMenu.add(pasteEditMenuItem);
		
		cutEditMenuItem.addActionListener(this);
		copyEditMenuItem.addActionListener(this);
		pasteEditMenuItem.addActionListener(this);
		
		JMenuItem closeMenuItem = new JMenuItem("Close");
		
		closeMenuItem.addActionListener(this);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(closeMenuItem);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		frame.add(textArea);
		frame.setSize(500,500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equalsIgnoreCase("Close")) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		} else if(command.equalsIgnoreCase("New")) {
			textArea.setText("");
		} else if(command.equalsIgnoreCase("Cut")) {
			textArea.cut();
		} else if(command.equalsIgnoreCase("Copy")) {
			textArea.copy();
		} else if(command.equalsIgnoreCase("Paste")) {
			textArea.paste();
		} else if(command.equalsIgnoreCase("Open")) {
			JFileChooser fileChooser = new JFileChooser("f:");
			
			int option = fileChooser.showOpenDialog(null);
			
			if(option == JFileChooser.APPROVE_OPTION) {
				currentFile = fileChooser.getSelectedFile();
				Path filePath = Paths.get(currentFile.getAbsolutePath());
				
				String content = "";
				try {
					List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
					
					for(String line : lines) {
						content += (line + "\n");
					}
					
					textArea.setText(content);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if(command.equalsIgnoreCase("Save")) {
			if(currentFile == null) {
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			
		}
	}
	public static void main(String args[]) {
		Editor editor = new Editor();
	}
}
