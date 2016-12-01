//@author:Shreya Sharma(2015096) Ishmeet Kaur(2015042)
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Staff extends User{
	JFrame frame = new JFrame("Supervisor");JPanel kpanel = new JPanel();JPanel mrpanel = new JPanel();
	JPanel rpanel = new JPanel();JPanel mpanel = new JPanel();
	JPanel panel = new JPanel(new FlowLayout());
	JButton buttons[] = new JButton[6];JPanel leavepanel = new JPanel();
	String name[] = {"Home","Send Leave","Tasks","Logout"};
	String nameleave= this.getUserName();
	String name3= this.getDepartment()+ " Supervisor";
	ArrayList<Task> task= new ArrayList<Task>();
	ArrayList<Leave> leave= new ArrayList<Leave>();
	int noTask;
	Staff(String UserName,int UserID, String Password, String name, String address, String userType,String department, String dob, int status)
	{
		super(UserName,UserID,Password,name,address,userType,department,dob,status);
	}
	public String getNames(int i)
	{
		return leave.get(i).getWhose();
	}
	
	public int getSizeLeave()
	{
		return leave.size();
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
	public  ArrayList<String[]> readFileDept(String dept)
    {
		    BufferedReader br= null;
		    ArrayList<String[]> arr = new ArrayList<String[]>();
		    try
		    {
		    	
		    br= new BufferedReader(new FileReader("Task.txt"));
		    String line=null; 
		    while((line=br.readLine())!=null)
		    {
			
			String lines[]=line.split(";");
			if(lines[2].equals(dept))
				arr.add(lines);
				
		    }
		    
		    }catch(FileNotFoundException ex) {ex.printStackTrace();}
		    catch(IOException ex) {ex.printStackTrace();}
		    
		    finally
		    {
		    	
		    try{if(br!=null) br.close();}
		    catch(IOException ex) {ex.printStackTrace();}
		    }
		    System.out.println(arr.size());
		    return arr;
    }
	
	public  ArrayList<String[]> readFile()
	    {
	    BufferedReader br= null;
	    ArrayList<String[]> arr = new ArrayList<String[]>();
	    try
	    {
    	
	    br= new BufferedReader(new FileReader("Task.txt"));
	    String line=null; 
	    while((line=br.readLine())!=null)
	    {
		
		String lines[]=line.split(";");
		arr.add(lines);
			
	    }
	    
	    }catch(FileNotFoundException ex) {ex.printStackTrace();}
	    catch(IOException ex) {ex.printStackTrace();}
	    
	    finally
	    {
	    	
	    try{if(br!=null) br.close();}
	    catch(IOException ex) {ex.printStackTrace();}
	    }
	    System.out.println(arr.size());
	    return arr;
    }
	
	public void getTaskReport(String[] str){
		JFrame ta= new JFrame(str[0]);
		JPanel pa = new JPanel();
		System.out.println("YES");
		pa.setLayout(new BoxLayout(pa,BoxLayout.Y_AXIS));
		JLabel[] la = new JLabel[9];
		for(int i=0;i<9;i++)
			la[i]= new JLabel();
		la[0].setText("Task Name :  " + str[0]);//
		la[1].setText("Task ID :  " +str[1]);
		la[2].setText("Task Department :  " + str[2]);
		la[3].setText("Items Used :  " + str[3]);
		la[4].setText("Task Start Date :  " + str[4]);
		la[5].setText("Task Deadline :  " + str[5]);
		la[6].setText("Task Description :  " +str[6]);
		la[7].setText("Task Status :  "+str[7]);
		la[8].setText("Task Staff :  "+str[8]);
		for(int i=0;i<9;i++)
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
		for(int i=0;i<4;i++){
			buttons[i]= new JButton(name[i]);
			buttons[i].addActionListener(e);
			buttons[i].setActionCommand(name[i]);
			panel.add(buttons[i]);
		}
		buttons[3].setBackground(Color.white);
		panel.add(date);panel.add(time);
		panel.setBackground(null);
		date.setColumns(10);time.setColumns(8);
		date.setEditable(false);time.setEditable(false);
		frame.add(mpanel);
		frame.setVisible(true);
	}
	public class Event implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{if(e.getActionCommand()=="Home"){
			for(int i=0;i<4;i++)
			{if(buttons[i].getText()!="Home")buttons[i].setBackground(null);
			else buttons[i].setBackground(Color.PINK);}
			buttons[3].setBackground(Color.white);
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
			for(int i=0;i<4;i++)
			{if(buttons[i].getText()!="Send Leave")buttons[i].setBackground(null);
			else buttons[i].setBackground(Color.PINK);}
			buttons[3].setBackground(Color.white);
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
		
		if(e.getActionCommand()=="Tasks"){
			for(int i=0;i<4;i++)
			{if(buttons[i].getText()!="Staff")buttons[i].setBackground(null);
			else buttons[i].setBackground(Color.PINK);}
			buttons[3].setBackground(Color.white);
			rpanel.removeAll();
			rpanel.revalidate();
			kpanel.removeAll();
			kpanel.revalidate();
			rpanel.setLayout(new BoxLayout(rpanel,BoxLayout.Y_AXIS));
			ArrayList<String[]> arr = new ArrayList<String[]>();
			arr=readFile();
			System.out.println(arr.size());
			for(int i=0;i<arr.size();i++)
				System.out.println(arr.get(i)[0]);
			for(int i=0;i<arr.size();i++)
			{
				System.out.println("ec");
				JLabel y = new JLabel(arr.get(i)[0]);
				JButton j1 = new JButton("Generate Task Report");
				JButton j2= new JButton("Update Task Status");
				JButton j3= new JButton("Send Logistics Request");
				JPanel pan = new JPanel();
				pan.add(y);pan.add(j1);pan.add(j2);pan.add(j3);
				rpanel.add(pan);int k = arr.size();
				String[] gt = arr.get(i);int index = i;
				j1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						getTaskReport(gt);
					}
				});
				j2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						Object[] options = {"ONGOING","COMPLETE"};
						int n = JOptionPane.showOptionDialog(frame,"Update"+ "Status",gt[0],JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
						if(n==JOptionPane.YES_OPTION){gt[7]="ONGOING";}
						if(n==JOptionPane.NO_OPTION){gt[7]="COMPLETE";}	
						updateFile(gt[7],gt[1]);
					}
				});
				j3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//code for view
						 JFrame Frame1 = new JFrame("Logistics Request");
							JLabel jlabel[] = new JLabel[3];
							JTextField txt[] = new JTextField[3];
							
							JPanel leavepanel= new JPanel();
							Frame1.add(leavepanel);
							leavepanel.setLayout(new BoxLayout(leavepanel,BoxLayout.Y_AXIS)); leavepanel.setVisible(true); 					Frame1.setSize(300,500);
							JLabel l1 = new JLabel("To Whom?");JTextField j1 = new JTextField(getDepartment() + 					"Supervisor");leavepanel.add(l1);leavepanel.add(j1);j1.setEditable(false);
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
				});
				
				
			}
			mpanel.add(rpanel);
			frame.setVisible(true);
			
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
		public void updateFile(String y,String u) 
		{
			ArrayList<String[]> arr = new ArrayList<String[]>();
			arr=readFile();
			System.out.print(arr.size());
			try
			{
			FileWriter fr= new FileWriter("Task.txt",false);
			BufferedWriter br= new BufferedWriter(fr);
			PrintWriter out= new PrintWriter(br);
			for(int l=0;l<arr.size();l++)
			{
				System.out.print(l);
					out.write(arr.get(l)[0]+";");
					out.write(arr.get(l)[1]+";");
					out.write(arr.get(l)[2]+";");
					out.write(arr.get(l)[3]+";");
					out.write(arr.get(l)[4]+";");
					out.write(arr.get(l)[5]+";");
					out.write(arr.get(l)[6]+";");
					if(arr.get(l)[1].equals(u))
						out.write(y+";");
					else
						out.write(arr.get(l)[7]+";");
					out.write(arr.get(l)[8]);
					out.write("\n");
				
				}out.close();}
			
				catch(Exception E)
				{E.printStackTrace();}}}}
	

