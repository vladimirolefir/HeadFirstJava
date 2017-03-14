import java.io.*;
import java.net.*; // class Socket is in java.net

/*
A Socket connection means t he two ma chines have information about each other, including network location (IP address) and TCP port.

To connect to another machine, we need a Socket connection. A Socket ( java.net.Socket class) is an object that represents a network connection between two machines.
What’s a connection? A relationship between two machines, where two pieces of software know about each other.
Most importantly, those two pieces of software know how to communicate with each other. In other words, how to send bits to each other.

To make a Socket connection, you need to know two t hings about the server: who it is, and which port it’s running on. In other words, IP address and TCP port number.

The TCP port numbers from 0 to 1023 are reserved for wellknown services. Don’t use them for your own server programs!*

Your internet web (HTTP) server runs on port 80. That’s a standard. If you’ve got a Telnet server, its running on port
23. FTP? 20. POP3 mail server? 110. SMTP? 25. The Time server sits at 37. Think of port numbers as unique identifiers.
They represent a logical connection to a particular piece of software running on the server.
* */
public class DailyAdviceClient {
    public void go() {
        try {
            Socket s = new Socket("127.0.0.1", 4242); // make a Socket connection to whatever is running on port 4242, on the same host this code is running on. (The 'localhost')
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream()); // Make an InputStreamReader chained to the Socket’s low-level (connection) input stream
            BufferedReader reader = new BufferedReader(streamReader); // chain a BufferedReader to an InputStreamReader to the input stream from the Socket.

            // this readLine() is EXACTLY the same as if you were using a BufferedReader chained to a FILE..
            // In other words, by the time you call a BufferedReader method, the reader doesn’t know or care where the characters came from.
            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);
            reader.close(); // this closes ALL the streams
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }
}