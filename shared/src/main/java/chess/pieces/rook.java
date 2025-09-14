package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class rook {
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static Collection<ChessMove> getRookMoves(ChessBoard board,
                                                      ChessPosition start,
                                                      ChessGame.TeamColor color) {
        // sliding piece → pass true
        Set<ChessMove> moves = pieceMover.getLegalMove(board, start, color, DIRECTIONS, true);
        return moves; // or return as Set<ChessMove> if you prefer
    }
}
