# Compiler for Measuring Testing Quality
The project involves building a compiler using ANTLR4, a powerful parser generator, to support measuring the code coverage of a suite of input tests running on an input program. The project will define a set of tokens and grammar rules in a `.g4` file, which will be used by ANTLR4 to generate the lexer and parser components of the compiler. The design will support either the `-visitor` or `-no-listener` options in ANTLR4, depending on the implementation preference.

The goal is to develop a testing language that can be conveniently used to write tests for various functions, methods, modules, or classes. This testing language may be a subset of the input programming language's syntax and will be designed to easily define and manage test configurations, potentially including separate configuration files.

Test Case:
![Screenshot 2024-07-26 011638](https://github.com/user-attachments/assets/310c3777-54b6-426a-b916-562b343c4607)
Statement Coverage:
![Screenshot 2024-07-26 011651](https://github.com/user-attachments/assets/13f4ad9c-7b57-4a5b-85ea-193aa7c44b0e)
Condition Coverage:
![Screenshot 2024-07-26 011703](https://github.com/user-attachments/assets/f156928f-63aa-4bb6-bd2d-84fbf1a24ee5)
All-Defs Coverage:
![Screenshot 2024-07-26 011712](https://github.com/user-attachments/assets/00c92f90-9d0b-4319-b8c8-5f7598191de6)
All-C-Uses Coverage:
![Screenshot 2024-07-26 011723](https://github.com/user-attachments/assets/1340125d-3bee-4f63-bf50-7d9e00edff9b)
All-P-Uses Coverage:
![Screenshot 2024-07-26 011734](https://github.com/user-attachments/assets/da314d89-ce9e-4cf4-9073-41306d3e60b2)



Key features include:

1. **Design of Tokens and Grammar Rules**: The project will specify tokens and syntactic rules in the `.g4` file for the ANTLR4 tool to generate the necessary lexer and parser. This design will cover essential programming features, possibly inspired by popular programming languages.

2. **Testing Language Specification**: The testing language will be designed to allow convenient writing of tests, supporting various testing styles. This will include the ability to specify individual tests and their combinations.

3. **HTML Output for Code Coverage**: The compiler will output code coverage reports in HTML format. This will include detailed, cross-referenced information about the program coverage, similar to tools like EclEmma for Java in Eclipse. The HTML output will feature user-friendly navigation, including hyperlinks to navigate between covered parts of the program and the corresponding tests.

4. **Support for Multiple Input Files**: The compiler will accept multiple plain text files as input, representing both the program and the tests. It will produce a set of HTML files, with `index.html` serving as the main entry point for navigation.

Overall, the project aims to provide a comprehensive tool for analyzing and visualizing code coverage, helping users to understand how thoroughly their tests cover the program. The output should be detailed and accessible, ensuring that users can easily identify areas of the program that require additional testing or refactoring.
