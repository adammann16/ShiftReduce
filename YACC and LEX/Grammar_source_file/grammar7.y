%token   ID  NUM  STRING SHARED PRIVATE INTEGER SEMAPHORE RESTRICT PROGRAM PROCEDURE PROCESS P V ASSERT PRINT WHILE IF THEN ELSE PLUS MINUS TIMES MOD AND OR NOT LE LT EQ GE GT NE ASSIGN LPAREN RPAREN LBRACE RBRACE LBRACKET RBRACKET COMMA SEMICOLON TRUE

%%
A: B C NUM
      | C NUM

B: NUM NUM

C: NUM
  | C NUM
