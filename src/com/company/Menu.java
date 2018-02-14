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
                "5. check a game in \n" +
                "6. View checked out games \n" +
                "7. Exit the program");
        try {

            switch (input.nextInt()) {
                case 1:
                    System.out.println("You have chosen to add a new game to your library." +
                            "what is the name of the game?");
                    input.nextLine();
                    Game game = new Game(input.nextLine());
                    System.out.println("You have added:" + game.getTitle() + " " + "to your library.");
                    library.addGame(game);

                    //Add game
                    break;
                case 2:
                    System.out.println("You have chosen to remove a game from the library" +
                            "please chose from one of the following by number.");
                    library.removeGame(input.nextInt());
                    System.out.println();
                    //Remove game
                    break;
                case 3:
                    library.listGames();
                    //View Library
                    break;
                case 4:
                    //Check out game
                    break;
                case 5:
                    //Check in game
                    break;
                case 6:
                    //View checked out games
                    break;
                case 7:
                    //Exit game
                    break;
                default:
                    //Prompt user to pick correct number, loop back to menu.
                    break;
            }
        }catch (InputMismatchException ime){
            input.nextLine();
            System.out.println("Select a number from 1 - 7");
            startMenu();
        }
    }
}
