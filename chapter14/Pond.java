import java.io.*;

public class Pond implements Serializable { // Pond objects can be serialized
    private transient Duck duck = new Duck(); // Mark an instance variable as transient if it can’t (or shouldn’t) be saved.

    // you can version your serialization, but this is total gemorroy, forget for now
    // Use the serialver command-line tool to get the version ID for your class
    static final long serialVersionUID = -6849794470754667710L;

    public static void main(String[] args) {
        Pond myPond = new Pond();
        try {
            FileOutputStream fs = new FileOutputStream("Pond.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myPond); // Class Pond has one instance variable, a Duck. When you serialize myPond (a Pond object), its Duck instance variable automatically gets serialized.
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Deserialization
        try {
            FileInputStream fileStream = new FileInputStream("Pond.ser"); // Make a FileInputStream
            ObjectInputStream os = new ObjectInputStream(fileStream);     // Make an ObjectInputStream
            Object one = os.readObject();                                 // read the objects
            Pond elf = (Pond) one;                                        // Cast the objects
            os.close();                                                   // Close the ObjectInputStream
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


// Yikes!! Duck is not serializable! It doesn’t implement Serializable, so when you try to serialize a Pond object, it fails because the Pond’s Duck instance variable can’t be saved.
// WHen you mark class as public it MUST go to its own file!!!
public class Duck {
// duck code here
}