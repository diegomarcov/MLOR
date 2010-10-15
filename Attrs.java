package Proyecto;

public class Attrs{
	String type;
	int intValue;
	Boolean boolValue;
	
	public Attrs(String type,String value){
		this.type=type;
		this.intValue=0;
		this.boolValue=false;
		if(this.type.compareTo("int")==0 || this.type.compareTo("draw")==0)
			this.intValue=Integer.parseInt(value);
		else
			{
				this.boolValue=Boolean.parseBoolean(value);
			}
	}
	

	
	public int getIntValue(){
		return(this.intValue);
	}
	
	public Boolean getBoolValue(){
		return(this.boolValue);
	}
	
	public String getValue(){
		
		if(this.type.compareTo("boolean")==0)
			return(this.boolValue+"");
		else
			return(this.intValue+"");
		
	}
	
	public String getType(){
		return this.type;
	}
		


}