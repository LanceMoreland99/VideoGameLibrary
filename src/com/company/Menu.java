package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);
    private Library library = new Library(this);

    //User to prompt user library options

    public void startMenu(){

        System.out.println("Welcome to the video game library, what would you like to do? \n" +
                "1. add game to the library \n" +
                "2. Remove a game from the library \n" +
                "3. View what is currently in the Library \n" +
                "4. Check a game out \n" +
                "5. Check a game in \n" +
                "6. View checked out games \n" +
                "7. Exit the program");
        try {

            switch (input.nextInt()) {
                case 1:
                    System.out.println("You have chosen to add a new game to your library. " +
                            "what is the name of the game?");
                    input.nextLine();
                    Game game = new Game(input.nextLine());
                    System.out.println("You have added: " + game.getTitle() + " " + "to your library.");
                    library.addGame(game);
                    //Add game
                    break;
                case 2:
                    //Remove game from library
                    library.listGames();
                    System.out.println("What game would you like to remove?");
                    input.nextLine();
                    library.removeGame(input.nextInt());
                    startMenu();

                    break;
                case 3:
                    //View Library
                    library.listGames();
                    startMenu();
                    break;
                case 4:
                    //Check out game
                    library.listGames();
                    System.out.println("What game would you like to check out?");
                    library.checkedOutGames(input.nextInt());
                    startMenu();
                    break;

                case 5:
                    //Check in game
                    input.nextLine();
                    System.out.println("What game would you like to check back in?");
                    library.listCheckedOut(5);
                    library.checkedInGames(input.nextInt());
                    startMenu();
                    break;

                case 6:
                    //View checked out games
                    library.listCheckedOut(6);
                    break;

                case 7:
                    //Exit game
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;

                default:
                    //Prompt user to pick correct number, loop back to menu.
                    break;

            }
        }catch (InputMismatchException ime){
            input.nextLine();
            System.out.println("Select a number from 1 - 7");
            System.out.println("\n");
            startMenu();
        }
    }
}
