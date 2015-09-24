/*
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package jchess.core.players.implementation;

import jchess.JChessApp;
import jchess.core.Chessboard;
import jchess.core.Colors;
import jchess.core.pieces.Piece;
import jchess.core.pieces.PieceFactory;
import jchess.core.players.PlayerType;


/**
 * Class representing the player in the game
 * @author Mateusz Sławomir Lach (matlak, msl)
 */
public class HumanPlayer extends ComputerPlayer
{

    /**
     * Default constructor.
     */
    public HumanPlayer()
    {
        this.playerType = PlayerType.localUser;
    }

    /**
     * Constructor for Player class
     * @param name
     * @param color 
     */
    public HumanPlayer(String name, String color)
    {
        super(name, Colors.valueOf(color.toUpperCase()));
        this.playerType = PlayerType.localUser;
    }
    
    /**
     * Constructor for Player class
     * @param name
     * @param color 
     */
    public HumanPlayer(String name, Colors color)
    {
        super(name, color);
        this.playerType = PlayerType.localUser;
    }
  
    @Override
    public Piece getPromotionPiece(Chessboard chessboard) {
        String colorSymbol = color.getSymbolAsString().toUpperCase();
        String newPiece = JChessApp.getJavaChessView().showPawnPromotionBox(colorSymbol); //return name of new piece
        return PieceFactory.getPiece(chessboard, colorSymbol, newPiece, this);
    }

}
