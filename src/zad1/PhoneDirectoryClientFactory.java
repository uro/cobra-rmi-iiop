package zad1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class PhoneDirectoryClientFactory
{
    public static PhoneDirectoryInterface create() throws NamingException {
        Context ctx = new InitialContext();

        Object objref = ctx.lookup("PhoneDirectoryService");

        return(PhoneDirectoryInterface) PortableRemoteObject.narrow(objref, PhoneDirectoryInterface.class);
    }
}
