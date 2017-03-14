/*
Thread is a separate ‘thread of execution’. In other words, a separate call stack. A Thread is a Java class that represents a thread. To make a thread, make a Thread.
Unless you have multiple processors on your computer, each new Java thread is not actually a separate process running on the OS. But it almost feels as though it is.

Runnable is in the java.lang package, so you don’t need to import it. Runnable has only one method to implement: public void run() (with no arguments).
This is where you put the JOB the thread is supposed to run. This is the method that goes at the bottom of the new stack.

Runnable is to a Thread what a job is to a worker. A Runnable is the job a thread is supposed to run. A Runnable holds the method that goes on the bottom of the new t hread’s stack: run().

THREAD SCHEDULER:
The t hread scheduler makes all the decisions about who runs and who doesn’t. He usually makes the threads take turns, nicely.
But there’s no guarantee about that. He mig ht let one thread run to its heart’s content while the other t hreads ‘starve’.
*/
public class MyRunnable implements Runnable {
    public void run() {
        go();
    }
    public void go() {
        // Calling sleep here will force the new thread to leave the currently-running state!
        // The main thread will become the currently-running thread again, and print out “back in main”.
        // Then there will be a pause (for about two seconds) before we get to this line, which calls doMore() and prints out “top o’ the stack
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
        doMore();
    }
    public void doMore() {
        System.out.println("top o’ the stack");
    }
}

class ThreadTester {
    public static void main (String[] args) {
        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob); // Pass the new Runnable instance into the new Thread constructor. This tells the thread what method to put on the bottom of the new stack. In other words, the first method that the new thread will run.
        myThread.start(); // You won’t get a new thread of execution until you call start() on the Thread instance. A thread is not really a thread until you start it. Before that, it’s just a Thread instance, like any other object, but it won’t have any real ‘threadness’.
        System.out.println("back in main");
    }
}

