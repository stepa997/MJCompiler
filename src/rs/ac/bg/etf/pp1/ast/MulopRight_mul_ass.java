// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class MulopRight_mul_ass extends Assignop {

    public MulopRight_mul_ass () {
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
        buffer.append("MulopRight_mul_ass(\n");

        buffer.append(tab);
        buffer.append(") [MulopRight_mul_ass]");
        return buffer.toString();
    }
}
