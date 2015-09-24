/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retengr.chessserver;

import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import jchess.core.Game;
import jchess.core.Square;
import jchess.core.players.Player;
import jchess.core.players.implementation.HumanPlayer;

@Path("/greeting")
public class GreetingService {

    @GET
    public String message() {

        Game newGUI = new Game();
        // Il faut initialiser les pieces sur le chessboard !
        Player p1 = new HumanPlayer("Denis", "white");
        Player p2 = new HumanPlayer("Delphine", "black");

        newGUI.getChessboard().setPieces("", p1, p2);

        Square myActiveSquare = newGUI.getChessboard().getSquares()[2][6];
        Set<Square> possibleMoves = myActiveSquare.getPiece().getAllMoves();

        for (Square s : possibleMoves) {
            System.out.println(s.getPozX() + "-" + s.getPozY());
        }

        return "Hi REST!";
    }

    @POST
    public String lowerCase(final String message) {
        return "Hi REST!".toLowerCase();
    }
}
