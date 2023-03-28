package kerdrel.tugdual.ressources;

import kerdrel.tugdual.characters.Boss;
import kerdrel.tugdual.characters.Enemy;
import lombok.Getter;

public enum Levels {

    FIRST("The Philosopher’s Stone",
            new String[]{"After a long summer, you are ready to start your first year at Hogwarts !", "One day, you are with your best friend Ron Weasly, but you hear a huge scream !", "You run to see in the girls toilets, and you see Hermione Granger and a Troll !", "You will have to combat this Troll to finish this first year !"},
            //get the informations to build the boss from the enum without hard coding it
            Boss.builder().health(100).shield(10).attackPower(30).name("Troll").build(),
            100,
            10,
            10,
            "Toilets of the dungeon",
            null,
            0,
            0,
            0),
    SECOND("The Chamber of Secrets",
            new String[]{"After defeating the Troll last year, you made it to the second year !", "But this time, something sinister lurks in the school's hallways. Students begin to turn to stone, and a mysterious voice chants warnings about a \"Chamber of Secrets\" that must be opened.", "You will have to defeat the terrible Basilic ! !"},
            Boss.builder().health(100).shield(10).attackPower(30).name("Basilic").build(),
            100,
            10,
            10,
            "The Chamber of Secrets",
            null,
            0,
            0,
            0),
    THIRD("The Prisoner of Azkaban",
            new String[]{"Congratulations on your second year! You are once again at Hogwarts.", "But this year, you heard that the terrible Sirius Black, escaped from Azkaban !", "To protect you, the administration has put in place detractors, monsters that suck the souls out of bad people.", "You will have to face one of them who can't control himself adn tries to attack you (Are you bad ?) !"},
            Boss.builder().health(100).shield(10).attackPower(40).name("Detractor").build(),
            100,
            10,
            10,
            "lake in the forbidden forest",
            null,
            0,
            0,
            0
    ),
    FOURTH("The Deathly Hallows",
            new String[]{"This is the final step of your career as a Wizard !", "You finally have the Deathly Hallows, and you will have to face Voldemort !"},
            Boss.builder().health(100).shield(20).attackPower(50).name("Voldemort").build(),
            200,
            20,
            30,
            "The Great Hall",
            Enemy.builder().health(130).shield(40).attackPower(30).name("Bellatrix Lestrange").build(),
            130,
            40,
            5
    );

    private @Getter String name;

    private @Getter String[] text;
    private @Getter Boss boss;
    private @Getter int bossHealth;
    private @Getter int bossShield;
    private @Getter int bossAttackPower;
    private @Getter String place;

    private @Getter Enemy enemy;

    private @Getter int enemyHealth;
    private @Getter int enemyShield;
    private @Getter int enemyAttackPower;

    Levels(String name, String[] text, Boss boss, int bossHealth, int bossShield, int bossAttackPower, String place, Enemy enemy, int enemyHealth, int enemyShield, int enemyAttackPower) {
        this.name = name;
        this.text = text;
        this.boss = boss;
        this.bossHealth = bossHealth;
        this.bossShield = bossShield;
        this.bossAttackPower = bossAttackPower;
        this.place = place;
        this.enemy = enemy;
        this.enemyHealth = enemyHealth;
        this.enemyShield = enemyShield;
        this.enemyAttackPower = enemyAttackPower;
    }


}
