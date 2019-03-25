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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_COMMENT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'is'", "'end'", "';'", "'attribute'", "':'", "'subtype'", "'signal'", "';='", "'type'", "'array'", "'('", "'range'", "'<>'", "')'", "'of'", "'to'", "'units'", "'='", "','", "'impure'"
    };
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=10;
    public static final int RULE_COMMENT=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
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

                if ( (LA1_0==12) ) {
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


    // $ANTLR start "entryRuleXImpure"
    // InternalXHDL.g:353:1: entryRuleXImpure : ruleXImpure EOF ;
    public final void entryRuleXImpure() throws RecognitionException {
        try {
            // InternalXHDL.g:354:1: ( ruleXImpure EOF )
            // InternalXHDL.g:355:1: ruleXImpure EOF
            {
             before(grammarAccess.getXImpureRule()); 
            pushFollow(FOLLOW_1);
            ruleXImpure();

            state._fsp--;

             after(grammarAccess.getXImpureRule()); 
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
    // $ANTLR end "entryRuleXImpure"


    // $ANTLR start "ruleXImpure"
    // InternalXHDL.g:362:1: ruleXImpure : ( ( rule__XImpure__Group__0 ) ) ;
    public final void ruleXImpure() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:366:2: ( ( ( rule__XImpure__Group__0 ) ) )
            // InternalXHDL.g:367:2: ( ( rule__XImpure__Group__0 ) )
            {
            // InternalXHDL.g:367:2: ( ( rule__XImpure__Group__0 ) )
            // InternalXHDL.g:368:3: ( rule__XImpure__Group__0 )
            {
             before(grammarAccess.getXImpureAccess().getGroup()); 
            // InternalXHDL.g:369:3: ( rule__XImpure__Group__0 )
            // InternalXHDL.g:369:4: rule__XImpure__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XImpure__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXImpureAccess().getGroup()); 

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
    // $ANTLR end "ruleXImpure"


    // $ANTLR start "rule__XElement__Alternatives"
    // InternalXHDL.g:377:1: rule__XElement__Alternatives : ( ( ruleXType ) | ( ruleXSignal ) | ( ruleXSubType ) | ( ruleXAttribute ) | ( ruleXImpure ) );
    public final void rule__XElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:381:1: ( ( ruleXType ) | ( ruleXSignal ) | ( ruleXSubType ) | ( ruleXAttribute ) | ( ruleXImpure ) )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 21:
            case 22:
            case 24:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 18:
                {
                alt2=3;
                }
                break;
            case 16:
                {
                alt2=4;
                }
                break;
            case 32:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalXHDL.g:382:2: ( ruleXType )
                    {
                    // InternalXHDL.g:382:2: ( ruleXType )
                    // InternalXHDL.g:383:3: ruleXType
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
                    // InternalXHDL.g:388:2: ( ruleXSignal )
                    {
                    // InternalXHDL.g:388:2: ( ruleXSignal )
                    // InternalXHDL.g:389:3: ruleXSignal
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
                    // InternalXHDL.g:394:2: ( ruleXSubType )
                    {
                    // InternalXHDL.g:394:2: ( ruleXSubType )
                    // InternalXHDL.g:395:3: ruleXSubType
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
                    // InternalXHDL.g:400:2: ( ruleXAttribute )
                    {
                    // InternalXHDL.g:400:2: ( ruleXAttribute )
                    // InternalXHDL.g:401:3: ruleXAttribute
                    {
                     before(grammarAccess.getXElementAccess().getXAttributeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleXAttribute();

                    state._fsp--;

                     after(grammarAccess.getXElementAccess().getXAttributeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalXHDL.g:406:2: ( ruleXImpure )
                    {
                    // InternalXHDL.g:406:2: ( ruleXImpure )
                    // InternalXHDL.g:407:3: ruleXImpure
                    {
                     before(grammarAccess.getXElementAccess().getXImpureParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleXImpure();

                    state._fsp--;

                     after(grammarAccess.getXElementAccess().getXImpureParserRuleCall_4()); 

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
    // InternalXHDL.g:416:1: rule__XType__Alternatives : ( ( ( rule__XType__Group_0__0 ) ) | ( ( rule__XType__XrangeAssignment_1 ) ) | ( ( rule__XType__Group_2__0 ) ) );
    public final void rule__XType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:420:1: ( ( ( rule__XType__Group_0__0 ) ) | ( ( rule__XType__XrangeAssignment_1 ) ) | ( ( rule__XType__Group_2__0 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt3=1;
                }
                break;
            case 24:
                {
                alt3=2;
                }
                break;
            case 22:
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
                    // InternalXHDL.g:421:2: ( ( rule__XType__Group_0__0 ) )
                    {
                    // InternalXHDL.g:421:2: ( ( rule__XType__Group_0__0 ) )
                    // InternalXHDL.g:422:3: ( rule__XType__Group_0__0 )
                    {
                     before(grammarAccess.getXTypeAccess().getGroup_0()); 
                    // InternalXHDL.g:423:3: ( rule__XType__Group_0__0 )
                    // InternalXHDL.g:423:4: rule__XType__Group_0__0
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
                    // InternalXHDL.g:427:2: ( ( rule__XType__XrangeAssignment_1 ) )
                    {
                    // InternalXHDL.g:427:2: ( ( rule__XType__XrangeAssignment_1 ) )
                    // InternalXHDL.g:428:3: ( rule__XType__XrangeAssignment_1 )
                    {
                     before(grammarAccess.getXTypeAccess().getXrangeAssignment_1()); 
                    // InternalXHDL.g:429:3: ( rule__XType__XrangeAssignment_1 )
                    // InternalXHDL.g:429:4: rule__XType__XrangeAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__XType__XrangeAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getXTypeAccess().getXrangeAssignment_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalXHDL.g:433:2: ( ( rule__XType__Group_2__0 ) )
                    {
                    // InternalXHDL.g:433:2: ( ( rule__XType__Group_2__0 ) )
                    // InternalXHDL.g:434:3: ( rule__XType__Group_2__0 )
                    {
                     before(grammarAccess.getXTypeAccess().getGroup_2()); 
                    // InternalXHDL.g:435:3: ( rule__XType__Group_2__0 )
                    // InternalXHDL.g:435:4: rule__XType__Group_2__0
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
    // InternalXHDL.g:443:1: rule__XPackage__Group__0 : rule__XPackage__Group__0__Impl rule__XPackage__Group__1 ;
    public final void rule__XPackage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:447:1: ( rule__XPackage__Group__0__Impl rule__XPackage__Group__1 )
            // InternalXHDL.g:448:2: rule__XPackage__Group__0__Impl rule__XPackage__Group__1
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
    // InternalXHDL.g:455:1: rule__XPackage__Group__0__Impl : ( () ) ;
    public final void rule__XPackage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:459:1: ( ( () ) )
            // InternalXHDL.g:460:1: ( () )
            {
            // InternalXHDL.g:460:1: ( () )
            // InternalXHDL.g:461:2: ()
            {
             before(grammarAccess.getXPackageAccess().getXPackageAction_0()); 
            // InternalXHDL.g:462:2: ()
            // InternalXHDL.g:462:3: 
            {
            }

             after(grammarAccess.getXPackageAccess().getXPackageAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XPackage__Group__0__Impl"


    // $ANTLR start "rule__XPackage__Group__1"
    // InternalXHDL.g:470:1: rule__XPackage__Group__1 : rule__XPackage__Group__1__Impl rule__XPackage__Group__2 ;
    public final void rule__XPackage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:474:1: ( rule__XPackage__Group__1__Impl rule__XPackage__Group__2 )
            // InternalXHDL.g:475:2: rule__XPackage__Group__1__Impl rule__XPackage__Group__2
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
    // InternalXHDL.g:482:1: rule__XPackage__Group__1__Impl : ( 'package' ) ;
    public final void rule__XPackage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:486:1: ( ( 'package' ) )
            // InternalXHDL.g:487:1: ( 'package' )
            {
            // InternalXHDL.g:487:1: ( 'package' )
            // InternalXHDL.g:488:2: 'package'
            {
             before(grammarAccess.getXPackageAccess().getPackageKeyword_1()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getPackageKeyword_1()); 

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
    // InternalXHDL.g:497:1: rule__XPackage__Group__2 : rule__XPackage__Group__2__Impl rule__XPackage__Group__3 ;
    public final void rule__XPackage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:501:1: ( rule__XPackage__Group__2__Impl rule__XPackage__Group__3 )
            // InternalXHDL.g:502:2: rule__XPackage__Group__2__Impl rule__XPackage__Group__3
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
    // InternalXHDL.g:509:1: rule__XPackage__Group__2__Impl : ( ( rule__XPackage__NameAssignment_2 ) ) ;
    public final void rule__XPackage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:513:1: ( ( ( rule__XPackage__NameAssignment_2 ) ) )
            // InternalXHDL.g:514:1: ( ( rule__XPackage__NameAssignment_2 ) )
            {
            // InternalXHDL.g:514:1: ( ( rule__XPackage__NameAssignment_2 ) )
            // InternalXHDL.g:515:2: ( rule__XPackage__NameAssignment_2 )
            {
             before(grammarAccess.getXPackageAccess().getNameAssignment_2()); 
            // InternalXHDL.g:516:2: ( rule__XPackage__NameAssignment_2 )
            // InternalXHDL.g:516:3: rule__XPackage__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XPackage__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXPackageAccess().getNameAssignment_2()); 

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
    // InternalXHDL.g:524:1: rule__XPackage__Group__3 : rule__XPackage__Group__3__Impl rule__XPackage__Group__4 ;
    public final void rule__XPackage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:528:1: ( rule__XPackage__Group__3__Impl rule__XPackage__Group__4 )
            // InternalXHDL.g:529:2: rule__XPackage__Group__3__Impl rule__XPackage__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalXHDL.g:536:1: rule__XPackage__Group__3__Impl : ( 'is' ) ;
    public final void rule__XPackage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:540:1: ( ( 'is' ) )
            // InternalXHDL.g:541:1: ( 'is' )
            {
            // InternalXHDL.g:541:1: ( 'is' )
            // InternalXHDL.g:542:2: 'is'
            {
             before(grammarAccess.getXPackageAccess().getIsKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getIsKeyword_3()); 

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
    // InternalXHDL.g:551:1: rule__XPackage__Group__4 : rule__XPackage__Group__4__Impl rule__XPackage__Group__5 ;
    public final void rule__XPackage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:555:1: ( rule__XPackage__Group__4__Impl rule__XPackage__Group__5 )
            // InternalXHDL.g:556:2: rule__XPackage__Group__4__Impl rule__XPackage__Group__5
            {
            pushFollow(FOLLOW_7);
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
    // InternalXHDL.g:563:1: rule__XPackage__Group__4__Impl : ( ( rule__XPackage__XisAssignment_4 )* ) ;
    public final void rule__XPackage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:567:1: ( ( ( rule__XPackage__XisAssignment_4 )* ) )
            // InternalXHDL.g:568:1: ( ( rule__XPackage__XisAssignment_4 )* )
            {
            // InternalXHDL.g:568:1: ( ( rule__XPackage__XisAssignment_4 )* )
            // InternalXHDL.g:569:2: ( rule__XPackage__XisAssignment_4 )*
            {
             before(grammarAccess.getXPackageAccess().getXisAssignment_4()); 
            // InternalXHDL.g:570:2: ( rule__XPackage__XisAssignment_4 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==16||(LA4_0>=18 && LA4_0<=19)||(LA4_0>=21 && LA4_0<=22)||LA4_0==24||LA4_0==32) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalXHDL.g:570:3: rule__XPackage__XisAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__XPackage__XisAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getXPackageAccess().getXisAssignment_4()); 

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
    // InternalXHDL.g:578:1: rule__XPackage__Group__5 : rule__XPackage__Group__5__Impl rule__XPackage__Group__6 ;
    public final void rule__XPackage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:582:1: ( rule__XPackage__Group__5__Impl rule__XPackage__Group__6 )
            // InternalXHDL.g:583:2: rule__XPackage__Group__5__Impl rule__XPackage__Group__6
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:590:1: rule__XPackage__Group__5__Impl : ( 'end' ) ;
    public final void rule__XPackage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:594:1: ( ( 'end' ) )
            // InternalXHDL.g:595:1: ( 'end' )
            {
            // InternalXHDL.g:595:1: ( 'end' )
            // InternalXHDL.g:596:2: 'end'
            {
             before(grammarAccess.getXPackageAccess().getEndKeyword_5()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getEndKeyword_5()); 

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
    // InternalXHDL.g:605:1: rule__XPackage__Group__6 : rule__XPackage__Group__6__Impl rule__XPackage__Group__7 ;
    public final void rule__XPackage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:609:1: ( rule__XPackage__Group__6__Impl rule__XPackage__Group__7 )
            // InternalXHDL.g:610:2: rule__XPackage__Group__6__Impl rule__XPackage__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__XPackage__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XPackage__Group__7();

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
    // InternalXHDL.g:617:1: rule__XPackage__Group__6__Impl : ( ( rule__XPackage__XendAssignment_6 ) ) ;
    public final void rule__XPackage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:621:1: ( ( ( rule__XPackage__XendAssignment_6 ) ) )
            // InternalXHDL.g:622:1: ( ( rule__XPackage__XendAssignment_6 ) )
            {
            // InternalXHDL.g:622:1: ( ( rule__XPackage__XendAssignment_6 ) )
            // InternalXHDL.g:623:2: ( rule__XPackage__XendAssignment_6 )
            {
             before(grammarAccess.getXPackageAccess().getXendAssignment_6()); 
            // InternalXHDL.g:624:2: ( rule__XPackage__XendAssignment_6 )
            // InternalXHDL.g:624:3: rule__XPackage__XendAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__XPackage__XendAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getXPackageAccess().getXendAssignment_6()); 

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


    // $ANTLR start "rule__XPackage__Group__7"
    // InternalXHDL.g:632:1: rule__XPackage__Group__7 : rule__XPackage__Group__7__Impl ;
    public final void rule__XPackage__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:636:1: ( rule__XPackage__Group__7__Impl )
            // InternalXHDL.g:637:2: rule__XPackage__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XPackage__Group__7__Impl();

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
    // $ANTLR end "rule__XPackage__Group__7"


    // $ANTLR start "rule__XPackage__Group__7__Impl"
    // InternalXHDL.g:643:1: rule__XPackage__Group__7__Impl : ( ';' ) ;
    public final void rule__XPackage__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:647:1: ( ( ';' ) )
            // InternalXHDL.g:648:1: ( ';' )
            {
            // InternalXHDL.g:648:1: ( ';' )
            // InternalXHDL.g:649:2: ';'
            {
             before(grammarAccess.getXPackageAccess().getSemicolonKeyword_7()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getSemicolonKeyword_7()); 

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
    // $ANTLR end "rule__XPackage__Group__7__Impl"


    // $ANTLR start "rule__XAttribute__Group__0"
    // InternalXHDL.g:659:1: rule__XAttribute__Group__0 : rule__XAttribute__Group__0__Impl rule__XAttribute__Group__1 ;
    public final void rule__XAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:663:1: ( rule__XAttribute__Group__0__Impl rule__XAttribute__Group__1 )
            // InternalXHDL.g:664:2: rule__XAttribute__Group__0__Impl rule__XAttribute__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalXHDL.g:671:1: rule__XAttribute__Group__0__Impl : ( () ) ;
    public final void rule__XAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:675:1: ( ( () ) )
            // InternalXHDL.g:676:1: ( () )
            {
            // InternalXHDL.g:676:1: ( () )
            // InternalXHDL.g:677:2: ()
            {
             before(grammarAccess.getXAttributeAccess().getXAttributeAction_0()); 
            // InternalXHDL.g:678:2: ()
            // InternalXHDL.g:678:3: 
            {
            }

             after(grammarAccess.getXAttributeAccess().getXAttributeAction_0()); 

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
    // InternalXHDL.g:686:1: rule__XAttribute__Group__1 : rule__XAttribute__Group__1__Impl rule__XAttribute__Group__2 ;
    public final void rule__XAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:690:1: ( rule__XAttribute__Group__1__Impl rule__XAttribute__Group__2 )
            // InternalXHDL.g:691:2: rule__XAttribute__Group__1__Impl rule__XAttribute__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:698:1: rule__XAttribute__Group__1__Impl : ( 'attribute' ) ;
    public final void rule__XAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:702:1: ( ( 'attribute' ) )
            // InternalXHDL.g:703:1: ( 'attribute' )
            {
            // InternalXHDL.g:703:1: ( 'attribute' )
            // InternalXHDL.g:704:2: 'attribute'
            {
             before(grammarAccess.getXAttributeAccess().getAttributeKeyword_1()); 
            match(input,16,FOLLOW_2); 
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
    // InternalXHDL.g:713:1: rule__XAttribute__Group__2 : rule__XAttribute__Group__2__Impl rule__XAttribute__Group__3 ;
    public final void rule__XAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:717:1: ( rule__XAttribute__Group__2__Impl rule__XAttribute__Group__3 )
            // InternalXHDL.g:718:2: rule__XAttribute__Group__2__Impl rule__XAttribute__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalXHDL.g:725:1: rule__XAttribute__Group__2__Impl : ( ( rule__XAttribute__NameAssignment_2 ) ) ;
    public final void rule__XAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:729:1: ( ( ( rule__XAttribute__NameAssignment_2 ) ) )
            // InternalXHDL.g:730:1: ( ( rule__XAttribute__NameAssignment_2 ) )
            {
            // InternalXHDL.g:730:1: ( ( rule__XAttribute__NameAssignment_2 ) )
            // InternalXHDL.g:731:2: ( rule__XAttribute__NameAssignment_2 )
            {
             before(grammarAccess.getXAttributeAccess().getNameAssignment_2()); 
            // InternalXHDL.g:732:2: ( rule__XAttribute__NameAssignment_2 )
            // InternalXHDL.g:732:3: rule__XAttribute__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XAttribute__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXAttributeAccess().getNameAssignment_2()); 

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
    // InternalXHDL.g:740:1: rule__XAttribute__Group__3 : rule__XAttribute__Group__3__Impl rule__XAttribute__Group__4 ;
    public final void rule__XAttribute__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:744:1: ( rule__XAttribute__Group__3__Impl rule__XAttribute__Group__4 )
            // InternalXHDL.g:745:2: rule__XAttribute__Group__3__Impl rule__XAttribute__Group__4
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:752:1: rule__XAttribute__Group__3__Impl : ( ':' ) ;
    public final void rule__XAttribute__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:756:1: ( ( ':' ) )
            // InternalXHDL.g:757:1: ( ':' )
            {
            // InternalXHDL.g:757:1: ( ':' )
            // InternalXHDL.g:758:2: ':'
            {
             before(grammarAccess.getXAttributeAccess().getColonKeyword_3()); 
            match(input,17,FOLLOW_2); 
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
    // InternalXHDL.g:767:1: rule__XAttribute__Group__4 : rule__XAttribute__Group__4__Impl rule__XAttribute__Group__5 ;
    public final void rule__XAttribute__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:771:1: ( rule__XAttribute__Group__4__Impl rule__XAttribute__Group__5 )
            // InternalXHDL.g:772:2: rule__XAttribute__Group__4__Impl rule__XAttribute__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalXHDL.g:779:1: rule__XAttribute__Group__4__Impl : ( ( rule__XAttribute__XtypeAssignment_4 ) ) ;
    public final void rule__XAttribute__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:783:1: ( ( ( rule__XAttribute__XtypeAssignment_4 ) ) )
            // InternalXHDL.g:784:1: ( ( rule__XAttribute__XtypeAssignment_4 ) )
            {
            // InternalXHDL.g:784:1: ( ( rule__XAttribute__XtypeAssignment_4 ) )
            // InternalXHDL.g:785:2: ( rule__XAttribute__XtypeAssignment_4 )
            {
             before(grammarAccess.getXAttributeAccess().getXtypeAssignment_4()); 
            // InternalXHDL.g:786:2: ( rule__XAttribute__XtypeAssignment_4 )
            // InternalXHDL.g:786:3: rule__XAttribute__XtypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XAttribute__XtypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getXAttributeAccess().getXtypeAssignment_4()); 

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
    // InternalXHDL.g:794:1: rule__XAttribute__Group__5 : rule__XAttribute__Group__5__Impl ;
    public final void rule__XAttribute__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:798:1: ( rule__XAttribute__Group__5__Impl )
            // InternalXHDL.g:799:2: rule__XAttribute__Group__5__Impl
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
    // InternalXHDL.g:805:1: rule__XAttribute__Group__5__Impl : ( ';' ) ;
    public final void rule__XAttribute__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:809:1: ( ( ';' ) )
            // InternalXHDL.g:810:1: ( ';' )
            {
            // InternalXHDL.g:810:1: ( ';' )
            // InternalXHDL.g:811:2: ';'
            {
             before(grammarAccess.getXAttributeAccess().getSemicolonKeyword_5()); 
            match(input,15,FOLLOW_2); 
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
    // InternalXHDL.g:821:1: rule__XSubType__Group__0 : rule__XSubType__Group__0__Impl rule__XSubType__Group__1 ;
    public final void rule__XSubType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:825:1: ( rule__XSubType__Group__0__Impl rule__XSubType__Group__1 )
            // InternalXHDL.g:826:2: rule__XSubType__Group__0__Impl rule__XSubType__Group__1
            {
            pushFollow(FOLLOW_12);
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
    // InternalXHDL.g:833:1: rule__XSubType__Group__0__Impl : ( () ) ;
    public final void rule__XSubType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:837:1: ( ( () ) )
            // InternalXHDL.g:838:1: ( () )
            {
            // InternalXHDL.g:838:1: ( () )
            // InternalXHDL.g:839:2: ()
            {
             before(grammarAccess.getXSubTypeAccess().getXSubTypeAction_0()); 
            // InternalXHDL.g:840:2: ()
            // InternalXHDL.g:840:3: 
            {
            }

             after(grammarAccess.getXSubTypeAccess().getXSubTypeAction_0()); 

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
    // InternalXHDL.g:848:1: rule__XSubType__Group__1 : rule__XSubType__Group__1__Impl rule__XSubType__Group__2 ;
    public final void rule__XSubType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:852:1: ( rule__XSubType__Group__1__Impl rule__XSubType__Group__2 )
            // InternalXHDL.g:853:2: rule__XSubType__Group__1__Impl rule__XSubType__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:860:1: rule__XSubType__Group__1__Impl : ( 'subtype' ) ;
    public final void rule__XSubType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:864:1: ( ( 'subtype' ) )
            // InternalXHDL.g:865:1: ( 'subtype' )
            {
            // InternalXHDL.g:865:1: ( 'subtype' )
            // InternalXHDL.g:866:2: 'subtype'
            {
             before(grammarAccess.getXSubTypeAccess().getSubtypeKeyword_1()); 
            match(input,18,FOLLOW_2); 
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
    // InternalXHDL.g:875:1: rule__XSubType__Group__2 : rule__XSubType__Group__2__Impl rule__XSubType__Group__3 ;
    public final void rule__XSubType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:879:1: ( rule__XSubType__Group__2__Impl rule__XSubType__Group__3 )
            // InternalXHDL.g:880:2: rule__XSubType__Group__2__Impl rule__XSubType__Group__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalXHDL.g:887:1: rule__XSubType__Group__2__Impl : ( ( rule__XSubType__NameAssignment_2 ) ) ;
    public final void rule__XSubType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:891:1: ( ( ( rule__XSubType__NameAssignment_2 ) ) )
            // InternalXHDL.g:892:1: ( ( rule__XSubType__NameAssignment_2 ) )
            {
            // InternalXHDL.g:892:1: ( ( rule__XSubType__NameAssignment_2 ) )
            // InternalXHDL.g:893:2: ( rule__XSubType__NameAssignment_2 )
            {
             before(grammarAccess.getXSubTypeAccess().getNameAssignment_2()); 
            // InternalXHDL.g:894:2: ( rule__XSubType__NameAssignment_2 )
            // InternalXHDL.g:894:3: rule__XSubType__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XSubType__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXSubTypeAccess().getNameAssignment_2()); 

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
    // InternalXHDL.g:902:1: rule__XSubType__Group__3 : rule__XSubType__Group__3__Impl rule__XSubType__Group__4 ;
    public final void rule__XSubType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:906:1: ( rule__XSubType__Group__3__Impl rule__XSubType__Group__4 )
            // InternalXHDL.g:907:2: rule__XSubType__Group__3__Impl rule__XSubType__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__XSubType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSubType__Group__4();

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
    // InternalXHDL.g:914:1: rule__XSubType__Group__3__Impl : ( 'is' ) ;
    public final void rule__XSubType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:918:1: ( ( 'is' ) )
            // InternalXHDL.g:919:1: ( 'is' )
            {
            // InternalXHDL.g:919:1: ( 'is' )
            // InternalXHDL.g:920:2: 'is'
            {
             before(grammarAccess.getXSubTypeAccess().getIsKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getXSubTypeAccess().getIsKeyword_3()); 

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


    // $ANTLR start "rule__XSubType__Group__4"
    // InternalXHDL.g:929:1: rule__XSubType__Group__4 : rule__XSubType__Group__4__Impl rule__XSubType__Group__5 ;
    public final void rule__XSubType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:933:1: ( rule__XSubType__Group__4__Impl rule__XSubType__Group__5 )
            // InternalXHDL.g:934:2: rule__XSubType__Group__4__Impl rule__XSubType__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__XSubType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSubType__Group__5();

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
    // $ANTLR end "rule__XSubType__Group__4"


    // $ANTLR start "rule__XSubType__Group__4__Impl"
    // InternalXHDL.g:941:1: rule__XSubType__Group__4__Impl : ( ( rule__XSubType__XisAssignment_4 ) ) ;
    public final void rule__XSubType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:945:1: ( ( ( rule__XSubType__XisAssignment_4 ) ) )
            // InternalXHDL.g:946:1: ( ( rule__XSubType__XisAssignment_4 ) )
            {
            // InternalXHDL.g:946:1: ( ( rule__XSubType__XisAssignment_4 ) )
            // InternalXHDL.g:947:2: ( rule__XSubType__XisAssignment_4 )
            {
             before(grammarAccess.getXSubTypeAccess().getXisAssignment_4()); 
            // InternalXHDL.g:948:2: ( rule__XSubType__XisAssignment_4 )
            // InternalXHDL.g:948:3: rule__XSubType__XisAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XSubType__XisAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getXSubTypeAccess().getXisAssignment_4()); 

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
    // $ANTLR end "rule__XSubType__Group__4__Impl"


    // $ANTLR start "rule__XSubType__Group__5"
    // InternalXHDL.g:956:1: rule__XSubType__Group__5 : rule__XSubType__Group__5__Impl ;
    public final void rule__XSubType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:960:1: ( rule__XSubType__Group__5__Impl )
            // InternalXHDL.g:961:2: rule__XSubType__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XSubType__Group__5__Impl();

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
    // $ANTLR end "rule__XSubType__Group__5"


    // $ANTLR start "rule__XSubType__Group__5__Impl"
    // InternalXHDL.g:967:1: rule__XSubType__Group__5__Impl : ( ';' ) ;
    public final void rule__XSubType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:971:1: ( ( ';' ) )
            // InternalXHDL.g:972:1: ( ';' )
            {
            // InternalXHDL.g:972:1: ( ';' )
            // InternalXHDL.g:973:2: ';'
            {
             before(grammarAccess.getXSubTypeAccess().getSemicolonKeyword_5()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getXSubTypeAccess().getSemicolonKeyword_5()); 

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
    // $ANTLR end "rule__XSubType__Group__5__Impl"


    // $ANTLR start "rule__XSignal__Group__0"
    // InternalXHDL.g:983:1: rule__XSignal__Group__0 : rule__XSignal__Group__0__Impl rule__XSignal__Group__1 ;
    public final void rule__XSignal__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:987:1: ( rule__XSignal__Group__0__Impl rule__XSignal__Group__1 )
            // InternalXHDL.g:988:2: rule__XSignal__Group__0__Impl rule__XSignal__Group__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalXHDL.g:995:1: rule__XSignal__Group__0__Impl : ( () ) ;
    public final void rule__XSignal__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:999:1: ( ( () ) )
            // InternalXHDL.g:1000:1: ( () )
            {
            // InternalXHDL.g:1000:1: ( () )
            // InternalXHDL.g:1001:2: ()
            {
             before(grammarAccess.getXSignalAccess().getXSignalAction_0()); 
            // InternalXHDL.g:1002:2: ()
            // InternalXHDL.g:1002:3: 
            {
            }

             after(grammarAccess.getXSignalAccess().getXSignalAction_0()); 

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
    // InternalXHDL.g:1010:1: rule__XSignal__Group__1 : rule__XSignal__Group__1__Impl rule__XSignal__Group__2 ;
    public final void rule__XSignal__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1014:1: ( rule__XSignal__Group__1__Impl rule__XSignal__Group__2 )
            // InternalXHDL.g:1015:2: rule__XSignal__Group__1__Impl rule__XSignal__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:1022:1: rule__XSignal__Group__1__Impl : ( 'signal' ) ;
    public final void rule__XSignal__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1026:1: ( ( 'signal' ) )
            // InternalXHDL.g:1027:1: ( 'signal' )
            {
            // InternalXHDL.g:1027:1: ( 'signal' )
            // InternalXHDL.g:1028:2: 'signal'
            {
             before(grammarAccess.getXSignalAccess().getSignalKeyword_1()); 
            match(input,19,FOLLOW_2); 
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
    // InternalXHDL.g:1037:1: rule__XSignal__Group__2 : rule__XSignal__Group__2__Impl rule__XSignal__Group__3 ;
    public final void rule__XSignal__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1041:1: ( rule__XSignal__Group__2__Impl rule__XSignal__Group__3 )
            // InternalXHDL.g:1042:2: rule__XSignal__Group__2__Impl rule__XSignal__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalXHDL.g:1049:1: rule__XSignal__Group__2__Impl : ( ( rule__XSignal__NameAssignment_2 ) ) ;
    public final void rule__XSignal__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1053:1: ( ( ( rule__XSignal__NameAssignment_2 ) ) )
            // InternalXHDL.g:1054:1: ( ( rule__XSignal__NameAssignment_2 ) )
            {
            // InternalXHDL.g:1054:1: ( ( rule__XSignal__NameAssignment_2 ) )
            // InternalXHDL.g:1055:2: ( rule__XSignal__NameAssignment_2 )
            {
             before(grammarAccess.getXSignalAccess().getNameAssignment_2()); 
            // InternalXHDL.g:1056:2: ( rule__XSignal__NameAssignment_2 )
            // InternalXHDL.g:1056:3: rule__XSignal__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XSignal__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXSignalAccess().getNameAssignment_2()); 

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
    // InternalXHDL.g:1064:1: rule__XSignal__Group__3 : rule__XSignal__Group__3__Impl rule__XSignal__Group__4 ;
    public final void rule__XSignal__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1068:1: ( rule__XSignal__Group__3__Impl rule__XSignal__Group__4 )
            // InternalXHDL.g:1069:2: rule__XSignal__Group__3__Impl rule__XSignal__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__XSignal__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSignal__Group__4();

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
    // InternalXHDL.g:1076:1: rule__XSignal__Group__3__Impl : ( ':' ) ;
    public final void rule__XSignal__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1080:1: ( ( ':' ) )
            // InternalXHDL.g:1081:1: ( ':' )
            {
            // InternalXHDL.g:1081:1: ( ':' )
            // InternalXHDL.g:1082:2: ':'
            {
             before(grammarAccess.getXSignalAccess().getColonKeyword_3()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getColonKeyword_3()); 

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


    // $ANTLR start "rule__XSignal__Group__4"
    // InternalXHDL.g:1091:1: rule__XSignal__Group__4 : rule__XSignal__Group__4__Impl rule__XSignal__Group__5 ;
    public final void rule__XSignal__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1095:1: ( rule__XSignal__Group__4__Impl rule__XSignal__Group__5 )
            // InternalXHDL.g:1096:2: rule__XSignal__Group__4__Impl rule__XSignal__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__XSignal__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSignal__Group__5();

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
    // $ANTLR end "rule__XSignal__Group__4"


    // $ANTLR start "rule__XSignal__Group__4__Impl"
    // InternalXHDL.g:1103:1: rule__XSignal__Group__4__Impl : ( ( rule__XSignal__XtypeAssignment_4 ) ) ;
    public final void rule__XSignal__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1107:1: ( ( ( rule__XSignal__XtypeAssignment_4 ) ) )
            // InternalXHDL.g:1108:1: ( ( rule__XSignal__XtypeAssignment_4 ) )
            {
            // InternalXHDL.g:1108:1: ( ( rule__XSignal__XtypeAssignment_4 ) )
            // InternalXHDL.g:1109:2: ( rule__XSignal__XtypeAssignment_4 )
            {
             before(grammarAccess.getXSignalAccess().getXtypeAssignment_4()); 
            // InternalXHDL.g:1110:2: ( rule__XSignal__XtypeAssignment_4 )
            // InternalXHDL.g:1110:3: rule__XSignal__XtypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XSignal__XtypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getXSignalAccess().getXtypeAssignment_4()); 

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
    // $ANTLR end "rule__XSignal__Group__4__Impl"


    // $ANTLR start "rule__XSignal__Group__5"
    // InternalXHDL.g:1118:1: rule__XSignal__Group__5 : rule__XSignal__Group__5__Impl rule__XSignal__Group__6 ;
    public final void rule__XSignal__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1122:1: ( rule__XSignal__Group__5__Impl rule__XSignal__Group__6 )
            // InternalXHDL.g:1123:2: rule__XSignal__Group__5__Impl rule__XSignal__Group__6
            {
            pushFollow(FOLLOW_14);
            rule__XSignal__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSignal__Group__6();

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
    // $ANTLR end "rule__XSignal__Group__5"


    // $ANTLR start "rule__XSignal__Group__5__Impl"
    // InternalXHDL.g:1130:1: rule__XSignal__Group__5__Impl : ( ( rule__XSignal__Group_5__0 )? ) ;
    public final void rule__XSignal__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1134:1: ( ( ( rule__XSignal__Group_5__0 )? ) )
            // InternalXHDL.g:1135:1: ( ( rule__XSignal__Group_5__0 )? )
            {
            // InternalXHDL.g:1135:1: ( ( rule__XSignal__Group_5__0 )? )
            // InternalXHDL.g:1136:2: ( rule__XSignal__Group_5__0 )?
            {
             before(grammarAccess.getXSignalAccess().getGroup_5()); 
            // InternalXHDL.g:1137:2: ( rule__XSignal__Group_5__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==20) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXHDL.g:1137:3: rule__XSignal__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XSignal__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXSignalAccess().getGroup_5()); 

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
    // $ANTLR end "rule__XSignal__Group__5__Impl"


    // $ANTLR start "rule__XSignal__Group__6"
    // InternalXHDL.g:1145:1: rule__XSignal__Group__6 : rule__XSignal__Group__6__Impl ;
    public final void rule__XSignal__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1149:1: ( rule__XSignal__Group__6__Impl )
            // InternalXHDL.g:1150:2: rule__XSignal__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XSignal__Group__6__Impl();

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
    // $ANTLR end "rule__XSignal__Group__6"


    // $ANTLR start "rule__XSignal__Group__6__Impl"
    // InternalXHDL.g:1156:1: rule__XSignal__Group__6__Impl : ( ';' ) ;
    public final void rule__XSignal__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1160:1: ( ( ';' ) )
            // InternalXHDL.g:1161:1: ( ';' )
            {
            // InternalXHDL.g:1161:1: ( ';' )
            // InternalXHDL.g:1162:2: ';'
            {
             before(grammarAccess.getXSignalAccess().getSemicolonKeyword_6()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getSemicolonKeyword_6()); 

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
    // $ANTLR end "rule__XSignal__Group__6__Impl"


    // $ANTLR start "rule__XSignal__Group_5__0"
    // InternalXHDL.g:1172:1: rule__XSignal__Group_5__0 : rule__XSignal__Group_5__0__Impl rule__XSignal__Group_5__1 ;
    public final void rule__XSignal__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1176:1: ( rule__XSignal__Group_5__0__Impl rule__XSignal__Group_5__1 )
            // InternalXHDL.g:1177:2: rule__XSignal__Group_5__0__Impl rule__XSignal__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__XSignal__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XSignal__Group_5__1();

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
    // $ANTLR end "rule__XSignal__Group_5__0"


    // $ANTLR start "rule__XSignal__Group_5__0__Impl"
    // InternalXHDL.g:1184:1: rule__XSignal__Group_5__0__Impl : ( ';=' ) ;
    public final void rule__XSignal__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1188:1: ( ( ';=' ) )
            // InternalXHDL.g:1189:1: ( ';=' )
            {
            // InternalXHDL.g:1189:1: ( ';=' )
            // InternalXHDL.g:1190:2: ';='
            {
             before(grammarAccess.getXSignalAccess().getSemicolonEqualsSignKeyword_5_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getSemicolonEqualsSignKeyword_5_0()); 

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
    // $ANTLR end "rule__XSignal__Group_5__0__Impl"


    // $ANTLR start "rule__XSignal__Group_5__1"
    // InternalXHDL.g:1199:1: rule__XSignal__Group_5__1 : rule__XSignal__Group_5__1__Impl ;
    public final void rule__XSignal__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1203:1: ( rule__XSignal__Group_5__1__Impl )
            // InternalXHDL.g:1204:2: rule__XSignal__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XSignal__Group_5__1__Impl();

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
    // $ANTLR end "rule__XSignal__Group_5__1"


    // $ANTLR start "rule__XSignal__Group_5__1__Impl"
    // InternalXHDL.g:1210:1: rule__XSignal__Group_5__1__Impl : ( RULE_ID ) ;
    public final void rule__XSignal__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1214:1: ( ( RULE_ID ) )
            // InternalXHDL.g:1215:1: ( RULE_ID )
            {
            // InternalXHDL.g:1215:1: ( RULE_ID )
            // InternalXHDL.g:1216:2: RULE_ID
            {
             before(grammarAccess.getXSignalAccess().getIDTerminalRuleCall_5_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getIDTerminalRuleCall_5_1()); 

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
    // $ANTLR end "rule__XSignal__Group_5__1__Impl"


    // $ANTLR start "rule__XType__Group_0__0"
    // InternalXHDL.g:1226:1: rule__XType__Group_0__0 : rule__XType__Group_0__0__Impl rule__XType__Group_0__1 ;
    public final void rule__XType__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1230:1: ( rule__XType__Group_0__0__Impl rule__XType__Group_0__1 )
            // InternalXHDL.g:1231:2: rule__XType__Group_0__0__Impl rule__XType__Group_0__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalXHDL.g:1238:1: rule__XType__Group_0__0__Impl : ( () ) ;
    public final void rule__XType__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1242:1: ( ( () ) )
            // InternalXHDL.g:1243:1: ( () )
            {
            // InternalXHDL.g:1243:1: ( () )
            // InternalXHDL.g:1244:2: ()
            {
             before(grammarAccess.getXTypeAccess().getXTypeAction_0_0()); 
            // InternalXHDL.g:1245:2: ()
            // InternalXHDL.g:1245:3: 
            {
            }

             after(grammarAccess.getXTypeAccess().getXTypeAction_0_0()); 

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
    // InternalXHDL.g:1253:1: rule__XType__Group_0__1 : rule__XType__Group_0__1__Impl rule__XType__Group_0__2 ;
    public final void rule__XType__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1257:1: ( rule__XType__Group_0__1__Impl rule__XType__Group_0__2 )
            // InternalXHDL.g:1258:2: rule__XType__Group_0__1__Impl rule__XType__Group_0__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:1265:1: rule__XType__Group_0__1__Impl : ( 'type' ) ;
    public final void rule__XType__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1269:1: ( ( 'type' ) )
            // InternalXHDL.g:1270:1: ( 'type' )
            {
            // InternalXHDL.g:1270:1: ( 'type' )
            // InternalXHDL.g:1271:2: 'type'
            {
             before(grammarAccess.getXTypeAccess().getTypeKeyword_0_1()); 
            match(input,21,FOLLOW_2); 
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
    // InternalXHDL.g:1280:1: rule__XType__Group_0__2 : rule__XType__Group_0__2__Impl rule__XType__Group_0__3 ;
    public final void rule__XType__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1284:1: ( rule__XType__Group_0__2__Impl rule__XType__Group_0__3 )
            // InternalXHDL.g:1285:2: rule__XType__Group_0__2__Impl rule__XType__Group_0__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalXHDL.g:1292:1: rule__XType__Group_0__2__Impl : ( ( rule__XType__NameAssignment_0_2 ) ) ;
    public final void rule__XType__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1296:1: ( ( ( rule__XType__NameAssignment_0_2 ) ) )
            // InternalXHDL.g:1297:1: ( ( rule__XType__NameAssignment_0_2 ) )
            {
            // InternalXHDL.g:1297:1: ( ( rule__XType__NameAssignment_0_2 ) )
            // InternalXHDL.g:1298:2: ( rule__XType__NameAssignment_0_2 )
            {
             before(grammarAccess.getXTypeAccess().getNameAssignment_0_2()); 
            // InternalXHDL.g:1299:2: ( rule__XType__NameAssignment_0_2 )
            // InternalXHDL.g:1299:3: rule__XType__NameAssignment_0_2
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
    // InternalXHDL.g:1307:1: rule__XType__Group_0__3 : rule__XType__Group_0__3__Impl rule__XType__Group_0__4 ;
    public final void rule__XType__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1311:1: ( rule__XType__Group_0__3__Impl rule__XType__Group_0__4 )
            // InternalXHDL.g:1312:2: rule__XType__Group_0__3__Impl rule__XType__Group_0__4
            {
            pushFollow(FOLLOW_16);
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
    // InternalXHDL.g:1319:1: rule__XType__Group_0__3__Impl : ( 'is' ) ;
    public final void rule__XType__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1323:1: ( ( 'is' ) )
            // InternalXHDL.g:1324:1: ( 'is' )
            {
            // InternalXHDL.g:1324:1: ( 'is' )
            // InternalXHDL.g:1325:2: 'is'
            {
             before(grammarAccess.getXTypeAccess().getIsKeyword_0_3()); 
            match(input,13,FOLLOW_2); 
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
    // InternalXHDL.g:1334:1: rule__XType__Group_0__4 : rule__XType__Group_0__4__Impl ;
    public final void rule__XType__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1338:1: ( rule__XType__Group_0__4__Impl )
            // InternalXHDL.g:1339:2: rule__XType__Group_0__4__Impl
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
    // InternalXHDL.g:1345:1: rule__XType__Group_0__4__Impl : ( ( rule__XType__XenumsAssignment_0_4 ) ) ;
    public final void rule__XType__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1349:1: ( ( ( rule__XType__XenumsAssignment_0_4 ) ) )
            // InternalXHDL.g:1350:1: ( ( rule__XType__XenumsAssignment_0_4 ) )
            {
            // InternalXHDL.g:1350:1: ( ( rule__XType__XenumsAssignment_0_4 ) )
            // InternalXHDL.g:1351:2: ( rule__XType__XenumsAssignment_0_4 )
            {
             before(grammarAccess.getXTypeAccess().getXenumsAssignment_0_4()); 
            // InternalXHDL.g:1352:2: ( rule__XType__XenumsAssignment_0_4 )
            // InternalXHDL.g:1352:3: rule__XType__XenumsAssignment_0_4
            {
            pushFollow(FOLLOW_2);
            rule__XType__XenumsAssignment_0_4();

            state._fsp--;


            }

             after(grammarAccess.getXTypeAccess().getXenumsAssignment_0_4()); 

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
    // InternalXHDL.g:1361:1: rule__XType__Group_2__0 : rule__XType__Group_2__0__Impl rule__XType__Group_2__1 ;
    public final void rule__XType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1365:1: ( rule__XType__Group_2__0__Impl rule__XType__Group_2__1 )
            // InternalXHDL.g:1366:2: rule__XType__Group_2__0__Impl rule__XType__Group_2__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalXHDL.g:1373:1: rule__XType__Group_2__0__Impl : ( ( rule__XType__XarrayAssignment_2_0 ) ) ;
    public final void rule__XType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1377:1: ( ( ( rule__XType__XarrayAssignment_2_0 ) ) )
            // InternalXHDL.g:1378:1: ( ( rule__XType__XarrayAssignment_2_0 ) )
            {
            // InternalXHDL.g:1378:1: ( ( rule__XType__XarrayAssignment_2_0 ) )
            // InternalXHDL.g:1379:2: ( rule__XType__XarrayAssignment_2_0 )
            {
             before(grammarAccess.getXTypeAccess().getXarrayAssignment_2_0()); 
            // InternalXHDL.g:1380:2: ( rule__XType__XarrayAssignment_2_0 )
            // InternalXHDL.g:1380:3: rule__XType__XarrayAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__XType__XarrayAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getXTypeAccess().getXarrayAssignment_2_0()); 

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
    // InternalXHDL.g:1388:1: rule__XType__Group_2__1 : rule__XType__Group_2__1__Impl ;
    public final void rule__XType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1392:1: ( rule__XType__Group_2__1__Impl )
            // InternalXHDL.g:1393:2: rule__XType__Group_2__1__Impl
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
    // InternalXHDL.g:1399:1: rule__XType__Group_2__1__Impl : ( ';' ) ;
    public final void rule__XType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1403:1: ( ( ';' ) )
            // InternalXHDL.g:1404:1: ( ';' )
            {
            // InternalXHDL.g:1404:1: ( ';' )
            // InternalXHDL.g:1405:2: ';'
            {
             before(grammarAccess.getXTypeAccess().getSemicolonKeyword_2_1()); 
            match(input,15,FOLLOW_2); 
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
    // InternalXHDL.g:1415:1: rule__XArray__Group__0 : rule__XArray__Group__0__Impl rule__XArray__Group__1 ;
    public final void rule__XArray__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1419:1: ( rule__XArray__Group__0__Impl rule__XArray__Group__1 )
            // InternalXHDL.g:1420:2: rule__XArray__Group__0__Impl rule__XArray__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalXHDL.g:1427:1: rule__XArray__Group__0__Impl : ( () ) ;
    public final void rule__XArray__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1431:1: ( ( () ) )
            // InternalXHDL.g:1432:1: ( () )
            {
            // InternalXHDL.g:1432:1: ( () )
            // InternalXHDL.g:1433:2: ()
            {
             before(grammarAccess.getXArrayAccess().getXArrayAction_0()); 
            // InternalXHDL.g:1434:2: ()
            // InternalXHDL.g:1434:3: 
            {
            }

             after(grammarAccess.getXArrayAccess().getXArrayAction_0()); 

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
    // InternalXHDL.g:1442:1: rule__XArray__Group__1 : rule__XArray__Group__1__Impl rule__XArray__Group__2 ;
    public final void rule__XArray__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1446:1: ( rule__XArray__Group__1__Impl rule__XArray__Group__2 )
            // InternalXHDL.g:1447:2: rule__XArray__Group__1__Impl rule__XArray__Group__2
            {
            pushFollow(FOLLOW_16);
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
    // InternalXHDL.g:1454:1: rule__XArray__Group__1__Impl : ( 'array' ) ;
    public final void rule__XArray__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1458:1: ( ( 'array' ) )
            // InternalXHDL.g:1459:1: ( 'array' )
            {
            // InternalXHDL.g:1459:1: ( 'array' )
            // InternalXHDL.g:1460:2: 'array'
            {
             before(grammarAccess.getXArrayAccess().getArrayKeyword_1()); 
            match(input,22,FOLLOW_2); 
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
    // InternalXHDL.g:1469:1: rule__XArray__Group__2 : rule__XArray__Group__2__Impl rule__XArray__Group__3 ;
    public final void rule__XArray__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1473:1: ( rule__XArray__Group__2__Impl rule__XArray__Group__3 )
            // InternalXHDL.g:1474:2: rule__XArray__Group__2__Impl rule__XArray__Group__3
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:1481:1: rule__XArray__Group__2__Impl : ( '(' ) ;
    public final void rule__XArray__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1485:1: ( ( '(' ) )
            // InternalXHDL.g:1486:1: ( '(' )
            {
            // InternalXHDL.g:1486:1: ( '(' )
            // InternalXHDL.g:1487:2: '('
            {
             before(grammarAccess.getXArrayAccess().getLeftParenthesisKeyword_2()); 
            match(input,23,FOLLOW_2); 
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
    // InternalXHDL.g:1496:1: rule__XArray__Group__3 : rule__XArray__Group__3__Impl rule__XArray__Group__4 ;
    public final void rule__XArray__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1500:1: ( rule__XArray__Group__3__Impl rule__XArray__Group__4 )
            // InternalXHDL.g:1501:2: rule__XArray__Group__3__Impl rule__XArray__Group__4
            {
            pushFollow(FOLLOW_18);
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
    // InternalXHDL.g:1508:1: rule__XArray__Group__3__Impl : ( ( rule__XArray__XrangeAssignment_3 ) ) ;
    public final void rule__XArray__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1512:1: ( ( ( rule__XArray__XrangeAssignment_3 ) ) )
            // InternalXHDL.g:1513:1: ( ( rule__XArray__XrangeAssignment_3 ) )
            {
            // InternalXHDL.g:1513:1: ( ( rule__XArray__XrangeAssignment_3 ) )
            // InternalXHDL.g:1514:2: ( rule__XArray__XrangeAssignment_3 )
            {
             before(grammarAccess.getXArrayAccess().getXrangeAssignment_3()); 
            // InternalXHDL.g:1515:2: ( rule__XArray__XrangeAssignment_3 )
            // InternalXHDL.g:1515:3: rule__XArray__XrangeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__XArray__XrangeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getXArrayAccess().getXrangeAssignment_3()); 

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
    // InternalXHDL.g:1523:1: rule__XArray__Group__4 : rule__XArray__Group__4__Impl rule__XArray__Group__5 ;
    public final void rule__XArray__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1527:1: ( rule__XArray__Group__4__Impl rule__XArray__Group__5 )
            // InternalXHDL.g:1528:2: rule__XArray__Group__4__Impl rule__XArray__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalXHDL.g:1535:1: rule__XArray__Group__4__Impl : ( 'range' ) ;
    public final void rule__XArray__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1539:1: ( ( 'range' ) )
            // InternalXHDL.g:1540:1: ( 'range' )
            {
            // InternalXHDL.g:1540:1: ( 'range' )
            // InternalXHDL.g:1541:2: 'range'
            {
             before(grammarAccess.getXArrayAccess().getRangeKeyword_4()); 
            match(input,24,FOLLOW_2); 
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
    // InternalXHDL.g:1550:1: rule__XArray__Group__5 : rule__XArray__Group__5__Impl rule__XArray__Group__6 ;
    public final void rule__XArray__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1554:1: ( rule__XArray__Group__5__Impl rule__XArray__Group__6 )
            // InternalXHDL.g:1555:2: rule__XArray__Group__5__Impl rule__XArray__Group__6
            {
            pushFollow(FOLLOW_20);
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
    // InternalXHDL.g:1562:1: rule__XArray__Group__5__Impl : ( '<>' ) ;
    public final void rule__XArray__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1566:1: ( ( '<>' ) )
            // InternalXHDL.g:1567:1: ( '<>' )
            {
            // InternalXHDL.g:1567:1: ( '<>' )
            // InternalXHDL.g:1568:2: '<>'
            {
             before(grammarAccess.getXArrayAccess().getLessThanSignGreaterThanSignKeyword_5()); 
            match(input,25,FOLLOW_2); 
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
    // InternalXHDL.g:1577:1: rule__XArray__Group__6 : rule__XArray__Group__6__Impl rule__XArray__Group__7 ;
    public final void rule__XArray__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1581:1: ( rule__XArray__Group__6__Impl rule__XArray__Group__7 )
            // InternalXHDL.g:1582:2: rule__XArray__Group__6__Impl rule__XArray__Group__7
            {
            pushFollow(FOLLOW_21);
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
    // InternalXHDL.g:1589:1: rule__XArray__Group__6__Impl : ( ')' ) ;
    public final void rule__XArray__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1593:1: ( ( ')' ) )
            // InternalXHDL.g:1594:1: ( ')' )
            {
            // InternalXHDL.g:1594:1: ( ')' )
            // InternalXHDL.g:1595:2: ')'
            {
             before(grammarAccess.getXArrayAccess().getRightParenthesisKeyword_6()); 
            match(input,26,FOLLOW_2); 
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
    // InternalXHDL.g:1604:1: rule__XArray__Group__7 : rule__XArray__Group__7__Impl rule__XArray__Group__8 ;
    public final void rule__XArray__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1608:1: ( rule__XArray__Group__7__Impl rule__XArray__Group__8 )
            // InternalXHDL.g:1609:2: rule__XArray__Group__7__Impl rule__XArray__Group__8
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:1616:1: rule__XArray__Group__7__Impl : ( 'of' ) ;
    public final void rule__XArray__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1620:1: ( ( 'of' ) )
            // InternalXHDL.g:1621:1: ( 'of' )
            {
            // InternalXHDL.g:1621:1: ( 'of' )
            // InternalXHDL.g:1622:2: 'of'
            {
             before(grammarAccess.getXArrayAccess().getOfKeyword_7()); 
            match(input,27,FOLLOW_2); 
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
    // InternalXHDL.g:1631:1: rule__XArray__Group__8 : rule__XArray__Group__8__Impl ;
    public final void rule__XArray__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1635:1: ( rule__XArray__Group__8__Impl )
            // InternalXHDL.g:1636:2: rule__XArray__Group__8__Impl
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
    // InternalXHDL.g:1642:1: rule__XArray__Group__8__Impl : ( ( rule__XArray__XofAssignment_8 ) ) ;
    public final void rule__XArray__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1646:1: ( ( ( rule__XArray__XofAssignment_8 ) ) )
            // InternalXHDL.g:1647:1: ( ( rule__XArray__XofAssignment_8 ) )
            {
            // InternalXHDL.g:1647:1: ( ( rule__XArray__XofAssignment_8 ) )
            // InternalXHDL.g:1648:2: ( rule__XArray__XofAssignment_8 )
            {
             before(grammarAccess.getXArrayAccess().getXofAssignment_8()); 
            // InternalXHDL.g:1649:2: ( rule__XArray__XofAssignment_8 )
            // InternalXHDL.g:1649:3: rule__XArray__XofAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__XArray__XofAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getXArrayAccess().getXofAssignment_8()); 

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
    // InternalXHDL.g:1658:1: rule__XRange__Group__0 : rule__XRange__Group__0__Impl rule__XRange__Group__1 ;
    public final void rule__XRange__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1662:1: ( rule__XRange__Group__0__Impl rule__XRange__Group__1 )
            // InternalXHDL.g:1663:2: rule__XRange__Group__0__Impl rule__XRange__Group__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalXHDL.g:1670:1: rule__XRange__Group__0__Impl : ( () ) ;
    public final void rule__XRange__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1674:1: ( ( () ) )
            // InternalXHDL.g:1675:1: ( () )
            {
            // InternalXHDL.g:1675:1: ( () )
            // InternalXHDL.g:1676:2: ()
            {
             before(grammarAccess.getXRangeAccess().getXRangeAction_0()); 
            // InternalXHDL.g:1677:2: ()
            // InternalXHDL.g:1677:3: 
            {
            }

             after(grammarAccess.getXRangeAccess().getXRangeAction_0()); 

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
    // InternalXHDL.g:1685:1: rule__XRange__Group__1 : rule__XRange__Group__1__Impl rule__XRange__Group__2 ;
    public final void rule__XRange__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1689:1: ( rule__XRange__Group__1__Impl rule__XRange__Group__2 )
            // InternalXHDL.g:1690:2: rule__XRange__Group__1__Impl rule__XRange__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:1697:1: rule__XRange__Group__1__Impl : ( 'range' ) ;
    public final void rule__XRange__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1701:1: ( ( 'range' ) )
            // InternalXHDL.g:1702:1: ( 'range' )
            {
            // InternalXHDL.g:1702:1: ( 'range' )
            // InternalXHDL.g:1703:2: 'range'
            {
             before(grammarAccess.getXRangeAccess().getRangeKeyword_1()); 
            match(input,24,FOLLOW_2); 
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
    // InternalXHDL.g:1712:1: rule__XRange__Group__2 : rule__XRange__Group__2__Impl rule__XRange__Group__3 ;
    public final void rule__XRange__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1716:1: ( rule__XRange__Group__2__Impl rule__XRange__Group__3 )
            // InternalXHDL.g:1717:2: rule__XRange__Group__2__Impl rule__XRange__Group__3
            {
            pushFollow(FOLLOW_22);
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
    // InternalXHDL.g:1724:1: rule__XRange__Group__2__Impl : ( ( rule__XRange__XfromAssignment_2 ) ) ;
    public final void rule__XRange__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1728:1: ( ( ( rule__XRange__XfromAssignment_2 ) ) )
            // InternalXHDL.g:1729:1: ( ( rule__XRange__XfromAssignment_2 ) )
            {
            // InternalXHDL.g:1729:1: ( ( rule__XRange__XfromAssignment_2 ) )
            // InternalXHDL.g:1730:2: ( rule__XRange__XfromAssignment_2 )
            {
             before(grammarAccess.getXRangeAccess().getXfromAssignment_2()); 
            // InternalXHDL.g:1731:2: ( rule__XRange__XfromAssignment_2 )
            // InternalXHDL.g:1731:3: rule__XRange__XfromAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__XRange__XfromAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getXRangeAccess().getXfromAssignment_2()); 

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
    // InternalXHDL.g:1739:1: rule__XRange__Group__3 : rule__XRange__Group__3__Impl rule__XRange__Group__4 ;
    public final void rule__XRange__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1743:1: ( rule__XRange__Group__3__Impl rule__XRange__Group__4 )
            // InternalXHDL.g:1744:2: rule__XRange__Group__3__Impl rule__XRange__Group__4
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:1751:1: rule__XRange__Group__3__Impl : ( 'to' ) ;
    public final void rule__XRange__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1755:1: ( ( 'to' ) )
            // InternalXHDL.g:1756:1: ( 'to' )
            {
            // InternalXHDL.g:1756:1: ( 'to' )
            // InternalXHDL.g:1757:2: 'to'
            {
             before(grammarAccess.getXRangeAccess().getToKeyword_3()); 
            match(input,28,FOLLOW_2); 
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
    // InternalXHDL.g:1766:1: rule__XRange__Group__4 : rule__XRange__Group__4__Impl rule__XRange__Group__5 ;
    public final void rule__XRange__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1770:1: ( rule__XRange__Group__4__Impl rule__XRange__Group__5 )
            // InternalXHDL.g:1771:2: rule__XRange__Group__4__Impl rule__XRange__Group__5
            {
            pushFollow(FOLLOW_23);
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
    // InternalXHDL.g:1778:1: rule__XRange__Group__4__Impl : ( ( rule__XRange__XtoAssignment_4 ) ) ;
    public final void rule__XRange__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1782:1: ( ( ( rule__XRange__XtoAssignment_4 ) ) )
            // InternalXHDL.g:1783:1: ( ( rule__XRange__XtoAssignment_4 ) )
            {
            // InternalXHDL.g:1783:1: ( ( rule__XRange__XtoAssignment_4 ) )
            // InternalXHDL.g:1784:2: ( rule__XRange__XtoAssignment_4 )
            {
             before(grammarAccess.getXRangeAccess().getXtoAssignment_4()); 
            // InternalXHDL.g:1785:2: ( rule__XRange__XtoAssignment_4 )
            // InternalXHDL.g:1785:3: rule__XRange__XtoAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__XRange__XtoAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getXRangeAccess().getXtoAssignment_4()); 

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
    // InternalXHDL.g:1793:1: rule__XRange__Group__5 : rule__XRange__Group__5__Impl ;
    public final void rule__XRange__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1797:1: ( rule__XRange__Group__5__Impl )
            // InternalXHDL.g:1798:2: rule__XRange__Group__5__Impl
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
    // InternalXHDL.g:1804:1: rule__XRange__Group__5__Impl : ( ( rule__XRange__XunitsAssignment_5 )? ) ;
    public final void rule__XRange__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1808:1: ( ( ( rule__XRange__XunitsAssignment_5 )? ) )
            // InternalXHDL.g:1809:1: ( ( rule__XRange__XunitsAssignment_5 )? )
            {
            // InternalXHDL.g:1809:1: ( ( rule__XRange__XunitsAssignment_5 )? )
            // InternalXHDL.g:1810:2: ( rule__XRange__XunitsAssignment_5 )?
            {
             before(grammarAccess.getXRangeAccess().getXunitsAssignment_5()); 
            // InternalXHDL.g:1811:2: ( rule__XRange__XunitsAssignment_5 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==29) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXHDL.g:1811:3: rule__XRange__XunitsAssignment_5
                    {
                    pushFollow(FOLLOW_2);
                    rule__XRange__XunitsAssignment_5();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXRangeAccess().getXunitsAssignment_5()); 

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
    // InternalXHDL.g:1820:1: rule__XUnits__Group__0 : rule__XUnits__Group__0__Impl rule__XUnits__Group__1 ;
    public final void rule__XUnits__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1824:1: ( rule__XUnits__Group__0__Impl rule__XUnits__Group__1 )
            // InternalXHDL.g:1825:2: rule__XUnits__Group__0__Impl rule__XUnits__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalXHDL.g:1832:1: rule__XUnits__Group__0__Impl : ( () ) ;
    public final void rule__XUnits__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1836:1: ( ( () ) )
            // InternalXHDL.g:1837:1: ( () )
            {
            // InternalXHDL.g:1837:1: ( () )
            // InternalXHDL.g:1838:2: ()
            {
             before(grammarAccess.getXUnitsAccess().getXUnitsAction_0()); 
            // InternalXHDL.g:1839:2: ()
            // InternalXHDL.g:1839:3: 
            {
            }

             after(grammarAccess.getXUnitsAccess().getXUnitsAction_0()); 

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
    // InternalXHDL.g:1847:1: rule__XUnits__Group__1 : rule__XUnits__Group__1__Impl rule__XUnits__Group__2 ;
    public final void rule__XUnits__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1851:1: ( rule__XUnits__Group__1__Impl rule__XUnits__Group__2 )
            // InternalXHDL.g:1852:2: rule__XUnits__Group__1__Impl rule__XUnits__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalXHDL.g:1859:1: rule__XUnits__Group__1__Impl : ( 'units' ) ;
    public final void rule__XUnits__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1863:1: ( ( 'units' ) )
            // InternalXHDL.g:1864:1: ( 'units' )
            {
            // InternalXHDL.g:1864:1: ( 'units' )
            // InternalXHDL.g:1865:2: 'units'
            {
             before(grammarAccess.getXUnitsAccess().getUnitsKeyword_1()); 
            match(input,29,FOLLOW_2); 
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
    // InternalXHDL.g:1874:1: rule__XUnits__Group__2 : rule__XUnits__Group__2__Impl rule__XUnits__Group__3 ;
    public final void rule__XUnits__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1878:1: ( rule__XUnits__Group__2__Impl rule__XUnits__Group__3 )
            // InternalXHDL.g:1879:2: rule__XUnits__Group__2__Impl rule__XUnits__Group__3
            {
            pushFollow(FOLLOW_24);
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
    // InternalXHDL.g:1886:1: rule__XUnits__Group__2__Impl : ( ( rule__XUnits__XunitsAssignment_2 )* ) ;
    public final void rule__XUnits__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1890:1: ( ( ( rule__XUnits__XunitsAssignment_2 )* ) )
            // InternalXHDL.g:1891:1: ( ( rule__XUnits__XunitsAssignment_2 )* )
            {
            // InternalXHDL.g:1891:1: ( ( rule__XUnits__XunitsAssignment_2 )* )
            // InternalXHDL.g:1892:2: ( rule__XUnits__XunitsAssignment_2 )*
            {
             before(grammarAccess.getXUnitsAccess().getXunitsAssignment_2()); 
            // InternalXHDL.g:1893:2: ( rule__XUnits__XunitsAssignment_2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXHDL.g:1893:3: rule__XUnits__XunitsAssignment_2
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__XUnits__XunitsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getXUnitsAccess().getXunitsAssignment_2()); 

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
    // InternalXHDL.g:1901:1: rule__XUnits__Group__3 : rule__XUnits__Group__3__Impl rule__XUnits__Group__4 ;
    public final void rule__XUnits__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1905:1: ( rule__XUnits__Group__3__Impl rule__XUnits__Group__4 )
            // InternalXHDL.g:1906:2: rule__XUnits__Group__3__Impl rule__XUnits__Group__4
            {
            pushFollow(FOLLOW_23);
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
    // InternalXHDL.g:1913:1: rule__XUnits__Group__3__Impl : ( 'end' ) ;
    public final void rule__XUnits__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1917:1: ( ( 'end' ) )
            // InternalXHDL.g:1918:1: ( 'end' )
            {
            // InternalXHDL.g:1918:1: ( 'end' )
            // InternalXHDL.g:1919:2: 'end'
            {
             before(grammarAccess.getXUnitsAccess().getEndKeyword_3()); 
            match(input,14,FOLLOW_2); 
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
    // InternalXHDL.g:1928:1: rule__XUnits__Group__4 : rule__XUnits__Group__4__Impl ;
    public final void rule__XUnits__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1932:1: ( rule__XUnits__Group__4__Impl )
            // InternalXHDL.g:1933:2: rule__XUnits__Group__4__Impl
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
    // InternalXHDL.g:1939:1: rule__XUnits__Group__4__Impl : ( 'units' ) ;
    public final void rule__XUnits__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1943:1: ( ( 'units' ) )
            // InternalXHDL.g:1944:1: ( 'units' )
            {
            // InternalXHDL.g:1944:1: ( 'units' )
            // InternalXHDL.g:1945:2: 'units'
            {
             before(grammarAccess.getXUnitsAccess().getUnitsKeyword_4()); 
            match(input,29,FOLLOW_2); 
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
    // InternalXHDL.g:1955:1: rule__XUnit__Group__0 : rule__XUnit__Group__0__Impl rule__XUnit__Group__1 ;
    public final void rule__XUnit__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1959:1: ( rule__XUnit__Group__0__Impl rule__XUnit__Group__1 )
            // InternalXHDL.g:1960:2: rule__XUnit__Group__0__Impl rule__XUnit__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalXHDL.g:1967:1: rule__XUnit__Group__0__Impl : ( () ) ;
    public final void rule__XUnit__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1971:1: ( ( () ) )
            // InternalXHDL.g:1972:1: ( () )
            {
            // InternalXHDL.g:1972:1: ( () )
            // InternalXHDL.g:1973:2: ()
            {
             before(grammarAccess.getXUnitAccess().getXUnitAction_0()); 
            // InternalXHDL.g:1974:2: ()
            // InternalXHDL.g:1974:3: 
            {
            }

             after(grammarAccess.getXUnitAccess().getXUnitAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XUnit__Group__0__Impl"


    // $ANTLR start "rule__XUnit__Group__1"
    // InternalXHDL.g:1982:1: rule__XUnit__Group__1 : rule__XUnit__Group__1__Impl rule__XUnit__Group__2 ;
    public final void rule__XUnit__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1986:1: ( rule__XUnit__Group__1__Impl rule__XUnit__Group__2 )
            // InternalXHDL.g:1987:2: rule__XUnit__Group__1__Impl rule__XUnit__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalXHDL.g:1994:1: rule__XUnit__Group__1__Impl : ( ( rule__XUnit__NameAssignment_1 ) ) ;
    public final void rule__XUnit__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:1998:1: ( ( ( rule__XUnit__NameAssignment_1 ) ) )
            // InternalXHDL.g:1999:1: ( ( rule__XUnit__NameAssignment_1 ) )
            {
            // InternalXHDL.g:1999:1: ( ( rule__XUnit__NameAssignment_1 ) )
            // InternalXHDL.g:2000:2: ( rule__XUnit__NameAssignment_1 )
            {
             before(grammarAccess.getXUnitAccess().getNameAssignment_1()); 
            // InternalXHDL.g:2001:2: ( rule__XUnit__NameAssignment_1 )
            // InternalXHDL.g:2001:3: rule__XUnit__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__XUnit__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getXUnitAccess().getNameAssignment_1()); 

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
    // InternalXHDL.g:2009:1: rule__XUnit__Group__2 : rule__XUnit__Group__2__Impl rule__XUnit__Group__3 ;
    public final void rule__XUnit__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2013:1: ( rule__XUnit__Group__2__Impl rule__XUnit__Group__3 )
            // InternalXHDL.g:2014:2: rule__XUnit__Group__2__Impl rule__XUnit__Group__3
            {
            pushFollow(FOLLOW_26);
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
    // InternalXHDL.g:2021:1: rule__XUnit__Group__2__Impl : ( ( rule__XUnit__Group_2__0 )? ) ;
    public final void rule__XUnit__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2025:1: ( ( ( rule__XUnit__Group_2__0 )? ) )
            // InternalXHDL.g:2026:1: ( ( rule__XUnit__Group_2__0 )? )
            {
            // InternalXHDL.g:2026:1: ( ( rule__XUnit__Group_2__0 )? )
            // InternalXHDL.g:2027:2: ( rule__XUnit__Group_2__0 )?
            {
             before(grammarAccess.getXUnitAccess().getGroup_2()); 
            // InternalXHDL.g:2028:2: ( rule__XUnit__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==30) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXHDL.g:2028:3: rule__XUnit__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__XUnit__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getXUnitAccess().getGroup_2()); 

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
    // InternalXHDL.g:2036:1: rule__XUnit__Group__3 : rule__XUnit__Group__3__Impl ;
    public final void rule__XUnit__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2040:1: ( rule__XUnit__Group__3__Impl )
            // InternalXHDL.g:2041:2: rule__XUnit__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XUnit__Group__3__Impl();

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
    // InternalXHDL.g:2047:1: rule__XUnit__Group__3__Impl : ( ';' ) ;
    public final void rule__XUnit__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2051:1: ( ( ';' ) )
            // InternalXHDL.g:2052:1: ( ';' )
            {
            // InternalXHDL.g:2052:1: ( ';' )
            // InternalXHDL.g:2053:2: ';'
            {
             before(grammarAccess.getXUnitAccess().getSemicolonKeyword_3()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getSemicolonKeyword_3()); 

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


    // $ANTLR start "rule__XUnit__Group_2__0"
    // InternalXHDL.g:2063:1: rule__XUnit__Group_2__0 : rule__XUnit__Group_2__0__Impl rule__XUnit__Group_2__1 ;
    public final void rule__XUnit__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2067:1: ( rule__XUnit__Group_2__0__Impl rule__XUnit__Group_2__1 )
            // InternalXHDL.g:2068:2: rule__XUnit__Group_2__0__Impl rule__XUnit__Group_2__1
            {
            pushFollow(FOLLOW_27);
            rule__XUnit__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnit__Group_2__1();

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
    // $ANTLR end "rule__XUnit__Group_2__0"


    // $ANTLR start "rule__XUnit__Group_2__0__Impl"
    // InternalXHDL.g:2075:1: rule__XUnit__Group_2__0__Impl : ( '=' ) ;
    public final void rule__XUnit__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2079:1: ( ( '=' ) )
            // InternalXHDL.g:2080:1: ( '=' )
            {
            // InternalXHDL.g:2080:1: ( '=' )
            // InternalXHDL.g:2081:2: '='
            {
             before(grammarAccess.getXUnitAccess().getEqualsSignKeyword_2_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getEqualsSignKeyword_2_0()); 

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
    // $ANTLR end "rule__XUnit__Group_2__0__Impl"


    // $ANTLR start "rule__XUnit__Group_2__1"
    // InternalXHDL.g:2090:1: rule__XUnit__Group_2__1 : rule__XUnit__Group_2__1__Impl rule__XUnit__Group_2__2 ;
    public final void rule__XUnit__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2094:1: ( rule__XUnit__Group_2__1__Impl rule__XUnit__Group_2__2 )
            // InternalXHDL.g:2095:2: rule__XUnit__Group_2__1__Impl rule__XUnit__Group_2__2
            {
            pushFollow(FOLLOW_5);
            rule__XUnit__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XUnit__Group_2__2();

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
    // $ANTLR end "rule__XUnit__Group_2__1"


    // $ANTLR start "rule__XUnit__Group_2__1__Impl"
    // InternalXHDL.g:2102:1: rule__XUnit__Group_2__1__Impl : ( ( rule__XUnit__XvalueAssignment_2_1 ) ) ;
    public final void rule__XUnit__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2106:1: ( ( ( rule__XUnit__XvalueAssignment_2_1 ) ) )
            // InternalXHDL.g:2107:1: ( ( rule__XUnit__XvalueAssignment_2_1 ) )
            {
            // InternalXHDL.g:2107:1: ( ( rule__XUnit__XvalueAssignment_2_1 ) )
            // InternalXHDL.g:2108:2: ( rule__XUnit__XvalueAssignment_2_1 )
            {
             before(grammarAccess.getXUnitAccess().getXvalueAssignment_2_1()); 
            // InternalXHDL.g:2109:2: ( rule__XUnit__XvalueAssignment_2_1 )
            // InternalXHDL.g:2109:3: rule__XUnit__XvalueAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__XUnit__XvalueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getXUnitAccess().getXvalueAssignment_2_1()); 

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
    // $ANTLR end "rule__XUnit__Group_2__1__Impl"


    // $ANTLR start "rule__XUnit__Group_2__2"
    // InternalXHDL.g:2117:1: rule__XUnit__Group_2__2 : rule__XUnit__Group_2__2__Impl ;
    public final void rule__XUnit__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2121:1: ( rule__XUnit__Group_2__2__Impl )
            // InternalXHDL.g:2122:2: rule__XUnit__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XUnit__Group_2__2__Impl();

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
    // $ANTLR end "rule__XUnit__Group_2__2"


    // $ANTLR start "rule__XUnit__Group_2__2__Impl"
    // InternalXHDL.g:2128:1: rule__XUnit__Group_2__2__Impl : ( ( rule__XUnit__XbasedAssignment_2_2 ) ) ;
    public final void rule__XUnit__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2132:1: ( ( ( rule__XUnit__XbasedAssignment_2_2 ) ) )
            // InternalXHDL.g:2133:1: ( ( rule__XUnit__XbasedAssignment_2_2 ) )
            {
            // InternalXHDL.g:2133:1: ( ( rule__XUnit__XbasedAssignment_2_2 ) )
            // InternalXHDL.g:2134:2: ( rule__XUnit__XbasedAssignment_2_2 )
            {
             before(grammarAccess.getXUnitAccess().getXbasedAssignment_2_2()); 
            // InternalXHDL.g:2135:2: ( rule__XUnit__XbasedAssignment_2_2 )
            // InternalXHDL.g:2135:3: rule__XUnit__XbasedAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__XUnit__XbasedAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getXUnitAccess().getXbasedAssignment_2_2()); 

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
    // $ANTLR end "rule__XUnit__Group_2__2__Impl"


    // $ANTLR start "rule__XEnums__Group__0"
    // InternalXHDL.g:2144:1: rule__XEnums__Group__0 : rule__XEnums__Group__0__Impl rule__XEnums__Group__1 ;
    public final void rule__XEnums__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2148:1: ( rule__XEnums__Group__0__Impl rule__XEnums__Group__1 )
            // InternalXHDL.g:2149:2: rule__XEnums__Group__0__Impl rule__XEnums__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalXHDL.g:2156:1: rule__XEnums__Group__0__Impl : ( () ) ;
    public final void rule__XEnums__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2160:1: ( ( () ) )
            // InternalXHDL.g:2161:1: ( () )
            {
            // InternalXHDL.g:2161:1: ( () )
            // InternalXHDL.g:2162:2: ()
            {
             before(grammarAccess.getXEnumsAccess().getXEnumsAction_0()); 
            // InternalXHDL.g:2163:2: ()
            // InternalXHDL.g:2163:3: 
            {
            }

             after(grammarAccess.getXEnumsAccess().getXEnumsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XEnums__Group__0__Impl"


    // $ANTLR start "rule__XEnums__Group__1"
    // InternalXHDL.g:2171:1: rule__XEnums__Group__1 : rule__XEnums__Group__1__Impl rule__XEnums__Group__2 ;
    public final void rule__XEnums__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2175:1: ( rule__XEnums__Group__1__Impl rule__XEnums__Group__2 )
            // InternalXHDL.g:2176:2: rule__XEnums__Group__1__Impl rule__XEnums__Group__2
            {
            pushFollow(FOLLOW_28);
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
    // InternalXHDL.g:2183:1: rule__XEnums__Group__1__Impl : ( '(' ) ;
    public final void rule__XEnums__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2187:1: ( ( '(' ) )
            // InternalXHDL.g:2188:1: ( '(' )
            {
            // InternalXHDL.g:2188:1: ( '(' )
            // InternalXHDL.g:2189:2: '('
            {
             before(grammarAccess.getXEnumsAccess().getLeftParenthesisKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getXEnumsAccess().getLeftParenthesisKeyword_1()); 

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
    // InternalXHDL.g:2198:1: rule__XEnums__Group__2 : rule__XEnums__Group__2__Impl rule__XEnums__Group__3 ;
    public final void rule__XEnums__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2202:1: ( rule__XEnums__Group__2__Impl rule__XEnums__Group__3 )
            // InternalXHDL.g:2203:2: rule__XEnums__Group__2__Impl rule__XEnums__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__XEnums__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XEnums__Group__3();

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
    // InternalXHDL.g:2210:1: rule__XEnums__Group__2__Impl : ( ( rule__XEnums__Group_2__0 )* ) ;
    public final void rule__XEnums__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2214:1: ( ( ( rule__XEnums__Group_2__0 )* ) )
            // InternalXHDL.g:2215:1: ( ( rule__XEnums__Group_2__0 )* )
            {
            // InternalXHDL.g:2215:1: ( ( rule__XEnums__Group_2__0 )* )
            // InternalXHDL.g:2216:2: ( rule__XEnums__Group_2__0 )*
            {
             before(grammarAccess.getXEnumsAccess().getGroup_2()); 
            // InternalXHDL.g:2217:2: ( rule__XEnums__Group_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID||LA9_0==31) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalXHDL.g:2217:3: rule__XEnums__Group_2__0
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__XEnums__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getXEnumsAccess().getGroup_2()); 

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


    // $ANTLR start "rule__XEnums__Group__3"
    // InternalXHDL.g:2225:1: rule__XEnums__Group__3 : rule__XEnums__Group__3__Impl ;
    public final void rule__XEnums__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2229:1: ( rule__XEnums__Group__3__Impl )
            // InternalXHDL.g:2230:2: rule__XEnums__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEnums__Group__3__Impl();

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
    // $ANTLR end "rule__XEnums__Group__3"


    // $ANTLR start "rule__XEnums__Group__3__Impl"
    // InternalXHDL.g:2236:1: rule__XEnums__Group__3__Impl : ( ')' ) ;
    public final void rule__XEnums__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2240:1: ( ( ')' ) )
            // InternalXHDL.g:2241:1: ( ')' )
            {
            // InternalXHDL.g:2241:1: ( ')' )
            // InternalXHDL.g:2242:2: ')'
            {
             before(grammarAccess.getXEnumsAccess().getRightParenthesisKeyword_3()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getXEnumsAccess().getRightParenthesisKeyword_3()); 

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
    // $ANTLR end "rule__XEnums__Group__3__Impl"


    // $ANTLR start "rule__XEnums__Group_2__0"
    // InternalXHDL.g:2252:1: rule__XEnums__Group_2__0 : rule__XEnums__Group_2__0__Impl rule__XEnums__Group_2__1 ;
    public final void rule__XEnums__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2256:1: ( rule__XEnums__Group_2__0__Impl rule__XEnums__Group_2__1 )
            // InternalXHDL.g:2257:2: rule__XEnums__Group_2__0__Impl rule__XEnums__Group_2__1
            {
            pushFollow(FOLLOW_30);
            rule__XEnums__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XEnums__Group_2__1();

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
    // $ANTLR end "rule__XEnums__Group_2__0"


    // $ANTLR start "rule__XEnums__Group_2__0__Impl"
    // InternalXHDL.g:2264:1: rule__XEnums__Group_2__0__Impl : ( ( ',' )? ) ;
    public final void rule__XEnums__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2268:1: ( ( ( ',' )? ) )
            // InternalXHDL.g:2269:1: ( ( ',' )? )
            {
            // InternalXHDL.g:2269:1: ( ( ',' )? )
            // InternalXHDL.g:2270:2: ( ',' )?
            {
             before(grammarAccess.getXEnumsAccess().getCommaKeyword_2_0()); 
            // InternalXHDL.g:2271:2: ( ',' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==31) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalXHDL.g:2271:3: ','
                    {
                    match(input,31,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getXEnumsAccess().getCommaKeyword_2_0()); 

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
    // $ANTLR end "rule__XEnums__Group_2__0__Impl"


    // $ANTLR start "rule__XEnums__Group_2__1"
    // InternalXHDL.g:2279:1: rule__XEnums__Group_2__1 : rule__XEnums__Group_2__1__Impl ;
    public final void rule__XEnums__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2283:1: ( rule__XEnums__Group_2__1__Impl )
            // InternalXHDL.g:2284:2: rule__XEnums__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XEnums__Group_2__1__Impl();

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
    // $ANTLR end "rule__XEnums__Group_2__1"


    // $ANTLR start "rule__XEnums__Group_2__1__Impl"
    // InternalXHDL.g:2290:1: rule__XEnums__Group_2__1__Impl : ( ( rule__XEnums__XenumsAssignment_2_1 ) ) ;
    public final void rule__XEnums__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2294:1: ( ( ( rule__XEnums__XenumsAssignment_2_1 ) ) )
            // InternalXHDL.g:2295:1: ( ( rule__XEnums__XenumsAssignment_2_1 ) )
            {
            // InternalXHDL.g:2295:1: ( ( rule__XEnums__XenumsAssignment_2_1 ) )
            // InternalXHDL.g:2296:2: ( rule__XEnums__XenumsAssignment_2_1 )
            {
             before(grammarAccess.getXEnumsAccess().getXenumsAssignment_2_1()); 
            // InternalXHDL.g:2297:2: ( rule__XEnums__XenumsAssignment_2_1 )
            // InternalXHDL.g:2297:3: rule__XEnums__XenumsAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__XEnums__XenumsAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getXEnumsAccess().getXenumsAssignment_2_1()); 

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
    // $ANTLR end "rule__XEnums__Group_2__1__Impl"


    // $ANTLR start "rule__XImpure__Group__0"
    // InternalXHDL.g:2306:1: rule__XImpure__Group__0 : rule__XImpure__Group__0__Impl rule__XImpure__Group__1 ;
    public final void rule__XImpure__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2310:1: ( rule__XImpure__Group__0__Impl rule__XImpure__Group__1 )
            // InternalXHDL.g:2311:2: rule__XImpure__Group__0__Impl rule__XImpure__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__XImpure__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XImpure__Group__1();

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
    // $ANTLR end "rule__XImpure__Group__0"


    // $ANTLR start "rule__XImpure__Group__0__Impl"
    // InternalXHDL.g:2318:1: rule__XImpure__Group__0__Impl : ( 'impure' ) ;
    public final void rule__XImpure__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2322:1: ( ( 'impure' ) )
            // InternalXHDL.g:2323:1: ( 'impure' )
            {
            // InternalXHDL.g:2323:1: ( 'impure' )
            // InternalXHDL.g:2324:2: 'impure'
            {
             before(grammarAccess.getXImpureAccess().getImpureKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getXImpureAccess().getImpureKeyword_0()); 

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
    // $ANTLR end "rule__XImpure__Group__0__Impl"


    // $ANTLR start "rule__XImpure__Group__1"
    // InternalXHDL.g:2333:1: rule__XImpure__Group__1 : rule__XImpure__Group__1__Impl rule__XImpure__Group__2 ;
    public final void rule__XImpure__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2337:1: ( rule__XImpure__Group__1__Impl rule__XImpure__Group__2 )
            // InternalXHDL.g:2338:2: rule__XImpure__Group__1__Impl rule__XImpure__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__XImpure__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XImpure__Group__2();

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
    // $ANTLR end "rule__XImpure__Group__1"


    // $ANTLR start "rule__XImpure__Group__1__Impl"
    // InternalXHDL.g:2345:1: rule__XImpure__Group__1__Impl : ( ( rule__XImpure__XfuncAssignment_1 ) ) ;
    public final void rule__XImpure__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2349:1: ( ( ( rule__XImpure__XfuncAssignment_1 ) ) )
            // InternalXHDL.g:2350:1: ( ( rule__XImpure__XfuncAssignment_1 ) )
            {
            // InternalXHDL.g:2350:1: ( ( rule__XImpure__XfuncAssignment_1 ) )
            // InternalXHDL.g:2351:2: ( rule__XImpure__XfuncAssignment_1 )
            {
             before(grammarAccess.getXImpureAccess().getXfuncAssignment_1()); 
            // InternalXHDL.g:2352:2: ( rule__XImpure__XfuncAssignment_1 )
            // InternalXHDL.g:2352:3: rule__XImpure__XfuncAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__XImpure__XfuncAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getXImpureAccess().getXfuncAssignment_1()); 

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
    // $ANTLR end "rule__XImpure__Group__1__Impl"


    // $ANTLR start "rule__XImpure__Group__2"
    // InternalXHDL.g:2360:1: rule__XImpure__Group__2 : rule__XImpure__Group__2__Impl ;
    public final void rule__XImpure__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2364:1: ( rule__XImpure__Group__2__Impl )
            // InternalXHDL.g:2365:2: rule__XImpure__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XImpure__Group__2__Impl();

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
    // $ANTLR end "rule__XImpure__Group__2"


    // $ANTLR start "rule__XImpure__Group__2__Impl"
    // InternalXHDL.g:2371:1: rule__XImpure__Group__2__Impl : ( ';' ) ;
    public final void rule__XImpure__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2375:1: ( ( ';' ) )
            // InternalXHDL.g:2376:1: ( ';' )
            {
            // InternalXHDL.g:2376:1: ( ';' )
            // InternalXHDL.g:2377:2: ';'
            {
             before(grammarAccess.getXImpureAccess().getSemicolonKeyword_2()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getXImpureAccess().getSemicolonKeyword_2()); 

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
    // $ANTLR end "rule__XImpure__Group__2__Impl"


    // $ANTLR start "rule__Xhdl__PackagesAssignment"
    // InternalXHDL.g:2387:1: rule__Xhdl__PackagesAssignment : ( ruleXPackage ) ;
    public final void rule__Xhdl__PackagesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2391:1: ( ( ruleXPackage ) )
            // InternalXHDL.g:2392:2: ( ruleXPackage )
            {
            // InternalXHDL.g:2392:2: ( ruleXPackage )
            // InternalXHDL.g:2393:3: ruleXPackage
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


    // $ANTLR start "rule__XPackage__NameAssignment_2"
    // InternalXHDL.g:2402:1: rule__XPackage__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__XPackage__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2406:1: ( ( RULE_ID ) )
            // InternalXHDL.g:2407:2: ( RULE_ID )
            {
            // InternalXHDL.g:2407:2: ( RULE_ID )
            // InternalXHDL.g:2408:3: RULE_ID
            {
             before(grammarAccess.getXPackageAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__XPackage__NameAssignment_2"


    // $ANTLR start "rule__XPackage__XisAssignment_4"
    // InternalXHDL.g:2417:1: rule__XPackage__XisAssignment_4 : ( ruleXElement ) ;
    public final void rule__XPackage__XisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2421:1: ( ( ruleXElement ) )
            // InternalXHDL.g:2422:2: ( ruleXElement )
            {
            // InternalXHDL.g:2422:2: ( ruleXElement )
            // InternalXHDL.g:2423:3: ruleXElement
            {
             before(grammarAccess.getXPackageAccess().getXisXElementParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleXElement();

            state._fsp--;

             after(grammarAccess.getXPackageAccess().getXisXElementParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__XPackage__XisAssignment_4"


    // $ANTLR start "rule__XPackage__XendAssignment_6"
    // InternalXHDL.g:2432:1: rule__XPackage__XendAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__XPackage__XendAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2436:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2437:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2437:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2438:3: ( RULE_ID )
            {
             before(grammarAccess.getXPackageAccess().getXendXPackageRefCrossReference_6_0()); 
            // InternalXHDL.g:2439:3: ( RULE_ID )
            // InternalXHDL.g:2440:4: RULE_ID
            {
             before(grammarAccess.getXPackageAccess().getXendXPackageRefIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXPackageAccess().getXendXPackageRefIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getXPackageAccess().getXendXPackageRefCrossReference_6_0()); 

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
    // $ANTLR end "rule__XPackage__XendAssignment_6"


    // $ANTLR start "rule__XAttribute__NameAssignment_2"
    // InternalXHDL.g:2451:1: rule__XAttribute__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__XAttribute__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2455:1: ( ( RULE_ID ) )
            // InternalXHDL.g:2456:2: ( RULE_ID )
            {
            // InternalXHDL.g:2456:2: ( RULE_ID )
            // InternalXHDL.g:2457:3: RULE_ID
            {
             before(grammarAccess.getXAttributeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXAttributeAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__XAttribute__NameAssignment_2"


    // $ANTLR start "rule__XAttribute__XtypeAssignment_4"
    // InternalXHDL.g:2466:1: rule__XAttribute__XtypeAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__XAttribute__XtypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2470:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2471:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2471:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2472:3: ( RULE_ID )
            {
             before(grammarAccess.getXAttributeAccess().getXtypeXTypeRefCrossReference_4_0()); 
            // InternalXHDL.g:2473:3: ( RULE_ID )
            // InternalXHDL.g:2474:4: RULE_ID
            {
             before(grammarAccess.getXAttributeAccess().getXtypeXTypeRefIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXAttributeAccess().getXtypeXTypeRefIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getXAttributeAccess().getXtypeXTypeRefCrossReference_4_0()); 

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
    // $ANTLR end "rule__XAttribute__XtypeAssignment_4"


    // $ANTLR start "rule__XSubType__NameAssignment_2"
    // InternalXHDL.g:2485:1: rule__XSubType__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__XSubType__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2489:1: ( ( RULE_ID ) )
            // InternalXHDL.g:2490:2: ( RULE_ID )
            {
            // InternalXHDL.g:2490:2: ( RULE_ID )
            // InternalXHDL.g:2491:3: RULE_ID
            {
             before(grammarAccess.getXSubTypeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXSubTypeAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__XSubType__NameAssignment_2"


    // $ANTLR start "rule__XSubType__XisAssignment_4"
    // InternalXHDL.g:2500:1: rule__XSubType__XisAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__XSubType__XisAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2504:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2505:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2505:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2506:3: ( RULE_ID )
            {
             before(grammarAccess.getXSubTypeAccess().getXisXTypeRefCrossReference_4_0()); 
            // InternalXHDL.g:2507:3: ( RULE_ID )
            // InternalXHDL.g:2508:4: RULE_ID
            {
             before(grammarAccess.getXSubTypeAccess().getXisXTypeRefIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXSubTypeAccess().getXisXTypeRefIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getXSubTypeAccess().getXisXTypeRefCrossReference_4_0()); 

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
    // $ANTLR end "rule__XSubType__XisAssignment_4"


    // $ANTLR start "rule__XSignal__NameAssignment_2"
    // InternalXHDL.g:2519:1: rule__XSignal__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__XSignal__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2523:1: ( ( RULE_ID ) )
            // InternalXHDL.g:2524:2: ( RULE_ID )
            {
            // InternalXHDL.g:2524:2: ( RULE_ID )
            // InternalXHDL.g:2525:3: RULE_ID
            {
             before(grammarAccess.getXSignalAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getNameIDTerminalRuleCall_2_0()); 

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
    // $ANTLR end "rule__XSignal__NameAssignment_2"


    // $ANTLR start "rule__XSignal__XtypeAssignment_4"
    // InternalXHDL.g:2534:1: rule__XSignal__XtypeAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__XSignal__XtypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2538:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2539:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2539:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2540:3: ( RULE_ID )
            {
             before(grammarAccess.getXSignalAccess().getXtypeXTypeRefCrossReference_4_0()); 
            // InternalXHDL.g:2541:3: ( RULE_ID )
            // InternalXHDL.g:2542:4: RULE_ID
            {
             before(grammarAccess.getXSignalAccess().getXtypeXTypeRefIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXSignalAccess().getXtypeXTypeRefIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getXSignalAccess().getXtypeXTypeRefCrossReference_4_0()); 

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
    // $ANTLR end "rule__XSignal__XtypeAssignment_4"


    // $ANTLR start "rule__XType__NameAssignment_0_2"
    // InternalXHDL.g:2553:1: rule__XType__NameAssignment_0_2 : ( RULE_ID ) ;
    public final void rule__XType__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2557:1: ( ( RULE_ID ) )
            // InternalXHDL.g:2558:2: ( RULE_ID )
            {
            // InternalXHDL.g:2558:2: ( RULE_ID )
            // InternalXHDL.g:2559:3: RULE_ID
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


    // $ANTLR start "rule__XType__XenumsAssignment_0_4"
    // InternalXHDL.g:2568:1: rule__XType__XenumsAssignment_0_4 : ( ruleXEnums ) ;
    public final void rule__XType__XenumsAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2572:1: ( ( ruleXEnums ) )
            // InternalXHDL.g:2573:2: ( ruleXEnums )
            {
            // InternalXHDL.g:2573:2: ( ruleXEnums )
            // InternalXHDL.g:2574:3: ruleXEnums
            {
             before(grammarAccess.getXTypeAccess().getXenumsXEnumsParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_2);
            ruleXEnums();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXenumsXEnumsParserRuleCall_0_4_0()); 

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
    // $ANTLR end "rule__XType__XenumsAssignment_0_4"


    // $ANTLR start "rule__XType__XrangeAssignment_1"
    // InternalXHDL.g:2583:1: rule__XType__XrangeAssignment_1 : ( ruleXRange ) ;
    public final void rule__XType__XrangeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2587:1: ( ( ruleXRange ) )
            // InternalXHDL.g:2588:2: ( ruleXRange )
            {
            // InternalXHDL.g:2588:2: ( ruleXRange )
            // InternalXHDL.g:2589:3: ruleXRange
            {
             before(grammarAccess.getXTypeAccess().getXrangeXRangeParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleXRange();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXrangeXRangeParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__XType__XrangeAssignment_1"


    // $ANTLR start "rule__XType__XarrayAssignment_2_0"
    // InternalXHDL.g:2598:1: rule__XType__XarrayAssignment_2_0 : ( ruleXArray ) ;
    public final void rule__XType__XarrayAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2602:1: ( ( ruleXArray ) )
            // InternalXHDL.g:2603:2: ( ruleXArray )
            {
            // InternalXHDL.g:2603:2: ( ruleXArray )
            // InternalXHDL.g:2604:3: ruleXArray
            {
             before(grammarAccess.getXTypeAccess().getXarrayXArrayParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleXArray();

            state._fsp--;

             after(grammarAccess.getXTypeAccess().getXarrayXArrayParserRuleCall_2_0_0()); 

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
    // $ANTLR end "rule__XType__XarrayAssignment_2_0"


    // $ANTLR start "rule__XArray__XrangeAssignment_3"
    // InternalXHDL.g:2613:1: rule__XArray__XrangeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__XArray__XrangeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2617:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2618:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2618:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2619:3: ( RULE_ID )
            {
             before(grammarAccess.getXArrayAccess().getXrangeXTypeRefCrossReference_3_0()); 
            // InternalXHDL.g:2620:3: ( RULE_ID )
            // InternalXHDL.g:2621:4: RULE_ID
            {
             before(grammarAccess.getXArrayAccess().getXrangeXTypeRefIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getXrangeXTypeRefIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getXArrayAccess().getXrangeXTypeRefCrossReference_3_0()); 

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
    // $ANTLR end "rule__XArray__XrangeAssignment_3"


    // $ANTLR start "rule__XArray__XofAssignment_8"
    // InternalXHDL.g:2632:1: rule__XArray__XofAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__XArray__XofAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2636:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2637:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2637:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2638:3: ( RULE_ID )
            {
             before(grammarAccess.getXArrayAccess().getXofXTypeRefCrossReference_8_0()); 
            // InternalXHDL.g:2639:3: ( RULE_ID )
            // InternalXHDL.g:2640:4: RULE_ID
            {
             before(grammarAccess.getXArrayAccess().getXofXTypeRefIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXArrayAccess().getXofXTypeRefIDTerminalRuleCall_8_0_1()); 

            }

             after(grammarAccess.getXArrayAccess().getXofXTypeRefCrossReference_8_0()); 

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
    // $ANTLR end "rule__XArray__XofAssignment_8"


    // $ANTLR start "rule__XRange__XfromAssignment_2"
    // InternalXHDL.g:2651:1: rule__XRange__XfromAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__XRange__XfromAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2655:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2656:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2656:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2657:3: ( RULE_ID )
            {
             before(grammarAccess.getXRangeAccess().getXfromXRangeValueCrossReference_2_0()); 
            // InternalXHDL.g:2658:3: ( RULE_ID )
            // InternalXHDL.g:2659:4: RULE_ID
            {
             before(grammarAccess.getXRangeAccess().getXfromXRangeValueIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXRangeAccess().getXfromXRangeValueIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getXRangeAccess().getXfromXRangeValueCrossReference_2_0()); 

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
    // $ANTLR end "rule__XRange__XfromAssignment_2"


    // $ANTLR start "rule__XRange__XtoAssignment_4"
    // InternalXHDL.g:2670:1: rule__XRange__XtoAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__XRange__XtoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2674:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2675:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2675:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2676:3: ( RULE_ID )
            {
             before(grammarAccess.getXRangeAccess().getXtoXRangeValueCrossReference_4_0()); 
            // InternalXHDL.g:2677:3: ( RULE_ID )
            // InternalXHDL.g:2678:4: RULE_ID
            {
             before(grammarAccess.getXRangeAccess().getXtoXRangeValueIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXRangeAccess().getXtoXRangeValueIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getXRangeAccess().getXtoXRangeValueCrossReference_4_0()); 

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
    // $ANTLR end "rule__XRange__XtoAssignment_4"


    // $ANTLR start "rule__XRange__XunitsAssignment_5"
    // InternalXHDL.g:2689:1: rule__XRange__XunitsAssignment_5 : ( ruleXUnits ) ;
    public final void rule__XRange__XunitsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2693:1: ( ( ruleXUnits ) )
            // InternalXHDL.g:2694:2: ( ruleXUnits )
            {
            // InternalXHDL.g:2694:2: ( ruleXUnits )
            // InternalXHDL.g:2695:3: ruleXUnits
            {
             before(grammarAccess.getXRangeAccess().getXunitsXUnitsParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleXUnits();

            state._fsp--;

             after(grammarAccess.getXRangeAccess().getXunitsXUnitsParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__XRange__XunitsAssignment_5"


    // $ANTLR start "rule__XUnits__XunitsAssignment_2"
    // InternalXHDL.g:2704:1: rule__XUnits__XunitsAssignment_2 : ( ruleXUnit ) ;
    public final void rule__XUnits__XunitsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2708:1: ( ( ruleXUnit ) )
            // InternalXHDL.g:2709:2: ( ruleXUnit )
            {
            // InternalXHDL.g:2709:2: ( ruleXUnit )
            // InternalXHDL.g:2710:3: ruleXUnit
            {
             before(grammarAccess.getXUnitsAccess().getXunitsXUnitParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXUnit();

            state._fsp--;

             after(grammarAccess.getXUnitsAccess().getXunitsXUnitParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__XUnits__XunitsAssignment_2"


    // $ANTLR start "rule__XUnit__NameAssignment_1"
    // InternalXHDL.g:2719:1: rule__XUnit__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__XUnit__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2723:1: ( ( RULE_ID ) )
            // InternalXHDL.g:2724:2: ( RULE_ID )
            {
            // InternalXHDL.g:2724:2: ( RULE_ID )
            // InternalXHDL.g:2725:3: RULE_ID
            {
             before(grammarAccess.getXUnitAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getNameIDTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__XUnit__NameAssignment_1"


    // $ANTLR start "rule__XUnit__XvalueAssignment_2_1"
    // InternalXHDL.g:2734:1: rule__XUnit__XvalueAssignment_2_1 : ( RULE_INT ) ;
    public final void rule__XUnit__XvalueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2738:1: ( ( RULE_INT ) )
            // InternalXHDL.g:2739:2: ( RULE_INT )
            {
            // InternalXHDL.g:2739:2: ( RULE_INT )
            // InternalXHDL.g:2740:3: RULE_INT
            {
             before(grammarAccess.getXUnitAccess().getXvalueINTTerminalRuleCall_2_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getXvalueINTTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__XUnit__XvalueAssignment_2_1"


    // $ANTLR start "rule__XUnit__XbasedAssignment_2_2"
    // InternalXHDL.g:2749:1: rule__XUnit__XbasedAssignment_2_2 : ( ( RULE_ID ) ) ;
    public final void rule__XUnit__XbasedAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2753:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2754:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2754:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2755:3: ( RULE_ID )
            {
             before(grammarAccess.getXUnitAccess().getXbasedXUnitRefCrossReference_2_2_0()); 
            // InternalXHDL.g:2756:3: ( RULE_ID )
            // InternalXHDL.g:2757:4: RULE_ID
            {
             before(grammarAccess.getXUnitAccess().getXbasedXUnitRefIDTerminalRuleCall_2_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXUnitAccess().getXbasedXUnitRefIDTerminalRuleCall_2_2_0_1()); 

            }

             after(grammarAccess.getXUnitAccess().getXbasedXUnitRefCrossReference_2_2_0()); 

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
    // $ANTLR end "rule__XUnit__XbasedAssignment_2_2"


    // $ANTLR start "rule__XEnums__XenumsAssignment_2_1"
    // InternalXHDL.g:2768:1: rule__XEnums__XenumsAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__XEnums__XenumsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2772:1: ( ( RULE_ID ) )
            // InternalXHDL.g:2773:2: ( RULE_ID )
            {
            // InternalXHDL.g:2773:2: ( RULE_ID )
            // InternalXHDL.g:2774:3: RULE_ID
            {
             before(grammarAccess.getXEnumsAccess().getXenumsIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXEnumsAccess().getXenumsIDTerminalRuleCall_2_1_0()); 

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
    // $ANTLR end "rule__XEnums__XenumsAssignment_2_1"


    // $ANTLR start "rule__XImpure__XfuncAssignment_1"
    // InternalXHDL.g:2783:1: rule__XImpure__XfuncAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__XImpure__XfuncAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalXHDL.g:2787:1: ( ( ( RULE_ID ) ) )
            // InternalXHDL.g:2788:2: ( ( RULE_ID ) )
            {
            // InternalXHDL.g:2788:2: ( ( RULE_ID ) )
            // InternalXHDL.g:2789:3: ( RULE_ID )
            {
             before(grammarAccess.getXImpureAccess().getXfuncXFunctionRefCrossReference_1_0()); 
            // InternalXHDL.g:2790:3: ( RULE_ID )
            // InternalXHDL.g:2791:4: RULE_ID
            {
             before(grammarAccess.getXImpureAccess().getXfuncXFunctionRefIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getXImpureAccess().getXfuncXFunctionRefIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getXImpureAccess().getXfuncXFunctionRefCrossReference_1_0()); 

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
    // $ANTLR end "rule__XImpure__XfuncAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000001016D4000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000001016D0002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001600000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000084000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000080000012L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000010L});

}
