cls
rm Yylex.java parser.java sym.java *.class
java JLex.Main lex.lex
mv lex.lex.java Yylex.java
java java_cup.Main cup.cup
javac parser.java sym.java Yylex.java
