import java.awt.*;
import java.util.Scanner;


public class Main {
    // General variables
    public static Scanner sc = new Scanner(System.in);
    public static String choice;

    // potion and defense decrementor
    public static int potion = 18;
    public static int defDecrementor = 15;

    // Fighters in the game
    // Robot
    public static int RobotHP = 100;
    public static int RobotDef = 100;
    public static int RobotPotions = 3;


    // Human
    public static int HumanHP = 100;
    public static int HumanDef = 100;
    public static int HumanPotions = 3;

    // Current round count
    public static int roundCount = 1;

    // Current human's name
    public static String humanName;





    // Attacks
    public static int wAttack() {
        int max = 20;
        int min = 10;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    };

    public static int sAttack() {
        int max = 30;
        int min = 20;
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    };





    // Game logic
    public static void round() {
        System.out.println("===================="); // 20 ='s
        System.out.println("Round " + roundCount + "");
        System.out.println("====================\n"); // 20 ='s
        robotThinking(3000);
        humanChoiceLogic(humanMoveChoice());
        robotChoiceLogic(robotMoveChoice());
        robotThinking(2000);
        displayStats();
        roundCount++;
    };





    // Validate input
    public static String validateInput() {

        switch (choice) {
            case "a":
                return choice;
            case "b":
                return choice;
            case "c":
                return choice;
            case "d":
                return choice;
            default:
                System.out.println("Input is invalid. Please enter a letter:  ");
                choice = sc.nextLine();
                validateInput();
        }
        return choice;
    }



    // HUMAN ============================================
    // Human Move Choice
    public static String humanMoveChoice() {
        choice = "";
        Character enteredChoice;

        System.out.println("\n" + humanName + "'s Move !");
        robotThinking(1000);
        System.out.println("A. Throw a beer at Robot");
        System.out.println("B. Hit robot with guitar");
        System.out.println("C. Drink a beer");
        System.out.println("D. Play a sick rift the crowd loves!");

        // Take in user input
        System.out.println("\nEnter a letter: ");
        choice = sc.nextLine();

        // convert entered choice to string and lowercase
        choice = choice.toLowerCase();

        if (choice == "c" && HumanPotions <= 0) {
            robotThinking(500);
            System.out.println("You are out of beers, make another selection !");
            robotThinking(500);
            humanChoiceLogic(humanMoveChoice());
        }

        System.out.println("");
        robotThinking(1000);
        return validateInput();
    };

    // Human Choice Logic
    public static void humanChoiceLogic(String input) {

        switch (input) {
            case "a":
                System.out.println(humanName + " threw a beer at Robot");
                RobotHP = RobotHP - (wAttack() - (RobotDef / 10));
                break;
            case "b":
                System.out.println(humanName + " hit robot with guitar");
                RobotHP = RobotHP - (sAttack() - (RobotDef / 10));
                break;
            case "c":
                System.out.println(humanName + " drank a beer");
                HumanHP = HumanHP + potion;
                HumanPotions--;
                System.out.println("You increased your health to " + HumanHP + ". You have " + HumanPotions + " remaining.");
                break;
            case "d":
                System.out.println(humanName + " played a sick riff the crowd loves it!");
                RobotDef = RobotDef - defDecrementor;
                robotThinking(1000);
                System.out.println("You reduced the robot's defenses to " + RobotDef);
                break;
            default:
                System.out.println(":)");
        }
        System.out.println("");
    }




    // ROBOT ============================================
    // Robot Move Choice
    public static String robotMoveChoice() {
        choice = "";
        int robotChoice;
        Character enteredChoice;

        System.out.println("Robot's Move !");
        robotThinking(3000);
        System.out.println("A. Throw a ipod");
        System.out.println("B. Taze the human");
        System.out.println("C. Do the robot shuffle");
        System.out.println("D. Detune human's guitar!\n");
        robotThinking(1000);

        // Print picture of robot
        asciiRobot();
        robotThinking(1000);
        // Take in user input
        System.out.println("Robot is thinking!\n");
        robotThinking(5000);

        // Calculate robot choice
        int max = 3;
        int min = 0;
        int range = max - min;
        robotChoice = (int) (Math.random() * range) + min;

        switch (robotChoice) {
            case 0:
                choice = "a";
                break;
            case 1:
                choice = "b";
                break;
            case 2:
                choice = "c";
                break;
            default:
                choice = "d";
                break;
        }

        return choice;
    };

    // Human Choice Logic
    public static void robotChoiceLogic(String input){

        // Some AI logic
        if (RobotHP <= 50 && RobotPotions > 0) {
            input = "c";
        };

        if (input == "c" && RobotPotions <= 0) {
            input = "b";
        }

        switch (input){
            case "a" :
                System.out.println("Robot threw a ipod at human!");
                HumanHP = HumanHP - (wAttack() - (HumanDef / 10));
                break;
            case "b" :
                System.out.println("Robot zapped human!");
                HumanHP = HumanHP - (sAttack() - (HumanDef / 10));
                break;
            case "c" :
                System.out.println("Robot did a robot shuffle!");
                RobotHP = RobotHP + potion;
                RobotPotions--;
                System.out.println("Robot increased it's health to " + RobotHP + ". Robot now has " + RobotPotions + " shuffles remaining.");
                break;
            case "d" :
                System.out.println("Robot detuned the guitar!");
                robotThinking(1000);
                System.out.println("The crowd is hating your solo!");
                HumanDef = HumanDef - defDecrementor;
                System.out.println("You reduced the human's defenses to " + HumanDef);
                break;
            default :
                System.out.println("default case");
        }
    }

    // Display status
    public static void displayStats() {
        System.out.println("\n================================");
        System.out.println("Fight Stats!\n");
        System.out.println("Human: ");
        System.out.println("HP: " + HumanHP);
        System.out.println("DEF: " + HumanDef);
        System.out.println("Beers: " + HumanPotions +"\n");
        System.out.println("Robot");
        System.out.println("HP: " + RobotHP);
        System.out.println("DEF: " + RobotDef);
        System.out.println("Full batteries to shuffle: " + RobotPotions);
        System.out.println("================================\n");
        robotThinking(1000);
    }


    // Robot thinking
    public static void robotThinking(int delay) {
        try {
            Thread.sleep(delay);
        } catch(InterruptedException e) {
            e.printStackTrace();
        };
    };

    // ASCII ART
    // Robot ASCII art
    public static void asciiRobot() {
        System.out.println("       _______");
        System.out.println("     _/       \\_");
        System.out.println("    / |       | \\");
        System.out.println("   /  |__   __|  \\");
        System.out.println("  |__/((o| |o))\\__|");
        System.out.println("  |      | |      |");
        System.out.println("  |\\     |_|     /|");
        System.out.println("  | \\           / |");
        System.out.println("   \\| /  ___  \\ |/");
        System.out.println("    \\ | / _ \\ | /");
        System.out.println("     \\_________/");
        System.out.println("      _|_____|_");
        System.out.println(" ____|_________|____");
        System.out.println("/                   \\ ");
    }

    public static void asciiSmallGuy() {
        System.out.println("(ง'̀-'́)ง");
    }

    public static void asciiPrepareToFight() {
        System.out.println("__________                                            __           ___________.__       .__     __  ");
        System.out.println("\\______   \\______  ____ ___________ _______  ____   _/  |_  ____   \\_   _____/|__| ____ |  |___/  |_");
        System.out.println(" |     ___|_  __ \\/ __ \\\\____ \\__  \\\\_  __ \\/ __ \\  \\   __\\/  _ \\   |    __)  |  |/ ___\\|  |  \\   __");
        System.out.println(" |    |    |  | \\|  ___/|  |_> > __ \\|  | \\|  ___/   |  | (  <_> )  |     \\   |  / /_/  >   Y  \\  |  ");
        System.out.println(" |____|    |__|   \\___  >   __(____  /__|   \\___  >  |__|  \\____/   \\___  /   |__\\___  /|___|  /__|  ");
        System.out.println("                      \\/|__|       \\/           \\/                      \\/      /_____/      \\/      ");
    }

    public static void asciiHuzzah() {
        robotThinking(1000);
        System.out.println("Walking down Navarro Street, on the way to Codeup....");
        robotThinking(3000);
        System.out.println("\\( ﾟヮﾟ)/");
        robotThinking(500);
        System.out.println("-( ﾟヮﾟ)-");
        robotThinking(500);
        System.out.println("\\( ﾟヮﾟ)/");
        robotThinking(500);
        System.out.println("-( ﾟヮﾟ)-");
        robotThinking(500);
        System.out.println("\\( ﾟヮﾟ)/");
        robotThinking(500);
        System.out.println("-( ﾟヮﾟ)-");
        robotThinking(500);
        System.out.println("\\( ﾟヮﾟ)/");
        robotThinking(500);
        System.out.println("-( ﾟヮﾟ)-");
        robotThinking(500);
        System.out.println("\\( ﾟヮﾟ)/");
        robotThinking(500);
        System.out.println("-( ﾟヮﾟ)-");
        robotThinking(500);
        System.out.println("\\( ﾟヮﾟ)/");
        robotThinking(500);
        System.out.println("-( ﾟヮﾟ)-");
        robotThinking(500);
    }

    public static void asciiHumanWords() {
        System.out.println(".__                                 ");
        System.out.println("|  |__  __ __  _____ _____    ____ ");
        System.out.println("|  |  \\|  |  \\/     \\\\__  \\  /    \\ ");
        System.out.println("|   Y  \\  |  /  Y Y  \\/ __ \\|   |  \\");
        System.out.println("|___|  /____/|__|_|  (____  /___|  /");
        System.out.println("     \\/            \\/     \\/     \\/");
    }

    public static void asciiVerse() {
        System.out.println("____   _____________");
        System.out.println("\\   \\ /   /   _____/");
        System.out.println(" \\   Y   /\\_____  \\ ");
        System.out.println("  \\     / /        \\");
        System.out.println("   \\___/ /_______  /");
        System.out.println("                 \\/ ");
    }

    public static void asciiRobotWords() {
        System.out.println("__________      ___.           __  ");
        System.out.println("\\______   \\ ____\\_ |__   _____/  |_ ");
        System.out.println(" |       _//  _ \\| __ \\ /  _ \\   __\\");
        System.out.println(" |    |   (  <_> ) \\_\\ (  <_> )  |  ");
        System.out.println(" |____|_  /\\____/|___  /\\____/|__|  ");
        System.out.println("        \\/           \\/            ");
    }

    public static void asciiExclamation() {
        System.out.println("._.");
        System.out.println("| |");
        System.out.println("| |");
        System.out.println(" \\|");
        System.out.println(" __");
        System.out.println(" \\/");
    }


    public static void main(String[] args) {

        asciiHuzzah();
        robotThinking(2000);
        System.out.println("!");
        robotThinking(4000);
        System.out.println("... A wild robot appears.");
        robotThinking(1000);
        asciiRobot();
        robotThinking(1000);
        asciiHumanWords();
        robotThinking(1000);
        asciiVerse();
        robotThinking(1000);
        asciiRobotWords();
        robotThinking(2000);
        System.out.println("Who will defend humans from robots today? (Enter your name)");
        humanName = sc.nextLine();
        robotThinking(1000);
        System.out.println("Thank you, " + humanName + " you are so brave!");
        robotThinking(1000);
        asciiSmallGuy();
        robotThinking(1000);
        asciiPrepareToFight();
        robotThinking(2000);

        while (HumanHP >= 0 && RobotHP >= 0) {
            round();
        }

        if (HumanHP <= 0) {
            System.out.println("\nHumans have been defeated");
            robotThinking(1000);
            asciiRobot();
        }

        if (RobotHP <= 0) {
            System.out.println("\nRobots have been defeated!");
            robotThinking(1000);
            asciiHuzzah();
        }
    }
}