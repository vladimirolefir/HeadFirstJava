
/*
In the “Lost Update” problem, we have two threads, both trying to increment the balance.

Every Java object has a lock. A lock has only one key. Most of the time, t he lock is unlocked and nobody cares.
But if an object has synchronized methods, a thread can enter one of t he synchronized methods ONLY if the key for the object’s lock is available.
In other words, only if another thread hasn’t already gra bbed t he one key.

Synchronization doesn’t come for free.
First, a synchronized method has a certain amount of overhead. In other words, when code hits a synchronized method, there’s going to be a performance hit
(although typically, you’d never notice it) while the matter of “is the key available?” is resolved.
Second, a synchronized method can slow your program down because synchronization restricts concurrency.
In other words, a synchronized method forces other threads to get in line and wait their turn.
This might not be a problem in your code, but you have to consider it.
Third, and most frightening, synchronized methods can lead to DEADLOCK:
Thread deadlock happens when you have two threads, both of which are holding a key the other thread wants.
There’s no way out of this scenario, so the two threads will simply sit and wait. And wait. And wait.
* */
class TestSync implements Runnable {
    private int balance;
    public void run() {
        for(int i = 0; i < 50; i++) {
            increment();
            System.out.println("balance is " + balance);
        }
    }

    // doStuff() doesn’t need to be synchronized, so we don’t synchronize the whole method
    public void go() {
        doStuff();

        // Now, only these two method calls are grouped into one atomic unit.
        // When you use the synchronized keyword WITHIN a method, rather than in a method declaration,
        // you have to provide an argument that is the object whose key the thread needs to get.
        // Although there are other ways to do it, you will almost always synchronize on the current object (this).
        // That’s the same object you’d lock if the whole method were synchronized.
        synchronized(this) {
            criticalStuff();
            moreCriticalStuff();
        }
    }

    public void doStuff() {
    }

    public void criticalStuff() {
    }

    public void moreCriticalStuff() {
    }

    /*
    Use the synchronized keyword to modify a method so that only one thread at a time can access it.
    The synchronized keyword means that a thread needs a key in order to access the synchronized code.
    To protect your data (like the bank account), synchronize the methods that act on that data.
    * */
    public synchronized void increment() {
        int i = balance;
        balance = i + 1;
    }
}
public class TestSyncTest {
    public static void main (String[] args) {
        TestSync job = new TestSync();
        Thread a = new Thread(job);
        Thread b = new Thread(job);
        a.start();
        b.start();
    }
}