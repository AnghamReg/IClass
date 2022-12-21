import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerNbAbsence extends Thread{
    private int nb;
    private String[] classeEtAbsence; // [nomClasse] [nbAbsence]
    private Map<String,Integer> classeAbsence;
    public ServerNbAbsence(int n){
        nb=n;
        classeAbsence=new HashMap<String,Integer>();
    }
    public void run() {

        try {
            ServerSocket socketServeur = new ServerSocket(8080);
            System.out.println("Serveur en attente");

            while (true) {
                nb++;
                //Attendre connexion du client
                Socket socket = socketServeur.accept();
                System.out.println("Le client n" + nb + " est connecté");
                System.out.println("mes classes et leurs absences : " + classeAbsence.toString());
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String message = dataInputStream.readUTF();
                System.out.println("2) Socket du serveur a lit msg = " + message);

                classeEtAbsence = message.split(" ", 2);
                String nomClasse = classeEtAbsence[0];
                int nbAbsence = Integer.parseInt(classeEtAbsence[1]);
                classeAbsence.put(nomClasse, nbAbsence);

                System.out.println("mes classes et leurs absences : " + classeAbsence.toString());
                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int nb=0;
        new ServerNbAbsence(0).run();

    }
}
