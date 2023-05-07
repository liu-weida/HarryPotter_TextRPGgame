package Game;

import Player.Wizard;
import House.House;
import House.SortingHat;
import Potion.Potion;
import Wand.Wand;
import Pet.Pet;
import Spell.Spell;
import Spell.ForbiddenSpell;
import Spell.ApplySpell;
import Enemy.Enemy;
import Enemy.Boss;

import java.util.*;

public class Game {
    public static int[] property;
    public static Wizard wizard;
    public static List<Spell> spells = new ArrayList<>();
    static List<ForbiddenSpell> forbiddenSpells = new ArrayList<>();
    static List<ApplySpell> applySpells = new ArrayList<>();
    static List<Potion> potions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    int adventurelevel = 1;


    public void play() {
        createPlayers();
        assignHouse();
        Properties();//显示属性
        while (true){
            arrivalHouse();//购买药剂或者学习魔法或者训练营
        }

    }



    public int[] initializationProperty() {
        int[] property = new int[7];
        Random random = new Random();
        int level = 100;
        int HP = 10000;
        int gold = 1000;
        int sum = 100;
        int pharmacy = random.nextInt(21) + 20;
        sum -= pharmacy;
        int attack = random.nextInt(21) + 10;
        sum -= attack;
        int defense = random.nextInt(21) + 20;
        sum -= defense;
        int precise = sum;
        property[0] = level;
        property[1] = HP;
        property[2] = pharmacy;
        property[3] = attack;
        property[4] = defense;
        property[5] = precise;
        property[6] = gold;
        return property;
    }



    public void createPlayers() {//创建角色，分配学院和法杖（杖芯和尺寸）
        System.out.println("Welcome to Hogwarts, dear new student. What's your name?");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + ".\n"
                + "Attributes are being assigned to you.");
        waitForInput();
        property = initializationProperty();
        System.out.println("Your current attributes are:");
        System.out.println("level: " + property[0] +"       Level enough to learn the corresponding spell"+
                "\nHP: " + property[1] +"        Can be used to buy potions"+
                "\npharmacy: " + property[2] +"     Affects how well you recover HP after using potions"+
                "\nattack: " + property[3] + "       Affects the damage you deal to enemies"+
                "\ndefense: " + property[4] + "      Affects the damage your enemies inflict on you"+
                "\nprecise: " + property[5]+"      Affects the hit rate of your spells");
        wizard = new Wizard(property[1], name, property[2], property[3], property[4], property[5], property[0], null, null, null, null, null, null, null, property[6]);

    }

    public void assignHouse() {
        System.out.println("Next, SortingHat will assign you to a house.");
        waitForInput();
        House house = SortingHat.getRandomHome();
        System.out.println("Your house is: " + house);
        if (house == House.Hufflepuff) {
            System.out.println("You get House gain: pharmacy +20.");
        } else if (house == House.Ravenclaw) {
            System.out.println("You get House gain: precise +10.");
        } else if (house == House.Slytherin) {
            System.out.println("You get House gain: attack +10.");
        } else if (house == House.Gryffindor) {
            System.out.println("You get House gain: defense +10.");
        }
        wizard.setHouse(house);
        waitForInput();
        chooseWand();
    }
        public void chooseWand() {
        System.out.println("Next, choose your wand.");
        Wand.getWand();
        int intWand = scanner.nextInt();
        boolean isValidWand = (intWand == 1) || (intWand == 2) || (intWand == 3)|| (intWand == 4);
        while (!isValidWand) {
            System.out.println("Wrong input, please reselect your wand.");
            Wand.getWand();
            intWand = scanner.nextInt();
            isValidWand = (intWand == 1) || (intWand == 2) || (intWand == 3)|| (intWand == 4);
        }
        Wand wand = Wand.chooseWand(intWand);
        System.out.println("Your wand is: " + wand );
        if (intWand == 1){
            System.out.println("You get Wand gain: attack +5, defense +5.");
        } else if (intWand == 2) {
            System.out.println("You get Wand gain: attack +5, precise +5.");
        } else if (intWand == 3) {
            System.out.println("You get Wand gain: pharmacy +10, defense +5.");
        } else if (intWand == 4) {
            System.out.println("You get Wand gain: defense +5， precise +10.");
        }
            wizard.setWand(wand);
        waitForInput();
        choosePet();
    }

    public void choosePet() {
        System.out.println("Next, choose your pet.");
        printPets();
        int intPet = scanner.nextInt();
        boolean isValidPet = (intPet == 1) || (intPet == 2) || (intPet == 3)|| (intPet == 4);
        while (!isValidPet){
            System.out.println("Wrong input, please reselect your pet.");
            printPets();
            intPet = scanner.nextInt();
            isValidPet = (intPet == 1) || (intPet == 2) || (intPet == 3)|| (intPet == 4);
        }
        Pet pet = Pet.choosePet(intPet);
        System.out.println("Your pet is: " + pet);
        if (intPet == 1){
            System.out.println("You get Pet gain: pharmacy +10.");
        } else if (intPet == 2) {
            System.out.println("You get Pet gain: precise +5.");
        } else if (intPet == 3) {
            System.out.println("You get Pet gain: attack +5.");
        } else if (intPet == 4) {
            System.out.println("You get Pet gain: defense +5.");
        }
        wizard.setPet(pet);
        waitForInput();
    }


    public void printPets() {
        int i = 1;
        for (Pet pet : Pet.values()) {
            System.out.println(i + "." + pet);
            i++;
        }
    }

    public void Properties() {
        property[2] = property[2] + Wand.getPharmacyBonus() + wizard.getHouse().getPharmacyBonus() + wizard.getPet().getPharmacyBonus();
        property[3] = property[3] + Wand.getAttackBonus() + wizard.getHouse().getAttackBonus() + wizard.getPet().getAttackBonus();
        property[4] = property[4] + Wand.getDefenseBonus() + wizard.getHouse().getDefenseBonus() + wizard.getPet().getDefenseBonus();
        property[5] = property[5] + Wand.getPreciseBonus() + wizard.getHouse().getPreciseBonus() + wizard.getPet().getPreciseBonus();
        System.out.println("Your current attributes are:");
        wizard.setPharmacy(property[2]);
        wizard.setAttack(property[3]);
        wizard.setDefense(property[4]);
        wizard.setPrecise(property[5]);
        System.out.println("House: "+ wizard.getHouse()+"\nWand: "+wizard.getWand()+"\nPet: "+wizard.getPet());
        System.out.println("level: " + wizard.getLevel() + "\nHP: " + wizard.getHP() + "\npharmacy: " +wizard.getPharmacy() +
                "\nattack: " + wizard.getAttack() + "\ndefense: " + wizard.getDefense() + "\nprecise: " + wizard.getPrecise() + "\ngold: " + wizard.getGold());
    }

        public void currentProperties() {
        System.out.println("House: "+ wizard.getHouse()+"\nWand: "+wizard.getWand()+"\nPet: "+wizard.getPet());
        System.out.println("level: " + wizard.getLevel() + "\nHP: " + property[1] + "\npharmacy: " +wizard.getPharmacy() +
                "\nattack: " + wizard.getAttack() + "\ndefense: " + wizard.getDefense() + "\nprecise: " + wizard.getPrecise() + "\ngold: " + wizard.getGold());
        System.out.println("Spells:");
        int i = 1;
        if (spells.isEmpty()) {
            System.out.println("You don't know the spell yet");
        } else {
            for (Spell spell : spells) {
                System.out.println(i+". "+spell);
                i++;
            }
        }
        System.out.println("Forbidden Spells:");
        int j = 1;
        if (forbiddenSpells.isEmpty()) {
            System.out.println("You don't know the forbidden spell yet");
        } else {
            for (ForbiddenSpell forbiddenSpell : forbiddenSpells) {
                System.out.println(j+". "+forbiddenSpell);
                j++;
            }
        }
        System.out.println("Potions:");
        int ij = 1;
        if (potions.isEmpty()) {
            System.out.println("You don't have the potion yet.");
        } else {
            for (Potion potion : potions) {
                System.out.println(ij + ". " + potion);
                ij++;
            }
        }
        System.out.println("Click to enter House.");
        waitForInput();
        }




    public void arrivalHouse() { //到达学院，可以购买药剂和学习魔法
        System.out.println("Welcome to House, how can I help you?");
        System.out.println("1. Enter the spell class.\n"+ "2. Enter the forbidden spell class.\n" + "3. Enter the potion house.\n"+"4. Access to Boot Camp.\n"+"5. Start the adventure.\n"+"6. View own properties");
        int choose = scanner.nextInt();
        boolean isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4)||(choose == 5)||(choose == 6);
        while (!isValidChoose){
            System.out.println("Wrong input, please reselect.");
            System.out.println("1. Enter the spell class.\n"+ "2. Enter the forbidden spell class.\n" + "3. Enter the potion house.\n"+"4. Access to Boot Camp.\n"+"5. Start the adventure.\n"+"6. View own properties");
            choose = scanner.nextInt();
            isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4)||(choose == 5)||(choose == 6);
        }
        switch (choose){
            case 1:
                learnSpell();
                break;
            case 2:
                learnForbiddenSpell();
                break;
            case 3:
                buyPotion();
                break;
            case 4:
                trainingGround();
                break;
            case 5:
                adventure();
                break;
            case 6:
                currentProperties();
                break;
            default:break;
        }
    }


        public void adventure() {//用来控制进入的关卡
            if (spells.isEmpty()) {
                System.out.println("You have not mastered the spell, so it is not safe to start the adventure, go and learn it!");
                waitForInput();
                arrivalHouse();
            } else {
                switch (adventurelevel) {
                    case 1:
                        Level.adventure1st();
                        break;
                    case 2:
                        Level.adventure2nd();
                        break;
                    case 3:
                        Level.adventure3rd();
                        break;
                    case 4:
                        Level.adventure4th();
                        break;
                    case 5:
                        Level.adventure5th();
                        break;
                    case 6:
                        Level.adventure6th();
                        break;
                    case 7:
                        Level.adventure7th();
                        break;
                }
                adventurelevel += 1;
            }
        }

    public void learnSpell() {
        System.out.println("Welcome to the magic class, what magic do you want to learn?");
        Spell.getSpell();
        int choose = scanner.nextInt();
        boolean isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4)||(choose == 5)||(choose == 6)||(choose == 7);
        while (!isValidChoose){
            System.out.println("Wrong input, please reselect.");
            Spell.getSpell();
            choose = scanner.nextInt();
            isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4)||(choose == 5)||(choose == 6)||(choose == 7);
        }
        if ((choose == 1 && wizard.getLevel()<2)||
                (choose == 2 && wizard.getLevel()<4)||
                (choose == 3 && wizard.getLevel()<6)||
                (choose == 4 && wizard.getLevel()<8)||
                (choose == 5 && wizard.getLevel()<10)||
                (choose == 6 && wizard.getLevel()<12)||
                (choose == 7 && wizard.getLevel()<14))
                {System.out.println("Your level is not enough oh, please go to the adventure and then come back.");
                waitForInput();
                arrivalHouse();
                }
        Spell spell = Spell.chooseSpell(choose);
        if (spells.contains(spell)){
            System.out.println("You have mastered this spell, please reselect.");
            arrivalHouse();
        }else {
            spells.add(spell);
            wizard.setKnownSpells(spells);
            System.out.println("After studying hard, congratulations you have learned: "+ spell);
        }

        //List<Spell> spells = wizard.getKnownSpells();


    }

    public void learnForbiddenSpell() {//禁忌魔法
        System.out.println("Welcome to the Forbidden Magic Class, what magic do you want to learn?");
        ForbiddenSpell.getForbiddenSpell();
        int choose = scanner.nextInt();
        boolean isValidChoose = (choose == 1)||(choose == 2)||(choose == 3);
        while (!isValidChoose){
            System.out.println("Wrong input, please reselect.");
            ForbiddenSpell.getForbiddenSpell();
            choose = scanner.nextInt();
            isValidChoose = (choose == 1)||(choose == 2)||(choose == 3);
        }
        if ((choose == 1 && wizard.getLevel()<10)||
                (choose == 2 && wizard.getLevel()<12)||
                (choose == 3 && wizard.getLevel()<14))
        {System.out.println("Your level is not enough oh, please go to the adventure and then come back.");
        waitForInput();
        arrivalHouse();
        }
        ForbiddenSpell forbiddenSpell = ForbiddenSpell.chooseForbiddenSpell(choose);
        if (forbiddenSpells.contains(forbiddenSpell)){
            System.out.println("You have mastered this spell, please reselect.");
            arrivalHouse();
        }else {
            forbiddenSpells.add(forbiddenSpell);
            wizard.setKnownForbiddenSpells(forbiddenSpells);
            System.out.println("After a long and hard study, congratulations you have learned: "+ forbiddenSpell);
            System.out.println("Please be sure to use caution!");
            waitForInput();
        }
        //List<ForbiddenSpell> forbiddenSpells = wizard.getKnownForbiddenSpells();
    }

    public void buyPotion() {
        System.out.println("Welcome to the Potion House, what potion do you want to buy?");
        Potion.getPotion();
        int choose = scanner.nextInt();
        boolean isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4);
        while (!isValidChoose){
            System.out.println("Wrong input, please reselect.");
            Potion.getPotion();
            choose = scanner.nextInt();
            isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4);
        }
        if ((choose == 1 && wizard.getGold()<10)||
                (choose == 2 && wizard.getGold()<20)||
                (choose == 3 && wizard.getGold()<40)||
                (choose == 4 && wizard.getGold()<80))
        {System.out.println("You don't have enough coins, so come back after you get enough coins.");
            waitForInput();
            arrivalHouse();
        }else if(choose == 1) {
            int gold =  wizard.getGold();
            gold = gold - 10;
            wizard.setGold(gold);
        }else if(choose == 2) {
            int gold =  wizard.getGold();
            gold = gold - 20;
            wizard.setGold(gold);
        }else if(choose == 3) {
            int gold =  wizard.getGold();
            gold = gold - 40;
            wizard.setGold(gold);
        }else if(choose == 4) {
            int gold =  wizard.getGold();
            gold = gold - 80;
            wizard.setGold(gold);}
        Potion potion = Potion.choosePotion(choose);
        System.out.println(potion);
        potions.add(potion);
        wizard.setPotions(potions);
        System.out.println("You have purchased: "+potion+" ×1");
        waitForInput();
    }

    public static void combat(Enemy enemy){
        enemy.resetHP();
        System.out.println("Enemy "+enemy.getName()+" has appeared!");

        while (enemy.getHP()>0 && wizard.getHP()>0) {

            System.out.println("Please choose your action: \n1. use spell. \n2. use potion. \n3. use forbidden spell.\n4. Conduct defense.");
            int choose = scanner.nextInt();
            boolean isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4);
            while (!isValidChoose){
                System.out.println("Wrong input, please reselect.");
                System.out.println("Please choose your action: \n1. use spell. \n2. use potion. \n3. use forbidden spell.\n4. Conduct defense.");
                choose = scanner.nextInt();
                isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4);
            }
            if (choose == 1){
                useSpells(enemy);
            } else if (choose == 2) {
                usePotion(enemy);
            } else if (choose == 3) {
                useForbiddenSpell(enemy);
            } else if (choose == 4) {
                defense(enemy);
            } else {
                System.out.println("Invalid option, please try again.");
            }

        }

    }
    public static void useSpells(Enemy enemy){
        System.out.println("Please select the spell you want to use:");
        List<Spell> spells = wizard.getKnownSpells();
        for (int i = 0; i < spells.size(); i++) {
            System.out.println((i + 1) + "." + spells.get(i));
        }
        int chooseSpell;
        boolean isValidChoose = false;
        while (!isValidChoose){
            chooseSpell = scanner.nextInt();
            if (chooseSpell < 1 || chooseSpell > spells.size()) {
                System.out.println("Invalid input, please select a number between 1 and " + spells.size() + ".");
            } else if (chooseSpell > 1 && wizard.getKnownSpells().size() < 2) {
                System.out.println("You only know one spell, please select the first one.");
            } else {
                isValidChoose = true;
                wizard.attack(wizard, enemy, spells.get(chooseSpell-1));
                if (enemy.getHP()<=0){
                    System.out.println(enemy.getName()+" is dead, you have won!!!");
                    int gold = wizard.getGold()+enemy.getGold();
                    wizard.setGold(gold);
                    System.out.println("You now have "+wizard.getGold()+" gold!");
                    battleVictory();
                } else {
                    enemy.attack(wizard, enemy, spells.get(0));
                    System.out.println("You have "+property[1]+" HP points left.");
                }
            }
        }
    }

    public static void usePotion(Enemy enemy) {
        if (potions.isEmpty()) {
            System.out.println("You do not have any potions, use spells to defeat the enemy.");
            waitForInput();
            useSpells(enemy);
        } else {
            System.out.println("Please select the potion you want to use:");
            List<Potion> potions = wizard.getPotions();
            for (int i = 0; i < potions.size(); i++) {
                System.out.println((i + 1) + "." + potions.get(i));
            }
            int choosePotion;
            boolean isValidChoose = false;
            while (!isValidChoose){
                choosePotion = scanner.nextInt();
                if (choosePotion < 1 || choosePotion > potions.size()) {
                    System.out.println("Invalid input, please select a number between 1 and " + potions.size() + ".");
                } else {
                    isValidChoose = true;
                    wizard.usePotion(wizard, potions.get(choosePotion - 1));
                    potions.remove(choosePotion - 1);
                }
            }
        }
    }

    public static void useForbiddenSpell(Enemy enemy) {
        if (forbiddenSpells.isEmpty()) {
            System.out.println("You haven't mastered the forbidden spell yet, so use the other spells first.");
            waitForInput();
            useSpells(enemy);
        } else {
            System.out.println("Please select the forbidden spell you want to use:");
            List<ForbiddenSpell> forbiddenSpells = wizard.getKnownForbiddenSpells();
            for (int i = 0; i < forbiddenSpells.size(); i++) {
                System.out.println((i + 1) + "." + forbiddenSpells.get(i));
            }
            int chooseSpell;
            boolean isValidChoose = false;
            while (!isValidChoose){
                chooseSpell = scanner.nextInt();
                if (chooseSpell < 1 || chooseSpell > forbiddenSpells.size()) {
                    System.out.println("Invalid input, please select a number between 1 and " + forbiddenSpells.size() + ".");
                } else {
                    isValidChoose = true;
                    wizard.forbiddenAttack(wizard, enemy, forbiddenSpells.get(chooseSpell - 1));
                    if (enemy.getHP() <= 0) {
                        System.out.println(enemy.getName() + " is dead, you have won!!!");
                        int level = wizard.getLevel() + 1;
                        wizard.setLevel(level);
                        int gold = wizard.getGold() + enemy.getGold();
                        wizard.setGold(gold);
                        System.out.println("You now have " + wizard.getGold() + " gold!");
                        battleVictory();
                    } else {
                        enemy.attack(wizard, enemy, spells.get(0));
                        System.out.println("You have " + property[1] + " HP points left.");
                    }
                }
            }
        }
    }


    public static void defense(Enemy enemy){
        Wizard.defend(enemy);
    }
    public static void combatBoss(Boss enemy){
        enemy.resetHP();
        System.out.println("You face "+enemy.getName()+" head on, but choose to fight it anyway.");

        while (enemy.getHP()>0) {
            System.out.println("Please choose your action: \n1. use spell. \n2. use potion. \n3. use forbidden spell.\n4. Conduct defense.");
            int choose = scanner.nextInt();
            boolean isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4);
            while (!isValidChoose){
                System.out.println("Wrong input, please reselect.");
                System.out.println("Please choose your action: \n1. use spell. \n2. use potion. \n3. use forbidden spell.\n4. Conduct defense.");
                choose = scanner.nextInt();
                isValidChoose = (choose == 1)||(choose == 2)||(choose == 3)||(choose == 4);
            }
            if (choose == 1){
                useSpellsBoss(enemy);
            } else if (choose == 2) {
                usePotionBoss(enemy);
            } else if (choose == 3) {
                useForbiddenSpellBoss(enemy);
            } else if (choose == 4) {
                defense(enemy);
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }

    }
    public static void useSpellsBoss(Boss enemy){
        System.out.println("Please select the spell you want to use:");
        List<Spell> spells = wizard.getKnownSpells();
        for (int i = 0; i < spells.size(); i++) {
            System.out.println((i + 1) + "." + spells.get(i));
        }
        int chooseSpell;
        boolean isValidChoose = false;
        while (!isValidChoose){
            chooseSpell = scanner.nextInt();
            if (chooseSpell < 1 || chooseSpell > spells.size()) {
                System.out.println("Invalid input, please select a number between 1 and " + spells.size() + ".");
            } else {
                isValidChoose = true;
                wizard.attack(wizard,enemy, spells.get(chooseSpell-1));
                if (enemy.getHP()<=0){
                    System.out.println(enemy.getName()+" is dead, you have won!!!");
                    int level = wizard.getLevel()+1;
                    wizard.setLevel(level);
                    int gold = wizard.getGold()+enemy.getGold();
                    wizard.setGold(gold);
                    System.out.println("You now have "+wizard.getGold()+" gold!");
                    battleVictory();
                } else {
                    enemy.attack(wizard, enemy, spells.get(0));
                    System.out.println("You have "+property[1]+" HP points left.");
                }
            }
        }
    }

    public static void usePotionBoss(Boss enemy){
        if (potions.isEmpty()){
            System.out.println("You do not have any potions, use spells to defeat the enemy.");
            waitForInput();
            useSpellsBoss(enemy);
        } else {
            System.out.println("Please select the potion you want to use:");
            List<Potion> potions = wizard.getPotions();
            for (int i = 0; i < potions.size(); i++) {
                System.out.println((i + 1) + "." + potions.get(i));
            }
            int choosePotion;
            boolean isValidChoose = false;
            while (!isValidChoose){
                choosePotion = scanner.nextInt();
                if (choosePotion < 1 || choosePotion > potions.size()) {
                    System.out.println("Invalid input, please select a number between 1 and " + potions.size() + ".");
                } else {
                    isValidChoose = true;
                    wizard.usePotion(wizard, potions.get(choosePotion - 1));
                    potions.remove(choosePotion - 1);
                }
            }
        }
    }

    public static void useForbiddenSpellBoss(Boss enemy){
        if (forbiddenSpells.isEmpty()){
            System.out.println("You haven't mastered the forbidden spell yet, so use the other spells first.");
            waitForInput();
            combatBoss(enemy);
        } else {
            System.out.println("Please select the forbidden spell you want to use:");
            List<ForbiddenSpell> forbiddenSpells = wizard.getKnownForbiddenSpells();
            for (int i = 0; i < forbiddenSpells.size(); i++) {
                System.out.println((i + 1) + "." + forbiddenSpells.get(i));
            }
            int chooseSpell;
            boolean isValidChoose = false;
            while (!isValidChoose){
                chooseSpell = scanner.nextInt();
                if (chooseSpell < 1 || chooseSpell > forbiddenSpells.size()) {
                    System.out.println("Invalid input, please select a number between 1 and " + forbiddenSpells.size() + ".");
                } else {
                    isValidChoose = true;
                    wizard.forbiddenAttack(wizard, enemy, forbiddenSpells.get(chooseSpell - 1));
                    if (enemy.getHP() <= 0) {
                        System.out.println(enemy.getName() + " is dead, you have won!!!");
                        int level = wizard.getLevel() + 1;
                        wizard.setLevel(level);
                        int gold = wizard.getGold() + enemy.getGold();
                        wizard.setGold(gold);
                        System.out.println("You now have " + wizard.getGold() + " gold!");
                        battleVictory();
                    } else {
                        enemy.attack(wizard, enemy, spells.get(0));
                        System.out.println("You have " + property[1] + " HP points left.");
                    }
                }
            }
        }
    }

    public static void defense(Boss enemy){
        Wizard.defend(enemy);
    }
    public static void battleVictory(){
        waitForInput();
        System.out.println("Your level +1 ");
        wizard.setLevel(wizard.getLevel()+1);
        System.out.println("Please select the attributes to be enhanced:");
        System.out.println("1. HP +100 \n2. Pharmacy +2 \n3. Attack +2 \n4. Defense +2 \n5. Precise +2");
        int chosebonu = scanner.nextInt();
        boolean isValidChosebonu = (chosebonu == 1)||(chosebonu == 2)||(chosebonu == 3)||(chosebonu == 4)||(chosebonu == 5);
        while (!isValidChosebonu){
            System.out.println("Wrong input, please reselect.");
            System.out.println("1. HP +100 \n2. Pharmacy +2 \n3. Attack +2 \n4. Defense +2 \n5. Precise +2");
            chosebonu = scanner.nextInt();
            isValidChosebonu = (chosebonu == 1)||(chosebonu == 2)||(chosebonu == 3)||(chosebonu == 4)||(chosebonu == 5);
        }
        switch (chosebonu){
            case 1:
                property[1] += 100;
                break;
            case 2:
                wizard.setPharmacy(wizard.getPharmacy()+2);
                break;
            case 3:
                wizard.setAttack(wizard.getAttack()+2);
                break;
            case 4:
                wizard.setDefense(wizard.getDefense()+2);
                break;
            case 5:
                wizard.setPrecise(wizard.getPrecise()+2);
                break;
            default:break;
        }
    }

    public void trainingGround() {
        int sizeSpell = spells.size();
        if (sizeSpell == 0) {
            System.out.println("You don't know the spell yet, go to House and learn spell and then come back.");
            arrivalHouse();
        }
        System.out.println("Welcome to the training ground, please start training.");
        combat(Enemy.gargoyle);
        //combatBoss(Boss.basilic);
        System.out.println("The battle is over and you return to the House.");
    }
        public static void waitForInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("▼");
            scanner.nextLine();
        }
    }

