import java.util.ArrayList;
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
}