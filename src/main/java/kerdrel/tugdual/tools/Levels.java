package kerdrel.tugdual.tools;

import kerdrel.tugdual.characters.Boss;
import lombok.Getter;

public enum Levels {

    FIRST("La Pierre Philosophale",
            new String[]{"After a long summer, you are ready to start your first year at Hogwarts !", "One day, you are with your best friend Ron Weasly, but you hear a huge scream !", "You run to see in the girls toilets, and you see Hermione Granger and a Troll !", "You will have to combat this Troll to finish this first year !"},
            new Boss("Troll", 100, 10, 10),
            100,
            10,
            10,
            "Toilettes du donjon");

    private @Getter String name;

    private @Getter String[] text;
    private @Getter Boss boss;
    private @Getter int bossHealth;
    private @Getter int bossShield;
    private @Getter int bossAttackPower;
    private @Getter String place;

    Levels(String name, String[] text, Boss boss, int bossHealth, int bossShield, int bossAttackPower, String place) {
        this.name = name;
        this.text = text;
        this.boss = boss;
        this.bossHealth = bossHealth;
        this.bossShield = bossShield;
        this.bossAttackPower = bossAttackPower;
        this.place = place;
    }


}
