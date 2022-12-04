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
	 * Enter a parse tree produced by the {@code RMethodCall}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRMethodCall(exprParser.RMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RMethodCall}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRMethodCall(exprParser.RMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Values}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterValues(exprParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Values}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitValues(exprParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyMethods}
	 * labeled alternative in {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 */
	void enterMyMethods(exprParser.MyMethodsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyMethods}
	 * labeled alternative in {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 */
	void exitMyMethods(exprParser.MyMethodsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyReturnMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMyReturnMethod(exprParser.MyReturnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyReturnMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void exitMyReturnMethod(exprParser.MyReturnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MyVoidMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMyVoidMethod(exprParser.MyVoidMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MyVoidMethod}
	 * labeled alternative in {@link exprParser#method_type}.
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
	 * Enter a parse tree produced by the {@code Deterministic_Loop}
	 * labeled alternative in {@link exprParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterDeterministic_Loop(exprParser.Deterministic_LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Deterministic_Loop}
	 * labeled alternative in {@link exprParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitDeterministic_Loop(exprParser.Deterministic_LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterSingleParam(exprParser.SingleParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitSingleParam(exprParser.SingleParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterMultiParam(exprParser.MultiParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitMultiParam(exprParser.MultiParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterEmptyParam(exprParser.EmptyParamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitEmptyParam(exprParser.EmptyParamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Params}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParams(exprParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Params}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParams(exprParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiParamChild}
	 * labeled alternative in {@link exprParser#multi_param}.
	 * @param ctx the parse tree
	 */
	void enterMultiParamChild(exprParser.MultiParamChildContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiParamChild}
	 * labeled alternative in {@link exprParser#multi_param}.
	 * @param ctx the parse tree
	 */
	void exitMultiParamChild(exprParser.MultiParamChildContext ctx);
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
	 * Enter a parse tree produced by the {@code ReturnMethodCall}
	 * labeled alternative in {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 */
	void enterReturnMethodCall(exprParser.ReturnMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnMethodCall}
	 * labeled alternative in {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 */
	void exitReturnMethodCall(exprParser.ReturnMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidMethodCall}
	 * labeled alternative in {@link exprParser#v_method_call}.
	 * @param ctx the parse tree
	 */
	void enterVoidMethodCall(exprParser.VoidMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidMethodCall}
	 * labeled alternative in {@link exprParser#v_method_call}.
	 * @param ctx the parse tree
	 */
	void exitVoidMethodCall(exprParser.VoidMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallParameter}
	 * labeled alternative in {@link exprParser#call_parameter}.
	 * @param ctx the parse tree
	 */
	void enterCallParameter(exprParser.CallParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallParameter}
	 * labeled alternative in {@link exprParser#call_parameter}.
	 * @param ctx the parse tree
	 */
	void exitCallParameter(exprParser.CallParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallMultiParameter}
	 * labeled alternative in {@link exprParser#call_parameter}.
	 * @param ctx the parse tree
	 */
	void enterCallMultiParameter(exprParser.CallMultiParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallMultiParameter}
	 * labeled alternative in {@link exprParser#call_parameter}.
	 * @param ctx the parse tree
	 */
	void exitCallMultiParameter(exprParser.CallMultiParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallEmptyParameter}
	 * labeled alternative in {@link exprParser#call_parameter}.
	 * @param ctx the parse tree
	 */
	void enterCallEmptyParameter(exprParser.CallEmptyParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallEmptyParameter}
	 * labeled alternative in {@link exprParser#call_parameter}.
	 * @param ctx the parse tree
	 */
	void exitCallEmptyParameter(exprParser.CallEmptyParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallParamVarName}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCallParamVarName(exprParser.CallParamVarNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallParamVarName}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCallParamVarName(exprParser.CallParamVarNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallParamDouble}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCallParamDouble(exprParser.CallParamDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallParamDouble}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCallParamDouble(exprParser.CallParamDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallParamNum}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCallParamNum(exprParser.CallParamNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallParamNum}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCallParamNum(exprParser.CallParamNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallParamChar}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCallParamChar(exprParser.CallParamCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallParamChar}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCallParamChar(exprParser.CallParamCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallParamString}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCallParamString(exprParser.CallParamStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallParamString}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCallParamString(exprParser.CallParamStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallParamBoolean}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCallParamBoolean(exprParser.CallParamBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallParamBoolean}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCallParamBoolean(exprParser.CallParamBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultipleInput}
	 * labeled alternative in {@link exprParser#multiInput}.
	 * @param ctx the parse tree
	 */
	void enterMultipleInput(exprParser.MultipleInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultipleInput}
	 * labeled alternative in {@link exprParser#multiInput}.
	 * @param ctx the parse tree
	 */
	void exitMultipleInput(exprParser.MultipleInputContext ctx);
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
	 * Enter a parse tree produced by the {@code ValueDouble}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueDouble(exprParser.ValueDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueDouble}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueDouble(exprParser.ValueDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueNum}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueNum(exprParser.ValueNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueNum}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueNum(exprParser.ValueNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueString}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueString(exprParser.ValueStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueString}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueString(exprParser.ValueStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueChar}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueChar(exprParser.ValueCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueChar}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueChar(exprParser.ValueCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueBool}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueBool(exprParser.ValueBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBool}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueBool(exprParser.ValueBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueMath}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValueMath(exprParser.ValueMathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueMath}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValueMath(exprParser.ValueMathContext ctx);
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