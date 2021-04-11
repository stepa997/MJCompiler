// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class VoidType_Void extends VoidType {

    private String MethodName;

    public VoidType_Void (String MethodName) {
        this.MethodName=MethodName;
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VoidType_Void(\n");

        buffer.append(" "+tab+MethodName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VoidType_Void]");
        return buffer.toString();
    }
}
