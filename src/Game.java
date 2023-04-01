import java.util.Scanner;
import java.util.Random;

public class Game

{
    public static void main(String[] args)

    {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();


        String[] animals = { "Deer", "kangaroo", "Monkey", "raccoon" };
        String[] shopItems = { "Brick", "Stick", "Hat", "Shirt", "Jordan Shoes" };
        String randomItem = null;

        int animalAttackDamage = 25;
        int animalHealth = 0;

        String[] bossList = { "Bear" };

        int bearArmor = 20;
        int bearAttack = 65;
        int bearSpecialAttackValue = 150;



        int playerHealth = 90;
        int playerAttackDamage = 60;
        int initialPlayerAttack = playerAttackDamage;
        int playerArmorValue = 0;//we are naked at the beginning

        int numBurgers = 5;
        int burgerHealthEffect = 30;
        int healthBurgerDropChance = 50;

        int healthLostWhileRunning = 15;

        int numStrengthEnergyDrinks = 1;
        int strengthEnergyDrinkEffect = (rand.nextInt(3) + 1);

        int bearWeaponChance = 25;
        int cadDropChance = 75;
        int cadDropAmount;
        int cadAmount = 1000;



        int buyEnergyDrink;
        int buyBurger;

        int untilBearCount = 4;

        boolean running = true;

        System.out.println("You are entering 'Crazy Jungle' during night. Even though all of your friends told you not to go there." +
                " You want to prove your tribe that you are a real man. Oh Well" +
                " You have taken few burgers and energy drinks. You are very unhealthy person. Energy will give you some power, " +
                "and food will recover your health.");

        GAME:

        while(running)

        {

            System.out.println("__________________________________________________________");

            String animal = animals[rand.nextInt(animals.length)];

            System.out.println("\t# " + animal + " comes into your view! #\n");


            switch (animal)
            {
                case "Deer":
                    animalHealth = rand.nextInt(90) + 50;

                    animalAttackDamage = 10;

                    break;
                case "Monkey":
                    animalHealth = rand.nextInt(140) + 70;

                    animalAttackDamage = 20;

                    break;
                case "kangaroo":
                    animalHealth = rand.nextInt(250) + 90;

                    animalAttackDamage = 40;

                    break;
                case "raccoon":
                    animalHealth = rand.nextInt(60) + 100;

                    animalAttackDamage = 60;

                    break;
            }




            //TODO COMBAT
            label:
            while(animalHealth > 0)
            {


                System.out.println("\tYour Health is: " + playerHealth);
                System.out.println("\t" + animal + "'s Health: " + animalHealth);
                System.out.println("\n\tWhat will you do?");


                System.out.println("\t1. Attack");
                System.out.println("\t2. Eat chicken burger and recover some health");
                System.out.println("\t3. Keep walking!");
                System.out.println("\t4. Drink energy drink and become a bit stronger");
                System.out.println("\t5. Wait and see what will happen");

                String input = scanner.nextLine();

                switch (input) {
                    case "1" -> {

                        int damageDealt = rand.nextInt(playerAttackDamage);

                        int damageTaken = rand.nextInt(animalAttackDamage) - (playerArmorValue);


                        animalHealth -= damageDealt;

                        playerHealth -= damageTaken;

                        if (damageTaken <= 0) {

                            damageTaken = rand.nextInt(5) + 5;

                        }


                        System.out.println("\t> You deal " + damageDealt + " damage to " + animal);

                        System.out.println("\t> You receive " + damageTaken + " in retaliation! " + animal + "doesn't stand and watch you hit them. Of course he will hit you back!");

                        if (playerHealth < 1) {

                            System.out.println("\t> You have taken too much damage, you should have listened to your intuition and not play this game. You lost! I hope you will not repeat the same mistake twice!");
                            break label;

                        }

                    }
                    case "2" -> {
                        if (numBurgers > 0) {


                            playerHealth += burgerHealthEffect;

                            numBurgers--;

                            System.out.println("\t> You ate a good burger from kfc and recover by " + burgerHealthEffect + " health!"
                                    + "\n\t> Now your health is " + playerHealth + " ...."
                                    + "\n\t> You have " + numBurgers + " burgers left. You better be wise with your food, you never know when you get home again!\n)");

                        } else {

                            System.out.println("\t> You have no burgers left! ");

                        }
                    }
                    case "3" -> {

                        playerHealth -= healthLostWhileRunning;

                        System.out.println("\tYou run away from the " + animal + "! You lost " + healthLostWhileRunning + "health. Your health now is " + playerHealth);

                        if (playerHealth < 1) {

                            System.out.println("\t> You have been running for too long. Now you dont have any strength left. You lost!");
                            break label;

                        }
                        continue GAME;
                    }
                    case "4" -> {
                        int playerAttack = playerAttackDamage;

                        if (numStrengthEnergyDrinks > 0) {

                            playerAttackDamage = playerAttack * strengthEnergyDrinkEffect;
                            numStrengthEnergyDrinks--;

                            System.out.println("You drank an energy drink and now you feel more energetic and can strike stronger. Your attack has multiplied by: " + strengthEnergyDrinkEffect + " times!");

                        } else {

                            System.out.println("You dont have any energy drinks, sorry! Maybe you will find some Food machines in the jungle and you can buy some.");
                        }
                        continue GAME;
                    }
                    case "5" -> {
                        int damageDealt = animalAttackDamage - playerArmorValue;

                        if (damageDealt < 0)
                            damageDealt = -damageDealt;

                        playerHealth -= damageDealt;

                        System.out.println(animal + " got aggressive and attacked you ");

                    }
                    default -> System.out.println("\tInvalid command...");
                }

            }

            if (playerHealth < 1)

            {

                System.out.println("\n\tYour friends heard you crying and came to help you out.. Jungle whispered come back some other day.");
                break;

            }

            System.out.println("-------------------------------------------------");
            System.out.println(" # " + animal + " got tired from your presence and raised a white flag. You won #");
            System.out.println(" # You have " + playerHealth + " health left. You continue your journey #");

            playerAttackDamage = initialPlayerAttack;

            if(rand.nextInt(100) < healthBurgerDropChance)

            {

                switch (animal) {
                    case "Monkey" -> healthBurgerDropChance = 55;
                    case "kangaroo" -> healthBurgerDropChance = 60;
                    case "raccoon" -> healthBurgerDropChance = 75;
                }

                numBurgers++;

                System.out.println(" # The " + animal + " gave you a burger as a reward! # ");
                System.out.println(" # You have " + numBurgers + " burgers. # ");

            }

            if(rand.nextInt(100) < cadDropChance)

            {

                switch (animal) {
                    case "Monkey" -> cadDropChance = 44;
                    case "kangaroo" -> cadDropChance = 65;
                    case "raccoon" -> cadDropChance = 85;
                }

                cadDropAmount = rand.nextInt(500) + 1;

                cadAmount += cadDropAmount;

                System.out.println(" # The " + animal + " gave " + cadDropAmount + " CAD and said 'you need it more' #");
                System.out.println(" # You now have " + cadAmount + " Canadian Dollars. #");

            }

            System.out.println("______________________________________________________________________________");
            System.out.println("What's the nest step?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Give up");
            System.out.println("3. Visit the shop");
            System.out.println("4. Scream for help...");

            String input = scanner.nextLine();


            while(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4"))
            {

                System.out.println("You cannot do that... please choose a real action! Its not a game or movie!");
                input = scanner.nextLine();

            }

            if (input.equals("1"))

            {

                System.out.println("You continue your way.");

                continue GAME;

            }

            else if (input.equals("2"))

            {

                System.out.println("You heard peoples noise. you followed it and found a local tribe. They helped you to get home.");
                break;

            }

            else if (input.equals("4") && untilBearCount >= 4)        // Boss Battle Sequence, few special rules...

            {
                untilBearCount -= 4;

                System.out.println("-------------------------------------------------");
                System.out.println("\t# You were screaming so loud so that you woke up a bear. Now angry bear wants to attack you! #");

                int bearHealth = 2500;
                String enemyBoss = bossList[0];

                System.out.println("\t# " + enemyBoss + " appears! #\n");

                label:
                while(bearHealth > 0)

                {
                    // Enemy introduction and presentation of options.

                    System.out.println("\tYour health is: " + playerHealth);
                    System.out.println("\t" + enemyBoss + "'s health is: " + bearHealth);
                    System.out.println("\n\tWhat are you going to do?");

                    // Player options

                    System.out.println("\t1. Attack");
                    System.out.println("\t2. Eat burger");
                    System.out.println("\t3. Run away!");
                    System.out.println("\t4. Drink energy drink");

                    String inputBossFight = scanner.nextLine();

                    switch (inputBossFight) {
                        case "1" -> {
                            int bossDamageDealt = rand.nextInt(playerAttackDamage) - (bearArmor);
                            int bossDamageTaken = rand.nextInt(bearAttack) - (playerArmorValue);

                            bearHealth -= bossDamageDealt;

                            playerHealth -= bossDamageTaken;

                            if (bossDamageTaken <= 0) {

                                bossDamageTaken = rand.nextInt(20) + 10;

                            }
                            System.out.println("\t> You strike the " + enemyBoss + " for " + bossDamageDealt + " damage.");
                            System.out.println("\t> You receive " + bossDamageTaken + " in return!");

                            if (playerHealth < 1) {

                                System.out.println("\t> You have taken too much damage, you give up!");
                                break label;

                            }
                        }
                        case "2" -> {
                            if (numBurgers > 0) {

                                playerHealth += burgerHealthEffect;
                                numBurgers--;

                                System.out.println("\t> You ate a kfc burger and recover " + burgerHealthEffect + " health!"
                                        + "\n\t> You now have " + playerHealth + " health."
                                        + "\n\t> You have " + numBurgers + " burgers left.\n)");

                            } else {

                                System.out.println("\t> You have no burgers left! ");

                            }
                        }
                        case "3" -> {
                            playerHealth -= 50;

                            System.out.println("\tYou run away from the " + animal + "! It was not easy so you lost 50 health");

                            if (playerHealth < 1) {

                                System.out.println("\t> Now you are too exhausted. You gave up.... Your health is 0");
                                break label;

                            }
                            continue GAME;
                        }
                        case "4" -> {

                            int playerAttack = playerAttackDamage;

                            if (numStrengthEnergyDrinks > 0) {

                                playerAttackDamage = playerAttack * strengthEnergyDrinkEffect;

                                numStrengthEnergyDrinks--;

                                System.out.println("You drank an energy drink and you are stronger by: " + strengthEnergyDrinkEffect + " times!");

                            } else {
                                System.out.println("You don't have any energy drinks left");
                            }
                        }
                        default -> System.out.println("\tInvalid command...");
                    }

                }

                if (playerHealth < 1)

                {

                    System.out.println("\n\tYour health is too low to continue. Your friends will find you in few days and sae you. You can come back some other time.");
                    break;

                }

                if (bearHealth <= 100)

                {

                    System.out.println("\n\t!!!# The Bear jumped on top of you #!!!");

                    playerHealth -= bearSpecialAttackValue;

                    System.out.println("\t>!!!# You got hit by " + bearSpecialAttackValue + " from the Bear's claws! #!!!");

                    if(playerHealth < 1)
                    {

                        System.out.println("\t> You did not make it... Your health is 0. ");
                        break;

                    }

                }

                System.out.println("___________________________________________________________________________");
                System.out.println(" # " + enemyBoss + " lost! #");
                System.out.println(" # You still have " + playerHealth + " Health left. #");

                playerAttackDamage = initialPlayerAttack;

                if(rand.nextInt(100) < healthBurgerDropChance)

                {

                    numBurgers++;
                    numStrengthEnergyDrinks++;

                    System.out.println(" # You went to the " + enemyBoss + " cage and found a burger and energy drink! Of course it is not your favorite energy drink brand. You were a bit surprised to find it in his cage. # ");
                    System.out.println(" # Now you have " + numBurgers + " burgers, and " + numStrengthEnergyDrinks + " energy drinks! #");

                }

                if(rand.nextInt(100) < cadDropChance)

                {

                    cadDropAmount = rand.nextInt(500) + 1000;
                    cadAmount += cadDropAmount;

                    System.out.println(" # In addition " + enemyBoss + " had " + cadDropAmount + " of Canadian Dollars! You dont know how " + enemyBoss + " had that in his cage #");
                    System.out.println(" # You now have " + cadAmount + " CAD. Wohoo! Maybe you will start your own business if you make it #");

                }

                if (rand.nextInt(100) < bearWeaponChance)

                {

                    System.out.println("\n\t!!!# You made a weapon from Bear's teeth and now your attack has increased three times! #!!!");

                    playerAttackDamage *= 3;

                    System.out.println(" # Your attack now is " + playerAttackDamage);

                }

            }



            else if (input.equals("3"))

            {

                System.out.println("\nYou met some intelligent monkeys. They have an offer for you...");

                randomItem = shopItems[rand.nextInt(shopItems.length)];



                SHOP:
                System.out.println("\nWould to like to buy: " + randomItem + "? If you say no we will offer you to buy burgers:)");

                switch (randomItem) {
                    case "Brick" -> System.out.println("\nIts just 1000 CAD. Intelligent monkeys really want your money. So think twice if you really need this item.");
                    case "Stick" -> System.out.println("\nThat will be 250 CAD. Intelligent monkeys really want your money. So think twice if you really need this item.");
                    case "Hat" -> System.out.println("\nThat will be 150 CAD. Intelligent monkeys really want your money. So think twice if you really need this item. They wanna build schools and educate more monkeys to fight against human. We should not sponsor that");
                    case "Shirt" -> System.out.println("\nThat will be 200 CAD. Intelligent monkeys really want your money. So think twice if you really need this item.");
                    case "Jordan Shoes" -> System.out.println("\nThat will be 100 CAD. Intelligent monkeys really want your money. So think twice if you really need this item.");
                    }

                System.out.println("1. Yes");
                System.out.println("2. No");

                String input1 = scanner.nextLine();



                if (input1.equals("1") && randomItem.equals("Brick"))

                {

                    System.out.println("Of course you will not regret this decision.....");

                    cadAmount -= 1000;
                    if (cadAmount < 0) {
                        System.out.println("You could not afford claimed amount. Monkeys got mad and sent you to school. Your journey is over.");
                        break GAME;
                    }
                    playerAttackDamage += 100;

                    shopItems[0] = "Empty";

                    continue GAME;

                }

                else if (input1.equals("1") && randomItem.equals("Stick"))

                {

                    System.out.println("250 CAD for stick. Lol. That's why these monkeys are intelligent ");

                    cadAmount -= 250;
                    if (cadAmount < 0) {
                        System.out.println("You could not afford claimed amount. Monkeys got mad and sent you to school. Your journey is over.");
                        break GAME;
                    }
                    playerAttackDamage += 25;

                    shopItems[1] = "Empty";

                    continue GAME;

                }

                else if (input1.equals("1") && randomItem.equals("Hat"))

                {

                    System.out.println("You get + 10 armor");

                    cadAmount -= 150;
                    if (cadAmount < 0) {
                        System.out.println("You could not afford claimed amount. Monkeys got mad and sent you to school. Your journey is over.");
                        break GAME;
                    }
                    playerArmorValue += 10;

                    shopItems[2] = "Empty";

                    continue GAME;

                }

                else if (input1.equals("1") && randomItem.equals("Shirt"))

                {

                    System.out.println("You get +18 armor");

                    cadAmount -= 200;
                    if (cadAmount < 0) {
                        System.out.println("You could not afford claimed amount. Monkeys got mad and sent you to school. Your journey is over.");
                        break GAME;
                    }
                    playerArmorValue += 18;

                    shopItems[3] = "Empty";

                    continue GAME;

                }

                else if (input1.equals("1") && randomItem.equals("Jordan Shoes"))

                {

                    System.out.println("From this purchase you get +8 armor. Of course its worth (definitely not)");

                    cadAmount -= 100;
                    if (cadAmount < 0) {
                        System.out.println("You could not afford claimed amount. Monkeys got mad and sent you to school. Your journey is over.");
                        break GAME;
                    }
                    playerArmorValue += 8;

                    shopItems[4] = "Empty";

                    continue GAME;

                }

                else if (input1.equals("2"))

                {

                    System.out.println("\nWould you like to buy burgers or energy drinks at least?");
                    System.out.println("1. Yes");
                    System.out.println("2. No!");

                    String input2 = scanner.nextLine();



                    POTIONCHOICE:

                    if (input2.equals("2"))

                    {

                        System.out.println("\nOkay. You probably saving money for the next game.");

                        continue GAME;

                    }

                    if (input2.equals("1"))

                    {

                        System.out.println("\n You have " + cadAmount + " CAD. Burgers or Energy drinks? Yes! Intelligent monkeys charge a lot because: 1) They are intelligent 2) Have you seen monkeys selling burgers? Exactly!");
                        System.out.println("1. Burgers: 100 CAD");
                        System.out.println("2. Energy drinks: 500 CAD");
                        System.out.println("3. I don't want it. Its overpriced!");
                        System.out.println("4. You better give all of your goods to me for free!");

                        String input3 = scanner.nextLine();

                        switch (input3) {
                            case "1" -> {
                                System.out.println("How many would you like to buy? Calculate well how many you can afford. Monkeys dont play games");

                                int inputNumH = scanner.nextInt();

                                cadAmount -= inputNumH * 100;

                                if (cadAmount < 0) {
                                    System.out.println("You could not afford claimed amount. Monkeys got mad and sent you to school. Your journey is over.");
                                    break GAME;
                                }

                                numBurgers += inputNumH;

                                System.out.println("Here you are: " + inputNumH + " burgers.");

                                continue GAME;
                            }
                            case "2" -> {
                                System.out.println("How many would you like to buy?");

                                int inputNumS = scanner.nextInt();

                                cadAmount -= inputNumS * 500;

                                if (cadAmount < 0) {
                                    System.out.println("You could not afford claimed amount. Monkeys got mad and sent you to school. Your journey is over.");
                                    break GAME;
                                }

                                numStrengthEnergyDrinks += inputNumS;

                                System.out.println("Here you are: " + inputNumS + " energy drinks.");

                                continue GAME;
                            }
                            case "3" -> {

                                System.out.println("Stop wasting my time!");

                                continue GAME;
                            }
                            case "4" -> {

                                System.out.println("You underestimated monkeys. They robbed you instead. Now you have 0 CAD.");
                                cadAmount = 0;

                                continue GAME;
                            }
                            default -> {

                                System.out.println("What are you trying to say?! Monkeys don't speak human language that well. They got confused and left you.");

                                continue GAME;
                            }
                        }



                    }




                }

                System.out.println("\n\t# I hope you liked it!!!! # ");

                break;

            }

        }

    }
}