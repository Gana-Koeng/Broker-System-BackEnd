
package csx.broker.tcp;

import csx.broker.Entity.broker.Broker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.String.format;

public class GreetClient {
    private static Broker msgSend;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws Exception {

            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(clientSocket.getInputStream());


    }

    public String sendMessage(Broker broker) throws Exception {

        String msgSend =    "A2"                                                      +
                            format("%09d",broker.getIssueCode())                      +
                            format("%04d",Integer.parseInt(broker.getBrokerId()))     +
                            format("%04d",Integer.parseInt(broker.getAccountNo()))    +
                            format("%08d",broker.getOriginalOrderNo())                +
                            format("%08d", broker.getOrderQty())                      +
                            format("%08d", broker.getOrderUV());

        out.println(msgSend);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection()  {
        try{
            in.close();
            out.close();
            clientSocket.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        GreetClient client = new GreetClient();
        try{
            client.startConnection("10.10.18.248", 5000);

         
            client.sendMessage(msgSend);

        }catch (Exception e){
            client.stopConnection();
        }
    }
}