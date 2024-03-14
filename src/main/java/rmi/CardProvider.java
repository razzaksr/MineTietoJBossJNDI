package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;

public class CardProvider implements CardRemote, Serializable {

    private int[] holders={1200,5600,6700,300,5600,1200,600,4500,2300,530};
    private Registry registry;
    static Context context;

    public CardProvider(){
        try {
            registry = LocateRegistry.createRegistry(1010);
            Hashtable hashtable=new Hashtable();
            hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            hashtable.put(Context.PROVIDER_URL,"rmi://localhost:1010");
            context=new InitialContext(hashtable);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void search(int limit) {
        for(int index=0;index<holders.length;index++){
            if(holders[index]>=limit)
                System.out.println(holders[index]);
        }
    }

    public static void main(String[] args) throws IOException, NamingException {

        CardProvider provider=new CardProvider();

        context.bind("java:/rmi-card",provider);
        System.in.read();
        //Thread.sleep(30000);

    }
}
