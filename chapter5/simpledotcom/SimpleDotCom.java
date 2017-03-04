import java.io.*;

class SimpleDotComm {
    private int[] locationCells;
    private int numOfHits;

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for (int cell : locationCells) {
            if (guess == cell) {
                result = "hit";
                numOfHits++;
                break;
            } // end if
        } // end for
        if (numOfHits == locationCells.length) {
            result = "kill";
        } // end if
        System.out.println(result);
        return result;
    }

    public void setLocationCells(int[] locs) {
        locationCells = locs;
    }
}

public class SimpleDotComTestDrive {
    public static void main(String[] args) {

        SimpleDotCom dot = new SimpleDotCom();
        int[] locations = {2, 3, 4};
        dot.setLocationCells(locations);

        String userGuess = "2";
        String result = dot.checkYourself(userGuess);
        String testResult = "failed";
        if (result.equals("hit")) {
            testResult = "passed";
        }
        System.out.println(testResult);
    }
}

public class GameHelper {
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + “ “);
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println(“IOException: “+e);
        }
        return inputLine;
    }
}

    public class SimpleDotGame {

        public static void main(String[] args) {
            int numOfGuesses = 0;
            GameHelper helper = new GameHelper();
            SimpleDotCom theDotCom = new SimpleDotCom();
            int randomNum = (int) (Math.random() * 5);
            int[] locations = {randomNum, randomNum + 1, randomNum + 2};
            theDotCom.setLocationCells(locations);
            boolean isAlive = true;
            while (isAlive == true) {
                String guess = helper.getUserInput(“enter a number”);
                String result = theDotCom.checkYourself(guess);
                numOfGuesses++;
                if (result.equals("kill")) {
                    isAlive = false;
                    System.out.println("You took " + numOfGuesses + " guesses");
                } // close if
            } // close while
        }
    }