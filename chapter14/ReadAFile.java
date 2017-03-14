import java.io.*;

/*
If there were no buffers, it would be like shopping without a cart. You’d have to carry each thing out to your car, one soup can or toilet paper roll at a time.

buffers give you a temporary holding place to group things until the holder (like the cart) is full. You get to make far fewer trips when you use a buffer

The cool thing about buffers is that they’re much more efficient than working without them.
You can write to a file using FileWriter alone, by calling write(someString), but FileWriter writes each and every thing you pass to the file each and every time.
That’s overhead you don’t want or need, since every trip to the disk is a Big Deal compared to manipulating data in memory.
By chaining a BufferedWriter onto a FileWriter, the BufferedWriter will hold all the stuff you write to it until it’s full.
Only when the buffer is full will the FileWriter actually be told to write to the file on disk.

If you do want to send data before the buffer is full, you do have control. Just Flush It. Calls to writer.flush() say, “send whatever’s in the buffer, now!”
* */
class ReadAFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("MyText.txt");
            FileReader fileReader = new FileReader(myFile); // A FileReader is a connection stream for characters, that connects to a text file

            // Chain the FileReader to a BufferedReader for more efficient reading.
            // It’ll go back to the file to read only when the buffer is empty (because the program has read everything in it).
            BufferedReader reader = new BufferedReader(fileReader);

            // Make a String variable to hold each line as the line is read
            String line = null;
            while ((line = reader.readLine()) != null) {
                // This says, “Read a line of text, and assign it to the String variable ‘line’.
                // While that variable is not null (because there WAS something to read) print out the line that was just read.”
                // Or another way of saying it, “While there are still lines to read, read them and print them.”
                System.out.println(line);
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}