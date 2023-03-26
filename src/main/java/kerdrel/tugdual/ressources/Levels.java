package kerdrel.tugdual.ressources;

import kerdrel.tugdual.characters.Boss;
import kerdrel.tugdual.characters.Enemy;
import lombok.Getter;

public enum Levels {

    FIRST("The Philosopher’s Stone",
            new String[]{"After a long summer, you are ready to start your first year at Hogwarts !", "One day, you are with your best friend Ron Weasly, but you hear a huge scream !", "You run to see in the girls toilets, and you see Hermione Granger and a Troll !", "You will have to combat this Troll to finish this first year !"},
            Boss.builder().health(100).shield(10).attackPower(10).name("Troll").build(),
            100,
            10,
            10,
            "Toilets of the dungeon",
            null),
    SECOND("The Chamber of Secrets",
            new String[]{"After defeating the Troll last year, you made it to the second year !", "But this time, something sinister lurks in the school's hallways. Students begin to turn to stone, and a mysterious voice chants warnings about a \"Chamber of Secrets\" that must be opened.", "You will have to defeat the terrible Basilic ! !"},
            Boss.builder().health(100).shield(10).attackPower(10).name("Basilic").build(),
            100,
            10,
            10,
            "The Chamber of Secrets",
            null),
    THIRD("The Prisoner of Azkaban",
            new String[]{"Congratulations on your second year! You are once again at Hogwarts.", "But this year, you will have to face the terrible Sirius Black, who escaped from Azkaban !", "o protect you, the administration has put in place detractors, monsters that suck the souls out of people.", "You will have to face one of them who can't control himself adn tries to attack you !"},
            Boss.builder().health(100).shield(10).attackPower(10).name("Detractor").build(),
            100,
            10,
            10,
            "lake in the forbidden forest",
            null);

    private @Getter String name;

    private @Getter String[] text;
    private @Getter Boss boss;
    private @Getter int bossHealth;
    private @Getter int bossShield;
    private @Getter int bossAttackPower;
    private @Getter String place;

    private @Getter Enemy enemy;

    Levels(String name, String[] text, Boss boss, int bossHealth, int bossShield, int bossAttackPower, String place, Enemy enemy) {
        this.name = name;
        this.text = text;
        this.boss = boss;
        this.bossHealth = bossHealth;
        this.bossShield = bossShield;
        this.bossAttackPower = bossAttackPower;
        this.place = place;
        this.enemy = enemy;
    }


}
