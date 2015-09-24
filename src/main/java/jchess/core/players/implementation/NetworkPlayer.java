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

/**
 * @author Mateusz Sławomir Lach (matlak, msl)
 */
package jchess.core.players.implementation;

import jchess.core.Chessboard;
import jchess.core.Colors;
import jchess.core.pieces.Piece;
import jchess.core.players.PlayerType;

/**
 * Class representing the player in the game
 */
public class NetworkPlayer extends ComputerPlayer
{

    /**
     * Default constructor.
     */
    public NetworkPlayer()
    {
        this.playerType = PlayerType.networkUser;
    }

    /**
     * Constructor for Player class
     * @param name
     * @param color 
     */
    public NetworkPlayer(String name, String color)
    {
        super(name, color);
        this.playerType = PlayerType.networkUser;
    }
    
        /**
     * Constructor for Player class
     * @param name
     * @param color 
     */
    public NetworkPlayer(String name, Colors color)
    {
        super(name, color);
        this.playerType = PlayerType.networkUser;
    }

  
    @Override
    public Piece getPromotionPiece(Chessboard chessboard) {
        return null;
    }

}
