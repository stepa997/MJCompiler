// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class VarDeclDefine_Single extends VarDeclDefine {

    private String Name;

    public VarDeclDefine_Single (String Name) {
        this.Name=Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name=Name;
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
        buffer.append("VarDeclDefine_Single(\n");

        buffer.append(" "+tab+Name);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclDefine_Single]");
        return buffer.toString();
    }
}
