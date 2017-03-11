// Static variables are initialized when a class is loaded.
// All static variables in a class are initialized before any object of that class can be created.
class Player {
    static int playerCount = 0; // Static variables get default values just like instance variables.

    // A variable marked finalmeans that—once initialized—it can never change.
    // The variable is marked static so that you don’t need an instance of class
    // Constant variable names should be in all caps!
    // 1. At the time you declare it:
    public static final double PI = 3.141592653589793;
    private String name;
    final int stuff = 3; // A. A f inal variable means you can’t change its value.

    public Player(String n) {
        name = n;
        playerCount++;
    }


    public void doStuff(final int x) {
        // A. A f inal variable (x) means you can’t change its value.
    }

    // B. A f inal method means you can’t override the method.
    public final void finalWrapper(int i) {
        int x = 32;
        ArrayList list = new ArrayList();
        list.add(x); // This won’t work unless you’re using Java 5.0 or greater!! There’s no add(int) method in ArrayList that takes an int!
                     // (ArrayList only has add() methods that take object references, not primitives.)
                     // When you need to treat a primitive like an object, wrap it.

        // wrapping value
        int ival = 235;
        Integer iwrapped = new Integer(i);

        // unwrapping value
        int unWrapped = iWrap.intValue();
    }

    // Without autoboxing (Java versions before 5.0)
    public void doNumsOldWay() {
        ArrayList listOfNumbers = new ArrayList();
        listOfNumbers.add(new Integer(3));
        Integer one = (Integer) listOfNumbers.get(0);
        int intOne = one.intValue();
    }

    // Autoboxing: blurring the line bet ween primitive and object The autoboxing feature added to Java 5.0 does the conversion
    public void doNumsNewWay() {
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(3);
        int num = listOfNumbers.get(0);
    }

    public void finWithAutobofing(int x) { // accepts Integer and int
        bool truefalse = true;
        if (truefalse) { // accepts Boolean and bool
            System.out.println("true");
        }

        Integer i = new Integer(42);
        i++; // can be Integer as well as int

        // wrappers contain parse* methods
        String s = "2";
        int x = Integer.parseInt(s);
        double d = Double.parseDouble("420.24");
        boolean b = Boolean.parseBoolean("True");

        return x; // returns Integer and int
    }

    // 2. In a static initializer:
    // If you don’t give a value to a final variable in one of those two places the COmpiler will catch it
    static {
        PI = 3.141592653589793;
    }
}

// A f inal class means you can’t extend the class (i.e. you can’t make a subclass).
final class SuperPlayer extends Player{

}

public class PlayerTestDrive {
    public static void main(String[] args) {
        System.out.println(Player.playerCount);
        Player one = new Player("Tiger Woods");
        System.out.println(Player.playerCount);
    }
}