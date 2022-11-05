grammar expr;

@header {
	package antlr;
}

prog: 'game' CLASS_NAME '[' ']' '!' body '!' EOF	#Program
	;

body: (decl)* (assi)* (mymethod)*	#ClassBody
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

method_body: (decl)* (assi)* (if_statement)* (r_method_call)*	#MethodBody
		   ;	
		   
test: 'test' TEST_NAME '[' ']''!' (decl)* (assi)* (t_method_call)* '!'
	;
	
t_method_call: CLASS_NAME'.'METHODNAME'['input']'
			 ;

// what input
input:  
	 ;
 	   
math: math '+' math		#Addition
	| math '-' math		#Subtraction
	| math '*' math		#Multiplication
	| math '/' math		#Division
	| '(' math ')'		#MathParenthesis
	| NUM				#MathNumber
	| DOUBLE			#MathDouble
	;
		  
cond: '(' cond ')'		#CondParenthesis
	| math				#Mathematic
	| cond '&&' cond	#Conjunction
	| cond '||' cond	#Disjunction
	| cond '==' cond	#EqualTo
	| cond '/=' cond	#NotEqualTo
	| cond '>=' cond	#MoreOrEqual
	| cond '<=' cond	#LessOrEqual
	| cond '>' cond		#MoreThan
	| cond '<' cond		#LessThan
	| 'not' cond		#Negation
	| VAR_NAME			#CondVariable
	| NUM				#CondNum
	;	
			 

DATA_TYPE:'INT'|'DOUBLE'|'BOOLEAN'|'STRING'|'CHAR';
VOID_TYPE:'VOID';
BOOL: 'TRUE' | 'FALSE';
VAR_NAME:[a-z][a-z0-9_]*;
CLASS_NAME:[A-Z][a-zA-Z]*;
TEST_NAME: 'test_'[a-zA-Z0-9_]*;
METHODNAME: [A-Z][A-Z0-9_]*;
NUM: '0' | '-'?[1-9][0-9]*;
CHAR: '\''[a-z]'\'' | '\''[A-Z]'\'' ;
STRING: '"'[a-zA-Z0-9][a-zA-Z0-9 ]*'"';
DOUBLE: NUM'.'[0-9][0-9]; //2 decimal point
COMMENT: '#' ~[\r\n]* ->skip;
WS: [ \t\n\r]+ -> skip; 