import java.util.*;

public class Attrs{
	String type;
	String listType;
	LinkedList tupleTypes;
	
	String funDomain;
	String funRange;
	
	public Attrs(String type){
		this.type=type;
		this.listType = "";
		this.funDomain = "";
		this.funRange = "";
		this.tupleTypes = new LinkedList();
	}
	
	public Attrs(String type, String domain, String range){
		this.type=type;
		this.listType = "";
		this.funDomain = domain;
		this.funRange = range;
		this.tupleTypes = new LinkedList();
	}
	
	public Attrs(String type, String listType){
		this.type=type;
		this.listType = listType;
		this.funDomain = "";
		this.funRange = "";
		this.tupleTypes = new LinkedList();
	}
	
	public void setListType(String type){
		this.listType = type;
	}
	
	public String getListType(){
		return listType;
	}
	
	public LinkedList getTupleTypes(){
		return tupleTypes;
	}
	
	public String getDomain(){
		return funDomain;
	}
	
	public String getRange(){
		return funRange;
	}
	
	public void addTupletype(String type){
		this.tupleTypes.add(type);
	}

	public String getType(){
		return this.type;
	}
}