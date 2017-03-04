class AddThing {

    /* Instance variables always get a default value. If you don’t explicitly assign a value to an instance variable,
    or you don’t call a setter method, the instance variable still has a value! */

    int a;
    int b = 12;

    public int add() {

        /* Local variables do NOT get a default value! The compiler complains if you try to use a local variable before the variable is initialized. */

        int total = a + b;
        return total;
    }
}