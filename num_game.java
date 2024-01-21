import java.util.Random; // Import the Random class to generate random numbers
import java.util.Scanner; // Import the Scanner class to read user input

public class num_game { 
    public static int random_num(int low, int high) { // Define a public static method named random_num that takes two integers as input and returns a random integer between them
        Random random = new Random(); 
        return low + random.nextInt(high - low + 1); // Generate a random integer between low and high (inclusive) and return it
    }

    public static void main(String[] args) { 
        int low = 0, high = 100; 
        Scanner sc = new Scanner(System.in); 
        String ans = "y"; 
        int count = 0, max_count = 10; 
        int rnd_num = random_num(low, high); 

        while (ans.equalsIgnoreCase("y") && count <= max_count) { // Start a while loop that continues as long as the user wants to play the game and has not exceeded the maximum number of attempts
            System.out.println("Enter your input: "); 
            if (sc.hasNextInt()) { 
                int user_int = sc.nextInt(); 
                count++; 
                if (user_int == rnd_num) { // Check if the user's guess is correct
                    System.out.println("Hurray! You guessed it correctly! Won " + user_int); 
                    System.out.println("You guessed in: " + count + " attempts"); 
                    count = 0; 
                    rnd_num = random_num(low, high); // Generate a new random number
                    System.out.print("Enter 'y' to continue or 'n' to quit: "); // Print a message asking the user to continue or quit
                    ans = sc.next(); 
                    if (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n")) { 
                        System.out.println("Invalid input. Please enter 'y' or 'n'."); 
                        ans = sc.next(); // Read the user input again
                    }
                } else if (user_int > rnd_num) { // Check if the user's guess is too high
                    System.out.println("Your number is larger. Try entering a smaller one."); 
                } else if (user_int < rnd_num) { // Check if the user's guess is too low
                    System.out.println("You entered a smaller number."); 
                }
            } else { // If the user input is not a valid integer
                System.out.println("Invalid input. Please enter a number."); 
                sc.next(); 
            }
        }
        sc.close(); // Close the Scanner object
    }
}