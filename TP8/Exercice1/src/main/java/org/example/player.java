package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class player {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",123);
        Scanner scanner = new Scanner(System.in);


        InputStream in = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


        String responce;
        while (true) {
            System.out.println("number is ");
            String number = scanner.nextLine();
            out.println(number);
            responce = reader.readLine();
            System.out.println(responce);
            if(responce != null && responce.startsWith("felecitation")){
                break;
            }
        }

    }


}
