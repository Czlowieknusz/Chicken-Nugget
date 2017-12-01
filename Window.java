import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Window extends Frame implements ActionListener{
	static JTextField textinput, textoutput;	
	Window(){
	
	
	JFrame frame = new JFrame("Prezetowy Bot");
	frame.getContentPane().setLayout(new FlowLayout());
	textinput = new JTextField(10);
	textoutput = new JTextField(10);
	frame.getContentPane().add(textinput);
	frame.getContentPane().add(textoutput);
	
	
	
	
	
	
	frame.setSize(640,480);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	

	
	
}
	public static void main(String args[]) {
		new Window();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
		

