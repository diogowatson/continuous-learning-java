package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatServer {
    public static  void main(String[] argv){
        try{
            Scanner s = new Scanner(System.in);
            Chat server = new Chat("Ali");

            Registry registry = LocateRegistry.createRegistry(2020);
            registry.rebind("Chat", server);

            System.out.println("[System] Chat remote object is ready:");
            while(true){
                String msg = s.nextLine().trim();
                if(server.getClient() != null){
                    ChatInterface client = server.getClient();
                    msg = "[" + server.getName() + "]" + msg;

                }
            }

        }catch (Exception e){
            System.out.println("[System] Server failed" + e);
        }
    }
}
