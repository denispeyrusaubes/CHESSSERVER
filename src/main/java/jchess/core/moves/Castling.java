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
package jchess.core.moves;

/**
 * @author Mateusz Sławomir Lach (matlak, msl)
 */
public enum Castling
{
    NONE(""), 
    SHORT_CASTLING("0-0"), 
    LONG_CASTLING("0-0-0");
    
    protected String symbol;
    
    Castling(String symbol)
    {
        this.symbol = symbol;
    }
    
    public String getSymbol()
    {
        return symbol;
    }
    
    public static boolean isCastling(String moveInPGN)
    {
        return moveInPGN.equals(Castling.SHORT_CASTLING.getSymbol()) 
                || moveInPGN.equals(Castling.LONG_CASTLING.getSymbol());
    }
}
