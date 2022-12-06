How to set up Run Configuration on Eclipse
	1. Run
	2. Run Configurations...
	3. Java Application -> Create new Configuration
	5. Main -> Set Main class to app.ExpressionApp
	7. Arguments -> Set Program arguments to:     
	
			${file_prompt} ${file_prompt}
			
			
Steps to build Runnable JAR
	1. Project -> Clean...
	2. right-click EECS4302_F22_Project
	3. Java -> Runnable JAR
	4. Launch configuration: ExpressionApp - EECS4302_F22_Project
	5. Export destination: EECS4302_F22_Project/src/my-compilers.jar


How to run Runnable JAR:
	1. go to "src" file
	2. run the command below in terminal
			java -jar my-compilers.jar /../4302Project/EECS4302_F22_Project/src/tests/Program1  /../4302Project/EECS4302_F22_Project/src/tests/Test1
		
		
Where to find generated outputs:
	/../EECS4302_F22_Project/src	//depends on where user export the jar file to
			
			
Expected output: 
	Note: user are expected to open index.html file only 
	
	main HTML file named 
			=> index.html
			
	the other HTML files depends on the number of test method calls 
			=> game1.html 
			=> game2.html
			...
			
If user would like to generate another Program and Test files, user is required to delete all the generated html files
			
	
