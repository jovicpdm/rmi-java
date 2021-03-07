import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class CounterServer implements Counter{
    int counter = 0;
    public CounterServer(){
//        counter ++;
    }

    public static void main(String[] args){
        try {
            CounterServer server = new CounterServer();
            Counter stub = (Counter) UnicastRemoteObject.exportObject(server, 4444);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("ServerCont", stub);
            System.out.println("Servidor Ligado");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public int getValue() throws RemoteException {
        return this.counter;
    }

    @Override
    public void nextValue() throws RemoteException {
        this.counter++;
    }
}