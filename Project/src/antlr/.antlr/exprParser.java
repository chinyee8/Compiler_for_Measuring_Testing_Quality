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
		RULE_loop = 9, RULE_parameter = 10, RULE_param = 11, RULE_multi_param = 12, 
		RULE_test = 13, RULE_t_method_call = 14, RULE_r_method_call = 15, RULE_v_method_call = 16, 
		RULE_call_parameter = 17, RULE_input = 18, RULE_multiInput = 19, RULE_if_statement = 20, 
		RULE_value = 21, RULE_math = 22, RULE_cond = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "game", "body", "decl", "assi", "expr", "mymethod", "method_type", 
			"method_body", "loop", "parameter", "param", "multi_param", "test", "t_method_call", 
			"r_method_call", "v_method_call", "call_parameter", "input", "multiInput", 
			"if_statement", "value", "math", "cond"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'game'", "'!'", "'<<'", "'<-'", "'mymethod'", "'['", "']'", "'jackieReturns'", 
			"'loop'", "'('", "')'", "','", "'test'", "'jackieAsks'", "'elseJackie'", 
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
		public TestContext test() {
			return getRuleContext(TestContext.class,0);
		}
		public ProgramContext(ProgContext ctx) { copyFrom(ctx); }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			_localctx = new ProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(48);
				game();
				}
				break;
			case T__12:
				{
				setState(49);
				test();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(52);
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
			setState(54);
			match(T__0);
			setState(55);
			match(CLASS_NAME);
			setState(56);
			match(T__1);
			setState(57);
			body();
			setState(58);
			match(T__1);
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
			_localctx = new GameBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(60);
				mymethod();
				}
				}
				setState(65);
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
			setState(66);
			match(VAR_NAME);
			setState(67);
			match(T__2);
			setState(68);
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
			setState(70);
			match(VAR_NAME);
			setState(71);
			match(T__3);
			setState(72);
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
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case METHODNAME:
				_localctx = new RMethodCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				r_method_call();
				}
				break;
			case T__9:
			case BOOL:
			case VAR_NAME:
			case DOUBLE:
			case NUM:
			case CHAR:
			case STRING:
				_localctx = new ValuesContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
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
			setState(78);
			match(T__4);
			setState(79);
			match(METHODNAME);
			setState(80);
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
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_TYPE:
				_localctx = new MyReturnMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(DATA_TYPE);
				setState(83);
				match(T__5);
				setState(84);
				parameter();
				setState(85);
				match(T__6);
				setState(86);
				match(T__1);
				setState(87);
				method_body();
				setState(88);
				match(T__7);
				setState(89);
				match(VAR_NAME);
				setState(90);
				match(T__1);
				}
				break;
			case VOID_TYPE:
				_localctx = new MyVoidMethodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(VOID_TYPE);
				setState(93);
				match(T__5);
				setState(94);
				parameter();
				setState(95);
				match(T__6);
				setState(96);
				match(T__1);
				setState(97);
				method_body();
				setState(98);
				match(T__1);
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
		public List<V_method_callContext> v_method_call() {
			return getRuleContexts(V_method_callContext.class);
		}
		public V_method_callContext v_method_call(int i) {
			return getRuleContext(V_method_callContext.class,i);
		}
		public List<LoopContext> loop() {
			return getRuleContexts(LoopContext.class);
		}
		public LoopContext loop(int i) {
			return getRuleContext(LoopContext.class,i);
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
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(102);
					decl();
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(108);
				assi();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__13) | (1L << VOIDCALL))) != 0)) {
				{
				setState(117);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__13:
					{
					setState(114);
					if_statement();
					}
					break;
				case VOIDCALL:
					{
					setState(115);
					v_method_call();
					}
					break;
				case T__8:
					{
					setState(116);
					loop();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(121);
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

	public static class LoopContext extends ParserRuleContext {
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
	 
		public LoopContext() { }
		public void copyFrom(LoopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Deterministic_LoopContext extends LoopContext {
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public Method_bodyContext method_body() {
			return getRuleContext(Method_bodyContext.class,0);
		}
		public Deterministic_LoopContext(LoopContext ctx) { copyFrom(ctx); }
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_loop);
		try {
			_localctx = new Deterministic_LoopContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__8);
			setState(123);
			match(T__9);
			setState(124);
			match(NUM);
			setState(125);
			match(T__10);
			setState(126);
			match(T__1);
			setState(127);
			method_body();
			setState(128);
			match(T__1);
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
		enterRule(_localctx, 20, RULE_parameter);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new SingleParamContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				param();
				}
				break;
			case 2:
				_localctx = new MultiParamContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				param();
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					multi_param();
					}
					}
					setState(135); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__11 );
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
		enterRule(_localctx, 22, RULE_param);
		try {
			_localctx = new ParamsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(DATA_TYPE);
			setState(141);
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
		enterRule(_localctx, 24, RULE_multi_param);
		try {
			_localctx = new MultiParamChildContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__11);
			setState(144);
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
		enterRule(_localctx, 26, RULE_test);
		int _la;
		try {
			int _alt;
			_localctx = new TestCaseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__12);
			setState(147);
			match(TEST_NAME);
			setState(148);
			match(T__1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(149);
					decl();
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(155);
				assi();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==METHODNAME) {
				{
				{
				setState(161);
				t_method_call();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			match(T__1);
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
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public Call_parameterContext call_parameter() {
			return getRuleContext(Call_parameterContext.class,0);
		}
		public TestMethodCallContext(T_method_callContext ctx) { copyFrom(ctx); }
	}

	public final T_method_callContext t_method_call() throws RecognitionException {
		T_method_callContext _localctx = new T_method_callContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_t_method_call);
		try {
			_localctx = new TestMethodCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(METHODNAME);
			setState(170);
			match(T__5);
			setState(171);
			call_parameter();
			setState(172);
			match(T__6);
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
		enterRule(_localctx, 30, RULE_r_method_call);
		try {
			_localctx = new ReturnMethodCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(METHODNAME);
			setState(175);
			match(T__5);
			setState(176);
			call_parameter();
			setState(177);
			match(T__6);
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
		enterRule(_localctx, 32, RULE_v_method_call);
		try {
			_localctx = new VoidMethodCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(VOIDCALL);
			setState(180);
			match(METHODNAME);
			setState(181);
			match(T__5);
			setState(182);
			call_parameter();
			setState(183);
			match(T__6);
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
		enterRule(_localctx, 34, RULE_call_parameter);
		int _la;
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new CallParameterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				input();
				}
				break;
			case 2:
				_localctx = new CallMultiParameterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				input();
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(187);
					multiInput();
					}
					}
					setState(190); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__11 );
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
	public static class CallParamBooleanContext extends InputContext {
		public TerminalNode BOOL() { return getToken(exprParser.BOOL, 0); }
		public CallParamBooleanContext(InputContext ctx) { copyFrom(ctx); }
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
		enterRule(_localctx, 36, RULE_input);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR_NAME:
				_localctx = new CallParamVarNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(VAR_NAME);
				}
				break;
			case DOUBLE:
				_localctx = new CallParamDoubleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(DOUBLE);
				}
				break;
			case NUM:
				_localctx = new CallParamNumContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				match(NUM);
				}
				break;
			case CHAR:
				_localctx = new CallParamCharContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(198);
				match(CHAR);
				}
				break;
			case STRING:
				_localctx = new CallParamStringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(199);
				match(STRING);
				}
				break;
			case BOOL:
				_localctx = new CallParamBooleanContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(200);
				match(BOOL);
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
		enterRule(_localctx, 38, RULE_multiInput);
		try {
			_localctx = new MultipleInputContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__11);
			setState(204);
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
		enterRule(_localctx, 40, RULE_if_statement);
		try {
			_localctx = new IfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__13);
			setState(207);
			match(T__5);
			setState(208);
			cond(0);
			setState(209);
			match(T__6);
			setState(210);
			match(T__1);
			setState(211);
			method_body();
			setState(212);
			match(T__1);
			setState(213);
			match(T__14);
			setState(214);
			match(T__1);
			setState(215);
			method_body();
			setState(216);
			match(T__1);
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
		enterRule(_localctx, 42, RULE_value);
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new ValueDoubleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(DOUBLE);
				}
				break;
			case 2:
				_localctx = new ValueNumContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(NUM);
				}
				break;
			case 3:
				_localctx = new ValueStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new ValueCharContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				match(CHAR);
				}
				break;
			case 5:
				_localctx = new ValueBoolContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				match(BOOL);
				}
				break;
			case 6:
				_localctx = new ValueMathContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_math, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				{
				_localctx = new MathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(227);
				match(T__9);
				setState(228);
				math(0);
				setState(229);
				match(T__10);
				}
				break;
			case NUM:
				{
				_localctx = new MathNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				match(NUM);
				}
				break;
			case DOUBLE:
				{
				_localctx = new MathDoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(DOUBLE);
				}
				break;
			case VAR_NAME:
				{
				_localctx = new MathVarNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(233);
				match(VAR_NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(248);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(236);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(237);
						match(T__15);
						setState(238);
						math(8);
						}
						break;
					case 2:
						{
						_localctx = new SubtractionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(239);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(240);
						match(T__16);
						setState(241);
						math(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicationContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(242);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(243);
						match(T__17);
						setState(244);
						math(6);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(245);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(246);
						match(T__18);
						setState(247);
						math(5);
						}
						break;
					}
					} 
				}
				setState(252);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(254);
				match(T__19);
				setState(255);
				cond(14);
				}
				break;
			case 2:
				{
				_localctx = new CondParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(T__9);
				setState(257);
				cond(0);
				setState(258);
				match(T__10);
				}
				break;
			case 3:
				{
				_localctx = new CondBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
				match(BOOL);
				}
				break;
			case 4:
				{
				_localctx = new CondVarNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261);
				match(VAR_NAME);
				}
				break;
			case 5:
				{
				_localctx = new CondEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				math(0);
				setState(263);
				match(T__22);
				setState(264);
				math(0);
				}
				break;
			case 6:
				{
				_localctx = new CondNotEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				math(0);
				setState(267);
				match(T__23);
				setState(268);
				math(0);
				}
				break;
			case 7:
				{
				_localctx = new MoreOrEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				math(0);
				setState(271);
				match(T__24);
				setState(272);
				math(0);
				}
				break;
			case 8:
				{
				_localctx = new LessOrEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				math(0);
				setState(275);
				match(T__25);
				setState(276);
				math(0);
				}
				break;
			case 9:
				{
				_localctx = new MoreContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				math(0);
				setState(279);
				match(T__26);
				setState(280);
				math(0);
				}
				break;
			case 10:
				{
				_localctx = new LessContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				math(0);
				setState(283);
				match(T__27);
				setState(284);
				math(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(300);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(288);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(289);
						match(T__20);
						setState(290);
						cond(13);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(291);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(292);
						match(T__21);
						setState(293);
						cond(12);
						}
						break;
					case 3:
						{
						_localctx = new EqualToContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(294);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(295);
						match(T__22);
						setState(296);
						cond(11);
						}
						break;
					case 4:
						{
						_localctx = new NotEqualToContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(297);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(298);
						match(T__23);
						setState(299);
						cond(10);
						}
						break;
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		case 22:
			return math_sempred((MathContext)_localctx, predIndex);
		case 23:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0134\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\5\2\65\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\7\4@\n\4\f\4\16"+
		"\4C\13\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\5\7O\n\7\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\tg\n\t\3\n\7\nj\n\n\f\n\16\nm\13\n\3\n\7\np\n\n\f\n\16\ns\13"+
		"\n\3\n\3\n\3\n\7\nx\n\n\f\n\16\n{\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\6\f\u0088\n\f\r\f\16\f\u0089\3\f\5\f\u008d\n\f\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\7\17\u0099\n\17\f\17\16"+
		"\17\u009c\13\17\3\17\7\17\u009f\n\17\f\17\16\17\u00a2\13\17\3\17\7\17"+
		"\u00a5\n\17\f\17\16\17\u00a8\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\6\23\u00bf\n\23\r\23\16\23\u00c0\3\23\5\23\u00c4\n\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u00cc\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u00e3\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00ed\n\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u00fb"+
		"\n\30\f\30\16\30\u00fe\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0121\n\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u012f"+
		"\n\31\f\31\16\31\u0132\13\31\3\31\2\4.\60\32\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\2\2\2\u014b\2\64\3\2\2\2\48\3\2\2\2\6A\3\2\2"+
		"\2\bD\3\2\2\2\nH\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20f\3\2\2\2\22k\3\2\2"+
		"\2\24|\3\2\2\2\26\u008c\3\2\2\2\30\u008e\3\2\2\2\32\u0091\3\2\2\2\34\u0094"+
		"\3\2\2\2\36\u00ab\3\2\2\2 \u00b0\3\2\2\2\"\u00b5\3\2\2\2$\u00c3\3\2\2"+
		"\2&\u00cb\3\2\2\2(\u00cd\3\2\2\2*\u00d0\3\2\2\2,\u00e2\3\2\2\2.\u00ec"+
		"\3\2\2\2\60\u0120\3\2\2\2\62\65\5\4\3\2\63\65\5\34\17\2\64\62\3\2\2\2"+
		"\64\63\3\2\2\2\65\66\3\2\2\2\66\67\7\2\2\3\67\3\3\2\2\289\7\3\2\29:\7"+
		"%\2\2:;\7\4\2\2;<\5\6\4\2<=\7\4\2\2=\5\3\2\2\2>@\5\16\b\2?>\3\2\2\2@C"+
		"\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7\3\2\2\2CA\3\2\2\2DE\7$\2\2EF\7\5\2\2F"+
		"G\7 \2\2G\t\3\2\2\2HI\7$\2\2IJ\7\6\2\2JK\5\f\7\2K\13\3\2\2\2LO\5 \21\2"+
		"MO\5,\27\2NL\3\2\2\2NM\3\2\2\2O\r\3\2\2\2PQ\7\7\2\2QR\7&\2\2RS\5\20\t"+
		"\2S\17\3\2\2\2TU\7 \2\2UV\7\b\2\2VW\5\26\f\2WX\7\t\2\2XY\7\4\2\2YZ\5\22"+
		"\n\2Z[\7\n\2\2[\\\7$\2\2\\]\7\4\2\2]g\3\2\2\2^_\7!\2\2_`\7\b\2\2`a\5\26"+
		"\f\2ab\7\t\2\2bc\7\4\2\2cd\5\22\n\2de\7\4\2\2eg\3\2\2\2fT\3\2\2\2f^\3"+
		"\2\2\2g\21\3\2\2\2hj\5\b\5\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l"+
		"q\3\2\2\2mk\3\2\2\2np\5\n\6\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2"+
		"ry\3\2\2\2sq\3\2\2\2tx\5*\26\2ux\5\"\22\2vx\5\24\13\2wt\3\2\2\2wu\3\2"+
		"\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\23\3\2\2\2{y\3\2\2\2|}\7"+
		"\13\2\2}~\7\f\2\2~\177\7(\2\2\177\u0080\7\r\2\2\u0080\u0081\7\4\2\2\u0081"+
		"\u0082\5\22\n\2\u0082\u0083\7\4\2\2\u0083\25\3\2\2\2\u0084\u008d\5\30"+
		"\r\2\u0085\u0087\5\30\r\2\u0086\u0088\5\32\16\2\u0087\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008d\3\2"+
		"\2\2\u008b\u008d\3\2\2\2\u008c\u0084\3\2\2\2\u008c\u0085\3\2\2\2\u008c"+
		"\u008b\3\2\2\2\u008d\27\3\2\2\2\u008e\u008f\7 \2\2\u008f\u0090\7$\2\2"+
		"\u0090\31\3\2\2\2\u0091\u0092\7\16\2\2\u0092\u0093\5\30\r\2\u0093\33\3"+
		"\2\2\2\u0094\u0095\7\17\2\2\u0095\u0096\7#\2\2\u0096\u009a\7\4\2\2\u0097"+
		"\u0099\5\b\5\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u00a0\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u009f\5\n\6\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a6\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3"+
		"\u00a5\5\36\20\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\7\4\2\2\u00aa\35\3\2\2\2\u00ab\u00ac\7&\2\2\u00ac\u00ad\7\b\2\2"+
		"\u00ad\u00ae\5$\23\2\u00ae\u00af\7\t\2\2\u00af\37\3\2\2\2\u00b0\u00b1"+
		"\7&\2\2\u00b1\u00b2\7\b\2\2\u00b2\u00b3\5$\23\2\u00b3\u00b4\7\t\2\2\u00b4"+
		"!\3\2\2\2\u00b5\u00b6\7\37\2\2\u00b6\u00b7\7&\2\2\u00b7\u00b8\7\b\2\2"+
		"\u00b8\u00b9\5$\23\2\u00b9\u00ba\7\t\2\2\u00ba#\3\2\2\2\u00bb\u00c4\5"+
		"&\24\2\u00bc\u00be\5&\24\2\u00bd\u00bf\5(\25\2\u00be\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2"+
		"\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00bc\3\2\2\2\u00c3"+
		"\u00c2\3\2\2\2\u00c4%\3\2\2\2\u00c5\u00cc\7$\2\2\u00c6\u00cc\7\'\2\2\u00c7"+
		"\u00cc\7(\2\2\u00c8\u00cc\7)\2\2\u00c9\u00cc\7*\2\2\u00ca\u00cc\7\"\2"+
		"\2\u00cb\u00c5\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cb\u00c7\3\2\2\2\u00cb\u00c8"+
		"\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\'\3\2\2\2\u00cd"+
		"\u00ce\7\16\2\2\u00ce\u00cf\5&\24\2\u00cf)\3\2\2\2\u00d0\u00d1\7\20\2"+
		"\2\u00d1\u00d2\7\b\2\2\u00d2\u00d3\5\60\31\2\u00d3\u00d4\7\t\2\2\u00d4"+
		"\u00d5\7\4\2\2\u00d5\u00d6\5\22\n\2\u00d6\u00d7\7\4\2\2\u00d7\u00d8\7"+
		"\21\2\2\u00d8\u00d9\7\4\2\2\u00d9\u00da\5\22\n\2\u00da\u00db\7\4\2\2\u00db"+
		"+\3\2\2\2\u00dc\u00e3\7\'\2\2\u00dd\u00e3\7(\2\2\u00de\u00e3\7*\2\2\u00df"+
		"\u00e3\7)\2\2\u00e0\u00e3\7\"\2\2\u00e1\u00e3\5.\30\2\u00e2\u00dc\3\2"+
		"\2\2\u00e2\u00dd\3\2\2\2\u00e2\u00de\3\2\2\2\u00e2\u00df\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3-\3\2\2\2\u00e4\u00e5\b\30\1\2"+
		"\u00e5\u00e6\7\f\2\2\u00e6\u00e7\5.\30\2\u00e7\u00e8\7\r\2\2\u00e8\u00ed"+
		"\3\2\2\2\u00e9\u00ed\7(\2\2\u00ea\u00ed\7\'\2\2\u00eb\u00ed\7$\2\2\u00ec"+
		"\u00e4\3\2\2\2\u00ec\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2"+
		"\2\2\u00ed\u00fc\3\2\2\2\u00ee\u00ef\f\t\2\2\u00ef\u00f0\7\22\2\2\u00f0"+
		"\u00fb\5.\30\n\u00f1\u00f2\f\b\2\2\u00f2\u00f3\7\23\2\2\u00f3\u00fb\5"+
		".\30\t\u00f4\u00f5\f\7\2\2\u00f5\u00f6\7\24\2\2\u00f6\u00fb\5.\30\b\u00f7"+
		"\u00f8\f\6\2\2\u00f8\u00f9\7\25\2\2\u00f9\u00fb\5.\30\7\u00fa\u00ee\3"+
		"\2\2\2\u00fa\u00f1\3\2\2\2\u00fa\u00f4\3\2\2\2\u00fa\u00f7\3\2\2\2\u00fb"+
		"\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd/\3\2\2\2"+
		"\u00fe\u00fc\3\2\2\2\u00ff\u0100\b\31\1\2\u0100\u0101\7\26\2\2\u0101\u0121"+
		"\5\60\31\20\u0102\u0103\7\f\2\2\u0103\u0104\5\60\31\2\u0104\u0105\7\r"+
		"\2\2\u0105\u0121\3\2\2\2\u0106\u0121\7\"\2\2\u0107\u0121\7$\2\2\u0108"+
		"\u0109\5.\30\2\u0109\u010a\7\31\2\2\u010a\u010b\5.\30\2\u010b\u0121\3"+
		"\2\2\2\u010c\u010d\5.\30\2\u010d\u010e\7\32\2\2\u010e\u010f\5.\30\2\u010f"+
		"\u0121\3\2\2\2\u0110\u0111\5.\30\2\u0111\u0112\7\33\2\2\u0112\u0113\5"+
		".\30\2\u0113\u0121\3\2\2\2\u0114\u0115\5.\30\2\u0115\u0116\7\34\2\2\u0116"+
		"\u0117\5.\30\2\u0117\u0121\3\2\2\2\u0118\u0119\5.\30\2\u0119\u011a\7\35"+
		"\2\2\u011a\u011b\5.\30\2\u011b\u0121\3\2\2\2\u011c\u011d\5.\30\2\u011d"+
		"\u011e\7\36\2\2\u011e\u011f\5.\30\2\u011f\u0121\3\2\2\2\u0120\u00ff\3"+
		"\2\2\2\u0120\u0102\3\2\2\2\u0120\u0106\3\2\2\2\u0120\u0107\3\2\2\2\u0120"+
		"\u0108\3\2\2\2\u0120\u010c\3\2\2\2\u0120\u0110\3\2\2\2\u0120\u0114\3\2"+
		"\2\2\u0120\u0118\3\2\2\2\u0120\u011c\3\2\2\2\u0121\u0130\3\2\2\2\u0122"+
		"\u0123\f\16\2\2\u0123\u0124\7\27\2\2\u0124\u012f\5\60\31\17\u0125\u0126"+
		"\f\r\2\2\u0126\u0127\7\30\2\2\u0127\u012f\5\60\31\16\u0128\u0129\f\f\2"+
		"\2\u0129\u012a\7\31\2\2\u012a\u012f\5\60\31\r\u012b\u012c\f\13\2\2\u012c"+
		"\u012d\7\32\2\2\u012d\u012f\5\60\31\f\u012e\u0122\3\2\2\2\u012e\u0125"+
		"\3\2\2\2\u012e\u0128\3\2\2\2\u012e\u012b\3\2\2\2\u012f\u0132\3\2\2\2\u0130"+
		"\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\61\3\2\2\2\u0132\u0130\3\2\2"+
		"\2\31\64ANfkqwy\u0089\u008c\u009a\u00a0\u00a6\u00c0\u00c3\u00cb\u00e2"+
		"\u00ec\u00fa\u00fc\u0120\u012e\u0130";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}