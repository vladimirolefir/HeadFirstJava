public class Animal{
    public void roam(){
        System.out.println("Animal: roam");
    }
}

/*
Some classes hould not be instantiated directly

An abstract class has virtually* no use, no value, no purpose in life, unless it is extended. With an abstract class, the guys doing the work at runtime are instances of a subclass of your abstract class.
But abstract classes can contain STATIC members
*/
public abstract class Canine extends Animal{
    public void roam(){
        System.out.println("Animal: roam");
    }
    /* abstract methods has no bodies. if these is at least one abstact method, you should mark the whole classs abstract */
    public abstract void eat();
}