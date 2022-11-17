// Generated from /Users/cy/Desktop/4302Project/Project/src/antlr/expr.g4 by ANTLR 4.9.2

	package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, VOIDCALL=29, DATA_TYPE=30, VOID_TYPE=31, 
		BOOL=32, TEST_NAME=33, VAR_NAME=34, CLASS_NAME=35, METHODNAME=36, DOUBLE=37, 
		NUM=38, CHAR=39, STRING=40, COMMENT=41, WS=42;
	public static final int
		RULE_prog = 0, RULE_game = 1, RULE_body = 2, RULE_decl = 3, RULE_assi = 4, 
		RULE_expr = 5, RULE_mymethod = 6, RULE_method_type = 7, RULE_method_body = 8, 
		RULE_parameter = 9, RULE_param = 10, RULE_multi_param = 11, RULE_test = 12, 
		RULE_t_method_call = 13, RULE_r_method_call = 14, RULE_v_method_call = 15, 
		RULE_call_parameter = 16, RULE_input = 17, RULE_multiInput = 18, RULE_if_statement = 19, 
		RULE_value = 20, RULE_math = 21, RULE_cond = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "game", "body", "decl", "assi", "expr", "mymethod", "method_type", 
			"method_body", "parameter", "param", "multi_param", "test", "t_method_call", 
			"r_method_call", "v_method_call", "call_parameter", "input", "multiInput", 
			"if_statement", "value", "math", "cond"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'game'", "'['", "']'", "'!'", "'<<'", "'<-'", "'mymethod'", "'jackieReturns'", 
			"','", "'test'", "'.'", "'jackieAsks'", "'elseJackie'", "'('", "')'", 
			"'+'", "'-'", "'*'", "'/'", "'not'", "'&&'", "'||'", "'=='", "'/='", 
			"'>='", "'<='", "'>'", "'<'", "'void_'", null, "'VOID'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "VOIDCALL", "DATA_TYPE", "VOID_TYPE", "BOOL", 
			"TEST_NAME", "VAR_NAME", "CLASS_NAME", "METHODNAME", "DOUBLE", "NUM", 
			"CHAR", "STRING", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public exprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramContext extends ProgContext {
		public TerminalNode EOF() { return getToken(exprParser.EOF, 0); }
		public GameContext game() {
			return getRuleContext(GameContext.class,0);
		}
		public List<TestContext> test() {
			return getRuleContexts(TestContext.class);
		}
		public TestContext test(int i) {
			return getRuleContext(TestContext.class,i);
		}
		public ProgramContext(ProgContext ctx) { copyFrom(ctx); }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new ProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(46);
				game();
				}
				break;
			case T__9:
				{
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(47);
					test();
					}
					}
					setState(50); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__9 );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(54);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GameContext extends ParserRuleContext {
		public GameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_game; }
	 
		public GameContext() { }
		public void copyFrom(GameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GameClassContext extends GameContext {
		public TerminalNode CLASS_NAME() { return getToken(exprParser.CLASS_NAME, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public GameClassContext(GameContext ctx) { copyFrom(ctx); }
	}

	public final GameContext game() throws RecognitionException {
		GameContext _localctx = new GameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_game);
		try {
			_localctx = new GameClassContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__0);
			setState(57);
			match(CLASS_NAME);
			setState(58);
			match(T__1);
			setState(59);
			match(T__2);
			setState(60);
			match(T__3);
			setState(61);
			body();
			setState(62);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	 
		public BodyContext() { }
		public void copyFrom(BodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GameBodyContext extends BodyContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<AssiContext> assi() {
			return getRuleContexts(AssiContext.class);
		}
		public AssiContext assi(int i) {
			return getRuleContext(AssiContext.class,i);
		}
		public List<MymethodContext> mymethod() {
			return getRuleContexts(MymethodContext.class);
		}
		public MymethodContext mymethod(int i) {
			return getRuleContext(MymethodContext.class,i);
		}
		public GameBodyContext(BodyContext ctx) { copyFrom(ctx); }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_body);
		int _la;
		try {
			int _alt;
			_localctx = new GameBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(64);
					decl();
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(70);
				assi();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(76);
				mymethod();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	 
		public DeclContext() { }
		public void copyFrom(DeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationContext extends DeclContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public TerminalNode DATA_TYPE() { return getToken(exprParser.DATA_TYPE, 0); }
		public DeclarationContext(DeclContext ctx) { copyFrom(ctx); }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decl);
		try {
			_localctx = new DeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(VAR_NAME);
			setState(83);
			match(T__4);
			setState(84);
			match(DATA_TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssiContext extends ParserRuleContext {
		public AssiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assi; }
	 
		public AssiContext() { }
		public void copyFrom(AssiContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentContext extends AssiContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(AssiContext ctx) { copyFrom(ctx); }
	}

	public final AssiContext assi() throws RecognitionException {
		AssiContext _localctx = new AssiContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assi);
		try {
			_localctx = new AssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(VAR_NAME);
			setState(87);
			match(T__5);
			setState(88);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RMethodCallContext extends ExprContext {
		public R_method_callContext r_method_call() {
			return getRuleContext(R_method_callContext.class,0);
		}
		public RMethodCallContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ValuesContext extends ExprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ValuesContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case METHODNAME:
				_localctx = new RMethodCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				r_method_call();
				}
				break;
			case T__13:
			case BOOL:
			case VAR_NAME:
			case DOUBLE:
			case NUM:
			case CHAR:
			case STRING:
				_localctx = new ValuesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MymethodContext extends ParserRuleContext {
		public MymethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mymethod; }
	 
		public MymethodContext() { }
		public void copyFrom(MymethodContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MyMethodsContext extends MymethodContext {
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public Method_typeContext method_type() {
			return getRuleContext(Method_typeContext.class,0);
		}
		public MyMethodsContext(MymethodContext ctx) { copyFrom(ctx); }
	}

	public final MymethodContext mymethod() throws RecognitionException {
		MymethodContext _localctx = new MymethodContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mymethod);
		try {
			_localctx = new MyMethodsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__6);
			setState(95);
			match(METHODNAME);
			setState(96);
			method_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_typeContext extends ParserRuleContext {
		public Method_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_type; }
	 
		public Method_typeContext() { }
		public void copyFrom(Method_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MyVoidMethodContext extends Method_typeContext {
		public TerminalNode VOID_TYPE() { return getToken(exprParser.VOID_TYPE, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public Method_bodyContext method_body() {
			return getRuleContext(Method_bodyContext.class,0);
		}
		public MyVoidMethodContext(Method_typeContext ctx) { copyFrom(ctx); }
	}
	public static class MyReturnMethodContext extends Method_typeContext {
		public TerminalNode DATA_TYPE() { return getToken(exprParser.DATA_TYPE, 0); }
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public Method_bodyContext method_body() {
			return getRuleContext(Method_bodyContext.class,0);
		}
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public MyReturnMethodContext(Method_typeContext ctx) { copyFrom(ctx); }
	}

	public final Method_typeContext method_type() throws RecognitionException {
		Method_typeContext _localctx = new Method_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_method_type);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_TYPE:
				_localctx = new MyReturnMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(DATA_TYPE);
				setState(99);
				match(T__1);
				setState(100);
				parameter();
				setState(101);
				match(T__2);
				setState(102);
				match(T__3);
				setState(103);
				method_body();
				setState(104);
				match(T__7);
				setState(105);
				match(VAR_NAME);
				setState(106);
				match(T__3);
				}
				break;
			case VOID_TYPE:
				_localctx = new MyVoidMethodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(VOID_TYPE);
				setState(109);
				match(T__1);
				setState(110);
				parameter();
				setState(111);
				match(T__2);
				setState(112);
				match(T__3);
				setState(113);
				method_body();
				setState(114);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_bodyContext extends ParserRuleContext {
		public Method_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_body; }
	 
		public Method_bodyContext() { }
		public void copyFrom(Method_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MyMethodBodyContext extends Method_bodyContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<AssiContext> assi() {
			return getRuleContexts(AssiContext.class);
		}
		public AssiContext assi(int i) {
			return getRuleContext(AssiContext.class,i);
		}
		public List<If_statementContext> if_statement() {
			return getRuleContexts(If_statementContext.class);
		}
		public If_statementContext if_statement(int i) {
			return getRuleContext(If_statementContext.class,i);
		}
		public List<R_method_callContext> r_method_call() {
			return getRuleContexts(R_method_callContext.class);
		}
		public R_method_callContext r_method_call(int i) {
			return getRuleContext(R_method_callContext.class,i);
		}
		public List<V_method_callContext> v_method_call() {
			return getRuleContexts(V_method_callContext.class);
		}
		public V_method_callContext v_method_call(int i) {
			return getRuleContext(V_method_callContext.class,i);
		}
		public MyMethodBodyContext(Method_bodyContext ctx) { copyFrom(ctx); }
	}

	public final Method_bodyContext method_body() throws RecognitionException {
		Method_bodyContext _localctx = new Method_bodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_method_body);
		int _la;
		try {
			int _alt;
			_localctx = new MyMethodBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(118);
					decl();
					}
					} 
				}
				setState(123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(124);
				assi();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(130);
				if_statement();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOIDCALL || _la==METHODNAME) {
				{
				setState(138);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case METHODNAME:
					{
					setState(136);
					r_method_call();
					}
					break;
				case VOIDCALL:
					{
					setState(137);
					v_method_call();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	 
		public ParameterContext() { }
		public void copyFrom(ParameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleParamContext extends ParameterContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public SingleParamContext(ParameterContext ctx) { copyFrom(ctx); }
	}
	public static class EmptyParamContext extends ParameterContext {
		public EmptyParamContext(ParameterContext ctx) { copyFrom(ctx); }
	}
	public static class MultiParamContext extends ParameterContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public List<Multi_paramContext> multi_param() {
			return getRuleContexts(Multi_paramContext.class);
		}
		public Multi_paramContext multi_param(int i) {
			return getRuleContext(Multi_paramContext.class,i);
		}
		public MultiParamContext(ParameterContext ctx) { copyFrom(ctx); }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter);
		int _la;
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new SingleParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				param();
				}
				break;
			case 2:
				_localctx = new MultiParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				param();
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					multi_param();
					}
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__8 );
				}
				break;
			case 3:
				_localctx = new EmptyParamContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParamsContext extends ParamContext {
		public TerminalNode DATA_TYPE() { return getToken(exprParser.DATA_TYPE, 0); }
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public ParamsContext(ParamContext ctx) { copyFrom(ctx); }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_param);
		try {
			_localctx = new ParamsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(DATA_TYPE);
			setState(154);
			match(VAR_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multi_paramContext extends ParserRuleContext {
		public Multi_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multi_param; }
	 
		public Multi_paramContext() { }
		public void copyFrom(Multi_paramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultiParamChildContext extends Multi_paramContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public MultiParamChildContext(Multi_paramContext ctx) { copyFrom(ctx); }
	}

	public final Multi_paramContext multi_param() throws RecognitionException {
		Multi_paramContext _localctx = new Multi_paramContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_multi_param);
		try {
			_localctx = new MultiParamChildContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__8);
			setState(157);
			param();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TestContext extends ParserRuleContext {
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
	 
		public TestContext() { }
		public void copyFrom(TestContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TestCaseContext extends TestContext {
		public TerminalNode TEST_NAME() { return getToken(exprParser.TEST_NAME, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<AssiContext> assi() {
			return getRuleContexts(AssiContext.class);
		}
		public AssiContext assi(int i) {
			return getRuleContext(AssiContext.class,i);
		}
		public List<T_method_callContext> t_method_call() {
			return getRuleContexts(T_method_callContext.class);
		}
		public T_method_callContext t_method_call(int i) {
			return getRuleContext(T_method_callContext.class,i);
		}
		public TestCaseContext(TestContext ctx) { copyFrom(ctx); }
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_test);
		int _la;
		try {
			int _alt;
			_localctx = new TestCaseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__9);
			setState(160);
			match(TEST_NAME);
			setState(161);
			match(T__1);
			setState(162);
			match(T__2);
			setState(163);
			match(T__3);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(164);
					decl();
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(170);
				assi();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS_NAME) {
				{
				{
				setState(176);
				t_method_call();
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class T_method_callContext extends ParserRuleContext {
		public T_method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t_method_call; }
	 
		public T_method_callContext() { }
		public void copyFrom(T_method_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TestMethodCallContext extends T_method_callContext {
		public TerminalNode CLASS_NAME() { return getToken(exprParser.CLASS_NAME, 0); }
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public Call_parameterContext call_parameter() {
			return getRuleContext(Call_parameterContext.class,0);
		}
		public TestMethodCallContext(T_method_callContext ctx) { copyFrom(ctx); }
	}

	public final T_method_callContext t_method_call() throws RecognitionException {
		T_method_callContext _localctx = new T_method_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_t_method_call);
		try {
			_localctx = new TestMethodCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(CLASS_NAME);
			setState(185);
			match(T__10);
			setState(186);
			match(METHODNAME);
			setState(187);
			match(T__1);
			setState(188);
			call_parameter();
			setState(189);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class R_method_callContext extends ParserRuleContext {
		public R_method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r_method_call; }
	 
		public R_method_callContext() { }
		public void copyFrom(R_method_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnMethodCallContext extends R_method_callContext {
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public Call_parameterContext call_parameter() {
			return getRuleContext(Call_parameterContext.class,0);
		}
		public ReturnMethodCallContext(R_method_callContext ctx) { copyFrom(ctx); }
	}

	public final R_method_callContext r_method_call() throws RecognitionException {
		R_method_callContext _localctx = new R_method_callContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_r_method_call);
		try {
			_localctx = new ReturnMethodCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(METHODNAME);
			setState(192);
			match(T__1);
			setState(193);
			call_parameter();
			setState(194);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class V_method_callContext extends ParserRuleContext {
		public V_method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_v_method_call; }
	 
		public V_method_callContext() { }
		public void copyFrom(V_method_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VoidMethodCallContext extends V_method_callContext {
		public TerminalNode VOIDCALL() { return getToken(exprParser.VOIDCALL, 0); }
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public Call_parameterContext call_parameter() {
			return getRuleContext(Call_parameterContext.class,0);
		}
		public VoidMethodCallContext(V_method_callContext ctx) { copyFrom(ctx); }
	}

	public final V_method_callContext v_method_call() throws RecognitionException {
		V_method_callContext _localctx = new V_method_callContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_v_method_call);
		try {
			_localctx = new VoidMethodCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(VOIDCALL);
			setState(197);
			match(METHODNAME);
			setState(198);
			match(T__1);
			setState(199);
			call_parameter();
			setState(200);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_parameterContext extends ParserRuleContext {
		public Call_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_parameter; }
	 
		public Call_parameterContext() { }
		public void copyFrom(Call_parameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallParameterContext extends Call_parameterContext {
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public CallParameterContext(Call_parameterContext ctx) { copyFrom(ctx); }
	}
	public static class CallEmptyParameterContext extends Call_parameterContext {
		public CallEmptyParameterContext(Call_parameterContext ctx) { copyFrom(ctx); }
	}
	public static class CallMultiParameterContext extends Call_parameterContext {
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public List<MultiInputContext> multiInput() {
			return getRuleContexts(MultiInputContext.class);
		}
		public MultiInputContext multiInput(int i) {
			return getRuleContext(MultiInputContext.class,i);
		}
		public CallMultiParameterContext(Call_parameterContext ctx) { copyFrom(ctx); }
	}

	public final Call_parameterContext call_parameter() throws RecognitionException {
		Call_parameterContext _localctx = new Call_parameterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_call_parameter);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new CallParameterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				input();
				}
				break;
			case 2:
				_localctx = new CallMultiParameterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				input();
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(204);
					multiInput();
					}
					}
					setState(207); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__8 );
				}
				break;
			case 3:
				_localctx = new CallEmptyParameterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CallParamMathContext extends InputContext {
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public CallParamMathContext(InputContext ctx) { copyFrom(ctx); }
	}
	public static class CallParamCondContext extends InputContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CallParamCondContext(InputContext ctx) { copyFrom(ctx); }
	}
	public static class CallParamCharContext extends InputContext {
		public TerminalNode CHAR() { return getToken(exprParser.CHAR, 0); }
		public CallParamCharContext(InputContext ctx) { copyFrom(ctx); }
	}
	public static class CallParamStringContext extends InputContext {
		public TerminalNode STRING() { return getToken(exprParser.STRING, 0); }
		public CallParamStringContext(InputContext ctx) { copyFrom(ctx); }
	}
	public static class CallParamDoubleContext extends InputContext {
		public TerminalNode DOUBLE() { return getToken(exprParser.DOUBLE, 0); }
		public CallParamDoubleContext(InputContext ctx) { copyFrom(ctx); }
	}
	public static class CallParamNumContext extends InputContext {
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public CallParamNumContext(InputContext ctx) { copyFrom(ctx); }
	}
	public static class CallParamVarNameContext extends InputContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public CallParamVarNameContext(InputContext ctx) { copyFrom(ctx); }
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_input);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new CallParamMathContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				math(0);
				}
				break;
			case 2:
				_localctx = new CallParamCondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				cond(0);
				}
				break;
			case 3:
				_localctx = new CallParamVarNameContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				match(VAR_NAME);
				}
				break;
			case 4:
				_localctx = new CallParamDoubleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				match(DOUBLE);
				}
				break;
			case 5:
				_localctx = new CallParamNumContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(216);
				match(NUM);
				}
				break;
			case 6:
				_localctx = new CallParamCharContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(217);
				match(CHAR);
				}
				break;
			case 7:
				_localctx = new CallParamStringContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(218);
				match(STRING);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiInputContext extends ParserRuleContext {
		public MultiInputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiInput; }
	 
		public MultiInputContext() { }
		public void copyFrom(MultiInputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MultipleInputContext extends MultiInputContext {
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public MultipleInputContext(MultiInputContext ctx) { copyFrom(ctx); }
	}

	public final MultiInputContext multiInput() throws RecognitionException {
		MultiInputContext _localctx = new MultiInputContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_multiInput);
		try {
			_localctx = new MultipleInputContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__8);
			setState(222);
			input();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statementContext extends ParserRuleContext {
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	 
		public If_statementContext() { }
		public void copyFrom(If_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatementContext extends If_statementContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<Method_bodyContext> method_body() {
			return getRuleContexts(Method_bodyContext.class);
		}
		public Method_bodyContext method_body(int i) {
			return getRuleContext(Method_bodyContext.class,i);
		}
		public IfStatementContext(If_statementContext ctx) { copyFrom(ctx); }
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_if_statement);
		try {
			_localctx = new IfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__11);
			setState(225);
			match(T__1);
			setState(226);
			cond(0);
			setState(227);
			match(T__2);
			setState(228);
			match(T__3);
			setState(229);
			method_body();
			setState(230);
			match(T__3);
			setState(231);
			match(T__12);
			setState(232);
			match(T__3);
			setState(233);
			method_body();
			setState(234);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	 
		public ValueContext() { }
		public void copyFrom(ValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueDoubleContext extends ValueContext {
		public TerminalNode DOUBLE() { return getToken(exprParser.DOUBLE, 0); }
		public ValueDoubleContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueCharContext extends ValueContext {
		public TerminalNode CHAR() { return getToken(exprParser.CHAR, 0); }
		public ValueCharContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueMathContext extends ValueContext {
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public ValueMathContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueNumContext extends ValueContext {
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public ValueNumContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueStringContext extends ValueContext {
		public TerminalNode STRING() { return getToken(exprParser.STRING, 0); }
		public ValueStringContext(ValueContext ctx) { copyFrom(ctx); }
	}
	public static class ValueBoolContext extends ValueContext {
		public TerminalNode BOOL() { return getToken(exprParser.BOOL, 0); }
		public ValueBoolContext(ValueContext ctx) { copyFrom(ctx); }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value);
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new ValueDoubleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(DOUBLE);
				}
				break;
			case 2:
				_localctx = new ValueNumContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				match(NUM);
				}
				break;
			case 3:
				_localctx = new ValueStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new ValueCharContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(239);
				match(CHAR);
				}
				break;
			case 5:
				_localctx = new ValueBoolContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
				match(BOOL);
				}
				break;
			case 6:
				_localctx = new ValueMathContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(241);
				math(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathContext extends ParserRuleContext {
		public MathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_math; }
	 
		public MathContext() { }
		public void copyFrom(MathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MathNumberContext extends MathContext {
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public MathNumberContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class AdditionContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public AdditionContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class MultiplicationContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public MultiplicationContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class SubtractionContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public SubtractionContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class MathDoubleContext extends MathContext {
		public TerminalNode DOUBLE() { return getToken(exprParser.DOUBLE, 0); }
		public MathDoubleContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class MathParenthesisContext extends MathContext {
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public MathParenthesisContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class MathVarNameContext extends MathContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public MathVarNameContext(MathContext ctx) { copyFrom(ctx); }
	}
	public static class DivisionContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public DivisionContext(MathContext ctx) { copyFrom(ctx); }
	}

	public final MathContext math() throws RecognitionException {
		return math(0);
	}

	private MathContext math(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MathContext _localctx = new MathContext(_ctx, _parentState);
		MathContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_math, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				{
				_localctx = new MathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(245);
				match(T__13);
				setState(246);
				math(0);
				setState(247);
				match(T__14);
				}
				break;
			case NUM:
				{
				_localctx = new MathNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(NUM);
				}
				break;
			case DOUBLE:
				{
				_localctx = new MathDoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(250);
				match(DOUBLE);
				}
				break;
			case VAR_NAME:
				{
				_localctx = new MathVarNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(VAR_NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(266);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(254);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(255);
						match(T__15);
						setState(256);
						math(8);
						}
						break;
					case 2:
						{
						_localctx = new SubtractionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(257);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(258);
						match(T__16);
						setState(259);
						math(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicationContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(260);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(261);
						match(T__17);
						setState(262);
						math(6);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(263);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(264);
						match(T__18);
						setState(265);
						math(5);
						}
						break;
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LessOrEqualContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public LessOrEqualContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class NegationContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public NegationContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class NotEqualToContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public NotEqualToContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondVarNameContext extends CondContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public CondVarNameContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondEqualContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public CondEqualContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class EqualToContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public EqualToContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class MoreContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public MoreContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class DisjunctionContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public DisjunctionContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondBoolContext extends CondContext {
		public TerminalNode BOOL() { return getToken(exprParser.BOOL, 0); }
		public CondBoolContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class MoreOrEqualContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public MoreOrEqualContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondNotEqualContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public CondNotEqualContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class ConjunctionContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public ConjunctionContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class CondParenthesisContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondParenthesisContext(CondContext ctx) { copyFrom(ctx); }
	}
	public static class LessContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public LessContext(CondContext ctx) { copyFrom(ctx); }
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(272);
				match(T__19);
				setState(273);
				cond(14);
				}
				break;
			case 2:
				{
				_localctx = new CondParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(T__13);
				setState(275);
				cond(0);
				setState(276);
				match(T__14);
				}
				break;
			case 3:
				{
				_localctx = new CondBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(BOOL);
				}
				break;
			case 4:
				{
				_localctx = new CondEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(279);
				math(0);
				setState(280);
				match(T__22);
				setState(281);
				math(0);
				}
				break;
			case 5:
				{
				_localctx = new CondNotEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				math(0);
				setState(284);
				match(T__23);
				setState(285);
				math(0);
				}
				break;
			case 6:
				{
				_localctx = new MoreOrEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				math(0);
				setState(288);
				match(T__24);
				setState(289);
				math(0);
				}
				break;
			case 7:
				{
				_localctx = new LessOrEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				math(0);
				setState(292);
				match(T__25);
				setState(293);
				math(0);
				}
				break;
			case 8:
				{
				_localctx = new MoreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295);
				math(0);
				setState(296);
				match(T__26);
				setState(297);
				math(0);
				}
				break;
			case 9:
				{
				_localctx = new LessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(299);
				math(0);
				setState(300);
				match(T__27);
				setState(301);
				math(0);
				}
				break;
			case 10:
				{
				_localctx = new CondVarNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(VAR_NAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(318);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(306);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(307);
						match(T__20);
						setState(308);
						cond(13);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(309);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(310);
						match(T__21);
						setState(311);
						cond(12);
						}
						break;
					case 3:
						{
						_localctx = new EqualToContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(312);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(313);
						match(T__22);
						setState(314);
						cond(11);
						}
						break;
					case 4:
						{
						_localctx = new NotEqualToContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(315);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(316);
						match(T__23);
						setState(317);
						cond(10);
						}
						break;
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return math_sempred((MathContext)_localctx, predIndex);
		case 22:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean math_sempred(MathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0146\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\6"+
		"\2\63\n\2\r\2\16\2\64\5\2\67\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\7\4D\n\4\f\4\16\4G\13\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\7\4P\n"+
		"\4\f\4\16\4S\13\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\5\7_\n\7\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\tw\n\t\3\n\7\nz\n\n\f\n\16\n}\13\n\3\n\7\n\u0080\n\n"+
		"\f\n\16\n\u0083\13\n\3\n\7\n\u0086\n\n\f\n\16\n\u0089\13\n\3\n\3\n\7\n"+
		"\u008d\n\n\f\n\16\n\u0090\13\n\3\13\3\13\3\13\6\13\u0095\n\13\r\13\16"+
		"\13\u0096\3\13\5\13\u009a\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u00a8\n\16\f\16\16\16\u00ab\13\16\3\16\7\16\u00ae"+
		"\n\16\f\16\16\16\u00b1\13\16\3\16\7\16\u00b4\n\16\f\16\16\16\u00b7\13"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\6\22\u00d0\n\22\r\22"+
		"\16\22\u00d1\3\22\5\22\u00d5\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5"+
		"\23\u00de\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00f5\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00ff\n\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u010d\n\27\f\27\16\27\u0110"+
		"\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0133\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0141\n\30\f\30\16\30\u0144\13"+
		"\30\3\30\2\4,.\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\2"+
		"\2\u0162\2\66\3\2\2\2\4:\3\2\2\2\6E\3\2\2\2\bT\3\2\2\2\nX\3\2\2\2\f^\3"+
		"\2\2\2\16`\3\2\2\2\20v\3\2\2\2\22{\3\2\2\2\24\u0099\3\2\2\2\26\u009b\3"+
		"\2\2\2\30\u009e\3\2\2\2\32\u00a1\3\2\2\2\34\u00ba\3\2\2\2\36\u00c1\3\2"+
		"\2\2 \u00c6\3\2\2\2\"\u00d4\3\2\2\2$\u00dd\3\2\2\2&\u00df\3\2\2\2(\u00e2"+
		"\3\2\2\2*\u00f4\3\2\2\2,\u00fe\3\2\2\2.\u0132\3\2\2\2\60\67\5\4\3\2\61"+
		"\63\5\32\16\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2"+
		"\65\67\3\2\2\2\66\60\3\2\2\2\66\62\3\2\2\2\678\3\2\2\289\7\2\2\39\3\3"+
		"\2\2\2:;\7\3\2\2;<\7%\2\2<=\7\4\2\2=>\7\5\2\2>?\7\6\2\2?@\5\6\4\2@A\7"+
		"\6\2\2A\5\3\2\2\2BD\5\b\5\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FK"+
		"\3\2\2\2GE\3\2\2\2HJ\5\n\6\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L"+
		"Q\3\2\2\2MK\3\2\2\2NP\5\16\b\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2"+
		"R\7\3\2\2\2SQ\3\2\2\2TU\7$\2\2UV\7\7\2\2VW\7 \2\2W\t\3\2\2\2XY\7$\2\2"+
		"YZ\7\b\2\2Z[\5\f\7\2[\13\3\2\2\2\\_\5\36\20\2]_\5*\26\2^\\\3\2\2\2^]\3"+
		"\2\2\2_\r\3\2\2\2`a\7\t\2\2ab\7&\2\2bc\5\20\t\2c\17\3\2\2\2de\7 \2\2e"+
		"f\7\4\2\2fg\5\24\13\2gh\7\5\2\2hi\7\6\2\2ij\5\22\n\2jk\7\n\2\2kl\7$\2"+
		"\2lm\7\6\2\2mw\3\2\2\2no\7!\2\2op\7\4\2\2pq\5\24\13\2qr\7\5\2\2rs\7\6"+
		"\2\2st\5\22\n\2tu\7\6\2\2uw\3\2\2\2vd\3\2\2\2vn\3\2\2\2w\21\3\2\2\2xz"+
		"\5\b\5\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\u0081\3\2\2\2}{\3\2"+
		"\2\2~\u0080\5\n\6\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2"+
		"\u0081\u0082\3\2\2\2\u0082\u0087\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0086"+
		"\5(\25\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u008e\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008d\5\36"+
		"\20\2\u008b\u008d\5 \21\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2\2\u008d"+
		"\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\23\3\2\2"+
		"\2\u0090\u008e\3\2\2\2\u0091\u009a\5\26\f\2\u0092\u0094\5\26\f\2\u0093"+
		"\u0095\5\30\r\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3"+
		"\2\2\2\u0096\u0097\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0091\3\2\2\2\u0099\u0092\3\2\2\2\u0099\u0098\3\2\2\2\u009a\25\3\2\2"+
		"\2\u009b\u009c\7 \2\2\u009c\u009d\7$\2\2\u009d\27\3\2\2\2\u009e\u009f"+
		"\7\13\2\2\u009f\u00a0\5\26\f\2\u00a0\31\3\2\2\2\u00a1\u00a2\7\f\2\2\u00a2"+
		"\u00a3\7#\2\2\u00a3\u00a4\7\4\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00a9\7\6"+
		"\2\2\u00a6\u00a8\5\b\5\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00af\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ac\u00ae\5\n\6\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b5\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00b4\5\34\17\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b8\u00b9\7\6\2\2\u00b9\33\3\2\2\2\u00ba\u00bb\7%\2\2\u00bb\u00bc"+
		"\7\r\2\2\u00bc\u00bd\7&\2\2\u00bd\u00be\7\4\2\2\u00be\u00bf\5\"\22\2\u00bf"+
		"\u00c0\7\5\2\2\u00c0\35\3\2\2\2\u00c1\u00c2\7&\2\2\u00c2\u00c3\7\4\2\2"+
		"\u00c3\u00c4\5\"\22\2\u00c4\u00c5\7\5\2\2\u00c5\37\3\2\2\2\u00c6\u00c7"+
		"\7\37\2\2\u00c7\u00c8\7&\2\2\u00c8\u00c9\7\4\2\2\u00c9\u00ca\5\"\22\2"+
		"\u00ca\u00cb\7\5\2\2\u00cb!\3\2\2\2\u00cc\u00d5\5$\23\2\u00cd\u00cf\5"+
		"$\23\2\u00ce\u00d0\5&\24\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d5\3\2"+
		"\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00cd\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"#\3\2\2\2\u00d6\u00de\5,\27\2\u00d7\u00de\5.\30\2\u00d8\u00de\7$\2\2\u00d9"+
		"\u00de\7\'\2\2\u00da\u00de\7(\2\2\u00db\u00de\7)\2\2\u00dc\u00de\7*\2"+
		"\2\u00dd\u00d6\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00d8\3\2\2\2\u00dd\u00d9"+
		"\3\2\2\2\u00dd\u00da\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de"+
		"%\3\2\2\2\u00df\u00e0\7\13\2\2\u00e0\u00e1\5$\23\2\u00e1\'\3\2\2\2\u00e2"+
		"\u00e3\7\16\2\2\u00e3\u00e4\7\4\2\2\u00e4\u00e5\5.\30\2\u00e5\u00e6\7"+
		"\5\2\2\u00e6\u00e7\7\6\2\2\u00e7\u00e8\5\22\n\2\u00e8\u00e9\7\6\2\2\u00e9"+
		"\u00ea\7\17\2\2\u00ea\u00eb\7\6\2\2\u00eb\u00ec\5\22\n\2\u00ec\u00ed\7"+
		"\6\2\2\u00ed)\3\2\2\2\u00ee\u00f5\7\'\2\2\u00ef\u00f5\7(\2\2\u00f0\u00f5"+
		"\7*\2\2\u00f1\u00f5\7)\2\2\u00f2\u00f5\7\"\2\2\u00f3\u00f5\5,\27\2\u00f4"+
		"\u00ee\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f4\u00f0\3\2\2\2\u00f4\u00f1\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5+\3\2\2\2\u00f6\u00f7"+
		"\b\27\1\2\u00f7\u00f8\7\20\2\2\u00f8\u00f9\5,\27\2\u00f9\u00fa\7\21\2"+
		"\2\u00fa\u00ff\3\2\2\2\u00fb\u00ff\7(\2\2\u00fc\u00ff\7\'\2\2\u00fd\u00ff"+
		"\7$\2\2\u00fe\u00f6\3\2\2\2\u00fe\u00fb\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe"+
		"\u00fd\3\2\2\2\u00ff\u010e\3\2\2\2\u0100\u0101\f\t\2\2\u0101\u0102\7\22"+
		"\2\2\u0102\u010d\5,\27\n\u0103\u0104\f\b\2\2\u0104\u0105\7\23\2\2\u0105"+
		"\u010d\5,\27\t\u0106\u0107\f\7\2\2\u0107\u0108\7\24\2\2\u0108\u010d\5"+
		",\27\b\u0109\u010a\f\6\2\2\u010a\u010b\7\25\2\2\u010b\u010d\5,\27\7\u010c"+
		"\u0100\3\2\2\2\u010c\u0103\3\2\2\2\u010c\u0106\3\2\2\2\u010c\u0109\3\2"+
		"\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"-\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\b\30\1\2\u0112\u0113\7\26\2"+
		"\2\u0113\u0133\5.\30\20\u0114\u0115\7\20\2\2\u0115\u0116\5.\30\2\u0116"+
		"\u0117\7\21\2\2\u0117\u0133\3\2\2\2\u0118\u0133\7\"\2\2\u0119\u011a\5"+
		",\27\2\u011a\u011b\7\31\2\2\u011b\u011c\5,\27\2\u011c\u0133\3\2\2\2\u011d"+
		"\u011e\5,\27\2\u011e\u011f\7\32\2\2\u011f\u0120\5,\27\2\u0120\u0133\3"+
		"\2\2\2\u0121\u0122\5,\27\2\u0122\u0123\7\33\2\2\u0123\u0124\5,\27\2\u0124"+
		"\u0133\3\2\2\2\u0125\u0126\5,\27\2\u0126\u0127\7\34\2\2\u0127\u0128\5"+
		",\27\2\u0128\u0133\3\2\2\2\u0129\u012a\5,\27\2\u012a\u012b\7\35\2\2\u012b"+
		"\u012c\5,\27\2\u012c\u0133\3\2\2\2\u012d\u012e\5,\27\2\u012e\u012f\7\36"+
		"\2\2\u012f\u0130\5,\27\2\u0130\u0133\3\2\2\2\u0131\u0133\7$\2\2\u0132"+
		"\u0111\3\2\2\2\u0132\u0114\3\2\2\2\u0132\u0118\3\2\2\2\u0132\u0119\3\2"+
		"\2\2\u0132\u011d\3\2\2\2\u0132\u0121\3\2\2\2\u0132\u0125\3\2\2\2\u0132"+
		"\u0129\3\2\2\2\u0132\u012d\3\2\2\2\u0132\u0131\3\2\2\2\u0133\u0142\3\2"+
		"\2\2\u0134\u0135\f\16\2\2\u0135\u0136\7\27\2\2\u0136\u0141\5.\30\17\u0137"+
		"\u0138\f\r\2\2\u0138\u0139\7\30\2\2\u0139\u0141\5.\30\16\u013a\u013b\f"+
		"\f\2\2\u013b\u013c\7\31\2\2\u013c\u0141\5.\30\r\u013d\u013e\f\13\2\2\u013e"+
		"\u013f\7\32\2\2\u013f\u0141\5.\30\f\u0140\u0134\3\2\2\2\u0140\u0137\3"+
		"\2\2\2\u0140\u013a\3\2\2\2\u0140\u013d\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143/\3\2\2\2\u0144\u0142\3\2\2\2"+
		"\35\64\66EKQ^v{\u0081\u0087\u008c\u008e\u0096\u0099\u00a9\u00af\u00b5"+
		"\u00d1\u00d4\u00dd\u00f4\u00fe\u010c\u010e\u0132\u0140\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}