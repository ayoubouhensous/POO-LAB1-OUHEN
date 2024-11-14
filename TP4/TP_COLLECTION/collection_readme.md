# TP2: Collections in Java

This practical assignment explores the different collections available in Java, specifically **Lists**, **Maps**, and **Sets**. Collections are essential data structures that make it easy to manage groups of objects. In this assignment, we will complete several exercises to understand how to manipulate these collections effectively.

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Exercises](#exercises)
   - [Exercise 1: List Manipulation](#exercise-1-list-manipulation)
   - [Exercise 2: Map Manipulation](#exercise-2-map-manipulation)
   - [Exercise 3: Set Manipulation](#exercise-3-set-manipulation)
6. [Conclusion](#conclusion)

## Introduction

**Collections** are data structures used to store and manipulate groups of objects. The main collection interfaces in Java are:
- **List**: An ordered collection that can contain duplicate elements.
- **Map**: A collection that associates unique keys with values.
- **Set**: A collection that does not allow duplicate elements.

In this assignment, we will explore these concepts through three practical exercises.

## Technologies Used
- Java
- IntelliJ IDEA (IDE)
- JDK 17 or higher

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ayoubouhensous/POO-LAB2-OUHEN
2. Open the project in IntelliJ IDEA.
3. Ensure that JDK 17 or higher is installed.
4. Build the project to verify there are no errors.
Usage
Each exercise is encapsulated in a Java class with a main method. To run an exercise, simply execute the corresponding class in your IDE.

Exercises
Exercise 1: List Manipulation (Product List)
This exercise involves writing a Java program to manage a list of products using the List interface (ArrayList).

Creating the Product List
Define a Product class with attributes such as id, name, and price. Then, create an ArrayList to store objects of type Product.

Adding and Removing Products
Use the add() method to add Product objects to the list. Then, demonstrate how to remove a product from the list by its index using the remove() method.

Displaying Products
Traverse the list using a for-each loop to display each product with its details (id, name, and price).

Modifying a Product
Update the information of an existing product by accessing its index and updating its attributes.

Searching for a Product by Name
Allow the user to search for a product based on its name. Use a loop to check if the entered name matches a product in the list.

Exercise 2: Managing Student Grades (Map)
This exercise focuses on using a HashMap to store and manage student grades. The key is the student's name, and the value is their grade.

Creating the HashMap
Initialize a HashMap that stores student names as keys and their grades as values.

Adding and Updating Grades
Use the put() method to add grades and update a student's grade if they already exist in the HashMap.

Deleting Grades
Allow deletion of a student's grade using the remove() method.

Calculating Statistics
Traverse the HashMap to calculate statistics such as the average, maximum, and minimum grades of students.

Searching for a Specific Grade
The user can enter a grade, and the program will check if this grade is present in the collection. Use the containsValue() method for this check.

Displaying Data
Use a forEach loop with a lambda expression to display each student and their grade.

Exercise 3: Managing Student Groups with Sets
This exercise involves managing student groups using the Set interface (HashSet).

Creating Student Groups
Define two HashSets named groupA and groupB, containing the names of students belonging to each group.

Adding Students to Sets
Add student names to the HashSet using the add() method. HashSets do not allow duplicates, so each student name is unique within a set.

Finding Intersection of Groups
Use the retainAll() method to display students present in both groups (intersection of sets).

Union of Groups
To obtain the complete list of students from all groups, use the addAll() method, which combines the two sets without duplicates.

Difference between Groups
Use the removeAll() method to display students present in one group but not in the other (difference of sets).

Displaying Results
Traverse each HashSet to display student names in a clear format.

Conclusion
These exercises have introduced you to using different Java collections (List, Map, and Set) to manage data efficiently. You have learned how to manipulate ordered lists, collections of key-value pairs, and collections without duplicates, while applying operations such as sorting, searching, and calculating statistics.

Copier le code





