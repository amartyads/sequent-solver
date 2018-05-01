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
}