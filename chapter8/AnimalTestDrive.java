public interface Pet {
    public abstract void beFriendly(); // all interface methods are implicitly public and abstract.
    public abstract void play();
}

public abstract class Animal{
    public void roam(){
        roamconcrete();
    }

    public abstract void roamconcrete();
}

public class Dog extends Animal implements Pet{
    public void roamconcrete(){
        System.out.println("Dog: roam");
    }

    public void roam(){
        super.roam(); // this is how we call method of superclass from overridden method
    }

    public void beFriendly(){
        System.out.println("Dog: beFriendly");
    }

    public void play(){
        System.out.println("Dog: play");
    }
}

public class Cat extends Animal{
    public void roamconcrete(){
        System.out.println("Cat: roam");
    }
}

public class MyAnimalList {
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;
    public void add(Animal a) {
        if (nextIndex < animals.length) {
            animals[nextIndex] = a;
            System.out.println("Animal added at " + nextIndex);
            nextIndex++;
        }
    }
}

public class AnimalTestDrive{
    public static void main (String[] args) {
        MyAnimalList list = new MyAnimalList();
        Dog a = new Dog();
        Cat c = new Cat();
        list.add(a);
        list.add(c);

        Object o = new Dog();
        if (o instanceof Dog) {
            Dog d = (Dog)o; // casting object
        }
    }
}