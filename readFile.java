class readfile
{
	
	public void readFile(String namee)
    {
    BufferedReader br= null;
    try
    {
    br= new BufferedReader(new FileReader(namee));
    String line=null; 
    while((line=br.readLine())!=null)
    {
	User mmm= new User(null,0,null,null,null,null,null,null);
	String lines[]=line.split(",");
	int id =Integer.parseInt(lines[0]);
	String name =lines[1];
	String dob=lines[2];
	String addr=lines[3];
	String type=lines[4];
	String dept=lines[5];
	String username=lines[6];
	String pass =lines[7];
	if(type.equals("admin"))
		mmm= new Admin(username,id,pass,name,addr,type,dept,dob);
	else if(type.equals("supervisor"))
		mmm= new Supervisor(username,id,pass,name,addr,type,dept,dob);
	else if(type.equals("staff"))
		mmm= new Staff(username,id,pass,name,addr,type,dept,dob);
	users.add(mmm);
    }
	noUsers=users.size();
    }catch(FileNotFoundException ex) {ex.printStackTrace();}
    catch(IOException ex) {ex.printStackTrace();}
    finally
    {
    try{if(br!=null) br.close();}
    catch(IOException ex) {ex.printStackTrace();}
    }    
    }
}