import java.io.*;

class WriteAFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Foo.txt"); // If the file “Foo.txt” does not exist, FileWriter will create it.
            // BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // this is not necessary, but very effective
            writer.write("hello foo!");
            writer.close();                                // Close it when you’re done!
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}