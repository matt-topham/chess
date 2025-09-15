package chess.pieces;

import chess.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Collection;

public class pawn {

    public static Collection<ChessMove> getPawnMoves(ChessBoard board,
                                                     ChessPosition start,
                                                     ChessGame.TeamColor color) {
        Set<ChessMove> moves = new HashSet<>();

        int r = start.getRow();
        int c = start.getColumn();

        int dir = (color == ChessGame.TeamColor.WHITE) ? 1 : -1;
        int startRank = (color == ChessGame.TeamColor.WHITE) ? 2 : 7;
        int promoRank = (color == ChessGame.TeamColor.WHITE) ? 8 : 1;

        ChessPosition one = pos(r + dir, c);
        if (inBounds(one) && board.getPiece(one) == null) {
            addMoveOrPromotion(moves, start, one, promoRank);

            if (r == startRank) {
                ChessPosition two = pos(r + 2 * dir, c);
                if (inBounds(two) && board.getPiece(two) == null) {
                    moves.add(new ChessMove(start, two, null));
                }
            }
        }

        for (int dc : new int[]{-1, 1}) {
            ChessPosition diag = pos(r + dir, c + dc);
            if (!inBounds(diag)) continue;
            ChessPiece target = board.getPiece(diag);
            if (target != null && target.getTeamColor() != color) {
                addMoveOrPromotion(moves, start, diag, promoRank);
            }
        }

        return moves;
    }

    // --- helpers ---
    private static ChessPosition pos(int row, int col) {
        return new ChessPosition(row, col);
    }

    private static boolean inBounds(ChessPosition p) {
        int row = p.getRow(), col = p.getColumn();
        return row >= 1 && row <= 8 && col >= 1 && col <= 8;
    }

    private static void addMoveOrPromotion(Set<ChessMove> moves,
                                           ChessPosition from,
                                           ChessPosition to,
                                           int promoRank) {
        if (to.getRow() == promoRank) {
            moves.add(new ChessMove(from, to, ChessPiece.PieceType.QUEEN));
            moves.add(new ChessMove(from, to, ChessPiece.PieceType.ROOK));
            moves.add(new ChessMove(from, to, ChessPiece.PieceType.BISHOP));
            moves.add(new ChessMove(from, to, ChessPiece.PieceType.KNIGHT));
        } else {
            moves.add(new ChessMove(from, to, null));
        }
    }

}
