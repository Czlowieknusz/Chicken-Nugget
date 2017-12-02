import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1894037743641945270L;
	static JTextField cattegory,maxprice;	
	static JButton button1, button2,boy,girl,ds,find;
	Window(){
		
		
		
	
	JFrame frame = new JFrame("Prezentowy Bot");
	frame.getContentPane().setLayout(new FlowLayout());
	
	
	JLabel label = new JLabel("Give cattegory  ");
	frame.add(label);
	cattegory = new JTextField(45);
	frame.getContentPane().add(cattegory);
	
	
	JLabel mprice = new JLabel("Maximum price");
	frame.add(mprice);
	maxprice = new JTextField(45);
	frame.add(maxprice);
	
	JLabel gender = new JLabel("Select gender");
	frame.add(gender);
	boy = new JButton("Male");
	frame.add(boy);
	
	girl = new JButton("Female");
	frame.add(girl);
	
	ds = new JButton("Doesn't matter");
	frame.add(ds);
	JLabel spac = new JLabel("                                                                                ");
	frame.add(spac);
	
	
	
	find = new JButton("Find");
			frame.add(find);
	
	
	
	/*
	
	ans1 = new JTextField(45);
	 button2 = new JButton("Choose");
	 ans2 = new JTextField(45);
	 button3 = new JButton("Choose");
	 ans3 = new JTextField(45);
	 button4 = new JButton("Choose");
	 ans4 = new JTextField(45);
	 frame.add(button1);
	frame.add(ans1);
	frame.add(button2);
	frame.add(ans2);
	frame.add(button3);
	frame.add(ans3);
	frame.add(button4);
	frame.add(ans4);
	*/
	frame.setSize(640,480);
	frame.setVisible(true);
	frame.setResizable(false);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	

	

	
	
}
	
	public static void main(String args[]) {
		new Window();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
		

