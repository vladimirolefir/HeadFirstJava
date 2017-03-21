import java.util.*;

enum Color{
    RED, GREEN, WHITE, BLUE;
}

enum Holiday {
    NEWYEAR(31),
    CHRISTMAS(25);

    private int day;

    Holiday(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}

/* @Deprecated / @Override annotations */
class Human{
    public void eat(){
        System.out.println("Human:eat");
    }

    @Deprecated
    public void sleep(){
        System.out.println("Human:sleep");
    }
}

class Programmer extends Human{
    public void eat(){
        System.out.println("Programmer:eat");
    }

    @Override
    public void sleep(){
        System.out.println("Programmer:sleep");
    }

    // will not compile
    /*
    @Override
    public void walk(){
        System.out.println("Programmer:walk");
    }
    */
}

public class JavaFeatures15{

    public static void main(String[] args) {

        JavaFeatures15 jclass = new JavaFeatures15();
        jclass.iterators();
        jclass.enumstest(Color.GREEN);
        String[] names = {"Jach","Jimm"};
        jclass.variableArgumentList(names);

        System.out.println("***");
        System.out.println("End");
    }

    public void iterators(){
        System.out.println("*********");
        System.out.println("iterators");
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        Iterator<String> i = strings.iterator();

        while(i.hasNext()){
            System.out.println((String) i.next());
        }

        for (String str : strings) {
            System.out.println("Name is " + str);
        }
    }

    public void enumstest(Color color){
        System.out.println("*********");
        System.out.println("enumstest");
        System.out.println(Color.GREEN);
        System.out.println(Holiday.NEWYEAR.getDay());

        switch (color) {
            case RED:
                System.out.println("red color is " + color);
                break;

            case GREEN:
                System.out.println("green color is " + color);
                break;

            default:
                System.out.println("no color");
                break;
        }

        for (Holiday h : Holiday.values()) {
            System.out.println(h);
        }
    }

    public void variableArgumentList(String... names){
        System.out.println("*********");
        System.out.println("variableArgumentList");
        for (String str : names) {
            System.out.println("Name is " + str);
        }
    }
}