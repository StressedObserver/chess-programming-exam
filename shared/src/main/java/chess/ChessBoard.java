package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    ChessPiece[][] chessSquares = new ChessPiece[8][8];
    public ChessBoard() {
        
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        chessSquares[position.getRow() - 1][position.getColumn() - 1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return chessSquares[position.getRow() - 1][position.getColumn() - 1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        //Oh boy. Here we go.
        chessSquares[0] = new ChessPiece[]{new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK),new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK) };
        chessSquares[1] = new ChessPiece[]{new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN),new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN) };
        chessSquares[6] = new ChessPiece[]{new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN),new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN) };
        chessSquares[7] = new ChessPiece[]{new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK),new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK) };
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(chessSquares, that.chessSquares);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(chessSquares);
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "chessSquares=" + Arrays.toString(chessSquares) +
                '}';
    }
}
