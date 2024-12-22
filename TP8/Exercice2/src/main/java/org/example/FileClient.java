package org.example;

import java.io.*;
import java.net.Socket;

public class FileClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",1234);

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedReader userinput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("entrez le nom du fichier demander");
        String filename = userinput.readLine();

        out.println(filename);
        String response = in.readLine();

        if("Ok".equals(response)){
            receiveFile(socket);
        }
        else {
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

