package chess;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private final ChessGame.TeamColor myTeam;
    private final ChessPiece.PieceType myType;
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        myTeam = pieceColor;
        myType = type;
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
        return myTeam;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return myType;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPiece.PieceType typeOfPiece = board.getPiece(myPosition).getPieceType();
        switch (typeOfPiece){ //I'll finish this later.
            case ROOK:

            case QUEEN:

            case BISHOP:

            case KING:

            case KNIGHT:

            case PAWN:

            case null, default:
                return List.of();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return myTeam == that.myTeam && myType == that.myType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myTeam, myType);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "myTeam=" + myTeam +
                ", myType=" + myType +
                '}';
    }
}
