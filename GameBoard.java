import java.util.Stack;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameBoard extends JFrame implements MouseListener{
	private Card[] cards;
	private Card last;
	private int step;
	private Stack<Integer> stack = new Stack<Integer>();
	private boolean flag = true;
	private int count = 0;
	private MainFrame mf;
	
	private JLabel sl;
	
	private Button exit, reset;
	private ImageIcon back = new ImageIcon("pic/card-back.png");
	
	public GameBoard(Card[] cards1, MainFrame mainFrame) { 
		cards = cards1;
		exit = new Button("exit");  
		exit.setBounds(700, 50, 80, 30); 
		exit.addMouseListener(this); 
		this.add(exit); 
		
		reset = new Button("reset");  
		reset.setBounds(700, 200, 80, 30); 
		reset.addMouseListener(this); 
		this.add(reset); 
		
		this.mf = mainFrame;
		/*
		ii1 = new ImageIcon("pic/card-back.png");
		ii2 = new ImageIcon("pic/card-face.png");
		cardtry = new JButton(ii1);
		cardtry.setBounds(100, 100, 93, 130);
		cardtry.addMouseListener(this);
		this.add(cardtry); 
		*/
		JLabel L = new JLabel("Step:"); 
		L.setBounds(650, 600, 50, 40); 
		this.add(L); 
		
		sl = new JLabel("0");
		sl.setBounds(700, 600, 50, 40);
		this.add(sl);
		
		for (int i = 0; i < cards.length; i++){
			cards[i].getButton().setBounds(i%6 * 100 + 30, i/6 * 150 + 30, 93, 130);
			cards[i].getButton().addMouseListener(this);
			this.add(cards[i].getButton());
		}
		
		this.setLayout(null); 
		this.setBackground(Color.white);  
		this.setTitle("CardMemoryGame"); 
		this.setBounds(200, 80, 800, 800); 
		this.setVisible(true); 
	}
	
	private JButton b1,b2;
	private JFrame f;
	private void createEndBoard(){
		f = new JFrame();
		JLabel l1 = new JLabel("Mission Completed!! You win!!");
		JLabel l2 = new JLabel("Player: ".concat(mf.getText()));
		JLabel l3 = new JLabel("Total step: ".concat(String.valueOf(step)));
		l1.setBounds(40, 20, 200, 40); 
		l2.setBounds(40, 60, 200, 40); 
		l3.setBounds(40, 100, 200, 40); 
		f.add(l1);
		f.add(l2);
		f.add(l3);
		b1 = new JButton("new game");
		b2 = new JButton("exit");
		b1.setBounds(40, 150, 100, 40); 
		b1.addMouseListener(this);
		f.add(b1); 
		b2.setBounds(200, 150, 100, 40); 
		b2.addMouseListener(this);
		f.add(b2); 
		
		f.setLayout(null); 
		f.setBackground(Color.white);  
		f.setTitle("Congratulations!"); 
		f.setBounds(380, 300, 350, 220); 
		f.setVisible(true); 
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getComponent() == exit) { 
			System.exit(0); 
		}else if(e.getComponent() == b1 || e.getComponent() == reset){
			mf.GameStart();
			if (f != null){
				f.dispose();
			}
			this.dispose();
		}else if(e.getComponent() == b2){
			System.exit(0);
		}
		for (int i = 0; i < cards.length; i++){
			if (e.getComponent() == cards[i].getButton()) {
				if (!cards[i].isUp()){
					cards[i].getButton().setIcon(cards[i].getIcon());
//					this.flip(cards[i]);
//					this.isSame(cards[i]);
					cards[i].setUp(true);
					step++;
					sl.setText(String.valueOf(step));
					if(flag){
						stack.push(cards[i].getNum());
					}else{
						int n = 0;
						for (int j = 0; j < cards.length; j++){
							if (cards[j].isUp()){
								n++;
							}
						}
						if (n == cards.length){
							this.createEndBoard();
						}
					}
					flag = false;
					count++;
				}
				
			} 
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cards.length; i++){
			if (e.getComponent() == cards[i].getButton()) { 
//				if (!cards[i].isKnown()){
//					cards[i].getButton().setIcon(back);
//				}
				if (count == 2){
					if (cards[i].getNum() != stack.peek()){
						cards[i].getButton().setIcon(back);
						cards[i].setUp(false);
						int lastNum = stack.pop();
						for(int j = 0; j < cards.length; j++){
							if (cards[j].getNum() == lastNum){
								cards[j].getButton().setIcon(back);
								cards[j].setUp(false);
							}
						}
					}
					flag = true;
					count = 0;
				}
			} 
		}
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
