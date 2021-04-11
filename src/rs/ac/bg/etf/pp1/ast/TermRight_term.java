// generated with ast extension for cup
// version 0.8
// 8/8/2020 13:32:35


package rs.ac.bg.etf.pp1.ast;

public class TermRight_term extends Term {

    private TermLeft TermLeft;
    private MulopRight MulopRight;
    private Term Term;

    public TermRight_term (TermLeft TermLeft, MulopRight MulopRight, Term Term) {
        this.TermLeft=TermLeft;
        if(TermLeft!=null) TermLeft.setParent(this);
        this.MulopRight=MulopRight;
        if(MulopRight!=null) MulopRight.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public TermLeft getTermLeft() {
        return TermLeft;
    }

    public void setTermLeft(TermLeft TermLeft) {
        this.TermLeft=TermLeft;
    }

    public MulopRight getMulopRight() {
        return MulopRight;
    }

    public void setMulopRight(MulopRight MulopRight) {
        this.MulopRight=MulopRight;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TermLeft!=null) TermLeft.accept(visitor);
        if(MulopRight!=null) MulopRight.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TermLeft!=null) TermLeft.traverseTopDown(visitor);
        if(MulopRight!=null) MulopRight.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TermLeft!=null) TermLeft.traverseBottomUp(visitor);
        if(MulopRight!=null) MulopRight.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TermRight_term(\n");

        if(TermLeft!=null)
            buffer.append(TermLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MulopRight!=null)
            buffer.append(MulopRight.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TermRight_term]");
        return buffer.toString();
    }
}
