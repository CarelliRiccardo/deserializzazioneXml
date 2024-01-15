package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String string = in.readLine();

            ObjectMapper objectMapper = new ObjectMapper();
            Classe classe = objectMapper.readValue(string, Classe.class);
            System.out.println(classe.numero);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
