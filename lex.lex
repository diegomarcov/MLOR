import java_cup.runtime.Symbol;

%%
%line
%cup
%notunix
%ignorecase

%yylexthrow{Exception
%yylexthrow}

PUNTO = \.
NUMERO = [0-9]+
BLANCOS = [ \t\r\n\f]+
REAL = [0-9]+\.[0-9]+
STRING = \".*\"
ID = [a-z][a-z_0-9]*
OPREL = <>|<=|<|>=|>
OPADD = \+|-
%%

{PUNTO}		{ return new Symbol(sym.PUNTO, new Token(sym.PUNTO, yytext(), yyline+1));}
";"			{ return new Symbol(sym.PTOCOMA, new Token(sym.PTOCOMA, yytext(), yyline+1));}
"="			{ return new Symbol(sym.IGUAL);}
","			{ return new Symbol(sym.COMA, new Token(sym.COMA, yytext(), yyline+1));}
{OPREL}		{ return new Symbol(sym.OPREL, new Token(sym.OPREL, yytext(), yyline+1));}
"::"		{ return new Symbol(sym.CONS, new Token(sym.CONS, yytext(), yyline+1));}
{OPADD}		{ return new Symbol(sym.OPADD, new Token(sym.OPADD, yytext(), yyline+1));}
"orelse"	{ return new Symbol(sym.ORELSE, new Token(sym.ORELSE, yytext(), yyline+1));}
"^"			{ return new Symbol(sym.CONCAT, new Token(sym.CONCAT, yytext(), yyline+1));}
"*"			{ return new Symbol(sym.MUL, new Token(sym.MUL, yytext(), yyline+1));}
"/"			{ return new Symbol(sym.DIVREAL, new Token(sym.DIVREAL, yytext(), yyline+1));}
"div"		{ return new Symbol(sym.DIVINT, new Token(sym.DIVINT, yytext(), yyline+1));}
"mod"		{ return new Symbol(sym.MOD, new Token(sym.MOD, yytext(), yyline+1));}
"andalso"	{ return new Symbol(sym.ANDALSO, new Token(sym.ANDALSO, yytext(), yyline+1));}
"not"		{ return new Symbol(sym.NOT, new Token(sym.NOT, yytext(), yyline+1));}
"~"			{ return new Symbol(sym.MINUS, new Token(sym.MINUS, yytext(), yyline+1));}
"("			{ return new Symbol(sym.PARABRE, new Token(sym.PARABRE, yytext(), yyline+1));}
")"			{ return new Symbol(sym.PARCIERRA, new Token(sym.PARCIERRA, yytext(), yyline+1));}
"["			{ return new Symbol(sym.CORABRE, new Token(sym.CORABRE, yytext(), yyline+1));}
"]"			{ return new Symbol(sym.CORCIERRA, new Token(sym.CORCIERRA, yytext(), yyline+1));}
"nil"		{ return new Symbol(sym.NIL, new Token(sym.NIL, yytext(), yyline+1));}
"fun"		{ return new Symbol(sym.FUN, new Token(sym.FUN, yytext(), yyline+1));}
"val"		{ return new Symbol(sym.VAL, new Token(sym.VAL, yytext(), yyline+1));}
{REAL}		{ return new Symbol(sym.REAL,new Float(yytext()));}
{NUMERO}	{ return new Symbol(sym.INT,new Integer(yytext()));}
{STRING}	{ return new Symbol(sym.STRING, yytext());}
{ID}		{ return new Symbol(sym.ID, new Token(sym.ID,yytext(),yyline+1));}
{BLANCOS}	{ /* ignora espacios en blanco. */ }
.			{ throw new Exception("Error léxico: "+yytext()+" en línea "+(yyline+1)); }
