// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class LeftExpr extends Expr {

    private ExprLeft ExprLeft;

    public LeftExpr (ExprLeft ExprLeft) {
        this.ExprLeft=ExprLeft;
        if(ExprLeft!=null) ExprLeft.setParent(this);
    }

    public ExprLeft getExprLeft() {
        return ExprLeft;
    }

    public void setExprLeft(ExprLeft ExprLeft) {
        this.ExprLeft=ExprLeft;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprLeft!=null) ExprLeft.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprLeft!=null) ExprLeft.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprLeft!=null) ExprLeft.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LeftExpr(\n");

        if(ExprLeft!=null)
            buffer.append(ExprLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LeftExpr]");
        return buffer.toString();
    }
}
