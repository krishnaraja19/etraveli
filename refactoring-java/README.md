# Refactoring Java

The code creates an information slip about movie rentals.
Rewrite and improve the code after your own liking.

Think: you are responsible for the solution, this is a solution you will have to put your name on.


## Handing in the assignment

Reason how you have been thinking and the decisions you took. 
You can hand in the result any way you feel (git patch, pull-request or ZIP-file).
Note: the Git history must be included.




##Refactoring-java code details

1.In Main.java I have covered four different case of receipt data. All cases mentioned in code.

2. package description
com.movie.rental.service - This package having three java files. All these java provides services for receipt creation.
com.movie.rental.exception - This package having custom exception class and it is provide messages to get the valid input.
com.movie.rental.dto - This package having pojo file. Every pojo file is to hold the data.
com.movie.rental.dao - Basically It is get to load the data.
com.movie.rental.constants - This package is having constant java and holding the constant values.

3.Properties
I have a property file and it is used to get the constant values.
we can change the values easily and avoid touching the code If you want to change the value.
4. Please add the below mentioned jar file into the build path.
commons-lang3-3.11.jar

Features:
1. Maintained the SOLID principles in this java test.
2. Using custom exception to get valid inputs and maintained program flow. 



## To run the test:

```
javac src/*.java
java -cp src Main
```
