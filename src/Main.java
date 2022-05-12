import interfaces.ConjugaisonInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class Main {
    private static ConjugaisonInterface conjugaisonInterface;
    private static BufferedReader reader;
    public static void main(String[] args) {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            initConnection();
            while (true) {
                System.out.println("Saisissez un verbe à l'infinif suivit d'un temp (présent,futur,passé composé) sous la forme verbe,temp");
                try {
                    String verbEtTemp = reader.readLine();
                    String resultat = conjugaisonInterface.conjuguer(verbEtTemp);
                    System.out.println(resultat);

                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void initConnection() throws IOException, NotBoundException {
        System.out.println("Saisissez l'adresse de connection ainsi que le port sous la forme url:port (localhost:2000)");

        String url = reader.readLine();
        conjugaisonInterface = (ConjugaisonInterface) Naming.lookup("rmi://"+url+"/conjugaison");
    }
}
