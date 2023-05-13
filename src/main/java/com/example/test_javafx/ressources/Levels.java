package com.example.test_javafx.ressources;

import com.example.test_javafx.characters.Boss;
import com.example.test_javafx.characters.Enemy;
import com.example.test_javafx.spells.Spell;
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
            0,
            Spell.builder().name("Accio").damage(15).build(),
            "Wingardium Leviosa"),
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
            0,
            Spell.builder().name("Expecto Patronum").damage(10).build(),
            "Accio"
    ),
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
            0,
            Spell.builder().name("Accio").damage(10).build(),
            "Expecto Patronum"
    ),
    FOURTH("The Goblets Of Ire",
            new String[]{"Welcome to the treacherous world of The Goblet of Fire in this thrilling RPG chapter.", "You have unwittingly won the Triwizard Tournament, only to find yourself facing certain death in the clutches of the dreaded Voldemort and his loyal follower, Peter Pettigrew.", "You must make your way through the eerie cemetery to reach the Portkey", "But be warned, you will face unrelenting danger at every turn, and you will come face to face with the Dark Lord himself.", "Will you have the courage and magic to survive and emerge victorious, or will you succumb to the forces of evil?"},
            Boss.builder().health(100).shield(20).attackPower(50).name("Voldemort").build(),
            200,
            20,
            30,
            "The Great Hall",
            Enemy.builder().health(130).shield(40).attackPower(30).name("Petter Petigrow").build(),
            130,
            40,
            5,
            Spell.builder().name("Fireworks").damage(20).build(),
            "Accio"
    ),
    FIVE("The Order Of The Phoenix",
            new String[]{"Step into the world of The Order of the Phoenix with this exciting RPG chapter.", "You find yourself at the mercy of the dreaded Dolores Umbridge as it's time for the OWL (Ordinary Wizarding Level).", "Your objective? Distract Umbridge long enough for the fireworks to be unleashed.", "But be warned, Umbridge is watching your every move, and any wrong step could land you in serious danger.", "Are you ready to use all your cunning and magic to complete your mission and emerge victorious against the dark forces at play?"},
            Boss.builder().health(100).shield(20).attackPower(50).name("Dolores Ombrage").build(),
            100,
            20,
            50,
            "hogwarts examination room",
            null,
            0,
            0,
            0,
            Spell.builder().name("SectumSempra").damage(15).build(),
            "Fireworks"
    ),
    SIX("The Half Blood Prince",
            new String[]{"Get ready to defend Hogwarts against a fierce attack from the Death Eaters in this epic RPG chapter of The Half-Blood Prince.", "You must confront the enemy head-on with the powerful 'Sectumsempra' spell.", "But be warned, the stakes are high and the danger is real.", "If you are a member of Slytherin, you have a difficult decision to make.", "Will you stay loyal to your house or join the ranks of the Death Eaters?", "It's up to you to use your skills and magic to emerge victorious and save the wizarding world from darkness."},
            Boss.builder().health(100).shield(20).attackPower(50).name("Death Eater").build(),
            100,
            20,
            50,
            "Astronomy Tower",
            null,
            0,
            0,
            0,
            Spell.builder().name("Expelliramus").damage(30).build(),
            "SectumSempra"
    ),
    SEVEN("The Deathly Hallows",
            new String[]{"This is the final step of your career as a Wizard !", "You finally have the Deathly Hallows, and you will have to face Voldemort !"},
            Boss.builder().health(100).shield(20).attackPower(50).name("Voldemort").build(),
            200,
            20,
            30,
            "The Great Hall",
            Enemy.builder().health(130).shield(40).attackPower(30).name("Bellatrix Lestrange").build(),
            130,
            40,
            5,
            null,
            "Avada Kedavra"
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
    private @Getter Spell spellLearnt;
    private @Getter String spellToUse;

    Levels(String name, String[] text, Boss boss, int bossHealth, int bossShield, int bossAttackPower, String place, Enemy enemy, int enemyHealth, int enemyShield, int enemyAttackPower, Spell spellLearnt, String spellToUse) {
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
        this.spellLearnt = spellLearnt;
        this.spellToUse = spellToUse;
    }


}
