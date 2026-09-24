package chess;

import java.util.Collection;

public interface PieceMovesCalculator {

    Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition, int[][] offsets);
}
