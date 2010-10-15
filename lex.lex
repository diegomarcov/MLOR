import java_cup.runtime.Symbol;

%%
%line
%cup
%notunix
%ignorecase

%yylexthrow{Exception
%yylexthrow}

NUMERO = [0-9]+
BLANCOS = [ \t\r\n\f]+
REAL = [0-9]+\.[0-9]+
STRING = \".*\"
ID = [a-z][a-z_0-9]*
%%

"."			{ return new Symbol(sym.PUNTO);}
";"			{ return new Symbol(sym.PTOCOMA);}
"="			{ return new Symbol(sym.IGUAL);}
","			{ return new Symbol(sym.COMA);}
"<>"		{ return new Symbol(sym.DISTINTO);}
"<="		{ return new Symbol(sym.MENORIGUAL);}
"<"			{ return new Symbol(sym.MENOR);}
">="		{ return new Symbol(sym.MAYORIGUAL);}
">"			{ return new Symbol(sym.MAYOR);}
"::"		{ return new Symbol(sym.CONS);}
"+"			{ return new Symbol(sym.SUMA);}
"-"			{ return new Symbol(sym.RESTA);}
"orelse/* "	{ return new Symbol(sym.ORELSE);}
"^"			{ return new Symbol(sym.CONCAT);}
"*"			{ return new Symbol(sym.MUL);}
"/"			{ return new Symbol(sym.DIVREAL);}
"div"		{ return new Symbol(sym.DIVINT);}
"mod"		{ return new Symbol(sym.MOD);}
"andalso"	{ return new Symbol(sym.ANDALSO);}
"not"		{ return new Symbol(sym.NOT);}
"~"			{ return new Symbol(sym.MINUS);}
"("			{ return new Symbol(sym.PARABRE);}
")"			{ return new Symbol(sym.PARCIERRA);}
"["			{ return new Symbol(sym.CORABRE);}
"]"			{ return new Symbol(sym.CORCIERRA);}
"nil"		{ return new Symbol(sym.NIL);}
"fun"		{ return new Symbol(sym.FUN);}
"val"		{ return new Symbol(sym.VAL);}
{REAL}		{ return new Symbol(sym.REAL,new Float(yytext()));}
{NUMERO}	{ return new Symbol(sym.INT,new Integer(yytext()));}
{STRING}	{ return new Symbol(sym.STRING, yytext());}
{ID}		{ return new Symbol(sym.ID, yytext());}
{BLANCOS}	{ /* ignora espacios en blanco. */ }
.			{ throw new Exception("Error léxico: "+yytext()+" en línea "+(yyline+1)); }
