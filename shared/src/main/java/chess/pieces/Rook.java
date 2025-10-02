package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class Rook {
    //the four directions that a rook can move
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static Collection<ChessMove> getRookMoves(ChessBoard board,
                                                      ChessPosition start,
                                                      ChessGame.TeamColor color) {
        //use the helper function pieceMover.getLegalMove to help here
        Set<ChessMove> moves = PieceMover.getLegalMove(board, start, color, DIRECTIONS, true);
        return moves;
    }
}
