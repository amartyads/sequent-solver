public class SolutionTree
{
    public Sequent sequent;
    public SolutionTree lChild, rChild;
    public SolutionTree()
    {
        sequent = null;
        lChild = null;
        rChild = null;
    }
    public SolutionTree(Sequent sequent)
    {
        this.sequent = sequent;
    }
    public void print()
    {
    }
}