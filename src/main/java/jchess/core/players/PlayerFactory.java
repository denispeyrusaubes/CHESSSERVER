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
package jchess.core.players;

import jchess.core.Colors;
import jchess.core.players.implementation.ComputerPlayer;
import jchess.core.players.implementation.HumanPlayer;
import jchess.core.players.implementation.NetworkPlayer;

/**
 *
 * @author Mateusz Sławomir Lach (matlak, msl)
 */
public class PlayerFactory
{
  public static Player getInstance(String name, Colors color, PlayerType playerType)
  {
    Player player = null;
    if (PlayerType.localUser == playerType)
    {
      player = new HumanPlayer(name, color);
    }
    else if (PlayerType.networkUser == playerType)
    {
      player = new NetworkPlayer(name, color);
    }
    else if (PlayerType.computer == playerType)
    {
      player = new ComputerPlayer(name, color);
      player.setName("CPU");
    }
    else
    {
      player = new HumanPlayer(name, color);
    }
    return player;
  }
  
  public static Player getInstance(String name, String color, PlayerType playerType)
  {
    return getInstance(name, Colors.valueOf(color.toUpperCase()), playerType);
  }
}
