import javax.swing.*;
import java.io.*;

// interface Service (what the GUI services implement)
// defines the one method that any universal service must have—getGuiPanel().
// The interface extends Serializable, so that any class implementing the Service interface will automatically be Serializable.
// That's a must, because the services get shipped over the wire from the server, as a result of the client calling getService() on the remote ServiceServer.
public interface Service extends Serializable {
    public JPanel getGuiPanel();
}