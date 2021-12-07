package robotWar;


import java.util.ArrayList;
import java.util.Scanner;

public class RobotConsole {

    public static void enterRobotsName() {
        System.out.println("Enter robot`s name: ");
    }

    public static void missedMessage() {
        System.out.println("Hmm, you will be lucky next time");
    }

    public static void winnerMessage(Robot robot) {
        System.out.println("Robot " + robot.getName() + " is dead. Good job, you are the winner!");
    }

    public static String getStringFromConsole() {
        Scanner scanner = new Scanner(System.in);
        try {
            String str = scanner.nextLine().toUpperCase();
            if (str.isEmpty()) {
                System.out.println("Enter data!");
                str = getStringFromConsole();
            }
            return str;
        } catch (Exception e) {
            return "Wrong data";
        }
    }

    public static void printRobotsActions(Robot robot) {
        System.out.println("For exit enter 'L'");
        System.out.println("Shot to robot " + robot.getName());
        System.out.println("Select one letter from the list (QWEASDZXC)");
    }


    public static char getDamageKeyFromConsole() {
        String alphabet = "QWEASDZXCL";
        boolean isLetterWrong;
        char enteredChar;
        do {
            enteredChar = getStringFromConsole().toUpperCase().charAt(0);
            if (alphabet.contains(String.valueOf(enteredChar))) {
                isLetterWrong = false;
            } else {
                isLetterWrong = true;
                System.out.println("Wrong Letter, enter one from the list (QWEASDZXCL)");
            }
        } while (isLetterWrong);
        return enteredChar;
    }

    public static void checkDamage(Robot robot, Character newChar) {
        ArrayList<Character> removeDamage = new ArrayList<>();
        removeDamage.add(newChar);
        robot.getDamageButtonsList().removeAll(removeDamage);
        robot.setHealth(robot.getHealth() - 20);
        robot.setUsedButtonsList(removeDamage);
        System.out.println("Nice shot!");
        System.out.println("Robot '" + robot.getName() + "' health is " + robot.getHealth());
    }

    public static void checkUsedDamageList(Robot robot, Character newChar) {
        if (robot.getUsedButtonsList().contains(newChar)) {
            System.out.println("You can`t use letter '" + newChar + "' twice");
        }
    }
}
