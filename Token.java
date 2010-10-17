public class Token {
	protected int type;
	protected String lexeme;
	protected int line;
	
	public Token(int type,String lexeme,int line){
		this.type=type;
		this.lexeme=lexeme;
		this.line=line;
	} 
	
	public int getLine(){
		return this.line;
	}
	
	public int getType(){
		return this.type;
	}
	
	public String getLexeme(){
		return this.lexeme;
	}

}