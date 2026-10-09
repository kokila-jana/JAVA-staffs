package weekend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginPage implements ActionListener 
{
	JButton b,b1;
	JTextField t;
	JPasswordField t1;
	JFrame f;
void demo()
{
	f=new JFrame("My project");
	f.setSize(1600, 900);
	f.getContentPane().setBackground(Color.cyan);
	f.setLayout(null);
//	f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\manojana\\OneDrive\\Pictures\\wall1.jpg")));
	f.setVisible(true);
	
	JLabel l=new JLabel("Login Page");
	l.setBounds(200, 20, 200, 50);
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
	
	b=new JButton("Login");
	b.setBounds(200, 320, 200, 50);
	b.setForeground(Color.BLUE);
	b.setBackground(Color.CYAN);
	b.setFont(new Font("Rockwell",Font.ITALIC,35));
	f.add(b);
	b.addActionListener(this);
	
	b1=new JButton("Register");
	b1.setBounds(400, 320, 200, 50);
	b1.setForeground(Color.BLUE);
	b1.setBackground(Color.CYAN);
	b1.setFont(new Font("Rockwell",Font.ITALIC,35));
	f.add(b1);
	b1.addActionListener(this);
}
	
	public static void main(String[] args) 
	{
		LoginPage l=new LoginPage();
		l.demo();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		String s=t.getText();
		String s1=t1.getText();
		if(e.getSource()==b)
		{
			String url="jdbc:mysql://localhost/practice";
			String user="root";
			String pass="kokilajana";
			try {
				Connection con=DriverManager.getConnection(url, user, pass);
				PreparedStatement  ps=con.prepareStatement("select * from detail where name=? and pass=?");
				ps.setString(1, s);
				ps.setString(2, s1);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					JOptionPane.showMessageDialog(b,"Login Success");
					Next n=new Next();
					n.fun();
					f.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(b,"Login failed");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else
		{
			new Register();
			f.setVisible(false);
		}

	}
	
	
}
