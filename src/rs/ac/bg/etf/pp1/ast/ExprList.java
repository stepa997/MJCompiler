// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class ExprList extends ExprLeft {

    private ExprLeft ExprLeft;
    private AddopLeft AddopLeft;
    private TermLeft TermLeft;

    public ExprList (ExprLeft ExprLeft, AddopLeft AddopLeft, TermLeft TermLeft) {
        this.ExprLeft=ExprLeft;
        if(ExprLeft!=null) ExprLeft.setParent(this);
        this.AddopLeft=AddopLeft;
        if(AddopLeft!=null) AddopLeft.setParent(this);
        this.TermLeft=TermLeft;
        if(TermLeft!=null) TermLeft.setParent(this);
    }

    public ExprLeft getExprLeft() {
        return ExprLeft;
    }

    public void setExprLeft(ExprLeft ExprLeft) {
        this.ExprLeft=ExprLeft;
    }

    public AddopLeft getAddopLeft() {
        return AddopLeft;
    }

    public void setAddopLeft(AddopLeft AddopLeft) {
        this.AddopLeft=AddopLeft;
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
        if(ExprLeft!=null) ExprLeft.accept(visitor);
        if(AddopLeft!=null) AddopLeft.accept(visitor);
        if(TermLeft!=null) TermLeft.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprLeft!=null) ExprLeft.traverseTopDown(visitor);
        if(AddopLeft!=null) AddopLeft.traverseTopDown(visitor);
        if(TermLeft!=null) TermLeft.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprLeft!=null) ExprLeft.traverseBottomUp(visitor);
        if(AddopLeft!=null) AddopLeft.traverseBottomUp(visitor);
        if(TermLeft!=null) TermLeft.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprList(\n");

        if(ExprLeft!=null)
            buffer.append(ExprLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopLeft!=null)
            buffer.append(AddopLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TermLeft!=null)
            buffer.append(TermLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprList]");
        return buffer.toString();
    }
}
