package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class knight {
    // the eight different jumps the knight can make
    private static final int[][] DIRECTIONS = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public static Collection<ChessMove> getKnightMoves(ChessBoard board,
                                                     ChessPosition start,
                                                     ChessGame.TeamColor color) {
        // using the helper function to move the knight. isMoving is false because he gets one move
        Set<ChessMove> moves = pieceMover.getLegalMove(board, start, color, DIRECTIONS, false);
        return moves;
    }
}
