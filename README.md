# TP1 : Les tableaux et les chaines de caractères

This repository contains four Java exercises that focus on different programming concepts. The first exercise is about managing student grades, the second deals with conjugating first-group French verbs, the third focuses on string manipulation, and the last counts the occurrences of letters in a string. Each exercise includes code snippets and explanations to help you understand how the tasks are performed.


## Overview
This project focuses on the implementation of arrays and strings in Java. It consists of several exercises demonstrating how to manage student grades, conjugate French verbs, manipulate strings, and count letter occurrences. 

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Exercises](#exercises)
   - [Exercise 1: Managing Student Grades](#exercise-1-managing-student-grades)
   - [Exercise 2: Conjugating French Verbs](#exercise-2-conjugating-french-verbs)
   - [Exercise 3: Managing Strings](#exercise-3-managing-strings)
   - [Exercise 4: Counting Letter Occurrences](#exercise-4-counting-letter-occurrences)
6. [Contributing](#contributing)
7. [License](#license)

### Introduction

Arrays and strings are vital data structures in programming, particularly in object-oriented languages like Java. Arrays provide a way to store multiple elements of the same type, allowing for efficient data manipulation. They are commonly used for tasks such as sorting, searching, and performing statistical operations. In Java, arrays are objects that can store either primitive types or references to objects, offering flexibility for different use cases.

Strings, on the other hand, are used to represent sequences of characters, and are fundamental for handling textual data. In Java, strings are immutable, meaning they cannot be changed once created. This immutability ensures that string data remains secure, though it also introduces some challenges when manipulating them. Common string operations include concatenation, searching for substrings, reversing characters, and counting words.

Understanding these data structures is key to solving many programming problems, as they are the building blocks of numerous algorithms. In this lab, we explored different exercises that demonstrate the power and versatility of arrays and strings in Java programming.

 ## Technologies Used
- Java
- IntelliJ IDEA (IDE)
- JDK 17 or higher

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ayoubouhensous/POO-LAB1.git
2. Open the project in IntelliJ IDEA.
3. Ensure that you have JDK 11 or higher installed.


## Usage
To run the exercises, simply execute the corresponding Java class files. Each class contains a main method to start the program.


## Exercises

### Exercise 1: Managing Student Grades  
This exercise involves writing a Java program that allows the user to input student grades, sort them, and then calculate useful statistics, such as the average grade, the highest and lowest grades, and the number of students achieving a specific grade.

#### 1. Sorting and Displaying Grades  
The program begins by prompting the user to input the number of students and their respective grades.
```java
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number of students:");
int numStudents = sc.nextInt();
float[] grades = new float[numStudents];
for (int i = 0; i < numStudents; i++) {
    System.out.println("Enter the grade for student " + (i + 1) + ":");
    grades[i] = sc.nextFloat();
}
```

Next, we use the Arrays.sort() method to sort the grades in ascending order and display them.
```java
Arrays.sort(grades);
System.out.println("Sorted student grades:");
for (int i = 0; i < numStudents; i++) {
    System.out.println(grades[i]);
}
```

#### 2. Calculating the Average Grade
To compute the average, we sum all the grades and divide by the number of students.
```java
float total = 0;
for (float grade : grades) {
    total += grade;
}
System.out.println("The average grade is: " + total / numStudents);
```
#### 3. Finding the Maximum and Minimum Grades
The highest and lowest grades are found by accessing the last and first elements of the sorted array, respectively.
```java
System.out.println("The highest grade is: " + grades[numStudents - 1]);
System.out.println("The lowest grade is: " + grades[0]);
```
#### 4. Counting Students with a Specific Grade
The user can enter a grade, and the program will count how many students received that grade.
```java
System.out.println("Enter the grade to search for:");
float gradeToFind = sc.nextFloat();
int count = 0;
for (float grade : grades) {
    if (grade == gradeToFind) {
        count++;
    }
}
System.out.println("Number of students with the grade " + gradeToFind + ": " + count);
```

### Exercise 2: Conjugating French Verbs
This exercise focuses on developing a Java program that conjugates regular French verbs from the first group (those ending in "er", except for "aller"). The program first checks if the verb belongs to this group and then conjugates it for all singular and plural pronouns.

#### 1. Verifying the Verb
The program prompts the user to input a verb and verifies whether it belongs to the first group.
```java
Scanner sc = new Scanner(System.in);
System.out.println("Enter a verb to conjugate:");
String verb = sc.nextLine().toLowerCase();

String root = verb.substring(0, verb.length() - 2);
String ending = verb.substring(verb.length() - 2);

if (ending.equals("er") && !verb.equals("aller")) {
    // Proceed with conjugation
} else {
    System.out.println("The verb is not a first-group verb.");
}
```
#### 2. Conjugating the Verb
If the verb is valid, we concatenate the root with the appropriate endings for each pronoun.
```java
String[] pronouns = {"je", "tu", "il", "nous", "vous", "ils"};
String[] endings = {"e", "es", "e", "ons", "ez", "ent"};

for (int i = 0; i < pronouns.length; i++) {
    System.out.println(pronouns[i] + " " + root + endings[i]);
}
```

### Exercise 3: Managing Strings
This task consists of a Java program offering a menu for the user to enter a string, display it, reverse it, or count the number of words.

#### 1. Displaying the Menu
The program displays a menu with several options for string manipulation:
```java
public static void menu() {
    System.out.println("Menu:");
    System.out.println("1. Enter a string");
    System.out.println("2. Display the string");
    System.out.println("3. Reverse the string");
    System.out.println("4. Count words in the string");
    System.out.println("0. Exit");
}
```

#### 2. Reversing the String
We reverse the string using the StringBuilder class and display the result.
```java
public static void reverseString(String str) {
    if (str.isEmpty()) {
        System.out.println("No string entered.");
    } else {
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string: " + reversed);
    }
}
```

#### 3. Counting Words
To count the words, we split the string based on spaces and output the number of words.
```java
public static void countWords(String str) {
    if (str.isEmpty()) {
        System.out.println("No string entered.");
    } else {
        String[] words = str.trim().split("\\s+");
        System.out.println("Word count: " + words.length);
    }
}
```

### Exercise 4: Counting Letter Occurrences
In this final exercise, the program counts the number of occurrences of each letter in the input string. The string is converted to lowercase before counting.

#### 1. Counting the Letters
We iterate through the string and update a counter for each letter:
```java
for (char c : str.toCharArray()) {
    if (c >= 'a' && c <= 'z') {
        occurrences[c - 'a']++;
    }
}
```
#### 1. Displaying Results
After processing the string, the program displays the number of occurrences for each letter that appears.
```java
for (int i = 0; i < occurrences.length; i++) {
    if (occurrences[i] > 0) {
        char letter = (char) ('a' + i);
        System.out.println(letter + " appears " + occurrences[i] + " times.");
    }
}

```
### Conclusion
In this lab, we explored the core concepts of arrays and strings in Java. Through various tasks, from sorting student grades to manipulating and analyzing strings, we learned how these data structures are essential tools in the development of efficient Java applications.





















