package Spell;



public class Spell extends AbstractSpell {
    public Spell(String name, int damage, float precise) {
        super(name, damage, precise);
    }

    public static final Spell reducto = new Spell("Reducto", 10, 0.8f);//粉身碎骨
    public static final Spell confringo = new Spell("Confringo", 15, 0.85f);//霹雳爆炸
    public static final Spell locomotorMortis = new Spell("Locomotor mortis", 25, 0.75f);//腿立僵
    public static final Spell diffindo = new Spell("Diffindo", 35, 0.7f);//四分五裂
    public static final Spell incendio = new Spell("Incendio", 50, 0.65f);//火焰熊熊
    public static final Spell deprimo = new Spell("Deprimo", 70, 0.6f);//房塌地陷
    public static final Spell expulso = new Spell("Expulso", 90, 0.55f);//房塌地陷
    public static void getSpell(){
        System.out.println("1."+reducto+"            Need lv.1");
        System.out.println("2."+confringo+"          Need lv.3");
        System.out.println("3."+locomotorMortis+"   Need lv.5");
        System.out.println("4."+diffindo+"           Need lv.7");
        System.out.println("5."+incendio+"           Need lv.9");
        System.out.println("6."+deprimo+"            Need lv.11");
        System.out.println("7."+expulso+"            Need lv.13");
    }
    public static Spell chooseSpell(int spell) {
        switch (spell) {
            case 1:
                return reducto;
            case 2:
                return confringo;
            case 3:
                return locomotorMortis;
            case 4:
                return diffindo;
            case 5:
                return incendio;
            case 6:
                return deprimo;
            case 7:
                return expulso;
            default:
                return null;
        }

    }


    public String toString() {
        return name;
    }

}
