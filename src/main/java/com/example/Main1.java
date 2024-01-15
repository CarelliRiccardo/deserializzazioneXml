package com.example;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main1 {
    public static void main(String[] args) {
        Alunno alunno1 = new Alunno("Mario", "Rossi", new Date(2000, 1, 1));
        Alunno alunno2 = new Alunno("Luigi", "Verdi", new Date(2000, 2, 2));
        Alunno alunno3 = new Alunno("Giovanni", "Bianchi", new Date(2000, 3, 3));
        Alunno alunno4 = new Alunno("Paolo", "Neri", new Date(2000, 4, 4));
        ArrayList<Alunno> alunni = new ArrayList<Alunno>();
        alunni.add(alunno1);
        alunni.add(alunno2);
        alunni.add(alunno3);
        alunni.add(alunno4); 
        Classe classe = new Classe(1, "A", "Aula 1", alunni);


        
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            ObjectMapper objectMapper = new ObjectMapper ();
            String outString = objectMapper.writeValueAsString(classe);

            output.writeBytes(outString + "\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}