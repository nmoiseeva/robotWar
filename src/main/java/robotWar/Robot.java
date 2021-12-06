package robotWar;

import java.util.ArrayList;
import java.util.Random;

public class Robot {
    private int health;
    private String name;
    private ArrayList<Character> damageButtonsList;
    private ArrayList<Character> usedButtonsList;

    public Robot(String name) {
        this.health = 100;
        this.name = name;
        System.out.println(this.damageButtonsList = damageList());
        this.usedButtonsList = usedButtonsList;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Character> getDamageButtonsList() {
        return damageButtonsList;
    }

    public void setDamageButtonsList(ArrayList<Character> damageButtonsList) {
        this.damageButtonsList = damageButtonsList;
    }

    public ArrayList<Character> getUsedButtonsList() {
        return usedButtonsList;
    }

    public void setUsedButtonsList(ArrayList<Character> usedButtonsList) {
        this.usedButtonsList = usedButtonsList;
    }

    private char getRandomKey() {
        String alphabet = "QWEASDZXC";
        int randIdx = new Random().nextInt(alphabet.length());
        char randChar = alphabet.charAt(randIdx);
        alphabet = alphabet.replace(String.valueOf(randChar), "");
        return randChar;
    }

    private ArrayList damageList() {
        ArrayList<Character> newListDamage = new ArrayList<>();
        do {
            char newKay = getRandomKey();
            if (!(newListDamage.contains(newKay))) {
                newListDamage.add(newKay);
            } else continue;
        } while (newListDamage.size() < 5);
        return newListDamage;
    }

}
