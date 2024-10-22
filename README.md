# TP1 : Les tableaux et les chaines de caractères

This repository contains four Java exercises that focus on different programming concepts. The first exercise is about managing student grades, the second deals with conjugating first-group French verbs, the third focuses on string manipulation, and the last counts the occurrences of letters in a string. Each exercise includes code snippets and explanations to help you understand how the tasks are performed.

### Introduction

Arrays and strings are vital data structures in programming, particularly in object-oriented languages like Java. Arrays provide a way to store multiple elements of the same type, allowing for efficient data manipulation. They are commonly used for tasks such as sorting, searching, and performing statistical operations. In Java, arrays are objects that can store either primitive types or references to objects, offering flexibility for different use cases.

Strings, on the other hand, are used to represent sequences of characters, and are fundamental for handling textual data. In Java, strings are immutable, meaning they cannot be changed once created. This immutability ensures that string data remains secure, though it also introduces some challenges when manipulating them. Common string operations include concatenation, searching for substrings, reversing characters, and counting words.

Understanding these data structures is key to solving many programming problems, as they are the building blocks of numerous algorithms. In this lab, we explored different exercises that demonstrate the power and versatility of arrays and strings in Java programming.

### Exercise 1: Managing Student Grades  
This exercise involves writing a Java program that allows the user to input student grades, sort them, and then calculate useful statistics, such as the average grade, the highest and lowest grades, and the number of students achieving a specific grade.

#### 1. Sorting and Displaying Grades  
The program begins by prompting the user to input the number of students and their respective grades.
```java
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number of students:");
int numStudents = sc.nextInt();
```
float[] grades = new float[numStudents];
for (int i = 0; i < numStudents; i++) {
    System.out.println("Enter the grade for student " + (i + 1) + ":");
    grades[i] = sc.nextFloat();
}
```

Next, we use the Arrays.sort() method to sort the grades in ascending order and display them.
Arrays.sort(grades);
System.out.println("Sorted student grades:");
for (int i = 0; i < numStudents; i++) {
    System.out.println(grades[i]);
}

