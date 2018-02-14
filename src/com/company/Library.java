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
        Menu menu = new Menu();
        menu.startMenu();
    }

    protected void removeGame(int gameIndex) {
        //Code to remove game goes here

        gameIndex -= gameIndex;
        gameLibrary.remove(gameIndex);
        System.out.println("You have removed a game from your library. ");
        menu.startMenu();
    }

    protected void checkOutGames(int gameIndex) {
        //code for checkedOutGames goes here

        gameIndex -= gameIndex;
        Game game = gameLibrary.get(gameIndex);
        checkedOutGames.add(game);
        Calendar calendar = Calendar.getInstance();

        System.out.println("You checked out this game" + dateFormat.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR, 3);

        System.out.println("it is due back on : " + dateFormat.format(calendar.getTime()));

        game.setDueDate(dateFormat.format(calendar.getTime()));

    }

    protected void checkInGames(int gameIndex) {

        //code for

        for (Game game :checkedOutGames) {
            System.out.println(game.getTitle());
        }

    }

    protected void listGames() {

        // Create a foreach loop to iterate through the list of games in the library.  Display those items to the user

        for (Game game : gameLibrary) {
            System.out.println(game.getTitle());
        }
        //Go back to the menu
        menu.startMenu();
    }

}
