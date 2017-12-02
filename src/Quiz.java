
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quiz extends JFrame {
	
	
	

public boolean next = false;
public int counter = 0;
public int answer1, answer2, answer3;
	Quiz (String[] qna){
		JFrame frame = new JFrame("Quiz");
		JLabel questionlabel = new JLabel(qna[0]);
		questionlabel.setFont(questionlabel.getFont().deriveFont(18.0f));
		JButton abutton = new JButton(qna[1]);
		JButton bbutton = new JButton(qna[2]);
		JButton cbutton = new JButton(qna[3]);
		JButton dbutton = new JButton(qna[4]);
		JButton ebutton = new JButton(qna[5]);
		
		abutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				answer1=1;
				answer2=1;
				answer3=1;
				if(counter==3) frame.dispose();
			
			}
		});
		bbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				answer1=2;
				answer2=2;
				answer3=2;
				
			}
		});
		cbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				answer1=3;
				answer2=3;
				answer3=4;
				
			}
		});
		dbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				answer1=4;
				answer2=4;
				answer3=4;
			
			}
		});
		ebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter++;
				answer1=5;
				answer2=5;
				answer3=5;				
			}
		});
		int[] answers = new int[3];
		answers[0]=answer1;
		answers[1]=answer2;
		answers[2]=answer3;
		frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		frame.add(questionlabel);
		frame.add(abutton);
		frame.add(bbutton);
		frame.add(cbutton);
		frame.add(dbutton);
		frame.add(ebutton);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		frame.setSize(680, 480);
		frame.setResizable(false);
		
	}
	
	public static void main (String args[]) {
		String[] qna = new String[6];
		qna[0]="Go Ha Go Ha Go Ha 3 z³";
		qna[1]="xD";
		qna[2]="xD";
		qna[3]="xD";
		qna[4]="xD";
		qna[5]="xD";
	
		Quiz quiz = new Quiz(qna);
		while(quiz.isActive()) {
			
		}
		System.out.println(quiz.answer3);
			
		
		
		
	}
	
	
}
