import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // a new import statement for the package that ActionListener and ActionEvent are in.

// Implement the interface. This says, “an instance of SimpleGui1B IS-A ActionListener”. (The button will give events only to ActionListener implementers)
// Listeners, Sources, and Events
// Listener GETS the event. Source SENDS the event. Event object HOLDS DATA about the event
public class SimpleGui1B implements ActionListener {
    JButton button;

    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        /*
        register your interest with the button. This says to the button, “Add me to your list of listeners”.
        The argument you pass MUST be an object from a class that implements ActionListener!!
        * */
        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // Implement the ActionListener interface’s actionPerformed() method.. This is the actual event-handling method!
    public void actionPerformed(ActionEvent event) {
        button.setText("I’ve been clicked!");
    }
}

/*
If you want to put your own graphics on the screen, your best bet is to make your own paintable widget.
You plop that widget on the frame, just like a button or any other widget, but when it shows up it will have your images on it.
You can even make those images move, in an animation, or make the colors on the screen change every time you click a button.
It’s a piece of cake. Make a subclass of JPanel and override one method, paintComponent().
*/

class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) { // The object referenced by the ‘g’ parameter is actually an instance of the Graphics2D class.
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);
    }
}