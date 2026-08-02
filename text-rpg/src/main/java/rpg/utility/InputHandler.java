package rpg.utility;

import java.security.InvalidAlgorithmParameterException;
import java.util.Scanner;

import rpg.game.rooms.Direction;

public class InputHandler {
    
    private static final Scanner input = new Scanner(System.in);
    
    private InputHandler() {
        //no instances for you
    }

    public static String playerInput() {
        String str = input.nextLine().trim();
        if (str.equalsIgnoreCase("esc")) {
            System.out.println("Are you sure you want to exit?");
            if (playerYesNo()) {
                throw new RuntimeException("Exited game");
            }
        }

        return str;
    }

    public static String playerInput(String str) {
        System.out.println(str);
        return playerInput();
    }

    public static boolean playerYesNo() {
        String next = "";
        while (!(next.equalsIgnoreCase("Y") || next.equalsIgnoreCase("N"))) {
            System.out.println("Y/N");
            next = playerInput();
        }

        return next.equalsIgnoreCase("Y");
    }

    /**
     * Get a number from the player, range inclusive. This method will wait until valid input is given
     * @param low The low end of the range
     * @param high The high end of the range
     * @return an integer
     */
    public static int playerNum(int low, int high) {
        while (true) {
            try {
                int inp = Integer.parseInt(playerInput("Enter a number " + low + "-" + high));
                if (inp >= low && inp <= high) {
                    return inp;
                }
            } catch (NumberFormatException e) {
                System.out.println("Number must be between " + low + " and " + high);
            }
        }
    }

    @SafeVarargs
    public static <T> T choice(T... arr) {
        
        if (arr.length < 1) {
            throw new IllegalArgumentException("Must have at least one choice");
        }

        System.out.println("Choose one:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + ": " + arr[i].toString());
        }

        return arr[playerNum(1, arr.length) - 1];
        
    } 


    public static void close() {
        input.close();
    }
}
