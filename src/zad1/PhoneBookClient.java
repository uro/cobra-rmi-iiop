package zad1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class PhoneBookClient {

    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();

            Object objref = ctx.lookup("PhoneDirectoryService");

            PhoneDirectoryInterface pd;
            pd = (PhoneDirectoryInterface) PortableRemoteObject.narrow(
                    objref, PhoneDirectoryInterface.class);

            String name = "Arkadiusz";
            String phoneNumber = pd.getPhoneNumber(name);
            System.out.println(name + " - number: " + phoneNumber);

        } catch( Exception e ) {
            e.printStackTrace( );
        }
    }
}