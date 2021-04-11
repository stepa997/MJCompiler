package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class SemanticPass extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	private Obj currentTypeObj = Tab.noObj;
	Obj currentMethod = null;
	boolean returnFound = false;
	Struct currentType;
	int nvars;
	
	public static final Struct boolType = new Struct(Struct.Bool);
	
	Logger log = Logger.getLogger(getClass());
	private boolean errorDetected = false;
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected  = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
    
    public void visit(ProgName progName) {
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program) {
    	nvars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    }
    
    public void visit(Type type) {
    	Obj typeNode = Tab.find(type.getTypeName());
    	if(typeNode == Tab.noObj) {
    		report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
    		type.struct = Tab.noType;
    	} else {
    		if(Obj.Type == typeNode.getKind()) {
    			type.struct = typeNode.getType();
    			//report_info("Detektovan type : " + typeNode, null);
    			
    		}else {
    			report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip|", type);
    			type.struct = Tab.noType;
    		}
    	}
    	currentType = type.struct;
    }
    
    public void visit(ConstDecl constDecl) {
        currentTypeObj = Tab.noObj;
	}
    
    public void visit(ConstValAssign constValAssign) {
        Obj valObj = constValAssign.getConstVal().obj;
       // if (valObj.getType().equals(currentTypeObj.getType())) {
            if (Tab.currentScope().findSymbol(constValAssign.getIname()) == null) {
                Obj temp = Tab.insert(valObj.getKind(), constValAssign.getIname(), valObj.getType());
                temp.setAdr(valObj.getAdr());

                if (temp.getLevel() == 0) {
                   // globalConstCnt++;
                }
            } else {
                report_error("Greska na " + constValAssign.getLine() + "(" + constValAssign.getIname() + ") vec deklarisano", null);
            }
       /* } else {
            report_error("Greska na " + constValAssign.getLine() + valObj.getType()  + ": nekompatibilni tipovi podataka", null);
        }*/
    }
    
    public void visit(ConstVal_Num constVal_num) {
        constVal_num.obj = new Obj(Obj.Con, "", Tab.intType, constVal_num.getNc(), Obj.NO_VALUE);
    }

    public void visit(ConstVal_Char constVal_char) {
        constVal_char.obj = new Obj(Obj.Con, "", Tab.charType, constVal_char.getCc(), Obj.NO_VALUE);
    }

    public void visit(ConstVal_Bool constVal_bool) {
        constVal_bool.obj = new Obj(Obj.Con, "", null , Boolean.valueOf(constVal_bool.getBc()) ? 1 : 0, Obj.NO_VALUE);
    }

    public void visit(VarDeclDefine_Single VarDeclDefine_Single) {
    	if(Tab.currentScope.findSymbol(VarDeclDefine_Single.getName())==null){
    		Tab.insert(Obj.Var, VarDeclDefine_Single.getName(), currentType);
    	}
    }
    
    public void visit(VarDeclDefine_Array VarDeclDefine_Array) {
    	if(Tab.currentScope.findSymbol(VarDeclDefine_Array.getName())==null){
    		Tab.insert(Obj.Var, VarDeclDefine_Array.getName(), new Struct(Struct.Array, currentType));
    	}
    }
    
    
    
    public void visit(VoidType_Void VoidType_Void) {
    	if(Tab.currentScope.findSymbol(VoidType_Void.getMethodName())==null) {
    		currentMethod = Tab.insert(Obj.Meth, VoidType_Void.getMethodName(), Tab.noType);
    		VoidType_Void.obj = currentMethod;
    	}else {
    		currentMethod = new Obj(Obj.Meth, VoidType_Void.getMethodName(), Tab.noType);
    		report_error("Ime metode vec postoji " + VoidType_Void.getMethodName(), VoidType_Void);
    	}
    	Tab.openScope();
    }
    
    public void visit(VoidType_Type VoidType_Type) {
    	if(Tab.currentScope.findSymbol(VoidType_Type.getMethodName())==null) {
    		currentMethod = Tab.insert(Obj.Meth, VoidType_Type.getMethodName(), VoidType_Type.getType().struct);
    		VoidType_Type.obj = currentMethod;
    	}else {
    		currentMethod = new Obj(Obj.Meth, VoidType_Type.getMethodName(), VoidType_Type.getType().struct);
    		report_error("Ime metode vec postoji " + VoidType_Type.getMethodName(), VoidType_Type);
    	}
    	Tab.openScope();
    }
    
    public void visit(MethodDecl MethodDecl) {
    	if(!returnFound && currentMethod.getType() != Tab.noType) {
    		report_error("Funkcija " + currentMethod.getName() + " nema retrun!", MethodDecl);
    	} 
    		Tab.chainLocalSymbols(currentMethod);
    		Tab.closeScope();
    		returnFound = false;
    		currentMethod = null;
    	
    }
    
    public void visit(Statement_print print) {
  		Obj str = print.getExpr().obj;
  		if(!Tab.intType.assignableTo(str.getType()) && !Tab.charType.assignableTo(str.getType())) {
  			report_error("Greska na liniji " + print.getLine() + " : "
  					+ " los tip varijable ", null);
  		}
  		printCallCount++;
  	}
    
    public void visit(Statement_read Statement_read) {
    	Obj obj = Statement_read.getDesignator().obj;
		int kind = obj.getKind();
		if (!(kind == Obj.Var || kind == Obj.Fld || kind == Obj.Elem)) {
			report_error("Greska na liniji " + Statement_read.getLine() + " : "
					+ " nije dobar tip za designator ", null);
		}
		if (!(Tab.intType.assignableTo(obj.getType()) || Tab.charType.assignableTo(obj.getType()) ))
			report_error("Greska na liniji " + Statement_read.getLine() + " : "
					+ " los tip varijable ", null);
    }
    
    
    public void visit(DesignatorStatement_Plus DesignatorStatement_Plus) { 
    	Obj obj = DesignatorStatement_Plus.getDesignator().obj;
    	if(obj.getKind()!=Obj.Elem && obj.getKind()!=Obj.Fld && obj.getKind()!=Obj.Var) {
    		report_error("Greska na liniji " + DesignatorStatement_Plus.getLine() + " : "
					+ " nije odgovarajuci tip designatora za dodelu vrednosti ", null);
    	}
    	if(!Tab.intType.assignableTo(obj.getType())) {
    		report_error("Greska na liniji " + DesignatorStatement_Plus.getLine() + " : " + " nekompatibilni tipovi u dodeli vrednosti ",null);
    	}
    }
    
    public void visit(DesignatorStatement_Minus DesignatorStatement_Minus) { 
    	Obj obj = DesignatorStatement_Minus.getDesignator().obj;
    	if(obj.getKind()!=Obj.Elem && obj.getKind()!=Obj.Fld && obj.getKind()!=Obj.Var) {
    		report_error("Greska na liniji " + DesignatorStatement_Minus.getLine() + " : "
					+ " nije odgovarajuci tip designatora za dodelu vrednosti ", null);
    	}
    	if(!Tab.intType.assignableTo(obj.getType())) {
    		report_error("Greska na liniji " + DesignatorStatement_Minus.getLine() + " : " + " nekompatibilni tipovi u dodeli vrednosti ",null);
    	}
    }
    
    public void visit(DesignatorStatement_Expr DesignatorStatement_Expr) {
    	Obj obj = DesignatorStatement_Expr.getDesignator().obj;
    	//DesignatorStatement_Expr.getDesignator().obj.setLevel(DesignatorStatement_Expr.getExpr().obj.getKind()); 
    	if(obj.getKind()==Obj.Elem || obj.getKind()==Obj.Fld || obj.getKind()==Obj.Var) {
    		/*if(!DesignatorStatement_Expr.getExprLeft().struct.assignableTo(obj.getType())) {
        		report_error("Greska na liniji " + DesignatorStatement_Expr.getLine() + " : " +  " nekompatibilni tipovi u dodeli vrednosti " ,null);
       
        	}*/
    	}
    	
    }
    
  
    
    public void visit(DesignatorIdent DesignatorIdent) {
    	Obj obj = Tab.find(DesignatorIdent.getIDName());
    	if(obj == Tab.noObj) {
    		report_error("Greska na liniji " + DesignatorIdent.getLine() + " : ime " + DesignatorIdent.getIDName()
			+ " nije deklarisano! ", null);
    	}
    	DesignatorIdent.obj = obj;
    }
    
    public void visit(DesignatorExpr DesignatorExpr) {
    	Struct str = DesignatorExpr.getArrayOnly().getDesignator().obj.getType();
    	if(str.getKind() != Struct.Array) {
    		report_error("Greska na liniji " + DesignatorExpr.getLine() + " : designator nije tipa niza ", null);
    	}else {
    		DumpSymbolTableVisitor printer = new DumpSymbolTableVisitor();
			printer.visitObjNode(DesignatorExpr.getArrayOnly().getDesignator().obj);
			report_info("Detektovan pristup elementu niza : " + printer.getOutput(), DesignatorExpr);
    	}
    	DesignatorExpr.obj = new Obj(Obj.Elem,"Element", str.getElemType());
    	//DesignatorExpr.obj.setLevel(DesignatorExpr.getArrayOnly().getDesignator().obj.getKind());
    	Obj s = DesignatorExpr.getExpr().obj;
    	if(!Tab.intType.assignableTo(s.getType())) {
    		report_error("Greska na liniji " + DesignatorExpr.getLine() + " : indeks niza nije tipa int ", null);
    	}
    }
    
    public void visit(LeftExpr exp) {
    	exp.obj = exp.getExprLeft().obj;
    }
    
    public void visit(ExprRight exp) {
    	exp.obj = exp.getExprLeft().obj;
    }
    
    public void visit(ExprTerm Term) {
    	Term.obj = Term.getTerm().obj;
    }
    
    public void visit(TermLeft_term term) {
    	term.obj = term.getTermLeft().obj;
    }
    
    public void visit(ExprTermMinus Term) {
    	Obj t = Term.getTerm().obj;
    	if(!Tab.intType.assignableTo(t.getType())) {
    		report_error("Greska na liniji " + Term.getLine() + " : nekompatibilni tipovi u izrazu za sabiranje."
					+ t.getKind(), null);
    	} else {
    		Term.obj = Term.getTerm().obj;
    	}
    }
    
    public void visit(ExprList ExprTerm) {
    	Obj t = ExprTerm.getTermLeft().obj;
    	Obj tt = ExprTerm.getExprLeft().obj;
    	if(Tab.intType.assignableTo(t.getType()) && Tab.intType.assignableTo(tt.getType())) {
			ExprTerm.obj = tt;
    	} else {
    		//ExprTerm.obj. = Tab.noType;
    		ExprTerm.obj = new Obj(0, "", Tab.noType);
    		report_error("Greska na liniji " + Tab.intType + " : nekompatibilni tipovi u izrazu za sabiranjeeee."
					+ t.getKind(), null);
    	}
    }
    
    public void visit(TermOne Factor) {
    	Factor.obj = Factor.getFactor().obj;
    }
    
    public void visit(TermFactor Factor) {
    	Obj t = Factor.getTermLeft().obj;
    	Obj tt = Factor.getFactor().obj;
    	if(!Tab.intType.assignableTo(t.getType()) && !Tab.intType.assignableTo(tt.getType())) {
    		report_error("Greska na liniji " + Factor.getLine() + " : nekompatibilni tipovi u izrazu za mnozenje."
					+ t.getKind(), null);
			//Factor.struct = Tab.noType;
			Factor.obj = new Obj(Factor.obj.getKind(), "", Tab.noType);
    	} else {
    		Factor.obj = tt;
    	}
    }
    
    public void visit(FactorDesignator FactorDesignator) {
    	FactorDesignator.obj = FactorDesignator.getDesignator().obj;
    }
    
    public void visit(FactorNum FactorNum) {
    	FactorNum.obj = new Obj(FactorNum.getN1(), "", Tab.intType);
    }
    
    public void visit(FactorChar FactorChar) {
    	FactorChar.obj = new Obj(FactorChar.getC1(), "", Tab.charType);
    }
    
    
    
    public void visit(FactorBool FactorBool) {
    	FactorBool.obj = new Obj(0, "", boolType);
    }
    
    public void visit(FactorExpr FactorExpr) {
    	FactorExpr.obj = FactorExpr.getExpr().obj;
    }
    
    public void visit(FactorDesignatorConst Des) {
    	if(Des.getDesignator().obj.getKind() != Obj.Meth) {
    		report_error("Greska na liniji " + Des.getLine() + " : " + " ovo nije ime funkcije ", Des);
    	}
    }
    
    public void visit(NewType1 Exp) {
    	Obj t = Exp.getExpr().obj;
    	if(!Tab.intType.assignableTo(t.getType())) {
    		report_error("Greska na liniji " + Exp.getLine() + " : " + " ovo nije tip int ", Exp);
    	}
    	//Exp.struct = new Struct(Struct.Array, Exp.getType().struct);
    	Exp.obj = new Obj(Obj.Elem, "", Tab.intType);
    }
    
    public void visit(NewType0 Tp){
    	Tp.obj = new Obj(0, "",Tp.getType().struct);
    }
    
    public void vist(DesignatorArray desarr) {
    	if(Tab.intType.assignableTo(desarr.getDesignator2().obj.getType())) {
    		report_info("JESTE INT", null);
    	}
    }
    
}
