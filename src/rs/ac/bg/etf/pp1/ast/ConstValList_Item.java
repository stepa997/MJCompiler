// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class ConstValList_Item extends ConstValList {

    private ConstValAssign ConstValAssign;

    public ConstValList_Item (ConstValAssign ConstValAssign) {
        this.ConstValAssign=ConstValAssign;
        if(ConstValAssign!=null) ConstValAssign.setParent(this);
    }

    public ConstValAssign getConstValAssign() {
        return ConstValAssign;
    }

    public void setConstValAssign(ConstValAssign ConstValAssign) {
        this.ConstValAssign=ConstValAssign;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstValAssign!=null) ConstValAssign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstValAssign!=null) ConstValAssign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstValAssign!=null) ConstValAssign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstValList_Item(\n");

        if(ConstValAssign!=null)
            buffer.append(ConstValAssign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstValList_Item]");
        return buffer.toString();
    }
}
