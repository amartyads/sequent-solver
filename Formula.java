public class Formula
{
    public Formula lhs;
    public Formula rhs;
    public Operator op;
    public Formula()
    {
        lhs = null;
        op = Operator.NULL;
        rhs = null;
    }
    public Formula(Formula lhs, Operator op)
    {
        this.lhs = lhs;
        this.op = op;
        this.rhs = null;
    }
    public Formula(Formula lhs, Operator op, Formula rhs)
    {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
    }
    public Formula(String s)
    {
        parse(s);
    }
    public void parse(String s)
    {
    }
}