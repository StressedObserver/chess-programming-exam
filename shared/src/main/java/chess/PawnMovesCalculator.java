package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PawnMovesCalculator implements PieceMovesCalculator{

    @Override
    public Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition, int[][] offsets) {
        ChessPiece myPiece = board.getPiece(myPosition);
        ChessGame.TeamColor myColor = myPiece.getTeamColor();
        if(myColor == ChessGame.TeamColor.BLACK){
            offsets = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}}; //Overriding the offsets to brute force this.
        }
        Collection<ChessMove> legalMoves = new ArrayList<>(); //Change this later when function is fully implemented.
        for(int[] offset : offsets){
            int rowOffset = offset[0];
            int colOffset = offset[1];
            ChessPosition potentialPos = new ChessPosition(myPosition.getRow() + rowOffset, myPosition.getColumn() + colOffset );
            if(potentialPos.isInBounds()){
                if(board.getPiece(potentialPos) == null && colOffset == 0){//If the vision space is clear
                    if(canPromote(potentialPos, myColor)){
                        legalMoves.add(new ChessMove(myPosition, potentialPos, ChessPiece.PieceType.BISHOP));
                        legalMoves.add(new ChessMove(myPosition, potentialPos, ChessPiece.PieceType.KNIGHT));
                        legalMoves.add(new ChessMove(myPosition, potentialPos, ChessPiece.PieceType.ROOK));
                        legalMoves.add(new ChessMove(myPosition, potentialPos, ChessPiece.PieceType.QUEEN));
                    } else{
                        legalMoves.add(new ChessMove(myPosition, potentialPos, null));
                        ChessPosition lookAhead = new ChessPosition(potentialPos.getRow() + rowOffset,potentialPos.getColumn() + colOffset);
                        if(firstMove(myPosition, myColor) && board.getPiece(lookAhead) == null){
                            legalMoves.add(new ChessMove(myPosition, lookAhead, null));
                        }
                    }
                } else if(board.getPiece(potentialPos) != null && board.getPiece(potentialPos).getTeamColor() != myColor && colOffset != 0){
                    //If the vision space is not clear BUT we can capture it.
                    if(canPromote(potentialPos, myColor)){
                        legalMoves.add(new ChessMove(myPosition, potentialPos, ChessPiece.PieceType.BISHOP));
                        legalMoves.add(new ChessMove(myPosition, potentialPos, ChessPiece.PieceType.KNIGHT));
                        legalMoves.add(new ChessMove(myPosition, potentialPos, ChessPiece.PieceType.ROOK));
                        legalMoves.add(new ChessMove(myPosition, potentialPos, ChessPiece.PieceType.QUEEN));
                    } else{
                        legalMoves.add(new ChessMove(myPosition, potentialPos, null));
                    }
                }
            }
        }
        return legalMoves;
    }

    boolean firstMove(ChessPosition myPos, ChessGame.TeamColor myTeam){
        return ((myPos.getRow() == 2 && myTeam == ChessGame.TeamColor.WHITE) || (myPos.getRow() == 7 && myTeam == ChessGame.TeamColor.BLACK));
    }

    boolean canPromote(ChessPosition myPos, ChessGame.TeamColor myTeam){
        return ((myPos.getRow() == 8 && myTeam == ChessGame.TeamColor.WHITE) || (myPos.getRow() == 1 && myTeam == ChessGame.TeamColor.BLACK));
    }
}
