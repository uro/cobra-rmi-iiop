package zad1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PhoneDirectoryInterface extends Remote {

    String getPhoneNumber(String name) throws RemoteException;

    boolean addPhoneNumber(String name, String num) throws RemoteException;

    boolean replacePhoneNumber(String name, String num) throws RemoteException;
}
