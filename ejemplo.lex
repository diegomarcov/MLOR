import java_cup.runtime.Symbol;

%%
%line
%cup
%notunix

%yylexthrow{Exception
%yylexthrow}

NUMERO = [0-9]+
BLANCOS = [ \t\r\n\f]+
%%

";"			{ return new Symbol(sym.PTOCOMA); }
"+"			{ return new Symbol(sym.MAS); }
"*"			{ return new Symbol(sym.POR); }
"("			{ return new Symbol(sym.PARENA); }
")"			{ return new Symbol(sym.PARENC); }
{NUMERO}	{ return new Symbol(sym.NUMERO,new Integer(yytext())); }
{BLANCOS}	{ /* ignora espacios en blanco. */ }
.			{ throw new Exception("Error léxico: "+yytext()+" en línea "+(yyline+1)); }