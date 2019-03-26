package xproject.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXHDLLexer extends Lexer {
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=12;
    public static final int RULE_COMMENT=9;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_XLONG=6;
    public static final int RULE_XDOUBLE=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators

    public InternalXHDLLexer() {;} 
    public InternalXHDLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXHDLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalXHDL.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:11:7: ( 'package' )
            // InternalXHDL.g:11:9: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:12:7: ( 'is' )
            // InternalXHDL.g:12:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:13:7: ( 'end' )
            // InternalXHDL.g:13:9: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:14:7: ( 'attribute' )
            // InternalXHDL.g:14:9: 'attribute'
            {
            match("attribute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:15:7: ( 'subtype' )
            // InternalXHDL.g:15:9: 'subtype'
            {
            match("subtype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:16:7: ( 'signal' )
            // InternalXHDL.g:16:9: 'signal'
            {
            match("signal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:17:7: ( ':' )
            // InternalXHDL.g:17:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:18:7: ( 'type' )
            // InternalXHDL.g:18:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:19:7: ( 'array' )
            // InternalXHDL.g:19:9: 'array'
            {
            match("array"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:20:7: ( 'of' )
            // InternalXHDL.g:20:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:21:7: ( 'range' )
            // InternalXHDL.g:21:9: 'range'
            {
            match("range"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:22:7: ( '<>' )
            // InternalXHDL.g:22:9: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:23:7: ( 'to' )
            // InternalXHDL.g:23:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:24:7: ( '\\'' )
            // InternalXHDL.g:24:9: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:25:7: ( 'units' )
            // InternalXHDL.g:25:9: 'units'
            {
            match("units"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:26:7: ( 'function' )
            // InternalXHDL.g:26:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:27:7: ( 'return' )
            // InternalXHDL.g:27:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:28:7: ( 'impure' )
            // InternalXHDL.g:28:9: 'impure'
            {
            match("impure"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:29:7: ( ';' )
            // InternalXHDL.g:29:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:30:7: ( ';=' )
            // InternalXHDL.g:30:9: ';='
            {
            match(";="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:31:7: ( '(' )
            // InternalXHDL.g:31:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:32:7: ( ')' )
            // InternalXHDL.g:32:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:33:7: ( '=' )
            // InternalXHDL.g:33:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:34:7: ( ',' )
            // InternalXHDL.g:34:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "RULE_COMMENT"
    public final void mRULE_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4358:14: ( '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalXHDL.g:4358:16: '--' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("--"); 

            // InternalXHDL.g:4358:21: (~ ( ( '\\n' | '\\r' ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalXHDL.g:4358:21: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalXHDL.g:4358:37: ( ( '\\r' )? '\\n' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalXHDL.g:4358:38: ( '\\r' )? '\\n'
                    {
                    // InternalXHDL.g:4358:38: ( '\\r' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalXHDL.g:4358:38: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COMMENT"

    // $ANTLR start "RULE_XLONG"
    public final void mRULE_XLONG() throws RecognitionException {
        try {
            int _type = RULE_XLONG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4360:12: ( ( '-' )? ( '0' .. '9' )+ )
            // InternalXHDL.g:4360:14: ( '-' )? ( '0' .. '9' )+
            {
            // InternalXHDL.g:4360:14: ( '-' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalXHDL.g:4360:14: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalXHDL.g:4360:19: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalXHDL.g:4360:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_XLONG"

    // $ANTLR start "RULE_XDOUBLE"
    public final void mRULE_XDOUBLE() throws RecognitionException {
        try {
            int _type = RULE_XDOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4362:14: ( '[-+]?[0-9]*\\\\.?[0-9]+([eE][-+]?[0-9]+)?' )
            // InternalXHDL.g:4362:16: '[-+]?[0-9]*\\\\.?[0-9]+([eE][-+]?[0-9]+)?'
            {
            match("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_XDOUBLE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4364:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalXHDL.g:4364:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalXHDL.g:4364:11: ( '^' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='^') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXHDL.g:4364:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalXHDL.g:4364:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXHDL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4366:10: ( ( '0' .. '9' )+ )
            // InternalXHDL.g:4366:12: ( '0' .. '9' )+
            {
            // InternalXHDL.g:4366:12: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXHDL.g:4366:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4368:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalXHDL.g:4368:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalXHDL.g:4368:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\"') ) {
                alt11=1;
            }
            else if ( (LA11_0=='\'') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalXHDL.g:4368:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalXHDL.g:4368:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='\\') ) {
                            alt9=1;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='!')||(LA9_0>='#' && LA9_0<='[')||(LA9_0>=']' && LA9_0<='\uFFFF')) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalXHDL.g:4368:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXHDL.g:4368:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalXHDL.g:4368:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalXHDL.g:4368:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop10:
                    do {
                        int alt10=3;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\\') ) {
                            alt10=1;
                        }
                        else if ( ((LA10_0>='\u0000' && LA10_0<='&')||(LA10_0>='(' && LA10_0<='[')||(LA10_0>=']' && LA10_0<='\uFFFF')) ) {
                            alt10=2;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalXHDL.g:4368:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXHDL.g:4368:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4370:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalXHDL.g:4370:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalXHDL.g:4370:24: ( options {greedy=false; } : . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='*') ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1=='/') ) {
                        alt12=2;
                    }
                    else if ( ((LA12_1>='\u0000' && LA12_1<='.')||(LA12_1>='0' && LA12_1<='\uFFFF')) ) {
                        alt12=1;
                    }


                }
                else if ( ((LA12_0>='\u0000' && LA12_0<=')')||(LA12_0>='+' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalXHDL.g:4370:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4372:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalXHDL.g:4372:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalXHDL.g:4372:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalXHDL.g:4372:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // InternalXHDL.g:4372:40: ( ( '\\r' )? '\\n' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalXHDL.g:4372:41: ( '\\r' )? '\\n'
                    {
                    // InternalXHDL.g:4372:41: ( '\\r' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='\r') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalXHDL.g:4372:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4374:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalXHDL.g:4374:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalXHDL.g:4374:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>='\t' && LA16_0<='\n')||LA16_0=='\r'||LA16_0==' ') ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalXHDL.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalXHDL.g:4376:16: ( . )
            // InternalXHDL.g:4376:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalXHDL.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | RULE_COMMENT | RULE_XLONG | RULE_XDOUBLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt17=34;
        alt17 = dfa17.predict(input);
        switch (alt17) {
            case 1 :
                // InternalXHDL.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // InternalXHDL.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // InternalXHDL.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // InternalXHDL.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // InternalXHDL.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // InternalXHDL.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // InternalXHDL.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // InternalXHDL.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // InternalXHDL.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // InternalXHDL.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // InternalXHDL.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // InternalXHDL.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // InternalXHDL.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // InternalXHDL.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // InternalXHDL.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // InternalXHDL.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // InternalXHDL.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // InternalXHDL.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // InternalXHDL.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // InternalXHDL.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // InternalXHDL.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // InternalXHDL.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // InternalXHDL.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // InternalXHDL.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // InternalXHDL.g:1:154: RULE_COMMENT
                {
                mRULE_COMMENT(); 

                }
                break;
            case 26 :
                // InternalXHDL.g:1:167: RULE_XLONG
                {
                mRULE_XLONG(); 

                }
                break;
            case 27 :
                // InternalXHDL.g:1:178: RULE_XDOUBLE
                {
                mRULE_XDOUBLE(); 

                }
                break;
            case 28 :
                // InternalXHDL.g:1:191: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 29 :
                // InternalXHDL.g:1:199: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 30 :
                // InternalXHDL.g:1:208: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 31 :
                // InternalXHDL.g:1:220: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 32 :
                // InternalXHDL.g:1:236: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 33 :
                // InternalXHDL.g:1:252: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 34 :
                // InternalXHDL.g:1:260: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\1\uffff\5\35\1\uffff\3\35\1\33\1\54\2\35\1\61\4\uffff\1\33\1\67\2\33\1\uffff\2\33\2\uffff\1\35\1\uffff\1\76\6\35\1\uffff\1\35\1\106\1\107\2\35\3\uffff\2\35\10\uffff\1\67\4\uffff\1\35\1\uffff\1\35\1\116\5\35\2\uffff\6\35\1\uffff\4\35\1\136\7\35\1\146\2\35\1\uffff\1\151\1\35\1\153\2\35\1\156\1\35\1\uffff\1\35\1\161\1\uffff\1\162\1\uffff\1\35\1\164\1\uffff\1\35\1\166\2\uffff\1\35\1\uffff\1\35\1\uffff\1\171\1\172\2\uffff";
    static final String DFA17_eofS =
        "\173\uffff";
    static final String DFA17_minS =
        "\1\0\1\141\1\155\1\156\1\162\1\151\1\uffff\1\157\1\146\1\141\1\76\1\0\1\156\1\165\1\75\4\uffff\1\55\1\60\1\55\1\101\1\uffff\1\0\1\52\2\uffff\1\143\1\uffff\1\60\1\160\1\144\1\164\1\162\1\142\1\147\1\uffff\1\160\2\60\1\156\1\164\3\uffff\1\151\1\156\10\uffff\1\60\4\uffff\1\153\1\uffff\1\165\1\60\1\162\1\141\1\164\1\156\1\145\2\uffff\1\147\1\165\1\164\1\143\1\141\1\162\1\uffff\1\151\2\171\1\141\1\60\1\145\1\162\1\163\1\164\1\147\1\145\1\142\1\60\1\160\1\154\1\uffff\1\60\1\156\1\60\1\151\1\145\1\60\1\165\1\uffff\1\145\1\60\1\uffff\1\60\1\uffff\1\157\1\60\1\uffff\1\164\1\60\2\uffff\1\156\1\uffff\1\145\1\uffff\2\60\2\uffff";
    static final String DFA17_maxS =
        "\1\uffff\1\141\1\163\1\156\1\164\1\165\1\uffff\1\171\1\146\1\145\1\76\1\uffff\1\156\1\165\1\75\4\uffff\2\71\1\55\1\172\1\uffff\1\uffff\1\57\2\uffff\1\143\1\uffff\1\172\1\160\1\144\1\164\1\162\1\142\1\147\1\uffff\1\160\2\172\1\156\1\164\3\uffff\1\151\1\156\10\uffff\1\71\4\uffff\1\153\1\uffff\1\165\1\172\1\162\1\141\1\164\1\156\1\145\2\uffff\1\147\1\165\1\164\1\143\1\141\1\162\1\uffff\1\151\2\171\1\141\1\172\1\145\1\162\1\163\1\164\1\147\1\145\1\142\1\172\1\160\1\154\1\uffff\1\172\1\156\1\172\1\151\1\145\1\172\1\165\1\uffff\1\145\1\172\1\uffff\1\172\1\uffff\1\157\1\172\1\uffff\1\164\1\172\2\uffff\1\156\1\uffff\1\145\1\uffff\2\172\2\uffff";
    static final String DFA17_acceptS =
        "\6\uffff\1\7\10\uffff\1\25\1\26\1\27\1\30\4\uffff\1\34\2\uffff\1\41\1\42\1\uffff\1\34\7\uffff\1\7\5\uffff\1\14\1\16\1\36\2\uffff\1\24\1\23\1\25\1\26\1\27\1\30\1\31\1\32\1\uffff\1\33\1\37\1\40\1\41\1\uffff\1\2\7\uffff\1\15\1\12\6\uffff\1\3\17\uffff\1\10\7\uffff\1\11\2\uffff\1\13\1\uffff\1\17\2\uffff\1\22\2\uffff\1\6\1\21\1\uffff\1\1\1\uffff\1\5\2\uffff\1\20\1\4";
    static final String DFA17_specialS =
        "\1\1\12\uffff\1\0\14\uffff\1\2\142\uffff}>";
    static final String[] DFA17_transitionS = {
            "\11\33\2\32\2\33\1\32\22\33\1\32\1\33\1\30\4\33\1\13\1\17\1\20\2\33\1\22\1\23\1\33\1\31\12\24\1\6\1\16\1\12\1\21\3\33\32\27\1\25\2\33\1\26\1\27\1\33\1\4\3\27\1\3\1\15\2\27\1\2\5\27\1\10\1\1\1\27\1\11\1\5\1\7\1\14\5\27\uff85\33",
            "\1\34",
            "\1\37\5\uffff\1\36",
            "\1\40",
            "\1\42\1\uffff\1\41",
            "\1\44\13\uffff\1\43",
            "",
            "\1\47\11\uffff\1\46",
            "\1\50",
            "\1\51\3\uffff\1\52",
            "\1\53",
            "\0\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "",
            "",
            "",
            "",
            "\1\66\2\uffff\12\67",
            "\12\70",
            "\1\71",
            "\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\0\55",
            "\1\72\4\uffff\1\73",
            "",
            "",
            "\1\75",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "",
            "\1\105",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\110",
            "\1\111",
            "",
            "",
            "",
            "\1\112",
            "\1\113",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\70",
            "",
            "",
            "",
            "",
            "\1\114",
            "",
            "\1\115",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "",
            "",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\147",
            "\1\150",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\152",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\154",
            "\1\155",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\1\157",
            "",
            "\1\160",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\163",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "\1\165",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            "",
            "\1\167",
            "",
            "\1\170",
            "",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "\12\35\7\uffff\32\35\4\uffff\1\35\1\uffff\32\35",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | RULE_COMMENT | RULE_XLONG | RULE_XDOUBLE | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_11 = input.LA(1);

                        s = -1;
                        if ( ((LA17_11>='\u0000' && LA17_11<='\uFFFF')) ) {s = 45;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_0 = input.LA(1);

                        s = -1;
                        if ( (LA17_0=='p') ) {s = 1;}

                        else if ( (LA17_0=='i') ) {s = 2;}

                        else if ( (LA17_0=='e') ) {s = 3;}

                        else if ( (LA17_0=='a') ) {s = 4;}

                        else if ( (LA17_0=='s') ) {s = 5;}

                        else if ( (LA17_0==':') ) {s = 6;}

                        else if ( (LA17_0=='t') ) {s = 7;}

                        else if ( (LA17_0=='o') ) {s = 8;}

                        else if ( (LA17_0=='r') ) {s = 9;}

                        else if ( (LA17_0=='<') ) {s = 10;}

                        else if ( (LA17_0=='\'') ) {s = 11;}

                        else if ( (LA17_0=='u') ) {s = 12;}

                        else if ( (LA17_0=='f') ) {s = 13;}

                        else if ( (LA17_0==';') ) {s = 14;}

                        else if ( (LA17_0=='(') ) {s = 15;}

                        else if ( (LA17_0==')') ) {s = 16;}

                        else if ( (LA17_0=='=') ) {s = 17;}

                        else if ( (LA17_0==',') ) {s = 18;}

                        else if ( (LA17_0=='-') ) {s = 19;}

                        else if ( ((LA17_0>='0' && LA17_0<='9')) ) {s = 20;}

                        else if ( (LA17_0=='[') ) {s = 21;}

                        else if ( (LA17_0=='^') ) {s = 22;}

                        else if ( ((LA17_0>='A' && LA17_0<='Z')||LA17_0=='_'||(LA17_0>='b' && LA17_0<='d')||(LA17_0>='g' && LA17_0<='h')||(LA17_0>='j' && LA17_0<='n')||LA17_0=='q'||(LA17_0>='v' && LA17_0<='z')) ) {s = 23;}

                        else if ( (LA17_0=='\"') ) {s = 24;}

                        else if ( (LA17_0=='/') ) {s = 25;}

                        else if ( ((LA17_0>='\t' && LA17_0<='\n')||LA17_0=='\r'||LA17_0==' ') ) {s = 26;}

                        else if ( ((LA17_0>='\u0000' && LA17_0<='\b')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\u001F')||LA17_0=='!'||(LA17_0>='#' && LA17_0<='&')||(LA17_0>='*' && LA17_0<='+')||LA17_0=='.'||(LA17_0>='>' && LA17_0<='@')||(LA17_0>='\\' && LA17_0<=']')||LA17_0=='`'||(LA17_0>='{' && LA17_0<='\uFFFF')) ) {s = 27;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA17_24 = input.LA(1);

                        s = -1;
                        if ( ((LA17_24>='\u0000' && LA17_24<='\uFFFF')) ) {s = 45;}

                        else s = 27;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}