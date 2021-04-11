// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class VoidType_Type extends VoidType {

    private Type Type;
    private String MethodName;

    public VoidType_Type (Type Type, String MethodName) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.MethodName=MethodName;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getMethodName() {
        return MethodName;
    }

    public void setMethodName(String MethodName) {
        this.MethodName=MethodName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VoidType_Type(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+MethodName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VoidType_Type]");
        return buffer.toString();
    }
}
