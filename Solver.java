import java.util.Arrays;
public class Solver
{
    public static SolutionTree solve(Sequent sequent)
    {
        //check axiom
        for(Formula l: sequent.lhs)
        {
            if(l.op == Operator.NULL)
            {
                for(Formula r: sequent.rhs)
                {
                    if(r.op == Operator.NULL && r.atom == l.atom)
                    {
                        return new SolutionTree(1);
                    }
                }
            }
        }
        
        // ~L &L
        SolutionTree toRet = new SolutionTree(sequent);
        for(Formula f: sequent.lhs)
        {
            if(f.op == Operator.NOT)
            {
                sequent.rhs.add(f.lhs);
                sequent.lhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                return toRet;
            }
            if(f.op == Operator.AND)
            {
                sequent.lhs.add(f.lhs);
                sequent.lhs.add(f.rhs);
                sequent.lhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                return toRet;
            }
        }
        // ~R |R >R
        for(Formula f: sequent.rhs)
        {
            if(f.op == Operator.NOT)
            {
                sequent.lhs.add(f.lhs);
                sequent.rhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                return toRet;
            }
            if(f.op == Operator.OR)
            {
                sequent.rhs.add(f.lhs);
                sequent.rhs.add(f.rhs);
                sequent.rhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                return toRet;
            }
            if(f.op == Operator.IMP)
            {
                sequent.lhs.add(f.lhs);
                sequent.rhs.add(f.rhs);
                sequent.rhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                return toRet;
            }
        }
        // |L >L
        for(Formula f: sequent.lhs)
        {
            if(f.op == Operator.OR)
            {
                Sequent lTemp = sequent, rTemp = sequent;
                lTemp.lhs.add(f.lhs);
                lTemp.lhs.remove(f);
                rTemp.lhs.add(f.rhs);
                rTemp.lhs.remove(f);
                toRet.lChild = Solver.solve(lTemp);
                toRet.rChild = Solver.solve(rTemp);
                return toRet;
            }
            if(f.op == Operator.IMP)
            {
                Sequent lTemp = sequent, rTemp = sequent;
                lTemp.rhs.add(f.lhs);
                lTemp.lhs.remove(f);
                rTemp.lhs.add(f.rhs);
                rTemp.lhs.remove(f);
                toRet.lChild = Solver.solve(lTemp);
                toRet.rChild = Solver.solve(rTemp);
                return toRet;
            }
        }
        // &R
        for(Formula f: sequent.rhs)
        {
            if(f.op == Operator.AND)
            {
                Sequent lTemp = sequent, rTemp = sequent;
                lTemp.rhs.add(f.lhs);
                lTemp.rhs.remove(f);
                rTemp.rhs.add(f.rhs);
                rTemp.rhs.remove(f);
                toRet.lChild = Solver.solve(lTemp);
                toRet.rChild = Solver.solve(rTemp);
                return toRet;
            }
        }
        return new SolutionTree(2);
    }
}