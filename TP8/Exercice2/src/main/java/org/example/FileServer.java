package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket=new ServerSocket(123);

        while (true){
            Socket socket=serverSocket.accept();
            System.out.println("le client " + socket.getInetAddress());
            new ClientHandler(socket).start();
        }
    }


}
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
