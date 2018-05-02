import java.util.Arrays;
import java.io.*;
public class Solver
{
    public static SolutionTree solve(Sequent sequent) throws IOException
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
                        return new SolutionTree(sequent.deepCopy(),"Axiom",1);
                    }
                }
            }
        }
        
        //Bottom
        for(Formula l: sequent.lhs)
        {
            if(l.atom == 'L')
            {
                return new SolutionTree(sequent.deepCopy(),"Bottom L",1);
            }
        }
        
        // ~L &L
        SolutionTree toRet = new SolutionTree(sequent.deepCopy());
        
        Sequent lTemp = sequent;
        Sequent rTemp = sequent.deepCopy();
        for(Formula f: sequent.lhs)
        {
            if(f.op == Operator.NOT)
            {
                sequent.rhs.add(f.lhs);
                sequent.lhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                toRet.step = ("~L");
                return toRet;
            }
            if(f.op == Operator.AND)
            {
                sequent.lhs.add(f.lhs);
                sequent.lhs.add(f.rhs);
                sequent.lhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                toRet.step = ("&L");
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
                toRet.step = ("~R");
                return toRet;
            }
            if(f.op == Operator.OR)
            {
                sequent.rhs.add(f.lhs);
                sequent.rhs.add(f.rhs);
                sequent.rhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                toRet.step = ("|R");
                return toRet;
            }
            if(f.op == Operator.IMP)
            {
                sequent.lhs.add(f.lhs);
                sequent.rhs.add(f.rhs);
                sequent.rhs.remove(f);
                toRet.lChild = Solver.solve(sequent);
                toRet.step = (">R");
                return toRet;
            }
        }
        // |L >L
        for(Formula f: sequent.lhs)
        {
            if(f.op == Operator.OR)
            {
                lTemp.lhs.add(f.lhs);
                lTemp.lhs.remove(f);
                rTemp.lhs.add(f.rhs);
                rTemp.lhs.remove(f);
                toRet.lChild = Solver.solve(lTemp);
                toRet.rChild = Solver.solve(rTemp);
                toRet.step = ("|L");
                return toRet;
            }
            if(f.op == Operator.IMP)
            {
                lTemp.rhs.add(f.lhs);
                lTemp.lhs.remove(f);
                rTemp.lhs.add(f.rhs);
                rTemp.lhs.remove(f);
                toRet.lChild = Solver.solve(lTemp);
                toRet.rChild = Solver.solve(rTemp);
                toRet.step = (">L");
                return toRet;
            }
        }
        // &R
        for(Formula f: sequent.rhs)
        {
            if(f.op == Operator.AND)
            {
                lTemp.rhs.add(f.lhs);
                lTemp.rhs.remove(f);
                rTemp.rhs.add(f.rhs);
                rTemp.rhs.remove(f);
                toRet.lChild = Solver.solve(lTemp);
                toRet.rChild = Solver.solve(rTemp);
                toRet.step = ("&R");
                return toRet;
            }
        }
        return new SolutionTree(2);
    }
}