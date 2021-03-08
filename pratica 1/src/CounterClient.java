import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CounterClient {
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            int sizeCounter = (int) (Math.random()*(10));
            Registry registry = LocateRegistry.getRegistry(host);
            Counter stub = (Counter) registry.lookup("0001");
            String msgOut = "";
            for (int i = 0; i < sizeCounter; i++){
                int msg = stub.getValue();
                stub.nextValue();
                msgOut += "\n" + msg ;
            }
            System.out.println("Contador:" + msgOut);
            stub.finishCounter();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
