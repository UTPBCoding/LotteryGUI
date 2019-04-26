/**
 * Luke Hagerdon
 * 
 * COSC-2430.501 - Dr. Vuckovic
 * 
 * Project 2 - Number Of Letters
 * 
 * 2 April, 2019
 * 
 * This program will give you a randomly generated array of 5 numbers on a GUI
 * and you will try to guess what those number will be to win a monetary prize.
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



@SuppressWarnings("serial")
public class lotteryNumbers extends JFrame implements ActionListener{
	
	// Variables
	
	private static final int WIDTH = 800;
	private static final int  HEIGHT = 600;
	private static final int CHARS_PER_LINE = 1;
	
	private static int[] lottoInt = new int[5];
	private static int[] userInput = new int[5];
	private static int total = 0;
	
	private static JTextField AI_1, AI_2, AI_3, AI_4, AI_5;
	private static JTextField user_1, user_2, user_3, user_4, user_5;
	private static JTextField matches;
	private static JTextField prize;
	private static Container contentPane;
	
	public lotteryNumbers() {
		
		// JFrame Structure
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		addWindowListener(new WindowDestroyer());
		setTitle("Lottery Numbers");
		contentPane = getContentPane();
		contentPane.setLayout(null);
		
		// Methods in constructor 
		createAIArray();
		userLayout();
		AILayout();
		numOfMatches();
		prize();
		buttons();
		
		
	}
	
	public static void main(String[] args) {
		lotteryNumbers lotteryGUI = new lotteryNumbers();
		lotteryGUI.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		try {
			
			// If Play button is pressed, it will calculate how many numbers are correct from the input
			// and display the reward
			if(actionCommand.equals("Play")) {
				userInput[0] = Integer.parseInt(user_1.getText());
				userInput[1] = Integer.parseInt(user_2.getText());
				userInput[2] = Integer.parseInt(user_3.getText());
				userInput[3] = Integer.parseInt(user_4.getText());
				userInput[4] = Integer.parseInt(user_5.getText());
				
				switch(compareArrays()) {
					case 0: 
						matches.setText("0");
						prize.setText("Sorry, no prize!");
						break;
					case 1: 
						matches.setText("1");
						prize.setText("$2");
						break;
					case 2:
						matches.setText("2");
						prize.setText("$5");
						break;
					case 3: 
						matches.setText("3");
						prize.setText("$10");
						break;
					case 4:
						matches.setText("4");
						prize.setText("$5,000");
						break;
					case 5: 
						matches.setText("5");
						prize.setText("$50,000");
						break;
					default: 
						break;
				}
				
			// When Reset button is pressed, it resets everything all fields
			} else if(actionCommand.equals("Reset")) {
				total = 0;
				
				user_1.setText("");
				user_2.setText("");
				user_3.setText("");
				user_4.setText("");
				user_5.setText("");
				
				AI_1.setText("");
				AI_2.setText("");
				AI_3.setText("");
				AI_4.setText("");
				AI_5.setText("");
				
				matches.setText("");
				
				prize.setText("");
			}
		} catch(RuntimeException e1) {
			System.out.println("Problem in action performed.");
		}
	}
	
	public static void userLayout() {
		JPanel userText = new JPanel();
		
		// First Label
		
		JLabel userLabel = new JLabel("User's Lottery Numbers:");
		
		userText.add(userLabel);
		userText.setBounds(50, 40, 160, 30);
		contentPane.add(userText);
		
		// User's Input
		
		JPanel userPanel = new JPanel();
		
		user_1 = new JTextField(CHARS_PER_LINE);
		user_2 = new JTextField(CHARS_PER_LINE);
		user_3 = new JTextField(CHARS_PER_LINE);
		user_4 = new JTextField(CHARS_PER_LINE);
		user_5 = new JTextField(CHARS_PER_LINE);
		
		// Ensures the user  is not inputing anything but a number and limits the amount of input to 1 character
		user_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_1.getText().length() >= 1 || e.getKeyChar() < '0' || e.getKeyChar() > '9')
					e.consume();
				else
					user_2.requestFocus();
			}
		});
		
		user_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_2.getText().length() >= 1 || e.getKeyChar() < '0' || e.getKeyChar() > '9')
					e.consume();
				else
					user_3.requestFocus();
			}
		});
		
		user_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_3.getText().length() >= 1 || e.getKeyChar() < '0' || e.getKeyChar() > '9')
					e.consume();
				else
					user_4.requestFocus();
			}
		});
		
		user_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_4.getText().length() >= 1 || e.getKeyChar() < '0' || e.getKeyChar() > '9')
					e.consume();
				else
					user_5.requestFocus();
			}
		});
		
		user_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_5.getText().length() >= 1 || e.getKeyChar() < '0' || e.getKeyChar() > '9')
					e.consume();
			}
		});
		
		// Sets a margin on the text field
		user_1.setMargin(new Insets(10,10,10,10));
		user_2.setMargin(new Insets(10,10,10,10));
		user_3.setMargin(new Insets(10,10,10,10));
		user_4.setMargin(new Insets(10,10,10,10));
		user_5.setMargin(new Insets(10,10,10,10));
		
		// Changes the font in the text field
		user_1.setFont(user_1.getFont().deriveFont(14f));
		user_2.setFont(user_2.getFont().deriveFont(14f));
		user_3.setFont(user_3.getFont().deriveFont(14f));
		user_4.setFont(user_4.getFont().deriveFont(14f));
		user_5.setFont(user_5.getFont().deriveFont(14f));
		
		// Adds the textField to the panel
		userPanel.add(user_1);
		userPanel.add(user_2);
		userPanel.add(user_3);
		userPanel.add(user_4);
		userPanel.add(user_5);
		
		// Positions panel
		userPanel.setBounds(60, 80, 200, 50);
		
		contentPane.add(userPanel);
	}

	public static void AILayout() {
		
		// Winning Numbers Label
		
		JPanel winningNumbersPanel = new JPanel();
		
		JLabel winningNumbers = new JLabel("Winning Lottery Numbers:");
	
		winningNumbersPanel.add(winningNumbers);
		winningNumbersPanel.setBounds(55, 140, 160, 30);
		contentPane.add(winningNumbersPanel);
		
		JPanel computerPanel = new JPanel();
		
		AI_1 = new JTextField( CHARS_PER_LINE);
		AI_2 = new JTextField( CHARS_PER_LINE);
		AI_3 = new JTextField( CHARS_PER_LINE);
		AI_4 = new JTextField( CHARS_PER_LINE);
		AI_5 = new JTextField( CHARS_PER_LINE);
		
		// Cannot edit these text fields
		AI_1.setEditable(false);
		AI_2.setEditable(false);
		AI_3.setEditable(false);
		AI_4.setEditable(false);
		AI_5.setEditable(false);
		
		// Sets their backgrounds to white
		AI_1.setBackground(Color.WHITE);
		AI_2.setBackground(Color.WHITE);
		AI_3.setBackground(Color.WHITE);
		AI_4.setBackground(Color.WHITE);
		AI_5.setBackground(Color.WHITE);
		
		// Sets margins on textField
		AI_1.setMargin(new Insets(10,10,10,10));
		AI_2.setMargin(new Insets(10,10,10,10));
		AI_3.setMargin(new Insets(10,10,10,10));
		AI_4.setMargin(new Insets(10,10,10,10));
		AI_5.setMargin(new Insets(10,10,10,10));
		
		// Changes font size
		AI_1.setFont(AI_1.getFont().deriveFont(14f));
		AI_2.setFont(AI_2.getFont().deriveFont(14f));
		AI_3.setFont(AI_3.getFont().deriveFont(14f));
		AI_4.setFont(AI_4.getFont().deriveFont(14f));
		AI_5.setFont(AI_5.getFont().deriveFont(14f));
		
		// Adds the textFields to the pane
		computerPanel.add(AI_1);
		computerPanel.add(AI_2);
		computerPanel.add(AI_3);
		computerPanel.add(AI_4);
		computerPanel.add(AI_5);
		
		// Positions panel
		computerPanel.setBounds(60, 180, 200, 50);
		contentPane.add(computerPanel);
	}
	
	public static void numOfMatches() {
		// Number of Matches Panel
		JPanel numOfMatchesPanel = new JPanel();
		
		JLabel numOfMatches = new JLabel("Number of Matches:");
				
		numOfMatchesPanel.add(numOfMatches);
		numOfMatchesPanel.setBounds(40, 240, 160, 30);
		contentPane.add(numOfMatchesPanel);
				
		JPanel matchesPanel = new JPanel();
		
		matches = new JTextField( CHARS_PER_LINE);
		matches.setEditable(false);
		matches.setBackground(Color.WHITE);
		matches.setMargin(new Insets(10,10,10,10));
		matches.setFont(matches.getFont().deriveFont(14F));

		matchesPanel.add(matches);
		matchesPanel.setBounds(54, 280, 53, 50);
		contentPane.add(matchesPanel);
	}
	
	public static void prize() {
		// Prize Panel
		JPanel prizeWordPanel = new JPanel();
		
		JLabel prizeWord = new JLabel("Prize:");
				
		prizeWordPanel.add(prizeWord);
		prizeWordPanel.setBounds(0, 340, 160, 30);
		contentPane.add(prizeWordPanel);
				
		JPanel prizePanel = new JPanel();
		
		prize = new JTextField(16);
		prize.setEditable(false);
		prize.setBackground(Color.white);
		prize.setMargin(new Insets(10,10,10,10));
		prize.setFont(matches.getFont().deriveFont(14F));

		prizePanel.add(prize);
		prizePanel.setBounds(65, 380, 200, 50);
		contentPane.add(prizePanel);
	}
	
	public void buttons() {
		JPanel playButton = new JPanel();
		JButton play = new JButton("Play");
		play.addActionListener(this);
		play.setPreferredSize(new Dimension(150, 50));
		playButton.add(play);
		playButton.setBounds(240, 480, 150, 70);
		
		contentPane.add(playButton);
		
		JPanel resetButton = new JPanel();
		JButton reset = new JButton("Reset");
		reset.addActionListener(this);
		reset.setPreferredSize(new Dimension(150, 50));
		resetButton.add(reset);
		resetButton.setBounds(410, 480, 150, 70);
		
		contentPane.add(resetButton);
		
	}
	
	public static void createAIArray() {
		
		// Creates the random array 
		for(int i = 0; i < lottoInt.length; i++)
			lottoInt[i] = (int) (Math.random() * (9 - 0) * 1);
	}
	
	public static int compareArrays() {
		// Compares inputed array with random array to find matches
		for(int i = 0; i < lottoInt.length; i++)
			if(lottoInt[i] == userInput[i])
				total++;
		
		// Converts the random array to a string and adds it to the winning numbers field
		AI_1.setText(Integer.toString(lottoInt[0]));
		AI_2.setText(Integer.toString(lottoInt[1]));
		AI_3.setText(Integer.toString(lottoInt[2]));
		AI_4.setText(Integer.toString(lottoInt[3]));
		AI_5.setText(Integer.toString(lottoInt[4]));
		
		return total;
	}
}
