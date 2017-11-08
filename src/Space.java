/**
 * Created with IntelliJ IDEA.
 * User: erichenderson
 * Date: 1/31/13
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Space
{
    private int val = 0;

    public Space()
    {
        val = 0;
    }

    public Space(int val)
    {
        this.val = val;
    }

    public int getVal()
    {
        return val;
    }

    public void setVal(int val)
    {
        if(val >= 0 && val <= 9) this.val = val;
    }
}
