package Spell;

public class ApplySpell extends AbstractSpell{
    public ApplySpell(String name, int damage, float precise) {
        super(name, damage, precise);
    }
    private static final ApplySpell wingardiumLeviosa = new ApplySpell("Wingardium leviosa", 0, 1f);//漂浮咒
    private static final ApplySpell expectroPatronum = new ApplySpell("Expectro Patronum", 0, 1f);//守护神咒
    public static final ApplySpell accio = new ApplySpell("Accio", 0, 1f);//摄物咒

    public static ApplySpell chooseApplySpell(int applySpell) {
        switch (applySpell) {
            case 1:
                return wingardiumLeviosa;
            case 2:
                return expectroPatronum;
            case 3:
                return accio;

            default:
                return null;
        }

    }
}
