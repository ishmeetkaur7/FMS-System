//@author:Shreya Sharma(2015096) Ishmeet Kaur(2015042)
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Staff extends User{
	JFrame frame = new JFrame("Supervisor");JPanel kpanel = new JPanel();JPanel mrpanel = new JPanel();
	JPanel rpanel = new JPanel();JPanel mpanel = new JPanel();
	JPanel panel = new JPanel(new FlowLayout());
	JButton buttons[] = new JButton[6];JPanel leavepanel = new JPanel();
	String name[] = {"Home","Send Leave","Staff","Requests","Reports","Logout"};
	ArrayList<Task> task= new ArrayList<Task>();
	int noTask;
	Staff(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob, int status)
	{
		super(UserName,UserID,Password,name,address,userType,department,dob,status);
	}
	public void readFileTasks()
    {
    BufferedReader br= null;
    try
    {
    br= new BufferedReader(new FileReader("Task.txt"));
    String line=null; 
    while((line=br.readLine())!=null)
    {
	Task mmm= new Task(null,null,0,null,null,null,null,null);
	String lines[]=line.split(";");
	int id =Integer.parseInt(lines[1]);
	String name =lines[0];
	String dept=lines[2];
	String ite=lines[3];
	String dt1=lines[4];
	String dt3=lines[5];
	String purpose=lines[6];
	//ArrayList<String> staff = lines[7];
	//mmm= new Task(dt3,dt1,id,dept,name,ite,purpose,staff);
	task.add(mmm);
    }
	noTask=task.size();
    }catch(FileNotFoundException ex) {ex.printStackTrace();}
    catch(IOException ex) {ex.printStackTrace();}
    finally
    {
    try{if(br!=null) br.close();}
    catch(IOException ex) {ex.printStackTrace();}
    }    
    }
	public void getTaskReport(Task t){
		JFrame ta= new JFrame(t.getTaskName());
		JPanel pa = new JPanel();
		pa.setLayout(new BoxLayout(pa,BoxLayout.Y_AXIS));
		JLabel[] la = new JLabel[8];
		for(int i=0;i<8;i++)
			la[i]= new JLabel();
		la[0].setText("Task Name :  " + t.getTaskName());//
		la[1].setText("Task ID :  " + t.getTaskID());
		la[2].setText("Task Department :  " + t.getTaskDept());
		la[3].setText("Items Used :  " + t.getItems());
		la[4].setText("Task Start Date :  " + t.getStartDate());
		la[5].setText("Task Deadline :  " + t.getDeadline());
		la[6].setText("Task Description :  " + t.getDes());
		la[7].setText("Task Status :  COMPLETE");
		for(int i=0;i<8;i++)
			pa.add(la[i]);
		ta.add(pa);
		ta.setSize(400,200);
		ta.setVisible(true);
	}
	public void staffGUI()
	{
		frame.setSize(600,400);
		mpanel.setLayout(new BoxLayout(mpanel,BoxLayout.Y_AXIS));
	   	mpanel.add(panel);
		String ddate = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
	 	String ttime = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
	 	TextField date = new TextField(ddate);
	   	TextField time = new TextField(ttime);
		frame.setSize(900,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Event e = new Event();
		for(int i=0;i<6;i++){
			buttons[i]= new JButton(name[i]);
			buttons[i].addActionListener(e);
			buttons[i].setActionCommand(name[i]);
			panel.add(buttons[i]);
		}
		buttons[5].setBackground(Color.white);
		panel.add(date);panel.add(time);
		panel.setBackground(null);
		date.setColumns(10);time.setColumns(8);
		date.setEditable(false);time.setEditable(false);
		readFileTasks();
		frame.add(mpanel);
		frame.setVisible(true);
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{if(e.getActionCommand()=="Home"){
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
		if(e.getActionCommand()=="Send Leave"){
			for(int i=0;i<6;i++)
			{if(buttons[i].getText()!="Send Leave")buttons[i].setBackground(null);
			else buttons[i].setBackground(Color.PINK);}
			buttons[5].setBackground(Color.white);
			JFrame Frame1 = new JFrame("Leave Form");
			JLabel jlabel[] = new JLabel[4];
			JTextField txt[] = new JTextField[4];
			
			leavepanel.removeAll();
			leavepanel.revalidate();
			leavepanel.setLayout(new BoxLayout(leavepanel,BoxLayout.Y_AXIS)); leavepanel.setVisible(true); Frame1.setSize(300,500);
			String labelname[] = {"To Whom:","Reason","Frome (DD/MM/YYYY)","To (DD/MM/YYYY)"};
			for(int i=0;i<4;i++)
			{
				jlabel[i] = new JLabel(labelname[i]);
				if(i==0)
					{txt[i]=new JTextField(getDepartment()+" Supervisor");
					txt[i].setEditable(false);}
				else
					{txt[i]=new JTextField(""); 
					txt[i].setColumns(25);}
				leavepanel.add(jlabel[i]);leavepanel.add(txt[i]);
			}
			JButton b= new JButton(); 
			b.setText("Submit");
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
			for(int i=0;i<6;i++)
			{if(buttons[i].getText()!="Staff")buttons[i].setBackground(null);
			else buttons[i].setBackground(Color.PINK);}
			getTaskReport(task.get(3));
		}
		if(e.getActionCommand()=="Requests"){
			for(int i=0;i<6;i++)
			{if(buttons[i].getText()!="Requests")buttons[i].setBackground(null);
			else buttons[i].setBackground(Color.PINK);}
			 JFrame Frame1 = new JFrame("Logistics Request");
				JLabel jlabel[] = new JLabel[3];
				JTextField txt[] = new JTextField[3];
				
				JPanel leavepanel= new JPanel();
				Frame1.add(leavepanel);
				leavepanel.setLayout(new BoxLayout(leavepanel,BoxLayout.Y_AXIS)); leavepanel.setVisible(true); Frame1.setSize(300,500);
				JLabel l1 = new JLabel("To Whom?");JTextField j1 = new JTextField(getDepartment() + "Supervisor");leavepanel.add(l1);leavepanel.add(j1);j1.setEditable(false);
				JLabel l2 = new JLabel("For Which Task?");JTextField j2 = new JTextField("System Generated Task Name and Task ID");leavepanel.add(l2);leavepanel.add(j2);j2.setEditable(false);
				JLabel l3 = new JLabel("Logistics Request ID");JTextField j3 = new JTextField("System Gemerated");leavepanel.add(l3);leavepanel.add(j3);j3.setEditable(false);
				JLabel l4 = new JLabel("Items(Quantities)");JTextField j4 = new JTextField("");leavepanel.add(l4);leavepanel.add(j4);j4.setEditable(true);
				
				JButton b= new JButton(); 
				b.setText("Submit");
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
		if(e.getActionCommand()=="Reports"){
			for(int i=0;i<6;i++)
			{if(buttons[i].getText()!="Reports")buttons[i].setBackground(null);
			else buttons[i].setBackground(Color.PINK);}
		}
		if(e.getActionCommand()=="Logout"){
			frame.remove(panel);
			frame.dispose();
			system S = new system();
			S.noUsers=0;
			S.readFileUsers();
			S.mainGUI();
		}
		
		}
		
		
		
	}
	

}