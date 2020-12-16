// Joshua Colleran
// 08/04/2020
// CSE142
// TA: Asila Maksumova
// Assignment #6
//
// This program will interpret a code in the yazlanguage and translate it on a new document
// It will interpret any file the user selects and let you view the translated version

import java.io.*;  // This does file processing
import java.util.*; // Scanner

public class otherinterpretor {
    // This method controls the whole progam
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner (System.in);

        // Welcomes user to the program
        welcome();

        // Will run the function that asks what option they would like and it excutes the option
        while (doOption(console)) {
        }
    }

    // This method will print out the welcoming statements and explain to the user what the program does
    public static void welcome() {
        System.out.println ("Welcome to YazInterpreter!\nYou may interpret a YazLang program and output");
        System.out.println ("the results to a file or view a previously\ninterpreted YazLang program.\n");
    }

    // This method will ask the user which option of the three they would like to do
    // Depending on what they want to do it will run a specific function to meet their needs
    public static boolean doOption(Scanner console) throws FileNotFoundException {
        System.out.print ("(I)nterpret .yzy program, (V)iew .yzy output, (Q)uit? ");
        String pickOption = console.next();
        // Sets their option to upper case
        pickOption = pickOption.toUpperCase();
        // Runs different functions depending on the users choice
        if (pickOption.equals("I")) {
            interpretFile(console);
            System.out.println ("");
            return true;
        } else if (pickOption.equals("V")) {
            viewFile(console);
            System.out.println ("");
            return true;
        } else if (pickOption.equals("Q")) {
            return false;
        } else {
            return true;
        }
    }

    // This method will interpret the files and translate them from yazzy language
    public static void interpretFile(Scanner console) throws FileNotFoundException {
        // File was returned from the function getFile
        // getFile was called and it asked the user for a file to translate
        File f = getFile(console);
        Scanner input = new Scanner(f);
        System.out.print ("Output file name: ");
        String outputFile = console.next();
        PrintStream output = new PrintStream(new File(outputFile));

        // Will take the take the file and print its translated version into new file
        while (input.hasNextLine()) {
            String translationType = input.nextLine();
            convertion(translationType, output);
        }
        System.out.println ("YazLang interpreted and output to a file!");
    }

    // This method will let the user view any file they want (most likely the interpretted one)
    public static void viewFile(Scanner console) throws FileNotFoundException {
        // Will call getFile and will ask the user what file to veiw
        File f = getFile(console);
        Scanner output = new Scanner(f);
        System.out.println ("");

        // Will print the contents of the new file onto the screen
        while (output.hasNextLine()) {
            String finalOutput = output.nextLine();
            System.out.println (finalOutput);
        }
    }

    // This method will ask the user for a file until a file that is found is inputted
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

    // This method will translate the type of convertion the file starts with
    public static void convertion(String translationType, PrintStream output) {
        // Runs if statement to see what convertion type to run
        if (translationType.startsWith("CONVERT")) {
            translateConvert(translationType, output);
        } else if (translationType.startsWith("RANGE")) {
            translateRange(translationType, output);
        } else if (translationType.startsWith("REPEAT")) {
            translateRepeat(translationType, output);
        }
    }

    // This method will translate all the conversions from celcius to farenheit and vice versa
    public static void translateConvert (String converter, PrintStream output) {
        Scanner tokens = new Scanner(converter);
        String type = tokens.next();
        int degrees = tokens.nextInt();
        String tempType = tokens.next();
        tempType = tempType.toUpperCase();
        // This if statement will determine which way it will convert
        if (tempType.startsWith("F")) {
            double newDegrees = (degrees - 32) / 1.8;
            int finalDegrees = (int) newDegrees;
            output.println (finalDegrees + "C");
        } else if (tempType.startsWith("C")) {
            double newDegrees = 1.8 * degrees + 32;
            int finalDegrees = (int) newDegrees;
            output.println (finalDegrees + "F");
        }
    }

    // This method will translate all the range conversions
    public static void translateRange (String ranger, PrintStream output) {
        Scanner tokens = new Scanner(ranger);
        String type = tokens.next();
        int firstNum = tokens.nextInt();
        int lastNum = tokens.nextInt();
        int increments = tokens.nextInt();

        // This loop will print out the translated and correct amount of numbers and in the correct ored
        for (int i = firstNum; i < lastNum ; i = i + increments) {
            output.print(i + (" "));
        }
        output.println ("");
    }

    // This method will translate all the repeat convertions
    public static void translateRepeat (String repeater, PrintStream output) {
        Scanner tokens = new Scanner(repeater);
        String type = tokens.next();

        // This will translate each pair until there are none
        while (tokens.hasNextLine()) {
            String phrase = tokens.next();
            // This will replace the slashes and underscores with the appropriate characters
            phrase = phrase.replace("_", " ");
            phrase = phrase.substring(1, phrase.length() - 1);
            int numTimes = tokens.nextInt();
            // This will run the phrase the appropriate amount of times
            for (int i = 0; i < numTimes; i++) {
                output.print(phrase);
            }
        }
        output.println ("");
    }
}