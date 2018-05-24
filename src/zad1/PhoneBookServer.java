package zad1;

import javax.naming.Context;
import javax.naming.InitialContext;

public class PhoneBookServer  {

    public static void main(String[] args) {
        PhoneDirectory pd = null;
        try {
            String phdFileName = args[0];

            pd = new PhoneDirectory(phdFileName); // utworzenie mapy numerów z pliku

            Context ctx = new InitialContext();
            ctx.rebind("PhoneDirectoryService", pd );
        } catch(Exception exc) {
            exc.printStackTrace();
            System.exit(1);
        }
    }
}