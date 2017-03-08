/*
Inheritance:
When you call a method on an object reference, you’re calling the most specific version of the method for that object type.
In other words, the lowest one wins!

Polymorphysm:
When you define a supertype for a group of classes, any subclass of that supertype can be substituted where the supertype is expected.
With polymorphism, you can write code that doesn’t have to change when you introduce new subclass types into the program.
*/

public class Doctor {
    boolean worksAtHospital;    // This is package-private (visible within package)

    void treatPatient() {       // This is package-private as well.
        // perform a checkup
    }
}

public class FamilyDoctor extends Doctor {
    boolean makesHouseCalls;

    void giveAdvice() {
        // give homespun advice
    }
}

public class Surgeon extends Doctor {
    void treatPatient() {
        // perform surgery
    }

    void makeIncision() {
        // make incision (yikes!)
    }
}

public class Program {
    public static void main(String[] args){
        Doctor doc = new Doctor(); // The important point is that the reference type AND the object type are the same.

        Doctor fd = new FamilyDoctor(); // But with polymorphism, the reference and the object can be different.
    }
}