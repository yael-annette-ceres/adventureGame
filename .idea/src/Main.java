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
        humanChoiceLogic(humanMoveChoice());
        System.out.println("\nRobot's move!\n");
        robotChoiceLogic(robotMoveChoice());
        displayStats();
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


<<<<<<< HEAD
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




    // Human move choice
=======

    // HUMAN ============================================
    // Human Move Choice
>>>>>>> 716f4d793559fd5b43db56fc65a55a13b81a71d5
    public static String humanMoveChoice() {
        choice = "";
        Character enteredChoice;

        System.out.println(humanName + "'s Move !");
        System.out.println("A. Throw a beer at Robot");
        System.out.println("B. Hit robot with guitar");
        System.out.println("C. Drink a beer");
        System.out.println("D. Play a sick rift the crowd loves!");

        // Take in user input
        System.out.println("Enter a letter: ");
        choice = sc.nextLine();

        // convert entered choice to string and lowercase
        choice = choice.toLowerCase();

        System.out.println(choice);
        return validateInput();
<<<<<<< HEAD

    };


    //human choice logic

    public static void humanChoiceLogic(String input){

        switch (input){
            case "a" :
                System.out.println(humanName +  " threw a beer at Robot");
                RobotHP = RobotHP - (wAttack() - (RobotDef / 10));
                break;
            case "b" :
                System.out.println(humanName +  " hit robot with guitar");
                RobotHP = RobotHP - (sAttack() - (RobotDef / 10));
                break;
            case "c" :
                System.out.println(humanName +  " drank a beer");
                HumanHP = HumanHP + potion;
                HumanPotions--;
                System.out.println("You increased your health to " + HumanHP + ". You have " + HumanPotions + " remaining.");
                break;
            case "d" :
                System.out.println(humanName +  " played a sick riff the crowd loves!");
                RobotDef = RobotDef - defDecrementor;
                System.out.println("You reduced the robot's defenses to " + RobotDef);
                break;
            default :
                System.out.println("default case");


=======

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
                System.out.println(humanName + " played a sick riff the crowd loves!");
                RobotDef = RobotDef - defDecrementor;
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
        System.out.println("A. Throw a ipod");
        System.out.println("B. Taze the human");
        System.out.println("C. Do the robot shuffle");
        System.out.println("D. Detune human's guitar!");

        // Take in user input
        System.out.println("Robot is thinking!");
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
>>>>>>> 716f4d793559fd5b43db56fc65a55a13b81a71d5
        }


    }



    //System.out.println("A. Throw a beer at Robot");
    //        System.out.println("B. Hit robot with guitar");
    //        System.out.println("C. Drink a beer");
    //        System.out.println("D. Play a sick rift the crowd loves!");




    // Human Choice Logic
    public static void robotChoiceLogic(String input){

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
                System.out.println("Robot increased it's health to " + RobotHP + ". Robot now has " + RobotPotions + " remaining.");
                break;
            case "d" :
                System.out.println("Robot detuned the guitar!");
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
        System.out.println("Fight Stats ! ==================\n");
        System.out.println("Human: ");
        System.out.println("HP: " + HumanHP);
        System.out.println("DEF: " + HumanDef);
        System.out.println("Beers: " + HumanPotions +"\n");
        System.out.println("Robot");
        System.out.println("HP: " + RobotHP);
        System.out.println("DEF: " + RobotDef);
        System.out.println("Full batteries to shuffle: " + RobotPotions);
        System.out.println("================================");
    }


    // Robot thinking
    public static void robotThinking(int delay) {
        try {
            Thread.sleep(delay);
        } catch(InterruptedException e) {
            e.printStackTrace();
        };
    };






    public static void main(String[] args) {
        // Testing
//        System.out.println(RobotHP);
//
//        int attackTemp = wAttack();
//
//        RobotHP = RobotHP - (attackTemp - (RobotDef / 10));
//
//        System.out.println("attack was " + attackTemp);
//        System.out.println(RobotHP);
//
//
//        // lower defense and do same attack again
//        RobotDef = RobotDef - 18;
//        System.out.println("Robot defense is " + RobotDef);
//
//        RobotHP = 100;
//        RobotHP = RobotHP - (attackTemp - (RobotDef / 10));
//        System.out.println("Robot HP after same attack with lowered defense: " + RobotHP);


//        RobotHP = RobotHP + potion;
//
//        System.out.println(RobotHP);

//        round();

        humanChoiceLogic(humanMoveChoice());

    }










}