# TP4: Streams in Java

This TP explores the use of *Streams* in Java, a powerful tool for working with data collections in a functional way. Through two practical exercises, we will learn to use the main Stream operations such as `filter()`, `map()`, `reduce()`, `collect()`, and more.

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Exercises](#exercises)
   - [Exercise 1: Manipulating Words with Streams](#exercise-1-manipulating-words-with-streams)
   - [Exercise 2: Manipulating Employees with Streams](#exercise-2-manipulating-employees-with-streams)

6. [Conclusion](#conclusion)

## Introduction

Streams in Java allow us to process sequences of elements in a declarative way. By using Streams, we can perform transformations, filtering, reductions, etc., on collections without resorting to explicit loops.

In this TP, we will explore how to perform several common operations with Streams in Java, such as filtering, transforming data, and aggregating.


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
### Exercise 1: Manipulating Words with Streams
In this exercise, we are working with a list of words and performing various operations on them. These operations demonstrate different ways to manipulate and transform data in a list using Java Streams and functional programming concepts.

#### 1.Filter Words Containing the Letter "a"
In this operation, the goal is to filter out only those words from the list that contain the letter "a". This can be achieved using the filter() method in Java Streams, which checks if a condition is true for each word. If the condition (containing "a") is met, the word is included in the resulting list.

#### 2.Filter Words Longer than 3 Characters and Reverse Each Word
Here, we first filter the words whose length is greater than 3. Then, we transform each of the remaining words by reversing them. The map() method is used to apply the transformation, while the filtering step is done using filter(). Reversing a word can be done by converting it to a StringBuilder, using reverse(), and then converting it back to a string.

#### 3.Filter Words Containing the Letter "e" and Flatten Each Word into Characters
In this case, we filter words containing the letter "e" and transform each word into a list of its individual characters. We use flatMap() to flatten the stream of lists into a single list of characters, ensuring that each word is broken down into individual characters, which are then merged together.

#### 4.Transform Each Word to Uppercase
This operation involves transforming each word in the list to its uppercase version. The map() method is used to apply the toUpperCase() transformation on each word. This is a simple operation where each word is converted to uppercase.

#### 5.Convert Each Word to Its Length
Here, each word in the list is transformed into its length (an integer). This is done using the map() method again, but instead of transforming a word into another string, we transform it into an integer representing its length.

#### 6.Convert Each Word to a List of Characters, Then Flatten All Lists into One
First, each word is converted into a list of characters. Then, these lists are flattened into a single list of characters using flatMap(). This operation essentially breaks down the entire list of words into individual characters, without any nested lists, and combines all characters into one continuous list.

#### 7.Transform Each Word into a String of the Form "Name - Index"
This operation involves taking each word and transforming it into a string formatted as "Name - Index", where Index is the position of the word in the original list. We can use the IntStream.range() to generate indices, and then use map() to format each word along with its index.


### Exercise 2: Employee List Operations
his exercise involves managing a list of employees, where each employee has a name, department, and salary. The goal is to perform various operations that aggregate, filter, and manipulate the data of the employee list.

#### 1.Calculate the Total Salary of All Employees Using mapToDouble and sum
The mapToDouble() method is used to extract the salary of each employee as a double, and then we apply sum() to calculate the total salary of all employees. This is a straightforward operation where we convert each employee’s salary into a numerical value and then sum them up.

#### 2.Sort the List of Employees Alphabetically by Name
In this step, the employees are sorted alphabetically by their name. We use the sorted() method, which sorts the elements in a natural order (alphabetical order for strings) or using a custom comparator if needed.

#### 3.Find the Employee with the Lowest Salary Using min
To find the employee with the lowest salary, we use the min() method, which returns the employee with the smallest salary based on a comparator. The comparator compares employees by their salary, allowing us to identify the one with the minimum salary.

#### 4.Filter Employees with a Salary Greater than a Given Value Using filter
Here, we filter the list of employees to only include those whose salary is greater than a specified threshold. The filter() method is used to apply the condition, ensuring only employees meeting the criteria are retained in the resulting list.

#### 5.Find the Employee with the Highest Salary Using reduce
In this operation, we use the reduce() method to find the employee with the highest salary. The reduce() method takes a binary operator (a function that compares two employees at a time) and applies it to all elements in the list to accumulate the result. We use a comparator to compare the salaries and keep track of the employee with the highest salary.

#### 6.Concatenate All Employee Names Using reduce
The goal here is to concatenate the names of all employees into a single string. We use the reduce() method again, but this time the binary operator concatenates two employee names at a time, resulting in a single string that contains the names of all employees.

### Exercise 3: Set Manipulation
This exercise involves managing student groups using the Set interface. A HashSet is a collection that does not allow duplicates, making it ideal for handling groups where each student must be unique.


## Conclusion
These exercises have provided a practical introduction to the power of Java Streams and functional programming techniques for manipulating collections of data. By working with lists of words and employees, we have explored various operations such as filtering, transforming, and aggregating data.







