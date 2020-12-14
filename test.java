import java.io.*;  // This does file processing
import java.util.*; // Scanner

public class interpreter {
    // This method controls the whole progam
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);

        // Welcomes user to the program
        welcome();

        // Will run the function that asks what option they would like and it excutes the option
        while (doOption(console)) {
        }
    }

    // This method will print out the welcoming statements and explain to the user what the program does
    public static void welcome() {
        System.out.println("This program will show you all of the ancestors and descendants of a person.");
    }

    // This method will ask the user which option of the three they would like to do
    // Depending on what they want to do it will run a specific function to meet their needs
    public static boolean doOption(Scanner console) throws FileNotFoundException {
        System.out.print("What is the input file?");
        String pickOption = console.next();
        // Runs different functions depending on the users choice
        if (!pickOption.equals(null)) {
            FamilyInfo(console);
            System.out.println("");
            return true;
        }
    }
    public static File getFile(Scanner console) throws FileNotFoundException {
        // Sets ask to true
        boolean ask = true;
        String tryAgain = "Input file name: ";
        File f = new File("tempFile");

        // Runs ask until it a existing file is printed by the user
        while (ask) {
            System.out.print (tryAgain);
            String inputFile = console.next();
            f = new File(inputFile);
            if (f.exists()) {
                ask = false;
                Scanner input = new Scanner(f);
            } else {
                tryAgain = "File not found. Try again: ";
                ask = true;
            }
        }
        // Returns the file f to other functions
        return f;
    }
}