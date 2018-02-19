package com.company;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Library {


    public final Menu menu;
    private List<Game> gameLibrary = new ArrayList<Game>();
    private List<Game> checkedOutGames = new ArrayList<Game>();
    private List<Game> checkedInGames = new ArrayList<Game>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat( "MM/dd/yy, HH:mm:ss");


    public Library (Menu menu) {
        this.menu = menu;
    }

    protected void addGame(Game game) {
        //Code goes here to add game where ever we are saving game things to

        gameLibrary.add(game);
        menu.startMenu();
    }

    protected void removeGame(int gameIndex) {
        //Code to remove game goes here
        gameIndex -= gameIndex;
        gameLibrary.remove(gameIndex);
        System.out.println("You have removed a game from your library. ");

        menu.startMenu();
    }

    protected void checkedOutGames(int gameIndex) {
        //code for checkedOutGames goes here

        gameIndex -= gameIndex;
        Game game = gameLibrary.get(gameIndex);
        checkedOutGames.add(game);
        gameLibrary.remove(game);
        Calendar calendar = Calendar.getInstance();
        System.out.println("You checked out this game" + dateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        System.out.println("it is due back on : " + dateFormat.format(calendar.getTime()));
        game.setDueDate(dateFormat.format(calendar.getTime()));

    }

    protected void checkedInGames(int gameIndex) {

        //code for
        gameIndex -= gameIndex;
        Game game = checkedOutGames.get(gameIndex);
        if (checkedOutGames.isEmpty()) {
            System.out.println("Your currently have no games to check in.");
        }
        else {
            checkedOutGames.remove(game);
            gameLibrary.add(game);

        }
        System.out.println("what game would you like to check in?");
        System.out.println("\n");

    }

    protected void listGames() {

        // Create a foreach loop to iterate through the list of games in the library.  Display those items to the user

        if (gameLibrary.isEmpty()) {
            System.out.println("You currently don't have any games.");
        }
          else {
            System.out.println("This is the current games in your library");
            int index = 1;

            for (Game game : gameLibrary) {

                System.out.println(index++ + " " + game.getTitle());
            }
        }
        System.out.println("\n");
        //Go back to the menu
    }

    protected void listCheckedOut(int location) {

        System.out.println("This is your current checked out games.");
        if (checkedOutGames.isEmpty()){
            System.out.println("Your checkout list is empty");

            }
            else {
            int index = 1;

            for (Game game : checkedOutGames) {
                System.out.println(index++ + " " + game.getTitle());
                }

            }

        //Go back to menu
        if (location == 6) {
            menu.startMenu();
        }
    }
}
