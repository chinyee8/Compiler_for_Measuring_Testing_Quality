grammar expr;

@header {
	package antlr;
}

prog: 'game' CLASS_NAME '[' ']' '!' body '!' EOF	#Program
	;

body: 'jackieServes:' (decl)* 'jackieAssigns:' (assi)* (mymethod)*	#ClassBody
	;

decl: VAR_NAME '<<' DATA_TYPE	#Declaration
	;

assi: VAR_NAME '<-' expr	#Assignment
	;
	
mymethod: 'mymethod' METHODNAME method_type		#Method
	;
	
method_type: return_method		
		   | void_method		
		   ;  
	
return_method: DATA_TYPE '[' DATA_TYPE VAR_NAME ']' '!' method_body 'jackieReturns' VAR_NAME '!' 	#ReturnMethod
			 ;
			 
void_method: VOID_TYPE '[' DATA_TYPE VAR_NAME ']' '!' method_body '!'		#VoidMethod
	   	   ;

expr: r_method_call 	
	| value				
	;
	
value: NUM | DOUBLE | STRING | CHAR | BOOL 	#Values
	 ;
		  
	
r_method_call: METHODNAME '[' VAR_NAME ']'		#returnMethodCall
			 ;

if_statement: 'jackieAsks' '[' cond ']' '!' method_body '!' 'elseJackie' '!' method_body '!'	#IfStatement
			;

//compulsory for decl and assi or not
method_body: 'jackieServes:' (decl)* 'jackieAssigns:' (assi)* (if_statement)* (r_method_call)*	#MethodBody
		   ;		   

math: math '+' math		#Addition
	| math '-' math		#Subtraction
	| math '*' math		#Multiplication
	| math '/' math		#Division
	| NUM				#MathNumber
	| DOUBLE			#MathDouble
	;

//do we need implication?
// do we need >= and <=
cond: '(' cond ')'		#Parenthesis
	| 'not' cond		#Negation
	| cond '&&' cond	#Conjunction
	| cond '||' cond	#Disjunction
	| cond '=>' cond	#Implication
	| cond '==' cond	#EqualTo
	| cond '/=' cond	#NotEqualTo
	| cond '>' cond		#MoreThan
	| cond '<' cond		#LessThan
	| NUM				#CondNumber
	| BOOL				#CondBoolean
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
DOUBLE: NUM'.'[0-9][0-9]; //2 decimal point
COMMENT: '#' ~[\r\n]* ->skip;
WS: [ \t\n\r]+ -> skip; 