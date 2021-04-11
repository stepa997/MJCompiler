// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class Des_Assignop_ADD extends DesignatorAssignop {

    private Designator Designator;
    private AddopRight AddopRight;

    public Des_Assignop_ADD (Designator Designator, AddopRight AddopRight) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.AddopRight=AddopRight;
        if(AddopRight!=null) AddopRight.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public AddopRight getAddopRight() {
        return AddopRight;
    }

    public void setAddopRight(AddopRight AddopRight) {
        this.AddopRight=AddopRight;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(AddopRight!=null) AddopRight.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(AddopRight!=null) AddopRight.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(AddopRight!=null) AddopRight.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Des_Assignop_ADD(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopRight!=null)
            buffer.append(AddopRight.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Des_Assignop_ADD]");
        return buffer.toString();
    }
}
