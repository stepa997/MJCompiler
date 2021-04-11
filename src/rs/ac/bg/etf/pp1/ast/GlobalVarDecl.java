// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private GlobalVarDeclDefineList GlobalVarDeclDefineList;

    public GlobalVarDecl (Type Type, GlobalVarDeclDefineList GlobalVarDeclDefineList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.GlobalVarDeclDefineList=GlobalVarDeclDefineList;
        if(GlobalVarDeclDefineList!=null) GlobalVarDeclDefineList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public GlobalVarDeclDefineList getGlobalVarDeclDefineList() {
        return GlobalVarDeclDefineList;
    }

    public void setGlobalVarDeclDefineList(GlobalVarDeclDefineList GlobalVarDeclDefineList) {
        this.GlobalVarDeclDefineList=GlobalVarDeclDefineList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(GlobalVarDeclDefineList!=null) GlobalVarDeclDefineList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(GlobalVarDeclDefineList!=null) GlobalVarDeclDefineList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(GlobalVarDeclDefineList!=null) GlobalVarDeclDefineList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarDeclDefineList!=null)
            buffer.append(GlobalVarDeclDefineList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDecl]");
        return buffer.toString();
    }
}
