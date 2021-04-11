// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class ConstValList_List extends ConstValList {

    private ConstValList ConstValList;
    private ConstValAssign ConstValAssign;

    public ConstValList_List (ConstValList ConstValList, ConstValAssign ConstValAssign) {
        this.ConstValList=ConstValList;
        if(ConstValList!=null) ConstValList.setParent(this);
        this.ConstValAssign=ConstValAssign;
        if(ConstValAssign!=null) ConstValAssign.setParent(this);
    }

    public ConstValList getConstValList() {
        return ConstValList;
    }

    public void setConstValList(ConstValList ConstValList) {
        this.ConstValList=ConstValList;
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
        if(ConstValList!=null) ConstValList.accept(visitor);
        if(ConstValAssign!=null) ConstValAssign.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstValList!=null) ConstValList.traverseTopDown(visitor);
        if(ConstValAssign!=null) ConstValAssign.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstValList!=null) ConstValList.traverseBottomUp(visitor);
        if(ConstValAssign!=null) ConstValAssign.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstValList_List(\n");

        if(ConstValList!=null)
            buffer.append(ConstValList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstValAssign!=null)
            buffer.append(ConstValAssign.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstValList_List]");
        return buffer.toString();
    }
}
