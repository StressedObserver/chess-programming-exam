package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HoppingMovesCalculator implements PieceMovesCalculator{

    @Override
    public Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition, int[][] offsets) {
        ChessPiece myPiece = board.getPiece(myPosition);
        Collection<ChessMove> legalMoves = new ArrayList<>(); //Change this later when function is fully implemented.
        for(int[] offset : offsets){
            int rowOffset = offset[0];
            int colOffset = offset[1];
            ChessPosition potentialPos = new ChessPosition(myPosition.getRow() + rowOffset, myPosition.getColumn() + colOffset );
            if(potentialPos.isInBounds()){
                if(board.getPiece(potentialPos) == null){ //If the vision space is clear
                    legalMoves.add(new ChessMove(myPosition, potentialPos, null));
                } else if(board.getPiece(potentialPos) != null && board.getPiece(potentialPos).getTeamColor() != myPiece.getTeamColor()){
                    //If the vision space is not clear BUT we can capture it.
                    legalMoves.add(new ChessMove(myPosition, potentialPos, null));
                }
            }
        }
        return legalMoves;
    }
}
