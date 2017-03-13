import javax.swing.*; // don’t forget to import this swing package

public class SimpleGui1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame(); // make a frame and a button
        JButton button = new JButton("click me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this line makes the program quit as soon as you close the window (if you leave this out it will just sit there on the screen forever)
        frame.getContentPane().add(button); // add the button to the frame’s content pane
        frame.setSize(300, 300);
        frame.setVisible(true); finally, make it visible!! (if you forget this step, you won’t see anything when you run this code)
    }
}