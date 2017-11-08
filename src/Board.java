/**
 * Created with IntelliJ IDEA.
 * User: erichenderson
 * Date: 1/31/13
 * Time: 9:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class Board
{
    private Space[][] board = null;

    public Board()
    {
        setupBoard();
    }

    public Space getAt(int row, int col)
    {
        try
        {
            return board[row][col];
        }
        catch(Exception e) {}
        return new Space();
    }

    public void setAt(int row, int col, Space space)
    {
        try
        {
            board[row][col] = space;
        }
        catch(Exception e) {}
    }

    private void setupBoard()
    {
        board = new Space[9][9];
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                board[i][j] = new Space();
            }
        }
    }

    public void refreshBoard()
    {
        setupBoard();
    }

    public boolean[] numsLeft()
    {
        boolean[] numFilled = {false, false, false, false, false, false, false, false, false};
        int[] pos = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                int val = board[i][j].getVal();
                if(val > 0) pos[val - 1]++;
            }
        }
        for(int i = 0; i < 9; i++)
        {
            if(pos[i] >= 9) numFilled[i] = true;
        }
        return numFilled;
    }

    public Space[][] possibilities(int num)
    {
        if(num <= 0 || num > 9) return null;
        Space[][] temp = new Space[9][9];
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                temp[i][j] = new Space();
            }
        }
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j].getVal() == 0)
                {
                    if(checkBlock(num, i / 3, j / 3) && checkRow(num, i) && checkCol(num, j)) temp[i][j].setVal(num);
                }
            }
        }
        return temp;
    }

    public boolean only(int num, int row, int col)
    {
        if(num <= 0 || num > 9) return false;
        int[][] blocks = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[] rows = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] cols = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j].getVal() == 0)
                {
                    if(checkBlock(num, i / 3, j / 3) && checkRow(num, i) && checkCol(num, j))
                    {
                        blocks[(i / 3)][(j / 3)]++;
                        rows[i]++;
                        cols[j]++;
                    }
                }
            }
        }
        if(blocks[(row / 3)][(col / 3)] == 1 || rows[row] == 1 || cols[col] == 1) return true;
        return false;
    }

    private boolean checkBlock(int num, int brow, int bcol)
    {
        if(num <= 0 || num > 9) return false;
        int rmin = brow * 3;
        int rmax = ((brow + 1) * 3);
        int cmin = bcol * 3;
        int cmax = ((bcol + 1) * 3);
        for(int i = rmin; i < rmax; i++)
        {
            for(int j = cmin; j < cmax; j++)
            {
                if(board[i][j].getVal() == num) return false;
            }
        }
        return true;
    }

    private boolean checkRow(int num, int row)
    {
        if(num <= 0 || num > 9) return false;
        for(int i = 0; i < 9; i++)
        {
            if(board[row][i].getVal() == num) return false;
        }
        return true;
    }

    private boolean checkCol(int num, int col)
    {
        if(num <= 0 || num > 9) return false;
        for(int i = 0; i < 9; i++)
        {
            if(board[i][col].getVal() == num) return false;
        }
        return true;
    }
}
