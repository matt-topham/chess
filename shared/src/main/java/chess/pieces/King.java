package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class King {
    // the eight directions the king can move
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
    };

    public static Collection<ChessMove> getKingMoves(ChessBoard board,
                                                      ChessPosition start,
                                                      ChessGame.TeamColor color) {
        // using the helper function, isMoving is false because he gets one move
        Set<ChessMove> moves = PieceMover.getLegalMove(board, start, color, DIRECTIONS, false);
        return moves;
    }
}
