package Game;

import Enemy.Enemy;
import Enemy.Boss;
import Spell.ApplySpell;

import java.util.Objects;
import java.util.Scanner;

public class Level {
    private Game game;

    public Level(Game game) {
        this.game = game;
    }
    static Scanner scanner = new Scanner(System.in);
    public static void adventure1st(){
        System.out.println("The first level:  The Philosopher’s Stone.");
        System.out.println("\"Kid, this adventure is very dangerous, please be very careful. I divined for you yesterday and the stars show that you need Wingardium leviosa to help you with this adventure.\" Dean Dumbledore instructed. After saying that, he taught you a brand new magic.");
        ApplySpell applySpell = ApplySpell.chooseApplySpell(1);
        Game.applySpells.add(applySpell);
        Game.waitForInput();
        System.out.println("Congratulations on learning Wingardium leviosa. start your adventure.");
        Game.waitForInput();
        System.out.println("In order to explore the secrets of the Sage's Stone, you came alone to the dungeon.");
        System.out.println("There are a few Juvenile Trolls in front of you, so tackle them.");
        Game.waitForInput();
        Game.combat(Enemy.juvenileTrolls);
        System.out.println("After some exploration you came to the door of the dungeon toilet, which seems to have a dangerous atmosphere, whether to enter?");
        System.out.println("1. Enter\n" + "2. Don't enter");
        int chooseEnter = scanner.nextInt();
        boolean isValidChooseEnter = (chooseEnter == 1)||(chooseEnter == 2);
        while (!isValidChooseEnter){
            System.out.println("Wrong input, please reselect.");
            System.out.println("1. Enter\n" + "2. Don't enter");
            chooseEnter = scanner.nextInt();
            isValidChooseEnter = (chooseEnter == 1)||(chooseEnter == 2);
        }
        if (chooseEnter == 1){
            System.out.println("After thinking about it, you decide to enter the dungeon toilet full of danger.");
            Game.waitForInput();
            boss1st();
        } else if (chooseEnter == 2) {
            System.out.println("After thinking about it, you decide not to enter the dungeon toilet.");
            System.out.println("But you find that you are surrounded by enemies.");
            Game.waitForInput();
            Game.combat(Enemy.juvenileTrolls);
            Game.waitForInput();
            System.out.println("You find yourself surrounded by enemies, and you fight and retreat, and finally retreat to the door of the dungeon toilet. You find that the enemy seems to be afraid of the dungeon toilet, so you enter the dungeon toilet anyway.");
            Game.waitForInput();
            boss1st();
        }
    }
    public static void boss1st(){
        System.out.println("You sneak into the dungeon toilet and you find an oversized troll.");
        System.out.println("It looks like you can't beat it.");
        Game.waitForInput();
        System.out.println("After observing the environment, you found a nearby boulder, and then think of the spell Dumbledore taught you before the trip, you suddenly have a way.");
        Game.waitForInput();
        System.out.println("You use Wingardium leviosa to lift a nearby boulder and smash it against the troll.");
        System.out.println("With a wail from the troll, the troll is smashed by the boulder and is a bloody mess, but it also finds you.");
        Game.waitForInput();
        Game.combatBoss(Boss.troll);
        System.out.println("Congratulations you have successfully defeated the troll and you are in level 2!");
        System.out.println("After returning to school, you received a compliment from Dean Dumbledore.");
        Game.waitForInput();
        System.out.println("About to return to school.");
        Game.waitForInput();
    }
    public static void adventure2nd(){
        Enemy.snake.setHP(200);
        System.out.println(Enemy.snake.getHP());
        System.out.println("Level 2: The Chamber of Secrets");
        System.out.println("After a period of rest, you received an order from Dean Dumbledore.");
        System.out.println("\"Kid，go and defeat the Basilic in the chamber, then destroy Tom Riddle's diary with its fangs.\" Dean Dumbledore has said");
        Game.waitForInput();
        if(Objects.equals(Game.wizard.getHouse().getName(), "Gryffindor")){
            System.out.println("\"Don't forget that you are a Gryffindor and that you can summon the legendary sword of Godric Gryffindor in times of need through courage and loyalty. \"Before your departure your Dean Minerva McGonagall instructed you.");
            Game.waitForInput();
        }
        System.out.println("After some exploration, you found the hidden room, but in front of the room, there is a large poisonous snake guarding, quickly defeat it.");
        Game.waitForInput();
        Game.combat(Enemy.snake);
        System.out.println("After eliminating the snake, you enter the hidden room.");
        Game.waitForInput();
        boss2nd();
    }

    public static void boss2nd(){
        System.out.println("In the room, you find Basilic, whose large size makes you wince.");
        Game.waitForInput();
        if (Objects.equals(Game.wizard.getHouse().getName(), "Gryffindor")){
            System.out.println("You think of Minerva McGonagall's command and decide to overcome your fears and summon the legendary sword of Godric Gryffindor with courage and loyalty to defeat your enemies.");
            System.out.println("With your call, the legendary sword of Godric Gryffindor appears and it turns into a light and rushes towards Basilic.");
            Game.waitForInput();
            System.out.println("Basilic is wiped out!");
        }else {
            System.out.println("You still mustered up the courage and decided to fight Basilic!");
            Game.waitForInput();
            Game.combatBoss(Boss.basilic);
            System.out.println("After a hard-fought battle, you defeated Basilic!");
        }
        Game.waitForInput();
        System.out.println("You then pulled Basilic's fangs and used them to destroy Tom Riddle's diary.");
        System.out.println("Upon your return to the college, you once again received a warm welcome from all your fellow students and professors.");
        Game.waitForInput();
        System.out.println("About to return to school.");
        Game.waitForInput();
    }

    public static void adventure3rd(){
        System.out.println("Level 3: The Prisonner of Azkaban");
        System.out.println("In recent times, many Dementors have inexplicably appeared near Hogwarts, roaming the streets and wandering the countryside ...... wilfully harming others. One of your classmates was hurt by a Dementor, so you decided to learn the legendary Patronus spell to expel these Dementors.");
        Game.waitForInput();
        System.out.println("For this reason, you find Remus Lupin and ask him to teach you this defense spell.");
        Game.waitForInput();
        System.out.println("Remus Lupin happily agreed, but he said it was a difficult spell and you would need several attempts to learn it.");
        System.out.println("You started studying.");
        System.out.println("The first time, you failed because the moment you had in mind was not good enough, and fortunately Remus Lupin saved you.");
        Game.waitForInput();
        System.out.println("You didn't give up, and this time, you managed to cast Expectro Patronum using your fond memories of spending time with your parents.");
        ApplySpell applySpell = ApplySpell.chooseApplySpell(2);
        Game.applySpells.add(applySpell);
        Game.waitForInput();
        System.out.println("You bid farewell to Remus Lupin and decide to set out on the road to expel the Dementors.");
        Game.waitForInput();
        boss3rd();
    }
    public static void boss3rd(){
        System.out.println("In the wilderness, you find a group of dementors. They found you, too.");
        Game.waitForInput();
        System.out.println("When they come at you, you use Expectro Patronum again, and all of a sudden, a white light rises to the sky, and the image of a Patronus gradually becomes solid in the white light, fending off the Dementors' attacks.");
        Game.waitForInput();
        System.out.println("A Dementor's wail rang out, the majority of Dementors flew backwards, only one Dementor seemed to be frozen in place like a fool.");
        System.out.println("You rush up and decide to educate the dementor with an attack spell of your own.");
        Game.waitForInput();
        Game.combatBoss(Boss.dementor);
        System.out.println("With the Dementors dissipating in place, you know these Dementors will never dare to infest Hogwarts again, and you've successfully banished them!");
        System.out.println("Back at House, you became a real star and everyone thanked you.");
        Game.waitForInput();
        System.out.println("About to return to school.");
        Game.waitForInput();
    }

    public static void adventure4th(){
        System.out.println("Level 4: The Goblet of Fire.");
        System.out.println("After winning the Triwizard Tournament, you reaped a rare period of peace and quiet in which you desperately tried to learn various spells.");
        System.out.println("Among other things, you learn Accio, a magical spell that can manipulate items to fly into your hands.");
        ApplySpell applySpell = ApplySpell.chooseApplySpell(3);
        Game.applySpells.add(applySpell);
        Game.waitForInput();
        System.out.println("You also learn about various magic items and how to use them in the museum class.");
        Game.waitForInput();
        System.out.println("Suddenly one day, you received a distress message about a friend, and without the slightest doubt, you followed the instructions in the message to the cemetery.");
        System.out.println("But there is no friend of yours here, you were deceived by Voldemort.");
        Game.waitForInput();
        System.out.println("You had to find a way to get around Voldemort and Peter Pettigrew while you were at it.");
        Game.waitForInput();
        System.out.println("Suddenly, you see the Portkey around Peter Pettigrew's waist, and through the knowledge you learned in your museum class, you know that you can teleport anywhere through it, which is the only possibility for you to be saved.");
        System.out.println("But Peter Pettigrew doesn't want to give you what you want. He assumes a fighting stance and prepares to start using the spell.");
        Game.waitForInput();
        boss4th();
    }
    public static void boss4th(){
        System.out.println("There is no way, you had to beat him first, fortunately Voldemort just stood aside, and did not intervene.");
        Game.waitForInput();
        Game.combatBoss(Boss.peterPettigrew);
        System.out.println("Finally, you send him flying with a spell. In this instant, you use your newly learned spell Accio and use it to draw the Portkey around Peter Pettigrew's waist.");
        Game.waitForInput();
        System.out.println("A burst of light rose, you disappeared in place, before disappearing you took one last look at Voldemort, he looked at you with a smirk, but did not stop.");
        Game.waitForInput();
        System.out.println("After returning to the House, you first found Dean Dumbledore and reported the incident to him. But he could not guess Voldemort's intentions, so he had to remind the students and professors to strengthen the defense of the College.");
        Game.waitForInput();
        System.out.println("About to return to school.");
        Game.waitForInput();
    }

    public static void adventure5th(){
        System.out.println("Level 5: The Order of the Phenix.");
        System.out.println("After your last escape from death, you discovered the importance of learning magic, and during this time, you worked your ass off to learn all kinds of magic.");
        Game.waitForInput();
        System.out.println("Soon, exam of Universal Certificate of Elementary Witchcraft came.");
        System.out.println("You and your buddies did well in the exam.");
        Game.waitForInput();
        System.out.println("To celebrate, you have decided to throw a big party.");
        Game.waitForInput();
        System.out.println("How can a grand party be without fireworks?");
        System.out.println("But all of Hogwarts' fireworks are kept in storage.");
        Game.waitForInput();
        System.out.println("The Hogwarts warehouse is guarded by Dolores Ombrage.");
        System.out.println("You and your partners decide that you will attract Dolores Ombrage's attention while the others sneak into the warehouse and take the fireworks.");
        Game.waitForInput();
        boss5th();
    }
    public static void boss5th(){
        System.out.println("You approach the warehouse and say hello to Dolores Ombrage.");
        System.out.println("What are you doing here? Dolores Ombrage asked you sternly.");
        Game.waitForInput();
        System.out.println("Without speaking, you strike out with a spell.");
        Game.waitForInput();
        Game.combatBoss(Boss.doloresOmbrage);
        System.out.println("You have received a message from your partners.");
        System.out.println("You run away in a hurry.");
        Game.waitForInput();
        System.out.println("After meeting up with friends, the party officially started.");
        System.out.println("You partied all night long and celebrated together.");
        Game.waitForInput();
        System.out.println("About to return to school.");
        Game.waitForInput();
    }

    public static void adventure6th() {
        System.out.println("Level 6: The Half-Blood Prince.\nAfter the party, you have a smooth time again.");
        Game.waitForInput();
        System.out.println("One day, you are learning a new mantra.\nSuddenly, the alarm went off and it was the Death Eaters attacking Hogwarts.");
        boolean slytherin = Objects.equals(Game.wizard.getHouse().getName(), "Slytherin");
        if (slytherin) {
            System.out.println("You feel extreme fear at the sight of the incoming hordes of Death Eaters.\nYou begin to hesitate to join the Death Eaters and become a traitor to Hogwarts.");
            System.out.println("1. Join the Death Eaters.\n2. Fight to the death to protect Hogwarts.");
            int choose = scanner.nextInt();
            boolean isValidChoose = (choose == 1)||(choose == 2);
            while (!isValidChoose){
                System.out.println("Wrong input, please reselect.");
                System.out.println("1. Join the Death Eaters.\n2. Fight to the death to protect Hogwarts.");
                choose = scanner.nextInt();
                isValidChoose = (choose == 1)||(choose == 2);}
            if (choose == 1) {
                System.out.println("You choose to join the Death Eaters and unleash a spell to attack your former classmates.");
                Game.waitForInput();
                System.out.println("But Dean Dumbledore immediately noticed your behavior, and he did not hesitate for a moment to come at you with a spell.\nYou are unavoidably struck by the spell, and you feel endless remorse in the ecstasy between life and death."); Game.waitForInput();
                System.out.println("You are dead, choose the right path in the next life.");
                Game.waitForInput();
                System.exit(0);
            } else if (choose == 2) {
                System.out.println("In the end, your courage overcame cowardice, and you still decided to fight to protect Hogwarts.");
                Game.waitForInput();
                Game.combat(Enemy.deathEaters);}
        } else {
            System.out.println("You pick up your staff and rush in the direction of the Death Eaters' attack.");
            Game.waitForInput();
            Game.combat(Enemy.deathEaters);
        }
        System.out.println("You release a spell that knocks a Death Eater away, followed by a group of Death Eaters surrounding it.");
        Game.waitForInput();
        System.out.println("Just as you are surrounded, a light suddenly strikes, sending all the Death Eaters around you flying. It was Dean Dumbledore's help.");
        Game.waitForInput();
        System.out.println("\"Capture the thief, go and defeat the leader of this group of Death Eaters, and they will naturally retreat.\" Dumbledore said.");
        Game.waitForInput();
        System.out.println("Hearing the instructions of Dean Dumbledore, you resolutely rushed to the most dense area of the Death Eaters, where the leader of this group of Death Eaters is located.");
        Game.waitForInput();
        boss6th();}

    public static void boss6th(){
        System.out.println("To protect the chief, the Death Eaters rush towards you.");
        Game.waitForInput();
        Game.combat(Enemy.deathEaters);
        System.out.println("You use the spell to hit the Death Eaters while moving quickly to prevent being surrounded by them.");
        System.out.println("Finally, after some hard fighting, you finally came to the leader of this group of Death Eaters, fortunately, not Voldemort.");
        Game.waitForInput();
        Game.combatBoss(Boss.doloresOmbrageLeader);
        System.out.println("With the defeat of the leader of the Death Eaters, the siege of Hogwarts Death Eaters also gradually dispersed.");
        System.out.println("You got the win.");
        System.out.println("But you also know that this is not the first time, and will not be the last, it is time to make a break with Voldemort.");
        Game.waitForInput();
        System.out.println("About to return to school.");
        Game.waitForInput();
    }

    public static void adventure7th(){
        System.out.println("Level 7: The Deathly Hallows.");
        System.out.println("For some time after repelling the Death Eaters, you were desperately trying to learn various spells.");
        System.out.println("You vow to end it all by taking care of Voldemort as soon as possible.");
        Game.waitForInput();
        System.out.println("You wanted to seek revenge on Voldemort yourself, but you didn't expect him to take the initiative to come to you.");
        Game.waitForInput();
        System.out.println("Not only did he come, but he brought a large number of Death Eaters and Bellatrix Lestrange.");
        Game.waitForInput();
        System.out.println("They rushed to Hogwarts, and instantly, everyone at the college went into battle.");
        System.out.println("A guardian stone statue fell, a magical light rose to the sky, and everyone did their best to resist Voldemort and the Death Eaters.");
        Game.waitForInput();
        System.out.println("You also joined your classmates and professors, rebelling against Voldemort with a spell.");
        Game.waitForInput();
        Game.combat(Enemy.deathEaters);
        System.out.println("Just when you're in the middle of a good fight, you see Bellatrix Lestrange flying towards you with her staff raised.");
        Game.waitForInput();
        boss7th();
    }
    public static void boss7th(){
        System.out.println("You strike first with an attack spell.");
        Game.waitForInput();
        Game.combatBoss(Boss.bellatrixLestrange);
        System.out.println("You've just defeated Bellatrix Lestrange and watched Voldemort fly towards you.");
        Game.waitForInput();
        System.out.println("In the blink of an eye, an eerie black light struck, and it was Avada Kedavra.");
        Game.waitForInput();
        System.out.println("You can't avoid it, this is your best friend Jim rushed to your front and blocked the blow for you.");
        Game.waitForInput();
        System.out.println("\"Jim!!!\" You wail, while using a spell to hit Voldemort.");
        Game.waitForInput();
        if (Objects.equals(Game.wizard.getWand().getCore(), "PHOENIX_FEATHER")){
            System.out.println("Your wand lights up, and the wand in Voldemort's hand lights up as well.");
            Game.waitForInput();
            System.out.println("You know it's a resonance between the same kind of staff wick, which can lead to unpredictable things happening.");
            Game.waitForInput();
            System.out.println("Just see the wand in Voldemort's hand flew out a light and the light of the wand in your hand merged into one, and all of a sudden, you feel a warm power filled your whole body.");
            Game.wizard.setAttack(Game.wizard.getAttack()+20);
            Game.waitForInput();
            System.out.println("Your attack +20");
            Game.waitForInput();
            System.out.println("You continue to recite the incantation and attack Voldemort.");
            Game.waitForInput();
        }
        System.out.println("In that moment, you decided that even if you put everything you had into it, you would take revenge on Voldemort and bring it all to an end.");
        Game.waitForInput();
        Game.combatBoss(Boss.voldemort);
        System.out.println("Finally, Voldemort falls under your attack and it's all over.");
        Game.waitForInput();
        System.out.println("You feel as if all this is a dream that is not real, but the wreckage and bodies everywhere tell you that it is all real.");
        Game.waitForInput();
        System.out.println("You hugged Jim's body and cried out, as if you were mourning Jim, and as if you were glad it was over.");
        Game.waitForInput();
        System.out.println("About to return to school.");
        Game.waitForInput();
        graduationCeremony();
    }

    public static void graduationCeremony(){
        System.out.println("Finally you have solved your remarkable all the way and finished your seventh grade.");
        Game.waitForInput();
        System.out.println("Now, in the auditorium of Hogwarts, Dean Dumbledore is about to confer the degree on you.");
        Game.waitForInput();
        System.out.println(Game.wizard.getName()+"! "+"Dean Dumbledore called your name.");
        Game.waitForInput();
        System.out.println("You walk from the stage to the stage, and as a star student at Hogwarts, you reap the benefits of more applause and cheers.");
        Game.waitForInput();
        System.out.println("You walked up to the stage, towards Dean Dumbledore, and couldn't help but, you thought of Jim again.");
        Game.waitForInput();
        System.out.println("Dean Dumbledore awarded you your diploma and put on your wizard's hat, and for a moment, you enjoyed the stares and cheers of everyone in the room.");
        Game.waitForInput();
        System.out.println("Out of nowhere, you seem to see Jim sitting on the stage as well, wearing his wizard's robe and wizard's hat, holding his diploma and cheering for you like everyone else.");
        Game.waitForInput();
        System.out.println("After graduation, you joined the Ministry of Magic and became a commissioner of law enforcement.");
        Game.waitForInput();
        System.out.println("For you are sworn to punish all wizards who maliciously use forbidden magic.");
        Game.waitForInput();
        System.out.println("For more people like Jim.");
        Game.waitForInput();
        System.out.println("\"Jim ......\" you murmur, unable to help but think of that best friend of yours again.");
        Game.waitForInput();
        System.out.println("\""+Game.wizard.getName()+"! "+"\"There's a new mission, and this time we're dealing with a wizard who used forbidden magic to slaughter muggles.\"The captain's voice interrupted.");
        Game.waitForInput();
        System.out.println("You put on your wizard's hat, grabbed your wand, and rushed with the captain to the mission site……");
        Game.waitForInput();
        System.exit(0);
    }
}
