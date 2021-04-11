// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class DesignatorTar extends DesignatorStatement {

    private Designator Designator;
    private Factor Factor;
    private Factor Factor1;

    public DesignatorTar (Designator Designator, Factor Factor, Factor Factor1) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
        this.Factor1=Factor1;
        if(Factor1!=null) Factor1.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public Factor getFactor1() {
        return Factor1;
    }

    public void setFactor1(Factor Factor1) {
        this.Factor1=Factor1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
        if(Factor1!=null) Factor1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
        if(Factor1!=null) Factor1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        if(Factor1!=null) Factor1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorTar(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor1!=null)
            buffer.append(Factor1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorTar]");
        return buffer.toString();
    }
}
