package Spell;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellTest {

    @Test
    void testGetName() {
        Spell spell = Spell.chooseSpell(1);
        assertEquals("Reducto", spell.getName());
    }

    @Test
    void testChooseSpell() {
        Spell spell1 = Spell.chooseSpell(1);
        Spell spell2 = Spell.chooseSpell(2);
        Spell spell3 = Spell.chooseSpell(3);
        Spell spell4 = Spell.chooseSpell(4);
        Spell spell5 = Spell.chooseSpell(5);
        Spell spell6 = Spell.chooseSpell(6);
        Spell spell7 = Spell.chooseSpell(7);

        assertEquals("Reducto", spell1.getName());
        assertEquals(10, spell1.getDamage());
        assertEquals(0.8f, spell1.getPrecise());
        assertEquals("Reducto", spell1.toString());

        assertEquals("Confringo", spell2.getName());
        assertEquals(15, spell2.getDamage());
        assertEquals(0.85f, spell2.getPrecise());
        assertEquals("Confringo", spell2.toString());

        assertEquals("Locomotor mortis", spell3.getName());
        assertEquals(25, spell3.getDamage());
        assertEquals(0.75f, spell3.getPrecise());
        assertEquals("Locomotor mortis", spell3.toString());

        assertEquals("Diffindo", spell4.getName());
        assertEquals(35, spell4.getDamage());
        assertEquals(0.7f, spell4.getPrecise());
        assertEquals("Diffindo", spell4.toString());

        assertEquals("Incendio", spell5.getName());
        assertEquals(50, spell5.getDamage());
        assertEquals(0.65f, spell5.getPrecise());
        assertEquals("Incendio", spell5.toString());

        assertEquals("Deprimo", spell6.getName());
        assertEquals(70, spell6.getDamage());
        assertEquals(0.6f, spell6.getPrecise());
        assertEquals("Deprimo", spell6.toString());

        assertEquals("Expulso", spell7.getName());
        assertEquals(90, spell7.getDamage());
        assertEquals(0.55f, spell7.getPrecise());
        assertEquals("Expulso", spell7.toString());

    }

    @Test
    void testGetSpell() {
        Spell.getSpell();

    }

    @Test
    void testToString() {
        Spell spell = Spell.chooseSpell(1);
        assertEquals("Reducto", spell.toString());
    }
}
