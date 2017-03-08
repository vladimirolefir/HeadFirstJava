
// An object becomes eligible for GC when its last live reference disappears.
// Object-killer #1. Reference goes out of scope, permanently.
// Object-killer #2. Assign the reference to another object.
// Object-killer #3. Explicitly set the reference to null.
public class Animal {
    int val = 0;
    public Animal() {
        val = 0;
        System.out.println("Making an Animal");
    }

    public Animal(int val) {
        this.val = val;
        System.out.println("Making an Animal");
    }
}


// All objects live in the heap, regardless of whether the reference is a local or instance variable.
public class Duck extends Animal {
    int size; // Instance variables are declared inside a class but not inside a method. They represent the “fields” that each individual object has (which can be filled with different values for each instance of the class). They live inside the object they belong to.
    Object o; // If the local variable is a reference to an object, only the variable (the reference/remote control) goes on the stack.
    int smth; // An instance variable lives as long as the object does. If the object is still alive, so are its instance variables.

    // Local variables are declared inside a method, including method parameters. They’re temporary, and live only as long as the method is on the stack (in other words, as long as the method has not reached the closing curly brace).
    // Methods are stacked. The method on the top of the stack is always the currentlyexecuting method.
    public void foo(int x) {
        int i = x + 3;
        boolean b = true; // A local variable lives only within the method that declared the variable.
    }

    // The key feature of a constructor is that it runs before the object can be assigned to a reference. That means you get a chance to step in and do things to get the object ready for use.
    public Duck() {
        super(); // this is how we call superclass constructor. The call to super() must be the first statement in each constructor!*
        System.out.println("Quack");
    }

    /*
        If you do provide a constructor but you do not put in the call to super()
        The compiler will put a call to super() in each of your overloaded constructors.*
        The compiler-supplied call looks like: super(); It always looks like that.
        The compilerinserted call to super() is always a no-arg call.
        If the superclass has overloaded constructors, only the no-arg one is called.
        If you don’t provide a constructor If you do provide a constructor but you do not put in the call to super()
        *Unless the constructor calls another overloaded constructor
    * */
    public Duck(int size) {
        super(size); // this is how we call superclass constructor
        System.out.println("Quack");
    }

    // Calling overloaded constructor
    public Duck(int size, int val){
        this(val); // Every constructor can have a call to super() or this(), but never both!
    }
}