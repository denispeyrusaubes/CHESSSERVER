# Based upon http://sourceforge.net/projects/javaopenchess/

This webapp wraps the chess application as a rest webservice in order to return  possibles moves for a piece, in a specific board configuration (ie, at any moment of a game).

To deploy: 

```mvn install tomee:run```

The REST API is basic: a simple GET request, with two parameters:
Moves: contains the moves history, the server reruns this history in order the board to be in your correct configuration
Active: the position of the piece you want retrieve possibles moves 

```http://YOUSERVER/ChessServer-1.0-SNAPSHOT/chesschecker?moves=XXXXXXXctive=YY
Values example: 
moves = 1. c2-c4 e7-e6 2. b2-b3 Qd8-h4 3. Bc1-a3 Bf8-d6 4. g2-g3 a7-a5 5. g3xh4 c7-c5 6. Ng1-f3 Ng8-h6
active = f3
```
correct url:

```http://YOUSERVER/ChessServer-1.0-SNAPSHOT/chesschecker?moves=1.%20c2-c4%20e7-e6%202.%20b2-b3%20Qd8-h4%203.%20Bc1-a3%20Bf8-d6%204.%20g2-g3%20a7-a5%205.%20g3xh4%20c7-c5%206.%20Ng1-f3%20Ng8-h6%20&active=f3 ```

returns: ```{possibleMoves:[g5,g1,d4,e5]}```


FYI: moves format corresponds to a standard chess notation I don't remember the name... javaopenchess export a game respecting that format. You may espace the moves values because of spaces

