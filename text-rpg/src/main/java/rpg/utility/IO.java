package rpg.utility;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import rpg.game.rooms.Direction;

public class IO {
    
    private static final Scanner input = new Scanner(System.in);
    
    private IO() {
        //no instances for you
    }

    public static String playerInput() {
        String str = input.nextLine().trim();
        if (str.equalsIgnoreCase("esc")) {
            println("Are you sure you want to exit?");
            if (playerYesNo()) {
                throw new RuntimeException("Exited game");
            }
        }

        return str;
    }

    public static String playerInput(String str) {
        println(str);
        return playerInput();
    }

    public static boolean playerYesNo() {
        String next = "";
        while (!(next.equalsIgnoreCase("Y") || next.equalsIgnoreCase("N"))) {
            println("Y/N");
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
                println("Number must be between " + low + " and " + high);
            }
        }
    }

    @SafeVarargs
    public static <T> T choice(T... arr) {
        
        if (arr.length < 1) {
            throw new IllegalArgumentException("Must have at least one choice");
        }

        println("Choose one:");
        for (int i = 0; i < arr.length; i++) {
            println((i + 1) + ": " + arr[i].toString());
        }

        return arr[playerNum(1, arr.length) - 1];
        
    } 

    @SafeVarargs
    public static <T> T choice(Function<T, String> supplimentaryStringFunction, T... arr) {
        
        if (arr.length < 1) {
            throw new IllegalArgumentException("Must have at least one choice");
        }

        println("Choose one:");
        for (int i = 0; i < arr.length; i++) {
            println((i + 1) + ": " + arr[i].toString() + " " + supplimentaryStringFunction.apply(arr[i]));
        }

        return arr[playerNum(1, arr.length) - 1];
        
    } 

    

     public static void println(String s) {
        System.out.println(s);
    }

    public static <V> void printNumberedList(List<V> list) {
        for (int i = 0; i < list.size(); i++) {
            V obj = list.get(i);
            String name = obj != null ? obj.toString() : "None";
            println(i + 1 + ". " + name);
        }
    }


    public static void close() {
        input.close();
    }

    public static Object choice(Object object, Direction[] array) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'choice'");
    }
}
