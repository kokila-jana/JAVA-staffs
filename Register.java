package weekend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register implements ActionListener
{
	JFrame f;
	JTextField t,t2,t3;
	JPasswordField t1;
	JButton b;
	Register()
	{
		f=new JFrame("My project");
		f.setSize(1600, 900);
		f.getContentPane().setBackground(Color.green);
		f.setLayout(null);
//		f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\manojana\\OneDrive\\Pictures\\wall1.jpg")));
		f.setVisible(true);
		
		JLabel l=new JLabel("Register Page");
		l.setBounds(200, 20, 300, 50);
		l.setForeground(Color.BLUE);
		l.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(l);
		
		JLabel l1=new JLabel("User Name");
		l1.setBounds(100, 120, 200, 50);
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(l1);
		
		t=new JTextField();
		t.setBounds(300, 120, 400, 50);
		t.setForeground(Color.BLUE);
		t.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(t);
		
		JLabel l2=new JLabel("Password");
		l2.setBounds(100, 220, 200, 50);
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(l2);
		
		t1=new JPasswordField();
		t1.setBounds(300, 220, 400, 50);
		t1.setForeground(Color.BLUE);
		t1.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(t1);
		
		JLabel l3=new JLabel("Phone");
		l3.setBounds(100, 320, 200, 50);
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(l3);
		
		t2=new JTextField();
		t2.setBounds(300, 320, 400, 50);
		t2.setForeground(Color.BLUE);
		t2.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(t2);
		
		JLabel l4=new JLabel("GMail");
		l4.setBounds(100, 420, 200, 50);
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(l4);
		
		t3=new JTextField();
		t3.setBounds(300, 420, 400, 50);
		t3.setForeground(Color.BLUE);
		t3.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(t3);
		
		b=new JButton("Register");
		b.setBounds(200, 520, 200, 50);
		b.setForeground(Color.BLUE);
		b.setBackground(Color.green);
		b.setFont(new Font("Rockwell",Font.ITALIC,35));
		f.add(b);
		b.addActionListener(this);

		
	}

	public static void main(String[] args)
	{
		new Register();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String s=t.getText();
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
	if(e.getSource()==b)
	{
		if(s.isEmpty() || s1.isEmpty() ||s2.isEmpty()||s3.isEmpty())
		{
			JOptionPane.showMessageDialog(b, "Please Enter all details...");
		}
		else
		{
			String url="jdbc:mysql://localhost/practice";
			String user="root";
			String pass="kokilajana";
			try {
				Connection con=DriverManager.getConnection(url, user, pass);
				PreparedStatement  ps=con.prepareStatement("insert into detail values(?,?,?,?)");
				ps.setString(1, s);
				ps.setString(2, s1);
				ps.setString(3, s2);
				ps.setString(4, s3);
				ps.execute();
				
				JOptionPane.showMessageDialog(b,"Register Success");
				LoginPage l=new LoginPage();
				l.demo();
				f.setVisible(false);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	}

}
