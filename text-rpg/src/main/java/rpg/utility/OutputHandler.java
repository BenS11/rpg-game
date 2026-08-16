package rpg.utility;

import java.util.List;

public class OutputHandler {
    
    private OutputHandler() {}


    // this exists so that I can change how information is displayed
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
}
