package zad1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class PhoneBookClient {

    public static void main(String[] args) {
        try {
            PhoneDirectoryInterface pd = PhoneDirectoryClientFactory.create();

            String name = "Arkadiusz";
            String phoneNumber = pd.getPhoneNumber(name);
            System.out.println(name + " - number: " + phoneNumber);

        } catch( Exception e ) {
            e.printStackTrace( );
        }
    }
}