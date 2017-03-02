class ReferenceObj {

    String name;

    public void test() {
        System.out.println("test!");
    }
}

class ReferenceTestDrive{
    public static void main (String[] args) {
        ReferenceObj d = new ReferenceObj();

        // 1. declare reference variable. Tells the JVM to allocate space for a reference variable, and names that
        // variable myDog. The reference variable is, forever, of type ReferenceObj. In other words, a remote control that has buttons to control a ReferenceObj,
        // but not a Cat or a Button or a Socket.

        // 2. create an object. Tells the JVM to allocate space for a new ReferenceObj object on the heap

        // 3. link object with the reference. it's like remote conrol. Assigns the new Dog to the reference variable myDog.
        // In other words, programs the remote control.

        // Arrays are Object!
        // Arrays are always objects, whether they’re declared to hold primitives or object references.
        int[] nums; // 1. Declare an int array variable. An array variable is a remote control to an array object.

        nums = new int[7]; // Create a new int array with a length of 7, and assign it to the previouslydeclared int[] variable nums

        // 3. Give each element in the array an int value. Remember, elements in an int array are just int variables.
        nums[0] = 6;
        nums[1] = 5;
        // ...
        nums[6] = 3;

        int len = nums.length; // arrays hve length property
    }
}