// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class Addop_left extends Addop {

    private AddopLeft AddopLeft;

    public Addop_left (AddopLeft AddopLeft) {
        this.AddopLeft=AddopLeft;
        if(AddopLeft!=null) AddopLeft.setParent(this);
    }

    public AddopLeft getAddopLeft() {
        return AddopLeft;
    }

    public void setAddopLeft(AddopLeft AddopLeft) {
        this.AddopLeft=AddopLeft;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddopLeft!=null) AddopLeft.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopLeft!=null) AddopLeft.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopLeft!=null) AddopLeft.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Addop_left(\n");

        if(AddopLeft!=null)
            buffer.append(AddopLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Addop_left]");
        return buffer.toString();
    }
}
