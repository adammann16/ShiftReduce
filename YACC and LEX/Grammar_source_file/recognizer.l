%{ // scanner for next attempt at Peeved
//
// removed begin and end as tokens

#include "y.tab.h"
#include <stdio.h>
    extern int line_number ;
    int column = 0 ;
%}
%%

"shared"		{ return (SHARED) ; }
"private"		{ return (PRIVATE) ; }
"integer"		{ return (INTEGER) ; }
"semaphore"		{ return (SEMAPHORE) ; }
"restrict"		{ return (RESTRICT) ; }
"Program"		{ return (PROGRAM) ; }
"Procedure"		{ return (PROCEDURE) ; }
"Process"		{ return (PROCESS) ; }
"P"			{ return (P) ; }
"V"			{ return (V) ; }
"Assert"		{ return (ASSERT) ; }
"Print"			{ return (PRINT) ; }
"while"			{ return (WHILE) ; }
"if"			{ return (IF) ; }
"then"			{ return (THEN) ; }
"else"			{ return (ELSE) ; }
"True"			{ return (TRUE) ; }
"+"			{ return (PLUS) ; }
"-"			{ return (MINUS) ; }
"*"			{ return (TIMES) ; }
"%"			{ return (MOD) ; }
"&"			{ return (AND) ; }
"|"			{ return (OR) ; }
"!"			{ return (NOT) ; }
"<="			{ return (LE) ; }
"<"			{ return (LT) ; }
"="			{ return (EQ) ; }
">"			{ return (GE) ; }
">="			{ return (GT) ; }
"!="			{ return (NE) ; }
":="			{ return (ASSIGN) ; }
"("			{ return (LPAREN) ; }
")"			{ return (RPAREN) ; }
"{"			{ return (LBRACE) ; }
"}"			{ return (RBRACE) ; }
"["			{ return (LBRACKET) ; }
"]"			{ return (RBRACKET) ; }
","			{ return (COMMA) ; }
";"			{ return (SEMICOLON) ; }
[A-Za-z][A-Za-z0-9_]*	{ return (ID) ; }
[0-9]*			{ return (NUM) ; }
\"[^"]*\"		{ /* printf ("   got --%s--\n", yytext) ; fflush (stdout) ; */     return (STRING) ; }
"\n"			{ line_number ++ ; }
--.*			{ /* fprintf ( stderr , "ignored comment [%s]\n", yytext ) ; ignore comment */ }
[ \t	]		{ ; /* ignore white space */ }
.			{ fprintf(stderr, "scanner ignored '%c'\n", yytext[0]) ; }
