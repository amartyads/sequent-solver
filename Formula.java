public class Formula
{
    public Formula lhs;
    public Formula rhs;
    public Operator op;
    public char atom;
    public Formula()
    {
        lhs = null;
        op = Operator.NULL;
        rhs = null;
        atom = '!';
    }
    public Formula(Formula lhs, Operator op)
    {
        this.lhs = lhs;
        this.op = op;
        this.rhs = null;
        atom = '!';
    }
    public Formula(Formula lhs, Operator op, Formula rhs)
    {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
        atom = '!';
    }
    public Formula(char c)
    {
        atom = c;
        lhs = null;
        op = Operator.NULL;
        rhs = null;
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
    public String toString()
    {
        if(op == Operator.NULL)
            return Character.toString(atom);
        else
        {
            String oper = "";
            switch(op)
            {
                case AND:
                    oper = " & ";
                    break;
                case OR:
                    oper = " | ";
                    break;
                case IMP:
                    oper = " > ";
                    break;
                case NOT:
                    oper = " ~ ";
                    break;
            }
            return (lhs.toString() + oper + rhs.toString());
        }
    }
}