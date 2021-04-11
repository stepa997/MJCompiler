// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclDefineList_List extends GlobalVarDeclDefineList {

    private GlobalVarDeclDefineList GlobalVarDeclDefineList;
    private GlobalVarDeclDefine GlobalVarDeclDefine;

    public GlobalVarDeclDefineList_List (GlobalVarDeclDefineList GlobalVarDeclDefineList, GlobalVarDeclDefine GlobalVarDeclDefine) {
        this.GlobalVarDeclDefineList=GlobalVarDeclDefineList;
        if(GlobalVarDeclDefineList!=null) GlobalVarDeclDefineList.setParent(this);
        this.GlobalVarDeclDefine=GlobalVarDeclDefine;
        if(GlobalVarDeclDefine!=null) GlobalVarDeclDefine.setParent(this);
    }

    public GlobalVarDeclDefineList getGlobalVarDeclDefineList() {
        return GlobalVarDeclDefineList;
    }

    public void setGlobalVarDeclDefineList(GlobalVarDeclDefineList GlobalVarDeclDefineList) {
        this.GlobalVarDeclDefineList=GlobalVarDeclDefineList;
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
        if(GlobalVarDeclDefineList!=null) GlobalVarDeclDefineList.accept(visitor);
        if(GlobalVarDeclDefine!=null) GlobalVarDeclDefine.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarDeclDefineList!=null) GlobalVarDeclDefineList.traverseTopDown(visitor);
        if(GlobalVarDeclDefine!=null) GlobalVarDeclDefine.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarDeclDefineList!=null) GlobalVarDeclDefineList.traverseBottomUp(visitor);
        if(GlobalVarDeclDefine!=null) GlobalVarDeclDefine.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclDefineList_List(\n");

        if(GlobalVarDeclDefineList!=null)
            buffer.append(GlobalVarDeclDefineList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarDeclDefine!=null)
            buffer.append(GlobalVarDeclDefine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclDefineList_List]");
        return buffer.toString();
    }
}
