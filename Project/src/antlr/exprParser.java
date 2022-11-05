// Generated from java-escape by ANTLR 4.11.1

	package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class exprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, DATA_TYPE=30, VOID_TYPE=31, 
		BOOL=32, VAR_NAME=33, CLASS_NAME=34, TEST_NAME=35, METHODNAME=36, NUM=37, 
		CHAR=38, STRING=39, DOUBLE=40, COMMENT=41, WS=42;
	public static final int
		RULE_prog = 0, RULE_body = 1, RULE_decl = 2, RULE_assi = 3, RULE_expr = 4, 
		RULE_mymethod = 5, RULE_method_type = 6, RULE_return_method = 7, RULE_void_method = 8, 
		RULE_method_body = 9, RULE_param = 10, RULE_test = 11, RULE_t_method_call = 12, 
		RULE_input = 13, RULE_if_statement = 14, RULE_value = 15, RULE_r_method_call = 16, 
		RULE_math = 17, RULE_cond = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "body", "decl", "assi", "expr", "mymethod", "method_type", "return_method", 
			"void_method", "method_body", "param", "test", "t_method_call", "input", 
			"if_statement", "value", "r_method_call", "math", "cond"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'game'", "'['", "']'", "'!'", "'<<'", "'<-'", "'mymethod'", "'jackieReturns'", 
			"'test'", "'.'", "'jackieAsks'", "'elseJackie'", "'('", "')'", "'+'", 
			"'-'", "'*'", "'/'", "'not'", "'&&'", "'||'", "'=='", "'/='", "'>='", 
			"'<='", "'=<'", "'=>'", "'<'", "'>'", null, "'VOID'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "DATA_TYPE", "VOID_TYPE", "BOOL", 
			"VAR_NAME", "CLASS_NAME", "TEST_NAME", "METHODNAME", "NUM", "CHAR", "STRING", 
			"DOUBLE", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "java-escape"; }

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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ProgContext {
		public TerminalNode CLASS_NAME() { return getToken(exprParser.CLASS_NAME, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(exprParser.EOF, 0); }
		public ProgramContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			_localctx = new ProgramContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			match(CLASS_NAME);
			setState(40);
			match(T__1);
			setState(41);
			match(T__2);
			setState(42);
			match(T__3);
			setState(43);
			body();
			setState(44);
			match(T__3);
			setState(45);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends BodyContext {
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
		public ClassBodyContext(BodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			int _alt;
			_localctx = new ClassBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					decl();
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(53);
				assi();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(59);
				mymethod();
				}
				}
				setState(64);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends DeclContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public TerminalNode DATA_TYPE() { return getToken(exprParser.DATA_TYPE, 0); }
		public DeclarationContext(DeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			_localctx = new DeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(VAR_NAME);
			setState(66);
			match(T__4);
			setState(67);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends AssiContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(AssiContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssiContext assi() throws RecognitionException {
		AssiContext _localctx = new AssiContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assi);
		try {
			_localctx = new AssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(VAR_NAME);
			setState(70);
			match(T__5);
			setState(71);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public R_method_callContext r_method_call() {
			return getRuleContext(R_method_callContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case METHODNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				r_method_call();
				}
				break;
			case BOOL:
			case NUM:
			case CHAR:
			case STRING:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends MymethodContext {
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public Method_typeContext method_type() {
			return getRuleContext(Method_typeContext.class,0);
		}
		public MethodContext(MymethodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MymethodContext mymethod() throws RecognitionException {
		MymethodContext _localctx = new MymethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_mymethod);
		try {
			_localctx = new MethodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__6);
			setState(78);
			match(METHODNAME);
			setState(79);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class MReturnMethodContext extends Method_typeContext {
		public Return_methodContext return_method() {
			return getRuleContext(Return_methodContext.class,0);
		}
		public MReturnMethodContext(Method_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMReturnMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMReturnMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMReturnMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MVoidMethodContext extends Method_typeContext {
		public Void_methodContext void_method() {
			return getRuleContext(Void_methodContext.class,0);
		}
		public MVoidMethodContext(Method_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMVoidMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMVoidMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMVoidMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_typeContext method_type() throws RecognitionException {
		Method_typeContext _localctx = new Method_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_method_type);
		try {
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_TYPE:
				_localctx = new MReturnMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				return_method();
				}
				break;
			case VOID_TYPE:
				_localctx = new MVoidMethodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				void_method();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Return_methodContext extends ParserRuleContext {
		public Return_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_method; }
	 
		public Return_methodContext() { }
		public void copyFrom(Return_methodContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnMethodContext extends Return_methodContext {
		public TerminalNode DATA_TYPE() { return getToken(exprParser.DATA_TYPE, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Method_bodyContext method_body() {
			return getRuleContext(Method_bodyContext.class,0);
		}
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public ReturnMethodContext(Return_methodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterReturnMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitReturnMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitReturnMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_methodContext return_method() throws RecognitionException {
		Return_methodContext _localctx = new Return_methodContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_return_method);
		try {
			_localctx = new ReturnMethodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(DATA_TYPE);
			setState(86);
			match(T__1);
			setState(87);
			param();
			setState(88);
			match(T__2);
			setState(89);
			match(T__3);
			setState(90);
			method_body();
			setState(91);
			match(T__7);
			setState(92);
			match(VAR_NAME);
			setState(93);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Void_methodContext extends ParserRuleContext {
		public Void_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_void_method; }
	 
		public Void_methodContext() { }
		public void copyFrom(Void_methodContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidMethodContext extends Void_methodContext {
		public TerminalNode VOID_TYPE() { return getToken(exprParser.VOID_TYPE, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Method_bodyContext method_body() {
			return getRuleContext(Method_bodyContext.class,0);
		}
		public VoidMethodContext(Void_methodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterVoidMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitVoidMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitVoidMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Void_methodContext void_method() throws RecognitionException {
		Void_methodContext _localctx = new Void_methodContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_void_method);
		try {
			_localctx = new VoidMethodContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(VOID_TYPE);
			setState(96);
			match(T__1);
			setState(97);
			param();
			setState(98);
			match(T__2);
			setState(99);
			match(T__3);
			setState(100);
			method_body();
			setState(101);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyContext extends Method_bodyContext {
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
		public MethodBodyContext(Method_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_bodyContext method_body() throws RecognitionException {
		Method_bodyContext _localctx = new Method_bodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_method_body);
		int _la;
		try {
			int _alt;
			_localctx = new MethodBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(103);
					decl();
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(109);
				assi();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(115);
				if_statement();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==METHODNAME) {
				{
				{
				setState(121);
				r_method_call();
				}
				}
				setState(126);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode DATA_TYPE() { return getToken(exprParser.DATA_TYPE, 0); }
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_param);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(DATA_TYPE);
				setState(128);
				match(VAR_NAME);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
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

	@SuppressWarnings("CheckReturnValue")
	public static class TestContext extends ParserRuleContext {
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
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_test);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__8);
			setState(133);
			match(TEST_NAME);
			setState(134);
			match(T__1);
			setState(135);
			match(T__2);
			setState(136);
			match(T__3);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(137);
					decl();
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(143);
				assi();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS_NAME) {
				{
				{
				setState(149);
				t_method_call();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
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

	@SuppressWarnings("CheckReturnValue")
	public static class T_method_callContext extends ParserRuleContext {
		public TerminalNode CLASS_NAME() { return getToken(exprParser.CLASS_NAME, 0); }
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public T_method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterT_method_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitT_method_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitT_method_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final T_method_callContext t_method_call() throws RecognitionException {
		T_method_callContext _localctx = new T_method_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_t_method_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(CLASS_NAME);
			setState(158);
			match(T__9);
			setState(159);
			match(METHODNAME);
			setState(160);
			match(T__1);
			setState(161);
			input();
			setState(162);
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

	@SuppressWarnings("CheckReturnValue")
	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_if_statement);
		try {
			_localctx = new IfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__10);
			setState(167);
			match(T__1);
			setState(168);
			cond(0);
			setState(169);
			match(T__2);
			setState(170);
			match(T__3);
			setState(171);
			method_body();
			setState(172);
			match(T__3);
			setState(173);
			match(T__11);
			setState(174);
			match(T__3);
			setState(175);
			method_body();
			setState(176);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public TerminalNode DOUBLE() { return getToken(exprParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(exprParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(exprParser.CHAR, 0); }
		public TerminalNode BOOL() { return getToken(exprParser.BOOL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 2065879269376L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnMethodCallContext extends R_method_callContext {
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public ReturnMethodCallContext(R_method_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterReturnMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitReturnMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitReturnMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R_method_callContext r_method_call() throws RecognitionException {
		R_method_callContext _localctx = new R_method_callContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_r_method_call);
		try {
			_localctx = new ReturnMethodCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(METHODNAME);
			setState(181);
			match(T__1);
			setState(182);
			match(VAR_NAME);
			setState(183);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class MathNumberContext extends MathContext {
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public MathNumberContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMathNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMathNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMathNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public AdditionContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public MultiplicationContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtractionContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public SubtractionContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XContext extends MathContext {
		public TerminalNode DOUBLE() { return getToken(exprParser.DOUBLE, 0); }
		public XContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitX(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitX(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MathDoubleContext extends MathContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public MathDoubleContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMathDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMathDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMathDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MathParenthesisContext extends MathContext {
		public MathContext math() {
			return getRuleContext(MathContext.class,0);
		}
		public MathParenthesisContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMathParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMathParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMathParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivisionContext extends MathContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public DivisionContext(MathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDivision(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathContext math() throws RecognitionException {
		return math(0);
	}

	private MathContext math(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MathContext _localctx = new MathContext(_ctx, _parentState);
		MathContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_math, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				{
				_localctx = new MathParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(186);
				match(T__12);
				setState(187);
				math(0);
				setState(188);
				match(T__13);
				}
				break;
			case NUM:
				{
				_localctx = new MathNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(190);
				match(NUM);
				}
				break;
			case DOUBLE:
				{
				_localctx = new XContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(DOUBLE);
				}
				break;
			case VAR_NAME:
				{
				_localctx = new MathDoubleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(VAR_NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(207);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new AdditionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(195);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(196);
						match(T__14);
						setState(197);
						math(8);
						}
						break;
					case 2:
						{
						_localctx = new SubtractionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(198);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(199);
						match(T__15);
						setState(200);
						math(7);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicationContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(201);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(202);
						match(T__16);
						setState(203);
						math(6);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new MathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_math);
						setState(204);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(205);
						match(T__17);
						setState(206);
						math(5);
						}
						break;
					}
					} 
				}
				setState(211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class AContext extends CondContext {
		public TerminalNode BOOL() { return getToken(exprParser.BOOL, 0); }
		public AContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitA(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public BContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitB(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public CContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitC(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public NegationContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public DContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitD(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public EContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitE(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public FContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public GContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterG(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitG(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitG(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HContext extends CondContext {
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public HContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterH(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitH(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitH(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotEqualToContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public NotEqualToContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterNotEqualTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitNotEqualTo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitNotEqualTo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public IContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitI(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitI(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JContext extends CondContext {
		public List<MathContext> math() {
			return getRuleContexts(MathContext.class);
		}
		public MathContext math(int i) {
			return getRuleContext(MathContext.class,i);
		}
		public JContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterJ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitJ(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitJ(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualToContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public EqualToContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterEqualTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitEqualTo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitEqualTo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DisjunctionContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public DisjunctionContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConjunctionContext extends CondContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public ConjunctionContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CondParenthesisContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondParenthesisContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterCondParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitCondParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitCondParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(213);
				match(T__18);
				setState(214);
				cond(16);
				}
				break;
			case 2:
				{
				_localctx = new CondParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(215);
				match(T__12);
				setState(216);
				cond(0);
				setState(217);
				match(T__13);
				}
				break;
			case 3:
				{
				_localctx = new AContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				match(BOOL);
				}
				break;
			case 4:
				{
				_localctx = new IContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220);
				math(0);
				setState(221);
				match(T__21);
				setState(222);
				math(0);
				}
				break;
			case 5:
				{
				_localctx = new JContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				math(0);
				setState(225);
				match(T__22);
				setState(226);
				math(0);
				}
				break;
			case 6:
				{
				_localctx = new BContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				math(0);
				setState(229);
				match(T__23);
				setState(230);
				math(0);
				}
				break;
			case 7:
				{
				_localctx = new CContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				math(0);
				setState(233);
				match(T__24);
				setState(234);
				math(0);
				}
				break;
			case 8:
				{
				_localctx = new DContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				math(0);
				setState(237);
				match(T__25);
				setState(238);
				math(0);
				}
				break;
			case 9:
				{
				_localctx = new EContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				math(0);
				setState(241);
				match(T__26);
				setState(242);
				math(0);
				}
				break;
			case 10:
				{
				_localctx = new FContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				math(0);
				setState(245);
				match(T__27);
				setState(246);
				math(0);
				}
				break;
			case 11:
				{
				_localctx = new GContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(248);
				math(0);
				setState(249);
				match(T__28);
				setState(250);
				math(0);
				}
				break;
			case 12:
				{
				_localctx = new HContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				match(VAR_NAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(267);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctionContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(255);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(256);
						match(T__19);
						setState(257);
						cond(15);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctionContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(258);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(259);
						match(T__20);
						setState(260);
						cond(14);
						}
						break;
					case 3:
						{
						_localctx = new EqualToContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(261);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(262);
						match(T__21);
						setState(263);
						cond(13);
						}
						break;
					case 4:
						{
						_localctx = new NotEqualToContext(new CondContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(264);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(265);
						match(T__22);
						setState(266);
						cond(12);
						}
						break;
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		case 17:
			return math_sempred((MathContext)_localctx, predIndex);
		case 18:
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
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u0111\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u00011\b\u0001"+
		"\n\u0001\f\u00014\t\u0001\u0001\u0001\u0005\u00017\b\u0001\n\u0001\f\u0001"+
		":\t\u0001\u0001\u0001\u0005\u0001=\b\u0001\n\u0001\f\u0001@\t\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004L\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003"+
		"\u0006T\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0005"+
		"\ti\b\t\n\t\f\tl\t\t\u0001\t\u0005\to\b\t\n\t\f\tr\t\t\u0001\t\u0005\t"+
		"u\b\t\n\t\f\tx\t\t\u0001\t\u0005\t{\b\t\n\t\f\t~\t\t\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u0083\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u008b\b\u000b\n\u000b\f\u000b\u008e\t\u000b"+
		"\u0001\u000b\u0005\u000b\u0091\b\u000b\n\u000b\f\u000b\u0094\t\u000b\u0001"+
		"\u000b\u0005\u000b\u0097\b\u000b\n\u000b\f\u000b\u009a\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00c2\b\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u00d0\b\u0011\n\u0011\f\u0011\u00d3\t\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00fe\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u010c\b\u0012\n\u0012\f\u0012\u010f\t\u0012\u0001\u0012\u0000\u0002"+
		"\"$\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$\u0000\u0001\u0002\u0000  %(\u0120\u0000&"+
		"\u0001\u0000\u0000\u0000\u00022\u0001\u0000\u0000\u0000\u0004A\u0001\u0000"+
		"\u0000\u0000\u0006E\u0001\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000"+
		"\nM\u0001\u0000\u0000\u0000\fS\u0001\u0000\u0000\u0000\u000eU\u0001\u0000"+
		"\u0000\u0000\u0010_\u0001\u0000\u0000\u0000\u0012j\u0001\u0000\u0000\u0000"+
		"\u0014\u0082\u0001\u0000\u0000\u0000\u0016\u0084\u0001\u0000\u0000\u0000"+
		"\u0018\u009d\u0001\u0000\u0000\u0000\u001a\u00a4\u0001\u0000\u0000\u0000"+
		"\u001c\u00a6\u0001\u0000\u0000\u0000\u001e\u00b2\u0001\u0000\u0000\u0000"+
		" \u00b4\u0001\u0000\u0000\u0000\"\u00c1\u0001\u0000\u0000\u0000$\u00fd"+
		"\u0001\u0000\u0000\u0000&\'\u0005\u0001\u0000\u0000\'(\u0005\"\u0000\u0000"+
		"()\u0005\u0002\u0000\u0000)*\u0005\u0003\u0000\u0000*+\u0005\u0004\u0000"+
		"\u0000+,\u0003\u0002\u0001\u0000,-\u0005\u0004\u0000\u0000-.\u0005\u0000"+
		"\u0000\u0001.\u0001\u0001\u0000\u0000\u0000/1\u0003\u0004\u0002\u0000"+
		"0/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u000038\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000057\u0003\u0006\u0003\u000065\u0001\u0000\u0000\u00007:\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9>\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;=\u0003\n\u0005\u0000"+
		"<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?\u0003\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000AB\u0005!\u0000\u0000BC\u0005\u0005\u0000\u0000CD\u0005"+
		"\u001e\u0000\u0000D\u0005\u0001\u0000\u0000\u0000EF\u0005!\u0000\u0000"+
		"FG\u0005\u0006\u0000\u0000GH\u0003\b\u0004\u0000H\u0007\u0001\u0000\u0000"+
		"\u0000IL\u0003 \u0010\u0000JL\u0003\u001e\u000f\u0000KI\u0001\u0000\u0000"+
		"\u0000KJ\u0001\u0000\u0000\u0000L\t\u0001\u0000\u0000\u0000MN\u0005\u0007"+
		"\u0000\u0000NO\u0005$\u0000\u0000OP\u0003\f\u0006\u0000P\u000b\u0001\u0000"+
		"\u0000\u0000QT\u0003\u000e\u0007\u0000RT\u0003\u0010\b\u0000SQ\u0001\u0000"+
		"\u0000\u0000SR\u0001\u0000\u0000\u0000T\r\u0001\u0000\u0000\u0000UV\u0005"+
		"\u001e\u0000\u0000VW\u0005\u0002\u0000\u0000WX\u0003\u0014\n\u0000XY\u0005"+
		"\u0003\u0000\u0000YZ\u0005\u0004\u0000\u0000Z[\u0003\u0012\t\u0000[\\"+
		"\u0005\b\u0000\u0000\\]\u0005!\u0000\u0000]^\u0005\u0004\u0000\u0000^"+
		"\u000f\u0001\u0000\u0000\u0000_`\u0005\u001f\u0000\u0000`a\u0005\u0002"+
		"\u0000\u0000ab\u0003\u0014\n\u0000bc\u0005\u0003\u0000\u0000cd\u0005\u0004"+
		"\u0000\u0000de\u0003\u0012\t\u0000ef\u0005\u0004\u0000\u0000f\u0011\u0001"+
		"\u0000\u0000\u0000gi\u0003\u0004\u0002\u0000hg\u0001\u0000\u0000\u0000"+
		"il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000kp\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mo\u0003\u0006"+
		"\u0003\u0000nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qv\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000su\u0003\u001c\u000e\u0000ts\u0001\u0000\u0000"+
		"\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000w|\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000y{\u0003"+
		" \u0010\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0013\u0001\u0000\u0000"+
		"\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u001e\u0000\u0000\u0080"+
		"\u0083\u0005!\u0000\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082\u007f"+
		"\u0001\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0015"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0005\t\u0000\u0000\u0085\u0086\u0005"+
		"#\u0000\u0000\u0086\u0087\u0005\u0002\u0000\u0000\u0087\u0088\u0005\u0003"+
		"\u0000\u0000\u0088\u008c\u0005\u0004\u0000\u0000\u0089\u008b\u0003\u0004"+
		"\u0002\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000"+
		"\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u0092\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000"+
		"\u0000\u0000\u008f\u0091\u0003\u0006\u0003\u0000\u0090\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0098\u0001\u0000"+
		"\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0097\u0003\u0018"+
		"\f\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0005\u0004\u0000\u0000\u009c\u0017\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0005\"\u0000\u0000\u009e\u009f\u0005\n\u0000\u0000"+
		"\u009f\u00a0\u0005$\u0000\u0000\u00a0\u00a1\u0005\u0002\u0000\u0000\u00a1"+
		"\u00a2\u0003\u001a\r\u0000\u00a2\u00a3\u0005\u0003\u0000\u0000\u00a3\u0019"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u001b"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u000b\u0000\u0000\u00a7\u00a8"+
		"\u0005\u0002\u0000\u0000\u00a8\u00a9\u0003$\u0012\u0000\u00a9\u00aa\u0005"+
		"\u0003\u0000\u0000\u00aa\u00ab\u0005\u0004\u0000\u0000\u00ab\u00ac\u0003"+
		"\u0012\t\u0000\u00ac\u00ad\u0005\u0004\u0000\u0000\u00ad\u00ae\u0005\f"+
		"\u0000\u0000\u00ae\u00af\u0005\u0004\u0000\u0000\u00af\u00b0\u0003\u0012"+
		"\t\u0000\u00b0\u00b1\u0005\u0004\u0000\u0000\u00b1\u001d\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0007\u0000\u0000\u0000\u00b3\u001f\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0005$\u0000\u0000\u00b5\u00b6\u0005\u0002\u0000\u0000"+
		"\u00b6\u00b7\u0005!\u0000\u0000\u00b7\u00b8\u0005\u0003\u0000\u0000\u00b8"+
		"!\u0001\u0000\u0000\u0000\u00b9\u00ba\u0006\u0011\uffff\uffff\u0000\u00ba"+
		"\u00bb\u0005\r\u0000\u0000\u00bb\u00bc\u0003\"\u0011\u0000\u00bc\u00bd"+
		"\u0005\u000e\u0000\u0000\u00bd\u00c2\u0001\u0000\u0000\u0000\u00be\u00c2"+
		"\u0005%\u0000\u0000\u00bf\u00c2\u0005(\u0000\u0000\u00c0\u00c2\u0005!"+
		"\u0000\u0000\u00c1\u00b9\u0001\u0000\u0000\u0000\u00c1\u00be\u0001\u0000"+
		"\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c2\u00d1\u0001\u0000\u0000\u0000\u00c3\u00c4\n\u0007\u0000"+
		"\u0000\u00c4\u00c5\u0005\u000f\u0000\u0000\u00c5\u00d0\u0003\"\u0011\b"+
		"\u00c6\u00c7\n\u0006\u0000\u0000\u00c7\u00c8\u0005\u0010\u0000\u0000\u00c8"+
		"\u00d0\u0003\"\u0011\u0007\u00c9\u00ca\n\u0005\u0000\u0000\u00ca\u00cb"+
		"\u0005\u0011\u0000\u0000\u00cb\u00d0\u0003\"\u0011\u0006\u00cc\u00cd\n"+
		"\u0004\u0000\u0000\u00cd\u00ce\u0005\u0012\u0000\u0000\u00ce\u00d0\u0003"+
		"\"\u0011\u0005\u00cf\u00c3\u0001\u0000\u0000\u0000\u00cf\u00c6\u0001\u0000"+
		"\u0000\u0000\u00cf\u00c9\u0001\u0000\u0000\u0000\u00cf\u00cc\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2#\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d5\u0006\u0012\uffff"+
		"\uffff\u0000\u00d5\u00d6\u0005\u0013\u0000\u0000\u00d6\u00fe\u0003$\u0012"+
		"\u0010\u00d7\u00d8\u0005\r\u0000\u0000\u00d8\u00d9\u0003$\u0012\u0000"+
		"\u00d9\u00da\u0005\u000e\u0000\u0000\u00da\u00fe\u0001\u0000\u0000\u0000"+
		"\u00db\u00fe\u0005 \u0000\u0000\u00dc\u00dd\u0003\"\u0011\u0000\u00dd"+
		"\u00de\u0005\u0016\u0000\u0000\u00de\u00df\u0003\"\u0011\u0000\u00df\u00fe"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0003\"\u0011\u0000\u00e1\u00e2\u0005"+
		"\u0017\u0000\u0000\u00e2\u00e3\u0003\"\u0011\u0000\u00e3\u00fe\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0003\"\u0011\u0000\u00e5\u00e6\u0005\u0018\u0000"+
		"\u0000\u00e6\u00e7\u0003\"\u0011\u0000\u00e7\u00fe\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0003\"\u0011\u0000\u00e9\u00ea\u0005\u0019\u0000\u0000\u00ea"+
		"\u00eb\u0003\"\u0011\u0000\u00eb\u00fe\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0003\"\u0011\u0000\u00ed\u00ee\u0005\u001a\u0000\u0000\u00ee\u00ef\u0003"+
		"\"\u0011\u0000\u00ef\u00fe\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003\""+
		"\u0011\u0000\u00f1\u00f2\u0005\u001b\u0000\u0000\u00f2\u00f3\u0003\"\u0011"+
		"\u0000\u00f3\u00fe\u0001\u0000\u0000\u0000\u00f4\u00f5\u0003\"\u0011\u0000"+
		"\u00f5\u00f6\u0005\u001c\u0000\u0000\u00f6\u00f7\u0003\"\u0011\u0000\u00f7"+
		"\u00fe\u0001\u0000\u0000\u0000\u00f8\u00f9\u0003\"\u0011\u0000\u00f9\u00fa"+
		"\u0005\u001d\u0000\u0000\u00fa\u00fb\u0003\"\u0011\u0000\u00fb\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fe\u0005!\u0000\u0000\u00fd\u00d4\u0001\u0000"+
		"\u0000\u0000\u00fd\u00d7\u0001\u0000\u0000\u0000\u00fd\u00db\u0001\u0000"+
		"\u0000\u0000\u00fd\u00dc\u0001\u0000\u0000\u0000\u00fd\u00e0\u0001\u0000"+
		"\u0000\u0000\u00fd\u00e4\u0001\u0000\u0000\u0000\u00fd\u00e8\u0001\u0000"+
		"\u0000\u0000\u00fd\u00ec\u0001\u0000\u0000\u0000\u00fd\u00f0\u0001\u0000"+
		"\u0000\u0000\u00fd\u00f4\u0001\u0000\u0000\u0000\u00fd\u00f8\u0001\u0000"+
		"\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fe\u010d\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\n\u000e\u0000\u0000\u0100\u0101\u0005\u0014\u0000"+
		"\u0000\u0101\u010c\u0003$\u0012\u000f\u0102\u0103\n\r\u0000\u0000\u0103"+
		"\u0104\u0005\u0015\u0000\u0000\u0104\u010c\u0003$\u0012\u000e\u0105\u0106"+
		"\n\f\u0000\u0000\u0106\u0107\u0005\u0016\u0000\u0000\u0107\u010c\u0003"+
		"$\u0012\r\u0108\u0109\n\u000b\u0000\u0000\u0109\u010a\u0005\u0017\u0000"+
		"\u0000\u010a\u010c\u0003$\u0012\f\u010b\u00ff\u0001\u0000\u0000\u0000"+
		"\u010b\u0102\u0001\u0000\u0000\u0000\u010b\u0105\u0001\u0000\u0000\u0000"+
		"\u010b\u0108\u0001\u0000\u0000\u0000\u010c\u010f\u0001\u0000\u0000\u0000"+
		"\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000"+
		"\u010e%\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u0013"+
		"28>KSjpv|\u0082\u008c\u0092\u0098\u00c1\u00cf\u00d1\u00fd\u010b\u010d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}