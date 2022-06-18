package com.jetbrains;
import java.util.Scanner;


public class Game {

    Scanner myScanner = new Scanner(System.in);
    Scanner enterScanner = new Scanner(System.in);

    int playerHP;
    String playerName;
    String playerType;
    String playerWeapon;
    String playerSkill;

    int choice;
    int enemyHP;

    int workingFuelTank;
    String spareTankStatus = "notFound";
    String people = "notAcquired";
    String starChart = "notAcquired";

    public static void main(String[] args) {

        Game cyber;
        cyber = new Game();

        cyber.setUp();
        cyber.bridge();

    }

    public void setUp(){

        enemyHP = 15;

        System.out.println("\nPlease enter the associated number to pick your character type:\n");
        System.out.println("1: Engineer \n2: Astronomer \n3: Assistant captain\n");

        playerType = myScanner.nextLine();

        if (playerType.equals("1")) {
            playerHP = 15;
            playerWeapon = "wrench";
            playerSkill = "Repair";
        } else if (playerType.equals("2")) {
            playerHP = 15;
            playerWeapon = "extendable telescope";
            playerSkill = "Read Star Chart";
        } else if (playerType.equals("3")) {
            playerHP = 18;
            playerWeapon = "knife";
            playerSkill = "Rally the People";
        } else {
            System.out.println("\nNumber entered was invalid. Please try again.");
            System.out.println("\n------------------------------------------------------------------\n");
            setUp();
        }

        System.out.println("\nYour HP: "+ playerHP);
        System.out.println("Your Weapon: "+ playerWeapon);
        System.out.println("Your Skill: " + playerSkill);

        System.out.println("\nPlease enter your name:");
        playerName = myScanner.nextLine();
        System.out.println("\nHello " + playerName + ". Let's start the game.");
        enterScanner.nextLine();

        System.out.println("------------------------------------------------------------------\n");
        System.out.println("Ever since you were little, you always wanted to go to space. \nSo, when the opportunity " +
                "to join the colony on Mars was presented, you were ecstatic.");
        System.out.println("The training was not easy, but at least it prepared you for the G force of the ship " +
                "leaving the atmosphere.\n");
        System.out.println("Five months in space later, you can safely say it was the best decision you ever made.");
        enterScanner.nextLine();
        System.out.println("------------------------------------------------------------------\n");
        System.out.println("""
                Another day on the ship. You rise from your bunk to find your digital message board blinking with a white light.\s
                Still half asleep, you open the interface and glance through the text on screen.
                """);
        System.out.println("It's a summons from the captain, requesting your presence at the ship's bridge. \nWith a " +
                "sigh, you accept, and grab your trusty " + playerWeapon + " from your bedside table. It " +
                "never hurts to be prepared.");
        enterScanner.nextLine();

        System.out.println("------------------------------------------------------------------\n");
        System.out.println("""
                The captain stands at the front of the ship, looking out into the passing cosmos.\s
                He turns at the sound of the bridge door opening, and relief washes over his face.\s
                """);
        System.out.println("Captain: Ah, " + playerName + ", it's you. Good. \n\nHe lowers his voice so the " +
                "surrounding crew can't hear, and you discretely lean in to listen.");
        enterScanner.nextLine();
        System.out.println("Captain: I'm afraid I have grave news. I didn't want to worry the rest of the crew, but " +
                        "the ship's ");
        System.out.println("diagnostic this morning indicated that the last meteor field we passed jostled the " +
                        "primary fuel tanks.");
        System.out.println("I went to check on them, and the valve of one of them is now too beat up to function.");
        enterScanner.nextLine();
        System.out.println("Captain: I have to go around the passenger decks to make sure that no one was hurt by " +
                        "the meteor impacts.");
        System.out.println("As you know, some alien life forms boarded the ship through the hull breaches they " +
                        "caused, so I'm going to look for stragglers.");
        System.out.println("I was wondering if you could lend me your help with the tanks.");
        enterScanner.nextLine();
        System.out.println("Captain: There are a few ways to fix the fuel tank issue.");
        System.out.println("You could always try repairing the primary fuel tank in the belly of the ship.");
        System.out.println("Alternatively, there should be a spare fuel tank in the storage dock.");
        enterScanner.nextLine();
        System.out.println("------------------------------------------------------------------\n");
        bridge();
    }

    public void bridge(){

        System.out.println("You are at the bridge. What do you want to do?\n");
        System.out.println("1: Talk to the captain");
        System.out.println("2: Go to the belly of the ship");
        System.out.println("3: Go to the storage dock\n");

        choice = myScanner.nextInt();

        if(choice==1){
            if(workingFuelTank==1){
                ending1();
            }
            else if (starChart.equals("acquired")) {
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("You tell the captain about the nearby fuel station. \nAfter a quick conversation " +
                        "with the pilot, he agrees that you can make the trip.");
                System.out.println("The pilot adjusts your course towards the fuel station.");
                enterScanner.nextLine();
                ending3();
            }
            else if (spareTankStatus.equals("acquired")) {
                ending2();
            }
            else{
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("Captain: To fix the fuel tank issue, you can try repairing the primary fuel tank " +
                        "in the belly of the ship.");
                System.out.println("Alternatively, there should be a spare fuel tank in the storage dock.");
                enterScanner.nextLine();
                System.out.println("------------------------------------------------------------------\n");
                bridge();
            }
        }
        else if(choice==2 || choice==3){
            enterHall();
        }
        else{
            System.out.println("\nPlease enter a valid number choice.\n");
            bridge();
        }
    }

    public void enterHall(){

        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You are at a branching hallway. Luckily, working on the ship means you know where it goes" +
                ".\n");
        System.out.println("1: Go forward to the med bay");
        System.out.println("2: Go right to the storage dock");
        System.out.println("3: Go back to the bridge");
        System.out.println("4: Go left to the ship's belly\n");

        choice = myScanner.nextInt();

        System.out.println("\n------------------------------------------------------------------\n");

        if(choice==1){
            medBay();
        }
        else if(choice==2){
            storageDock();
        }
        else if(choice==3){
            bridge();
        }
        else if(choice==4){
            shipBelly();
        }
        else{
            System.out.println("Please enter a valid number choice.");
            enterHall();
        }
    }

    public void medBay(){

        System.out.println("""
                You enter the med bay lobby.\s
                There are several guests milling around, waiting for their injured loved ones to be released.
                """);

        if (playerType.equals("3") && people.equals("notAcquired")) {
            System.out.println("1: Talk to the guests");
            System.out.println("2: See a nurse");
            System.out.println("3: Return to the hall\n");

            choice = myScanner.nextInt();

            if (choice==1 && spareTankStatus.equals("found")) {
                System.out.println("\n1: Use your skill " + playerSkill + "\n");

                choice = myScanner.nextInt();

                if(choice==1){
                    System.out.println("\n------------------------------------------------------------------\n");
                    System.out.println("You tell the waiting guests about the spare fuel tank stuck under debris in" +
                            " ");
                    System.out.println("the storage dock, and request their help.");
                    System.out.println("Respectful of your status, they agree to follow you.");
                    people = "acquired";
                    enterScanner.nextLine();
                    enterHall();
                }
                else{
                    System.out.println("\n");
                    medBay();
                }
            }
            else if (choice==1 && spareTankStatus.equals("notFound")){
                System.out.println("\nGuest: A bunch of us had loved ones get knocked around by the meteor field.");
                System.out.println("It's nothing serious, but we thought we should accompany them here to be safe.");
                enterScanner.nextLine();
                System.out.println("------------------------------------------------------------------\n");
                medBay();
                }
            else if (choice==1 && people.equals("acquired")) {
                System.out.println("Guest: Weren't we supposed to be going to get the spare tank in?");
                System.out.println("\n1: Go into the hall");

                choice = myScanner.nextInt();

                System.out.println("\n------------------------------------------------------------------\n");

                if(choice==1){
                    enterHall();
                }
                else{
                    System.out.println("\n");
                    medBay();
                }
            }
            else if (choice==2) {
                System.out.println("\n------------------------------------------------------------------\n");
                System.out.println("You see a nurse, and they give you some snacks and medical supplies.");
                System.out.println("\nYour HP is recovered.");
                playerHP = 18;
                System.out.println("Your HP: " + playerHP);
                System.out.println("\n1: Go back to the hall\n");

                choice = myScanner.nextInt();

                if(choice==1){
                    enterHall();
                }
                else{
                    System.out.println("\n");
                    medBay();
                }
            }
            else if (choice==3) {
                enterHall();
            }
            else {
                System.out.println("\n");
                medBay();
            }
        }

        else {
            System.out.println("You see a nurse, and they give you some snacks and medical supplies.");
            System.out.println("\nYour HP is recovered.");
            playerHP = 15;
            System.out.println("Your HP: " + playerHP);
            System.out.println("\n1: Go back to the hall\n");

            choice = myScanner.nextInt();

            if(choice==1){
                enterHall();
            }
            else {
                System.out.println("\n");
                medBay();
            }
        }
    }

    public void storageDock(){

        if (people.equals("acquired") && spareTankStatus.equals("found")) {
            System.out.println("You re-enter the storage dock with your backup.");
            System.out.println("The guests help you dislodge the storage crates from each other and haul them off the" +
                    " fuel tank.");
            spareTankStatus = "acquired";
            System.out.println("\nYou have acquired the spare fuel tank! Best take it back to the captain.");

            System.out.println("\n1: Go back to the hall\n");

            choice = myScanner.nextInt();

            if(choice==1){
                enterHall();
            }
            else {
                System.out.println("\n");
                storageDock();
            }
        }
        else if (workingFuelTank==1 || spareTankStatus.equals("acquired") || starChart.equals("acquired")) {
            System.out.println("You continue into the storage dock, for some reason. There's nothing else you need " +
                    "here.");
            System.out.println("\n1: Return to the hall\n");

            choice = myScanner.nextInt();

            if(choice==1){
                enterHall();
            }
            else {
                System.out.println("\n");
                storageDock();
            }
        }
        else {
            System.out.println("You encounter an alien! Looks like there are still some around. \n");
            System.out.println("1: Fight");
            System.out.println("2: Run\n");

            choice = myScanner.nextInt();

            if (choice == 1) {
                fight();
            } else if (choice == 2) {
                enterHall();
            } else {
                System.out.println("\n");
                storageDock();
            }

            System.out.println("------------------------------------------------------------------\n");
            if (playerType.equals("2")) {
                System.out.println("Upon continuing into the storage dock, your heart sinks.");
                System.out.println("There doesn't appear to be anything that looks like a spare fuel tank in sight.");
                System.out.println("That said, there is a table near the door with a digital star chart spread across it.");

                System.out.println("\n1: Use your skill " + playerSkill + "\n");

                choice = myScanner.nextInt();
                System.out.println("\n------------------------------------------------------------------");

                if(choice==1) {
                    System.out.println("""
                        You take a look at the star chart, for once thankful for the years of study it took for you to get this job.\s
                        On the interactive display, you notice a marked refuelling station about ten degrees to the right of your course.\s
                        You calculate the ETA at 30 minutes given your current speed and remaining fuel volume.""");
                    System.out.println("\nYou figure it's best to return to the bridge to tell the captain about this.");
                    starChart = "acquired";
                    System.out.println("\n1: Go back to the hallway\n");

                    choice = myScanner.nextInt();

                    if (choice==1) {
                        enterHall();
                    } else {
                        System.out.println("\n");
                        storageDock();
                    }
                }
                else {
                    System.out.println("\n");
                    storageDock();
                }
            }
            else {
                /*Something is funky here and making this print out after the endings, I had it fixed before but
                  messed it up again in making more conditional add-ons
                  But I'm getting around it with exit codes aha rip*/
                System.out.println("You continue into the storage dock and see a large fuel tank against the back " +
                        "wall!");
                System.out.println("\nProblem is, the meteor impacts knocked all the storage boxes around, and many " +
                    "of them are now blocking the fuel tank in.");
                System.out.println("They look wedged and heavy. Seems you'd need more hands on deck to get the " +
                    "spare fuel tank out.");
                if (playerType.equals("2")) {
                    System.out.println("Seems there isn't anything else you can do here.");
                } else if (playerType.equals("3")) {
                    spareTankStatus = "found";
                }
                System.out.println("\n1: Go back to the hallway\n");
                choice = myScanner.nextInt();

                if (choice == 1) {
                    enterHall();
                } else {
                    System.out.println("\n");
                    storageDock();
                }
            }
        }
    }

    public void shipBelly(){

        if(workingFuelTank==1 || spareTankStatus.equals("found") || spareTankStatus.equals("acquired") || starChart.equals(
                "acquired")) {
            System.out.println("You continue into the ship's belly, for some reason. There's nothing else you need " +
                    "here.");
            System.out.println("\n1: Return to the hall\n");

            choice = myScanner.nextInt();

            if(choice==1){
                enterHall();
            }
            else {
                shipBelly();
            }
        }
        else {
            System.out.println("You encounter an alien! Seems the captain didn't manage to get rid of all of them. \n");
            System.out.println("1: Fight");
            System.out.println("2: Run \n");

            choice = myScanner.nextInt();

            if(choice==1){
                fight();
            }
            else if(choice==2){
                enterHall();
            }
            else{
                System.out.println("\n");
                shipBelly();
            }


            System.out.println("------------------------------------------------------------------\n");
            System.out.println("You continue into the ship's belly and head right towards the main fuel tank.");
            System.out.println("Immediately, you see what the captain was talking about. \nThe entrance valve is badly " +
                    "damaged; the ship can't use this tank's fuel effectively like this.");

            if (playerType.equals("1")) {
                System.out.println("\n1: Use your skill " + playerSkill + "\n");

                choice = myScanner.nextInt();
                System.out.println("\n------------------------------------------------------------------\n");


                if (choice==1) {
                    System.out.println("You get to work on the engine with your trusty wrench and bag of tools.");
                    System.out.println("After an hour of pouring over the valve, you sit back on your haunches, satisfied. " +
                                "\nEverything looks to be ship shape again.");
                    workingFuelTank = 1;
                    System.out.println("\nYou now have a working fuel tank!");
                    System.out.println("You figure it's best to return to the bridge to tell the captain the good news.");
                    System.out.println("\n1: Go back to the hallway\n");

                    choice = myScanner.nextInt();

                    if (choice==1) {
                        enterHall();
                    } else {
                        System.out.println("\n");
                        shipBelly();
                    }
                }
                else {
                    shipBelly(); //Newline check types 2 3
                }
            }
            else {
                System.out.println("Unfortunately, fixing it is outside of your area of expertise.");
                System.out.println("\n1: Go back to the hallway\n");

                choice = myScanner.nextInt();

                if (choice==1) {
                    enterHall();
                } else {
                    System.out.println("\n");
                    shipBelly();
                }
            }
        }
    }

    public void fight(){
        System.out.println("------------------------------------------------------------------\n");
        System.out.println("Your HP: "+ playerHP);
        System.out.println("Enemy HP: " + enemyHP);
        System.out.println("\n1: Attack");
        System.out.println("2: Run\n");

        choice = myScanner.nextInt();

        if(choice==1){
            attack();
        }
        else if(choice==2){
            enterHall();
        }
        else{
            System.out.println("\n");
            fight();
        }
    }

    public void attack(){

        int playerDamage = 0;

        if(playerWeapon.equals("wrench")){
            playerDamage = new java.util.Random().nextInt(6);
        }
        else if(playerWeapon.equals("extendable telescope")){
            playerDamage = new java.util.Random().nextInt(5);
        }
        else if(playerWeapon.equals("knife")){
            playerDamage = new java.util.Random().nextInt(8);
        }

        System.out.println("\nYou attacked the enemy with your " + playerWeapon + " and dealt " + playerDamage + " " +
                "damage!\n");

        enemyHP = enemyHP - playerDamage;

        System.out.println("Enemy HP: " + enemyHP);

        if(enemyHP<1){
            enemyHP = 15;
            alive();
        }
        else {
            int enemyDamage;

            enemyDamage = new java.util.Random().nextInt(4);

            System.out.println("\nThe enemy attacked you and dealt " + enemyDamage + " damage!\n");

            playerHP = playerHP - enemyDamage;

            System.out.println("Player HP: " + playerHP);
            enterScanner.nextLine();

            if(playerHP<1){
                dead();
            } else {
                fight();
            }
        }
    }

    public void dead(){
        System.out.println("------------------------------------------------------------------\n");
        System.out.println("You died!");
        System.out.println("\nGAME OVER");
        System.out.println("\nLoading revive...");
        enterScanner.nextLine();
        enterHall();
    }

    public void alive() {
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("You killed the alien!");
        System.out.println("Area now clear, you can continue exploring the room.");
        enterScanner.nextLine();
    }

    public void ending1(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Captain: Oh, you managed to get the main fuel tank working? Fantastic job.");
        System.out.println("Captain: Looks like we'll be able to get to Mars alright after all.");
        System.out.println("\n                           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Happy 20th birthday Kieran!");
        System.exit(0);
    }

    public void ending2(){
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Captain: Oh, you managed to get find the spare fuel tank? Great work!");
        System.out.println("Captain: Looks like we'll be able to get to Mars alright after all.");
        System.out.println("\n                           THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Happy 20th birthday Kieran!");
        System.exit(0);
    }

    public void ending3() {
        System.out.println("------------------------------------------------------------------\n");
        System.out.println("A half hour later, the crew are all helping haul the newly bought fuel tank into the" +
                " engine room.");
        System.out.println("\nCaptain: Great job locating that refuel station!");
        System.out.println("I'm glad we had someone around who was able to properly read those interactive star maps.");
        System.out.println("\nCaptain: Looks like we'll be able to get to Mars alright after all.");
        System.out.println("\n                          THE END                    ");
        System.out.println("\n------------------------------------------------------------------\n");
        System.out.println("Happy 20th birthday Kieran!");
        System.exit(0);
    }
}