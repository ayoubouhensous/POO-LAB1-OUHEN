package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class server {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(123);
        System.out.println("waiting the player");
        Random random = new Random();
        int magicnumber = random.nextInt(100);

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        PrintWriter writer = new PrintWriter(outputStream,true);

        String responce ;

        while ((responce=reader.readLine()) != null){
                int guesse = Integer.parseInt(responce);
                if( guesse < magicnumber ){
                    writer.println("trop petite");
                } else if (guesse > magicnumber) {
                    writer.println("trop grande");
                }
                else {
                    writer.println("felecitation player");
                    break;
                }
            }


    }
}
