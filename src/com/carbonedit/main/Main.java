package com.carbonedit.main;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

public class Main extends JFrame implements ActionListener {
	
	public Main() {
		JFrame frame = new JFrame("CarbonEdit");
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
