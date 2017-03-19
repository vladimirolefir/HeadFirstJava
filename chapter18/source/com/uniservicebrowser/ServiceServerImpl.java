import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

// class ServiceServerImpl (the remote implementation)
public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer { // A normal RMI implementation

    // The services will be stored in a HashMap collection.
    // Instead of putting ONE object in the collection, you put TWO -- a key object (like a String) and a value object (whatever you want).
    HashMap serviceList;

    public ServiceServerImpl() throws RemoteException {
        setUpServices();
    }

    private void setUpServices() {
        serviceList = new HashMap();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the Week Service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }

    // Client calls this in order to get a list of services to display in the browser (so the user can select one).
    // We send an array of type Object (even though it has Strings inside) by making an array of just the KEYS that are in the HashMap.
    // We won't send an actual Service object unless the client asks for it by calling getService().
    public Object[] getServiceList() {
        System.out.println("in remote");
        return serviceList.keySet().toArray();
    }

    // Client calls this method after the user selects a service from the displayed list of services (that it got from the method above).
    // This code uses the key (the same key originally sent to the client) to get the corresponding service out of the HashMap.
    public Service getService(Object serviceKey) throws RemoteException {
        Service theService = (Service) serviceList.get(serviceKey);
        return theService;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Remote service is running");
    }
}