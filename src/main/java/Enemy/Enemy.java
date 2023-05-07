package Enemy;

import Character.Character;
import Game.Game;
import Player.Wizard;
import Spell.Spell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Enemy extends AbstractEnemy {


    public Enemy(int HP, int initialHP, String name, int pharmacy, int attack, int defense, int precise, int level, List<Spell> knownSpells,int gold) {
        super(HP, initialHP, name, pharmacy, attack, defense, precise, level, knownSpells,gold);
    }
    public static final Enemy gargoyle = new Enemy(100, 100,"Gargoyle", 2, 12, 4, 8, 1,new ArrayList<Spell>(Arrays.asList(Spell.reducto)),15);
    public static final Enemy juvenileTrolls = new Enemy(60, 60,"Juvenile Trolls", 2, 12, 6, 8, 1,new ArrayList<Spell>(Arrays.asList(Spell.reducto)),15);
    public static final Enemy snake = new Enemy(80, 80,"Snake", 2, 18, 10, 12, 1,new ArrayList<Spell>(Arrays.asList(Spell.confringo)),20);
    public static final Enemy deathEaters = new Enemy(120, 120,"Death Eaters", 2, 25, 25, 25, 1,new ArrayList<Spell>(Arrays.asList(Spell.locomotorMortis)),25);


    public void attack(Wizard wizard, Character enemy, Spell spell) {
        Random random = new Random();
        double number = random.nextDouble();
        if (number < spell.getPrecise()+enemy.getPrecise()*0.05) {
            int injury = (int)((spell.getDamage() + enemy.getAttack())*((100-(wizard.getDefense()))*0.01));
            int wizardHP = Game.property[1] - injury;
            System.out.println("Enemy has dealt "+ injury +" points of damage to you!");
            Game.property[1] = wizardHP;
            if (Game.property[1]<=0){
                    System.out.println("You have been defeated!");
                    System.exit(0); // 结束程序
            }
        }else {
            System.out.println("The enemy's attack missed!");
        }
    }
    public void resetHP() {
        setHP(initialHP);
    }

}