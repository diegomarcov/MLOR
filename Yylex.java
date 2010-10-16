import java_cup.runtime.Symbol;


class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NOT_ACCEPT,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NOT_ACCEPT,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NOT_ACCEPT,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NOT_ACCEPT,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"35:9,38,39,35,38,39,35:18,17,35,34,35:5,27,28,16,8,4,9,1,15,33:10,7,2,5,3,6" +
",35:2,23,36:2,19,12,31,36:2,20,36:2,13,22,24,10,36:2,11,14,25,32,21,36:4,29" +
",35,30,18,37,35,23,36:2,19,12,31,36:2,20,36:2,13,22,24,10,36:2,11,14,25,32," +
"21,36:4,35:3,26,35,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,65,
"0,1:5,2,3,4,1:2,5,1:2,6,1:6,7,1:4,8,9:6,10,9,1,10,8,11,8,1,12,13,14,15,16,1" +
"7,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,9,34")[0];

	private int yy_nxt[][] = unpackFromString(35,40,
"1,2,3,4,5,6,7,8,9,10,11,63:4,12,13,14,15,50,63,51,52,64,53,63,16,17,18,19,2" +
"0,54,63,21,37,40,63,40,14:2,-1:43,22,-1:2,23,-1:36,24,-1:43,25,-1:42,63,61," +
"63:3,-1:4,63:7,-1:5,63:3,-1:2,63:2,-1:19,14,-1:20,14:2,-1,36,-1:31,21,-1:7," +
"39:33,26,39:4,-1:11,63:5,-1:4,63:7,-1:5,63:3,-1:2,63:2,-1:35,33,-1:16,63:5," +
"-1:4,63:2,27,63:4,-1:5,63:3,-1:2,63:2,-1:12,63:3,28,63,-1:4,63:7,-1:5,63:3," +
"-1:2,63:2,-1:18,44,-1:33,63:5,-1:4,29,63:6,-1:5,63:3,-1:2,63:2,-1:19,35,-1:" +
"32,63:5,-1:4,63:6,30,-1:5,63:3,-1:2,63:2,-1:12,63:3,31,63,-1:4,63:7,-1:5,63" +
":3,-1:2,63:2,-1:12,63:5,-1:4,63:5,32,63,-1:5,63:3,-1:2,63:2,-1:12,63:5,42,-" +
"1:3,63:7,-1:5,63:3,-1:2,63:2,-1:12,34,63:4,-1:4,63:7,-1:5,63:3,-1:2,63:2,-1" +
":12,63:5,-1:4,63,38,63:5,-1:5,63:3,-1:2,63:2,-1:12,63:5,-1:4,63:4,41,63:2,-" +
"1:5,63:3,-1:2,63:2,-1:12,43,63:4,-1:4,63:7,-1:5,63:3,-1:2,63:2,-1:12,45,63:" +
"4,-1:4,63,46,63:5,-1:5,63:3,-1:2,63:2,-1:12,63:5,-1:4,63:7,-1:5,63,47,63,-1" +
":2,63:2,-1:12,63:2,48,63:2,-1:4,63:7,-1:5,63:3,-1:2,63:2,-1:12,63:4,49,-1:4" +
",63:7,-1:5,63:3,-1:2,63:2,-1:12,63:4,55,-1:4,63:7,-1:5,63:3,-1:2,63:2,-1:12" +
",63:3,56,63,-1:4,63:7,-1:5,63:3,-1:2,63:2,-1:12,63:3,57,63,-1:4,63:7,-1:5,6" +
"3:3,-1:2,63:2,-1:12,63:5,-1:4,63:4,58,63:2,-1:5,63:3,-1:2,63:2,-1:12,63:2,5" +
"9,63:2,-1:4,63:7,-1:5,63:3,-1:2,63:2,-1:12,63:5,-1:4,60,63:6,-1:5,63:3,-1:2" +
",63:2,-1:12,63:5,-1:4,63:5,62,63,-1:5,63:3,-1:2,63:2,-1:2");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException, Exception

		{
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ return new Symbol(sym.PUNTO, new Token(sym.PUNTO, yytext(), yyline+1));}
					case -3:
						break;
					case 3:
						{ return new Symbol(sym.PTOCOMA, new Token(sym.PTOCOMA, yytext(), yyline+1));}
					case -4:
						break;
					case 4:
						{ return new Symbol(sym.IGUAL);}
					case -5:
						break;
					case 5:
						{ return new Symbol(sym.COMA, new Token(sym.COMA, yytext(), yyline+1));}
					case -6:
						break;
					case 6:
						{ return new Symbol(sym.MENOR, new Token(sym.MENOR, yytext(), yyline+1));}
					case -7:
						break;
					case 7:
						{ return new Symbol(sym.MAYOR, new Token(sym.MAYOR, yytext(), yyline+1));}
					case -8:
						break;
					case 8:
						{ throw new Exception("Error léxico: "+yytext()+" en línea "+(yyline+1)); }
					case -9:
						break;
					case 9:
						{ return new Symbol(sym.SUMA, new Token(sym.SUMA, yytext(), yyline+1));}
					case -10:
						break;
					case 10:
						{ return new Symbol(sym.RESTA, new Token(sym.RESTA, yytext(), yyline+1));}
					case -11:
						break;
					case 11:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -12:
						break;
					case 12:
						{ return new Symbol(sym.DIVREAL, new Token(sym.DIVREAL, yytext(), yyline+1));}
					case -13:
						break;
					case 13:
						{ return new Symbol(sym.MUL, new Token(sym.MUL, yytext(), yyline+1));}
					case -14:
						break;
					case 14:
						{ /* ignora espacios en blanco. */ }
					case -15:
						break;
					case 15:
						{ return new Symbol(sym.CONCAT, new Token(sym.CONCAT, yytext(), yyline+1));}
					case -16:
						break;
					case 16:
						{ return new Symbol(sym.MINUS, new Token(sym.MINUS, yytext(), yyline+1));}
					case -17:
						break;
					case 17:
						{ return new Symbol(sym.PARABRE, new Token(sym.PARABRE, yytext(), yyline+1));}
					case -18:
						break;
					case 18:
						{ return new Symbol(sym.PARCIERRA, new Token(sym.PARCIERRA, yytext(), yyline+1));}
					case -19:
						break;
					case 19:
						{ return new Symbol(sym.CORABRE, new Token(sym.CORABRE, yytext(), yyline+1));}
					case -20:
						break;
					case 20:
						{ return new Symbol(sym.CORCIERRA, new Token(sym.CORCIERRA, yytext(), yyline+1));}
					case -21:
						break;
					case 21:
						{ return new Symbol(sym.INT,new Integer(yytext()));}
					case -22:
						break;
					case 22:
						{ return new Symbol(sym.MENORIGUAL, new Token(sym.MENORIGUAL, yytext(), yyline+1));}
					case -23:
						break;
					case 23:
						{ return new Symbol(sym.DISTINTO, new Token(sym.DISTINTO, yytext(), yyline+1));}
					case -24:
						break;
					case 24:
						{ return new Symbol(sym.MAYORIGUAL, new Token(sym.MAYORIGUAL, yytext(), yyline+1));}
					case -25:
						break;
					case 25:
						{ return new Symbol(sym.CONS, new Token(sym.CONS, yytext(), yyline+1));}
					case -26:
						break;
					case 26:
						{ return new Symbol(sym.STRING, yytext());}
					case -27:
						break;
					case 27:
						{ return new Symbol(sym.DIVINT, new Token(sym.DIVINT, yytext(), yyline+1));}
					case -28:
						break;
					case 28:
						{ return new Symbol(sym.VAL, new Token(sym.VAL, yytext(), yyline+1));}
					case -29:
						break;
					case 29:
						{ return new Symbol(sym.MOD, new Token(sym.MOD, yytext(), yyline+1));}
					case -30:
						break;
					case 30:
						{ return new Symbol(sym.NOT, new Token(sym.NOT, yytext(), yyline+1));}
					case -31:
						break;
					case 31:
						{ return new Symbol(sym.NIL, new Token(sym.NIL, yytext(), yyline+1));}
					case -32:
						break;
					case 32:
						{ return new Symbol(sym.FUN, new Token(sym.FUN, yytext(), yyline+1));}
					case -33:
						break;
					case 33:
						{ return new Symbol(sym.REAL,new Float(yytext()));}
					case -34:
						break;
					case 34:
						{ return new Symbol(sym.ANDALSO, new Token(sym.ANDALSO, yytext(), yyline+1));}
					case -35:
						break;
					case 35:
						{ return new Symbol(sym.ORELSE, new Token(sym.ORELSE, yytext(), yyline+1));}
					case -36:
						break;
					case 37:
						{ throw new Exception("Error léxico: "+yytext()+" en línea "+(yyline+1)); }
					case -37:
						break;
					case 38:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -38:
						break;
					case 40:
						{ throw new Exception("Error léxico: "+yytext()+" en línea "+(yyline+1)); }
					case -39:
						break;
					case 41:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -40:
						break;
					case 43:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -41:
						break;
					case 45:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -42:
						break;
					case 46:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -43:
						break;
					case 47:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -44:
						break;
					case 48:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -45:
						break;
					case 49:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -46:
						break;
					case 50:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -47:
						break;
					case 51:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -48:
						break;
					case 52:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -49:
						break;
					case 53:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -50:
						break;
					case 54:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -51:
						break;
					case 55:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -52:
						break;
					case 56:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -53:
						break;
					case 57:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -54:
						break;
					case 58:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -55:
						break;
					case 59:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -56:
						break;
					case 60:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -57:
						break;
					case 61:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -58:
						break;
					case 62:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -59:
						break;
					case 63:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -60:
						break;
					case 64:
						{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
					case -61:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
