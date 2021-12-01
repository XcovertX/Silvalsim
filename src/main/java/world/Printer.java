package main.java.world;

/**
 * Printer.java
 * Package: main.java.world
 * Description: This is a static utility class to pretty print
 * 
 * @author James Covert
 * @version 1.0
 */
public final class Printer {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    private Printer() {
        
    }

    public static void print(String color, String s) {
        
        System.out.print(color + s + ANSI_RESET);  
    }
    
    public static void print(String s) {
        
        System.out.print(s);
    }
    
    public static void println(String color, String s) {
        
        System.out.println(color + s + ANSI_RESET);
    }
    
    public static void println(String s) {
        
        System.out.println(s);
    }
}
