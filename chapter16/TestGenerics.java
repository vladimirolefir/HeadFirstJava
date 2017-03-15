import java.util.*;

public class TestGenerics1 {
    public static void main(String[] args) {
        new TestGenerics1().go();
    }

    public void go1() {
        Animal[] animals = {new Dog(), new Cat(), new Dog()};
        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        takeAnimals(animals);
        takeAnimals(dogs);
    }

    public void takeAnimals1(Animal[] animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }

    public void go2() {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        takeAnimals2(animals);
    }

    public void takeAnimals2(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }

    /*
    When we compile it we get error.

    So that’s the problem. There’s certainly nothing wrong with adding a Cat to an ArrayList<Animal>,
    and that’s the whole point of having an ArrayList of a supertype like Animal—so that you can put all types of animals in a single Animal ArrayList.
    But if you passed a Dog ArrayList—one meant to hold ONLY Dogs—to this method that takes an Animal ArrayList, then suddenly you’d end up with a Cat in the Dog list.
    The compiler knows that if it lets you pass a Dog ArrayList into the method like that, someone could, at runtime, add a Cat to your Dog list.
    So instead, the compiler just won’t let you take the risk.

    If you declare a method to take ArrayList<Animal> it can take ONLY an ArrayList<Animal>, not ArrayList<Dog> or ArrayList<Cat>.

    Array types are checked again at runtime, but collection type checks happen only when you compile
    * */
    public void go3() {
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(new Dog());
        animals.add(new Cat());
        animals.add(new Dog());
        takeAnimals3(animals);
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        takeAnimals3(dogs);
    }

    public void takeAnimals3(ArrayList<Animal> animals) {
        for (Animal a : animals) {
            a.eat();
        }
    }

    /*
    Remember, the keyword "extends" here means either extends OR implements depending on the type.
    So if you want to take an ArrayList of types that implement the Pet interface, you’d declare it as: ArrayList<? extends Pet>

    you can do things with the list elements, but you can’t put new things in the list. So you’re safe at runtime, because the compiler won’t let you do anything that might be horrible at runtime.
    So, this is OK inside takeAnimals():
    for(Animal a: animals) {
        a.eat();
    }
    But THIS would not compile:
    animals.add(new Cat());
    
    This:
        public <T extends Animal> void takeThing(ArrayList<T> list)
    Does the same thing as this:
        public void takeThing(ArrayList<? extends Animal> list)
    * */
    public void takeAnimals3(ArrayList<? extends Animal> animals) {
        for(Animal a: animals) {
            a.eat();
        }
    }
}

abstract class Animal {
    void eat() {
        System.out.println("animal eating");
    }
}

class Dog extends Animal {
    void bark() {
    }
}

class Cat extends Animal {
    void meow() {
    }
}