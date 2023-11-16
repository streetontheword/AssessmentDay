package sdf.task02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private static String SERVER;
    private static int PORT;

    // write a client side
    public static void main(String[] args) throws UnknownHostException, IOException {

        if (args.length == 0) {
            SERVER = "127.0.0.1";
            PORT = 3000;
            System.out.printf("Attempting to connect to 127.0.0.1, on PORT %d\n", PORT);

            SERVER = "127.0.0.1";
            PORT = 3000;
            Socket clientSocket = new Socket(SERVER, PORT);

            System.out.println("connected to server");
           
        } else if (args.length ==1){ 
        
            System.out.printf("Attempting to connect to 127.0.0.1, on PORT %d\n", args[0]);
            SERVER = "127.0.0.1";
            PORT = Integer.parseInt(args[0]);
            Socket clientSocket = new Socket(SERVER, PORT);
    
            System.out.println("Connected to server");
        
        } else 
        {

            System.out.printf("Attempting to connect to %s\n", args[0]);
            String[] serverPort = args[0].split(":");
            SERVER = serverPort[0];
            PORT = Integer.parseInt(serverPort[1]);
            Socket clientSocket = new Socket(SERVER, PORT);

            System.out.println("Connected to server");
            

    
            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = clientSocket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            // reader to accept the input from the server
            String serverResponse;
            while ((serverResponse = br.readLine()) != null) {
                serverResponse = serverResponse.trim();
                
                if (serverResponse.equals("prod_end")){
                    continue;
                }
                
                
                String[] keyValuePair = serverResponse.split(":");
                String key = keyValuePair[0];
                String value = keyValuePair[1].trim();

                switch (key){
                    case "prod_id":
                    Product prod = new Product(value);
                    prod.setProductId(Integer.parseInt(value));
                    break;

                    case "title":
                    prod.setNameOfProduct(value);
                    break;

                    case "price":
                    prod.setPrice(Double.parseDouble(value));
                    break;

                    case "rating":
                    prod.setRating(Double.parseDouble(value));
                    break;
                }


            }
        }
        }


        
    }
    

