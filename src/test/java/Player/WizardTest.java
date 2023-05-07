package Player;

import Potion.Potion;
import Spell.Spell;
import Spell.ForbiddenSpell;
import Spell.ApplySpell;
import Wand.Wand;


import org.junit.Test;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class WizardTest {
    private Wizard wizard;
    private Wizard enemy;

    @BeforeEach
    void setUp() {
        // 初始化测试用的wizard和enemy
        List<Spell> knownSpells = new ArrayList<>();
        knownSpells.add(Spell.reducto);
        List<ForbiddenSpell> knownForbiddenSpells = new ArrayList<>();
        knownForbiddenSpells.add(ForbiddenSpell.crucio);
        List<ApplySpell> knownApplySpell = new ArrayList<>();
        knownApplySpell.add(ApplySpell.accio);
        List<Potion> potions = new ArrayList<>();
        potions.add(Potion.invigorationDraught);
        this.wizard = new Wizard(100, "TestWizard", 0, 10, 5, 10, 1, null, Wand.Holly_DRAGON_HEARTSTRING, null, knownSpells, knownForbiddenSpells, knownApplySpell, potions, 100);
        this.enemy = new Wizard(100, "TestEnemy", 0, 5, 5, 10, 1, null, null, null, null, null, null, null,100);
    }

    @Test
    void attack() {
        wizard.attack(wizard, enemy, Spell.reducto);
        assertEquals(85, enemy.getHP());  // 根据测试用例，enemy应该收到15点伤害
    }

    @Test
    void forbiddenAttack() {
        wizard.forbiddenAttack(wizard, enemy, ForbiddenSpell.crucio);
        assertEquals(70, enemy.getHP());  // 根据测试用例，enemy应该收到30点伤害
    }

    @Test
    void usePotion() {
        wizard.usePotion(wizard, Potion.invigorationDraught);
        assertEquals(120, wizard.getHP());  // 根据测试用例，wizard应该回复20点HP
    }

    @Test
    void defend() {
        Wizard.defend(enemy);
        assertTrue(enemy.getHP() < 100);  // 根据测试用例，enemy应该受到伤害
    }
}
