import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Window extends Frame implements ActionListener{
		

	public static void main(String args[]) {
		
	JFrame frame = new JFrame("Prezetowy Bot");
	frame.setSize(640,480);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
		
}
