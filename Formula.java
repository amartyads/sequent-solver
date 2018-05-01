public class Formula
{
    public char[] preForm;
    public Formula()
    {
        preForm = null;
    }
    public Formula(char c)
    {
        preForm = new char[1];
        preForm[0] = c;
    }
    public Formula(char[] c)
    {
        preForm = c;
    }
    public Formula(String s)
    {
        preForm = parse(s);
    }
    public static char[] parse(String s)
    {
        // check for parse error, match patterns
        // if wrong, exit immediately
        // recursively call parse and match operators every call
        return null;
    }
}