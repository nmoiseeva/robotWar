package robotWar;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        RobotConsole robotConsole = new RobotConsole();
        char newChar = ' ';

        List<Robot> robotList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            RobotConsole.enterRobotsName();
            robotList.add(new Robot(RobotConsole.getStringFromConsole()));
        }

        do {
            for (Robot robot : robotList) {
                RobotConsole.printRobotsActions(robot);
                newChar = RobotConsole.getDamageKeyFromConsole();
                if (newChar == 'L') {
                    return;
                }
                if (robot.getDamageButtonsList().contains(newChar)) {
                    RobotConsole.checkDamage(robot, newChar);
                    if (robot.getHealth() == 0) {
                        RobotConsole.winnerMessage(robot);
                        return;
                    }
                } if (robot.getHealth() < 100) {
                    RobotConsole.checkUsedDamageList(robot, newChar);
                } else {
                    robotConsole.missedMessage();
                }
            }
        }
        while (newChar != 'L');
    }

}
