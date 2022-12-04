// Generated from /Users/cy/Desktop/4302Project/Project/src/antlr/expr.g4 by ANTLR 4.9.2

	package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class exprLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "VOIDCALL", "DATA_TYPE", "VOID_TYPE", "BOOL", 
			"TEST_NAME", "VAR_NAME", "CLASS_NAME", "METHODNAME", "DOUBLE", "NUM", 
			"CHAR", "STRING", "COMMENT", "WS"
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


	public exprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u014e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\5\37\u00e8\n\37\3 \3 \3 \3 \3"+
		" \3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u00f8\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7"+
		"\"\u0101\n\"\f\"\16\"\u0104\13\"\3#\3#\7#\u0108\n#\f#\16#\u010b\13#\3"+
		"$\3$\7$\u010f\n$\f$\16$\u0112\13$\3%\3%\7%\u0116\n%\f%\16%\u0119\13%\3"+
		"&\3&\3&\3&\3&\3\'\3\'\5\'\u0122\n\'\3\'\3\'\7\'\u0126\n\'\f\'\16\'\u0129"+
		"\13\'\5\'\u012b\n\'\3(\3(\3(\3(\3(\3(\5(\u0133\n(\3)\3)\3)\7)\u0138\n"+
		")\f)\16)\u013b\13)\3)\3)\3*\3*\7*\u0141\n*\f*\16*\u0144\13*\3*\3*\3+\6"+
		"+\u0149\n+\r+\16+\u014a\3+\3+\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\r"+
		"\6\2\62;C\\aac|\3\2c|\5\2\62;aac|\3\2C\\\5\2\62;C\\aa\3\2\62;\3\2\63;"+
		"\5\2\62;C\\c|\6\2\"\"\62;C\\c|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u015d"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\3W\3\2\2\2\5\\\3\2\2\2\7^\3\2\2\2\ta\3\2\2\2\13d\3\2\2\2\rm"+
		"\3\2\2\2\17o\3\2\2\2\21q\3\2\2\2\23\177\3\2\2\2\25\u0084\3\2\2\2\27\u0086"+
		"\3\2\2\2\31\u0088\3\2\2\2\33\u008a\3\2\2\2\35\u008f\3\2\2\2\37\u009a\3"+
		"\2\2\2!\u00a5\3\2\2\2#\u00a7\3\2\2\2%\u00a9\3\2\2\2\'\u00ab\3\2\2\2)\u00ad"+
		"\3\2\2\2+\u00b1\3\2\2\2-\u00b4\3\2\2\2/\u00b7\3\2\2\2\61\u00ba\3\2\2\2"+
		"\63\u00bd\3\2\2\2\65\u00c0\3\2\2\2\67\u00c3\3\2\2\29\u00c5\3\2\2\2;\u00c7"+
		"\3\2\2\2=\u00e7\3\2\2\2?\u00e9\3\2\2\2A\u00f7\3\2\2\2C\u00f9\3\2\2\2E"+
		"\u0105\3\2\2\2G\u010c\3\2\2\2I\u0113\3\2\2\2K\u011a\3\2\2\2M\u012a\3\2"+
		"\2\2O\u0132\3\2\2\2Q\u0134\3\2\2\2S\u013e\3\2\2\2U\u0148\3\2\2\2WX\7i"+
		"\2\2XY\7c\2\2YZ\7o\2\2Z[\7g\2\2[\4\3\2\2\2\\]\7#\2\2]\6\3\2\2\2^_\7>\2"+
		"\2_`\7>\2\2`\b\3\2\2\2ab\7>\2\2bc\7/\2\2c\n\3\2\2\2de\7o\2\2ef\7{\2\2"+
		"fg\7o\2\2gh\7g\2\2hi\7v\2\2ij\7j\2\2jk\7q\2\2kl\7f\2\2l\f\3\2\2\2mn\7"+
		"]\2\2n\16\3\2\2\2op\7_\2\2p\20\3\2\2\2qr\7l\2\2rs\7c\2\2st\7e\2\2tu\7"+
		"m\2\2uv\7k\2\2vw\7g\2\2wx\7T\2\2xy\7g\2\2yz\7v\2\2z{\7w\2\2{|\7t\2\2|"+
		"}\7p\2\2}~\7u\2\2~\22\3\2\2\2\177\u0080\7n\2\2\u0080\u0081\7q\2\2\u0081"+
		"\u0082\7q\2\2\u0082\u0083\7r\2\2\u0083\24\3\2\2\2\u0084\u0085\7*\2\2\u0085"+
		"\26\3\2\2\2\u0086\u0087\7+\2\2\u0087\30\3\2\2\2\u0088\u0089\7.\2\2\u0089"+
		"\32\3\2\2\2\u008a\u008b\7v\2\2\u008b\u008c\7g\2\2\u008c\u008d\7u\2\2\u008d"+
		"\u008e\7v\2\2\u008e\34\3\2\2\2\u008f\u0090\7l\2\2\u0090\u0091\7c\2\2\u0091"+
		"\u0092\7e\2\2\u0092\u0093\7m\2\2\u0093\u0094\7k\2\2\u0094\u0095\7g\2\2"+
		"\u0095\u0096\7C\2\2\u0096\u0097\7u\2\2\u0097\u0098\7m\2\2\u0098\u0099"+
		"\7u\2\2\u0099\36\3\2\2\2\u009a\u009b\7g\2\2\u009b\u009c\7n\2\2\u009c\u009d"+
		"\7u\2\2\u009d\u009e\7g\2\2\u009e\u009f\7L\2\2\u009f\u00a0\7c\2\2\u00a0"+
		"\u00a1\7e\2\2\u00a1\u00a2\7m\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7g\2\2"+
		"\u00a4 \3\2\2\2\u00a5\u00a6\7-\2\2\u00a6\"\3\2\2\2\u00a7\u00a8\7/\2\2"+
		"\u00a8$\3\2\2\2\u00a9\u00aa\7,\2\2\u00aa&\3\2\2\2\u00ab\u00ac\7\61\2\2"+
		"\u00ac(\3\2\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af\7q\2\2\u00af\u00b0\7v\2"+
		"\2\u00b0*\3\2\2\2\u00b1\u00b2\7(\2\2\u00b2\u00b3\7(\2\2\u00b3,\3\2\2\2"+
		"\u00b4\u00b5\7~\2\2\u00b5\u00b6\7~\2\2\u00b6.\3\2\2\2\u00b7\u00b8\7?\2"+
		"\2\u00b8\u00b9\7?\2\2\u00b9\60\3\2\2\2\u00ba\u00bb\7\61\2\2\u00bb\u00bc"+
		"\7?\2\2\u00bc\62\3\2\2\2\u00bd\u00be\7@\2\2\u00be\u00bf\7?\2\2\u00bf\64"+
		"\3\2\2\2\u00c0\u00c1\7>\2\2\u00c1\u00c2\7?\2\2\u00c2\66\3\2\2\2\u00c3"+
		"\u00c4\7@\2\2\u00c48\3\2\2\2\u00c5\u00c6\7>\2\2\u00c6:\3\2\2\2\u00c7\u00c8"+
		"\7x\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7f\2\2\u00cb"+
		"\u00cc\7a\2\2\u00cc<\3\2\2\2\u00cd\u00ce\7K\2\2\u00ce\u00cf\7P\2\2\u00cf"+
		"\u00e8\7V\2\2\u00d0\u00d1\7F\2\2\u00d1\u00d2\7Q\2\2\u00d2\u00d3\7W\2\2"+
		"\u00d3\u00d4\7D\2\2\u00d4\u00d5\7N\2\2\u00d5\u00e8\7G\2\2\u00d6\u00d7"+
		"\7D\2\2\u00d7\u00d8\7Q\2\2\u00d8\u00d9\7Q\2\2\u00d9\u00da\7N\2\2\u00da"+
		"\u00db\7G\2\2\u00db\u00dc\7C\2\2\u00dc\u00e8\7P\2\2\u00dd\u00de\7U\2\2"+
		"\u00de\u00df\7V\2\2\u00df\u00e0\7T\2\2\u00e0\u00e1\7K\2\2\u00e1\u00e2"+
		"\7P\2\2\u00e2\u00e8\7I\2\2\u00e3\u00e4\7E\2\2\u00e4\u00e5\7J\2\2\u00e5"+
		"\u00e6\7C\2\2\u00e6\u00e8\7T\2\2\u00e7\u00cd\3\2\2\2\u00e7\u00d0\3\2\2"+
		"\2\u00e7\u00d6\3\2\2\2\u00e7\u00dd\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8>"+
		"\3\2\2\2\u00e9\u00ea\7X\2\2\u00ea\u00eb\7Q\2\2\u00eb\u00ec\7K\2\2\u00ec"+
		"\u00ed\7F\2\2\u00ed@\3\2\2\2\u00ee\u00ef\7V\2\2\u00ef\u00f0\7T\2\2\u00f0"+
		"\u00f1\7W\2\2\u00f1\u00f8\7G\2\2\u00f2\u00f3\7H\2\2\u00f3\u00f4\7C\2\2"+
		"\u00f4\u00f5\7N\2\2\u00f5\u00f6\7U\2\2\u00f6\u00f8\7G\2\2\u00f7\u00ee"+
		"\3\2\2\2\u00f7\u00f2\3\2\2\2\u00f8B\3\2\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb"+
		"\7g\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7a\2\2\u00fe"+
		"\u0102\3\2\2\2\u00ff\u0101\t\2\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2"+
		"\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103D\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0105\u0109\t\3\2\2\u0106\u0108\t\4\2\2\u0107\u0106\3\2\2\2\u0108"+
		"\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010aF\3\2\2\2"+
		"\u010b\u0109\3\2\2\2\u010c\u0110\t\5\2\2\u010d\u010f\t\3\2\2\u010e\u010d"+
		"\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"H\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0117\t\5\2\2\u0114\u0116\t\6\2\2"+
		"\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118J\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\5M\'\2\u011b\u011c"+
		"\7\60\2\2\u011c\u011d\t\7\2\2\u011d\u011e\t\7\2\2\u011eL\3\2\2\2\u011f"+
		"\u012b\7\62\2\2\u0120\u0122\7/\2\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\u0127\t\b\2\2\u0124\u0126\t\7\2\2\u0125"+
		"\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u011f\3\2\2\2\u012a"+
		"\u0121\3\2\2\2\u012bN\3\2\2\2\u012c\u012d\7)\2\2\u012d\u012e\t\3\2\2\u012e"+
		"\u0133\7)\2\2\u012f\u0130\7)\2\2\u0130\u0131\t\5\2\2\u0131\u0133\7)\2"+
		"\2\u0132\u012c\3\2\2\2\u0132\u012f\3\2\2\2\u0133P\3\2\2\2\u0134\u0135"+
		"\7$\2\2\u0135\u0139\t\t\2\2\u0136\u0138\t\n\2\2\u0137\u0136\3\2\2\2\u0138"+
		"\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2"+
		"\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7$\2\2\u013dR\3\2\2\2\u013e\u0142"+
		"\7%\2\2\u013f\u0141\n\13\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2"+
		"\2\2\u0145\u0146\b*\2\2\u0146T\3\2\2\2\u0147\u0149\t\f\2\2\u0148\u0147"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\b+\2\2\u014dV\3\2\2\2\20\2\u00e7\u00f7\u0102"+
		"\u0109\u0110\u0117\u0121\u0127\u012a\u0132\u0139\u0142\u014a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}