# Invitation

This is the solution for an assessment for Intercom.com.

It solves the following problem:

**Technical problem**

We have some customer records in a text file (customers.txt) -- one customer per line, JSON lines formatted. We want to invite any customer within 100km of our Dublin office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).

You must use the first formula from this Wikipedia article to calculate distance. Don't forget, you'll need to convert degrees to radians.

The GPS coordinates for our Dublin office are 53.339428, -6.257664.

You can find the Customer list here.

We're looking for you to produce working code, with enough room to demonstrate how to structure components in a small program. Good submissions are well composed. Calculating distances and reading from a file are separate concerns. Classes or functions have clearly defined responsibilities.  Poor submissions will be in the form of one big function. It’s impossible to test anything smaller than the entire operation of the program, including reading from the input file.


## Solution
It implements the law of cosines at the class DistanceCalculator.

## Techinical information
This is a simple project built upon Java 8+ using Maven using Junit5 to test.

The only additional library used is Jackson to process the file provided.

The focus of this solution is to provide a simple API to solve the technical problem.

### How to build

Assuming basic knowledge about Java simple run:

```
mvn clean package
```

### How to test

### Sample output

## Final considerations
