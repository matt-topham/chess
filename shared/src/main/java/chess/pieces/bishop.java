package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class bishop {
    // the four diagonal directions the bishop can move
    private static final int[][] DIAGONALS = {
            {-1,  1}, {-1, -1}, { 1,  1}, { 1, -1}};
    //using the helper function to move the bishop
    public static Collection<ChessMove> getBishopMoves(ChessBoard board, ChessPosition start, ChessGame.TeamColor color) {
        Set<ChessMove> moves = pieceMover.getLegalMove(board, start, color, DIAGONALS, true);
        return moves;
    }
}
