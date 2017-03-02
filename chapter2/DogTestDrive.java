class Dog {

    int size;
    String breed;
    String name;
    boolean isDog = false;

    // by default it's public
    public void bark() {
        System.out.println("Ruff! Ruff!");
    }
}

class DogTestDrive{
    public static void main (String[] args) {
        Dog d = new Dog();
        d.size = 40;
        d.bark();
    }
}