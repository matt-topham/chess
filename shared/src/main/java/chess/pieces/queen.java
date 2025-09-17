package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class queen {
    //the eight directions the queen can move
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
    };

    public static Collection<ChessMove> getQueenMoves(ChessBoard board,
                                                       ChessPosition start,
                                                       ChessGame.TeamColor color) {
        // using the helper function to now move the queen
        Set<ChessMove> moves = pieceMover.getLegalMove(board, start, color, DIRECTIONS, true);
        return moves;
    }
}
