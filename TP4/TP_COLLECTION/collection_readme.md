# TP4: Collections in Java

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
## Usage
Each exercise is encapsulated in a Java class with a main method. To run an exercise, simply execute the corresponding class in your IDE.

## Exercises
### Exercise 1: List Manipulation
This exercise focuses on managing a list of products using Java’s List interface, specifically the ArrayList class. This type of collection allows you to store a set of objects and provides easy manipulation of them.

#### 1.Creating the Product List
The goal here is to create a Product class that represents a product with attributes such as id, name, and price. Once the class is defined, we create an ArrayList to store Product objects. This allows us to dynamically manage a collection of products within the program.

#### 2.Adding and Removing Products
The add() method is used to add Product objects to the list. This demonstrates how to insert elements into a collection. On the other hand, the remove() method allows us to remove a product based on its index. This step highlights how to manipulate lists by adding or removing elements dynamically during the program's execution.

#### 3.Displaying Products
In this section, we traverse the list and display each product. To achieve this, we use an enhanced for loop (for-each loop), which is a convenient way to iterate over the elements of a collection. Each product will display its attributes (id, name, and price), allowing the user to view the products in the list.

#### 4.Modifying a Product
Here, we show how to access a specific product by its index in the list and then modify its attributes. This illustrates the flexibility of lists in Java, where we can not only add and remove elements but also update them as needed.

#### 5.Searching for a Product by Name
In this part, we demonstrate how to search for a product by its name within the list. We use a loop to compare each product’s name with the searched name. This simulates a search mechanism within a list, showing how simple iteration can be used to perform searches.


### Exercise 2: Map Manipulation
This exercise is about using a HashMap, a key-value collection, to manage student grades. The key is the student’s name, and the value is their grade.

#### 1.Creating the HashMap
We start by initializing a HashMap that associates student names (keys) with their grades (values). The use of unique keys allows for direct access to a student’s grade by their name, which makes the HashMap an efficient choice for this task.

#### 2.Adding and Updating Grades
The put() method is used to add new grades or update the grade of an existing student in the HashMap. This shows how a HashMap allows us to store and update data associated with unique keys, providing an efficient way to handle data modifications.

#### 3.Deleting Grades
We use the remove() method to delete a student’s grade based on their name. This operation is important for dynamically managing the data in a key-value store, as it allows the removal of entries when needed.

#### 4.Calculating Statistics
In this step, we traverse the HashMap to calculate statistics such as the average, maximum, and minimum grades. This part demonstrates how to work with collections to perform basic statistical operations on a dataset.

#### 5.Searching for a Specific Grade
We use the containsValue() method to check if a particular grade exists in the collection. This demonstrates how we can perform searches on the values of a HashMap without directly iterating through the keys.

#### 6.Displaying Data
A forEach loop with a lambda expression is used to display each student’s name and their grade. This modern approach to iteration simplifies the process of displaying data from the collection.

### Exercise 3: Set Manipulation
This exercise involves managing student groups using the Set interface. A HashSet is a collection that does not allow duplicates, making it ideal for handling groups where each student must be unique.

#### 1.Creating Student Groups
We define two HashSet collections, groupA and groupB, to store the names of students in each group. The goal is to manipulate these groups and perform set operations such as intersection, union, and difference.

#### 2.Adding Students to Sets
Students are added to the groups using the add() method. A HashSet ensures that each student name is unique within the set, preventing duplicates from being added.

#### 3.Finding Intersection of Groups
The retainAll() method is used to find students who are present in both groups, i.e., the intersection of the sets. This demonstrates how to manipulate sets to find common elements between multiple collections.

#### 4.Union of Groups
The addAll() method is used to combine both groups into one, ensuring there are no duplicates. This operation illustrates how to merge multiple sets into a single set without repeating elements.

#### 5.Difference between Groups
We use the removeAll() method to find students who are in one group but not the other, showing how to perform a set difference operation. This helps to identify the unique elements in one set relative to another.


#### 6.Displaying Results
Finally, we iterate through each HashSet to display the student names. This step allows us to verify the results of the set operations and output the data in a clear format.

## Conclusion
These exercises have introduced you to using different Java collections (List, Map, and Set) to manage data efficiently. You have learned how to manipulate ordered lists, collections of key-value pairs, and collections without duplicates, while applying operations such as sorting, searching, and calculating statistics.






