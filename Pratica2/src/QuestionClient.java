import org.w3c.dom.css.Counter;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class QuestionClient {
    public static void main(String[] args){
        String host = (args.length < 1) ? null : args[0];
        String string = (args.length < 2) ? null : args[1];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Question stub = (Question) registry.lookup("1000");
            String msg = stub.correctQuestion(string);
            System.out.println("o servidor diz " + msg);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
