
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	//ukljucivanje info o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	//ukljucivanje info o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}
	


%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" "     { }
"\b"    { }
"\t"    { }
"\r\n"  { }
"\f"    { }

"program" { return new_symbol(sym.PROG, yytext()); } 
"break" { return new_symbol(sym.BREAK, yytext()); } 
"class" { return new_symbol(sym.CLASS, yytext()); } 
"abstract" { return new_symbol(sym.ABSTRACT, yytext()); } 
"else" { return new_symbol(sym.ELSE, yytext()); } 
"if" { return new_symbol(sym.IF, yytext()); } 
"print" { return new_symbol(sym.PRINT, yytext()); } 
"new" { return new_symbol(sym.NEW, yytext()); } 
"const" { return new_symbol(sym.CONST, yytext()); }
"read" { return new_symbol(sym.READ, yytext()); } 
"return" { return new_symbol(sym.RETURN, yytext()); } 
"void" { return new_symbol(sym.VOID, yytext()); } 
"for" { return new_symbol(sym.FOR, yytext()); } 
"extends" { return new_symbol(sym.EXTENDS, yytext()); } 
"continue" { return new_symbol(sym.CONTINUE, yytext()); } 
"+" { return new_symbol(sym.PLUS, yytext()); } 
"-" { return new_symbol(sym.MINUS, yytext()); } 
"*" { return new_symbol(sym.PUTA, yytext()); } 
"/" { return new_symbol(sym.PODELJENO, yytext()); } 
"%" { return new_symbol(sym.POSTO, yytext()); } 
"==" { return new_symbol(sym.JEDNJEDN, yytext()); } 
"!=" { return new_symbol(sym.RAZLICITO, yytext()); } 
">" { return new_symbol(sym.VECE, yytext()); } 
">=" { return new_symbol(sym.VECEJEDN, yytext()); } 
"<" { return new_symbol(sym.MANJE, yytext()); } 
"<=" { return new_symbol(sym.MANJEJEDN, yytext()); } 
"&&" { return new_symbol(sym.II, yytext()); }
"||" { return new_symbol(sym.ILIILI, yytext()); } 
"=" { return new_symbol(sym.JEDN, yytext()); } 
"++" { return new_symbol(sym.PLUSPLUS, yytext()); } 
"--" { return new_symbol(sym.MINUSMINUS, yytext()); } 
";" { return new_symbol(sym.TACKAZAP, yytext()); } 
"," { return new_symbol(sym.ZAP, yytext()); } 
"." { return new_symbol(sym.TACKA, yytext()); } 
"(" { return new_symbol(sym.OTVZGRD, yytext()); } 
")" { return new_symbol(sym.ZATZGRD, yytext()); } 
"[" { return new_symbol(sym.OTVUGLZGRD, yytext()); } 
"]" { return new_symbol(sym.ZATUGLZGRD, yytext()); } 
"{" { return new_symbol(sym.OTVVITZGRD, yytext()); }
"}" { return new_symbol(sym.ZATVITZGRD, yytext()); }
"+=" { return new_symbol(sym.PLUSJEDN, yytext()); } 
"-=" { return new_symbol(sym.MINUSJEDN, yytext()); } 
"*=" { return new_symbol(sym.PUTAJEDN, yytext()); } 
"/=" { return new_symbol(sym.PODELJENOJEDN, yytext()); } 
"%=" { return new_symbol(sym.POSTOJEDN, yytext()); } 
"@" { return new_symbol(sym.AT, yytext()); }
"#" { return new_symbol(sym.TAR, yytext()); }

<YYINITIAL>"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" {yybegin(YYINITIAL);}

[0-9]+ { return new_symbol(sym.NUMCONST, new Integer (yytext())); }
true   { return new_symbol(sym.BOOLCONST, new String(yytext())); }
false   { return new_symbol(sym.BOOLCONST, new String(yytext())); }
('[ -~]') {return new_symbol(sym.CHARCONST, new Character(yytext().charAt(1)));}

([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }
. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }



