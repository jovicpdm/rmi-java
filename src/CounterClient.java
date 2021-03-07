import java.rmi.registry.*;

public class CounterClient {
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Counter stub = (Counter) registry.lookup("ServerCont");
            int msg = stub.getValue();
            stub.nextValue();
            System.out.println("Contador:" + msg);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    }
