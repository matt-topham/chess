package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class bishop {
    private static final int[][] DIAGONALS = {
            {-1,  1}, // NE
            {-1, -1}, // NW
            { 1,  1}, // SE
            { 1, -1}  // SW
    };

    public static Collection<ChessMove> getBishopMoves(ChessBoard board, ChessPosition start, ChessGame.TeamColor color) {
        // sliding piece → pass true
        Set<ChessMove> moves = pieceMover.getLegalMove(board, start, color, DIAGONALS, true);
        return moves; // or return as Set<ChessMove> if you prefer
    }
}
