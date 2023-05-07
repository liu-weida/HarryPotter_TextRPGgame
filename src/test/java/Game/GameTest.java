package Game;

import Enemy.Enemy;
import Enemy.Boss;
import House.House;
import Pet.Pet;
import Player.Wizard;
import Potion.Potion;
import Spell.Spell;
import Spell.ForbiddenSpell;
import Spell.ApplySpell;
import Wand.Wand;
import Wand.Core;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;

public class GameTest {
    @Mock
    Wizard wizard;
    @Mock
    List<Spell> spells;
    @Mock
    List<ForbiddenSpell> forbiddenSpells;
    @Mock
    List<ApplySpell> applySpells;
    @Mock
    List<Potion> potions;
    @InjectMocks
    Game game;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPlay() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(null, 0, null, 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House(null, 0, 0, 0, 0));
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.play();
    }

    @Test
    public void testInitializationProperty() throws Exception {
        int[] result = game.initializationProperty();
        Assert.assertArrayEquals(new int[]{0}, result);
    }

    @Test
    public void testCreatePlayers() throws Exception {
        game.createPlayers();
    }

    @Test
    public void testAssignHouse() throws Exception {
        game.assignHouse();
    }

    @Test
    public void testChooseWand() throws Exception {
        game.chooseWand();
    }

    @Test
    public void testChoosePet() throws Exception {
        game.choosePet();
    }

    @Test
    public void testPrintPets() throws Exception {
        game.printPets();
    }

    @Test
    public void testProperties() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(null, 0, null, 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House(null, 0, 0, 0, 0));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.Properties();
    }

    @Test
    public void testCurrentProperties() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(Core.PHOENIX_FEATHER, 0, "wood", 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House("name", 0, 0, 0, 0));
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.currentProperties();
    }

    @Test
    public void testArrivalHouse() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(Core.PHOENIX_FEATHER, 0, "wood", 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House("name", 0, 0, 0, 0));
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.arrivalHouse();
    }

    @Test
    public void testAdventure() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(Core.PHOENIX_FEATHER, 0, "wood", 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House("name", 0, 0, 0, 0));
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.adventure();
    }

    @Test
    public void testLearnSpell() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(Core.PHOENIX_FEATHER, 0, "wood", 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House("name", 0, 0, 0, 0));
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.learnSpell();
    }

    @Test
    public void testLearnForbiddenSpell() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(Core.PHOENIX_FEATHER, 0, "wood", 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House("name", 0, 0, 0, 0));
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.learnForbiddenSpell();
    }

    @Test
    public void testBuyPotion() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(Core.PHOENIX_FEATHER, 0, "wood", 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House("name", 0, 0, 0, 0));
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.buyPotion();
    }

    @Test
    public void testCombat() throws Exception {
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.combat(new Enemy(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testUseSpells() throws Exception {
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.useSpells(new Enemy(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testUsePotion() throws Exception {
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.usePotion(new Enemy(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testUseForbiddenSpell() throws Exception {
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.useForbiddenSpell(new Enemy(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testDefense() throws Exception {
        Game.defense(new Enemy(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testCombatBoss() throws Exception {
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.combatBoss(new Boss(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }
    

    @Test
    public void testUseSpellsBoss() throws Exception {
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.useSpellsBoss(new Boss(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testUsePotionBoss() throws Exception {
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.usePotionBoss(new Boss(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testUseForbiddenSpellBoss() throws Exception {
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.useForbiddenSpellBoss(new Boss(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testDefense2() throws Exception {
        Game.defense(new Boss(0, 0, "name", 0, 0, 0, 0, 0, List.of(new Spell("name", 0, 0f)), 0));
    }

    @Test
    public void testBattleVictory() throws Exception {
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        Game.battleVictory();
    }

    @Test
    public void testTrainingGround() throws Exception {
        when(wizard.getPet()).thenReturn(Pet.OWL);
        when(wizard.getWand()).thenReturn(new Wand(Core.PHOENIX_FEATHER, 0, "wood", 0, 0, 0, 0));
        when(wizard.getHouse()).thenReturn(new House("name", 0, 0, 0, 0));
        when(wizard.getKnownSpells()).thenReturn(List.of(new Spell("name", 0, 0f)));
        when(wizard.getKnownForbiddenSpells()).thenReturn(List.of(new ForbiddenSpell("name", 0, 0f)));
        when(wizard.getPotions()).thenReturn(List.of(new Potion("name", 0)));
        when(wizard.getHP()).thenReturn(0);
        when(wizard.getName()).thenReturn("getNameResponse");
        when(wizard.getLevel()).thenReturn(0);
        when(wizard.getGold()).thenReturn(0);
        when(wizard.getPharmacy()).thenReturn(0);
        when(wizard.getAttack()).thenReturn(0);
        when(wizard.getDefense()).thenReturn(0);
        when(wizard.getPrecise()).thenReturn(0);

        game.trainingGround();
    }

    @Test
    public void testWaitForInput() throws Exception {
        Game.waitForInput();
    }
}
