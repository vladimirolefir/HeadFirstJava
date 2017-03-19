import java.rmi.*;

/*
Step one: Make a Remote Interface
- Extend java.rmi.Remote
- Declare that all methods throw a RemoteException
- Be sure arguments and return values are primitives or Serializable
* */
public interface MyRemote extends Remote {
    public String sayHello() throws RemoteException;
}