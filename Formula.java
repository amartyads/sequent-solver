import java.util.*;
public class Formula
{
    public Formula lhs;
    public Formula rhs;
    public Operator op;
    public char atom;
    public final static Formula TOP = new Formula('T');
    public final static Formula BOTTOM = new Formula('L');
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
    public Formula(Formula lhs, Operator op, Formula rhs, char atom)
    {
        this.lhs = lhs;
        this.op = op;
        this.rhs = rhs;
        this.atom = atom;
    }
    public Formula(String s)
    {
        Formula ans = Formula.parse(s.trim());
        this.lhs = ans.lhs;
        this.op = ans.op;
        this.rhs = ans.rhs;
        this.atom = ans.atom;
    }
    public Formula deepCopy()
    {
        return new Formula(lhs, op, rhs, atom);
    }
    public static Formula parse(String s)
    {
        // check for parse error, match patterns
        // if wrong, exit immediately
        // recursively call parse and match operators every call
        // Getting infix expression to convert to postfix to expression tree
        char[] infix = new char[s.length()+1];
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
                case ' ':
                    break;
                default:
                    if(Character.isLetter(i))
                    {
                        if(k < s.length()-1 && Character.isLetter(s.charAt(k+1)))
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
        infix[infix.length-1] = ')';
        //Conversion from infix to postfix
        char[] postfix = new char[s.length()+1];
        char[] stack = new char[s.length()+1];
        stack[0] = '(';
        int qt = 0;
        int pt = 0;
        for(int i = 0; i < infix.length; ++i)
        {
            char c = infix[i];
            if(Character.isLetter(c))
            {
                postfix[pt++] = c;
                if(stack[qt] == '~')
                    postfix[pt++] = stack[qt--];
            }
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
        
        //Convert Postfix expression to expression tree
        ArrayList<Formula> fst = new ArrayList<Formula>();
        int pos = -1;
        for(int i = 0; i < postfix.length; ++i)
        {
            char c = postfix[i];
            if(c == '\u0000')
                continue;
            if(Character.isLetter(c))
            {
                fst.add(new Formula(c));
                pos++;
            }
            else if(c == '~')
            {
                Formula temp = new Formula(fst.remove(pos),Operator.NOT);
                fst.add(temp);
            }
            else if(c == '|'){
                Formula temp = new Formula(fst.get(pos-1),Operator.OR,fst.get(pos));
                fst.remove(pos);
                fst.remove(pos-1);
                fst.add(temp);
                pos--;
            }
            else if(c == '&'){
                Formula temp = new Formula(fst.get(pos-1),Operator.AND,fst.get(pos));
                fst.remove(pos);
                fst.remove(pos-1);
                fst.add(temp);
                pos--;
            }
            else if(c == '>'){
                Formula temp = new Formula(fst.get(pos-1),Operator.IMP,fst.get(pos));
                fst.remove(pos);
                fst.remove(pos-1);
                fst.add(temp);
                pos--;
            }
        }
        
        return fst.get(0);
    }
    public String toString()
    {
        if(op == Operator.NULL)
            return Character.toString(atom);
        else
        {
            String oper = "";
            if(op != Operator.NOT)
            {
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
                }
                return ("( " + lhs.toString() + oper + rhs.toString() + " )");
            }
            else
                return ("~" + lhs.toString());
        }
    }
}