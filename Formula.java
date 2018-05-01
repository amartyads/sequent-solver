import java.util.*;
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
        Formula ans = Formula.parse(s.trim());
        this.lhs = ans.lhs;
        this.op = ans.op;
        this.rhs = ans.rhs;
    }
    public static Formula parse(String s)
    {
        // check for parse error, match patterns
        // if wrong, exit immediately
        // recursively call parse and match operators every call
        // Getting infix expression to convert to postfix to expression tree
        char[] infix = new char[s.length()];
        for(int k = 0; k < s.length(); ++k)
        {
            char i = s.charAt(k);
            switch (i)
            {
                case '(':
                case ')':
                case '~':
                   
                case '&':
                    
                case '|':
                    
                case '>':
                    infix[k] = i;
                    break;   
                default:
                    if(Character.isLetter(i))
                    {
                        if(k < s.length() && Character.isLetter(s.charAt(k+1)))
                        {
                             System.out.println("Invalid Input");
                             System.exit(0);
                        }
                        infix[k] = i;
                    }
                    else
                    {
                        System.out.println("Invalid Input");
                        System.exit(0);
                    }
                    break;
            }
        }
        //Conversion from infix to postfix
        Stack st = new Stack();
        char[] postfix = new char[s.length()];
        char[] stack = new char[s.length()];
        int qt = -1;
        int pt = 0;
        for(int i = 0; i < infix.length; ++i)
        {
            char c = infix[i];
            if(Character.isLetter(c))
                postfix[pt++] = c;
            else
            {
                if(c == '(')
                    stack[++qt] = c;
                else if(c == ')')
                {
                    while(stack[qt] != '(')
                    {
                        postfix[pt++] = stack[qt--];
                    }
                    qt--;
                }
                else
                    stack[++qt] = c;
            }
        }
        
        return null;
    }
}