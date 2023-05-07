package Enemy;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import Spell.Spell;
import Game.Game;
import Player.Wizard;


public class BossTest {

    @Test
    public void testAttack() {
        Wizard wizard = new Wizard(100,"Harry", 100, 100, 10, 10, 10, null, null, null,new ArrayList<Spell>(Arrays.asList(Spell.reducto)), null, null, null, 100);
        Boss boss = new Boss(250, 250, "Troll", 5, 40, 20, 20, 1, new ArrayList<Spell>(Arrays.asList(Spell.reducto)), 50);
        Spell spell = Spell.reducto;

    }

    @Test
    public void testResetHP() {
        Boss boss = new Boss(250, 250, "Troll", 5, 40, 20, 20, 1, new ArrayList<Spell>(Arrays.asList(Spell.reducto)), 50);
        boss.setHP(0);
        boss.resetHP();
        assertEquals(250, boss.getHP());
    }

    @Test
    public void testStaticVariables() {
        assertEquals(250, Boss.troll.getInitialHP());
        assertEquals("Troll", Boss.troll.getName());
        assertEquals(300, Boss.basilic.getInitialHP());
        assertEquals("Basilic", Boss.basilic.getName());
        assertEquals(400, Boss.dementor.getInitialHP());
        assertEquals("Dementor", Boss.dementor.getName());
        assertEquals(500, Boss.peterPettigrew.getInitialHP());
        assertEquals("Peter Pettigrew", Boss.peterPettigrew.getName());
        assertEquals(600, Boss.doloresOmbrage.getInitialHP());
        assertEquals("Dolores Ombrage", Boss.doloresOmbrage.getName());
        assertEquals(750, Boss.doloresOmbrageLeader.getInitialHP());
        assertEquals("Dolores Ombrage Leader", Boss.doloresOmbrageLeader.getName());
        assertEquals(900, Boss.bellatrixLestrange.getInitialHP());
        assertEquals("Bellatrix Lestrange", Boss.bellatrixLestrange.getName());
        assertEquals(1000, Boss.voldemort.getInitialHP());
        assertEquals("Voldemort", Boss.voldemort.getName());
    }
}
