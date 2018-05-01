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
        Formula ans = Formula.parse(s);
        this.lhs = ans.lhs;
        this.op = ans.op;
        this.rhs = ans.rhs;
    }
    public static Formula parse(String s)
    {
        // check for parse error, match patterns
        // if wrong, exit immediately
        // recursively call parse and match operators every call
        return null;
    }
}