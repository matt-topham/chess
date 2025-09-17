package chess.pieces;

import chess.*;

import java.util.HashSet;
import java.util.Set;

public class pieceMover {
    public static Set<ChessMove> getLegalMove(ChessBoard board,
                                                     ChessPosition start,
                                                     ChessGame.TeamColor color,
                                                     int[][] dir,
                                                     boolean isMoving) {
        Set<ChessMove> moves = new HashSet<>(); // result will be a hash set

        //for loop that will iterate to make the moves for the pieces
        for (int[] vector : dir) {

            // takes in directions from the indv pieces for possible moves
            int nextRow = start.getRow() + vector[0];
            int nextCol = start.getColumn() + vector[1];

            // while loop for when it is still on the board, if it is a single move piece it breaks
            while(isInside(nextRow, nextCol)) {
                // set target and occupant
                ChessPosition target = new ChessPosition(nextRow, nextCol);
                ChessPiece occupant = board.getPiece(target);

                // if nothing it there, you can move there
                if (occupant == null) {
                    moves.add(new ChessMove(start, target, null));
                }
                // if something is there check the color, if your color stop, if not, capture
                else {
                    if (occupant.getTeamColor() != color) {
                        moves.add(new ChessMove(start, target, null));
                    }
                    break;
                }
                // how it knows if its a single move or a slider
                if (!isMoving) {
                    break; //king, knight, pawn move once
                }

                // check the next move as well
                nextRow += vector[0];
                nextCol += vector[1];

            }
        }
        return moves;
    }

    // Helper function to check if it is still on the board
    public static boolean isInside(int row, int col) {
        return row >= 1 && row <= 8 && col >= 1 && col <= 8;
    }
}
