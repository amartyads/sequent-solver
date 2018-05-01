public class SolutionTree
{
    public Sequent sequent;
    public SolutionTree lChild, rChild;
    public boolean solved;
    public SolutionTree()
    {
        sequent = null;
        lChild = null;
        rChild = null;
        solved = false;
    }
    public SolutionTree(Sequent sequent)
    {
        this.sequent = sequent;
    }
    public SolutionTree(boolean b)
    {
        sequent = null;
        lChild = null;
        rChild = null;
        solved = b;
    }
    public void print()
    {
    }
}