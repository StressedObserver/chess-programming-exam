package chess;

import java.util.Collection;
import java.util.List;

public class SlidingMovesCalculator implements PieceMovesCalculator{

    @Override
    public Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition, int[][] offsets) {
        ChessPiece myPiece = board.getPiece(myPosition);
        Collection<ChessMove> legalMoves = List.of(); //Change this later when function is fully implemented.
        for(int[] offset : offsets){
            int rowOffset = offset[0];
            int colOffset = offset[1];
            ChessPosition potentialPos = new ChessPosition(myPosition.getRow() + rowOffset, myPosition.getColumn() + colOffset );
            while(potentialPos.isInBounds()){
                if(board.getPiece(potentialPos) == null){ //If the vision space is clear
                    legalMoves.add(new ChessMove(myPosition, potentialPos, null));
                } else if(board.getPiece(potentialPos) != null && board.getPiece(potentialPos).getTeamColor() != myPiece.getTeamColor()){
                    //If the vision space is not clear BUT we can capture it.
                    legalMoves.add(new ChessMove(myPosition, potentialPos, null));
                    break;
                } else{
                    break; //Our vision is being "blocked" by our own pieces.
                }
                rowOffset += offset[0];
                colOffset += offset[1];
                potentialPos = new ChessPosition(myPosition.getRow() + rowOffset,myPosition.getColumn() + colOffset);
            }
        }
        return legalMoves;
    }
}
