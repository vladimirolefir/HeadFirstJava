/*
Step two: Make a Remote Implementation
- Implement the Remote interface
- Extend UnicastRemoteObject
- Write a no-arg constructor that declares a RemoteException
- Register the service with the RMI registry

Step three: generate stubs and skeletons
- Run rmic on the remote implementation class (not the remote interface)
%javac MyRemoteImpl.java
%rmic MyRemoteImpl

Step four: run rmiregistry
- Bring up a terminal and start the
%rmiregistry

Step five: start the service
- Bring up another terminal and start your service
%java MyRemoteImpl
* */

import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public String sayHello() {
        return "Server says, 'Hey'";
    }

    public MyRemoteImpl() throws RemoteException {
    }

    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}