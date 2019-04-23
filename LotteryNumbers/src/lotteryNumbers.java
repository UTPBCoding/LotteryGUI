import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class lotteryNumbers extends JFrame implements ActionListener{

	private static final int WIDTH = 800;
	private static final int  HEIGHT = 600;
	private static final int LINES = 1;
	private static final int CHARS_PER_LINE = 1;
	
	
	private static int[] lottoInt = new int[5];
	
	
	private static JTextArea AI_1;
	private static JTextArea AI_2;
	private static JTextArea AI_3;
	private static JTextArea AI_4;
	private static JTextArea AI_5;
	
	private static JTextArea user_1;
	private static JTextArea user_2;
	private static JTextArea user_3;
	private static JTextArea user_4;
	private static JTextArea user_5;
	
	private static JTextArea matches;
	
	private static JTextArea prize;
	
	private static Container contentPane;
	
	public lotteryNumbers() {
		setSize(WIDTH, HEIGHT);
		addWindowListener(new WindowDestroyer());
		setTitle("Lottery Numbers");
		contentPane = getContentPane();
		contentPane.setLayout(null);
		
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
		if(e.getActionCommand().equals("Save Numbers")) {
			lottoInt[0] = Integer.parseInt(AI_1.getText());
			lottoInt[1] = Integer.parseInt(AI_2.getText());
			lottoInt[2] = Integer.parseInt(AI_3.getText());
			lottoInt[3] = Integer.parseInt(AI_4.getText());
			lottoInt[4] = Integer.parseInt(AI_5.getText());
			
			user_1.setText(Integer.toString(lottoInt[0]));
			user_2.setText(Integer.toString(lottoInt[1]));
			user_3.setText(Integer.toString(lottoInt[2]));
			user_4.setText(Integer.toString(lottoInt[3]));
			user_5.setText(Integer.toString(lottoInt[4]));
			
			
			
		}
	}
	
	public static void userLayout() {
		JPanel userText = new JPanel();
		
		// Label
		
		JLabel userLabel = new JLabel("User's Lottery Numbers:");
		
		userText.setBackground(Color.GRAY);
		userText.add(userLabel);
		userText.setBounds(60, 40, 160, 30);
		contentPane.add(userText);
		
		// User's Input
		
		JPanel userPanel = new JPanel();
		
		userPanel.setBackground(Color.GRAY);
		
		user_1 = new JTextArea(LINES, CHARS_PER_LINE);
		user_2 = new JTextArea(LINES, CHARS_PER_LINE);
		user_3 = new JTextArea(LINES, CHARS_PER_LINE);
		user_4 = new JTextArea(LINES, CHARS_PER_LINE);
		user_5 = new JTextArea(LINES, CHARS_PER_LINE);
		
		user_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_1.getText().length() >= 1)
					e.consume();
				user_2.requestFocus();
			}
		});
		
		user_2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_2.getText().length() >= 1)
					e.consume();
				user_3.requestFocus();
			}
		});
		
		user_3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_3.getText().length() >= 1)
					e.consume();
				user_4.requestFocus();
			}
		});
		
		user_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_4.getText().length() >= 1)
					e.consume();
				user_5.requestFocus();
			}
		});
		
		user_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if(user_5.getText().length() >= 1)
					e.consume();
			}
		});
		
		user_1.setMargin(new Insets(10,10,10,10));
		user_2.setMargin(new Insets(10,10,10,10));
		user_3.setMargin(new Insets(10,10,10,10));
		user_4.setMargin(new Insets(10,10,10,10));
		user_5.setMargin(new Insets(10,10,10,10));
		
		user_1.setFont(user_1.getFont().deriveFont(14f));
		user_2.setFont(user_2.getFont().deriveFont(14f));
		user_3.setFont(user_3.getFont().deriveFont(14f));
		user_4.setFont(user_4.getFont().deriveFont(14f));
		user_5.setFont(user_5.getFont().deriveFont(14f));
		
		
		userPanel.add(user_1);
		userPanel.add(user_2);
		userPanel.add(user_3);
		userPanel.add(user_4);
		userPanel.add(user_5);
		
		userPanel.setBounds(60, 80, 200, 50);
		
		contentPane.add(userPanel);
	}

	public static void AILayout() {
		
		// Label
		
		JPanel winningNumbersPanel = new JPanel();
		
		JLabel winningNumbers = new JLabel("Winning Lottery Numbers:");
				
		winningNumbersPanel.setBackground(Color.GRAY);
		winningNumbersPanel.add(winningNumbers);
		winningNumbersPanel.setBounds(60, 140, 160, 30);
		contentPane.add(winningNumbersPanel);
		
		JPanel computerPanel = new JPanel();
		computerPanel.setBackground(Color.black);
		
		AI_1 = new JTextArea(LINES, CHARS_PER_LINE);
		AI_2 = new JTextArea(LINES, CHARS_PER_LINE);
		AI_3 = new JTextArea(LINES, CHARS_PER_LINE);
		AI_4 = new JTextArea(LINES, CHARS_PER_LINE);
		AI_5 = new JTextArea(LINES, CHARS_PER_LINE);
		
		AI_1.setEditable(false);
		AI_2.setEditable(false);
		AI_3.setEditable(false);
		AI_4.setEditable(false);
		AI_5.setEditable(false);
		
		AI_1.setMargin(new Insets(10,10,10,10));
		AI_2.setMargin(new Insets(10,10,10,10));
		AI_3.setMargin(new Insets(10,10,10,10));
		AI_4.setMargin(new Insets(10,10,10,10));
		AI_5.setMargin(new Insets(10,10,10,10));
		
		AI_1.setFont(AI_1.getFont().deriveFont(14f));
		AI_2.setFont(AI_2.getFont().deriveFont(14f));
		AI_3.setFont(AI_3.getFont().deriveFont(14f));
		AI_4.setFont(AI_4.getFont().deriveFont(14f));
		AI_5.setFont(AI_5.getFont().deriveFont(14f));
		
		
		computerPanel.add(AI_1);
		computerPanel.add(AI_2);
		computerPanel.add(AI_3);
		computerPanel.add(AI_4);
		computerPanel.add(AI_5);
		
		computerPanel.setBounds(60, 180, 200, 50);
		contentPane.add(computerPanel);
	}
	
	public static void numOfMatches() {
		// Number of Matches
		
		JPanel numOfMatchesPanel = new JPanel();
		
		JLabel numOfMatches = new JLabel("Number of Matches:");
				
		numOfMatchesPanel.setBackground(Color.GRAY);
		numOfMatchesPanel.add(numOfMatches);
		numOfMatchesPanel.setBounds(60, 240, 160, 30);
		contentPane.add(numOfMatchesPanel);
				
		JPanel matchesPanel = new JPanel();
		matchesPanel.setBackground(Color.GRAY);
		
		matches = new JTextArea(LINES, CHARS_PER_LINE);
		matches.setEditable(false);
		matches.setMargin(new Insets(10,10,10,10));
		matches.setFont(matches.getFont().deriveFont(14F));

		matchesPanel.add(matches);
		matchesPanel.setBounds(60, 280, 53, 50);
		contentPane.add(matchesPanel);
	}
	
	public static void prize() {
		JPanel prizeWordPanel = new JPanel();
		
		JLabel prizeWord = new JLabel("Prize:");
				
		prizeWordPanel.setBackground(Color.GRAY);
		prizeWordPanel.add(prizeWord);
		prizeWordPanel.setBounds(60, 340, 160, 30);
		contentPane.add(prizeWordPanel);
				
		JPanel prizePanel = new JPanel();
		prizePanel.setBackground(Color.GRAY);
		
		prize = new JTextArea(LINES, CHARS_PER_LINE);
		prize.setEditable(false);
		prize.setMargin(new Insets(10,10,10,10));
		prize.setFont(matches.getFont().deriveFont(14F));

		prizePanel.add(prize);
		prizePanel.setBounds(60, 380, 53, 50);
		contentPane.add(prizePanel);
	}
	
	public static void buttons() {
		
	}
}
