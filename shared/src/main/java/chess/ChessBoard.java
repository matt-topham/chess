package chess;

import java.util.Arrays;
import java.util.Objects;

public class ChessBoard {

    // creates new 8 by 8 array
    ChessPiece[][] squares = new ChessPiece[8][8];

    public ChessBoard() { }

    // adds piece to the board in the correct position
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow()-1][position.getColumn()-1] = piece;
    }

    // returns what piece in a location
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()-1][position.getColumn()-1];
    }

    // reset the board
    public void resetBoard() {

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                squares[r][c] = null;
            }
        }

        // how the back row is organized
        ChessPiece.PieceType[] order = {
                ChessPiece.PieceType.ROOK,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.QUEEN,
                ChessPiece.PieceType.KING,
                ChessPiece.PieceType.BISHOP,
                ChessPiece.PieceType.KNIGHT,
                ChessPiece.PieceType.ROOK
        };

        // for the white rows, row 1 is the array above followed by rows of pawns
        for (int col = 1; col <= 8; col++) {
            addPiece(new ChessPosition(1, col),
                    new ChessPiece(ChessGame.TeamColor.WHITE, order[col - 1]));
            addPiece(new ChessPosition(2, col),
                    new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        }
        // similar to above but at the top for black
        for (int col = 1; col <= 8; col++) {
            addPiece(new ChessPosition(8, col),
                    new ChessPiece(ChessGame.TeamColor.BLACK, order[col - 1]));
            addPiece(new ChessPosition(7, col),
                    new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
        }
    }

    // override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessBoard other)) return false;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                ChessPiece a = this.squares[r][c];
                ChessPiece b = other.squares[r][c];

                if (a == b) continue;
                if (a == null || b == null) return false;

                if (a.getTeamColor() != b.getTeamColor()
                        || a.getPieceType() != b.getPieceType()) {
                    return false;
                }
            }
        }
        return true;
    }

    // override hashcode
    @Override
    public int hashCode() {
        int h = 1;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                ChessPiece p = squares[r][c];
                int cell = 0;
                if (p != null) {
                    cell = 31 * p.getTeamColor().hashCode() + p.getPieceType().hashCode();
                }
                h = 31 * h + cell;
            }
        }
        return h;
    }

}
