
# TP1 : Multithreading en Java

This project focuses on using multithreading in Java. It includes two exercises that leverage the power of threads to perform tasks in parallel:

1. Exercise 1 involves creating multiple threads to display messages.
2. Exercise 2 splits an array into several segments, with each thread calculating a partial sum, and synchronization is used to avoid concurrency issues.


## Overview
This project focuses on the implementation of arrays and strings in Java. It consists of several exercises demonstrating how to manage student grades, conjugate French verbs, manipulate strings, and count letter occurrences. 

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Exercises](#exercises)
   - [Exercise 1: Exercise 1:Displaying Messages with Threads](#exercise-1:Displaying-Messages-with-Threads)
   - [Exercise 2: Exercise 2:Summing Array Elements with Threads](#exercise-2:Summing-Array-Elements-with-Threads)
6. [Conclusion](#Conclusion)

### Introduction

Multithreading allows multiple tasks to run simultaneously, which is useful for improving program performance, especially for independent processes. In Java, threads are managed through the Runnable interface or the Thread class.

In this project, we explored two practical exercises to demonstrate the use of threads:

In the first exercise, we created multiple threads that display messages to the console.
In the second exercise, we parallelized the summation of array elements using several threads.

 ## Technologies Used
- Java
- IntelliJ IDEA (IDE)
- JDK 17 or higher

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ayoubouhensous/POO-LAB1-OUHEN
2. Open the project in IntelliJ IDEA.
3. Ensure that you have JDK 17 or higher installed.


## Usage
To run the exercises, simply execute the corresponding Java class files. Each class contains a main method to start the program.

## Exercises

### Exercise 1: Displaying Messages with Threads

In this exercise, we created 10 threads. Each thread prints a message containing its number 100 times. The threads run independently and display messages in a random order depending on the execution order of the threads.

#### Class Definition
~~~ java
public class Talkative implements Runnable {
    private int ent;
~~~
- Talkative  is a class that implements the Runnable interface. The Runnable interface represents a task that can be executed by a thread. Any class that implements Runnable must override the run() method to define the task that the thread will execute.
- The ent variable is used to store a unique identifier for each thread. In this case, it will hold the thread's number (from 1 to 10).

  #### Constructor
  ~~~ java
  public Talkative(int ent) {
    this.ent = ent;
}
~~~
The constructor takes an integer ent as a parameter, which will represent the thread's number. The value is stored in the instance variable ent.

#### run() Method

~~~ java
@Override
public void run() {
    for (int i = 0; i < 100; i++) {
        System.out.println("Threads" + ent + " : " + ent);
    }
}
~~~
The run() method is where the actual task of the thread is defined. Since the Talkative class implements Runnable, this method must be provided.

Inside the run() method, there is a loop that runs 100 times. Each time, the message "Threads" + ent + " : " + ent is printed to the console.

- "Threads" is a string that will be printed before the thread's number.
- ent is the thread number that was passed in the constructor (e.g., 1, 2, 3, ...).
- The loop will repeat 100 times for each thread, printing its message.

#### main() Method

~~~ java
public static void main(String[] args) throws InterruptedException {
    for (int i = 1; i <= 10; i++) {
        Talkative t = new Talkative(i);
        Thread thread = new Thread(t);
        thread.start();
    }
}
~~~
The main() method is the entry point of the program. Here's what happens inside:
- A for loop runs from 1 to 10. For each iteration, a new instance of the Talkative class is created, passing the current value of i (the thread number) to the constructor. This creates a new Talkative object for each thread.
- A new Thread object is created, passing the Talkative object as the task for the thread to execute. The thread is initialized with the task that will run in the run() method.
- The start() method is called on the thread, which starts the execution of the thread and invokes the run() method in parallel with other threads.

#### Key Points:
1 - Multithreading: The program demonstrates multithreading by creating multiple threads that run simultaneously.
2- Concurrency: The messages from different threads may be printed in a mixed order because the threads execute independently and concurrently.
3- Thread Initialization: The threads are created using the Thread class and started with the start() method.
4- Runnable Interface: The Talkative class implements the Runnable interface, which means it can be used as a task to be executed by a thread.



### Exercise 2: Summing Array Elements with Threads

In this exercise, we created multiple threads to compute the sum of elements in an array. The array is divided into segments, and each thread is responsible for summing a specific segment. After all threads finish, the results are combined to get the final sum.

####Class Definition - Sommeur

~~~ java
public class Sommeur implements Runnable {
    private int[] tableau;
    private int debut;
    private int fin;
    private static int somme;
~~~

- Sommeur is a class that implements the Runnable interface. This class is responsible for summing a part of the array in each thread.
- tableau is the array that contains the elements to be summed.
- debut and fin define the start and end indices for each thread's segment of the array.
- somme is a static variable used to store the cumulative sum of all array elements, which is updated by each thread.

#### Constructor

~~~ java
public Sommeur(int[] tableau, int debut, int fin) {
    this.tableau = tableau;
    this.debut = debut;
    this.fin = fin;
}
~~~

- The constructor takes three parameters: the array tableau, the start index debut, and the end index fin. These values define which segment of the array the thread will process.

#### run() Method

~~~ java
@Override
public void run() {
    for (int i = debut; i < fin; i++) {
        synchronized (Sommeur.class) {
            somme += tableau[i];
        }
    }
}
~~~
- The run() method is where each thread sums its segment of the array.
- A loop iterates over the segment of the array defined by debut and fin, adding each element to the static somme variable.
- The synchronized block ensures that only one thread can update the somme variable at a time, avoiding race conditions and ensuring thread safety.

~~~ java
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] tableau = new int[20];

        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }
        int nombreDeThreads = 5;
        int tailleSegment = tableau.length / nombreDeThreads;

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < nombreDeThreads; i++) {
            int debut = i * tailleSegment;
            int fin = (i == nombreDeThreads - 1) ? tableau.length : (i + 1) * tailleSegment;
            Sommeur sommeur = new Sommeur(tableau, debut, fin);
            Thread thread = new Thread(sommeur);
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        System.out.println(Sommeur.getSomme());
    }
}
~~~
- The main() method is where the program is executed.
- First, an array tableau of size 20 is created, and it is filled with integers from 1 to 20.
- The array is divided into 5 segments for 5 threads. Each thread will process a specific segment and sum its values.
- A list of threads is created, and for each thread, a Sommeur object is created, passing the appropriate segment of the array.
- The start() method is called on each thread to begin its execution, and join() is used to ensure that the main thread waits for all threads to finish before proceeding.
- Once all threads finish, the getSomme() method is called to retrieve and print the total sum of all the array elements.

 #### Key Points:
1- Multithreading: The array is divided into segments, and each thread computes the sum of a segment.
2-Thread Safety: The synchronized keyword ensures that the static variable somme is updated safely by multiple threads.
3-Concurrency: The threads run concurrently and perform the summation in parallel, improving performance by leveraging multiple processors/cores.
4-Joining Threads: The join() method ensures the main thread waits for all threads to finish before printing the final result.

### Conclusion

In these two exercises, we learned how to implement multithreading in Java. The first exercise showed how to run multiple threads concurrently to print messages, while the second exercise demonstrated dividing a task (summing array elements) into smaller parallel tasks for improved efficiency. Both exercises highlighted the importance of thread synchronization when working with shared data, showcasing how multithreading can enhance performance and ensure safe execution in concurrent environments.

















































