# Anagram Finder
A simple command line utility for finding anagrams in a specified file

## Software required to run this
* Java 17

## Building and Running the tests
```
./gradlew clean build
```

## Running the program[Please run the code from editor[intelliJ or Eclipse] - I developed and tested the code in editor only..]

Running in intelliJ by passing the file as a param 

Choose the
AnagramFinderApplication ->Modify Run Configurations-> go to program Arguments -> Give your exact example2.txt file location 

Example for me the path is 
"C:\Users\workspace\MAVERICK\commercial-trading-java-techtest-master\src\main\resources\examples2.txt"

Step 1 :

After you set the program arguments please run the "AnagramFinderApplication" and it 
picks up the contents from example2.txt and apply the anagram logic and output will be displayed in IntelliJ console 

## Running the tests
 Right click on AnagramCommandLineRunnerIntegrationTest.java and Run 
* it executes all the junit test cases and test results listed in the respective editor console
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams


## Improvements

if I have more time i might have implemented following things 

* I might have written more test cases and fix all the existing commandLineRunnerTest cases which I have written already
* I might have enabled the IntelliJ profile and check the JVM load and memory allocation info
* I might have added Loggers and more exception handling criteria 

