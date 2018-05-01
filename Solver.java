public class Solver
{
    public static SolutionTree solve(Sequent sequent)
    {
        //check axiom
        for(Formula l: sequent.lhs)
        {
            if(l.length() == 1)
            {
                for(Formula r: sequent.rhs)
                {
                    if(r.length() == 1 && l.preForm[0] == r.preForm[0])
                    {
                        return new SolutionTree(true);
                    }
                }
            }
        }
        // ~L &L |L >L
        
        // ~R &R |R >R
        
        return null;
    }
}