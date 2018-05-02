public class SolutionTree
{
    public Sequent sequent;
    public SolutionTree lChild, rChild;
    public int solved; // 0 not atom 1 solved 2 unsolved
    public SolutionTree()
    {
        sequent = null;
        lChild = null;
        rChild = null;
        solved = 2;
    }
    public SolutionTree(Sequent sequent)
    {
        this.sequent = sequent;
        solved = 0;
    }
    public SolutionTree(Sequent sequent, int b)
    {
        this.sequent = sequent;
        solved = b;
    }
    public SolutionTree(int b)
    {
        sequent = null;
        lChild = null;
        rChild = null;
        solved = b;
    }
    public static void print(SolutionTree st)
    {
        print(st, 0);
    }
    private static void print(SolutionTree st, int level)
    {
        for(int i = 0; i < level; i++)
        {
            System.out.print("    ");
        }
        System.out.println(st.sequent);
        if(st.solved == 1)
        {
            System.out.print("Axiom");
        }
        else if(st.solved == 2)
        {
            System.out.print("Cannot solve");
        }
        else
        {
            if(st.rChild == null)
            {
                print(st.lChild, level);
            }
            else
            {
                for(int i = 0; i < level; i++)
                {
                    System.out.print("    ");
                }
                System.out.println("Left Child:");
                print(st.lChild, level+1);
                for(int i = 0; i < level; i++)
                {
                    System.out.print("    ");
                }
                System.out.println("Right Child");
                print(st.rChild, level+1);
            }
        }
        System.out.println();
    }
}