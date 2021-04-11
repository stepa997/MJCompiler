// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class TermFactor extends TermLeft {

    private TermLeft TermLeft;
    private MulopLeft MulopLeft;
    private Factor Factor;

    public TermFactor (TermLeft TermLeft, MulopLeft MulopLeft, Factor Factor) {
        this.TermLeft=TermLeft;
        if(TermLeft!=null) TermLeft.setParent(this);
        this.MulopLeft=MulopLeft;
        if(MulopLeft!=null) MulopLeft.setParent(this);
        this.Factor=Factor;
        if(Factor!=null) Factor.setParent(this);
    }

    public TermLeft getTermLeft() {
        return TermLeft;
    }

    public void setTermLeft(TermLeft TermLeft) {
        this.TermLeft=TermLeft;
    }

    public MulopLeft getMulopLeft() {
        return MulopLeft;
    }

    public void setMulopLeft(MulopLeft MulopLeft) {
        this.MulopLeft=MulopLeft;
    }

    public Factor getFactor() {
        return Factor;
    }

    public void setFactor(Factor Factor) {
        this.Factor=Factor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermLeft!=null) TermLeft.accept(visitor);
        if(MulopLeft!=null) MulopLeft.accept(visitor);
        if(Factor!=null) Factor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermLeft!=null) TermLeft.traverseTopDown(visitor);
        if(MulopLeft!=null) MulopLeft.traverseTopDown(visitor);
        if(Factor!=null) Factor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermLeft!=null) TermLeft.traverseBottomUp(visitor);
        if(MulopLeft!=null) MulopLeft.traverseBottomUp(visitor);
        if(Factor!=null) Factor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermFactor(\n");

        if(TermLeft!=null)
            buffer.append(TermLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MulopLeft!=null)
            buffer.append(MulopLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Factor!=null)
            buffer.append(Factor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermFactor]");
        return buffer.toString();
    }
}
