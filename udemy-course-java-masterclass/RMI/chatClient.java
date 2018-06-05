package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class chatClient {
    public static void main(String[] argv){
        try{
            ChatInterface client = new Chat("Ali");
            Scanner s = new Scanner(System.in);
            Registry registry = LocateRegistry.getRegistry(2020);
            ChatInterface server = (ChatInterface)registry.lookup("Chat");
            String msg = "[" + client.getName() + "] got connected";
            server.send(msg);
            System.out.println("[System] Chat remote object is ready:");
            server.setClient(client);
            while(true){
                msg = s.nextLine().trim();
                msg = "[" + client.getName() +"]" + msg;
                server.send(msg);

            }
        }catch (Exception e){
            System.out.println("[System] Server failed: " + e);
        }
    }
}
