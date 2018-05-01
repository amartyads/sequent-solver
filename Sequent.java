import java.util.ArrayList;
import java.lang.StringBuilder;
public class Sequent
{
    public ArrayList<Formula> lhs;
    public ArrayList<Formula> rhs;
    public Sequent()
    {
        lhs = new ArrayList<Formula>();
        rhs = new ArrayList<Formula>();
    }
    public Sequent(ArrayList<Formula> lhs, ArrayList<Formula> rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    public Sequent(String s)
    {
        Sequent ans = Sequent.parse(s);
        this.lhs = ans.lhs;
        this.rhs = ans.rhs;
    }
    public static Sequent parse(String s)
    {
        // look for substring "|-"
        // if not found append at beginning
        // split across "|-"
        // split rhs and lhs along ','
        // trim individual string for spaces
        // run formula.parse on each split string, add to arraylist
        return null;
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        int i;
        try
        {
            sb.append(lhs.get(0).toString());
            for(i = 1; i < lhs.size(); i++)
            {
                sb.append(", ");
                sb.append(lhs.get(i));
            }
        }
        catch(Exception e) {}
        sb.append(" |- ");
        try
        {
            sb.append(rhs.get(0).toString());
            for(i = 1; i < rhs.size(); i++)
            {
                sb.append(", ");
                sb.append(rhs.get(i));
            }
        }
        catch(Exception e) {}
        return sb.toString();
    }
}