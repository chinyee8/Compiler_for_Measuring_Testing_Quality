grammar expr;

@header {
	package antlr;
}

prog: (game | (test)+) EOF						#Program
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
mymethod: 'mymethod' METHODNAME method_type															#MyMethods
		;
	
//MethodType
method_type: DATA_TYPE '[' parameter ']' '!' method_body 'jackieReturns' VAR_NAME '!'				#MyReturnMethod
		   | VOID_TYPE '[' parameter ']' '!' method_body '!'										#MyVoidMethod
		   ;  
	

method_body: (decl)* (assi)* (if_statement)* (r_method_call|v_method_call)*					 					#MyMethodBody
		   ;

//Parameter	   
parameter: param							#SingleParam
    	 | param (multi_param)+				#MultiParam
    	 |									#EmptyParam
    	 ;   
            
param: DATA_TYPE VAR_NAME 					#Params
     ;
   
 
multi_param: ',' param						#MultiParamChild
           ; 
		   
//********************** test method ********************** //		   
test: 'test' TEST_NAME '[' ']''!' (decl)* (assi)* (t_method_call)* '!'		#TestCase
	;
//********************** method calls ********************** //		   
	
t_method_call: METHODNAME'[' call_parameter ']'				#TestMethodCall
			 ;
r_method_call: METHODNAME '[' call_parameter ']'							#ReturnMethodCall
			 ;
v_method_call: VOIDCALL METHODNAME '[' call_parameter ']'			 		#VoidMethodCall
			;
//Call_Parameter
call_parameter: input														#CallParameter
				| input (multiInput)+										#CallMultiParameter
				|															#CallEmptyParameter
			;

//Input_List
input: VAR_NAME																#CallParamVarName
     | DOUBLE																#CallParamDouble
	 | NUM																	#CallParamNum
     | CHAR																	#CallParamChar
     | STRING																#CallParamString
	 ;    
	 
multiInput: ',' input														#MultipleInput
	;	
//********************** if Statement ********************** //	 
if_statement: 'jackieAsks' '[' cond ']' '!' method_body '!' 'elseJackie' '!' method_body '!'	#IfStatement
			;	 
	 
//********************** extra ********************** //
//Value_List
value: DOUBLE 		#ValueDouble
	 | NUM 			#ValueNum
	 | STRING 		#ValueString
	 | CHAR 		#ValueChar
	 | BOOL 		#ValueBool
	 | math			#ValueMath
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
	| VAR_NAME          #CondVarName
    | math '==' math    #CondEqual
    | math '/=' math    #CondNotEqual    
    | math '>=' math    #MoreOrEqual
    | math '<=' math    #LessOrEqual    
    | math '>' math     #More    
    | math '<' math     #Less
    ;  
	
			 
VOIDCALL: 'void_';
DATA_TYPE:'INT'|'DOUBLE'|'BOOLEAN'|'STRING'|'CHAR';
VOID_TYPE:'VOID';
BOOL: 'TRUE' | 'FALSE';
TEST_NAME: 'test_'[a-zA-Z0-9_]*;
VAR_NAME:[a-z][a-z0-9_]*;
CLASS_NAME:[A-Z][a-z]*;
METHODNAME: [A-Z][A-Z0-9_]*;
DOUBLE: NUM'.'[0-9][0-9]; //2 decimal point
NUM: '0' | '-'?[1-9][0-9]*;
CHAR: '\''[a-z]'\'' | '\''[A-Z]'\'' ;
STRING: '"'[a-zA-Z0-9][a-zA-Z0-9 ]*'"';
COMMENT: '#' ~[\r\n]* ->skip;
WS: [ \t\n\r]+ -> skip; 
