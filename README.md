# 
CS341 Software Engineering

Homework 6

Write the code for the application described below in Java.  Commit the source code (with documentation) to GitHub. 
Submit the Git repository URL to Moodle.
Submit the following Word documents to Moodle
•	Testing summary. 
•	Completed final summary for your Personal Software Process: PSP Form



Program Requirements, Data Structures, Testing, Personal Software Process

  
Application Description
Write a program to analyze a Java code file, specifically counting the Lines of Code (LOC).
 


Requirements

Design/Features

•	You must use the Java programming language to develop this program.
•	Allow the user to choose an input Java code file.
•	Count and report all lines of code in the file. Ignore blank lines (those containing only white space). Ignore comment lines as well. Remember that comments may start with /* and end with */ several lines below. Handle these cases as well.
•	Develop a plan and design for your program. Choose the best possible data structures.
•	The final report must also list the names of all methods in the source file along with their number of lines.
•	Produce a table listing of control structures used in the code file.  For example, indicate how many for loops, while loops, if statements, etc. are used in the code.
•	Use OOP and write efficient code. For example, do not unnecessarily traverse the list. 
•	Assure the readability of your code in this assignment. 



Testing

•	In your testing phase, include tests that count the lines of HW2 and this assignment.  Produce a test summary, indicating how you ensured that the code is correct You are responsible for resolving all issues. Document all your assumptions and decisions wherever requirements are unclear. Here are some basic tests:
1.	Test for basic functionality. Run the program on multiple code files.
2.	Test for simple comments (// or /*..*/ on one line). NOTE: * // or /* or */ inside of quotes should not be counted as comments.
3.	Test for empty lines
4.	Test for multi-line comments

Final Documentation

•	You are responsible for resolving any issue not covered by these requirements. Document all your assumptions and decisions wherever requirements are unclear.

•	Produce a final summary of your Personal Software Process. See the PSP Form. This document requires you to record the size (number of lines of code) for your entire program, the time spent on design, coding, testing (in minutes), and a list of all defects your encountered and fixed (indicate the type/root cause). The final program should have all defects corrected. Retain this data for future use.


Some general remarks

The point of measuring LOC is not for the purpose of reducing it in the future. Low LOC can actually reflect code with low readability/portability.  Personal Software Process uses LOC as a measure of size, not as a reflection of code quality. The goal of PSP is to improve your efficiency through measurement. 



