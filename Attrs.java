
public class Attrs{
	String type;
	int intValue;
	float floatValue;
	Boolean boolValue;
	
	public Attrs(String type,String value){
		this.type=type;
		this.intValue=0;
		this.boolValue=false;
		if(this.type.compareTo("int")==0)
			this.intValue=Integer.parseInt(value);
		else
			if (this.type.compareTo("float")==0)
				this.floatValue=Float.parseFloat(value);
			else
				this.boolValue=Boolean.parseBoolean(value);
	}

	
	public int getIntValue(){
		return(this.intValue);
	}
	
	public Boolean getBoolValue(){
		return(this.boolValue);
	}
	
	public float getFloatValue(){
		return(this.floatValue);
	}
	
	public float getRealValue(){
	// sobrecargo este procedimiento porque SE
	// que nos vamos a equivocar al llamar a FloatValue =P
		return(this.floatValue);
	}
	
	public String getValue(){
		
		if(this.type.compareTo("int")==0)
			return ""+this.intValue;
		else
			if (this.type.compareTo("float")==0)
				return ""+this.floatValue;
			else
				return ""+this.boolValue;
		
	}
	
	public String getType(){
		return this.type;
	}
		
}