//@author:Shreya Sharma(2015096) Ishmeet Kaur(2015042)
import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class Supervisor extends User {
	JFrame frame = new JFrame("FMS System : Supervisor "+this.getDepartment());
	JPanel mpanel = new JPanel();JPanel kpanel = new JPanel();JPanel mrpanel = new JPanel();
	JPanel rpanel = new JPanel();JPanel leavepanel = new JPanel();
	JPanel panel = new JPanel(new FlowLayout());
	JButton buttons[] = new JButton[6];
	String name[] = {"Home","Send Leave","Staff","Requests","Reports","Logout"};
	String dname[] = {"Electricity","HVAC","Audio/Video","Security","Housekeeping"};
	JButton b1 = new JButton("Member Requests"); JButton b2 = new JButton("Leave Requests"); JButton b3 = new JButton("Logistics Requests");
	Supervisor(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob, int status)
	{
		super(UserName,UserID,Password,name,address,userType,department,dob,status);
	}
	public void supGUI()
	{
		mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.Y_AXIS));
	   	mpanel.add(panel);
		frame.setSize(900,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String ddate = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	 	String ttime = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
	 	TextField date = new TextField(ddate);
	   	TextField time = new TextField(ttime);
		panel.setVisible(true);
		
		Event e = new Event();
		for(int i=0;i<6;i++){
			buttons[i] =new JButton(name[i]);
			buttons[i].addActionListener(e);
			buttons[i].setActionCommand(name[i]);
			panel.add(buttons[i]);
		}
		buttons[5].setBackground(Color.white);
		panel.add(date);panel.add(time);
		date.setColumns(10);time.setColumns(8);
		date.setEditable(false);time.setEditable(false);
		//frame.add(panel);
		frame.add(mpanel);
		frame.setVisible(true);
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("Home")){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Home")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				buttons[5].setBackground(Color.white);
				kpanel.removeAll();
				kpanel.revalidate();
				rpanel.removeAll();
				rpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				JLabel[] jlabel = new JLabel[6];
				for(int i=0;i<6;i++)
				{
					jlabel[i]= new JLabel();
					rpanel.add(jlabel[i]);
				}
				//rpanel.setBackground(Color.pink);
				rpanel.add(kpanel);
				
				mpanel.add(rpanel);
				jlabel[0].setText("Name : "+ getName());
				jlabel[1].setText("Username : "+ getUserName());
				jlabel[2].setText("Address : "+ getAddress());
				jlabel[3].setText("Department : "+ getDepartment());
				jlabel[4].setText("Date of Birth : "+ getDOB());
				jlabel[5].setText("User ID : "+ getUserID());
				frame.setVisible(true);
			}
			if(e.getActionCommand().equals("Send Leave")){
				ArrayList<Leave> leave= new ArrayList<Leave>();
				
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Send Leave")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				buttons[5].setBackground(Color.white);
				JFrame Frame1 = new JFrame("Leave Form");
				JLabel jlabel[] = new JLabel[4];
				JTextField txt[] = new JTextField[4];
				leavepanel.removeAll();
				leavepanel.revalidate();
				Frame1.add(leavepanel);
				leavepanel.setLayout(new BoxLayout(leavepanel,BoxLayout.Y_AXIS)); leavepanel.setVisible(true); Frame1.setSize(300,500);
				String labelname[] = {"To Whom:","Reason","Frome (DD/MM/YYYY)","To (DD/MM/YYYY)"};
				for(int i=0;i<4;i++)
				{
					jlabel[i] = new JLabel(labelname[i]);
					if(i==0)
						{txt[i]=new JTextField("Admin");
						txt[i].setEditable(false);}
					else
						{txt[i]=new JTextField(""); 
						txt[i].setColumns(25);}
					leavepanel.add(jlabel[i]);leavepanel.add(txt[i]);
				}
				JButton b= new JButton(); 
				b.setText("Submit");
				Leave mmm = new Leave(txt[0].getText(),txt[1].getText(),txt[2].getText(),txt[3].getText());
				leave.add(mmm);
				System.out.println(leave.get(0).get_to_whom());
				leavepanel.add(b);
				Frame1.add(leavepanel);
				Frame1.setVisible(true);
				frame.setVisible(false);
				
				b.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e){
						Frame1.setVisible(false);
						frame.setVisible(true);
					}});
				
				
			}	
			
			if(e.getActionCommand()=="Staff"){
				for(int i=0;i<5;i++)
				{if(buttons[i].getText()=="Staff")buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				buttons[5].setBackground(Color.white);
				rpanel.removeAll();
				rpanel.revalidate();kpanel.removeAll();
				kpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				ArrayList<String> names = new ArrayList<String>(); 
				ArrayList<String> info= new ArrayList<String>();
				ArrayList<Integer> index= new ArrayList<Integer>();
				system s= new system();
				int x=s.getRequests().size(); int i;
				for( i=0;i<x;i++)
				{
					System.out.println(i);
					if(s.getReq(i)==1 && s.getUserType(i).equals("staff")) {names.add(s.getName(i));info.add(s.getInfo(i)); index.add(i); }
				}				
				for( i=0;i<names.size();i++)
				{
					JPanel lpanel = new JPanel();JButton a = new JButton("Delete");
					JButton v = new JButton("View");
					JLabel t = new JLabel(names.get(i));v.addActionListener(new Event());
					lpanel.add(t);a.setBackground(Color.red);
					String str= info.get(i);
					v.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							String[] line = str.split(",",-1);
							JFrame ta= new JFrame(line[0]);
							JPanel pa = new JPanel();
							pa.setLayout(new BoxLayout(pa,BoxLayout.Y_AXIS));
							JLabel[] la = new JLabel[8];
							for(int i=0;i<6;i++)
								la[i]= new JLabel();
							la[0].setText("Username :  " + line[0]);//
							la[1].setText("Name :  " + line[1]);
							la[2].setText("Address :  " + line[2]);
							la[3].setText("UserType :  " + line[3]);
							la[4].setText("Department :  " +line[4]);
							la[5].setText("DOB :  " + line[5]);
							for(int i=0;i<6;i++)
								pa.add(la[i]);
							ta.add(pa);
							ta.setSize(400,200);
							ta.setVisible(true);
						}
					});	
					int chu= index.get(i); String y=names.get(i);
					a.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							JOptionPane.showMessageDialog(null, "Deleted");
							t.setText(y+ " deleted.");
							System.out.println(t.getText());
							a.setVisible(false); v.setVisible(false);
							s.removeUser(chu);
						}
					});
					lpanel.add(a);a.setActionCommand("delete");v.setBackground(Color.CYAN);
					a.addActionListener(new Event());
					lpanel.add(v);v.setActionCommand("view");
					rpanel.add(lpanel);
				}
				mpanel.add(rpanel);
				frame.setVisible(true);
			
				 }
			if(e.getActionCommand().equals("Requests")){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Requests")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				b1.setActionCommand("Member Requests");
				b2.setActionCommand("Leave Requests");
				b3.setActionCommand("Logistics Request");
				b1.addActionListener(new Event());
				b2.addActionListener(new Event());
				b3.addActionListener(new Event());
				b2.setBackground(null);
				b1.setBackground(null);
				b3.setBackground(null);
				rpanel.removeAll();
				rpanel.revalidate();
				kpanel.removeAll();
				kpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<5;i++)
				{if(buttons[i].getText().equals("Requests"))buttons[i].setBackground(Color.pink);
				else buttons[i].setBackground(null);}
				kpanel.add(b1);kpanel.add(b2);kpanel.add(b3);
				buttons[5].setBackground(Color.white);
				
				rpanel.add(kpanel);
				
				mpanel.add(rpanel);
				frame.setVisible(true);
			}			
			if(e.getActionCommand().equals("Reports")){
				for(int i=0;i<6;i++)
				{if(buttons[i].getText()!="Reports")buttons[i].setBackground(null);
				else buttons[i].setBackground(Color.PINK);}
				buttons[5].setBackground(Color.white);
				rpanel.removeAll();
				rpanel.revalidate();kpanel.removeAll();
				kpanel.revalidate();
				rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
				rpanel.add(kpanel);
				mpanel.add(rpanel);
				frame.setVisible(true);
				
				
			}
			if(e.getActionCommand().equals("Logout")){
				frame.remove(panel);
				frame.dispose();
				system S = new system();
				S.noUsers=0;
				S.readFileUsers();
				S.mainGUI();
			}
			if(e.getActionCommand().equals("Member Requests")){
				b1.setBackground(Color.pink);
				b2.setBackground(null);
				b3.setBackground(null);
				mrpanel.removeAll();
				mrpanel.revalidate();
				kpanel.removeAll();
				kpanel.revalidate();
				mrpanel.setLayout(new BoxLayout(mrpanel,BoxLayout.Y_AXIS));
								system s=new system();
				
				//System.out.println("here" + s.getRequests().size());
				int i,f;
				ArrayList<String> arr = new ArrayList<String>(); 
				ArrayList<String> info= new ArrayList<String>();
				ArrayList<Integer> index= new ArrayList<>();
				 ArrayList<Integer> status= new ArrayList<>();
				int x=s.getRequests().size();
				for( i=0;i<x;i++)
				{
					System.out.println(i);
					if(s.getReq(i)==-1) {arr.add(s.getName(i)); info.add(s.getInfo(i)); index.add(i); status.add(-1);}
				}
				System.out.println(arr.size());
				 for( i=0;i<arr.size();i++)
				 {
					JPanel lpanel = new JPanel();JButton a = new JButton("Approve");
					JButton r = new JButton("Reject");JButton v = new JButton("view");	
					String y=arr.get(i); JLabel t = new JLabel(y);
					String str= info.get(i);
					v.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							String[] line = str.split(",",-1);
							JFrame ta= new JFrame(line[0]);
							JPanel pa = new JPanel();
							pa.setLayout(new BoxLayout(pa,BoxLayout.Y_AXIS));
							JLabel[] la = new JLabel[8];
							for(int i=0;i<6;i++)
								la[i]= new JLabel();
							la[0].setText("Username :  " + line[0]);//
							la[1].setText("Name :  " + line[1]);
							la[2].setText("Address :  " + line[2]);
							la[3].setText("UserType :  " + line[3]);
							la[4].setText("Department :  " +line[4]);
							la[5].setText("DOB :  " + line[5]);
							for(int i=0;i<6;i++)
								pa.add(la[i]);
							ta.add(pa);
							ta.setSize(400,200);
							ta.setVisible(true);
						}
					});			
					int chu= index.get(i);
					a.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							JOptionPane.showMessageDialog(null, "Approved");
							t.setText(y+ " approved.");
							System.out.println(t.getText());
							a.setVisible(false); r.setVisible(false); v.setVisible(false);
							s.setUserStatus(chu);
						}
					});
					
					r.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							JOptionPane.showMessageDialog(null, "Rejected");
							t.setText(y+ " rejected.");
							System.out.println(t.getText());
							a.setVisible(false); r.setVisible(false); v.setVisible(false);
							s.removeUser(chu);
						}
					});
										
					lpanel.add(t);a.setBackground(Color.green);r.setBackground(Color.red);
					lpanel.add(a);a.setActionCommand("approve");v.setBackground(Color.CYAN);
					lpanel.add(r);r.setActionCommand("reject");
					lpanel.add(v);v.setActionCommand("view");
					mrpanel.add(lpanel);
				 }
				rpanel.add(mrpanel);
				frame.setVisible(true);
			
			}
			if(e.getActionCommand().equals("Leave Requests")){
				b2.setBackground(Color.pink);
				b1.setBackground(null);
				b3.setBackground(null);
				mrpanel.removeAll();
				mrpanel.revalidate();
				
				mrpanel.setLayout(new BoxLayout(mrpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<5;i++)
				{
					JPanel lpanel = new JPanel();JButton a = new JButton("Approve");
					JButton r = new JButton("Reject");JButton v = new JButton("view");
					JLabel t = new JLabel("Will you dance ?");v.addActionListener(new Event());
					lpanel.add(t);a.setBackground(Color.green);r.setBackground(Color.red);
					lpanel.add(a);a.setActionCommand("approve");v.setBackground(Color.CYAN);
					lpanel.add(r);r.setActionCommand("reject");a.addActionListener(new Event());
					lpanel.add(v);v.setActionCommand("view");r.addActionListener(new Event());
					mrpanel.add(lpanel);
				}
				rpanel.add(mrpanel);
				frame.setVisible(true);
				}
			if(e.getActionCommand().equals("Logistics Request")){
				b3.setBackground(Color.pink);
				b1.setBackground(null);
				b2.setBackground(null);
				mrpanel.removeAll();
				mrpanel.revalidate();
				mrpanel.setLayout(new BoxLayout(mrpanel,BoxLayout.Y_AXIS));
				for(int i=0;i<3;i++)
				{
					JPanel lpanel = new JPanel();JButton a = new JButton("Approve");
					JButton r = new JButton("Reject");JButton v = new JButton("view");
					JLabel t = new JLabel("please lets go out?");
					lpanel.add(t);a.setBackground(Color.green);r.setBackground(Color.red);
					lpanel.add(a);a.setActionCommand("approve");v.setBackground(Color.CYAN);
					lpanel.add(r);r.setActionCommand("reject");
					lpanel.add(v);v.setActionCommand("view");
					mrpanel.add(lpanel);
				}
				rpanel.add(mrpanel);
				frame.setVisible(true);
			}
			if(e.getActionCommand()=="approve"){
				
				}
			if(e.getActionCommand()=="reject"){
				
				}
			if(e.getActionCommand()=="view"){
				
			}
			
	}
}
}