// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class ConstVal_Bool extends ConstVal {

    private String Bc;

    public ConstVal_Bool (String Bc) {
        this.Bc=Bc;
    }

    public String getBc() {
        return Bc;
    }

    public void setBc(String Bc) {
        this.Bc=Bc;
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
        buffer.append("ConstVal_Bool(\n");

        buffer.append(" "+tab+Bc);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstVal_Bool]");
        return buffer.toString();
    }
}
