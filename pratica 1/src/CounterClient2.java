import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CounterClient2 {
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            int sizeCounter = (int) (Math.random()*(10));
            Registry registry = LocateRegistry.getRegistry(host);
            Counter stub = (Counter) registry.lookup("1212");
            for (int i = 0; i < sizeCounter; i++){
                int msg = stub.getValue();
                stub.nextValue();
                System.out.println("Contador:" + msg);
            }
            stub.finishCounter();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    }
