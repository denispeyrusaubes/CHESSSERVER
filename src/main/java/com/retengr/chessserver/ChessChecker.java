/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.retengr.chessserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import jchess.core.Game;
import jchess.core.Square;
import jchess.core.players.Player;
import jchess.core.players.implementation.HumanPlayer;

@Path("/chesschecker")
public class ChessChecker {

    @GET
    public String possibleMoves(@QueryParam("moves") String moves,
            @QueryParam("active") String active) {
        String result = null;
        if (moves==null) moves="";
        Game newGUI = new Game();
        // Il faut initialiser les pieces sur le chessboard !
        Player p1 = new HumanPlayer("p1", "white");
        Player p2 = new HumanPlayer("p2", "black");

        newGUI.getChessboard().setPieces("", p1, p2);
        
        System.out.println("input:"+moves);
        //moves = "";
        newGUI.getMoves().setMoves(moves);

        int x = convert(active.charAt(0));
        int y = 8 - Integer.parseInt(active.substring(1));
        
        
        Square myActiveSquare = newGUI.getChessboard().getSquares()[x][y];
        
        System.out.println("coucou"+myActiveSquare.getPiece());
        Set<Square> possibleMovesTmp = myActiveSquare.getPiece().getAllMoves();
        System.out.println("kfds");
        List<Square> possibleMoves = new ArrayList<Square>();
        System.out.println("aa");
        possibleMoves.addAll(possibleMovesTmp);

        result = "{\"possibleMoves\":[";
        if (!possibleMoves.isEmpty()) {
            Square first = possibleMoves.get(0);
            String position = "\""+getLetter(first.getPozX()) + "" + (8 - first.getPozY())+"\"";
            result += position;
            if (possibleMoves.size() > 1) {
                for (int i = 1; i < possibleMoves.size(); i++) {
                    Square s = possibleMoves.get(i);
                    position = ",\"" + getLetter(s.getPozX()) + "" + (8 - s.getPozY())+"\"";
                    result += position;
                }
            }
        }

        result = result+"]}";

        return result;
    }

    private String getLetter(int x) {
        String result = "a";
        switch (x) {
            case 0:
                result = "a";
                break;
            case 1:
                result = "b";
                break;
            case 2:
                result = "c";
                break;
            case 3:
                result = "d";
                break;
            case 4:
                result = "e";
                break;
            case 5:
                result = "f";
                break;
            case 6:
                result = "g";
                break;
            case 7:
                result = "h";
                break;

        }
        return result;
    }

    private int convert(char c) {
        int result = 0;
        switch (c) {
            case 'a':
                result = 0;
                break;
            case 'b':
                result = 1;
                break;
            case 'c':
                result = 2;
                break;
            case 'd':
                result = 3;
                break;
            case 'e':
                result = 4;
                break;
            case 'f':
                result = 5;
                break;
            case 'g':
                result = 6;
                break;
            case 'h':
                result = 7;
                break;

        }
        return result;
    }
}
