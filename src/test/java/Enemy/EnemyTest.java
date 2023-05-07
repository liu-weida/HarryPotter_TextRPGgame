package Enemy;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import Spell.Spell;
import Game.Game;
import Player.Wizard;

public class EnemyTest {

    @Test
    public void testAttack() {
        Wizard wizard = new Wizard(100, "Harry", 100, 10, 10, 10, 10, null,null, null,new ArrayList<Spell>(Arrays.asList(Spell.reducto)),null,null,null,100);
        Enemy enemy = new Enemy(100, 100, "Gargoyle", 2, 12, 4, 8, 1, new ArrayList<Spell>(Arrays.asList(Spell.reducto)), 15);
        Spell spell = Spell.reducto;
    }

    @Test
    public void testResetHP() {
        Enemy enemy = new Enemy(100, 100, "Gargoyle", 2, 12, 4, 8, 1, new ArrayList<Spell>(Arrays.asList(Spell.reducto)), 15);
        enemy.setHP(0);
        enemy.resetHP();
        assertEquals(100, enemy.getHP());
    }

    @Test
    public void testStaticVariables() {
        assertEquals(100, Enemy.gargoyle.getInitialHP());
        assertEquals("Gargoyle", Enemy.gargoyle.getName());
        assertEquals(60, Enemy.juvenileTrolls.getInitialHP());
        assertEquals("Juvenile Trolls", Enemy.juvenileTrolls.getName());
        assertEquals(80, Enemy.snake.getInitialHP());
        assertEquals("Snake", Enemy.snake.getName());
        assertEquals(120, Enemy.deathEaters.getInitialHP());
        assertEquals("Death Eaters", Enemy.deathEaters.getName());
    }

}
