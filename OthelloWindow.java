package othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class OthelloWindow extends JFrame{

	private JMenuBar menuBar;
	
	//The main contentPane
	private JPanel contentPane;
	
	//The board
	private OthelloBoard board;
	private OthelloBoardPanel boardPanel;
	
	

	//Our side panel for other game actions and information
	private JPanel sidePanel;
	private JLabel currentPlayerLabel;
	private JButton passButton;
	
	
	
	public OthelloWindow(OthelloBoard board){
		this.board = board;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create the menu bar
		menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setPreferredSize(new Dimension(500,20));
		setJMenuBar(menuBar);
		
		//Set the Content Pane
		contentPane = new JPanel(new BorderLayout());
		contentPane.setPreferredSize(new Dimension(600,400));
		setContentPane(contentPane);
				
		//Add the board drawing
		boardPanel = new OthelloBoardPanel(this.board);
		boardPanel.setPreferredSize(new Dimension(400,400));
		contentPane.add(boardPanel, BorderLayout.CENTER);
			
		//Add the side panel
		sidePanel = new JPanel();
		sidePanel.setPreferredSize(new Dimension(200,200));
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		contentPane.add(sidePanel, BorderLayout.EAST);
		
		//Add content to the side panel
		currentPlayerLabel = new JLabel("BLACK");
		currentPlayerLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		passButton = new JButton("Pass Turn");
		passButton.setAlignmentX(CENTER_ALIGNMENT);
			
		
		sidePanel.add(currentPlayerLabel);
		sidePanel.add(passButton);
			
	}
	
	public OthelloBoardPanel getBoardPanel() {
		return boardPanel;
	}
	
	public void changeTurn(){
		switch (currentPlayerLabel.getText()){
		case "WHITE": currentPlayerLabel.setText("BLACK"); break;
		case "BLACK": currentPlayerLabel.setText("WHITE"); break;
		default: currentPlayerLabel.setText("ERROR");
		}	
	}
	
}
