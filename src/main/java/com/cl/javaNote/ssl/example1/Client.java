package com.cl.javaNote.ssl.example1;

/**
 * Created by cl on 2017/12/1.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 9091);
        PrintWriter writer = new PrintWriter(s.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        writer.println("hello");
        writer.flush();
        System.out.println(reader.readLine());
        s.close();
    }
}