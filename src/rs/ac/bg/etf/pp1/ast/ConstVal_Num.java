// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:34


package rs.ac.bg.etf.pp1.ast;

public class ConstVal_Num extends ConstVal {

    private Integer Nc;

    public ConstVal_Num (Integer Nc) {
        this.Nc=Nc;
    }

    public Integer getNc() {
        return Nc;
    }

    public void setNc(Integer Nc) {
        this.Nc=Nc;
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
        buffer.append("ConstVal_Num(\n");

        buffer.append(" "+tab+Nc);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstVal_Num]");
        return buffer.toString();
    }
}
