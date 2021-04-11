// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class VarDeclDefine_Item extends VarDeclDefineList {

    private VarDeclDefine VarDeclDefine;

    public VarDeclDefine_Item (VarDeclDefine VarDeclDefine) {
        this.VarDeclDefine=VarDeclDefine;
        if(VarDeclDefine!=null) VarDeclDefine.setParent(this);
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
        if(VarDeclDefine!=null) VarDeclDefine.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclDefine!=null) VarDeclDefine.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclDefine!=null) VarDeclDefine.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclDefine_Item(\n");

        if(VarDeclDefine!=null)
            buffer.append(VarDeclDefine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclDefine_Item]");
        return buffer.toString();
    }
}
