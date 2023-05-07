package Spell;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public abstract class AbstractSpell {
    public String name;
    int damage;
    float precise;


    public AbstractSpell(String name, int damage, float precise){
        this.name = name;
        this.damage = damage;
        this.precise = precise;

    }

}
