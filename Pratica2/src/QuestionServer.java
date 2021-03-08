import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class QuestionServer implements Question{
    public QuestionServer() {

    }

    public static void main(String[] args){
        try {
            QuestionServer server = new QuestionServer();
            Question stub = (Question) UnicastRemoteObject.exportObject(server, 1292);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("1000", stub);
            System.out.println("Servidor Ligado");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public QuestionClass createQuestion() throws RemoteException {
        QuestionClass q1 = new QuestionClass();
        q1.numeroQuestao = 1;
        q1.numeroAlternativa = 5;
        q1.respostas = "vfvfv";

        return q1;
    }

//    @Override
//    public QuestionClass getQuestion(String s) throws RemoteException {
//
//        return q2;
//    }


    @Override
    public String correctQuestion(String s) throws RemoteException {
        String msg = null;
        String[] received = s.split(";");
        QuestionClass q2 = new QuestionClass();
        q2.numeroQuestao = Integer.parseInt(received[0]);
        q2.numeroAlternativa = Integer.parseInt(received[1]);
        q2.respostas = received[2];
        QuestionClass q1 = createQuestion();

        if(q2.numeroQuestao == q1.numeroQuestao){
            if (q2.numeroAlternativa == q1.numeroAlternativa){
                int points = 0;
                char[] alternativeReceived = q2.respostas.toCharArray();
                char[] alternative = q1.respostas.toCharArray();
                for (int i = 0; i < alternative.length; i++){
                    if(alternative[i] == alternativeReceived[i]){
                        points++;
                    }
                }
                msg = q1.numeroQuestao + ";" + points + ";" + (q2.numeroAlternativa - points);
            }
            else {
                msg = "O número de alternativas não condiz com o número cadastrado";
            }
        }else {
            msg = "Numero da questão incorreto";
        }

        return msg;
    }

}
