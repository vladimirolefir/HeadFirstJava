class Clock {

    String time;

    void setTime(String t) {
        time = t;
    }

    void getTime() {
        return time;
    }
}

class ClockTestDrive {

    public static void main(String [] args) {
        Clock c = new Clock();
        Clock c2 = new Clock();

        // To see if two references are the same (which means they refer to the same object on the heap) use the == operator
        if(c == c2){
            c.setTime("1245");
        }

        String tod = c.getTime();
        System.out.println("time: " + tod);
    }
}