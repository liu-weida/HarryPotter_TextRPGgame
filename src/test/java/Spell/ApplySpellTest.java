package Spell;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplySpellTest {

    @Test
    void testGetName() {
        ApplySpell applySpell = ApplySpell.chooseApplySpell(1);
        assertEquals("Wingardium leviosa", applySpell.getName());
    }

    @Test
    void testChooseApplySpell() {
        ApplySpell applySpell1 = ApplySpell.chooseApplySpell(1);
        ApplySpell applySpell2 = ApplySpell.chooseApplySpell(2);
        ApplySpell applySpell3 = ApplySpell.chooseApplySpell(3);

        assertEquals("Wingardium leviosa", applySpell1.getName());
        assertEquals(0, applySpell1.getDamage());
        assertEquals(1f, applySpell1.getPrecise());
        assertEquals("Wingardium leviosa", applySpell1.toString());

        assertEquals("Expectro Patronum", applySpell2.getName());
        assertEquals(0, applySpell2.getDamage());
        assertEquals(1f, applySpell2.getPrecise());
        assertEquals("Expectro Patronum", applySpell2.toString());

        assertEquals("Accio", applySpell2.getName());
        assertEquals(0, applySpell2.getDamage());
        assertEquals(1f, applySpell2.getPrecise());
        assertEquals("Accio", applySpell2.toString());
    }

    @Test
    void testToString() {
        ApplySpell applySpell = ApplySpell.chooseApplySpell(1);
        assertEquals("Wingardium leviosa", applySpell.toString());
    }
}
