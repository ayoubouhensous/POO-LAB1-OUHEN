
# TP8 : Sockets en Java

This project focuses on socket programming in Java, implementing two exercises that demonstrate client-server communication. The first exercise involves a guessing game, and the second exercise involves file transfer.
=

## Overview
This project illustrates the use of sockets in Java to enable communication between a server and clients. It includes:

A guessing game where the player attempts to guess a randomly generated number.
A file transfer system where the client can request a file from the server.

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies Used](#technologies-used)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Exercises](#exercises)
   - [Exercise 1: Exercise 1: Guessing Game](#guessing-game)
   - [Exercise 2: Exercise 2: File Transfer](#exercise-2:file-transfer)
6. [Conclusion](#Conclusion)

### Introduction

Socket programming allows for communication between computers over a network. In Java, the Socket and ServerSocket classes are used to implement this communication.

In this project, we explored two practical exercises:

In the first exercise, a server generates a random number, and the player attempts to guess this number, receiving feedback on whether their guess is too high or too low.
In the second exercise, the client requests a file from the server, which sends the file if it exists.

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

### Exercise 1: Exercise 1: Guessing Game

In this exercise, a server generates a random number between 0 and 99, and the client tries to guess it.

#### Class Definition
~~~ java
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(123);
        System.out.println("Waiting for the player...");
        Random random = new Random();
        int magicNumber = random.nextInt(100);
~~~
The Server class contains the main method that sets up a server socket on port 123, waiting for a client to connect.
A random number (magicNumber) is generated between 0 and 99 using the Random class, which the client will try to guess.

#### Accepting Connections

~~~ java
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

~~~
The accept() method blocks until a client connects to the server. Once a connection is established, it creates a Socket object representing the connection.
Input and output streams are obtained from the socket to read from and write to the client.

#### Reading and Writing Data

~~~ java
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter writer = new PrintWriter(outputStream, true);

~~~
A BufferedReader is created to read input from the client, and a PrintWriter is used to send responses back to the client.
The true parameter in PrintWriter enables auto-flushing, which means that the output will be sent immediately without needing to call flush() explicitly.

#### Key Points:
1 - Socket Programming: The server uses sockets to communicate with the client.
2- Random Number Generation: A random number is generated for the client to guess.
3- Input/Output Streams: The server reads guesses from the client and sends feedback using streams.
4- Loop and Conditionals: The server uses a loop to continuously process guesses and conditional statements to provide appropriate feedback.



### Exercise 2:  File Transfer

In this exercise, the server listens for incoming connections from clients, allowing them to request a file. If the file exists, the server sends it to the client; otherwise, it returns an error message.


####FileServer Class

~~~ java
package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(123);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Le client " + socket.getInetAddress());
            new ClientHandler(socket).start();
        }
    }
}

~~~

The FileServer class sets up a server socket that listens on port 123.
Inside an infinite loop, it waits for clients to connect. When a client connects, it creates a new ClientHandler thread to manage the communication with that client.
The server prints the client's IP address when a connection is accepted.

#### Client Handler Class

~~~ java
class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String filename = in.readLine();
            System.out.println("Demande de fichier : " + filename);

            File file = new File(filename);
            if (file.exists() && !file.isDirectory()) {
                out.println("Ok");
                sendfile(file);
            } else {
                out.println("Error");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendfile(File file) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            OutputStream os = socket.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

~~~

The ClientHandler class extends Thread and handles the communication with a connected client.
It reads the requested filename from the client. If the file exists, it sends an "Ok" response and calls the sendfile method to transfer the file.
If the file does not exist, it sends an "Error" response.
The sendfile method reads the file in chunks (4096 bytes) and sends it over the socket to the client.

#### Client Class Definition

~~~ java
package org.example;

import java.io.*;
import java.net.Socket;

public class FileClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 123);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Entrez le nom du fichier demander");
        String filename = userinput.readLine();

        out.println(filename);
        String response = in.readLine();

        if ("Ok".equals(response)) {
            receiveFile(socket);
        } else {
            System.out.println(response);
        }
    }

    private static void receiveFile(Socket socket) {
        try (BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream("received_file"))) {
            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                fileOut.write(buffer, 0, bytesRead);
            }
            fileOut.flush();
            System.out.println("Fichier reçu et sauvegardé sous 'received_file'");
        } catch (IOException e) {
            System.err.println("Erreur lors de la réception du fichier : " + e.getMessage());
        }
    }
}

~~~
The FileClient class connects to the server on localhost at port 123.
It prompts the user to enter the filename they want to request and sends it to the server.
If the server responds with "Ok", the client calls the receiveFile method to save the incoming file.
The receiveFile method reads the file data in chunks and writes it to a file named received_file.

 #### Key Points:
1- Socket Communication: The server and client use sockets to establish a connection and communicate.
2-File Transfer: The server sends a requested file to the client if it exists; otherwise, it sends an error message.
3-Threading: The server handles multiple clients simultaneously using threads, allowing each client to be processed independently.
4-Buffered Streams: Buffered input and output streams are used to efficiently read and write data in chunks, improving performance.

### Conclusion

In this two exercise, we successfully developed two applications: one for file transfer and the other for a number-guessing game. The file transfer application demonstrated the principles of client-server communication using Java sockets, showcasing how to send and receive files efficiently while handling multiple client requests with multithreading. Meanwhile, the number-guessing game illustrated basic programming concepts, including loops and conditional statements, while engaging users in a fun and interactive way. Together, these projects reinforced our understanding of network programming, multithreading, and user interaction, providing a solid foundation for future development in these areas. Overall, both applications serve as practical examples of core programming principles applied in real-world scenarios.







