package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConjugaisonInterface extends Remote {
    public String conjuguer(String tempEtVerbe) throws RemoteException;
}
