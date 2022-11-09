How to run tool:
	1. go to "src" file
	2. run the command below in terminal
			java -jar my-compiler.jar \tests\input-1.txt

Expected output: 
	a single HTML file named => index.html
	
Rules : 
	TEST_NAME: Starts with “test_” and continue with (a-z)* , (A-Z)* or  (0-9) *
	
	VAR_NAME: All lower case (a-z)* , numbers (0-9)* or _
	
	CLASS_NAME: Starts with uppercase (A-Z) and the rest lower case (a-z) {no number or symbols}
	
	METHODNAME: Starts with uppercase (A-Z) and the rest upper case (A-Z)*, number (0-9)*, and ‘_’
	
	NUM: 0 OR -ve number that does not starts with 0
	
	CHAR: character either lower or upper case in between of  ‘   ‘
	
	STRING: Upper and lower case alphabet, numbers and space in between “   “
	
	DOUBLE: 2 decimal points only
	
	COMMENT: Starts with #
	
	RETURN METHOD:  DATA_TYPE '[' parameter ']' '!' method_body 'jackieReturns'                                             VAR_NAME '!' 	
					Must return variable name
					
	INSIDE METHODBODY: while declaring methodbody, cannot declare more methods inside methodbody. Can create declarations, assignments and call return method calls
	
	GAMEBODY: cannot do returncalls/voidcalls in gamebody, unless assigning to a variable
	
	If condition: cannot compare string with string or char with char directly, must assign it into variable first and compare with variable.
		