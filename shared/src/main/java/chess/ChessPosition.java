package chess;

import java.util.Objects;

/**
 * Represents a single square position on a chess board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPosition {
    private final int myRow;
    private final int myCol;
    public ChessPosition(int row, int col) {
        myRow = row;
        myCol = col;
    }

    /**
     * @return which row this position is in
     * 1 codes for the bottom row
     */
    public int getRow() {
        return myRow;
    }

    /**
     * @return which column this position is in
     * 1 codes for the left column
     */
    public int getColumn() {
        return myCol;
    }

    //This function will come in handy when implementing the move helpers.
    public boolean isInBounds(){
        return ((myRow > 0 && myRow <= 8) && (myCol > 0 && myCol <= 8));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPosition that = (ChessPosition) o;
        return myRow == that.myRow && myCol == that.myCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myRow, myCol);
    }

    @Override
    public String toString() {
        return "ChessPosition{" +
                "myRow=" + myRow +
                ", myCol=" + myCol +
                '}';
    }
}
