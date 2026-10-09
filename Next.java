package weekend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Next implements ActionListener 
{
	JButton b;
	JFrame f;
	void fun()
	{
		f=new JFrame("My Page");
		f.setSize(1600, 900);
		f.getContentPane().setBackground(Color.yellow);
		f.setLayout(null);
//		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\manojana\\OneDrive\\Pictures\\wall1.jpg")));
		f.setVisible(true);
		
		JLabel l=new JLabel("Welcome to My Page");
		l.setBounds(200, 20, 500, 50);
		l.setForeground(Color.BLUE);
		l.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(l);
		
		JRadioButton rb=new JRadioButton("Male");
		rb.setBounds(100, 120, 150, 50);
		rb.setForeground(Color.BLUE);
		rb.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(rb);
		
		JRadioButton rb1=new JRadioButton("Female");
		rb1.setBounds(300, 120, 150, 50);
		rb1.setForeground(Color.BLUE);
		rb1.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(rb1);
		
		ButtonGroup bu=new ButtonGroup();
		bu.add(rb1);
		bu.add(rb);
		
		String a[]= {"Select","Namakkal","Salem","Chennai","Erode","Karur"};
		JComboBox cb=new JComboBox(a);
		cb.setBounds(100, 220, 200, 50);
		cb.setForeground(Color.BLUE);
		cb.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(cb);
		
		String x[]= {"Java","Python","Web designing","AI","Cloud"};
		JList l1=new JList(x);
		l1.setSelectedIndex(0);
		l1.setBounds(100, 320, 300, 250);
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(l1);

		JCheckBox ck=new JCheckBox("I am not Robot");
		ck.setBounds(500, 420, 300, 50);
		ck.setForeground(Color.BLUE);
		ck.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(ck);
		
		JTextArea ta=new JTextArea();
		ta.setBounds(800, 20, 500, 500);
		ta.setForeground(Color.BLUE);
		ta.setLineWrap(true);
		ta.setBackground(Color.PINK);
		ta.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(ta);
		
		b=new JButton("Logout");
		b.setBounds(800, 620, 200, 50);
		b.setForeground(Color.BLUE);
		b.setBackground(Color.CYAN);
		b.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(b);
		b.addActionListener(this);
	}
	public static void main(String[] args) {
		Next n=new Next();
		n.fun();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b)
		{
			JOptionPane.showMessageDialog(b, "Logged out");
			LoginPage l=new LoginPage();
			l.demo();
			f.setVisible(false);
		}
	}

}
