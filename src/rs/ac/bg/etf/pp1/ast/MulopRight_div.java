// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class MulopRight_div extends MulopRight {

    public MulopRight_div () {
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
        buffer.append("MulopRight_div(\n");

        buffer.append(tab);
        buffer.append(") [MulopRight_div]");
        return buffer.toString();
    }
}
