grammar expr;

@header {
	package antlr;
}

prog: 'game' CLASS_NAME '[' ']' '!' body '!' EOF	#Program
	;


//********************** class ********************** //

body: (decl)* (assi)* (mymethod)*	#ClassBody
	;

//	 do we allow class name to be same as method name and var name?
decl: VAR_NAME '<<' DATA_TYPE	#Declaration
	;

assi: VAR_NAME '<-' expr	#Assignment
	;
	
expr: r_method_call 	
	| value				
	;
	
//********************** mymethod ********************** //
mymethod: 'mymethod' METHODNAME method_type		#Method
		;
	
method_type: return_method		#mReturnMethod
		   | void_method		#mVoidMethod
		   ;  
	
return_method: DATA_TYPE '[' param ']' '!' method_body 'jackieReturns' VAR_NAME '!' 	#ReturnMethod
			 ;
			 
void_method: VOID_TYPE '[' param ']' '!' method_body '!'		#VoidMethod
	   	   ;

method_body: (decl)* (assi)* (if_statement)* (r_method_call)*	#MethodBody
		   ;
		   
param: DATA_TYPE VAR_NAME
	 | 
	 ;
		   
//********************** test method ********************** //		   
test: 'test' TEST_NAME '[' ']''!' (decl)* (assi)* (t_method_call)* '!'
	;
	
t_method_call: CLASS_NAME'.'METHODNAME'['input']'
			 ;

// what input
input:  
	 ;	
	
//********************** if Statement ********************** //	 
if_statement: 'jackieAsks' '[' cond ']' '!' method_body '!' 'elseJackie' '!' method_body '!'	#IfStatement
			;	 
	 
//********************** extra ********************** //
value: NUM | DOUBLE | STRING | CHAR | BOOL 	#Values
	 ;
		  
r_method_call: METHODNAME '[' VAR_NAME ']'		#returnMethodCall
			 ;

math:'(' math ')'        #MathParenthesis 
    | math '+' math        #Addition
    | math '-' math        #Subtraction
    | math '*' math        #Multiplication
    | math '/' math        #Division
    | NUM                #MathNumber
    | DOUBLE            # x
    | VAR_NAME            #MathDouble
    ;
          
cond: 'not' cond        #Negation 
    |'(' cond ')'        #CondParenthesis
    | cond '&&' cond    #Conjunction
    | cond '||' cond    #Disjunction
    | cond '==' cond    #EqualTo
    | cond '/=' cond    #NotEqualTo
    | BOOL                 # a
    | math '==' math    # b    
    | math '>=' math    # b    
    | math '<=' math    #c
    | math '=<' math     #d
    | math '=>' math    #e        
    | math '<' math        #f
    | math '>' math        #g
    | VAR_NAME            #h
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