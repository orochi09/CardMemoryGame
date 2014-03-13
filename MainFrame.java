import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;

public class MainFrame extends Frame implements MouseListener{

	private Label L; 
	private TextField T; 
	private Button B1, B2; 
	
	private GameBoard board;
	private int[] defaultNums = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12};

	public String getText(){
		return T.getText();
	}
	
	public void GameStart(){
		Card[] cards = new Card[24];
		ArrayList<Integer> cardSet = new ArrayList<Integer>();
		for (int i = 0; i < 24; i++){
			cardSet.add(defaultNums[i]);
		}
		for (int i = 0; i < cards.length; i++){
			int randomIndex = (int)(Math.random()*(cardSet.size()));
			cards[i] = new Card(cardSet.get(randomIndex));
			cardSet.remove(randomIndex);
					
		}
		board = new GameBoard(cards, this);
		//TODO
	}
	
	
	
	private static final int LENGTH = 1280, HEIGHT = 720;
	public MainFrame() { 
		this.setLayout(null); 
		L = new Label("Your name:"); 
		L.setBounds(LENGTH/2 - 120, HEIGHT/2 - 80, 100, 40); 
		this.add(L); 
		T = new TextField("Player1"); 
		T.setBounds(LENGTH/2, HEIGHT/2 - 80, 100, 40); 
		this.add(T); 
		B1 = new Button("start"); 
		B1.setBounds(LENGTH/2 - 120, HEIGHT/2, 100, 40); 
		B1.addMouseListener(this);
		this.add(B1); 
		B2 = new Button("exit"); 
		B2.setBounds(LENGTH/2, HEIGHT/2, 100, 40); 
		B2.addMouseListener(this); 
		this.add(B2); 
		this.setBackground(Color.yellow); 
		this.setTitle("CardMemory"); 
		this.setBounds(0, 0, LENGTH, HEIGHT);  
		this.setVisible(true);  
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mf = new MainFrame();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getComponent() == B1) { 
			//board = new GameBoard();
			this.GameStart();
			this.setVisible(false); 
			} 
		if (e.getComponent() == B2) { 
			System.exit(0); 
			} 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




}
