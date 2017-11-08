/**
 * Created with IntelliJ IDEA.
 * User: erichenderson
 * Date: 1/31/13
 * Time: 9:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpacePos
{
    private int row = 0;
    private int col = 0;

    public SpacePos()
    {
        row = 0;
        col = 0;
    }

    public SpacePos(int row, int col)
    {
        setRow(row);
        setCol(col);
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        if(row >= -1 && row <= 8) this.row = row;
    }

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        if(col >= -1 && col <= 8) this.col = col;
    }
}
