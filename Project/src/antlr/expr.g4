grammar expr;

@header {
	package antlr;
}

prog: (game | (test)+) EOF	#Program
	;

//********************** class ********************** //
game: 'game' CLASS_NAME '[' ']' '!' body '!'	#GameClass
	;

body: (decl)* (assi)* (mymethod)*				#GameBody
	;

decl: VAR_NAME '<<' DATA_TYPE					#Declaration
	;

assi: VAR_NAME '<-' expr						#Assignment
	;
	
//Expr	
expr: r_method_call 							#RMethodCall
	| value										#Values
	;
	
//********************** mymethod ********************** //
mymethod: 'mymethod' METHODNAME method_type												#MyMethods
		;
	
//MethodType
method_type: return_method																#MyReturnM
		   | void_method																#MyVoidM
		   ;  
	
return_method: DATA_TYPE '[' param ']' '!' method_body 'jackieReturns' VAR_NAME '!' 	#MyReturnMethod
			 ;
			 
void_method: VOID_TYPE '[' param ']' '!' method_body '!'								#MyVoidMethod
	   	   ;

method_body: (decl)* (assi)* (if_statement)* (r_method_call)*							#MyMethodBody
		   ;

//Parameter	   
param: DATA_TYPE VAR_NAME													#MyParameter
	 | (DATA_TYPE VAR_NAME ',')+ DATA_TYPE VAR_NAME										#MyMultiParameter
	 |																		#MyNoParameter
	 ;
		   
//********************** test method ********************** //		   
test: 'test' TEST_NAME '[' ']''!' (decl)* (assi)* (t_method_call)* '!'		#TestCase
	;
	
t_method_call: CLASS_NAME'.'METHODNAME'['input']'							#TestMethodCall
			 ;
//Input
input: math																	#TestMath
     | cond																	#TestCond
     | VAR_NAME																#TestVarName
     | NUM																	#TestNum
     | CHAR																	#TestChar
     | STRING																#TestString
     | DOUBLE																#TestDouble
     | input ',' input														#TestInputs
     |																		#TestEmpty
	 ;    
	
//********************** if Statement ********************** //	 
if_statement: 'jackieAsks' '[' cond ']' '!' method_body '!' 'elseJackie' '!' method_body '!'	#IfStatement
			;	 
	 
//********************** extra ********************** //
//Values
value: NUM 			#ValueNum
	 | DOUBLE 		#ValueDouble
	 | STRING 		#ValueString
	 | CHAR 		#ValueChar
	 | BOOL 		#ValueBool
	 ;
	  
r_method_call: METHODNAME '[' VAR_NAME ']'		#returnMethodCall
			 ;

//Mathematics
math:'(' math ')'        #MathParenthesis 
    | math '+' math      #Addition
    | math '-' math      #Subtraction
    | math '*' math      #Multiplication
    | math '/' math      #Division
    | NUM                #MathNumber
    | DOUBLE             #MathDouble
    | VAR_NAME           #MathVarName
    ;
      
//Condition    
cond: 'not' cond        #Negation 
    |'(' cond ')'       #CondParenthesis
    | cond '&&' cond    #Conjunction
    | cond '||' cond    #Disjunction
    | cond '==' cond    #EqualTo
    | cond '/=' cond    #NotEqualTo
    | BOOL              #CondBool
    | math '==' math    #CondEqual
    | math '/=' math    #CondNotEqual    
    | math '>=' math    #MoreOrEqual
    | math '<=' math    #LessOrEqual    
    | math '>' math     #More    
    | math '<' math     #Less
    | VAR_NAME          #CondVarName
    ;  
	
			 

DATA_TYPE:'INT'|'DOUBLE'|'BOOLEAN'|'STRING'|'CHAR';
VOID_TYPE:'VOID';
BOOL: 'TRUE' | 'FALSE';
TEST_NAME: 'test_'[a-zA-Z0-9_]*;
VAR_NAME:[a-z][a-z0-9_]*;
CLASS_NAME:[A-Z][a-z]*;
METHODNAME: [A-Z][A-Z0-9_]*;
NUM: '0' | '-'?[1-9][0-9]*;
CHAR: '\''[a-z]'\'' | '\''[A-Z]'\'' ;
STRING: '"'[a-zA-Z0-9][a-zA-Z0-9 ]*'"';
DOUBLE: NUM'.'[0-9][0-9]; //2 decimal point
COMMENT: '#' ~[\r\n]* ->skip;
WS: [ \t\n\r]+ -> skip; 
