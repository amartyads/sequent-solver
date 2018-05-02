public class SolutionTree
{
    public Sequent sequent;
    public SolutionTree lChild, rChild;
    public String step;
    public int solved; // 0 not atom 1 solved 2 unsolved
    public SolutionTree()
    {
        sequent = null;
        lChild = null;
        rChild = null;
        step = "";
        solved = 2;
    }
    public SolutionTree(Sequent sequent)
    {
        this.sequent = sequent;
        step = "";
        solved = 0;
    }
    public SolutionTree(Sequent sequent, String step, int b)
    {
        this.sequent = sequent;
        this.step = step;
        solved = b;
    }
    public SolutionTree(int b)
    {
        sequent = null;
        lChild = null;
        rChild = null;
        step = "";
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
        System.out.println(st.sequent + "\t\t\t\t" + st.step);
        if(st.solved == 1)
        {
            System.out.print("Solved");
        }
        else if(st.solved == 2)
        {
            System.out.print("Cannot solve, exiting...");
            System.exit(0);
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