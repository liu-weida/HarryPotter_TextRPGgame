package Potion;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Potion { //药水
    private String name;
    private int addHP;


    public Potion(String name, int addHP) {
        this.name = name;
        this.addHP = addHP;
    }

    public static final Potion invigorationDraught = new Potion("Invigoration Draught", 20);//活力滋补剂
    private static final Potion bruiseHealing = new Potion("Bruise Bealing", 40);//淤伤治疗剂
    private static final Potion bloodrReplenishing = new Potion("Blood Replenishing", 60);//补血药
    private static final Potion skeleGro = new Potion("Skele Gro", 100);//生骨灵


    public static void getPotion() {
        System.out.println("1." + invigorationDraught+"       Need 10 gold");
        System.out.println("2." + bruiseHealing+"             Need 20 gold");
        System.out.println("3." + bloodrReplenishing+"         Need 40 gold");
        System.out.println("4." + skeleGro+"                  Need 80 gold");
    }
    public static Potion choosePotion(int potion) {
        switch (potion) {
            case 1:
                return invigorationDraught;
            case 2:
                return bruiseHealing;
            case 3:
                return bloodrReplenishing;
            case 4:
                return skeleGro;
            default:
                return null;
        }

    }


    public String toString(){
        return name;
    }


}

