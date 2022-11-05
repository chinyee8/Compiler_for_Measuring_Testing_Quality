grammar expr;

@header {
	package antlr;
}

prog: 'game' CLASS_NAME '[' ']' '!' body '!' EOF	#Program
	;

body: 'jackieServes:' (decl)* 'jackieAssigns:' (assi)* (mymethod)*
	;

decl: VAR_NAME '<<' DATA_TYPE
	;

assi: VAR_NAME '<-' expr
	;
	
mymethod: 'mymethod' METHODNAME method_type
	;
	
method_type: return_method
		   | void_method
		   ;  
	
return_method: DATA_TYPE '[' DATA_TYPE VAR_NAME ']' '!' method_body 'jackieReturns' VAR_NAME '!' 
			 ;
			 
void_method: VOID_TYPE '[' DATA_TYPE VAR_NAME ']' '!' method_body '!'
	   	   ;

expr: r_method_call 
	| value
	;
	

value: NUM | DOUB | STRING | CHAR | BOOL //what if enter string in int variable, semantic or parse error?
	 ;
		  
	
r_method_call: METHODNAME '[' VAR_NAME ']'
			 ;

if_statement: 'jackieAsks' '[' cond ']' '!' method_body '!' 'elseJackie' '!' method_body '!'
			;

//compulsory for decl and assi or not
method_body: 'jackieServes:' (decl)* 'jackieAssigns:' (assi)* (if_statement)* (r_method_call)*
		   ;
		   

cond: '(' cond ')'
	| 'not' cond
	| cond '&&' cond
	| cond '||' cond
	| cond '=>' cond
	| cond '==' cond
	| cond '/=' cond
	| cond '>' cond
	| cond '<' cond
	| NUM
	| BOOL
	;		 

VAR_NAME:[a-z][a-z0-9_]*;
CLASS_NAME:[A-Z][a-zA-Z]*;
DATA_TYPE:'iNT'|'dOUBLE'|'bOOLEAN'|'sTRING'|'cHAR';
METHODNAME: [A-Z][A-Z0-9_]*;
NUM: '0' | '-'?[1-9][0-9]*;
VOID_TYPE:'vOID';
BOOL: 'tRUE' | 'fALSE';
CHAR: '\''[a-z]'\'' | '\''[A-Z]'\'' ;
STRING: '"'[a-zA-Z0-9][a-zA-Z0-9 ]*'"';
DOUB: NUM'.'[0-9][0-9]; //2 decimal point
COMMENT: '#' ~[\r\n]* ->skip;
WS: [ \t\n\r]+ -> skip; 