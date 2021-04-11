// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclDefineList_Item extends GlobalVarDeclDefineList {

    private GlobalVarDeclDefine GlobalVarDeclDefine;

    public GlobalVarDeclDefineList_Item (GlobalVarDeclDefine GlobalVarDeclDefine) {
        this.GlobalVarDeclDefine=GlobalVarDeclDefine;
        if(GlobalVarDeclDefine!=null) GlobalVarDeclDefine.setParent(this);
    }

    public GlobalVarDeclDefine getGlobalVarDeclDefine() {
        return GlobalVarDeclDefine;
    }

    public void setGlobalVarDeclDefine(GlobalVarDeclDefine GlobalVarDeclDefine) {
        this.GlobalVarDeclDefine=GlobalVarDeclDefine;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarDeclDefine!=null) GlobalVarDeclDefine.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarDeclDefine!=null) GlobalVarDeclDefine.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarDeclDefine!=null) GlobalVarDeclDefine.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclDefineList_Item(\n");

        if(GlobalVarDeclDefine!=null)
            buffer.append(GlobalVarDeclDefine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclDefineList_Item]");
        return buffer.toString();
    }
}
