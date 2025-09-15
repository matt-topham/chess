package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class knight {
    private static final int[][] DIRECTIONS = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    public static Collection<ChessMove> getKnightMoves(ChessBoard board,
                                                     ChessPosition start,
                                                     ChessGame.TeamColor color) {
        Set<ChessMove> moves = pieceMover.getLegalMove(board, start, color, DIRECTIONS, false);
        return moves;
    }
}
