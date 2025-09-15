package chess.pieces;

import chess.*;
import java.util.Collection;
import java.util.Set;

public class queen {
    private static final int[][] DIRECTIONS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
    };

    public static Collection<ChessMove> getQueenMoves(ChessBoard board,
                                                       ChessPosition start,
                                                       ChessGame.TeamColor color) {

        Set<ChessMove> moves = pieceMover.getLegalMove(board, start, color, DIRECTIONS, true);
        return moves;
    }
}
