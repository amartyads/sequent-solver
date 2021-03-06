import java.io.*;
public class Main
{
    public static void main(String[] args)throws IOException
    {
        String inp = args[0];
        //send inp to Sequent parser
        Sequent init = new Sequent(inp);
        //solve init
        SolutionTree stree = Solver.solve(init);
        //print the tree
        SolutionTree.print(stree);
    }
}