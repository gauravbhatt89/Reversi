import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;


public class revBoard extends JFrame {
	public static void main(String args[]) {
		
	new	revBoard(); 
	
	}
	
	public revBoard() {
		this.setSize(500,500);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		Dimension dm = tk.getScreenSize();
		
		int xPos = (dm.width/2) - (this.getWidth()/2);
		int yPos = (dm.height/2) - (this.getHeight()/2);
		this.setLocation(xPos,yPos);
		this.setResizable(false);
		
		this.setTitle("Reversiiiiiii");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		
		
		this.setVisible(true);
	}
}