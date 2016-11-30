class Leave
{
private String to_whom, reason, from, to;
Leave(String to_whom,String reason, String from, String to)
{
this.to_whom=to_whom;
this.reason=reason;
this.from=from;
this.to=to;
}

public String get_to_whom() {return to_whom;}
public String getReason() {return reason;}
public String getFrom() {return from;}
public String getTo() {return to;}

public void set_to_whom(String x) {this.to_whom=x;} 
public void setReason(String x) {this.reason=x;} 
public void setFrom(String x) {this.from=x;} 
public void setTo(String x) {this.to=x;} 

}