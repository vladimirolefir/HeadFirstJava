import java.awt.*;
import javax.swing.*;
import java.rmi.*;
import java.awt.event.*;

// class ServiceBrowser (the client)
public class ServiceBrowser {
    JPanel mainPanel;
    JComboBox serviceList;
    ServiceServer server;

    public void buildGUI() {
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        Object[] services = getServicesList();
        serviceList = new JComboBox(services); // Add the services (an array of Objects) to the JComboBox (the list). The JComboBox knows how to make displayable Strings out of each thing in the array.
        frame.getContentPane().add(BorderLayout.NORTH, serviceList);
        serviceList.addActionListener(new MyListListener());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    // Here's where we add the actual service to the GUI, after the user has selected one. (This method is called by the event listener on the JComboBox).
    // We call getService() on the remote server (the stub for ServiceServer)
    // and pass it the String that was displayed in the list (which is the SAME String we originally got from the server when we called getServiceList()).
    // The server returns the actual service (serialized), which is automatically deserialized (thanks to RMI)
    // and we simply call the getGuiPanel() on the service and add  the result (a JPanel) to the browser's mainPanel.
    void loadService(Object serviceSelection) {
        try {
            Service svc = server.getService(serviceSelection);
            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // gets the stub, and calls getServiceList().
    Object[] getServicesList() {
        Object obj = null;
        Object[] services = null;
        try {
            obj = Naming.lookup("rmi://127.0.0.1/ServiceServer");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        server = (ServiceServer) obj;
        try {
            services = server.getServiceList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return services;
    }

    class MyListListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            Object selection = serviceList.getSelectedItem();
            loadService(selection); // If we're here, it means the user made a selection from the JComboBox list.
            // So, take the selection they made and load the appropriate service. (see the loadService method, that asks the server for the service that corresponds with this selection)
        }
    }

    public static void main(String[] args) {
        new ServiceBrowser().buildGUI();
    }
}