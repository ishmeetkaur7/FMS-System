//@author:Shreya Sharma(2015096) Ishmeet Kaur(2015042)
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;
//Task Report – ID, Task ID, Task Name, Task Description, Items used, Time Taken,
//Comments.
public class Task {
	private String Deadline, StartDate;
	private int TaskID;
	private String TaskDept,TaskName,Items,Des;
	String staff;
	public enum TaskStatus { COMPLETE,  NOT_STARTED, ONGOING } ;
	Task(String Deadline,String StartDate,int TaskID, String TaskDept,String TaskName,String Items,String Des,String staff){
		this.Deadline=Deadline;
		this.StartDate=StartDate;
		this.TaskID=TaskID;
		this.TaskDept=TaskDept;
		this.TaskName=TaskName;
		this.Items = Items;
		this.Des = Des;
		this.staff=staff;
	}
	public void setTaskName(String Name)
	{
		this.TaskName=Name;
	}
	public void setDeadline(String String)
	{
		this.Deadline=String;
	}
	public void setStartDate(String String)
	{
		this.StartDate=String;
	}
	public void setTaskID(int t)
	{
		this.TaskID=t;
	}
	public void setTaskDept(String t)
	{
		this.TaskDept=t;
	}
	public String getTaskName()
	{
		return TaskName;
	}
	public String getDeadline()
	{
		return Deadline;
	}
	public void setItems(String t){
		this.Items = t;
	}
	public String getStartDate()
	{
		return StartDate;
	}
	public int getTaskID()
	{
		return TaskID;
	}
	public String getTaskDept()
	{
		return TaskDept;
	}
	public String getItems() {
		// TODO Auto-generated method stub
		return Items;
	}
	public String getDes() {
		// TODO Auto-generated method stub
		return Des;
	}public void setDes(String y) {
		// TODO Auto-generated method stub
		this.Des = y;
	}
	public void WriteFile(String n,String d,String i, String st,String de,String p,String stf)
	{
		try
		{
		FileWriter fr= new FileWriter("Task.txt",true);
		BufferedWriter br= new BufferedWriter(fr);
		PrintWriter out= new PrintWriter(br);
			Random r = new Random();
			int id = r.nextInt(1000);
			out.write(n+";");
			out.write(id+";");
			out.write(d +";");
			out.write(i +";");
			out.write(st +";");
			out.write(de +";");
			out.write(p +";");
			out.write("NOT_STARTED"+";");
			out.write(stf);
			out.write("\n");
		out.close();
		}
		catch(Exception e)
		{e.printStackTrace();}
		
	}
}//Task Report – ID, Task ID, Task Name, Task Description, Items used, Time Taken,
//Comments.