import java.util.Scanner;


public class Main {
    //
    public static Scanner sc = new Scanner(System.in);

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

    //
    public static int roundCount = 1;

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
        System.out.println("Round " + roundCount + "\n");
        System.out.println("===================="); // 20 ='s
        humanMoveChoice();


    };

    // Human move choice
    public static String humanMoveChoice() {
        String choice;
        Character enteredChoice;

        System.out.println(humanName + "'s Move !");
        System.out.println("A. Throw a beer at Robot");
        System.out.println("B. Hit robot with guitar");
        System.out.println("C. Drink a beer");
        System.out.println("D. Play a sick rift the crowd loves!");

        // Take in user input
        System.out.println("Enter a letter: ");
        enteredChoice = sc.nextLine().charAt(0);

        // convert entered choice to string and lowercase
        choice = enteredChoice.toString();
        choice = choice.toLowerCase();

        System.out.println(choice);

        // Validate input
        while (choice != "a" && choice != "b" && choice != "c" && choice != "d") {
            System.out.println("Enter a valid choice !\n");

            System.out.println("Enter a letter: ");
            enteredChoice = sc.nextLine().charAt(0);
            choice = enteredChoice.toString();
            choice = choice.toLowerCase();

            System.out.println(choice);
        }

        return choice;
    };

    // Robot thinking
    public static void robotThinking(int delay) {
        try {
            Thread.sleep(delay);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }


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

        round();


    }










}
