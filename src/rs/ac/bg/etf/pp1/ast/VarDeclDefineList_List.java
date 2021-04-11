// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class VarDeclDefineList_List extends VarDeclDefineList {

    private VarDeclDefineList VarDeclDefineList;
    private VarDeclDefine VarDeclDefine;

    public VarDeclDefineList_List (VarDeclDefineList VarDeclDefineList, VarDeclDefine VarDeclDefine) {
        this.VarDeclDefineList=VarDeclDefineList;
        if(VarDeclDefineList!=null) VarDeclDefineList.setParent(this);
        this.VarDeclDefine=VarDeclDefine;
        if(VarDeclDefine!=null) VarDeclDefine.setParent(this);
    }

    public VarDeclDefineList getVarDeclDefineList() {
        return VarDeclDefineList;
    }

    public void setVarDeclDefineList(VarDeclDefineList VarDeclDefineList) {
        this.VarDeclDefineList=VarDeclDefineList;
    }

    public VarDeclDefine getVarDeclDefine() {
        return VarDeclDefine;
    }

    public void setVarDeclDefine(VarDeclDefine VarDeclDefine) {
        this.VarDeclDefine=VarDeclDefine;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclDefineList!=null) VarDeclDefineList.accept(visitor);
        if(VarDeclDefine!=null) VarDeclDefine.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclDefineList!=null) VarDeclDefineList.traverseTopDown(visitor);
        if(VarDeclDefine!=null) VarDeclDefine.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclDefineList!=null) VarDeclDefineList.traverseBottomUp(visitor);
        if(VarDeclDefine!=null) VarDeclDefine.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclDefineList_List(\n");

        if(VarDeclDefineList!=null)
            buffer.append(VarDeclDefineList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclDefine!=null)
            buffer.append(VarDeclDefine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclDefineList_List]");
        return buffer.toString();
    }
}
