package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {

    private TeamColor teamTurn;
    private ChessBoard board;
    private boolean gameOver;


    public ChessGame() {
        this.board = new ChessBoard();
        this.board.resetBoard();
        this.teamTurn = TeamColor.WHITE;
        this.gameOver = false;

    }

    /**
     * @return Which team's turn it is
     */
    public TeamColor getTeamTurn() {
        return teamTurn;
    }

    /**
     * Set's which teams turn it is
     *
     * @param team the team whose turn it is
     */
    public void setTeamTurn(TeamColor team) {
        this.teamTurn = team;
    }

    /**
     * Enum identifying the 2 possible teams in a chess game
     */
    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets a valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessPiece piece = board.getPiece(startPosition);
        if (piece == null) {
            return null;
        }
        Collection<ChessMove> potential = piece.pieceMoves(board, startPosition);
        List<ChessMove> legal_moves = new ArrayList<>();
        if (potential == null) {
            return legal_moves;
        }
        for (ChessMove move: potential) {
            if (safeMove(startPosition, piece, move)) {
                legal_moves.add(move);
            }
        }
        return legal_moves;
    }

    /**
     * Makes a move in a chess game
     *
     * @param move chess move to perform
     * @throws InvalidMoveException if move is invalid
     */
    public void makeMove(ChessMove move) throws InvalidMoveException {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Determines if the given team is in check
     *
     * @param teamColor which team to check for check
     * @return True if the specified team is in check
     */
    public boolean isInCheck(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    /**
     * Determines if the given team is in checkmate
     *
     * @param teamColor which team to check for checkmate
     * @return True if the specified team is in checkmate
     */
    public boolean isInCheckmate(TeamColor teamColor) {
        return isInCheck(teamColor) && !anyLegalMove(teamColor);
    }

    /**
     * Determines if the given team is in stalemate, which here is defined as having
     * no valid moves while not in check.
     *
     * @param teamColor which team to check for stalemate
     * @return True if the specified team is in stalemate, otherwise false
     */
    public boolean isInStalemate(TeamColor teamColor) {
        return !isInCheck(teamColor) && !anyLegalMove(teamColor);
    }

    /**
     * Sets this game's chessboard with a given board
     *
     * @param board the new board to use
     */
    public void setBoard(ChessBoard board) {
        this.board = board;
    }

    /**
     * Gets the current chessboard
     *
     * @return the chessboard
     */
    public ChessBoard getBoard() {
        return board;
    }

    private TeamColor opponent(TeamColor color) {
        if (color == TeamColor.WHITE) {
            return TeamColor.BLACK;
        }
        else {
            return TeamColor.WHITE;
        }
    }

    private ChessBoard copyBoard() {
        ChessBoard copy = new ChessBoard();
        for (int r = 1; r <= 8; r++) {
            for (int c = 1; c <= 8; c++) {
                ChessPosition p = new ChessPosition(r, c);
                ChessPiece piece = board.getPiece(p);
                if (piece != null) {
                    copy.addPiece(p, new ChessPiece(piece.getTeamColor(), piece.getPieceType()));
                }
                else {
                    copy.addPiece(p, null);
                }
            }
        }
        return copy;
    }

    private boolean anyLegalMove(TeamColor color) {
        for (int r = 1; r <= 8; r++) {
            for (int c = 1; c <= 8; c++) {
                ChessPosition p = new ChessPosition(r, c);
                ChessPiece piece = board.getPiece(p);
                if (piece == null || piece.getTeamColor() != color) {
                    continue;
                }
                Collection<ChessMove> legalMove = validMoves(p);
                if (legalMove != null && !legalMove.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean safeMove(ChessPosition from, ChessPiece mover, ChessMove move) {
        ChessBoard board = copyBoard();

        ChessPiece.PieceType type = move.getPromotionPiece();

        if (type != null) {
            move.getPromotionPiece();
        }
        else {
            mover.getPieceType();
        }

        board.addPiece(from, null);
        board.addPiece(move.getEndPosition(), new ChessPiece(mover.getTeamColor(), type));

        ChessGame test = new ChessGame();
        test.setBoard(board);
        return !test.isInCheck(mover.getTeamColor());
    }
}
