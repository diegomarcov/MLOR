import java.util.*;

public class Attrs{
	String type;
	Attrs listType;
	ArrayList<Attrs> tupleTypes;
	int politipo=0;
	ArrayList<String> idList;
	
	Attrs funDomain;
	Attrs funRange;
	
	public Attrs(String type){
		idList = new ArrayList<String>();
		this.type=type;
		this.listType = null;
		this.funDomain = null;
		this.funRange = null;
		this.tupleTypes = null;
	}
	
	public Attrs(String type, Attrs domain, Attrs range){ //funcion
		idList = new ArrayList<String>();
		this.type=type;
		this.listType = null;
		this.funDomain = domain;
		this.funRange = range;
		this.tupleTypes = null;
	}
	
	public Attrs(String type, Attrs listType){ //lista
		idList = new ArrayList<String>();
		this.type=type;
		this.listType = listType;
		this.funDomain = null;
		this.funRange = null;
		this.tupleTypes = null;
	}
	
	public Attrs(String type, ArrayList typeList){ //tupla
		idList = new ArrayList<String>();
		this.type=type;
		this.listType = null;
		this.funDomain = null;
		this.funRange = null;
		this.tupleTypes = typeList;
	}
	
	public void agregarID(String s){
		idList.put(s);
	}

	public void deleteInvolvedIDs(){
		idList =new ArrayList<String>();
	}
	public ArrayList<String> getInvolvedIDs(){
		return idList;
	}
	
	public void setPolytype(int p){
		politipo=p;
	}
	
	public int getPolytype(){
		return politipo;
	}
	
	public void setListType(Attrs listType){
		this.listType = listType;
	}
	
	public Attrs getListType(){
		return listType;
	}
	
	public int getTupleLenght(){
		return tupleTypes.size();
	}
	
	public void setDomain(Attrs d){
		funDomain = d;
	}
	
	public Attrs getDomain(){
		return funDomain;
	}
	
	public void setRange(Attrs r){
		funRange = r;
	}
	
	public Attrs getRange(){
		return funRange;
	}
	
	public void setTupleTypes(ArrayList list){
		tupleTypes = list;
	}
		
	public ArrayList getTupleTypes(){
		return tupleTypes;
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
	
	public void setType(String t){
		type = t;
	}

}