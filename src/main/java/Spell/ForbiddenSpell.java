package Spell;

import Wand.Wand;

public class ForbiddenSpell extends AbstractSpell {
    public ForbiddenSpell(String name, int damage, float precise) {
        super(name, damage, precise);
    }
    private static final ForbiddenSpell avadaKedavra = new ForbiddenSpell("Avada Kedavra", 200, 0.4f);//阿瓦达啃大瓜
    private static final ForbiddenSpell imperio = new ForbiddenSpell("Imperio", 120, 0.5f);//魂魄出窍
    public static final ForbiddenSpell crucio = new ForbiddenSpell("Crucio", 150, 0.45f);//钻心剜骨

    public static void getForbiddenSpell(){
        System.out.println("1."+imperio+"             Need lv.9");
        System.out.println("2."+crucio+"              Need lv.11");
        System.out.println("3."+avadaKedavra+"       Need lv.13");
    }
    public static ForbiddenSpell chooseForbiddenSpell(int forbiddenSpell) {
        switch (forbiddenSpell) {
            case 1:
                return imperio;
            case 2:
                return crucio;
            case 3:
                return avadaKedavra;
            default:
                return null;
        }

    }


    public String toString() {
        return name;
    }
}
