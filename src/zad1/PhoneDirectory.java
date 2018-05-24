package zad1;

import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import java.util.*;
import java.io.*;

public class PhoneDirectory extends PortableRemoteObject implements PhoneDirectoryInterface {

    private Map<String, String> phoneBook = new HashMap<>();

    PhoneDirectory(String fileName) throws RemoteException {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(" +", 2);
                phoneBook.put(info[0], info[1]);
            }
        } catch (Exception exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }

    public String getPhoneNumber(String name) throws RemoteException {
        return phoneBook.get(name);
    }

    public boolean addPhoneNumber(String name, String num) throws RemoteException {
        if (phoneBook.containsKey(name)) return false;
        phoneBook.put(name, num);
        return true;
    }

    public boolean replacePhoneNumber(String name, String num) throws RemoteException {
        if (!phoneBook.containsKey(name)) return false;
        phoneBook.put(name, num);
        return true;
    }
}