import java.rmi.*;

public interface Question extends Remote {

//    public QuestionClass getQuestion(String s) throws RemoteException;

    public QuestionClass createQuestion() throws RemoteException;

    public String correctQuestion(String s) throws RemoteException;
}
