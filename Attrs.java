import java.util.*;

public class Attrs{
	String type;
	Attrs listType;
	ArrayList<Attrs> tupleTypes;
	
	Attrs funDomain;
	Attrs funRange;
	
	public Attrs(String type){
		this.type=type;
		this.listType = null;
		this.funDomain = null;
		this.funRange = null;
		this.tupleTypes = null;
	}
	
	public Attrs(String type, Attrs domain, Attrs range){
		this.type=type;
		this.listType = null;
		this.funDomain = domain;
		this.funRange = range;
		this.tupleTypes = null;
	}
	
	public Attrs(String type, Attrs listType){
		this.type=type;
		this.listType = listType;
		this.funDomain = null;
		this.funRange = null;
		this.tupleTypes = null;
	}
	
	public Attrs(String type, ArrayList typeList){
		this.type=type;
		this.listType = null;
		this.funDomain = null;
		this.funRange = null;
		this.tupleTypes = typeList;
	}
	
	public void setListType(Attrs listType){
		this.listType = listType;
	}
	
	public Attrs getListType(){
		return listType;
	}
	
	public ArrayList getTupleTypes(){
		return tupleTypes;
	}
	
	public Attrs getDomain(){
		return funDomain;
	}
	
	public Attrs getRange(){
		return funRange;
	}
	
	public void addTupleTypeBegin(Attrs type){
		this.tupleTypes.add(0,type);
	}
	
	public void addTupleTypeFinal(Attrs type){
		this.tupleTypes.add(type);
	}

	public String getType(){
		return this.type;
	}
	

}