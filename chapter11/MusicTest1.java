import javax.sound.midi.*;

// The compiler checks for everything except RuntimeExceptions.
// RuntimeExceptions are NOT checked by the compiler. They are known as (big surprise here) "unchecked exceptions".
public class MusicTest1 {

    // with throw: error: unreported exception MidiUnavailableException; must be caught or declared to be thrown
    // If you wrap the risky code in something called a try/catch, the compiler will relax.
    // A try/catch block tells the compiler that you know an exceptional thing could happen in the  method you’re calling, and that you’re prepared to handle it.
    // That compiler doesn’t care how you handle it; it cares only that you say you’re taking care of it.
    public void play() {

        try{
            Sequencer sequencer = MidiSystem.getSequencer(); // The getSequencer() method takes a risk. It can fail at runtime.
                                                             // So it must ‘declare’ the risk you take when you call it.
            System.out.println("We got a sequencer");

        } catch(MidiUnavailableException ex) {
            System.out.println("Bummer");
        } finally {
            System.out.println("We will always be here"); // A finally block is where you put code that must run regardless of an exception.
        }
    } // close play

    // 1. Risky, exception-throwing code:
    public void takeRisk() throws Exception, IOException {
        if (true) {
            throw new Exception();
        }
    }

    // 2. Your code that calls the risky method:
    public void crossFingers() {
        try {
            takeRisk();
        } catch (IOException ex) { // we should catch from most specific to least specific
            System.out.println("Aaargh IOException!");
        }
        catch (Exception ex) {
            System.out.println("Aaargh!");
            ex.printStackTrace();
        }
    }

    // 3. If you don’t want to handle an exception, you can duck it by declaring it.
    public void crossFingersSkipHandling() throws Exception, IOException {
        takeRisk();
    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    } // close main

} // close class