import java.io.*; // Serializable is in the java.io package, so you need the import

//No methods to implement, but when you say "implements Serializable", it says to the JVM, "it’s OK to serialize objects of this type."
public class Box implements Serializable {

    private int width; // these two values will be saved
    private int height;

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.setWidth(50);
        myBox.setHeight(20);

        // I/O operations can throw exceptions
        try {
            FileOutputStream fs = new FileOutputStream("foo.ser"); // Connect to a file named "foo.ser" if it exists. If it doesn’t, make a new file named "foo.ser".
            ObjectOutputStream os = new ObjectOutputStream(fs); // Make an ObjectOutputStream chained to the connection stream.
            os.writeObject(myBox); // Tell it to write the object
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}