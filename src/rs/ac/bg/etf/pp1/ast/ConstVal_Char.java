// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class ConstVal_Char extends ConstVal {

    private Character Cc;

    public ConstVal_Char (Character Cc) {
        this.Cc=Cc;
    }

    public Character getCc() {
        return Cc;
    }

    public void setCc(Character Cc) {
        this.Cc=Cc;
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
        buffer.append("ConstVal_Char(\n");

        buffer.append(" "+tab+Cc);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstVal_Char]");
        return buffer.toString();
    }
}
