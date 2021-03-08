import java.rmi.*;

public interface Counter extends Remote{
    public int getValue() throws RemoteException;

    public void nextValue() throws RemoteException;

    public void finishCounter() throws RemoteException;
}
