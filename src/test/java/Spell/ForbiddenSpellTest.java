package Spell;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ForbiddenSpellTest {

    @Test
    void testGetName() {
        ForbiddenSpell forbiddenSpell = ForbiddenSpell.chooseForbiddenSpell(1);
        assertEquals("Imperio", forbiddenSpell.getName());
    }

    @Test
    void testChooseForbiddenSpell() {
        ForbiddenSpell forbiddenSpell1 = ForbiddenSpell.chooseForbiddenSpell(1);
        ForbiddenSpell forbiddenSpell2 = ForbiddenSpell.chooseForbiddenSpell(2);
        ForbiddenSpell forbiddenSpell3 = ForbiddenSpell.chooseForbiddenSpell(3);

        assertEquals("Imperio", forbiddenSpell1.getName());
        assertEquals(120, forbiddenSpell1.getDamage());
        assertEquals(0.5f, forbiddenSpell1.getPrecise());
        assertEquals("Imperio", forbiddenSpell1.toString());

        assertEquals("Crucio", forbiddenSpell2.getName());
        assertEquals(150, forbiddenSpell2.getDamage());
        assertEquals(0.45f, forbiddenSpell2.getPrecise());
        assertEquals("Crucio", forbiddenSpell2.toString());

        assertEquals("Avada Kedavra", forbiddenSpell2.getName());
        assertEquals(200, forbiddenSpell2.getDamage());
        assertEquals(0.4f, forbiddenSpell2.getPrecise());
        assertEquals("Avada Kedavra", forbiddenSpell2.toString());
    }

    @Test
    void testGetForbiddenSpell() {
        ForbiddenSpell.getForbiddenSpell();
        // 根据控制台输出手动验证
    }

    @Test
    void testToString() {
        ForbiddenSpell forbiddenSpell = ForbiddenSpell.chooseForbiddenSpell(1);
        assertEquals("Imperio", forbiddenSpell.toString());
    }
}
