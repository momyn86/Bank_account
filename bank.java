import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class bank extends Frame implements ActionListener,ItemListener
{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int st=0,st1=0;
Panel m,p1,p2,p3,p4,p5,rp1;
CardLayout cr;
Checkbox ch1,ch2;
Connection c;
CheckboxGroup cbg;
Label lb1,lb2,lb3,r1,r2,r3;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
Label l16,l17,l18,l19,l20,l21,l22,l23,l24,l25;
Choice transtype3,acctype4,ch3,ch4;
List transrp;
TextField pwd,acctype,minbal,transno,transdt,transamt,currbal,accno3,chacno,accnorp;
TextField accno4,name,addr,phoneno,opendt,openbal,dtofbirth,usr;
Button login,exit,clear2,save2,close2,modify2,clear3,save3,close3,newtrans,newmem,clear4,save4,modify4,close4,search,closerp;
Dialog dd=new Dialog(this,"Error",true);
Dialog dd2=new Dialog(this,"Banking System",true);
Dialog dd3=new Dialog(this,"Banking System",true);
Button ok=new Button("OK");
Button ok2=new Button("OK");
Button cancel2=new Button("Cancel");
Button ok3=new Button("OK");
Button cancel3=new Button("Cancel");
Menu file,msearch;
 MenuItem m1,m2,m3,m4,m6,m7;

public bank()
{
    MenuBar b=new MenuBar();
    setMenuBar(b);     
 file=new Menu("File");
msearch=new Menu("View");
    m1=new MenuItem("New Account Type");
    m2=new MenuItem("New Account");
    m3=new MenuItem("New Transaction");
    m4=new MenuItem("Exit");	
	
file.setEnabled(false);
msearch.setEnabled(false);

    m1.addActionListener(this);
    m2.addActionListener(this);	
    m3.addActionListener(this);
    m4.addActionListener(this);

    Menu m5=new Menu("Report");
    m6=new MenuItem("Accont detail");
    m7=new MenuItem("Transaction detail");
    msearch.add(m5);

    m6.addActionListener(this);
    m7.addActionListener(this);

    m5.add(m6);m5.add(m7);

    file.add(m1);
    file.add(m2);
    file.add(m3);
    file.add(m4);
    b.add(file);
    b.add(msearch);


m=new Panel();
p1=new Panel();	  //Login
p2=new Panel();	 //
p3=new Panel();
p4=new Panel();
p5=new Panel();
rp1=new Panel();
cr=new CardLayout();
m.setLayout(cr);

//--------------------------
p1.setLayout(null);
l1=new Label("Login");l2=new Label("To");
l3=new Label("Banking System");
l4=new Label("User Name");
l5=new Label("Password");
l1.setFont(new Font("Arial",Font.BOLD,70));
l2.setFont(new Font("Arial",Font.BOLD,70));
l3.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,70));
l4.setFont(new Font("Arial",Font.BOLD,30));
l5.setFont(new Font("Arial",Font.BOLD,30));
usr=new TextField();
pwd=new TextField();
pwd.setEchoChar('*');
login=new Button("Login");
exit=new Button("Exit");
login.addActionListener(this);
exit.addActionListener(this);
p1.add(l1);p1.add(l2);p1.add(l3);p1.add(l4);p1.add(l5);
p1.add(usr);p1.add(pwd);p1.add(login);p1.add(exit);
l1.setBounds(250,50,300,100);
l2.setBounds(300,150,300,100);
l3.setBounds(100,240,700,100);
l4.setBounds(200,350,180,50);
l5.setBounds(200,400,175,50);
usr.setBounds(380,365,140,20);
pwd.setBounds(380,420,140,20);
login.setBounds(270,480,80,40);
exit.setBounds(360,480,80,40);
//--------------------------

p2.setLayout(null);
l6=new Label("Account Details");l7=new Label("Account Type");
l8=new Label("Minimum Balance");
l6.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,70));
l7.setFont(new Font("Arial",Font.BOLD,30));
l8.setFont(new Font("Arial",Font.BOLD,30));
acctype=new TextField();
minbal=new TextField();
acctype.setEnabled(false);
minbal.setEnabled(false);
clear2=new Button("Clear");clear2.addActionListener(this);
save2=new Button("Save");save2.addActionListener(this);
modify2=new Button("Modify");modify2.addActionListener(this);
close2=new Button("Close");close2.addActionListener(this);
p2.add(l6);p2.add(l7);p2.add(l8);p2.add(acctype);
p2.add(minbal);p2.add(clear2);p2.add(save2);
p2.add(close2);p2.add(modify2);
l6.setBounds(120,50,600,100);
l7.setBounds(150,200,200,80);
l8.setBounds(150,300,250,80);
acctype.setBounds(430,225,150,25);
minbal.setBounds(430,325,150,25);
clear2.setBounds(180,400,80,40);
save2.setBounds(280,400,80,40);
modify2.setBounds(380,400,80,40);
close2.setBounds(480,400,80,40);

//--------------------------

p3.setLayout(null);
l9=new Label("Transaction Details");
l10=new Label("Account No");
l11=new Label("Transaction Type");
l12=new Label("Transaction Date");
l13=new Label("Transaction Amount");
l14=new Label("Current Balance");
l15=new Label("Transaction No.");
l9.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,70));
l10.setFont(new Font("Arial",Font.BOLD,30));
l11.setFont(new Font("Arial",Font.BOLD,30));
l12.setFont(new Font("Arial",Font.BOLD,30));
l13.setFont(new Font("Arial",Font.BOLD,30));
l14.setFont(new Font("Arial",Font.BOLD,30));
l15.setFont(new Font("Arial",Font.BOLD,30));
accno3=new TextField();
transdt=new TextField();
transamt=new TextField();
currbal=new TextField();
transno=new TextField();
transtype3=new Choice();
transtype3.add("Deposit");
transtype3.add("Withdrawal");
transtype3.addItemListener(this);
newtrans=new Button("New Transaction");
newtrans.addActionListener(this);
clear3=new Button("Clear");
save3=new Button("Save");
close3=new Button("Close");
p3.add(l9);p3.add(l15);p3.add(l10);p3.add(l11);
p3.add(l12);p3.add(l13);p3.add(l14);
p3.add(accno3);p3.add(transtype3);p3.add(transdt);
p3.add(transamt);p3.add(currbal);p3.add(transno);
p3.add(newtrans);p3.add(clear3);p3.add(save3);
p3.add(close3);
l9.setBounds(60,20,660,130);
l15.setBounds(80,140,230,80);transno.setBounds(380,170,200,30);
l10.setBounds(80,190,230,80);accno3.setBounds(380,220,200,30);
l11.setBounds(80,240,250,80);transtype3.setBounds(380,270,200,30);
l12.setBounds(80,290,250,82);transdt.setBounds(380,320,200,30);
l13.setBounds(80,340,300,82);transamt.setBounds(380,370,200,30);
l14.setBounds(80,400,250,82);currbal.setBounds(380,430,200,30);

transno.setEnabled(false);
accno3.setEnabled(false);
transtype3.setEnabled(false);
transdt.setEnabled(false);
transamt.setEnabled(false);
currbal.setEnabled(false);

newtrans.setBounds(100,500,100,40);
clear3.setBounds(250,500,80,40);
save3.setBounds(350,500,80,40);
close3.setBounds(450,500,80,40);
newtrans.addActionListener(this);
clear3.addActionListener(this);
save3.addActionListener(this);
close3.addActionListener(this);

//--------------------------

p4.setLayout(null);
l16=new Label("Member Details");l17=new Label("Account No");
l18=new Label("Name");l19=new Label("Address");
l20=new Label("PhoneNo.");l21=new Label("Gender");
l22=new Label("Opening Date");l23=new Label("Opening Balance");
l24=new Label("Account Type");l25=new Label("Date Of Birth");
cbg=new CheckboxGroup();
ch1=new Checkbox("Male",cbg,false);
ch2=new Checkbox("Female",cbg,false);
ch1.setEnabled(false);ch2.setEnabled(false);
l16.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,70));
l17.setFont(new Font("Arial",Font.BOLD,30));
l18.setFont(new Font("Arial",Font.BOLD,30));
l19.setFont(new Font("Arial",Font.BOLD,30));
l20.setFont(new Font("Arial",Font.BOLD,30));
l21.setFont(new Font("Arial",Font.BOLD,30));
l22.setFont(new Font("Arial",Font.BOLD,30));
l23.setFont(new Font("Arial",Font.BOLD,30));
l24.setFont(new Font("Arial",Font.BOLD,30));
l25.setFont(new Font("Arial",Font.BOLD,30));
accno4=new TextField();name=new TextField();
addr=new TextField();phoneno=new TextField();
opendt=new TextField();openbal=new TextField();
dtofbirth=new TextField();acctype4=new Choice();
accno4.setEnabled(false);name.setEnabled(false);
addr.setEnabled(false);phoneno.setEnabled(false);
opendt.setEnabled(false);openbal.setEnabled(false);
dtofbirth.setEnabled(false);acctype4.setEnabled(false);
newmem=new Button("New Member");
newmem.addActionListener(this);
clear4=new Button("Clear");
clear4.addActionListener(this);
save4=new Button("Save");
save4.addActionListener(this);
modify4=new Button("Modify");
modify4.addActionListener(this);
close4=new Button("Close");
close4.addActionListener(this);
p4.add(l16);p4.add(l17);p4.add(accno4);
p4.add(l18);p4.add(name);
p4.add(l19);p4.add(addr);
p4.add(l20);p4.add(phoneno);
p4.add(l21);p4.add(newmem);p4.add(save4);
p4.add(clear4);p4.add(modify4);p4.add(close4);
p4.add(l22);p4.add(l23);p4.add(l24);
p4.add(l25);p4.add(ch1);p4.add(ch2);p4.add(dtofbirth);
p4.add(opendt);p4.add(openbal);p4.add(acctype4);
l16.setBounds(150,5,660,90);
l17.setBounds(80,85,230,55);accno4.setBounds(380,100,200,30);
l18.setBounds(80,125,230,55);name.setBounds(380,140,200,30);
l19.setBounds(80,165,230,55);addr.setBounds(380,180,200,30);
l20.setBounds(80,205,230,55);phoneno.setBounds(380,220,200,30);
l21.setBounds(80,245,230,55);ch1.setBounds(380,260,60,30);ch2.setBounds(450,260,100,30);
l22.setBounds(80,285,230,55);opendt.setBounds(380,300,200,30);
l23.setBounds(80,325,250,55);openbal.setBounds(380,340,200,30);
l24.setBounds(80,365,230,55);acctype4.setBounds(380,380,200,30);
l25.setBounds(80,405,230,55);dtofbirth.setBounds(380,420,200,30);
newmem.setBounds(120,480,100,40);
clear4.setBounds(250,480,80,40);
save4.setBounds(350,480,80,40);
close4.setBounds(450,480,80,40);
modify4.setBounds(550,480,80,40);
//---------------------------------

rp1.setLayout(null);
r1=new Label("Transaction Report");r2=new Label("Account No");
r3=new Label("Transaction Details");
r1.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,70));
r2.setFont(new Font("Arial",Font.BOLD,30));
r3.setFont(new Font("Arial",Font.BOLD,30));
accnorp=new TextField();
transrp=new List();
transrp.add("  Serial_No      Transaction_type       Trans_Date       Transaction_Amt       Curr_balance");
transrp.add("-----------------------------------------------------------------------------------------------------------------------------------");
transrp.setEnabled(false);
search=new Button("Search");
search.addActionListener(this);
closerp=new Button("Close");
closerp.addActionListener(this);
rp1.add(r1);rp1.add(r2);rp1.add(r3);
rp1.add(accnorp);rp1.add(transrp);
rp1.add(search);rp1.add(closerp);

r1.setBounds(100,5,660,90);
r2.setBounds(80,110,230,55);accnorp.setBounds(380,120,200,30);
r3.setBounds(80,190,400,55);transrp.setBounds(140,250,500,200);
search.setBounds(300,480,100,40);
closerp.setBounds(450,480,80,40);

//---------------------------------




//--------------------------

	 lb1=new Label("enter account name & minimumbalance");
	lb1.setVisible(false);
	chacno=new TextField(10);
	chacno.setVisible(false);
	dd.setLayout(new FlowLayout());
	ok.addActionListener(this);
	dd.add(lb1);
	add(chacno);
	dd.add(ok);
	dd.setSize(200,200);

//--------------------------
	 lb2=new Label("Select account type");
	lb2.setVisible(false);
	ch3=new Choice();
	ch3.setVisible(false);
	dd2.setLayout(new FlowLayout());
	ok2.addActionListener(this);
	cancel2.addActionListener(this);
	dd2.add(lb2);
	dd2.add(ch3);
	dd2.add(ok2);
	dd2.add(cancel2);
	dd2.setSize(200,200);
//-----------------------------------

//--------------------------
	 lb3=new Label("Select accountno");
	lb3.setVisible(false);
	ch4=new Choice();
	ch4.setVisible(false);
	dd3.setLayout(new FlowLayout());
	ok3.addActionListener(this);
	cancel3.addActionListener(this);
	dd3.add(lb3);
	dd3.add(ch4);
	dd3.add(ok3);
	dd3.add(cancel3);
	dd3.setSize(200,200);
//-----------------------------------
m.add(p1,"first");
p1.setVisible(true);
p3.setVisible(false);
p2.setVisible(false);
p4.setVisible(false);
m.add(p3,"transaction");
m.add(p4,"member");
m.add(p2,"accdetails");

m.add(rp1,"tdetail");
add(m);
}

public void connect()
{
	try
	{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	c=DriverManager.getConnection("jdbc:odbc:bank","aptech","aptech");
}
	catch(SQLException r)
	{
	System.out.println(r);
	}

	catch(ClassNotFoundException e1)
	{
	System.out.println(e1);
	}

}
public void itemStateChanged(ItemEvent e)
{
st++;
}
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e)
{
if (e.getSource()==m1)
{
System.out.println(11);
p2.setVisible(true);
}
else if (e.getSource()==m2)
{
p4.setVisible(true);
}
else if (e.getSource()==m3)
{
p3.setVisible(true);
}
else if (e.getSource()==m4)
{
System.exit(0);
}
else if(e.getSource()==m7)
{
rp1.setVisible(true);
}
else if (e.getSource()==m6)
{
	lb1.setText("Enter Accno ");	
	st1=1;
	dd.add(chacno);
	chacno.setText("");
	chacno.setVisible(true);
	lb1.setVisible(true);
	dd.setVisible(true);
}
else if(e.getSource()==save2)
	{
	if(acctype.getText().equals("") || minbal.getText().equals(""))
	{
	lb1.setVisible(true);
	dd.setVisible(true);
	}
	else
	{
	try
	{
	connect();
	Statement s= c.createStatement();
	int n=s.executeUpdate("insert into accdetails values('"+acctype.getText()+"','"+minbal.getText()+"')");
	System.out.println(n +"row inserted");
	lb1.setText("Record Inserted");
	acctype.setText("");
	minbal.setText("");
	acctype.setEnabled(false);
	minbal.setEnabled(false);
	lb1.setVisible(true);
	dd.setVisible(true);
	}
	catch(SQLException r)
	{
	System.out.println(r);
	}
	}

	}
else if(e.getSource()==ok)
{
	System.out.println("value="+st1);
	if(st1==1)
	{
	String str3=chacno.getText();
	dd.dispose();
	
	int cnnt1=0;
		try
		{
		connect();
		Statement s= c.createStatement();
		ResultSet rr=s.executeQuery("select * from member where accno='"+str3+"'"); 
		while(rr.next())
		{
		accno4.setText(rr.getString(1));
		name.setText(rr.getString(2));
		addr.setText(rr.getString(3));
		phoneno.setText(rr.getString(4));
		phoneno.setEnabled(false);
		addr.setEnabled(false);
			if(rr.getString(5).equals("Male"))
			ch1.setState(true);
			else
			ch2.setState(true);
		opendt.setText(rr.getString(6));
		openbal.setText(rr.getString(7));
		acctype4.add(rr.getString(8));
		dtofbirth.setText(rr.getString(9));
		cnnt1++;
		}
		if(cnnt1==0)
		{p4.setVisible(false);
			st1=0;
			lb1.setText("Invalid Account No.");	
			lb1.setVisible(true);
			chacno.setVisible(false);
			dd.setVisible(true);			
		}
		else
		p4.setVisible(true);

	
		}
		catch(SQLException r)
		{
		System.out.println(r);
		}
	addr.setEnabled(true);
	phoneno.setEnabled(true);
	modify4.setLabel("Update");
	dd3.dispose();
	}

else
	{
	System.out.println("call");
	dd.dispose();
	}	
}
else if(e.getSource()==clear2)
	{
	System.out.println(11);
	acctype.setText("");
	minbal.setText("");
	acctype.setEnabled(true);
	minbal.setEnabled(true);
	modify2.setLabel("Modify");
	}
else if(e.getSource()==clear4)
	{
accno4.setText("");name.setText("");
addr.setText("");phoneno.setText("");
opendt.setText("");openbal.setText("");
dtofbirth.setText("");
acctype4.removeAll();
ch1.setState(false);ch2.setState(false);
		name.setEnabled(false);
		addr.setEnabled(false);
		phoneno.setEnabled(false);		
		openbal.setEnabled(false);
		dtofbirth.setEnabled(false);
		ch1.setEnabled(false);
		ch2.setEnabled(false);
		acctype4.setEnabled(false);
		modify4.setLabel("Modify");

	}
else if(e.getSource()==modify2)
	{
		if(modify2.getLabel().equals("Modify"))
		{
		try
		{
		connect();
		Statement s= c.createStatement();
		ResultSet r=s.executeQuery("select * from accdetails"); 			
		while(r.next())
		{
		ch3.add(r.getString(1));
		}

		}
		catch(SQLException r)
		{
		System.out.println(r);
		}

		lb2.setVisible(true);
		ch3.setVisible(true);
		ok2.setVisible(true);
		cancel2.setVisible(true);
		dd2.setVisible(true);
		}
		else if(modify2.getLabel().equals("Update"))		
		{
			try
			{
			connect();
			Statement s= c.createStatement();
		s.executeUpdate("update accdetails set min_bal='"+minbal.getText()+"' where acctype='"+acctype.getText()+"'");
		System.out.println("row updated");
			lb1.setText("Record Modified");
			acctype.setText("");
			minbal.setText("");
			acctype.setEnabled(false);
			minbal.setEnabled(false);
			lb1.setVisible(true);
			dd.setVisible(true);

		modify2.setLabel("Modify");
			}
		catch(SQLException r)
		{
		System.out.println(r);
		}

		}
	}
else if(e.getSource()==ok2)
	{
	acctype.setText(ch3.getSelectedItem());
	modify2.setLabel("Update");
	dd2.dispose();
	}
else if(e.getSource()==m1)
{
p3.setVisible(true);
}
else if(e.getSource()==ok3)
{
	System.out.println(12);

		try
		{
		connect();
		Statement s= c.createStatement();
		ResultSet r=s.executeQuery("select * from member where accno='"+ch4.getSelectedItem()+"'"); 			
		while(r.next())
		{
		accno4.setText(r.getString(1));
		name.setText(r.getString(2));
		addr.setText(r.getString(3));
		phoneno.setText(r.getString(4));
		if(r.getString(5).equals("Male"))
		{
			ch1.setState(true);
		}
		else
		{
			ch2.setState(true);
		}
		opendt.setText(r.getString(6));
		openbal.setText(r.getString(7));
		acctype4.add(r.getString(8));
		dtofbirth.setText(r.getString(9));
		}
		}
		catch(SQLException r)
		{
		System.out.println(r);
		}
	addr.setEnabled(true);
	phoneno.setEnabled(true);
	modify4.setLabel("Update");
	dd3.dispose();
	}




else if(e.getSource()==cancel2)
	{
	dd2.dispose();
	}
else if(e.getSource()==newmem)
{
		int no=0;
		try
		{
		connect();
		Statement s= c.createStatement();
		ResultSet r=s.executeQuery("select * from member"); 			
		while(r.next())
		{
		no=Integer.parseInt(r.getString(1));
		System.out.println(no);
		}
		no=no+1;
		accno4.setText(String.valueOf(no));
		name.setEnabled(true);
		addr.setEnabled(true);
		phoneno.setEnabled(true);		
		openbal.setEnabled(true);
		dtofbirth.setEnabled(true);
		ch1.setEnabled(true);
		ch2.setEnabled(true);
		acctype4.setEnabled(true);
		java.util.Date dd=new java.util.Date();
		opendt.setText(dd.getDate()+"/"+dd.getMonth()+"/"+dd.getYear());
		Statement s1= c.createStatement();
		ResultSet r1=s1.executeQuery("select * from accdetails"); 			
		while(r1.next())
		{
		acctype4.add(r1.getString(1));
		}

		}
		catch(SQLException r)
		{
		System.out.println(r);
		}

}
else if(e.getSource()==save4)
	{
	String g="";
if(ch1.getState()==true)
{
	g="Male";
}
else if(ch2.getState()==true)
{
	g="Female";
}
System.out.println(g);

if(phoneno.getText().equals(""))
{
phoneno.setText("0");
}

	if(accno4.getText().equals("") || name.getText().equals("") || addr.getText().equals("") || phoneno.getText().equals("")||openbal.getText().equals("") || dtofbirth.getText().equals("") || g.equals("") || acctype4.getSelectedItem().equals(""))
	{
	lb1.setText("Enter all fields");
	lb1.setVisible(true);
	dd.setVisible(true);
	}
	else
	{
	try
	{
	connect();
	Statement s1=c.createStatement();
	ResultSet r1=s1.executeQuery("select * from accdetails where 	acctype='"+acctype4.getSelectedItem()+"'");	
	int no=0;
	while(r1.next())	
	{
	no=Integer.parseInt(r1.getString(2));
	System.out.println(no);
	}

	if(Integer.parseInt(openbal.getText())<no)
	{
	lb1.setText("Minimum balance cannot be less than " + no);
	lb1.setVisible(true);
	dd.setVisible(true);
	}
	else
	{
	Statement s= c.createStatement();
	int n=s.executeUpdate("insert into member values('"+accno4.getText()+"','"+name.getText()+"','"+addr.getText()+"','"+phoneno.getText()+"','"+g+"','"+opendt.getText()+"','"+openbal.getText()+"','"+acctype4.getSelectedItem()+"','"+dtofbirth.getText()+"')");
	System.out.println(n +"row inserted");
	lb1.setText("Record Inserted");
	accno4.setText("");name.setText("");
	addr.setText("");phoneno.setText("");
	opendt.setText("");openbal.setText("");
	dtofbirth.setText("");
	acctype4.removeAll();
	ch1.setState(false);ch2.setState(false);
		name.setEnabled(false);
		addr.setEnabled(false);
		phoneno.setEnabled(false);		
		openbal.setEnabled(false);
		dtofbirth.setEnabled(false);
		ch1.setEnabled(false);
		ch2.setEnabled(false);
		acctype4.setEnabled(false);

	lb1.setVisible(true);
	dd.setVisible(true);
	}
	}	
catch(SQLException r)
	{
	System.out.println(r);
	}
	}

	}

else if(e.getSource()==modify4)
	{
		if(modify4.getLabel().equals("Modify"))
		{
		try
		{
		connect();
		Statement s= c.createStatement();
		ResultSet r=s.executeQuery("select * from member"); 			
		while(r.next())
		{
		ch4.add(r.getString(1));
		}
		}
		catch(SQLException r)
		{
		System.out.println(r);
		}
	
		lb3.setVisible(true);
		ch4.setVisible(true);
		ok3.setVisible(true);
		cancel3.setVisible(true);
		dd3.setVisible(true);

		}
		else if(modify4.getLabel().equals("Update"))		
		{
			try
			{
			connect();
			Statement s= c.createStatement();
		s.executeUpdate("update member set address='"+addr.getText()+"',phoneno='"+phoneno.getText()+"' where accno='"+accno4.getText()+"'");
		System.out.println("row updated");
		accno4.setText("");name.setText("");
addr.setText("");phoneno.setText("");
opendt.setText("");openbal.setText("");
dtofbirth.setText("");
acctype4.removeAll();
ch1.setState(false);ch2.setState(false);
		name.setEnabled(false);
		addr.setEnabled(false);
		phoneno.setEnabled(false);		
		openbal.setEnabled(false);
		dtofbirth.setEnabled(false);
		ch1.setEnabled(false);
		ch2.setEnabled(false);
		acctype4.setEnabled(false);
		modify4.setLabel("Modify");


			lb1.setText("Record Modified");
			lb1.setVisible(true);
			dd.setVisible(true);

		modify2.setLabel("Modify");
			}
		catch(SQLException r)
		{
		System.out.println(r);
		}

		}
	}

	if(e.getSource()==newtrans)
	{
	accno3.setEnabled(true);
	transtype3.setEnabled(true);
	transdt.setEnabled(false);
	transamt.setEnabled(true);
	currbal.setEnabled(false);

		int no=0;
		try
		{
		connect();
		Statement s= c.createStatement();
		ResultSet r=s.executeQuery("select * from transaction"); 			
		while(r.next())
		{
		no=Integer.parseInt(r.getString(6));
		System.out.println(no);
		}
		no=no+1;
		transno.setText(String.valueOf(no));
		java.util.Date dd=new java.util.Date();
		transdt.setText(dd.getDate()+"/"+dd.getMonth()+"/"+dd.getYear());
		}
		catch(SQLException r)
		{
		System.out.println(r);
		}


}

else if(e.getSource()==save3)
{

//System.out.println(accno3.getText()+"-"+st+"-"+transdt.getText()+"-"+ transamt.getText()+"-");
	if(accno3.getText().equals("") || st==0 || transdt.getText().equals("") || transamt.getText().equals(""))
	{
	lb1.setText("Enter all fields");
	lb1.setVisible(true);
	dd.setVisible(true);

	}
	else
{
	st=0;
	try
     {
	connect();
	Statement s1=c.createStatement();
	int cnt=0,balance=0,cnt1=0;
	String actype1="";
		ResultSet r1=s1.executeQuery("select acctype,curr_bal from transaction,member where transaction.accno='"+accno3.getText()+"'");	
		while(r1.next())
		{
		balance=Integer.parseInt(r1.getString(2));
		actype1=r1.getString(1);
		cnt=cnt+1;
		}	
			if(cnt==0)
			{
		System.out.println("enter.........1.");
			 r1=s1.executeQuery("select * from member where accno='"+accno3.getText()+"'");	
				while(r1.next())
				{
				balance=Integer.parseInt(r1.getString(7));
				actype1=String.valueOf(r1.getString(8));
				cnt1++;
				}
			}
		
	if(cnt1==0 && cnt==0)	
	{
		lb1.setText("Invalid Account no");
		lb1.setVisible(true);
		dd.setVisible(true);
	}
	else
	{//for MIN BALANCE
		r1=null;
		r1=s1.executeQuery("select * from accdetails where acctype='"+actype1+"'");
		int no=0;
		while(r1.next())	
		{
		no=Integer.parseInt(r1.getString(2));
		System.out.println(no);
		}
		if(transtype3.getSelectedIndex()==1)
		{		System.out.println("enter..........2");
			if(balance-Integer.parseInt(transamt.getText())<no)
			{
			lb1.setText("U can not withdraw this much amount");
			lb1.setVisible(true);
			dd.setVisible(true);
			}
			else
			{
			System.out.println("enter..........3");
			Statement s12=c.createStatement();	
			currbal.setText(String.valueOf(balance-Integer.parseInt(transamt.getText())));
			int n1=s12.executeUpdate("insert into transaction values('"+accno3.getText()+"','Withdraw','"+transdt.getText()+"','"+transamt.getText()+"','"+currbal.getText()+"','"+transno.getText()+"')");
			System.out.println(n1 +"row inserted");
			}
		}	
		else if(transtype3.getSelectedIndex()==0)
		{
			Statement s13=c.createStatement();	
			currbal.setText(String.valueOf(balance+Integer.parseInt(transamt.getText())));
			int n1=s13.executeUpdate("insert into transaction values('"+accno3.getText()+"','Withdraw','"+transdt.getText()+"','"+transamt.getText()+"','"+currbal.getText()+"','"+transno.getText()+"')");
		}
	
	}
	}	
	catch(SQLException r)
	{
	System.out.println(r);
	}
}
}
else if(e.getSource()==clear3)
	{

	accno3.setEnabled(false);
	transtype3.setEnabled(false);
	transdt.setEnabled(false);
	transamt.setEnabled(false);
	currbal.setEnabled(false);
	accno3.setText("");
	//transtype3.setText("");
	transdt.setText("");
	transamt.setText("");
	currbal.setText("");
	transno.setText("");
	}

else if(e.getSource()==close2)
	{
		p2.setVisible(false);
	}
else if(e.getSource()==close3)
	{
		p3.setVisible(false);
	}
else if(e.getSource()==close4)
	{
		p4.setVisible(false);
	}

else if(e.getSource()==closerp)
{
rp1.setVisible(false);
}
else if(e.getSource()==search)
	{
	if(accnorp.getText().equals(""))
	{
	lb1.setText("Enter Account no.");
	lb1.setVisible(true);
	dd.setVisible(true);
	}
	else
	{
	try
	{
	connect();
	Statement s= c.createStatement();
	ResultSet rr=s.executeQuery("select * from transaction where accno='"+accnorp.getText()+"'");
	System.out.println("found");
	int tno1=0;
	while(rr.next())
	{
		tno1++;
		transrp.add("         "+tno1+"                      "+rr.getString(2)+"                   "+rr.getString(3)+"                       "+rr.getString(4)+"                       "+rr.getString(5));
	}
	if(tno1==0)
	{
	lb1.setText("Account no. not found");
	lb1.setVisible(true);
	dd.setVisible(true);
	}
	}
	catch(SQLException r)
	{
	System.out.println(r);
	}
	}
	}
else if(e.getSource()==login)
	{
		if(usr.getText().equals("") || pwd.getText().equals(""))
		{
		System.out.println(22);
		lb1.setText("Enter user id and password");
		lb1.setVisible(true);
		dd.setVisible(true);
		}
		else if(usr.getText().equals("administrator") && pwd.getText().equals("admin"))
		{
		p1.setVisible(false);
		file.setEnabled(true);
		msearch.setEnabled(true);
		}
		else
		{
		lb1.setText("Invalid user id or password");
		lb1.setVisible(true);
		dd.setVisible(true);

		}
	}

else if(e.getSource()==exit)
	{
		System.exit(0);
	}


}
public static void main(String args[])
{
bank bk=new bank();
bk.setSize(800,800);
bk.setVisible(true);
}
}

