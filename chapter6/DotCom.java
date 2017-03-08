import java.util.*;

/*
Comparing ArrayList to a regular array:

1. A plain old array has to know its size at the time it’s created. To put an object in a regular array, you must assign it to a specific location.
2. Arrays use array syntax that’s not used anywhere else in Java.
3. ArrayLists in Java 5.0 are parameterized.
*/
public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " : ( ");
            } else {
                result = "hit”;
            } // close if
        } // close if
        return result;
    } // close method
} // close class