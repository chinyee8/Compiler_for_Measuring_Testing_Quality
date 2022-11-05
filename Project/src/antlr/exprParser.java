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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, VAR_NAME=23, CLASS_NAME=24, 
		DATA_TYPE=25, METHODNAME=26, NUM=27, VOID_TYPE=28, BOOL=29, CHAR=30, STRING=31, 
		DOUB=32, COMMENT=33, WS=34;
	public static final int
		RULE_prog = 0, RULE_body = 1, RULE_decl = 2, RULE_assi = 3, RULE_mymethod = 4, 
		RULE_method_type = 5, RULE_return_method = 6, RULE_void_method = 7, RULE_expr = 8, 
		RULE_value = 9, RULE_r_method_call = 10, RULE_if_statement = 11, RULE_method_body = 12, 
		RULE_cond = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "body", "decl", "assi", "mymethod", "method_type", "return_method", 
			"void_method", "expr", "value", "r_method_call", "if_statement", "method_body", 
			"cond"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'game'", "'['", "']'", "'!'", "'jackieServes:'", "'jackieAssigns:'", 
			"'<<'", "'<-'", "'mymethod'", "'jackieReturns'", "'jackieAsks'", "'elseJackie'", 
			"'('", "')'", "'not'", "'&&'", "'||'", "'=>'", "'=='", "'/='", "'>'", 
			"'<'", null, null, null, null, null, "'vOID'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "VAR_NAME", 
			"CLASS_NAME", "DATA_TYPE", "METHODNAME", "NUM", "VOID_TYPE", "BOOL", 
			"CHAR", "STRING", "DOUB", "COMMENT", "WS"
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
			setState(28);
			match(T__0);
			setState(29);
			match(CLASS_NAME);
			setState(30);
			match(T__1);
			setState(31);
			match(T__2);
			setState(32);
			match(T__3);
			setState(33);
			body();
			setState(34);
			match(T__3);
			setState(35);
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
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__4);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(38);
				decl();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44);
			match(T__5);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(45);
				assi();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(51);
				mymethod();
				}
				}
				setState(56);
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
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public TerminalNode DATA_TYPE() { return getToken(exprParser.DATA_TYPE, 0); }
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(VAR_NAME);
			setState(58);
			match(T__6);
			setState(59);
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
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterAssi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitAssi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitAssi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssiContext assi() throws RecognitionException {
		AssiContext _localctx = new AssiContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(VAR_NAME);
			setState(62);
			match(T__7);
			setState(63);
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
	public static class MymethodContext extends ParserRuleContext {
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public Method_typeContext method_type() {
			return getRuleContext(Method_typeContext.class,0);
		}
		public MymethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mymethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMymethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMymethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMymethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MymethodContext mymethod() throws RecognitionException {
		MymethodContext _localctx = new MymethodContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mymethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__8);
			setState(66);
			match(METHODNAME);
			setState(67);
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
		public Return_methodContext return_method() {
			return getRuleContext(Return_methodContext.class,0);
		}
		public Void_methodContext void_method() {
			return getRuleContext(Void_methodContext.class,0);
		}
		public Method_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMethod_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMethod_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMethod_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_typeContext method_type() throws RecognitionException {
		Method_typeContext _localctx = new Method_typeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method_type);
		try {
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DATA_TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				return_method();
				}
				break;
			case VOID_TYPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
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
		public List<TerminalNode> DATA_TYPE() { return getTokens(exprParser.DATA_TYPE); }
		public TerminalNode DATA_TYPE(int i) {
			return getToken(exprParser.DATA_TYPE, i);
		}
		public List<TerminalNode> VAR_NAME() { return getTokens(exprParser.VAR_NAME); }
		public TerminalNode VAR_NAME(int i) {
			return getToken(exprParser.VAR_NAME, i);
		}
		public Method_bodyContext method_body() {
			return getRuleContext(Method_bodyContext.class,0);
		}
		public Return_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterReturn_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitReturn_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitReturn_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_methodContext return_method() throws RecognitionException {
		Return_methodContext _localctx = new Return_methodContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_return_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(DATA_TYPE);
			setState(74);
			match(T__1);
			setState(75);
			match(DATA_TYPE);
			setState(76);
			match(VAR_NAME);
			setState(77);
			match(T__2);
			setState(78);
			match(T__3);
			setState(79);
			method_body();
			setState(80);
			match(T__9);
			setState(81);
			match(VAR_NAME);
			setState(82);
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
		public TerminalNode VOID_TYPE() { return getToken(exprParser.VOID_TYPE, 0); }
		public TerminalNode DATA_TYPE() { return getToken(exprParser.DATA_TYPE, 0); }
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public Method_bodyContext method_body() {
			return getRuleContext(Method_bodyContext.class,0);
		}
		public Void_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_void_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterVoid_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitVoid_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitVoid_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Void_methodContext void_method() throws RecognitionException {
		Void_methodContext _localctx = new Void_methodContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_void_method);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(VOID_TYPE);
			setState(85);
			match(T__1);
			setState(86);
			match(DATA_TYPE);
			setState(87);
			match(VAR_NAME);
			setState(88);
			match(T__2);
			setState(89);
			match(T__3);
			setState(90);
			method_body();
			setState(91);
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
		enterRule(_localctx, 16, RULE_expr);
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case METHODNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				r_method_call();
				}
				break;
			case NUM:
			case BOOL:
			case CHAR:
			case STRING:
			case DOUB:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public TerminalNode DOUB() { return getToken(exprParser.DOUB, 0); }
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
		enterRule(_localctx, 18, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 8187281408L) != 0) ) {
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
		public TerminalNode METHODNAME() { return getToken(exprParser.METHODNAME, 0); }
		public TerminalNode VAR_NAME() { return getToken(exprParser.VAR_NAME, 0); }
		public R_method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterR_method_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitR_method_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitR_method_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final R_method_callContext r_method_call() throws RecognitionException {
		R_method_callContext _localctx = new R_method_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_r_method_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(METHODNAME);
			setState(100);
			match(T__1);
			setState(101);
			match(VAR_NAME);
			setState(102);
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
	public static class If_statementContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<Method_bodyContext> method_body() {
			return getRuleContexts(Method_bodyContext.class);
		}
		public Method_bodyContext method_body(int i) {
			return getRuleContext(Method_bodyContext.class,i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__10);
			setState(105);
			match(T__1);
			setState(106);
			cond(0);
			setState(107);
			match(T__2);
			setState(108);
			match(T__3);
			setState(109);
			method_body();
			setState(110);
			match(T__3);
			setState(111);
			match(T__11);
			setState(112);
			match(T__3);
			setState(113);
			method_body();
			setState(114);
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
		public Method_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterMethod_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitMethod_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitMethod_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_bodyContext method_body() throws RecognitionException {
		Method_bodyContext _localctx = new Method_bodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_method_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__4);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR_NAME) {
				{
				{
				setState(117);
				decl();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(T__5);
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
			while (_la==T__10) {
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
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==METHODNAME) {
				{
				{
				setState(136);
				r_method_call();
				}
				}
				setState(141);
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
	public static class CondContext extends ParserRuleContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public TerminalNode NUM() { return getToken(exprParser.NUM, 0); }
		public TerminalNode BOOL() { return getToken(exprParser.BOOL, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof exprListener ) ((exprListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof exprVisitor ) return ((exprVisitor<? extends T>)visitor).visitCond(this);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				{
				setState(143);
				match(T__12);
				setState(144);
				cond(0);
				setState(145);
				match(T__13);
				}
				break;
			case T__14:
				{
				setState(147);
				match(T__14);
				setState(148);
				cond(10);
				}
				break;
			case NUM:
				{
				setState(149);
				match(NUM);
				}
				break;
			case BOOL:
				{
				setState(150);
				match(BOOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(174);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(153);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(154);
						match(T__15);
						setState(155);
						cond(10);
						}
						break;
					case 2:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(156);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(157);
						match(T__16);
						setState(158);
						cond(9);
						}
						break;
					case 3:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(159);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(160);
						match(T__17);
						setState(161);
						cond(8);
						}
						break;
					case 4:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(162);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(163);
						match(T__18);
						setState(164);
						cond(7);
						}
						break;
					case 5:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(165);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(166);
						match(T__19);
						setState(167);
						cond(6);
						}
						break;
					case 6:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(168);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(169);
						match(T__20);
						setState(170);
						cond(5);
						}
						break;
					case 7:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(171);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(172);
						match(T__21);
						setState(173);
						cond(4);
						}
						break;
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		case 13:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u00b4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0005\u0001(\b\u0001\n\u0001\f\u0001+\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001/\b\u0001\n\u0001\f\u00012\t\u0001\u0001\u0001"+
		"\u0005\u00015\b\u0001\n\u0001\f\u00018\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0003\u0005H\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003"+
		"\b`\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0005\fw\b\f\n\f\f\fz\t\f\u0001\f\u0001\f\u0005\f~\b\f\n\f"+
		"\f\f\u0081\t\f\u0001\f\u0005\f\u0084\b\f\n\f\f\f\u0087\t\f\u0001\f\u0005"+
		"\f\u008a\b\f\n\f\f\f\u008d\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0098\b\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00af\b\r\n\r\f\r\u00b2\t\r\u0001\r\u0000\u0001\u001a\u000e"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u0000\u0001\u0002\u0000\u001b\u001b\u001d \u00b8\u0000\u001c\u0001\u0000"+
		"\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u00049\u0001\u0000\u0000\u0000"+
		"\u0006=\u0001\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000\nG\u0001\u0000"+
		"\u0000\u0000\fI\u0001\u0000\u0000\u0000\u000eT\u0001\u0000\u0000\u0000"+
		"\u0010_\u0001\u0000\u0000\u0000\u0012a\u0001\u0000\u0000\u0000\u0014c"+
		"\u0001\u0000\u0000\u0000\u0016h\u0001\u0000\u0000\u0000\u0018t\u0001\u0000"+
		"\u0000\u0000\u001a\u0097\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0001"+
		"\u0000\u0000\u001d\u001e\u0005\u0018\u0000\u0000\u001e\u001f\u0005\u0002"+
		"\u0000\u0000\u001f \u0005\u0003\u0000\u0000 !\u0005\u0004\u0000\u0000"+
		"!\"\u0003\u0002\u0001\u0000\"#\u0005\u0004\u0000\u0000#$\u0005\u0000\u0000"+
		"\u0001$\u0001\u0001\u0000\u0000\u0000%)\u0005\u0005\u0000\u0000&(\u0003"+
		"\u0004\u0002\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000"+
		")\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000"+
		"\u0000+)\u0001\u0000\u0000\u0000,0\u0005\u0006\u0000\u0000-/\u0003\u0006"+
		"\u0003\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000016\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000035\u0003\b\u0004\u000043\u0001\u0000\u0000\u0000"+
		"58\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000"+
		"\u00007\u0003\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u00009:\u0005"+
		"\u0017\u0000\u0000:;\u0005\u0007\u0000\u0000;<\u0005\u0019\u0000\u0000"+
		"<\u0005\u0001\u0000\u0000\u0000=>\u0005\u0017\u0000\u0000>?\u0005\b\u0000"+
		"\u0000?@\u0003\u0010\b\u0000@\u0007\u0001\u0000\u0000\u0000AB\u0005\t"+
		"\u0000\u0000BC\u0005\u001a\u0000\u0000CD\u0003\n\u0005\u0000D\t\u0001"+
		"\u0000\u0000\u0000EH\u0003\f\u0006\u0000FH\u0003\u000e\u0007\u0000GE\u0001"+
		"\u0000\u0000\u0000GF\u0001\u0000\u0000\u0000H\u000b\u0001\u0000\u0000"+
		"\u0000IJ\u0005\u0019\u0000\u0000JK\u0005\u0002\u0000\u0000KL\u0005\u0019"+
		"\u0000\u0000LM\u0005\u0017\u0000\u0000MN\u0005\u0003\u0000\u0000NO\u0005"+
		"\u0004\u0000\u0000OP\u0003\u0018\f\u0000PQ\u0005\n\u0000\u0000QR\u0005"+
		"\u0017\u0000\u0000RS\u0005\u0004\u0000\u0000S\r\u0001\u0000\u0000\u0000"+
		"TU\u0005\u001c\u0000\u0000UV\u0005\u0002\u0000\u0000VW\u0005\u0019\u0000"+
		"\u0000WX\u0005\u0017\u0000\u0000XY\u0005\u0003\u0000\u0000YZ\u0005\u0004"+
		"\u0000\u0000Z[\u0003\u0018\f\u0000[\\\u0005\u0004\u0000\u0000\\\u000f"+
		"\u0001\u0000\u0000\u0000]`\u0003\u0014\n\u0000^`\u0003\u0012\t\u0000_"+
		"]\u0001\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`\u0011\u0001\u0000"+
		"\u0000\u0000ab\u0007\u0000\u0000\u0000b\u0013\u0001\u0000\u0000\u0000"+
		"cd\u0005\u001a\u0000\u0000de\u0005\u0002\u0000\u0000ef\u0005\u0017\u0000"+
		"\u0000fg\u0005\u0003\u0000\u0000g\u0015\u0001\u0000\u0000\u0000hi\u0005"+
		"\u000b\u0000\u0000ij\u0005\u0002\u0000\u0000jk\u0003\u001a\r\u0000kl\u0005"+
		"\u0003\u0000\u0000lm\u0005\u0004\u0000\u0000mn\u0003\u0018\f\u0000no\u0005"+
		"\u0004\u0000\u0000op\u0005\f\u0000\u0000pq\u0005\u0004\u0000\u0000qr\u0003"+
		"\u0018\f\u0000rs\u0005\u0004\u0000\u0000s\u0017\u0001\u0000\u0000\u0000"+
		"tx\u0005\u0005\u0000\u0000uw\u0003\u0004\u0002\u0000vu\u0001\u0000\u0000"+
		"\u0000wz\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000y{\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{\u007f"+
		"\u0005\u0006\u0000\u0000|~\u0003\u0006\u0003\u0000}|\u0001\u0000\u0000"+
		"\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0085\u0001\u0000\u0000\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\u0082\u0084\u0003\u0016\u000b\u0000\u0083"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u008b\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0003\u0014\n\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008d"+
		"\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\u0001\u0000\u0000\u0000\u008c\u0019\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0006\r\uffff\uffff\u0000\u008f\u0090"+
		"\u0005\r\u0000\u0000\u0090\u0091\u0003\u001a\r\u0000\u0091\u0092\u0005"+
		"\u000e\u0000\u0000\u0092\u0098\u0001\u0000\u0000\u0000\u0093\u0094\u0005"+
		"\u000f\u0000\u0000\u0094\u0098\u0003\u001a\r\n\u0095\u0098\u0005\u001b"+
		"\u0000\u0000\u0096\u0098\u0005\u001d\u0000\u0000\u0097\u008e\u0001\u0000"+
		"\u0000\u0000\u0097\u0093\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000"+
		"\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u00b0\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\n\t\u0000\u0000\u009a\u009b\u0005\u0010\u0000"+
		"\u0000\u009b\u00af\u0003\u001a\r\n\u009c\u009d\n\b\u0000\u0000\u009d\u009e"+
		"\u0005\u0011\u0000\u0000\u009e\u00af\u0003\u001a\r\t\u009f\u00a0\n\u0007"+
		"\u0000\u0000\u00a0\u00a1\u0005\u0012\u0000\u0000\u00a1\u00af\u0003\u001a"+
		"\r\b\u00a2\u00a3\n\u0006\u0000\u0000\u00a3\u00a4\u0005\u0013\u0000\u0000"+
		"\u00a4\u00af\u0003\u001a\r\u0007\u00a5\u00a6\n\u0005\u0000\u0000\u00a6"+
		"\u00a7\u0005\u0014\u0000\u0000\u00a7\u00af\u0003\u001a\r\u0006\u00a8\u00a9"+
		"\n\u0004\u0000\u0000\u00a9\u00aa\u0005\u0015\u0000\u0000\u00aa\u00af\u0003"+
		"\u001a\r\u0005\u00ab\u00ac\n\u0003\u0000\u0000\u00ac\u00ad\u0005\u0016"+
		"\u0000\u0000\u00ad\u00af\u0003\u001a\r\u0004\u00ae\u0099\u0001\u0000\u0000"+
		"\u0000\u00ae\u009c\u0001\u0000\u0000\u0000\u00ae\u009f\u0001\u0000\u0000"+
		"\u0000\u00ae\u00a2\u0001\u0000\u0000\u0000\u00ae\u00a5\u0001\u0000\u0000"+
		"\u0000\u00ae\u00a8\u0001\u0000\u0000\u0000\u00ae\u00ab\u0001\u0000\u0000"+
		"\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u001b\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\f)06G_x\u007f\u0085\u008b\u0097"+
		"\u00ae\u00b0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}