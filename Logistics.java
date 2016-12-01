class Logistics
{
private String to_whom, task, items;
private int id,statusS,statusA;
//items are comma seperated.

Logistics(String to_whom,String task,String items,int id, int statusS, int statusA)
{
	this.to_whom=to_whom;
	this.task=task;
	this.id=id;
	this.items=items;
	this.statusS=statusS;
	this.statusA=statusA;
}

public String get_to_whom() {return to_whom;} 
public String getTask() {return task;} 
public String getItems() {return items;} 
public int getID() {return id;} 
public int getstatusS() {return statusS;} 
public int getStatusA() {return statusA;} 

public void set_to_whom(String x) {this.to_whom=x;}
public void setTask(String x) {this.task=x;}
public void setItems(String x) {this.items=x;}
public void setID(int x) {this.id=x;}
public void statusS(int x) {this.statusS=x;}
public void setstatusA(int x) {this.statusA=x;}

}