package com.carbonedit.main;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

public class Editor extends JFrame implements ActionListener {
	JFrame frame;
	public Editor() {
		frame = new JFrame("CarbonEdit");
		JTextArea textArea = new JTextArea();
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem newFileMenuItem = new JMenuItem("New");
		JMenuItem editFileMenuItem = new JMenuItem("Edit");
		JMenuItem openFileMenuItem = new JMenuItem("Open");
		JMenuItem saveFileMenuItem = new JMenuItem("Save");
		JMenuItem saveAsFileMenuItem = new JMenuItem("Save As");
		
		fileMenu.add(newFileMenuItem);
		fileMenu.add(editFileMenuItem);
		fileMenu.add(openFileMenuItem);
		fileMenu.add(saveFileMenuItem);
		fileMenu.add(saveAsFileMenuItem);
		
		JMenu editMenu = new JMenu("Edit");
		
		JMenuItem cutEditMenuItem = new JMenuItem("Cut");
		JMenuItem copyEditMenuItem = new JMenuItem("Copy");
		JMenuItem pasteEditMenuItem = new JMenuItem("Paste");
		
		editMenu.add(cutEditMenuItem);
		editMenu.add(copyEditMenuItem);
		editMenu.add(pasteEditMenuItem);
		
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
		}
	}
	public static void main(String args[]) {
		Editor editor = new Editor();
	}
}
