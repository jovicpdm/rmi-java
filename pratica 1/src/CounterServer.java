import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class CounterServer implements Counter{
    int counter = 0;
    public CounterServer(){
//        counter ++;
    }

    int referenceCounter = counter;

    public static void main(String[] args){
        try {
            CounterServer server = new CounterServer();
            Counter stub = (Counter) UnicastRemoteObject.exportObject(server, 1291);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("1212", stub);
            System.out.println("Servidor Ligado");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int getValue() throws RemoteException {
        return referenceCounter;
    }

    @Override
    public void nextValue() throws RemoteException {
        referenceCounter++;
    }

    @Override
    public void finishCounter() throws RemoteException {
        referenceCounter = counter;
    }

}