// Generated from java-escape by ANTLR 4.11.1

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link exprParser}.
 */
public interface exprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link exprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(exprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link exprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(exprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GameClass}
	 * labeled alternative in {@link exprParser#game}.
	 * @param ctx the parse tree
	 */
	void enterGameClass(exprParser.GameClassContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GameClass}
	 * labeled alternative in {@link exprParser#game}.
	 * @param ctx the parse tree
	 */
	void exitGameClass(exprParser.GameClassContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GameBody}
	 * labeled alternative in {@link exprParser#body}.
	 * @param ctx the parse tree
	 */
	void enterGameBody(exprParser.GameBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GameBody}
	 * labeled alternative in {@link exprParser#body}.
	 * @param ctx the parse tree
	 */
	void exitGameBody(exprParser.GameBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link exprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(exprParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link exprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(exprParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link exprParser#assi}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(exprParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link exprParser#assi}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(exprParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssiRMethodCall}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssiRMethodCall(exprParser.AssiRMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssiRMethodCall}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssiRMethodCall(exprParser.AssiRMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssiExprValues}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssiExprValues(exprParser.AssiExprValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssiExprValues}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssiExprValues(exprParser.AssiExprValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyMethod}
	 * labeled alternative in {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 */
	void enterMyMethod(exprParser.MyMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyMethod}
	 * labeled alternative in {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 */
	void exitMyMethod(exprParser.MyMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyReturnM}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMyReturnM(exprParser.MyReturnMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyReturnM}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void exitMyReturnM(exprParser.MyReturnMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyVoidM}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMyVoidM(exprParser.MyVoidMContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyVoidM}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void exitMyVoidM(exprParser.MyVoidMContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyReturnMethod}
	 * labeled alternative in {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 */
	void enterMyReturnMethod(exprParser.MyReturnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyReturnMethod}
	 * labeled alternative in {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 */
	void exitMyReturnMethod(exprParser.MyReturnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyVoidMethod}
	 * labeled alternative in {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 */
	void enterMyVoidMethod(exprParser.MyVoidMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyVoidMethod}
	 * labeled alternative in {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 */
	void exitMyVoidMethod(exprParser.MyVoidMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyMethodBody}
	 * labeled alternative in {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 */
	void enterMyMethodBody(exprParser.MyMethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyMethodBody}
	 * labeled alternative in {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 */
	void exitMyMethodBody(exprParser.MyMethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyParameter}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void enterMyParameter(exprParser.MyParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyParameter}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void exitMyParameter(exprParser.MyParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyMultiParameter}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void enterMyMultiParameter(exprParser.MyMultiParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyMultiParameter}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void exitMyMultiParameter(exprParser.MyMultiParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyNoParameter}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void enterMyNoParameter(exprParser.MyNoParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyNoParameter}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void exitMyNoParameter(exprParser.MyNoParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestCase}
	 * labeled alternative in {@link exprParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTestCase(exprParser.TestCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestCase}
	 * labeled alternative in {@link exprParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTestCase(exprParser.TestCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestMethodCall}
	 * labeled alternative in {@link exprParser#t_method_call}.
	 * @param ctx the parse tree
	 */
	void enterTestMethodCall(exprParser.TestMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestMethodCall}
	 * labeled alternative in {@link exprParser#t_method_call}.
	 * @param ctx the parse tree
	 */
	void exitTestMethodCall(exprParser.TestMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestChar}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterTestChar(exprParser.TestCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestChar}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitTestChar(exprParser.TestCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestEmpty}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterTestEmpty(exprParser.TestEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestEmpty}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitTestEmpty(exprParser.TestEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestVarName}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterTestVarName(exprParser.TestVarNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestVarName}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitTestVarName(exprParser.TestVarNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestNum}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterTestNum(exprParser.TestNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestNum}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitTestNum(exprParser.TestNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestDouble}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterTestDouble(exprParser.TestDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestDouble}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitTestDouble(exprParser.TestDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestInputs}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterTestInputs(exprParser.TestInputsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestInputs}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitTestInputs(exprParser.TestInputsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TestString}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterTestString(exprParser.TestStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TestString}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitTestString(exprParser.TestStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(exprParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(exprParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(exprParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(exprParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnMethodCall}
	 * labeled alternative in {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 */
	void enterReturnMethodCall(exprParser.ReturnMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnMethodCall}
	 * labeled alternative in {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 */
	void exitReturnMethodCall(exprParser.ReturnMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathNumber}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMathNumber(exprParser.MathNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathNumber}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMathNumber(exprParser.MathNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterAddition(exprParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitAddition(exprParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(exprParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(exprParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(exprParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(exprParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathDouble}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMathDouble(exprParser.MathDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathDouble}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMathDouble(exprParser.MathDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathParenthesis}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMathParenthesis(exprParser.MathParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathParenthesis}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMathParenthesis(exprParser.MathParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathVarName}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMathVarName(exprParser.MathVarNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathVarName}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMathVarName(exprParser.MathVarNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterDivision(exprParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitDivision(exprParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterLessOrEqual(exprParser.LessOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitLessOrEqual(exprParser.LessOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNegation(exprParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNegation(exprParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualTo(exprParser.NotEqualToContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualTo(exprParser.NotEqualToContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondVarName}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondVarName(exprParser.CondVarNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondVarName}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondVarName(exprParser.CondVarNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondEqual(exprParser.CondEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondEqual(exprParser.CondEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqualTo(exprParser.EqualToContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqualTo(exprParser.EqualToContext ctx);
	/**
	 * Enter a parse tree produced by the {@code More}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterMore(exprParser.MoreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code More}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitMore(exprParser.MoreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(exprParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(exprParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondBool}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondBool(exprParser.CondBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondBool}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondBool(exprParser.CondBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MoreOrEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterMoreOrEqual(exprParser.MoreOrEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MoreOrEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitMoreOrEqual(exprParser.MoreOrEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondNotEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondNotEqual(exprParser.CondNotEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondNotEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondNotEqual(exprParser.CondNotEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(exprParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(exprParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondParenthesis}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondParenthesis(exprParser.CondParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondParenthesis}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondParenthesis(exprParser.CondParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Less}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterLess(exprParser.LessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitLess(exprParser.LessContext ctx);
}