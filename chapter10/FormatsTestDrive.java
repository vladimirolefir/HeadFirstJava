// The percent (%) says, “insert argument here” (and format it using these instructions)
public class FormatsTestDrive {
    public static void main (String[] args) {

        // The formatting instructions for how to format the second argument (which in this case is an int value).
        String s = String.format("%, d", 1000000000); // 1,000,000,000

        // The “%” sign tells the formatter to insert the other method argument (the second argument to format(), the number) here,
        // AND format it using the “.2f” characters after the percent sign.
        s = String.format("I have %.2f bugs to fix.", 476578.09876); // I have 476578.10 bugs to fix.

        // adding comma
        // By changing the format instructions from “%.2f” to %,.2f”, we got a comma in the formatted number.
        s = String.format("I have %,.2f bugs to fix.", 476578.09876); // I have 476,578.10 bugs to fix.

        /*
            Everything after the percent sign up to and including the type indicator (like “d” or “f”) are part of the formatting instructions.
            After the type indicator, the formatter assumes the next set of characters are meant to be part of the output String,
            until or unless it hits another percent (%) sign.

            A format specifier can have up to five different parts (not including the “%”).
            Everything in brackets [ ] below is optional, so only the percent (%) and the type are required.

            %[argument number][flags][width][.precision]type

            [argument number] - it lets you say WHICH argument if there’s more than one.

            [flags]           - These are for special formatting options like inserting commas, or putting negative numbers in parentheses, or to make the numbers left justified.

            [width]           - This defines the MINIMUM number of characters that will be used. That’s *minimum* not TOTAL.
                                If the number is longer than the width, it’ll still be used in full, but if it’s less than the width, it’ll be padded with zeroes.

            [.precision]      - It defines the precision. In other words, it sets the number of decimal places. Don’t forget to include the “.” in there.

            type              - Type is mandatory (see the next page) and will usually be “d” for a decimal integer or “f” for a floating point number.

        */

        s = String.format("%,6.1f", 42.000);
        // There’s no “argument number” specified in this format String, but all the other pieces are there.

        // The TYPE is mandatory, everything else is optional.

        s = String.format("%d", 42);          // decimal. Output: 42
        s = String.format("%.3f", 42.000000); // floating point. Output: 42.000
        s = String.format("%x", 42);          // hexadecimal. Output: a2
        s = String.format("%c", 42);          // character. Output: *

        s = String.format("The rank is %,d out of %,.2f", one, two); // The rank is 20,456,654 out of 100,567,890.25

        s = String.format("%tc", new Date()); // The complete date and time. Sun Nov 28 14:52:41 MST 2004
        s = String.format("%tc", new Date()); // Just the time. 03:01:47 PM

        Date today = new Date();
        s = String.format("%tA, %tB %td",today, today, today); // Day of the week, month and day. Sunday, November 28
        s = String.format("%tA, %<tB %<td", today); // The angle-bracket “<” is just another flag in the specifier that tells the formatter to “use the previous argument again.”

        /*
            For a time-stamp of “now”, use Date. But for everything else, use Calendar.
        */
        Calendar cal = Calendar.getInstance();
        c.set(2004,0,7,15,40);
        long day1 = c.getTimeInMillis();
        day1 += 1000 * 60 * 60;
        c.setTimeInMillis(day1);
        System.out.println("new hour " + c.get(c.HOUR_OF_DAY)); // new hour 16
        c.add(c.DATE, 35);
        System.out.println("add 35 days " + c.getTime()); // add 35 days Wed Feb 11 16:40:41 MST 2004
        c.roll(c.DATE, 35);
        System.out.println("roll 35 days " + c.getTime()); // roll 35 days Tue Feb 17 16:40:41 MST 2004
        c.set(c.DATE, 1);
        System.out.println("set to 1 " + c.getTime()); // set to 1 Sun Feb 01 16:40:41 MST 2004

        System.out.println(s);
    }
}