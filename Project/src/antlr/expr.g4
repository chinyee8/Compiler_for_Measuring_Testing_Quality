grammar expr;

@header {
	package antlr;
}

prog: 'game' CLASS_NAME '[' ']' '!' body '!' EOF	#Program
	;

body: 'jackieServes:' (decl)* 'jackieAssigns:' (assi)* (mymethod)*	#ClassBody
	;

//	 do we allow class name to be same as method name and var name?
decl: VAR_NAME '<<' DATA_TYPE	#Declaration
	;

assi: VAR_NAME '<-' expr	#Assignment
	;
	
mymethod: 'mymethod' METHODNAME method_type		#Method
		;
	
method_type: return_method		#mReturnMethod
		   | void_method		#mVoidMethod
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

DATA_TYPE:'INT'|'DOUBLE'|'BOOLEAN'|'STRING'|'CHAR';
VOID_TYPE:'VOID';
BOOL: 'TRUE' | 'FALSE';
VAR_NAME:[a-z][a-z0-9_]*;
CLASS_NAME:[A-Z][a-zA-Z]*;
METHODNAME: [A-Z][A-Z0-9_]*;
NUM: '0' | '-'?[1-9][0-9]*;
CHAR: '\''[a-z]'\'' | '\''[A-Z]'\'' ;
STRING: '"'[a-zA-Z0-9][a-zA-Z0-9 ]*'"';
DOUBLE: NUM'.'[0-9][0-9]; //2 decimal point
COMMENT: '#' ~[\r\n]* ->skip;
WS: [ \t\n\r]+ -> skip; 