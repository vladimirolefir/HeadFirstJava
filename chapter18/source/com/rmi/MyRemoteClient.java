import java.rmi.*;

/*
javac MyRemoteClient.java
java MyRemoteClient

Don’t forget, the client uses the interface to call methods on the stub. The client JVM needs the stub class, but the client never refers to the stub class in code.
The client always uses the remote interface, as though the remote interface WERE the actual remote object.
* */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello"); // Client does a lookup on the RMI registry
            String s = service.sayHello(); // RMI registry returns the stub object. Client invokes a method on the stub, as though the stub IS the real service
            System.out.println(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}