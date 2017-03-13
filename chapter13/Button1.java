import javax.swing.*;
import java.awt.*;

/*
A widget is technically a Swing Component. Almost every thing you can stick in a GUI extends from javax.swing.JComponent.

LAYOUT MANAGERS:

BorderLayout
A BorderLayout manager divides a background component into five regions.

FlowLayout
A FlowLayout manager acts kind of like a word processor, except with components instead of words. Each component is the size it wants to be.

BoxLayout
A BoxLayout manager is like FlowLayout in that each component gets to have its own size,
and the components are placed in the order in which they’re added.
But, unlike FlowLayout, a BoxLayout manager can stack the components vertically
(or horizontally, but usually we’re just concerned with vertically).
* */
public class Button1 {
    public static void main(String[] args) {
        Button1 gui = new Button1();
        gui.go();
    }

    public void go() {
        /* Four steps to making a GUI (review) */

        // Make a window (a JFrame)
        JFrame frame = new JFrame();

        // Make a component (button, text field, etc.)
        JButton button = new JButton("click me");

        // Add the component to the frame
        frame.getContentPane().add(BorderLayout.EAST, button);

        // Display it (give it a size and make it visible)
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    public void go() {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        // The BoxLayout constructor needs to know the component its laying out (i.e., the panel) and which axis to use (we use Y_AXIS for a vertical stack).
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Change the layout manager to be a new instance of BoxLayout.

        JButton button = new JButton("shock me");
        JButton buttonTwo = new JButton("bliss");

        panel.add(button);
        panel.add(buttonTwo);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250,200);
        frame.setVisible(true);
    }
}