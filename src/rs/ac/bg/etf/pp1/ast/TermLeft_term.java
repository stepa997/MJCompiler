// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class TermLeft_term extends Term {

    private TermLeft TermLeft;

    public TermLeft_term (TermLeft TermLeft) {
        this.TermLeft=TermLeft;
        if(TermLeft!=null) TermLeft.setParent(this);
    }

    public TermLeft getTermLeft() {
        return TermLeft;
    }

    public void setTermLeft(TermLeft TermLeft) {
        this.TermLeft=TermLeft;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermLeft!=null) TermLeft.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermLeft!=null) TermLeft.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermLeft!=null) TermLeft.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermLeft_term(\n");

        if(TermLeft!=null)
            buffer.append(TermLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermLeft_term]");
        return buffer.toString();
    }
}
