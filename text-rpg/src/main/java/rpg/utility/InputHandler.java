package rpg.utility;

import java.util.Scanner;

public class InputHandler {
    
    private static final Scanner input = new Scanner(System.in);
    
    private InputHandler() {
        //no instances for you
    }

    public static String playerInput() {
        String str = input.nextLine().trim();
        if (str.equalsIgnoreCase("esc")) {
            OutputHandler.println("Are you sure you want to exit?");
            if (playerYesNo()) {
                throw new RuntimeException("Exited game");
            }
        }

        return str;
    }

    public static String playerInput(String str) {
        OutputHandler.println(str);
        return playerInput();
    }

    public static boolean playerYesNo() {
        String next = "";
        while (!(next.equalsIgnoreCase("Y") || next.equalsIgnoreCase("N"))) {
            OutputHandler.println("Y/N");
            next = playerInput();
        }

        return next.equalsIgnoreCase("Y");
    }

    public static boolean playerYesNo(String req) {
        System.out.println(req);
        return playerYesNo();
    }

    /**
     * Get a number from the player, range inclusive. This method will wait until valid input is given
     * @param low The low end of the range
     * @param high The high end of the range
     * @return an integer
     */
    public static int playerNum(int low, int high) {

        if (low > high) {
            throw new RuntimeException("Low end of range greater than high end");
        }
        while (true) {
            try {
                int inp = Integer.parseInt(playerInput("Enter a number " + low + "-" + high));
                if (inp >= low && inp <= high) {
                    return inp;
                }
            } catch (NumberFormatException e) {
                OutputHandler.println("Number must be between " + low + " and " + high);
            }
        }
    }

    @SafeVarargs
    public static <T> T choice(T... arr) {
        
        if (arr.length < 1) {
            throw new IllegalArgumentException("Must have at least one choice");
        }

        OutputHandler.println("Choose one:");
        for (int i = 0; i < arr.length; i++) {
            OutputHandler.println((i + 1) + ": " + arr[i].toString());
        }

        return arr[playerNum(1, arr.length) - 1];
        
    } 


    public static void close() {
        input.close();
    }
}
