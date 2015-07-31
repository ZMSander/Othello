package othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class OthelloGUI {

	//The main frame
	private JFrame frame;
	
	private JMenuBar menuBar;
	
	//The main contentPane
	private JPanel contentPane;
	
	//Our game board
	private JPanel boardPanel;
	
	//Our side panel for other game actions and information
	private JPanel sidePanel;
	
	public OthelloGUI(){
		createAndShowGUI();
	}

	private void createAndShowGUI(){
		frame = new JFrame("Othello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create the menu bar
		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setPreferredSize(new Dimension(500,20));
		frame.setJMenuBar(menuBar);
		
		//Set the Content Pane
		contentPane = new JPanel(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(600,400));
		frame.setContentPane(contentPane);
		
		//Add the board drawing
		boardPanel = new OthelloBoardDrawPanel();
		boardPanel.setPreferredSize(new Dimension(400,400));
		contentPane.add(boardPanel, BorderLayout.CENTER);
		
		//Add the side panel
		sidePanel = new JPanel();
		sidePanel.setPreferredSize(new Dimension(200,200));
		contentPane.add(sidePanel, BorderLayout.EAST);
		
		//Display
		frame.pack();
		frame.setVisible(true);
	}
	
}
