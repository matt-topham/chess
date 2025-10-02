package chess;

import java.util.Collection;
import java.util.Collections;

import chess.pieces.*;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return  pieceColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType(){
        return type;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChessPiece other)) {
            return false;
        }
        return pieceColor == other.pieceColor && type == other.type;
    }

    @Override
    public int hashCode() {
        int h = 17;
        h = 31 * h + pieceColor.hashCode();
        h = 31 * h + type.hashCode();
        return h;
    }


    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPiece piece = board.getPiece(myPosition);
        if (piece.getPieceType() == PieceType.BISHOP) {
            return Bishop.getBishopMoves(board, myPosition, pieceColor);
        }
        else if (piece.getPieceType() == PieceType.QUEEN) {
            return Queen.getQueenMoves(board, myPosition, pieceColor);
        }
        else if (piece.getPieceType() == PieceType.KING) {
            return King.getKingMoves(board, myPosition, pieceColor);
        }
        else if (piece.getPieceType() == PieceType.ROOK) {
            return Rook.getRookMoves(board, myPosition, pieceColor);
        }
        else if (piece.getPieceType() == PieceType.KNIGHT) {
            return Knight.getKnightMoves(board, myPosition, pieceColor);
        }
        else if (piece.getPieceType() == PieceType.PAWN) {
            return Pawn.getPawnMoves(board, myPosition, pieceColor);
        }
        return Collections.emptyList();
    }
}
