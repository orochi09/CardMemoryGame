import javax.swing.ImageIcon;
import javax.swing.JButton;




public class Card {
	Card(int num) {
		this.num = num;
		this.isUp = false;
		this.isKnown = false;
		//TODO
		
		this.strOfNum = String.valueOf(this.num);
		this.setIcon(new ImageIcon("pic/card-face"+this.strOfNum+".png"));
		
		this.setButton(new JButton(new ImageIcon("pic/card-back.png")));
	}
	private int num = 0;
	private String strOfNum;
	private boolean isKnown;
	private boolean isUp;
	private JButton button;
	private ImageIcon icon;

	public boolean isUp() {
		return isUp;
	}
	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public JButton getButton() {
		return button;
	}
	public void setButton(JButton button) {
		this.button = button;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public boolean isKnown() {
		return isKnown;
	}
	public void setKnown(boolean isKnown) {
		this.isKnown = isKnown;
	}
	
	
	
}
