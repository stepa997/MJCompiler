package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import jdk.nashorn.internal.ir.Assignment;
import jdk.nashorn.internal.ir.FunctionCall;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
import sun.font.CompositeFontDescriptor;

public class CodeGenerator extends VisitorAdaptor {

	private int mainPc;
	private int znak=0;
	
	public int getMainPc() {
		return mainPc;
	}
	
	Logger log = Logger.getLogger(getClass());
	
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
public CodeGenerator() {
		
		Tab.ordObj.setAdr(Code.pc);
		// Generate the entry.
		Code.put(Code.enter);
		Code.put(Tab.ordObj.getLevel());
		Code.put(Tab.ordObj.getLocalSymbols().size());
		
		Code.put(Code.load_n);
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Tab.chrObj.setAdr(Code.pc);
		// Generate the entry.
		Code.put(Code.enter);
		Code.put(Tab.chrObj.getLevel());
		Code.put(Tab.chrObj.getLocalSymbols().size());
		
		Code.put(Code.load_n);
		
		Code.put(Code.exit);
		Code.put(Code.return_);
		
		Tab.lenObj.setAdr(Code.pc);
		// Generate the entry.
		Code.put(Code.enter);
		Code.put(Tab.lenObj.getLevel());
		Code.put(Tab.lenObj.getLocalSymbols().size());
		
		Code.put(Code.load_n);
		Code.put(Code.arraylength);
		
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(Statement_print print) {
		if (print.getExpr().obj.getType() == Tab.charType) {
			Code.loadConst(1);
			Code.put(Code.bprint);
		} else {
			Code.loadConst(5);
			Code.put(Code.print);
		}
  	}
	
	public void visit(Statement_numconst numconst) {
		Code.loadConst(numconst.getN2());
		if(numconst.getExpr().obj.getType() == Tab.charType) {
			Code.put(Code.bprint);
		} else {
			Code.put(Code.print);
		}
	}
	
	public void visit(Statement_read read) {
		if(read.getDesignator().obj.getType() == Tab.charType) {
			Code.put(Code.bread);
		} else {
			Code.put(Code.read);
		}
		Code.store(read.getDesignator().obj);
	}
	
	public void visit(FactorNum cnst) {
		Obj con = Tab.insert(Obj.Con, "$", cnst.obj.getType());
		con.setLevel(0);
		con.setAdr(cnst.getN1());
		
		Code.load(con);
	}
	
	public void visit(FactorChar cnst) {
		Code.loadConst(cnst.getC1());
	}
	
	public void visit(VoidType_Void type) {
		if("main".equalsIgnoreCase(type.getMethodName())) {
			mainPc = Code.pc;
		}
		type.obj.setAdr(Code.pc);
		//Entry
		Code.put(Code.enter);
		Code.put(0);
		Code.put(type.obj.getLocalSymbols().size());
	}
	
	public void visit(VoidType_Type type) {
		type.obj.setAdr(Code.pc);
		//Entry
		Code.put(Code.enter);
		Code.put(0);
		Code.put(type.obj.getLocalSymbols().size());
	}
	
	public void visit(MethodDecl MethodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(ConstVal_Num num) {
		Code.loadConst(num.getNc());
	}
	
	public void visit(ConstVal_Char num) {
		Code.loadConst(num.getCc());
	}
	
	public void visit(ConstVal_Bool bool) {
		Code.loadConst(bool.getBc().equals("true")? 1:0);
	}
	
	public void visit(FactorBool bool) {
		Code.loadConst(bool.getB1().equals("true")? 1:0);
	}
	
	public void visit(FactorDesignator designator) {
		//Code.load(designator.getDesignator().obj);
	}
	
	public void visit(FactorDesignatorConst func) {
		Code.put(Code.call);
		Code.put2(func.getDesignator().obj.getAdr() - Code.pc);
	}
	
	public void visit(ExprList addExpr) {
		if (addExpr.getAddopLeft() instanceof Addop_add) {
			Code.put(Code.add);
		}
		else
			Code.put(Code.sub);
	}
	
	public void visit(ExprTermMinus minus) {
		Code.put(Code.neg);
	}
	
	public void visit(TermFactor mulFact) {
		if (mulFact.getMulopLeft() instanceof Mulop_mul)
			Code.put(Code.mul);
		else if (mulFact.getMulopLeft() instanceof Mulop_div)
			Code.put(Code.div);
		else
			Code.put(Code.rem);
	}
	
	public void visit(NewType1 array) {
		Code.put(Code.newarray);
		if(array.getType().struct == Tab.charType) {
			Code.put(0);
		} else {
			Code.put(1);
		}
	}
	
	
	
	public void visit(DesignatorStatement_Plus plus) {
		/*if(plus.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}*/
		/*Code.load(plus.getDesignator().obj);*/
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(plus.getDesignator().obj);
	}
	
	public void visit(DesignatorStatement_Minus plus) {
		/*if(plus.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}
		Code.load(plus.getDesignator().obj);*/
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(plus.getDesignator().obj);
	}
	
	
	public void visit(DesignatorStatement_Expr ass) {
		Code.store(ass.getDesignator().obj);
	}
	
	public void visit(DesignatorStatement_Expr_addRight ass) {
		if(ass.getAddopRight() instanceof AddopRight_add)
		Code.put(Code.add);
		else Code.put(Code.sub);
		Code.store(ass.getDesignator().obj);
	}
	
	public void visit(DesignatorStatement_Expr_mulRigth ass) {
		if(ass.getMulopRight() instanceof MulopRight_mul)
			Code.put(Code.mul);
		else if(ass.getMulopRight() instanceof MulopRight_div)
			Code.put(Code.div);
		else Code.put(Code.rem);
		Code.store(ass.getDesignator().obj);
	}
	
	public void visit(AddopRight_add_ass ass) {
		//Code.put(Code.dup);
	}
	
	public void visit(AddopRight_sub_ass ass) {
		//Code.put(Code.dup);
	}
	public void visit(MulopRight_mul_ass ass) {
		//Code.put(Code.dup);
	}
	
	public void visit(MulopRight_div_ass ass) {
		//Code.put(Code.dup);
	}
	public void visit(MulopRight_proc_ass ass) {
		//Code.put(Code.dup);
	}
	
	public void visit(AddopRight_add ass) {
		//Code.put(Code.dup);
	}
	
	public void visit(MulopRight_mul ass) {
		//Code.put(Code.dup);
	}
	public void visit(AddopRight_sub ass) {
		//Code.put(Code.dup);
	}
	
	public void visit(MulopRight_div ass) {
		//Code.put(Code.dup);
	}
	public void visit(MulopRight_proc ass) {
		//Code.put(Code.dup);
	}
	
	public void visit(ExprRight ass) {
		if (ass.getAddopRight() instanceof AddopRight_add)
			Code.put(Code.add);
		else if (ass.getAddopRight() instanceof AddopRight_sub)
			Code.put(Code.sub);
		Code.put(Code.dup);
		Code.store(ass.getExprLeft().obj);
	}
	
	public void visit(TermRight_term ass) {
		if (ass.getMulopRight() instanceof MulopRight_mul)
			Code.put(Code.mul);
		else if (ass.getMulopRight() instanceof MulopRight_div)
			Code.put(Code.div);
		else if (ass.getMulopRight() instanceof MulopRight_proc)
			Code.put(Code.rem);
		Code.put(Code.dup);
		Code.store(ass.getTermLeft().obj);
	}
	
	/*public void visit(FactorDesignator Expr) {
		Code.load(Expr.getDesignator().obj);
	}/*/
	
	/*public void visit(DesignatorStatement_Right ass) {
		/*Obj obj = null;
		Code.store(obj);
		if(ass.getAddopRight() instanceof AddopRight_add) {
			Code.load(ass.getDesignator().obj);
			//Code.load(obj);
			Code.put(Code.add);
			Code.put(Code.dup);
		} else {
			Code.load(ass.getDesignator().obj);
			//Code.load(obj);
			Code.put(Code.sub);
			Code.put(Code.dup);
		}
		Code.put(Code.neg);
		Code.store(ass.getDesignator().obj);
	}*/
	
	public void visit(DesignatorIdent ident) {
		SyntaxNode parent = ident.getParent();
		
		if(ArrayOnly.class != parent.getClass()) {
			Code.load(ident.obj);
			
		} 
		
		if(DesignatorTar.class == parent.getClass()) {
			/*Code.loadConst(90);
			Code.loadConst(90);*/
		}
		
	}
	
	public void visit(DesignatorExpr exp) {
		SyntaxNode parent = exp.getParent();
		if(DesignatorStatement_Expr.class != parent.getClass()) {
			/*if(DesignatorStatement_Expr_add.class == parent.getClass() || DesignatorStatement_Expr_addst.class == parent.getClass()
					|| DesignatorStatement_Expr_mul.class == parent.getClass() || DesignatorStatement_Expr_mulst.class == parent.getClass()
					|| DesignatorStatement_Plus.class == parent.getClass() || DesignatorStatement_Plus.class == parent.getClass()) {
				Code.put(Code.dup2);
			}*/
			if(DesignatorStatement_Expr_addRight.class == parent.getClass() || DesignatorStatement_Expr_mulRigth.class == parent.getClass()
					|| DesignatorStatement_Plus.class == parent.getClass() || DesignatorStatement_Minus.class == parent.getClass()) {
				Code.put(Code.dup2);
			}
			Code.load(exp.obj);
		}
		//Code.load(exp.obj);
	}
	
	public void visit(ArrayOnly designator) {
		
		Code.load(designator.getDesignator().obj);
	}
	
	/*public void visit(Ass_Addop_Right right) {
		if(right.getAddopRight() instanceof AddopRight_add) znak = 2;
		else if(right.getAddopRight() instanceof AddopRight_sub) znak = 3;
		
		
	}
	
	public void visit(Ass_Mulop_Right right) {
		if(right.getMulopRight() instanceof MulopRight_mul) znak = 4;
		else if(right.getMulopRight() instanceof MulopRight_div) znak = 5;
		else if(right.getMulopRight() instanceof MulopRight_proc) znak = 6;
	}*/
	
	/*public void visit(ExprRight right) {
		
	}*/
	
	/*public void visit(DesignatorStatement_Expr_Mulst expr) {
		
	}*/
	
	/*public void visit(DesignatorStatement_Expr_add exp) {
		if(exp.getAddopRight() instanceof AddopRight_add) Code.put(Code.add);
		else if(exp.getAddopRight() instanceof AddopRight_sub) Code.put(Code.sub);
		//Code.put(Code.dup);
		Code.store(exp.getDesignator().obj);
	}
	
	public void visit(DesignatorStatement_Expr_addst exp) {
		//Code.load(exp.getDesignator().obj);
		if(exp.getAddopRight() instanceof AddopRight_add) Code.put(Code.add);
		else if(exp.getAddopRight() instanceof AddopRight_sub) Code.put(Code.sub);
		//Code.put(Code.dup);
		Code.store(exp.getDesignator().obj);
	}
	
	public void visit(DesignatorStatement_Expr_mulst exp) {
		if(exp.getMulopRight() instanceof MulopRight_mul) Code.put(Code.mul);
		else if(exp.getMulopRight() instanceof MulopRight_div) Code.put(Code.div);
		else if(exp.getMulopRight() instanceof MulopRight_proc) Code.put(Code.rem);
		Code.put(Code.dup);
		Code.store(exp.getDesignator().obj);
		
	}
	
	public void visit(DesignatorStatement_Expr_mul exp) {
		if(exp.getMulopRight() instanceof MulopRight_mul) Code.put(Code.mul);
		else if(exp.getMulopRight() instanceof MulopRight_div) Code.put(Code.div);
		else if(exp.getMulopRight() instanceof MulopRight_proc) Code.put(Code.rem);
		Code.put(Code.dup);
		Code.store(exp.getDesignator().obj);
		
	}
	
	public void visit(Des_Assignop_Mul exp) {
		if(exp.getMulopRight() instanceof MulopRight_mul) Code.put(Code.mul);
		else if(exp.getMulopRight() instanceof MulopRight_div) Code.put(Code.div);
		else if(exp.getMulopRight() instanceof MulopRight_proc) Code.put(Code.rem);
		Code.put(Code.dup);
		Code.store(exp.getDesignator().obj);
	}*/
	
	public void visit(DesignatorArray desarr) {
		Code.put(Code.aload);
		Code.load(desarr.getDesignator1().obj);
		Code.put(Code.dup);
		Code.put(Code.arraylength);
		Code.load(desarr.getDesignator2().obj);
		Code.put(Code.sub);
		Code.put(Code.aload);
		Code.put(Code.add);
		Code.store(desarr.getDesignator().obj);
	}
	
	public void visit(DesignatorTar tar) {
		/*int n = tar.getFactor1().obj.getKind();
		Obj obj = tar.getFactor().obj;
		for(int i = 0; i < n; i++) {
			Code.load(tar.getFactor().obj);
			Code.loadConst(i);
			Code.store(obj);
			Code.load(obj);
			System.out.print(obj.getKind());*/
		
		/*Code.load(tar.getFactor1().obj);
		Code.loadConst(tar.getFactor().obj.getKind());
		Code.loadConst(65);
		Code.put(Code.sub);
		Code.loadConst(5);
		Code.put(Code.rem);
		Code.put(Code.baload);
		
		Code.store(tar.getDesignator().obj);*/
		
		Code.load(tar.getFactor1().obj);
		Code.loadConst(0);
		Code.put(Code.aload);
		Obj obj = tar.getFactor1().obj;
		Code.store(obj);
		
		System.out.print(tar.getDesignator().obj.getKind());
		
		/*Code.load(tar.getFactor1().obj);
		Code.loadConst(2);
		Code.put(Code.baload);
		Code.store(tar.getDesignator().obj);*/
	}
	
	public void visit(Modifikacija mod) {
		Code.loadConst(4);
		Code.put(Code.newarray);
		Code.put(0);
		Code.store(mod.getDesignator().obj);
		Code.put(Code.dup);
		Code.put(Code.dup);
		Code.put(Code.dup);
		//niz[0];
		Code.load(mod.getDesignator().obj);
		Code.loadConst(0);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		//Code.load(mod.getDesignator1().obj);
		Code.put(Code.bastore);
		//niz[1];
		Code.load(mod.getDesignator().obj);
		Code.loadConst(1);
		//Code.load(mod.getDesignator1().obj);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.loadConst(8);
		Code.put(Code.shr);
		Code.put(Code.bastore);
		//niz[2];
		Code.load(mod.getDesignator().obj);
		Code.loadConst(2);
		//Code.load(mod.getDesignator1().obj);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.loadConst(16);
		Code.put(Code.shr);
		Code.put(Code.bastore);
		//niz[3];
		Code.load(mod.getDesignator().obj);
		Code.loadConst(3);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		//Code.load(mod.getDesignator1().obj);
		Code.loadConst(24);
		Code.put(Code.shr);
		Code.put(Code.bastore);
	}
	
	public void visit(BoolModifikacija mod) {
		//0
		Code.load(mod.getDesignator1().obj);
		Code.loadConst(0);
		Code.put(Code.aload);
		//1
		Code.load(mod.getDesignator1().obj);
		Code.loadConst(1);
		Code.put(Code.aload);
		Code.loadConst(2);
		Code.put(Code.mul);
		Code.put(Code.add);
		//2
		Code.load(mod.getDesignator1().obj);
		Code.loadConst(2);
		Code.put(Code.aload);
		Code.loadConst(4);
		Code.put(Code.mul);
		Code.put(Code.add);
		//3
		Code.load(mod.getDesignator1().obj);
		Code.loadConst(3);
		Code.put(Code.aload);
		Code.loadConst(8);
		Code.put(Code.mul);
		Code.put(Code.add);
		//4
		Code.load(mod.getDesignator1().obj);
		Code.loadConst(4);
		Code.put(Code.aload);
		Code.loadConst(16);
		Code.put(Code.mul);
		Code.put(Code.add);
		//5
		Code.load(mod.getDesignator1().obj);
		Code.loadConst(5);
		Code.put(Code.aload);
		Code.loadConst(32);
		Code.put(Code.mul);
		Code.put(Code.add);
		//6
		Code.load(mod.getDesignator1().obj);
		Code.loadConst(6);
		Code.put(Code.aload);
		Code.loadConst(64);
		Code.put(Code.mul);
		Code.put(Code.add);
		//7
		Code.load(mod.getDesignator1().obj);
		Code.loadConst(7);
		Code.put(Code.aload);
		Code.loadConst(128);
		Code.put(Code.mul);
		Code.put(Code.add);
		Code.put(Code.eq);
		//store
		Code.store(mod.getDesignator().obj);
		
	}
}
