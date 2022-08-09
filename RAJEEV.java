package jnjnuj;
import java.awt.*;



import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
public class RAJEEV implements ActionListener{
	JTextField a1=new JTextField();
	JTextField a2=new JTextField();
	JTextField a3=new JTextField();
	JTextField a4=new JTextField();
	JButton q=new JButton("New loan analysis");
	JButton S=new JButton("Compute monthly payment");
	JButton b=new JButton("X");
	JButton c=new JButton("X");
	TextArea g=new TextArea();
	JFrame w =new JFrame();
	JFrame k=new JFrame("loan assistant");
	String d=new String("hi");
	int months;
	JButton mo=new JButton("Exit");
	String aa=new String();
public void v()
{
		// TODO Auto-generated method stub
		k.setSize(700,300);
		k.setLayout(null);
		Label l1,l2,l3,l4;
		l1=new Label("Loan Balance:");
		l2=new Label("interest rate:");
		l3=new Label("number of months:");
		l4=new Label("monthly payment:");
		l1.setBounds(10,20,80,20);
		l2.setBounds(10,50,80,20);
		l3.setBounds(10,80,120,20);
		l4.setBounds(10,110,100,20);
		k.add(l1);
		k.add(l2);
		k.add(l3);
		k.add(l4);
		a1.setBounds(135,20,150,20);
		a2.setBounds(135,50,150,20);
		a3.setBounds(135,80,150,20);
		a4.setBounds(135,110,150,20);
		k.add(a2);
		k.add(a3);
		k.add(a4);
		b.setBounds(300,80,50,27);
		k.add(b);
		c.setBounds(300,107,50,27);
		S.setBounds(65,150,200,27);
		k.add(S);
		k.add(c);
		q.setBounds(82,185,165,27);
		k.add(q);
		Label h=new Label("Loan analysis");
		h.setBounds(355,20,120,20);
		k.add(h);
		
		g.setBounds(355,50,300,117);
		k.add(g);
		S.addActionListener(this);
		q.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		k.add(a1);	
		k.setVisible(true);
		q.setEnabled(false);
		c.setVisible(false);
		a3.setBackground(Color.white);
		a4.setBackground(Color.yellow);
		a4.setEditable(false);
		k.setResizable(false);
}

public void actionPerformed (ActionEvent e)
{ 
	if(e.getSource()==b)
	{
		b.setVisible(false);
		c.setVisible(true);	
		a3.setEditable(false);
		a4.setEditable(true);
		a3.setBackground(Color.yellow);
		a4.setBackground(Color.white);
		a1.setText("");
		a2.setText("");
		a3.setText("");
		a4.setText("");
		g.setText("");
		a3.setEnabled(false);
		a4.setEnabled(true);
		S.setEnabled(true);
		q.setEnabled(false);
		
		
	}
	else if(e.getSource()==c)
	{
		c.setVisible(false);
		b.setVisible(true);
		a4.setBackground(Color.yellow);
		a3.setBackground(Color.white);
		a4.setEditable(false);
		a3.setEditable(true);
		a1.setText("");
		a2.setText("");
		a3.setText("");
		a4.setText("");
		g.setText("");
		a4.setEnabled(false);
		a3.setEnabled(true);
		S.setEnabled(true);
		q.setEnabled(false);
	}
	else if(e.getSource()==q)
	{
		a1.setText("");
		a2.setText("");
		a3.setText("");
		a4.setText("");
		g.setText("");
		S.setEnabled(true);
		q.setEnabled(false);
	}
if(e.getSource()==S)
{
			q.setEnabled(true);
			S.setEnabled(false);
			double  interest = 0; 
			int payment = 0;
			Double months=0.0;
			double balance=0;
			if (a1.getText().equalsIgnoreCase(""))
			{
			JOptionPane.showConfirmDialog(null, "Invalid or empty Loan Balance entry.\nPleasecorrect.", "Balance Input Error", JOptionPane.DEFAULT_OPTION,
			JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
			balance =Double.parseDouble(a1.getText());		
			}
			
			if (a2.getText().equalsIgnoreCase(""))
			{
			JOptionPane.showConfirmDialog(null, "Invalid or empty Interest Rate entry.\nPleasecorrect.", "Interest Input Error", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				interest =
						Double.parseDouble(a2.getText());
			}
			if(a4.getText().equalsIgnoreCase("") && a3.getText()!="")
			{
				payment=Integer.parseInt(a3.getText());
				if (interest == 0)
				{
				months = (double)(balance/payment);
				}
				else if(a3.getText().equalsIgnoreCase("")){
					JOptionPane.showConfirmDialog(null, "Invalid or empty Number of Paymentsentry.\nPlease correct.", "Number of Payments Input Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
				}
				else 
				{
					months=(double)((balance+((balance*interest)/100))/payment);
					a4.setText(Double.toString(months));
					a3.setText(Integer.toString(payment));
				}
			
				g.setText("Loan Balance: $" +balance);
				g.append("\n" + "Interest Rate: " +(interest) + "%");
				g.append("\n\n" +a3.getText()+ " Payments of $" +((balance+((balance*interest)/100))/payment));
				g.append("\n" + "Total Payments: $" +Double.toString((balance+((balance*interest)/100))));
				g.append("\n" + "Interest Paid $"+(balance*interest)/100);
}
			else if(a3.getText().equalsIgnoreCase("") && a4.getText()!="") {
				months=Double.parseDouble(a4.getText());
			if (interest == 0)
			{
			payment = (int)(balance / months);
			}
			else if(a3.getText().equalsIgnoreCase(""))
			{
			payment =(int)((balance+((balance*interest)/100))/months);
				
			
			}
			a3.setText(Integer.toString((int)(Math.ceil((balance+((balance*interest)/100))/months))));
			q.setEnabled(true);
			S.setEnabled(false);
			g.setText("Loan Balance: $" +balance);
			g.append("\n" + "Interest Rate: " +(interest) + "%");
			g.append("\n\n" +payment+ " Payments of $" +(months));
			g.append("\n" + "Final Payment of: $" + Double.toString(((balance+((balance*interest)/100))-(payment*(Integer.parseInt((a4.getText())))))));
			g.append("\n" + "Total Payments: $" +Double.toString((balance+((balance*interest)/100))));
			g.append("\n" + "Interest Paid $"+(balance*interest)/100);
}
}
}

			private boolean validateDecimalNumber(JTextField a42) {
	// TODO Auto-generated method stub
	return false;
}
public static void main(String[]args)
{
	RAJEEV fq=new RAJEEV();
	fq.v();
}
}
