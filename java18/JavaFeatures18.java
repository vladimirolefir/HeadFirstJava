public class JavaFeatures18 {

    public static void main(String[] args) {

        JavaFeatures18 jclass = new JavaFeatures18();
        jclass.lambdaexpressions();
        jclass.stringjoin();
        jclass.foreachincollections();
        jclass.functionalinterfacesandlambdas();
        jclass.streamapi();
        jclass.workwithpaths();

        System.out.println("***");
        System.out.println("End");
    }

    // You don’t have to type the whole list of types for the instantiation. Instead you use the symbol, which is called diamond operator.
    // syntax: (argtype arg...) -> { return some expression.. probably using these arguments }
    public void lambdaexpressions() {
        System.out.println("*********");
        System.out.println("lambdaexpressions");

        // OLD Style
        Runnable oldRunner = new Runnable(){
            public void run(){
                System.out.println("I am running");
            }
        };

        // Java 1.8
        Runnable java8Runner = () ->{
            System.out.println("I am running");
        };

        Comparator c = (a, b) -> Integer.compare(a.length(), b.length());
    }

    public void stringjoin() {
        System.out.println("*********");
        System.out.println("stringjoin");

        String abc = String.join(" ", "Java", "8"); // Will get evaluated as "Java 8"
    }

    // Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business logic only.
    // forEach method takes java.util.function.Consumer object as argument, so it helps in having our business logic at a separate location that we can reuse.
    // Let’s see forEach usage with simple example.
    public void foreachincollections() {
        System.out.println("*********");
        System.out.println("foreachincollections");

        //creating sample Collection
        List<Integer> myList = new ArrayList<Integer>();
        for(int i=0; i<10; i++) myList.add(i);

        //traversing using Iterator
        Iterator<Integer> it = myList.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            System.out.println("Iterator Value::"+i);
        }

        //traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("forEach anonymous class Value::"+t);
            }
        });

        //traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);
    }

    // One of the major benefits of functional interface is the possibility to use lambda expressions to instantiate them.
    // We can instantiate an interface with anonymous class but the code looks bulky.
    public void functionalinterfacesandlambdas() {
        System.out.println("*********");
        System.out.println("functionalinterfacesandlambdas");

        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("My Runnable");
            }};

        // here is how we'll rewrite it in Java 1.8.
        // Since functional interfaces have only one method, lambda expressions can easily provide the method implementation.
        Runnable r1 = () -> {
            System.out.println("My Runnable");
        };

        // If you have single statement in method implementation, we don’t need curly braces also.
        // For example above Interface1 anonymous class can be instantiated using lambda as follows:

        Interface1 i1 = (s) -> System.out.println(s);
        i1.method1("abc");
    }

    // A new java.util.stream has been added in Java 8 to perform filter/map/reduce like operations with the collection.
    // Stream API will allow sequential as well as parallel execution.
    // Collection interface has been extended with stream() and parallelStream() default methods to get the Stream for sequential and parallel execution.
    public void streamapi() {
        System.out.println("*********");
        System.out.println("streamapi");

        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();

        //using lambda with Stream API, filter example
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        //using lambda in forEach
        highNums.forEach(p -> System.out.println("High Nums parallel="+p));

        Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
        highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));

        /*
        High Nums parallel=91
        High Nums parallel=96
        High Nums parallel=93
        High Nums parallel=98
        High Nums parallel=94
        High Nums parallel=95
        High Nums parallel=97
        High Nums parallel=92
        High Nums parallel=99
        High Nums sequential=91
        High Nums sequential=92
        High Nums sequential=93
        High Nums sequential=94
        High Nums sequential=95
        High Nums sequential=96
        High Nums sequential=97
        High Nums sequential=98
        High Nums sequential=99
        */
    }
}

/*
functional interfaces. Notice that both the interfaces have a common method log() with implementation logic.
We know that Java doesn’t provide multiple inheritance in Classes because it leads to Diamond Problem.
So how it will be handled with interfaces now, since interfaces are now similar to abstract classes.
The solution is that compiler will throw exception in this scenario and we will have to provide implementation logic in the class implementing the interfaces.
*/

// you will notice @FunctionalInterface annotation. Functional interfaces are new concept introduced in Java 8.
// An interface with exactly one abstract method becomes Functional Interface.
// We don’t need to use @FunctionalInterface annotation to mark an interface as Functional Interface.
// @FunctionalInterface annotation is a facility to avoid accidental addition of abstract methods in the functional interfaces.
// You can think of it like @Override annotation and it’s best practice to use it
@FunctionalInterface
public interface Interface1 {

    void method1(String str);

    default void log(String str){
        System.out.println("I1 logging::"+str);
    }

    static void print(String str){
        System.out.println("Printing "+str);
    }

    //trying to override Object method gives compile time error as
    //"A default method cannot override a method from java.lang.Object"

    //	default String toString(){
    //		return "i1";
    //	}
}

@FunctionalInterface
public interface Interface2 {

    void method2();

    default void log(String str){
        System.out.println("I2 logging::"+str);
    }
}

public class MyClass implements Interface1, Interface2 {

    @Override
    public void method2() {
    }

    @Override
    public void method1(String str) {
    }

    // MyClass won't compile without having it's own log() implementation
    // As you can see that Interface1 has static method implementation that is used in MyClass.log() method implementation.
    @Override
    public void log(String str){
        System.out.println("MyClass logging::"+str);
        Interface1.print("abc");
    }
}