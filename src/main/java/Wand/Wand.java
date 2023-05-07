package Wand;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class Wand { //魔杖
    private Core core;
    private int size;
    private String wood;
    private static int pharmacyBonus;  //药水
    private static int attackBonus;  //攻击
    private static int defenseBonus;  //防御
    private static int preciseBonus;  //精准

    public Wand(Core core, int size, String wood, int pharmacyBonus, int attackBonus, int defenseBonus, int preciseBonus) {
        this.core = core;
        this.size = size;
        this.wood = wood;
        Wand.pharmacyBonus = pharmacyBonus;
        Wand.attackBonus = attackBonus;
        Wand.defenseBonus = defenseBonus;
        Wand.preciseBonus = preciseBonus;
    }

    private static final Wand Holly_PHOENIX_FEATHER = new Wand(Core.PHOENIX_FEATHER, 11, "Holly", 0, 5, 5, 0);//冬青木+凤羽，防御+攻击
    public static final Wand Holly_DRAGON_HEARTSTRING = new Wand(Core.DRAGON_HEARTSTRING, 10, "Holly", 0, 5, 0, 5);//冬青木+龙心弦，防御+精准
    private static final Wand Redwood_PHOENIX_FEATHER = new Wand(Core.PHOENIX_FEATHER, 11, "Redwood", 10, 1, 5, 0);//红杉木+凤羽，药水增益+攻击
    private static final Wand Redwood_DRAGON_HEARTSTRING = new Wand(Core.DRAGON_HEARTSTRING, 10, "Redwood", 0, 0, 5, 10);//红杉木+龙心弦，药水增益+精准

    public Core getCore() {
        return core;
    }


    public static Wand chooseWand(int wand) {
        switch (wand) {
            case 1:
                return Holly_PHOENIX_FEATHER;
            case 2:
                return Holly_DRAGON_HEARTSTRING;
            case 3:
                return Redwood_PHOENIX_FEATHER;
            case 4:
                return Redwood_DRAGON_HEARTSTRING;
            default:
                return null;
        }

    }
    public static void getWand(){
        System.out.println("1."+Holly_PHOENIX_FEATHER);
        System.out.println("2."+Holly_DRAGON_HEARTSTRING);
        System.out.println("3."+Redwood_PHOENIX_FEATHER);
        System.out.println("4."+Redwood_DRAGON_HEARTSTRING);
    }

    public String toString() {
        return "Wand: "+ wood +"  "+ core + "   " +size + " inches";
    }

    public static int getPharmacyBonus() {
        return pharmacyBonus;
    }

    public static int getAttackBonus() {
        return attackBonus;
    }

    public static int getDefenseBonus() {
        return defenseBonus;
    }

    public static int getPreciseBonus() {
        return preciseBonus;
    }

}
