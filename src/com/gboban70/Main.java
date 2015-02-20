package com.gboban70;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            URL url =new URL(args[0]);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            connection =(HttpURLConnection) urlConnection;

            BufferedReader in=new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String current;
            // ready to read, so open output file
            FileOutputStream fout = new FileOutputStream(args[1]);
            OutputStreamWriter out = new OutputStreamWriter(fout);
            while((current =in.readLine())!=null)
            {
                out.write(current);
            }
            out.close();
            fout.close();
            in.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}