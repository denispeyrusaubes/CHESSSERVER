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

/*
 * Authors:
 * Mateusz Sławomir Lach ( matlak, msl )
 * Damian Marciniak
 */
package jchess.core.players.implementation;

import jchess.JChessApp;
import jchess.core.Chessboard;
import jchess.core.Colors;
import jchess.core.pieces.Piece;
import jchess.core.pieces.PieceFactory;
import jchess.core.pieces.implementation.Bishop;
import jchess.core.pieces.implementation.Knight;
import jchess.core.pieces.implementation.Queen;
import jchess.core.pieces.implementation.Rook;
import jchess.core.players.Player;
import jchess.core.players.PlayerType;


/**
 * Class representing the player in the game
 */
public class ComputerPlayer implements Player
{

    protected String name;

    protected Colors color;

    protected PlayerType playerType;
    
    protected boolean goDown;

    /**
     * Default constructor.
     */
    public ComputerPlayer()
    {
        this.playerType = PlayerType.computer;
    }

    /**
     * Constructor for Player class
     * @param name
     * @param color 
     */
    public ComputerPlayer(String name, String color)
    {
        this(name, Colors.valueOf(color.toUpperCase()));
    }
    
        /**
     * Constructor for Player class
     * @param name
     * @param color 
     */
    public ComputerPlayer(String name, Colors color)
    {
        this();
        this.name = name;
        this.color = color;
        this.goDown = false;
    }

    /** Method setting the players name
     *  @param name name of player
     */
    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    /** Method getting the players name
     *  @return name of player
     */
    @Override
    public String getName()
    {
        return this.name;
    }

    /** Method setting the players type
     *  @param type type of player - enumerate
     */
    @Override
    public void setType(PlayerType type)
    {
        this.playerType = type;
    }

    /**
     * @return the color
     */
    @Override
    public Colors getColor()
    {
        return color;
    }

    /**
     * @return the playerType
     */
    @Override
    public PlayerType getPlayerType()
    {
        return playerType;
    }

    /**
     * @return the goDown
     */
    @Override
    public boolean isGoDown()
    {
        return goDown;
    }    
    
    @Override
    public void setGoDown(boolean goDown)
    {
        this.goDown = goDown;
    }

    @Override
    public Piece getPromotionPiece(Chessboard chessboard) {
        return null;
    }

}
