package xproject.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import xproject.services.XHDLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXHDLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'is'", "'end'", "';'", "'attribute'", "':'", "'subtype'", "'signal'", "'type'", "'array'", "'('", "'range'", "'<>'", "')'", "'of'", "'to'", "'units'", "'='", "','"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalXHDLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXHDLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXHDLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalXHDL.g"; }


    	private XHDLGrammarAccess grammarAccess;

    	public void setGrammarAccess(XHDLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRulexhdl"
    // InternalXHDL.g:53:1: entryRulexhdl : rulexhdl EOF ;
    public final void entryRulexhdl() throws RecognitionException {
        try {
            // InternalXHDL.g:54:1: ( rulexhdl EOF )
            // InternalXHDL.g:55:1: rulexhdl EOF
            {
             before(grammarAccess.getXhdlRule()); 
            pushFollow(FOLLOW_1);
            rulexhdl();

            state._fsp--;

             after(grammarAccess.getXhdlRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulexhdl"


    // $ANTLR start "rulexhdl"
    // InternalXHDL.g:62:1: rulexhdl : ( ( rule__Xhdl__PackagesAssignment )* ) ;
    public final void rulexhdl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:66:2: ( ( ( rule__Xhdl__PackagesAssignment )* ) )
            // InternalXHDL.g:67:2: ( ( rule__Xhdl__PackagesAssignment )* )
            {
            // InternalXHDL.g:67:2: ( ( rule__Xhdl__PackagesAssignment )* )
            // InternalXHDL.g:68:3: ( rule__Xhdl__PackagesAssignment )*
            {
             before(grammarAccess.getXhdlAccess().getPackagesAssignment()); 
            // InternalXHDL.g:69:3: ( rule__Xhdl__PackagesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalXHDL.g:69:4: rule__Xhdl__PackagesAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Xhdl__PackagesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getXhdlAccess().getPackagesAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulexhdl"


    // $ANTLR start "entryRuleXPackage"
    // InternalXHDL.g:78:1: entryRuleXPackage : ruleXPackage EOF ;
    public final void entryRuleXPackage() throws RecognitionException {
        try {
            // InternalXHDL.g:79:1: ( ruleXPackage EOF )
            // InternalXHDL.g:80:1: ruleXPackage EOF
            {
             before(grammarAccess.getXPackageRule()); 
            pushFollow(FOLLOW_1);
            ruleXPackage();

            state._fsp--;

             after(grammarAccess.getXPackageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXPackage"


    // $ANTLR start "ruleXPackage"
    // InternalXHDL.g:87:1: ruleXPackage : ( ( rule__XPackage__Group__0 ) ) ;
    public final void ruleXPackage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:91:2: ( ( ( rule__XPackage__Group__0 ) ) )
            // InternalXHDL.g:92:2: ( ( rule__XPackage__Group__0 ) )
            {
            // InternalXHDL.g:92:2: ( ( rule__XPackage__Group__0 ) )
            // InternalXHDL.g:93:3: ( rule__XPackage__Group__0 )
            {
             before(grammarAccess.getXPackageAccess().getGroup()); 
            // InternalXHDL.g:94:3: ( rule__XPackage__Group__0 )
            // InternalXHDL.g:94:4: rule__XPackage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XPackage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXPackageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXPackage"


    // $ANTLR start "entryRuleXElement"
    // InternalXHDL.g:103:1: entryRuleXElement : ruleXElement EOF ;
    public final void entryRuleXElement() throws RecognitionException {
        try {
            // InternalXHDL.g:104:1: ( ruleXElement EOF )
            // InternalXHDL.g:105:1: ruleXElement EOF
            {
             before(grammarAccess.getXElementRule()); 
            pushFollow(FOLLOW_1);
            ruleXElement();

            state._fsp--;

             after(grammarAccess.getXElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXElement"


    // $ANTLR start "ruleXElement"
    // InternalXHDL.g:112:1: ruleXElement : ( ( rule__XElement__Alternatives ) ) ;
    public final void ruleXElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:116:2: ( ( ( rule__XElement__Alternatives ) ) )
            // InternalXHDL.g:117:2: ( ( rule__XElement__Alternatives ) )
            {
            // InternalXHDL.g:117:2: ( ( rule__XElement__Alternatives ) )
            // InternalXHDL.g:118:3: ( rule__XElement__Alternatives )
            {
             before(grammarAccess.getXElementAccess().getAlternatives()); 
            // InternalXHDL.g:119:3: ( rule__XElement__Alternatives )
            // InternalXHDL.g:119:4: rule__XElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__XElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXElement"


    // $ANTLR start "entryRuleXAttribute"
    // InternalXHDL.g:128:1: entryRuleXAttribute : ruleXAttribute EOF ;
    public final void entryRuleXAttribute() throws RecognitionException {
        try {
            // InternalXHDL.g:129:1: ( ruleXAttribute EOF )
            // InternalXHDL.g:130:1: ruleXAttribute EOF
            {
             before(grammarAccess.getXAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleXAttribute();

            state._fsp--;

             after(grammarAccess.getXAttributeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXAttribute"


    // $ANTLR start "ruleXAttribute"
    // InternalXHDL.g:137:1: ruleXAttribute : ( ( rule__XAttribute__Group__0 ) ) ;
    public final void ruleXAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:141:2: ( ( ( rule__XAttribute__Group__0 ) ) )
            // InternalXHDL.g:142:2: ( ( rule__XAttribute__Group__0 ) )
            {
            // InternalXHDL.g:142:2: ( ( rule__XAttribute__Group__0 ) )
            // InternalXHDL.g:143:3: ( rule__XAttribute__Group__0 )
            {
             before(grammarAccess.getXAttributeAccess().getGroup()); 
            // InternalXHDL.g:144:3: ( rule__XAttribute__Group__0 )
            // InternalXHDL.g:144:4: rule__XAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXAttribute"


    // $ANTLR start "entryRuleXSubType"
    // InternalXHDL.g:153:1: entryRuleXSubType : ruleXSubType EOF ;
    public final void entryRuleXSubType() throws RecognitionException {
        try {
            // InternalXHDL.g:154:1: ( ruleXSubType EOF )
            // InternalXHDL.g:155:1: ruleXSubType EOF
            {
             before(grammarAccess.getXSubTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleXSubType();

            state._fsp--;

             after(grammarAccess.getXSubTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXSubType"


    // $ANTLR start "ruleXSubType"
    // InternalXHDL.g:162:1: ruleXSubType : ( ( rule__XSubType__Group__0 ) ) ;
    public final void ruleXSubType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:166:2: ( ( ( rule__XSubType__Group__0 ) ) )
            // InternalXHDL.g:167:2: ( ( rule__XSubType__Group__0 ) )
            {
            // InternalXHDL.g:167:2: ( ( rule__XSubType__Group__0 ) )
            // InternalXHDL.g:168:3: ( rule__XSubType__Group__0 )
            {
             before(grammarAccess.getXSubTypeAccess().getGroup()); 
            // InternalXHDL.g:169:3: ( rule__XSubType__Group__0 )
            // InternalXHDL.g:169:4: rule__XSubType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XSubType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXSubTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXSubType"


    // $ANTLR start "entryRuleXSignal"
    // InternalXHDL.g:178:1: entryRuleXSignal : ruleXSignal EOF ;
    public final void entryRuleXSignal() throws RecognitionException {
        try {
            // InternalXHDL.g:179:1: ( ruleXSignal EOF )
            // InternalXHDL.g:180:1: ruleXSignal EOF
            {
             before(grammarAccess.getXSignalRule()); 
            pushFollow(FOLLOW_1);
            ruleXSignal();

            state._fsp--;

             after(grammarAccess.getXSignalRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXSignal"


    // $ANTLR start "ruleXSignal"
    // InternalXHDL.g:187:1: ruleXSignal : ( ( rule__XSignal__Group__0 ) ) ;
    public final void ruleXSignal() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:191:2: ( ( ( rule__XSignal__Group__0 ) ) )
            // InternalXHDL.g:192:2: ( ( rule__XSignal__Group__0 ) )
            {
            // InternalXHDL.g:192:2: ( ( rule__XSignal__Group__0 ) )
            // InternalXHDL.g:193:3: ( rule__XSignal__Group__0 )
            {
             before(grammarAccess.getXSignalAccess().getGroup()); 
            // InternalXHDL.g:194:3: ( rule__XSignal__Group__0 )
            // InternalXHDL.g:194:4: rule__XSignal__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XSignal__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXSignalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXSignal"


    // $ANTLR start "entryRuleXType"
    // InternalXHDL.g:203:1: entryRuleXType : ruleXType EOF ;
    public final void entryRuleXType() throws RecognitionException {
        try {
            // InternalXHDL.g:204:1: ( ruleXType EOF )
            // InternalXHDL.g:205:1: ruleXType EOF
            {
             before(grammarAccess.getXTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleXType();

            state._fsp--;

             after(grammarAccess.getXTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXType"


    // $ANTLR start "ruleXType"
    // InternalXHDL.g:212:1: ruleXType : ( ( rule__XType__Alternatives ) ) ;
    public final void ruleXType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:216:2: ( ( ( rule__XType__Alternatives ) ) )
            // InternalXHDL.g:217:2: ( ( rule__XType__Alternatives ) )
            {
            // InternalXHDL.g:217:2: ( ( rule__XType__Alternatives ) )
            // InternalXHDL.g:218:3: ( rule__XType__Alternatives )
            {
             before(grammarAccess.getXTypeAccess().getAlternatives()); 
            // InternalXHDL.g:219:3: ( rule__XType__Alternatives )
            // InternalXHDL.g:219:4: rule__XType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__XType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getXTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXType"


    // $ANTLR start "entryRuleXArray"
    // InternalXHDL.g:228:1: entryRuleXArray : ruleXArray EOF ;
    public final void entryRuleXArray() throws RecognitionException {
        try {
            // InternalXHDL.g:229:1: ( ruleXArray EOF )
            // InternalXHDL.g:230:1: ruleXArray EOF
            {
             before(grammarAccess.getXArrayRule()); 
            pushFollow(FOLLOW_1);
            ruleXArray();

            state._fsp--;

             after(grammarAccess.getXArrayRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXArray"


    // $ANTLR start "ruleXArray"
    // InternalXHDL.g:237:1: ruleXArray : ( ( rule__XArray__Group__0 ) ) ;
    public final void ruleXArray() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:241:2: ( ( ( rule__XArray__Group__0 ) ) )
            // InternalXHDL.g:242:2: ( ( rule__XArray__Group__0 ) )
            {
            // InternalXHDL.g:242:2: ( ( rule__XArray__Group__0 ) )
            // InternalXHDL.g:243:3: ( rule__XArray__Group__0 )
            {
             before(grammarAccess.getXArrayAccess().getGroup()); 
            // InternalXHDL.g:244:3: ( rule__XArray__Group__0 )
            // InternalXHDL.g:244:4: rule__XArray__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XArray__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXArrayAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXArray"


    // $ANTLR start "entryRuleXRange"
    // InternalXHDL.g:253:1: entryRuleXRange : ruleXRange EOF ;
    public final void entryRuleXRange() throws RecognitionException {
        try {
            // InternalXHDL.g:254:1: ( ruleXRange EOF )
            // InternalXHDL.g:255:1: ruleXRange EOF
            {
             before(grammarAccess.getXRangeRule()); 
            pushFollow(FOLLOW_1);
            ruleXRange();

            state._fsp--;

             after(grammarAccess.getXRangeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXRange"


    // $ANTLR start "ruleXRange"
    // InternalXHDL.g:262:1: ruleXRange : ( ( rule__XRange__Group__0 ) ) ;
    public final void ruleXRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:266:2: ( ( ( rule__XRange__Group__0 ) ) )
            // InternalXHDL.g:267:2: ( ( rule__XRange__Group__0 ) )
            {
            // InternalXHDL.g:267:2: ( ( rule__XRange__Group__0 ) )
            // InternalXHDL.g:268:3: ( rule__XRange__Group__0 )
            {
             before(grammarAccess.getXRangeAccess().getGroup()); 
            // InternalXHDL.g:269:3: ( rule__XRange__Group__0 )
            // InternalXHDL.g:269:4: rule__XRange__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XRange__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXRangeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXRange"


    // $ANTLR start "entryRuleXUnits"
    // InternalXHDL.g:278:1: entryRuleXUnits : ruleXUnits EOF ;
    public final void entryRuleXUnits() throws RecognitionException {
        try {
            // InternalXHDL.g:279:1: ( ruleXUnits EOF )
            // InternalXHDL.g:280:1: ruleXUnits EOF
            {
             before(grammarAccess.getXUnitsRule()); 
            pushFollow(FOLLOW_1);
            ruleXUnits();

            state._fsp--;

             after(grammarAccess.getXUnitsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXUnits"


    // $ANTLR start "ruleXUnits"
    // InternalXHDL.g:287:1: ruleXUnits : ( ( rule__XUnits__Group__0 ) ) ;
    public final void ruleXUnits() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:291:2: ( ( ( rule__XUnits__Group__0 ) ) )
            // InternalXHDL.g:292:2: ( ( rule__XUnits__Group__0 ) )
            {
            // InternalXHDL.g:292:2: ( ( rule__XUnits__Group__0 ) )
            // InternalXHDL.g:293:3: ( rule__XUnits__Group__0 )
            {
             before(grammarAccess.getXUnitsAccess().getGroup()); 
            // InternalXHDL.g:294:3: ( rule__XUnits__Group__0 )
            // InternalXHDL.g:294:4: rule__XUnits__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XUnits__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXUnitsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXUnits"


    // $ANTLR start "entryRuleXUnit"
    // InternalXHDL.g:303:1: entryRuleXUnit : ruleXUnit EOF ;
    public final void entryRuleXUnit() throws RecognitionException {
        try {
            // InternalXHDL.g:304:1: ( ruleXUnit EOF )
            // InternalXHDL.g:305:1: ruleXUnit EOF
            {
             before(grammarAccess.getXUnitRule()); 
            pushFollow(FOLLOW_1);
            ruleXUnit();

            state._fsp--;

             after(grammarAccess.getXUnitRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXUnit"


    // $ANTLR start "ruleXUnit"
    // InternalXHDL.g:312:1: ruleXUnit : ( ( rule__XUnit__Group__0 ) ) ;
    public final void ruleXUnit() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:316:2: ( ( ( rule__XUnit__Group__0 ) ) )
            // InternalXHDL.g:317:2: ( ( rule__XUnit__Group__0 ) )
            {
            // InternalXHDL.g:317:2: ( ( rule__XUnit__Group__0 ) )
            // InternalXHDL.g:318:3: ( rule__XUnit__Group__0 )
            {
             before(grammarAccess.getXUnitAccess().getGroup()); 
            // InternalXHDL.g:319:3: ( rule__XUnit__Group__0 )
            // InternalXHDL.g:319:4: rule__XUnit__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XUnit__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXUnitAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXUnit"


    // $ANTLR start "entryRuleXEnums"
    // InternalXHDL.g:328:1: entryRuleXEnums : ruleXEnums EOF ;
    public final void entryRuleXEnums() throws RecognitionException {
        try {
            // InternalXHDL.g:329:1: ( ruleXEnums EOF )
            // InternalXHDL.g:330:1: ruleXEnums EOF
            {
             before(grammarAccess.getXEnumsRule()); 
            pushFollow(FOLLOW_1);
            ruleXEnums();

            state._fsp--;

             after(grammarAccess.getXEnumsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXEnums"


    // $ANTLR start "ruleXEnums"
    // InternalXHDL.g:337:1: ruleXEnums : ( ( rule__XEnums__Group__0 ) ) ;
    public final void ruleXEnums() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:341:2: ( ( ( rule__XEnums__Group__0 ) ) )
            // InternalXHDL.g:342:2: ( ( rule__XEnums__Group__0 ) )
            {
            // InternalXHDL.g:342:2: ( ( rule__XEnums__Group__0 ) )
            // InternalXHDL.g:343:3: ( rule__XEnums__Group__0 )
            {
             before(grammarAccess.getXEnumsAccess().getGroup()); 
            // InternalXHDL.g:344:3: ( rule__XEnums__Group__0 )
            // InternalXHDL.g:344:4: rule__XEnums__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XEnums__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXEnumsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXEnums"


    // $ANTLR start "rule__XElement__Alternatives"
    // InternalXHDL.g:352:1: rule__XElement__Alternatives : ( ( ruleXType ) | ( ruleXSignal ) | ( ruleXSubType ) | ( ruleXAttribute ) );
    public final void rule__XElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:356:1: ( ( ruleXType ) | ( ruleXSignal ) | ( ruleXSubType ) | ( ruleXAttribute ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 19:
            case 20:
            case 22:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 17:
                {
                alt2=3;
                }
                break;
            case 15:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalXHDL.g:357:2: ( ruleXType )
                    {
                    // InternalXHDL.g:357:2: ( ruleXType )
                    // InternalXHDL.g:358:3: ruleXType
                    {
                     before(grammarAccess.getXElementAccess().getXTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleXType();

                    state._fsp--;

                     after(grammarAccess.getXElementAccess().getXTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXHDL.g:363:2: ( ruleXSignal )
                    {
                    // InternalXHDL.g:363:2: ( ruleXSignal )
                    // InternalXHDL.g:364:3: ruleXSignal
                    {
                     before(grammarAccess.getXElementAccess().getXSignalParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleXSignal();

                    state._fsp--;

                     after(grammarAccess.getXElementAccess().getXSignalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXHDL.g:369:2: ( ruleXSubType )
                    {
                    // InternalXHDL.g:369:2: ( ruleXSubType )
                    // InternalXHDL.g:370:3: ruleXSubType
                    {
                     before(grammarAccess.getXElementAccess().getXSubTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleXSubType();

                    state._fsp--;

                     after(grammarAccess.getXElementAccess().getXSubTypeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalXHDL.g:375:2: ( ruleXAttribute )
                    {
                    // InternalXHDL.g:375:2: ( ruleXAttribute )
                    // InternalXHDL.g:376:3: ruleXAttribute
                    {
                     before(grammarAccess.getXElementAccess().getXAttributeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleXAttribute();

                    state._fsp--;

                     after(grammarAccess.getXElementAccess().getXAttributeParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XElement__Alternatives"


    // $ANTLR start "rule__XType__Alternatives"
    // InternalXHDL.g:385:1: rule__XType__Alternatives : ( ( ( rule__XType__Group_0__0 ) ) | ( ruleXRange ) | ( ( rule__XType__Group_2__0 ) ) );
    public final void rule__XType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:389:1: ( ( ( rule__XType__Group_0__0 ) ) | ( ruleXRange ) | ( ( rule__XType__Group_2__0 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt3=1;
                }
                break;
            case 22:
                {
                alt3=2;
                }
                break;
            case 20:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalXHDL.g:390:2: ( ( rule__XType__Group_0__0 ) )
                    {
                    // InternalXHDL.g:390:2: ( ( rule__XType__Group_0__0 ) )
                    // InternalXHDL.g:391:3: ( rule__XType__Group_0__0 )
                    {
                     before(grammarAccess.getXTypeAccess().getGroup_0()); 
                    // InternalXHDL.g:392:3: ( rule__XType__Group_0__0 )
                    // InternalXHDL.g:392:4: rule__XType__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XType__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXTypeAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalXHDL.g:396:2: ( ruleXRange )
                    {
                    // InternalXHDL.g:396:2: ( ruleXRange )
                    // InternalXHDL.g:397:3: ruleXRange
                    {
                     before(grammarAccess.getXTypeAccess().getXRangeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleXRange();

                    state._fsp--;

                     after(grammarAccess.getXTypeAccess().getXRangeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXHDL.g:402:2: ( ( rule__XType__Group_2__0 ) )
                    {
                    // InternalXHDL.g:402:2: ( ( rule__XType__Group_2__0 ) )
                    // InternalXHDL.g:403:3: ( rule__XType__Group_2__0 )
                    {
                     before(grammarAccess.getXTypeAccess().getGroup_2()); 
                    // InternalXHDL.g:404:3: ( rule__XType__Group_2__0 )
                    // InternalXHDL.g:404:4: rule__XType__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XType__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getXTypeAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Alternatives"


    // $ANTLR start "rule__XPackage__Group__0"
    // InternalXHDL.g:412:1: rule__XPackage__Group__0 : rule__XPackage__Group__0__Impl rule__XPackage__Group__1 ;
    public final void rule__XPackage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:416:1: ( rule__XPackage__Group__0__Impl rule__XPackage__Group__1 )
            // InternalXHDL.g:417:2: rule__XPackage__Group__0__Impl rule__XPackage__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__XPackage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XPackage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__0"


    // $ANTLR start "rule__XPackage__Group__0__Impl"
    // InternalXHDL.g:424:1: rule__XPackage__Group__0__Impl : ( 'package' ) ;
    public final void rule__XPackage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:428:1: ( ( 'package' ) )
            // InternalXHDL.g:429:1: ( 'package' )
            {
            // InternalXHDL.g:429:1: ( 'package' )
            // InternalXHDL.g:430:2: 'package'
            {
             before(grammarAccess.getXPackageAccess().getPackageKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__0__Impl"


    // $ANTLR start "rule__XPackage__Group__1"
    // InternalXHDL.g:439:1: rule__XPackage__Group__1 : rule__XPackage__Group__1__Impl rule__XPackage__Group__2 ;
    public final void rule__XPackage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:443:1: ( rule__XPackage__Group__1__Impl rule__XPackage__Group__2 )
            // InternalXHDL.g:444:2: rule__XPackage__Group__1__Impl rule__XPackage__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__XPackage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XPackage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__1"


    // $ANTLR start "rule__XPackage__Group__1__Impl"
    // InternalXHDL.g:451:1: rule__XPackage__Group__1__Impl : ( ( rule__XPackage__NameAssignment_1 ) ) ;
    public final void rule__XPackage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:455:1: ( ( ( rule__XPackage__NameAssignment_1 ) ) )
            // InternalXHDL.g:456:1: ( ( rule__XPackage__NameAssignment_1 ) )
            {
            // InternalXHDL.g:456:1: ( ( rule__XPackage__NameAssignment_1 ) )
            // InternalXHDL.g:457:2: ( rule__XPackage__NameAssignment_1 )
            {
             before(grammarAccess.getXPackageAccess().getNameAssignment_1()); 
            // InternalXHDL.g:458:2: ( rule__XPackage__NameAssignment_1 )
            // InternalXHDL.g:458:3: rule__XPackage__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__XPackage__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getXPackageAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__1__Impl"


    // $ANTLR start "rule__XPackage__Group__2"
    // InternalXHDL.g:466:1: rule__XPackage__Group__2 : rule__XPackage__Group__2__Impl rule__XPackage__Group__3 ;
    public final void rule__XPackage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:470:1: ( rule__XPackage__Group__2__Impl rule__XPackage__Group__3 )
            // InternalXHDL.g:471:2: rule__XPackage__Group__2__Impl rule__XPackage__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__XPackage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XPackage__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__2"


    // $ANTLR start "rule__XPackage__Group__2__Impl"
    // InternalXHDL.g:478:1: rule__XPackage__Group__2__Impl : ( 'is' ) ;
    public final void rule__XPackage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:482:1: ( ( 'is' ) )
            // InternalXHDL.g:483:1: ( 'is' )
            {
            // InternalXHDL.g:483:1: ( 'is' )
            // InternalXHDL.g:484:2: 'is'
            {
             before(grammarAccess.getXPackageAccess().getIsKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getIsKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__2__Impl"


    // $ANTLR start "rule__XPackage__Group__3"
    // InternalXHDL.g:493:1: rule__XPackage__Group__3 : rule__XPackage__Group__3__Impl rule__XPackage__Group__4 ;
    public final void rule__XPackage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:497:1: ( rule__XPackage__Group__3__Impl rule__XPackage__Group__4 )
            // InternalXHDL.g:498:2: rule__XPackage__Group__3__Impl rule__XPackage__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__XPackage__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XPackage__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__3"


    // $ANTLR start "rule__XPackage__Group__3__Impl"
    // InternalXHDL.g:505:1: rule__XPackage__Group__3__Impl : ( ( rule__XPackage__ElementsAssignment_3 )* ) ;
    public final void rule__XPackage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:509:1: ( ( ( rule__XPackage__ElementsAssignment_3 )* ) )
            // InternalXHDL.g:510:1: ( ( rule__XPackage__ElementsAssignment_3 )* )
            {
            // InternalXHDL.g:510:1: ( ( rule__XPackage__ElementsAssignment_3 )* )
            // InternalXHDL.g:511:2: ( rule__XPackage__ElementsAssignment_3 )*
            {
             before(grammarAccess.getXPackageAccess().getElementsAssignment_3()); 
            // InternalXHDL.g:512:2: ( rule__XPackage__ElementsAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15||(LA4_0>=17 && LA4_0<=20)||LA4_0==22) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalXHDL.g:512:3: rule__XPackage__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__XPackage__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getXPackageAccess().getElementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__3__Impl"


    // $ANTLR start "rule__XPackage__Group__4"
    // InternalXHDL.g:520:1: rule__XPackage__Group__4 : rule__XPackage__Group__4__Impl rule__XPackage__Group__5 ;
    public final void rule__XPackage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:524:1: ( rule__XPackage__Group__4__Impl rule__XPackage__Group__5 )
            // InternalXHDL.g:525:2: rule__XPackage__Group__4__Impl rule__XPackage__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__XPackage__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XPackage__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__4"


    // $ANTLR start "rule__XPackage__Group__4__Impl"
    // InternalXHDL.g:532:1: rule__XPackage__Group__4__Impl : ( 'end' ) ;
    public final void rule__XPackage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:536:1: ( ( 'end' ) )
            // InternalXHDL.g:537:1: ( 'end' )
            {
            // InternalXHDL.g:537:1: ( 'end' )
            // InternalXHDL.g:538:2: 'end'
            {
             before(grammarAccess.getXPackageAccess().getEndKeyword_4()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getEndKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__4__Impl"


    // $ANTLR start "rule__XPackage__Group__5"
    // InternalXHDL.g:547:1: rule__XPackage__Group__5 : rule__XPackage__Group__5__Impl rule__XPackage__Group__6 ;
    public final void rule__XPackage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:551:1: ( rule__XPackage__Group__5__Impl rule__XPackage__Group__6 )
            // InternalXHDL.g:552:2: rule__XPackage__Group__5__Impl rule__XPackage__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__XPackage__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XPackage__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__5"


    // $ANTLR start "rule__XPackage__Group__5__Impl"
    // InternalXHDL.g:559:1: rule__XPackage__Group__5__Impl : ( RULE_ID ) ;
    public final void rule__XPackage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:563:1: ( ( RULE_ID ) )
            // InternalXHDL.g:564:1: ( RULE_ID )
            {
            // InternalXHDL.g:564:1: ( RULE_ID )
            // InternalXHDL.g:565:2: RULE_ID
            {
             before(grammarAccess.getXPackageAccess().getIDTerminalRuleCall_5()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getIDTerminalRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__5__Impl"


    // $ANTLR start "rule__XPackage__Group__6"
    // InternalXHDL.g:574:1: rule__XPackage__Group__6 : rule__XPackage__Group__6__Impl ;
    public final void rule__XPackage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:578:1: ( rule__XPackage__Group__6__Impl )
            // InternalXHDL.g:579:2: rule__XPackage__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XPackage__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__6"


    // $ANTLR start "rule__XPackage__Group__6__Impl"
    // InternalXHDL.g:585:1: rule__XPackage__Group__6__Impl : ( ';' ) ;
    public final void rule__XPackage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:589:1: ( ( ';' ) )
            // InternalXHDL.g:590:1: ( ';' )
            {
            // InternalXHDL.g:590:1: ( ';' )
            // InternalXHDL.g:591:2: ';'
            {
             before(grammarAccess.getXPackageAccess().getSemicolonKeyword_6()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getSemicolonKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__6__Impl"


    // $ANTLR start "rule__XAttribute__Group__0"
    // InternalXHDL.g:601:1: rule__XAttribute__Group__0 : rule__XAttribute__Group__0__Impl rule__XAttribute__Group__1 ;
    public final void rule__XAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:605:1: ( rule__XAttribute__Group__0__Impl rule__XAttribute__Group__1 )
            // InternalXHDL.g:606:2: rule__XAttribute__Group__0__Impl rule__XAttribute__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__XAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__0"


    // $ANTLR start "rule__XAttribute__Group__0__Impl"
    // InternalXHDL.g:613:1: rule__XAttribute__Group__0__Impl : ( () ) ;
    public final void rule__XAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:617:1: ( ( () ) )
            // InternalXHDL.g:618:1: ( () )
            {
            // InternalXHDL.g:618:1: ( () )
            // InternalXHDL.g:619:2: ()
            {
             before(grammarAccess.getXAttributeAccess().getAttributeAction_0()); 
            // InternalXHDL.g:620:2: ()
            // InternalXHDL.g:620:3: 
            {
            }

             after(grammarAccess.getXAttributeAccess().getAttributeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__0__Impl"


    // $ANTLR start "rule__XAttribute__Group__1"
    // InternalXHDL.g:628:1: rule__XAttribute__Group__1 : rule__XAttribute__Group__1__Impl rule__XAttribute__Group__2 ;
    public final void rule__XAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:632:1: ( rule__XAttribute__Group__1__Impl rule__XAttribute__Group__2 )
            // InternalXHDL.g:633:2: rule__XAttribute__Group__1__Impl rule__XAttribute__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__XAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__1"


    // $ANTLR start "rule__XAttribute__Group__1__Impl"
    // InternalXHDL.g:640:1: rule__XAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__XAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:644:1: ( ( 'attribute' ) )
            // InternalXHDL.g:645:1: ( 'attribute' )
            {
            // InternalXHDL.g:645:1: ( 'attribute' )
            // InternalXHDL.g:646:2: 'attribute'
            {
             before(grammarAccess.getXAttributeAccess().getAttributeKeyword_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getXAttributeAccess().getAttributeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__1__Impl"


    // $ANTLR start "rule__XAttribute__Group__2"
    // InternalXHDL.g:655:1: rule__XAttribute__Group__2 : rule__XAttribute__Group__2__Impl rule__XAttribute__Group__3 ;
    public final void rule__XAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:659:1: ( rule__XAttribute__Group__2__Impl rule__XAttribute__Group__3 )
            // InternalXHDL.g:660:2: rule__XAttribute__Group__2__Impl rule__XAttribute__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__XAttribute__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XAttribute__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__2"


    // $ANTLR start "rule__XAttribute__Group__2__Impl"
    // InternalXHDL.g:667:1: rule__XAttribute__Group__2__Impl : ( RULE_ID ) ;
    public final void rule__XAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:671:1: ( ( RULE_ID ) )
            // InternalXHDL.g:672:1: ( RULE_ID )
            {
            // InternalXHDL.g:672:1: ( RULE_ID )
            // InternalXHDL.g:673:2: RULE_ID
            {
             before(grammarAccess.getXAttributeAccess().getIDTerminalRuleCall_2()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXAttributeAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__2__Impl"


    // $ANTLR start "rule__XAttribute__Group__3"
    // InternalXHDL.g:682:1: rule__XAttribute__Group__3 : rule__XAttribute__Group__3__Impl rule__XAttribute__Group__4 ;
    public final void rule__XAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:686:1: ( rule__XAttribute__Group__3__Impl rule__XAttribute__Group__4 )
            // InternalXHDL.g:687:2: rule__XAttribute__Group__3__Impl rule__XAttribute__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__XAttribute__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XAttribute__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__3"


    // $ANTLR start "rule__XAttribute__Group__3__Impl"
    // InternalXHDL.g:694:1: rule__XAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__XAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:698:1: ( ( ':' ) )
            // InternalXHDL.g:699:1: ( ':' )
            {
            // InternalXHDL.g:699:1: ( ':' )
            // InternalXHDL.g:700:2: ':'
            {
             before(grammarAccess.getXAttributeAccess().getColonKeyword_3()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getXAttributeAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__3__Impl"


    // $ANTLR start "rule__XAttribute__Group__4"
    // InternalXHDL.g:709:1: rule__XAttribute__Group__4 : rule__XAttribute__Group__4__Impl rule__XAttribute__Group__5 ;
    public final void rule__XAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:713:1: ( rule__XAttribute__Group__4__Impl rule__XAttribute__Group__5 )
            // InternalXHDL.g:714:2: rule__XAttribute__Group__4__Impl rule__XAttribute__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__XAttribute__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XAttribute__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__4"


    // $ANTLR start "rule__XAttribute__Group__4__Impl"
    // InternalXHDL.g:721:1: rule__XAttribute__Group__4__Impl : ( RULE_ID ) ;
    public final void rule__XAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:725:1: ( ( RULE_ID ) )
            // InternalXHDL.g:726:1: ( RULE_ID )
            {
            // InternalXHDL.g:726:1: ( RULE_ID )
            // InternalXHDL.g:727:2: RULE_ID
            {
             before(grammarAccess.getXAttributeAccess().getIDTerminalRuleCall_4()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXAttributeAccess().getIDTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__4__Impl"


    // $ANTLR start "rule__XAttribute__Group__5"
    // InternalXHDL.g:736:1: rule__XAttribute__Group__5 : rule__XAttribute__Group__5__Impl ;
    public final void rule__XAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:740:1: ( rule__XAttribute__Group__5__Impl )
            // InternalXHDL.g:741:2: rule__XAttribute__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XAttribute__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__5"


    // $ANTLR start "rule__XAttribute__Group__5__Impl"
    // InternalXHDL.g:747:1: rule__XAttribute__Group__5__Impl : ( ';' ) ;
    public final void rule__XAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:751:1: ( ( ';' ) )
            // InternalXHDL.g:752:1: ( ';' )
            {
            // InternalXHDL.g:752:1: ( ';' )
            // InternalXHDL.g:753:2: ';'
            {
             before(grammarAccess.getXAttributeAccess().getSemicolonKeyword_5()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXAttributeAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XAttribute__Group__5__Impl"


    // $ANTLR start "rule__XSubType__Group__0"
    // InternalXHDL.g:763:1: rule__XSubType__Group__0 : rule__XSubType__Group__0__Impl rule__XSubType__Group__1 ;
    public final void rule__XSubType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:767:1: ( rule__XSubType__Group__0__Impl rule__XSubType__Group__1 )
            // InternalXHDL.g:768:2: rule__XSubType__Group__0__Impl rule__XSubType__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__XSubType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSubType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSubType__Group__0"


    // $ANTLR start "rule__XSubType__Group__0__Impl"
    // InternalXHDL.g:775:1: rule__XSubType__Group__0__Impl : ( () ) ;
    public final void rule__XSubType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:779:1: ( ( () ) )
            // InternalXHDL.g:780:1: ( () )
            {
            // InternalXHDL.g:780:1: ( () )
            // InternalXHDL.g:781:2: ()
            {
             before(grammarAccess.getXSubTypeAccess().getSubtypeAction_0()); 
            // InternalXHDL.g:782:2: ()
            // InternalXHDL.g:782:3: 
            {
            }

             after(grammarAccess.getXSubTypeAccess().getSubtypeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSubType__Group__0__Impl"


    // $ANTLR start "rule__XSubType__Group__1"
    // InternalXHDL.g:790:1: rule__XSubType__Group__1 : rule__XSubType__Group__1__Impl rule__XSubType__Group__2 ;
    public final void rule__XSubType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:794:1: ( rule__XSubType__Group__1__Impl rule__XSubType__Group__2 )
            // InternalXHDL.g:795:2: rule__XSubType__Group__1__Impl rule__XSubType__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__XSubType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSubType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSubType__Group__1"


    // $ANTLR start "rule__XSubType__Group__1__Impl"
    // InternalXHDL.g:802:1: rule__XSubType__Group__1__Impl : ( 'subtype' ) ;
    public final void rule__XSubType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:806:1: ( ( 'subtype' ) )
            // InternalXHDL.g:807:1: ( 'subtype' )
            {
            // InternalXHDL.g:807:1: ( 'subtype' )
            // InternalXHDL.g:808:2: 'subtype'
            {
             before(grammarAccess.getXSubTypeAccess().getSubtypeKeyword_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getXSubTypeAccess().getSubtypeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSubType__Group__1__Impl"


    // $ANTLR start "rule__XSubType__Group__2"
    // InternalXHDL.g:817:1: rule__XSubType__Group__2 : rule__XSubType__Group__2__Impl rule__XSubType__Group__3 ;
    public final void rule__XSubType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:821:1: ( rule__XSubType__Group__2__Impl rule__XSubType__Group__3 )
            // InternalXHDL.g:822:2: rule__XSubType__Group__2__Impl rule__XSubType__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__XSubType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSubType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSubType__Group__2"


    // $ANTLR start "rule__XSubType__Group__2__Impl"
    // InternalXHDL.g:829:1: rule__XSubType__Group__2__Impl : ( RULE_ID ) ;
    public final void rule__XSubType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:833:1: ( ( RULE_ID ) )
            // InternalXHDL.g:834:1: ( RULE_ID )
            {
            // InternalXHDL.g:834:1: ( RULE_ID )
            // InternalXHDL.g:835:2: RULE_ID
            {
             before(grammarAccess.getXSubTypeAccess().getIDTerminalRuleCall_2()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXSubTypeAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSubType__Group__2__Impl"


    // $ANTLR start "rule__XSubType__Group__3"
    // InternalXHDL.g:844:1: rule__XSubType__Group__3 : rule__XSubType__Group__3__Impl ;
    public final void rule__XSubType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:848:1: ( rule__XSubType__Group__3__Impl )
            // InternalXHDL.g:849:2: rule__XSubType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XSubType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSubType__Group__3"


    // $ANTLR start "rule__XSubType__Group__3__Impl"
    // InternalXHDL.g:855:1: rule__XSubType__Group__3__Impl : ( ';' ) ;
    public final void rule__XSubType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:859:1: ( ( ';' ) )
            // InternalXHDL.g:860:1: ( ';' )
            {
            // InternalXHDL.g:860:1: ( ';' )
            // InternalXHDL.g:861:2: ';'
            {
             before(grammarAccess.getXSubTypeAccess().getSemicolonKeyword_3()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXSubTypeAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSubType__Group__3__Impl"


    // $ANTLR start "rule__XSignal__Group__0"
    // InternalXHDL.g:871:1: rule__XSignal__Group__0 : rule__XSignal__Group__0__Impl rule__XSignal__Group__1 ;
    public final void rule__XSignal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:875:1: ( rule__XSignal__Group__0__Impl rule__XSignal__Group__1 )
            // InternalXHDL.g:876:2: rule__XSignal__Group__0__Impl rule__XSignal__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__XSignal__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSignal__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSignal__Group__0"


    // $ANTLR start "rule__XSignal__Group__0__Impl"
    // InternalXHDL.g:883:1: rule__XSignal__Group__0__Impl : ( () ) ;
    public final void rule__XSignal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:887:1: ( ( () ) )
            // InternalXHDL.g:888:1: ( () )
            {
            // InternalXHDL.g:888:1: ( () )
            // InternalXHDL.g:889:2: ()
            {
             before(grammarAccess.getXSignalAccess().getSignalAction_0()); 
            // InternalXHDL.g:890:2: ()
            // InternalXHDL.g:890:3: 
            {
            }

             after(grammarAccess.getXSignalAccess().getSignalAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSignal__Group__0__Impl"


    // $ANTLR start "rule__XSignal__Group__1"
    // InternalXHDL.g:898:1: rule__XSignal__Group__1 : rule__XSignal__Group__1__Impl rule__XSignal__Group__2 ;
    public final void rule__XSignal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:902:1: ( rule__XSignal__Group__1__Impl rule__XSignal__Group__2 )
            // InternalXHDL.g:903:2: rule__XSignal__Group__1__Impl rule__XSignal__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__XSignal__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSignal__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSignal__Group__1"


    // $ANTLR start "rule__XSignal__Group__1__Impl"
    // InternalXHDL.g:910:1: rule__XSignal__Group__1__Impl : ( 'signal' ) ;
    public final void rule__XSignal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:914:1: ( ( 'signal' ) )
            // InternalXHDL.g:915:1: ( 'signal' )
            {
            // InternalXHDL.g:915:1: ( 'signal' )
            // InternalXHDL.g:916:2: 'signal'
            {
             before(grammarAccess.getXSignalAccess().getSignalKeyword_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getSignalKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSignal__Group__1__Impl"


    // $ANTLR start "rule__XSignal__Group__2"
    // InternalXHDL.g:925:1: rule__XSignal__Group__2 : rule__XSignal__Group__2__Impl rule__XSignal__Group__3 ;
    public final void rule__XSignal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:929:1: ( rule__XSignal__Group__2__Impl rule__XSignal__Group__3 )
            // InternalXHDL.g:930:2: rule__XSignal__Group__2__Impl rule__XSignal__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__XSignal__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSignal__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSignal__Group__2"


    // $ANTLR start "rule__XSignal__Group__2__Impl"
    // InternalXHDL.g:937:1: rule__XSignal__Group__2__Impl : ( RULE_ID ) ;
    public final void rule__XSignal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:941:1: ( ( RULE_ID ) )
            // InternalXHDL.g:942:1: ( RULE_ID )
            {
            // InternalXHDL.g:942:1: ( RULE_ID )
            // InternalXHDL.g:943:2: RULE_ID
            {
             before(grammarAccess.getXSignalAccess().getIDTerminalRuleCall_2()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSignal__Group__2__Impl"


    // $ANTLR start "rule__XSignal__Group__3"
    // InternalXHDL.g:952:1: rule__XSignal__Group__3 : rule__XSignal__Group__3__Impl ;
    public final void rule__XSignal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:956:1: ( rule__XSignal__Group__3__Impl )
            // InternalXHDL.g:957:2: rule__XSignal__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XSignal__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSignal__Group__3"


    // $ANTLR start "rule__XSignal__Group__3__Impl"
    // InternalXHDL.g:963:1: rule__XSignal__Group__3__Impl : ( ';' ) ;
    public final void rule__XSignal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:967:1: ( ( ';' ) )
            // InternalXHDL.g:968:1: ( ';' )
            {
            // InternalXHDL.g:968:1: ( ';' )
            // InternalXHDL.g:969:2: ';'
            {
             before(grammarAccess.getXSignalAccess().getSemicolonKeyword_3()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XSignal__Group__3__Impl"


    // $ANTLR start "rule__XType__Group_0__0"
    // InternalXHDL.g:979:1: rule__XType__Group_0__0 : rule__XType__Group_0__0__Impl rule__XType__Group_0__1 ;
    public final void rule__XType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:983:1: ( rule__XType__Group_0__0__Impl rule__XType__Group_0__1 )
            // InternalXHDL.g:984:2: rule__XType__Group_0__0__Impl rule__XType__Group_0__1
            {
            pushFollow(FOLLOW_13);
            rule__XType__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XType__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__0"


    // $ANTLR start "rule__XType__Group_0__0__Impl"
    // InternalXHDL.g:991:1: rule__XType__Group_0__0__Impl : ( () ) ;
    public final void rule__XType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:995:1: ( ( () ) )
            // InternalXHDL.g:996:1: ( () )
            {
            // InternalXHDL.g:996:1: ( () )
            // InternalXHDL.g:997:2: ()
            {
             before(grammarAccess.getXTypeAccess().getTypeAction_0_0()); 
            // InternalXHDL.g:998:2: ()
            // InternalXHDL.g:998:3: 
            {
            }

             after(grammarAccess.getXTypeAccess().getTypeAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__0__Impl"


    // $ANTLR start "rule__XType__Group_0__1"
    // InternalXHDL.g:1006:1: rule__XType__Group_0__1 : rule__XType__Group_0__1__Impl rule__XType__Group_0__2 ;
    public final void rule__XType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1010:1: ( rule__XType__Group_0__1__Impl rule__XType__Group_0__2 )
            // InternalXHDL.g:1011:2: rule__XType__Group_0__1__Impl rule__XType__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__XType__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XType__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__1"


    // $ANTLR start "rule__XType__Group_0__1__Impl"
    // InternalXHDL.g:1018:1: rule__XType__Group_0__1__Impl : ( 'type' ) ;
    public final void rule__XType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1022:1: ( ( 'type' ) )
            // InternalXHDL.g:1023:1: ( 'type' )
            {
            // InternalXHDL.g:1023:1: ( 'type' )
            // InternalXHDL.g:1024:2: 'type'
            {
             before(grammarAccess.getXTypeAccess().getTypeKeyword_0_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getXTypeAccess().getTypeKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__1__Impl"


    // $ANTLR start "rule__XType__Group_0__2"
    // InternalXHDL.g:1033:1: rule__XType__Group_0__2 : rule__XType__Group_0__2__Impl rule__XType__Group_0__3 ;
    public final void rule__XType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1037:1: ( rule__XType__Group_0__2__Impl rule__XType__Group_0__3 )
            // InternalXHDL.g:1038:2: rule__XType__Group_0__2__Impl rule__XType__Group_0__3
            {
            pushFollow(FOLLOW_5);
            rule__XType__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XType__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__2"


    // $ANTLR start "rule__XType__Group_0__2__Impl"
    // InternalXHDL.g:1045:1: rule__XType__Group_0__2__Impl : ( ( rule__XType__NameAssignment_0_2 ) ) ;
    public final void rule__XType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1049:1: ( ( ( rule__XType__NameAssignment_0_2 ) ) )
            // InternalXHDL.g:1050:1: ( ( rule__XType__NameAssignment_0_2 ) )
            {
            // InternalXHDL.g:1050:1: ( ( rule__XType__NameAssignment_0_2 ) )
            // InternalXHDL.g:1051:2: ( rule__XType__NameAssignment_0_2 )
            {
             before(grammarAccess.getXTypeAccess().getNameAssignment_0_2()); 
            // InternalXHDL.g:1052:2: ( rule__XType__NameAssignment_0_2 )
            // InternalXHDL.g:1052:3: rule__XType__NameAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__XType__NameAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getXTypeAccess().getNameAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__2__Impl"


    // $ANTLR start "rule__XType__Group_0__3"
    // InternalXHDL.g:1060:1: rule__XType__Group_0__3 : rule__XType__Group_0__3__Impl rule__XType__Group_0__4 ;
    public final void rule__XType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1064:1: ( rule__XType__Group_0__3__Impl rule__XType__Group_0__4 )
            // InternalXHDL.g:1065:2: rule__XType__Group_0__3__Impl rule__XType__Group_0__4
            {
            pushFollow(FOLLOW_14);
            rule__XType__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XType__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__3"


    // $ANTLR start "rule__XType__Group_0__3__Impl"
    // InternalXHDL.g:1072:1: rule__XType__Group_0__3__Impl : ( 'is' ) ;
    public final void rule__XType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1076:1: ( ( 'is' ) )
            // InternalXHDL.g:1077:1: ( 'is' )
            {
            // InternalXHDL.g:1077:1: ( 'is' )
            // InternalXHDL.g:1078:2: 'is'
            {
             before(grammarAccess.getXTypeAccess().getIsKeyword_0_3()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getXTypeAccess().getIsKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__3__Impl"


    // $ANTLR start "rule__XType__Group_0__4"
    // InternalXHDL.g:1087:1: rule__XType__Group_0__4 : rule__XType__Group_0__4__Impl ;
    public final void rule__XType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1091:1: ( rule__XType__Group_0__4__Impl )
            // InternalXHDL.g:1092:2: rule__XType__Group_0__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XType__Group_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__4"


    // $ANTLR start "rule__XType__Group_0__4__Impl"
    // InternalXHDL.g:1098:1: rule__XType__Group_0__4__Impl : ( ruleXEnums ) ;
    public final void rule__XType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1102:1: ( ( ruleXEnums ) )
            // InternalXHDL.g:1103:1: ( ruleXEnums )
            {
            // InternalXHDL.g:1103:1: ( ruleXEnums )
            // InternalXHDL.g:1104:2: ruleXEnums
            {
             before(grammarAccess.getXTypeAccess().getXEnumsParserRuleCall_0_4()); 
            pushFollow(FOLLOW_2);
            ruleXEnums();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXEnumsParserRuleCall_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_0__4__Impl"


    // $ANTLR start "rule__XType__Group_2__0"
    // InternalXHDL.g:1114:1: rule__XType__Group_2__0 : rule__XType__Group_2__0__Impl rule__XType__Group_2__1 ;
    public final void rule__XType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1118:1: ( rule__XType__Group_2__0__Impl rule__XType__Group_2__1 )
            // InternalXHDL.g:1119:2: rule__XType__Group_2__0__Impl rule__XType__Group_2__1
            {
            pushFollow(FOLLOW_8);
            rule__XType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_2__0"


    // $ANTLR start "rule__XType__Group_2__0__Impl"
    // InternalXHDL.g:1126:1: rule__XType__Group_2__0__Impl : ( ruleXArray ) ;
    public final void rule__XType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1130:1: ( ( ruleXArray ) )
            // InternalXHDL.g:1131:1: ( ruleXArray )
            {
            // InternalXHDL.g:1131:1: ( ruleXArray )
            // InternalXHDL.g:1132:2: ruleXArray
            {
             before(grammarAccess.getXTypeAccess().getXArrayParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXArray();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXArrayParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_2__0__Impl"


    // $ANTLR start "rule__XType__Group_2__1"
    // InternalXHDL.g:1141:1: rule__XType__Group_2__1 : rule__XType__Group_2__1__Impl ;
    public final void rule__XType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1145:1: ( rule__XType__Group_2__1__Impl )
            // InternalXHDL.g:1146:2: rule__XType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XType__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_2__1"


    // $ANTLR start "rule__XType__Group_2__1__Impl"
    // InternalXHDL.g:1152:1: rule__XType__Group_2__1__Impl : ( ';' ) ;
    public final void rule__XType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1156:1: ( ( ';' ) )
            // InternalXHDL.g:1157:1: ( ';' )
            {
            // InternalXHDL.g:1157:1: ( ';' )
            // InternalXHDL.g:1158:2: ';'
            {
             before(grammarAccess.getXTypeAccess().getSemicolonKeyword_2_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXTypeAccess().getSemicolonKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__Group_2__1__Impl"


    // $ANTLR start "rule__XArray__Group__0"
    // InternalXHDL.g:1168:1: rule__XArray__Group__0 : rule__XArray__Group__0__Impl rule__XArray__Group__1 ;
    public final void rule__XArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1172:1: ( rule__XArray__Group__0__Impl rule__XArray__Group__1 )
            // InternalXHDL.g:1173:2: rule__XArray__Group__0__Impl rule__XArray__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__XArray__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XArray__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__0"


    // $ANTLR start "rule__XArray__Group__0__Impl"
    // InternalXHDL.g:1180:1: rule__XArray__Group__0__Impl : ( () ) ;
    public final void rule__XArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1184:1: ( ( () ) )
            // InternalXHDL.g:1185:1: ( () )
            {
            // InternalXHDL.g:1185:1: ( () )
            // InternalXHDL.g:1186:2: ()
            {
             before(grammarAccess.getXArrayAccess().getArrayAction_0()); 
            // InternalXHDL.g:1187:2: ()
            // InternalXHDL.g:1187:3: 
            {
            }

             after(grammarAccess.getXArrayAccess().getArrayAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__0__Impl"


    // $ANTLR start "rule__XArray__Group__1"
    // InternalXHDL.g:1195:1: rule__XArray__Group__1 : rule__XArray__Group__1__Impl rule__XArray__Group__2 ;
    public final void rule__XArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1199:1: ( rule__XArray__Group__1__Impl rule__XArray__Group__2 )
            // InternalXHDL.g:1200:2: rule__XArray__Group__1__Impl rule__XArray__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__XArray__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XArray__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__1"


    // $ANTLR start "rule__XArray__Group__1__Impl"
    // InternalXHDL.g:1207:1: rule__XArray__Group__1__Impl : ( 'array' ) ;
    public final void rule__XArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1211:1: ( ( 'array' ) )
            // InternalXHDL.g:1212:1: ( 'array' )
            {
            // InternalXHDL.g:1212:1: ( 'array' )
            // InternalXHDL.g:1213:2: 'array'
            {
             before(grammarAccess.getXArrayAccess().getArrayKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getArrayKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__1__Impl"


    // $ANTLR start "rule__XArray__Group__2"
    // InternalXHDL.g:1222:1: rule__XArray__Group__2 : rule__XArray__Group__2__Impl rule__XArray__Group__3 ;
    public final void rule__XArray__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1226:1: ( rule__XArray__Group__2__Impl rule__XArray__Group__3 )
            // InternalXHDL.g:1227:2: rule__XArray__Group__2__Impl rule__XArray__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__XArray__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XArray__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__2"


    // $ANTLR start "rule__XArray__Group__2__Impl"
    // InternalXHDL.g:1234:1: rule__XArray__Group__2__Impl : ( '(' ) ;
    public final void rule__XArray__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1238:1: ( ( '(' ) )
            // InternalXHDL.g:1239:1: ( '(' )
            {
            // InternalXHDL.g:1239:1: ( '(' )
            // InternalXHDL.g:1240:2: '('
            {
             before(grammarAccess.getXArrayAccess().getLeftParenthesisKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__2__Impl"


    // $ANTLR start "rule__XArray__Group__3"
    // InternalXHDL.g:1249:1: rule__XArray__Group__3 : rule__XArray__Group__3__Impl rule__XArray__Group__4 ;
    public final void rule__XArray__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1253:1: ( rule__XArray__Group__3__Impl rule__XArray__Group__4 )
            // InternalXHDL.g:1254:2: rule__XArray__Group__3__Impl rule__XArray__Group__4
            {
            pushFollow(FOLLOW_16);
            rule__XArray__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XArray__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__3"


    // $ANTLR start "rule__XArray__Group__3__Impl"
    // InternalXHDL.g:1261:1: rule__XArray__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__XArray__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1265:1: ( ( RULE_ID ) )
            // InternalXHDL.g:1266:1: ( RULE_ID )
            {
            // InternalXHDL.g:1266:1: ( RULE_ID )
            // InternalXHDL.g:1267:2: RULE_ID
            {
             before(grammarAccess.getXArrayAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getIDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__3__Impl"


    // $ANTLR start "rule__XArray__Group__4"
    // InternalXHDL.g:1276:1: rule__XArray__Group__4 : rule__XArray__Group__4__Impl rule__XArray__Group__5 ;
    public final void rule__XArray__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1280:1: ( rule__XArray__Group__4__Impl rule__XArray__Group__5 )
            // InternalXHDL.g:1281:2: rule__XArray__Group__4__Impl rule__XArray__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__XArray__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XArray__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__4"


    // $ANTLR start "rule__XArray__Group__4__Impl"
    // InternalXHDL.g:1288:1: rule__XArray__Group__4__Impl : ( 'range' ) ;
    public final void rule__XArray__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1292:1: ( ( 'range' ) )
            // InternalXHDL.g:1293:1: ( 'range' )
            {
            // InternalXHDL.g:1293:1: ( 'range' )
            // InternalXHDL.g:1294:2: 'range'
            {
             before(grammarAccess.getXArrayAccess().getRangeKeyword_4()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getRangeKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__4__Impl"


    // $ANTLR start "rule__XArray__Group__5"
    // InternalXHDL.g:1303:1: rule__XArray__Group__5 : rule__XArray__Group__5__Impl rule__XArray__Group__6 ;
    public final void rule__XArray__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1307:1: ( rule__XArray__Group__5__Impl rule__XArray__Group__6 )
            // InternalXHDL.g:1308:2: rule__XArray__Group__5__Impl rule__XArray__Group__6
            {
            pushFollow(FOLLOW_18);
            rule__XArray__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XArray__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__5"


    // $ANTLR start "rule__XArray__Group__5__Impl"
    // InternalXHDL.g:1315:1: rule__XArray__Group__5__Impl : ( '<>' ) ;
    public final void rule__XArray__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1319:1: ( ( '<>' ) )
            // InternalXHDL.g:1320:1: ( '<>' )
            {
            // InternalXHDL.g:1320:1: ( '<>' )
            // InternalXHDL.g:1321:2: '<>'
            {
             before(grammarAccess.getXArrayAccess().getLessThanSignGreaterThanSignKeyword_5()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getLessThanSignGreaterThanSignKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__5__Impl"


    // $ANTLR start "rule__XArray__Group__6"
    // InternalXHDL.g:1330:1: rule__XArray__Group__6 : rule__XArray__Group__6__Impl rule__XArray__Group__7 ;
    public final void rule__XArray__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1334:1: ( rule__XArray__Group__6__Impl rule__XArray__Group__7 )
            // InternalXHDL.g:1335:2: rule__XArray__Group__6__Impl rule__XArray__Group__7
            {
            pushFollow(FOLLOW_19);
            rule__XArray__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XArray__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__6"


    // $ANTLR start "rule__XArray__Group__6__Impl"
    // InternalXHDL.g:1342:1: rule__XArray__Group__6__Impl : ( ')' ) ;
    public final void rule__XArray__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1346:1: ( ( ')' ) )
            // InternalXHDL.g:1347:1: ( ')' )
            {
            // InternalXHDL.g:1347:1: ( ')' )
            // InternalXHDL.g:1348:2: ')'
            {
             before(grammarAccess.getXArrayAccess().getRightParenthesisKeyword_6()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__6__Impl"


    // $ANTLR start "rule__XArray__Group__7"
    // InternalXHDL.g:1357:1: rule__XArray__Group__7 : rule__XArray__Group__7__Impl rule__XArray__Group__8 ;
    public final void rule__XArray__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1361:1: ( rule__XArray__Group__7__Impl rule__XArray__Group__8 )
            // InternalXHDL.g:1362:2: rule__XArray__Group__7__Impl rule__XArray__Group__8
            {
            pushFollow(FOLLOW_4);
            rule__XArray__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XArray__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__7"


    // $ANTLR start "rule__XArray__Group__7__Impl"
    // InternalXHDL.g:1369:1: rule__XArray__Group__7__Impl : ( 'of' ) ;
    public final void rule__XArray__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1373:1: ( ( 'of' ) )
            // InternalXHDL.g:1374:1: ( 'of' )
            {
            // InternalXHDL.g:1374:1: ( 'of' )
            // InternalXHDL.g:1375:2: 'of'
            {
             before(grammarAccess.getXArrayAccess().getOfKeyword_7()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getOfKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__7__Impl"


    // $ANTLR start "rule__XArray__Group__8"
    // InternalXHDL.g:1384:1: rule__XArray__Group__8 : rule__XArray__Group__8__Impl ;
    public final void rule__XArray__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1388:1: ( rule__XArray__Group__8__Impl )
            // InternalXHDL.g:1389:2: rule__XArray__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XArray__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__8"


    // $ANTLR start "rule__XArray__Group__8__Impl"
    // InternalXHDL.g:1395:1: rule__XArray__Group__8__Impl : ( RULE_ID ) ;
    public final void rule__XArray__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1399:1: ( ( RULE_ID ) )
            // InternalXHDL.g:1400:1: ( RULE_ID )
            {
            // InternalXHDL.g:1400:1: ( RULE_ID )
            // InternalXHDL.g:1401:2: RULE_ID
            {
             before(grammarAccess.getXArrayAccess().getIDTerminalRuleCall_8()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getIDTerminalRuleCall_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XArray__Group__8__Impl"


    // $ANTLR start "rule__XRange__Group__0"
    // InternalXHDL.g:1411:1: rule__XRange__Group__0 : rule__XRange__Group__0__Impl rule__XRange__Group__1 ;
    public final void rule__XRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1415:1: ( rule__XRange__Group__0__Impl rule__XRange__Group__1 )
            // InternalXHDL.g:1416:2: rule__XRange__Group__0__Impl rule__XRange__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__XRange__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XRange__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__0"


    // $ANTLR start "rule__XRange__Group__0__Impl"
    // InternalXHDL.g:1423:1: rule__XRange__Group__0__Impl : ( () ) ;
    public final void rule__XRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1427:1: ( ( () ) )
            // InternalXHDL.g:1428:1: ( () )
            {
            // InternalXHDL.g:1428:1: ( () )
            // InternalXHDL.g:1429:2: ()
            {
             before(grammarAccess.getXRangeAccess().getRangeAction_0()); 
            // InternalXHDL.g:1430:2: ()
            // InternalXHDL.g:1430:3: 
            {
            }

             after(grammarAccess.getXRangeAccess().getRangeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__0__Impl"


    // $ANTLR start "rule__XRange__Group__1"
    // InternalXHDL.g:1438:1: rule__XRange__Group__1 : rule__XRange__Group__1__Impl rule__XRange__Group__2 ;
    public final void rule__XRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1442:1: ( rule__XRange__Group__1__Impl rule__XRange__Group__2 )
            // InternalXHDL.g:1443:2: rule__XRange__Group__1__Impl rule__XRange__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__XRange__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XRange__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__1"


    // $ANTLR start "rule__XRange__Group__1__Impl"
    // InternalXHDL.g:1450:1: rule__XRange__Group__1__Impl : ( 'range' ) ;
    public final void rule__XRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1454:1: ( ( 'range' ) )
            // InternalXHDL.g:1455:1: ( 'range' )
            {
            // InternalXHDL.g:1455:1: ( 'range' )
            // InternalXHDL.g:1456:2: 'range'
            {
             before(grammarAccess.getXRangeAccess().getRangeKeyword_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getXRangeAccess().getRangeKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__1__Impl"


    // $ANTLR start "rule__XRange__Group__2"
    // InternalXHDL.g:1465:1: rule__XRange__Group__2 : rule__XRange__Group__2__Impl rule__XRange__Group__3 ;
    public final void rule__XRange__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1469:1: ( rule__XRange__Group__2__Impl rule__XRange__Group__3 )
            // InternalXHDL.g:1470:2: rule__XRange__Group__2__Impl rule__XRange__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__XRange__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XRange__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__2"


    // $ANTLR start "rule__XRange__Group__2__Impl"
    // InternalXHDL.g:1477:1: rule__XRange__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__XRange__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1481:1: ( ( RULE_INT ) )
            // InternalXHDL.g:1482:1: ( RULE_INT )
            {
            // InternalXHDL.g:1482:1: ( RULE_INT )
            // InternalXHDL.g:1483:2: RULE_INT
            {
             before(grammarAccess.getXRangeAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getXRangeAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__2__Impl"


    // $ANTLR start "rule__XRange__Group__3"
    // InternalXHDL.g:1492:1: rule__XRange__Group__3 : rule__XRange__Group__3__Impl rule__XRange__Group__4 ;
    public final void rule__XRange__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1496:1: ( rule__XRange__Group__3__Impl rule__XRange__Group__4 )
            // InternalXHDL.g:1497:2: rule__XRange__Group__3__Impl rule__XRange__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__XRange__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XRange__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__3"


    // $ANTLR start "rule__XRange__Group__3__Impl"
    // InternalXHDL.g:1504:1: rule__XRange__Group__3__Impl : ( 'to' ) ;
    public final void rule__XRange__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1508:1: ( ( 'to' ) )
            // InternalXHDL.g:1509:1: ( 'to' )
            {
            // InternalXHDL.g:1509:1: ( 'to' )
            // InternalXHDL.g:1510:2: 'to'
            {
             before(grammarAccess.getXRangeAccess().getToKeyword_3()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getXRangeAccess().getToKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__3__Impl"


    // $ANTLR start "rule__XRange__Group__4"
    // InternalXHDL.g:1519:1: rule__XRange__Group__4 : rule__XRange__Group__4__Impl rule__XRange__Group__5 ;
    public final void rule__XRange__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1523:1: ( rule__XRange__Group__4__Impl rule__XRange__Group__5 )
            // InternalXHDL.g:1524:2: rule__XRange__Group__4__Impl rule__XRange__Group__5
            {
            pushFollow(FOLLOW_22);
            rule__XRange__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XRange__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__4"


    // $ANTLR start "rule__XRange__Group__4__Impl"
    // InternalXHDL.g:1531:1: rule__XRange__Group__4__Impl : ( RULE_INT ) ;
    public final void rule__XRange__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1535:1: ( ( RULE_INT ) )
            // InternalXHDL.g:1536:1: ( RULE_INT )
            {
            // InternalXHDL.g:1536:1: ( RULE_INT )
            // InternalXHDL.g:1537:2: RULE_INT
            {
             before(grammarAccess.getXRangeAccess().getINTTerminalRuleCall_4()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getXRangeAccess().getINTTerminalRuleCall_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__4__Impl"


    // $ANTLR start "rule__XRange__Group__5"
    // InternalXHDL.g:1546:1: rule__XRange__Group__5 : rule__XRange__Group__5__Impl ;
    public final void rule__XRange__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1550:1: ( rule__XRange__Group__5__Impl )
            // InternalXHDL.g:1551:2: rule__XRange__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XRange__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__5"


    // $ANTLR start "rule__XRange__Group__5__Impl"
    // InternalXHDL.g:1557:1: rule__XRange__Group__5__Impl : ( ( ruleXUnits )? ) ;
    public final void rule__XRange__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1561:1: ( ( ( ruleXUnits )? ) )
            // InternalXHDL.g:1562:1: ( ( ruleXUnits )? )
            {
            // InternalXHDL.g:1562:1: ( ( ruleXUnits )? )
            // InternalXHDL.g:1563:2: ( ruleXUnits )?
            {
             before(grammarAccess.getXRangeAccess().getXUnitsParserRuleCall_5()); 
            // InternalXHDL.g:1564:2: ( ruleXUnits )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXHDL.g:1564:3: ruleXUnits
                    {
                    pushFollow(FOLLOW_2);
                    ruleXUnits();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXRangeAccess().getXUnitsParserRuleCall_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XRange__Group__5__Impl"


    // $ANTLR start "rule__XUnits__Group__0"
    // InternalXHDL.g:1573:1: rule__XUnits__Group__0 : rule__XUnits__Group__0__Impl rule__XUnits__Group__1 ;
    public final void rule__XUnits__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1577:1: ( rule__XUnits__Group__0__Impl rule__XUnits__Group__1 )
            // InternalXHDL.g:1578:2: rule__XUnits__Group__0__Impl rule__XUnits__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__XUnits__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnits__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__0"


    // $ANTLR start "rule__XUnits__Group__0__Impl"
    // InternalXHDL.g:1585:1: rule__XUnits__Group__0__Impl : ( () ) ;
    public final void rule__XUnits__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1589:1: ( ( () ) )
            // InternalXHDL.g:1590:1: ( () )
            {
            // InternalXHDL.g:1590:1: ( () )
            // InternalXHDL.g:1591:2: ()
            {
             before(grammarAccess.getXUnitsAccess().getUnitsAction_0()); 
            // InternalXHDL.g:1592:2: ()
            // InternalXHDL.g:1592:3: 
            {
            }

             after(grammarAccess.getXUnitsAccess().getUnitsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__0__Impl"


    // $ANTLR start "rule__XUnits__Group__1"
    // InternalXHDL.g:1600:1: rule__XUnits__Group__1 : rule__XUnits__Group__1__Impl rule__XUnits__Group__2 ;
    public final void rule__XUnits__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1604:1: ( rule__XUnits__Group__1__Impl rule__XUnits__Group__2 )
            // InternalXHDL.g:1605:2: rule__XUnits__Group__1__Impl rule__XUnits__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__XUnits__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnits__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__1"


    // $ANTLR start "rule__XUnits__Group__1__Impl"
    // InternalXHDL.g:1612:1: rule__XUnits__Group__1__Impl : ( 'units' ) ;
    public final void rule__XUnits__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1616:1: ( ( 'units' ) )
            // InternalXHDL.g:1617:1: ( 'units' )
            {
            // InternalXHDL.g:1617:1: ( 'units' )
            // InternalXHDL.g:1618:2: 'units'
            {
             before(grammarAccess.getXUnitsAccess().getUnitsKeyword_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getXUnitsAccess().getUnitsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__1__Impl"


    // $ANTLR start "rule__XUnits__Group__2"
    // InternalXHDL.g:1627:1: rule__XUnits__Group__2 : rule__XUnits__Group__2__Impl rule__XUnits__Group__3 ;
    public final void rule__XUnits__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1631:1: ( rule__XUnits__Group__2__Impl rule__XUnits__Group__3 )
            // InternalXHDL.g:1632:2: rule__XUnits__Group__2__Impl rule__XUnits__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__XUnits__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnits__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__2"


    // $ANTLR start "rule__XUnits__Group__2__Impl"
    // InternalXHDL.g:1639:1: rule__XUnits__Group__2__Impl : ( ( rule__XUnits__UnitsAssignment_2 )* ) ;
    public final void rule__XUnits__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1643:1: ( ( ( rule__XUnits__UnitsAssignment_2 )* ) )
            // InternalXHDL.g:1644:1: ( ( rule__XUnits__UnitsAssignment_2 )* )
            {
            // InternalXHDL.g:1644:1: ( ( rule__XUnits__UnitsAssignment_2 )* )
            // InternalXHDL.g:1645:2: ( rule__XUnits__UnitsAssignment_2 )*
            {
             before(grammarAccess.getXUnitsAccess().getUnitsAssignment_2()); 
            // InternalXHDL.g:1646:2: ( rule__XUnits__UnitsAssignment_2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalXHDL.g:1646:3: rule__XUnits__UnitsAssignment_2
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__XUnits__UnitsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getXUnitsAccess().getUnitsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__2__Impl"


    // $ANTLR start "rule__XUnits__Group__3"
    // InternalXHDL.g:1654:1: rule__XUnits__Group__3 : rule__XUnits__Group__3__Impl rule__XUnits__Group__4 ;
    public final void rule__XUnits__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1658:1: ( rule__XUnits__Group__3__Impl rule__XUnits__Group__4 )
            // InternalXHDL.g:1659:2: rule__XUnits__Group__3__Impl rule__XUnits__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__XUnits__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnits__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__3"


    // $ANTLR start "rule__XUnits__Group__3__Impl"
    // InternalXHDL.g:1666:1: rule__XUnits__Group__3__Impl : ( 'end' ) ;
    public final void rule__XUnits__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1670:1: ( ( 'end' ) )
            // InternalXHDL.g:1671:1: ( 'end' )
            {
            // InternalXHDL.g:1671:1: ( 'end' )
            // InternalXHDL.g:1672:2: 'end'
            {
             before(grammarAccess.getXUnitsAccess().getEndKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getXUnitsAccess().getEndKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__3__Impl"


    // $ANTLR start "rule__XUnits__Group__4"
    // InternalXHDL.g:1681:1: rule__XUnits__Group__4 : rule__XUnits__Group__4__Impl ;
    public final void rule__XUnits__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1685:1: ( rule__XUnits__Group__4__Impl )
            // InternalXHDL.g:1686:2: rule__XUnits__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XUnits__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__4"


    // $ANTLR start "rule__XUnits__Group__4__Impl"
    // InternalXHDL.g:1692:1: rule__XUnits__Group__4__Impl : ( 'units' ) ;
    public final void rule__XUnits__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1696:1: ( ( 'units' ) )
            // InternalXHDL.g:1697:1: ( 'units' )
            {
            // InternalXHDL.g:1697:1: ( 'units' )
            // InternalXHDL.g:1698:2: 'units'
            {
             before(grammarAccess.getXUnitsAccess().getUnitsKeyword_4()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getXUnitsAccess().getUnitsKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__Group__4__Impl"


    // $ANTLR start "rule__XUnit__Group__0"
    // InternalXHDL.g:1708:1: rule__XUnit__Group__0 : rule__XUnit__Group__0__Impl rule__XUnit__Group__1 ;
    public final void rule__XUnit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1712:1: ( rule__XUnit__Group__0__Impl rule__XUnit__Group__1 )
            // InternalXHDL.g:1713:2: rule__XUnit__Group__0__Impl rule__XUnit__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__XUnit__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnit__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__0"


    // $ANTLR start "rule__XUnit__Group__0__Impl"
    // InternalXHDL.g:1720:1: rule__XUnit__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__XUnit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1724:1: ( ( RULE_ID ) )
            // InternalXHDL.g:1725:1: ( RULE_ID )
            {
            // InternalXHDL.g:1725:1: ( RULE_ID )
            // InternalXHDL.g:1726:2: RULE_ID
            {
             before(grammarAccess.getXUnitAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__0__Impl"


    // $ANTLR start "rule__XUnit__Group__1"
    // InternalXHDL.g:1735:1: rule__XUnit__Group__1 : rule__XUnit__Group__1__Impl rule__XUnit__Group__2 ;
    public final void rule__XUnit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1739:1: ( rule__XUnit__Group__1__Impl rule__XUnit__Group__2 )
            // InternalXHDL.g:1740:2: rule__XUnit__Group__1__Impl rule__XUnit__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__XUnit__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnit__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__1"


    // $ANTLR start "rule__XUnit__Group__1__Impl"
    // InternalXHDL.g:1747:1: rule__XUnit__Group__1__Impl : ( '=' ) ;
    public final void rule__XUnit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1751:1: ( ( '=' ) )
            // InternalXHDL.g:1752:1: ( '=' )
            {
            // InternalXHDL.g:1752:1: ( '=' )
            // InternalXHDL.g:1753:2: '='
            {
             before(grammarAccess.getXUnitAccess().getEqualsSignKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__1__Impl"


    // $ANTLR start "rule__XUnit__Group__2"
    // InternalXHDL.g:1762:1: rule__XUnit__Group__2 : rule__XUnit__Group__2__Impl rule__XUnit__Group__3 ;
    public final void rule__XUnit__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1766:1: ( rule__XUnit__Group__2__Impl rule__XUnit__Group__3 )
            // InternalXHDL.g:1767:2: rule__XUnit__Group__2__Impl rule__XUnit__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__XUnit__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnit__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__2"


    // $ANTLR start "rule__XUnit__Group__2__Impl"
    // InternalXHDL.g:1774:1: rule__XUnit__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__XUnit__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1778:1: ( ( RULE_INT ) )
            // InternalXHDL.g:1779:1: ( RULE_INT )
            {
            // InternalXHDL.g:1779:1: ( RULE_INT )
            // InternalXHDL.g:1780:2: RULE_INT
            {
             before(grammarAccess.getXUnitAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__2__Impl"


    // $ANTLR start "rule__XUnit__Group__3"
    // InternalXHDL.g:1789:1: rule__XUnit__Group__3 : rule__XUnit__Group__3__Impl rule__XUnit__Group__4 ;
    public final void rule__XUnit__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1793:1: ( rule__XUnit__Group__3__Impl rule__XUnit__Group__4 )
            // InternalXHDL.g:1794:2: rule__XUnit__Group__3__Impl rule__XUnit__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__XUnit__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnit__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__3"


    // $ANTLR start "rule__XUnit__Group__3__Impl"
    // InternalXHDL.g:1801:1: rule__XUnit__Group__3__Impl : ( RULE_ID ) ;
    public final void rule__XUnit__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1805:1: ( ( RULE_ID ) )
            // InternalXHDL.g:1806:1: ( RULE_ID )
            {
            // InternalXHDL.g:1806:1: ( RULE_ID )
            // InternalXHDL.g:1807:2: RULE_ID
            {
             before(grammarAccess.getXUnitAccess().getIDTerminalRuleCall_3()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getIDTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__3__Impl"


    // $ANTLR start "rule__XUnit__Group__4"
    // InternalXHDL.g:1816:1: rule__XUnit__Group__4 : rule__XUnit__Group__4__Impl ;
    public final void rule__XUnit__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1820:1: ( rule__XUnit__Group__4__Impl )
            // InternalXHDL.g:1821:2: rule__XUnit__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XUnit__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__4"


    // $ANTLR start "rule__XUnit__Group__4__Impl"
    // InternalXHDL.g:1827:1: rule__XUnit__Group__4__Impl : ( ';' ) ;
    public final void rule__XUnit__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1831:1: ( ( ';' ) )
            // InternalXHDL.g:1832:1: ( ';' )
            {
            // InternalXHDL.g:1832:1: ( ';' )
            // InternalXHDL.g:1833:2: ';'
            {
             before(grammarAccess.getXUnitAccess().getSemicolonKeyword_4()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getSemicolonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__4__Impl"


    // $ANTLR start "rule__XEnums__Group__0"
    // InternalXHDL.g:1843:1: rule__XEnums__Group__0 : rule__XEnums__Group__0__Impl rule__XEnums__Group__1 ;
    public final void rule__XEnums__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1847:1: ( rule__XEnums__Group__0__Impl rule__XEnums__Group__1 )
            // InternalXHDL.g:1848:2: rule__XEnums__Group__0__Impl rule__XEnums__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__XEnums__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XEnums__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group__0"


    // $ANTLR start "rule__XEnums__Group__0__Impl"
    // InternalXHDL.g:1855:1: rule__XEnums__Group__0__Impl : ( '(' ) ;
    public final void rule__XEnums__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1859:1: ( ( '(' ) )
            // InternalXHDL.g:1860:1: ( '(' )
            {
            // InternalXHDL.g:1860:1: ( '(' )
            // InternalXHDL.g:1861:2: '('
            {
             before(grammarAccess.getXEnumsAccess().getLeftParenthesisKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getXEnumsAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group__0__Impl"


    // $ANTLR start "rule__XEnums__Group__1"
    // InternalXHDL.g:1870:1: rule__XEnums__Group__1 : rule__XEnums__Group__1__Impl rule__XEnums__Group__2 ;
    public final void rule__XEnums__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1874:1: ( rule__XEnums__Group__1__Impl rule__XEnums__Group__2 )
            // InternalXHDL.g:1875:2: rule__XEnums__Group__1__Impl rule__XEnums__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__XEnums__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XEnums__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group__1"


    // $ANTLR start "rule__XEnums__Group__1__Impl"
    // InternalXHDL.g:1882:1: rule__XEnums__Group__1__Impl : ( ( rule__XEnums__Group_1__0 )* ) ;
    public final void rule__XEnums__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1886:1: ( ( ( rule__XEnums__Group_1__0 )* ) )
            // InternalXHDL.g:1887:1: ( ( rule__XEnums__Group_1__0 )* )
            {
            // InternalXHDL.g:1887:1: ( ( rule__XEnums__Group_1__0 )* )
            // InternalXHDL.g:1888:2: ( rule__XEnums__Group_1__0 )*
            {
             before(grammarAccess.getXEnumsAccess().getGroup_1()); 
            // InternalXHDL.g:1889:2: ( rule__XEnums__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==29) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXHDL.g:1889:3: rule__XEnums__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__XEnums__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getXEnumsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group__1__Impl"


    // $ANTLR start "rule__XEnums__Group__2"
    // InternalXHDL.g:1897:1: rule__XEnums__Group__2 : rule__XEnums__Group__2__Impl ;
    public final void rule__XEnums__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1901:1: ( rule__XEnums__Group__2__Impl )
            // InternalXHDL.g:1902:2: rule__XEnums__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEnums__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group__2"


    // $ANTLR start "rule__XEnums__Group__2__Impl"
    // InternalXHDL.g:1908:1: rule__XEnums__Group__2__Impl : ( ')' ) ;
    public final void rule__XEnums__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1912:1: ( ( ')' ) )
            // InternalXHDL.g:1913:1: ( ')' )
            {
            // InternalXHDL.g:1913:1: ( ')' )
            // InternalXHDL.g:1914:2: ')'
            {
             before(grammarAccess.getXEnumsAccess().getRightParenthesisKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getXEnumsAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group__2__Impl"


    // $ANTLR start "rule__XEnums__Group_1__0"
    // InternalXHDL.g:1924:1: rule__XEnums__Group_1__0 : rule__XEnums__Group_1__0__Impl rule__XEnums__Group_1__1 ;
    public final void rule__XEnums__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1928:1: ( rule__XEnums__Group_1__0__Impl rule__XEnums__Group_1__1 )
            // InternalXHDL.g:1929:2: rule__XEnums__Group_1__0__Impl rule__XEnums__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__XEnums__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XEnums__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group_1__0"


    // $ANTLR start "rule__XEnums__Group_1__0__Impl"
    // InternalXHDL.g:1936:1: rule__XEnums__Group_1__0__Impl : ( ( ',' )? ) ;
    public final void rule__XEnums__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1940:1: ( ( ( ',' )? ) )
            // InternalXHDL.g:1941:1: ( ( ',' )? )
            {
            // InternalXHDL.g:1941:1: ( ( ',' )? )
            // InternalXHDL.g:1942:2: ( ',' )?
            {
             before(grammarAccess.getXEnumsAccess().getCommaKeyword_1_0()); 
            // InternalXHDL.g:1943:2: ( ',' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXHDL.g:1943:3: ','
                    {
                    match(input,29,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getXEnumsAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group_1__0__Impl"


    // $ANTLR start "rule__XEnums__Group_1__1"
    // InternalXHDL.g:1951:1: rule__XEnums__Group_1__1 : rule__XEnums__Group_1__1__Impl ;
    public final void rule__XEnums__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1955:1: ( rule__XEnums__Group_1__1__Impl )
            // InternalXHDL.g:1956:2: rule__XEnums__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEnums__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group_1__1"


    // $ANTLR start "rule__XEnums__Group_1__1__Impl"
    // InternalXHDL.g:1962:1: rule__XEnums__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__XEnums__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1966:1: ( ( RULE_ID ) )
            // InternalXHDL.g:1967:1: ( RULE_ID )
            {
            // InternalXHDL.g:1967:1: ( RULE_ID )
            // InternalXHDL.g:1968:2: RULE_ID
            {
             before(grammarAccess.getXEnumsAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXEnumsAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group_1__1__Impl"


    // $ANTLR start "rule__Xhdl__PackagesAssignment"
    // InternalXHDL.g:1978:1: rule__Xhdl__PackagesAssignment : ( ruleXPackage ) ;
    public final void rule__Xhdl__PackagesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1982:1: ( ( ruleXPackage ) )
            // InternalXHDL.g:1983:2: ( ruleXPackage )
            {
            // InternalXHDL.g:1983:2: ( ruleXPackage )
            // InternalXHDL.g:1984:3: ruleXPackage
            {
             before(grammarAccess.getXhdlAccess().getPackagesXPackageParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleXPackage();

            state._fsp--;

             after(grammarAccess.getXhdlAccess().getPackagesXPackageParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Xhdl__PackagesAssignment"


    // $ANTLR start "rule__XPackage__NameAssignment_1"
    // InternalXHDL.g:1993:1: rule__XPackage__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__XPackage__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1997:1: ( ( RULE_ID ) )
            // InternalXHDL.g:1998:2: ( RULE_ID )
            {
            // InternalXHDL.g:1998:2: ( RULE_ID )
            // InternalXHDL.g:1999:3: RULE_ID
            {
             before(grammarAccess.getXPackageAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__NameAssignment_1"


    // $ANTLR start "rule__XPackage__ElementsAssignment_3"
    // InternalXHDL.g:2008:1: rule__XPackage__ElementsAssignment_3 : ( ruleXElement ) ;
    public final void rule__XPackage__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2012:1: ( ( ruleXElement ) )
            // InternalXHDL.g:2013:2: ( ruleXElement )
            {
            // InternalXHDL.g:2013:2: ( ruleXElement )
            // InternalXHDL.g:2014:3: ruleXElement
            {
             before(grammarAccess.getXPackageAccess().getElementsXElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleXElement();

            state._fsp--;

             after(grammarAccess.getXPackageAccess().getElementsXElementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__ElementsAssignment_3"


    // $ANTLR start "rule__XType__NameAssignment_0_2"
    // InternalXHDL.g:2023:1: rule__XType__NameAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__XType__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2027:1: ( ( RULE_ID ) )
            // InternalXHDL.g:2028:2: ( RULE_ID )
            {
            // InternalXHDL.g:2028:2: ( RULE_ID )
            // InternalXHDL.g:2029:3: RULE_ID
            {
             before(grammarAccess.getXTypeAccess().getNameIDTerminalRuleCall_0_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXTypeAccess().getNameIDTerminalRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XType__NameAssignment_0_2"


    // $ANTLR start "rule__XUnits__UnitsAssignment_2"
    // InternalXHDL.g:2038:1: rule__XUnits__UnitsAssignment_2 : ( ruleXUnit ) ;
    public final void rule__XUnits__UnitsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2042:1: ( ( ruleXUnit ) )
            // InternalXHDL.g:2043:2: ( ruleXUnit )
            {
            // InternalXHDL.g:2043:2: ( ruleXUnit )
            // InternalXHDL.g:2044:3: ruleXUnit
            {
             before(grammarAccess.getXUnitsAccess().getUnitsXUnitParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXUnit();

            state._fsp--;

             after(grammarAccess.getXUnitsAccess().getUnitsXUnitParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnits__UnitsAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000005EA000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000005E8002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000005E8000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000580000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000021000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000020000012L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020000010L});

}