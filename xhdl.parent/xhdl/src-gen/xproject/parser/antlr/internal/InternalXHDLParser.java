package xproject.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import xproject.services.XHDLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXHDLParser extends AbstractInternalAntlrParser {
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

        public InternalXHDLParser(TokenStream input, XHDLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "xhdl";
       	}

       	@Override
       	protected XHDLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRulexhdl"
    // InternalXHDL.g:64:1: entryRulexhdl returns [EObject current=null] : iv_rulexhdl= rulexhdl EOF ;
    public final EObject entryRulexhdl() throws RecognitionException {
        EObject current = null;

        EObject iv_rulexhdl = null;


        try {
            // InternalXHDL.g:64:45: (iv_rulexhdl= rulexhdl EOF )
            // InternalXHDL.g:65:2: iv_rulexhdl= rulexhdl EOF
            {
             newCompositeNode(grammarAccess.getXhdlRule()); 
            pushFollow(FOLLOW_1);
            iv_rulexhdl=rulexhdl();

            state._fsp--;

             current =iv_rulexhdl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulexhdl"


    // $ANTLR start "rulexhdl"
    // InternalXHDL.g:71:1: rulexhdl returns [EObject current=null] : ( (lv_packages_0_0= ruleXPackage ) )* ;
    public final EObject rulexhdl() throws RecognitionException {
        EObject current = null;

        EObject lv_packages_0_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:77:2: ( ( (lv_packages_0_0= ruleXPackage ) )* )
            // InternalXHDL.g:78:2: ( (lv_packages_0_0= ruleXPackage ) )*
            {
            // InternalXHDL.g:78:2: ( (lv_packages_0_0= ruleXPackage ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalXHDL.g:79:3: (lv_packages_0_0= ruleXPackage )
            	    {
            	    // InternalXHDL.g:79:3: (lv_packages_0_0= ruleXPackage )
            	    // InternalXHDL.g:80:4: lv_packages_0_0= ruleXPackage
            	    {

            	    				newCompositeNode(grammarAccess.getXhdlAccess().getPackagesXPackageParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_packages_0_0=ruleXPackage();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getXhdlRule());
            	    				}
            	    				add(
            	    					current,
            	    					"packages",
            	    					lv_packages_0_0,
            	    					"xproject.XHDL.XPackage");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulexhdl"


    // $ANTLR start "entryRuleXPackage"
    // InternalXHDL.g:100:1: entryRuleXPackage returns [EObject current=null] : iv_ruleXPackage= ruleXPackage EOF ;
    public final EObject entryRuleXPackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPackage = null;


        try {
            // InternalXHDL.g:100:49: (iv_ruleXPackage= ruleXPackage EOF )
            // InternalXHDL.g:101:2: iv_ruleXPackage= ruleXPackage EOF
            {
             newCompositeNode(grammarAccess.getXPackageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXPackage=ruleXPackage();

            state._fsp--;

             current =iv_ruleXPackage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXPackage"


    // $ANTLR start "ruleXPackage"
    // InternalXHDL.g:107:1: ruleXPackage returns [EObject current=null] : ( () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xis_4_0= ruleXElement ) )* otherlv_5= 'end' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' ) ;
    public final EObject ruleXPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_xis_4_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:113:2: ( ( () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xis_4_0= ruleXElement ) )* otherlv_5= 'end' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' ) )
            // InternalXHDL.g:114:2: ( () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xis_4_0= ruleXElement ) )* otherlv_5= 'end' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' )
            {
            // InternalXHDL.g:114:2: ( () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xis_4_0= ruleXElement ) )* otherlv_5= 'end' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';' )
            // InternalXHDL.g:115:3: () otherlv_1= 'package' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xis_4_0= ruleXElement ) )* otherlv_5= 'end' ( (otherlv_6= RULE_ID ) ) otherlv_7= ';'
            {
            // InternalXHDL.g:115:3: ()
            // InternalXHDL.g:116:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXPackageAccess().getXPackageAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXPackageAccess().getPackageKeyword_1());
            		
            // InternalXHDL.g:126:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXHDL.g:127:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXHDL.g:127:4: (lv_name_2_0= RULE_ID )
            // InternalXHDL.g:128:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXPackageAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXPackageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getXPackageAccess().getIsKeyword_3());
            		
            // InternalXHDL.g:148:3: ( (lv_xis_4_0= ruleXElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16||(LA2_0>=18 && LA2_0<=19)||(LA2_0>=21 && LA2_0<=22)||LA2_0==24||LA2_0==32) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalXHDL.g:149:4: (lv_xis_4_0= ruleXElement )
            	    {
            	    // InternalXHDL.g:149:4: (lv_xis_4_0= ruleXElement )
            	    // InternalXHDL.g:150:5: lv_xis_4_0= ruleXElement
            	    {

            	    					newCompositeNode(grammarAccess.getXPackageAccess().getXisXElementParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_xis_4_0=ruleXElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getXPackageRule());
            	    					}
            	    					add(
            	    						current,
            	    						"xis",
            	    						lv_xis_4_0,
            	    						"xproject.XHDL.XElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getXPackageAccess().getEndKeyword_5());
            		
            // InternalXHDL.g:171:3: ( (otherlv_6= RULE_ID ) )
            // InternalXHDL.g:172:4: (otherlv_6= RULE_ID )
            {
            // InternalXHDL.g:172:4: (otherlv_6= RULE_ID )
            // InternalXHDL.g:173:5: otherlv_6= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXPackageRule());
            					}
            				
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_6, grammarAccess.getXPackageAccess().getXendXPackageRefCrossReference_6_0());
            				

            }


            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getXPackageAccess().getSemicolonKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXPackage"


    // $ANTLR start "entryRuleXElement"
    // InternalXHDL.g:192:1: entryRuleXElement returns [EObject current=null] : iv_ruleXElement= ruleXElement EOF ;
    public final EObject entryRuleXElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXElement = null;


        try {
            // InternalXHDL.g:192:49: (iv_ruleXElement= ruleXElement EOF )
            // InternalXHDL.g:193:2: iv_ruleXElement= ruleXElement EOF
            {
             newCompositeNode(grammarAccess.getXElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXElement=ruleXElement();

            state._fsp--;

             current =iv_ruleXElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXElement"


    // $ANTLR start "ruleXElement"
    // InternalXHDL.g:199:1: ruleXElement returns [EObject current=null] : (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute | this_XImpure_4= ruleXImpure ) ;
    public final EObject ruleXElement() throws RecognitionException {
        EObject current = null;

        EObject this_XType_0 = null;

        EObject this_XSignal_1 = null;

        EObject this_XSubType_2 = null;

        EObject this_XAttribute_3 = null;

        EObject this_XImpure_4 = null;



        	enterRule();

        try {
            // InternalXHDL.g:205:2: ( (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute | this_XImpure_4= ruleXImpure ) )
            // InternalXHDL.g:206:2: (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute | this_XImpure_4= ruleXImpure )
            {
            // InternalXHDL.g:206:2: (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute | this_XImpure_4= ruleXImpure )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 21:
            case 22:
            case 24:
                {
                alt3=1;
                }
                break;
            case 19:
                {
                alt3=2;
                }
                break;
            case 18:
                {
                alt3=3;
                }
                break;
            case 16:
                {
                alt3=4;
                }
                break;
            case 32:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalXHDL.g:207:3: this_XType_0= ruleXType
                    {

                    			newCompositeNode(grammarAccess.getXElementAccess().getXTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_XType_0=ruleXType();

                    state._fsp--;


                    			current = this_XType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalXHDL.g:216:3: this_XSignal_1= ruleXSignal
                    {

                    			newCompositeNode(grammarAccess.getXElementAccess().getXSignalParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_XSignal_1=ruleXSignal();

                    state._fsp--;


                    			current = this_XSignal_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXHDL.g:225:3: this_XSubType_2= ruleXSubType
                    {

                    			newCompositeNode(grammarAccess.getXElementAccess().getXSubTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_XSubType_2=ruleXSubType();

                    state._fsp--;


                    			current = this_XSubType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalXHDL.g:234:3: this_XAttribute_3= ruleXAttribute
                    {

                    			newCompositeNode(grammarAccess.getXElementAccess().getXAttributeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_XAttribute_3=ruleXAttribute();

                    state._fsp--;


                    			current = this_XAttribute_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalXHDL.g:243:3: this_XImpure_4= ruleXImpure
                    {

                    			newCompositeNode(grammarAccess.getXElementAccess().getXImpureParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_XImpure_4=ruleXImpure();

                    state._fsp--;


                    			current = this_XImpure_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXElement"


    // $ANTLR start "entryRuleXAttribute"
    // InternalXHDL.g:255:1: entryRuleXAttribute returns [EObject current=null] : iv_ruleXAttribute= ruleXAttribute EOF ;
    public final EObject entryRuleXAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAttribute = null;


        try {
            // InternalXHDL.g:255:51: (iv_ruleXAttribute= ruleXAttribute EOF )
            // InternalXHDL.g:256:2: iv_ruleXAttribute= ruleXAttribute EOF
            {
             newCompositeNode(grammarAccess.getXAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXAttribute=ruleXAttribute();

            state._fsp--;

             current =iv_ruleXAttribute; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXAttribute"


    // $ANTLR start "ruleXAttribute"
    // InternalXHDL.g:262:1: ruleXAttribute returns [EObject current=null] : ( () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleXAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalXHDL.g:268:2: ( ( () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalXHDL.g:269:2: ( () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalXHDL.g:269:2: ( () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalXHDL.g:270:3: () otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            // InternalXHDL.g:270:3: ()
            // InternalXHDL.g:271:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXAttributeAccess().getXAttributeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXAttributeAccess().getAttributeKeyword_1());
            		
            // InternalXHDL.g:281:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXHDL.g:282:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXHDL.g:282:4: (lv_name_2_0= RULE_ID )
            // InternalXHDL.g:283:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXAttributeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXAttributeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getXAttributeAccess().getColonKeyword_3());
            		
            // InternalXHDL.g:303:3: ( (otherlv_4= RULE_ID ) )
            // InternalXHDL.g:304:4: (otherlv_4= RULE_ID )
            {
            // InternalXHDL.g:304:4: (otherlv_4= RULE_ID )
            // InternalXHDL.g:305:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXAttributeRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_4, grammarAccess.getXAttributeAccess().getXtypeXTypeRefCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getXAttributeAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXAttribute"


    // $ANTLR start "entryRuleXSubType"
    // InternalXHDL.g:324:1: entryRuleXSubType returns [EObject current=null] : iv_ruleXSubType= ruleXSubType EOF ;
    public final EObject entryRuleXSubType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSubType = null;


        try {
            // InternalXHDL.g:324:49: (iv_ruleXSubType= ruleXSubType EOF )
            // InternalXHDL.g:325:2: iv_ruleXSubType= ruleXSubType EOF
            {
             newCompositeNode(grammarAccess.getXSubTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXSubType=ruleXSubType();

            state._fsp--;

             current =iv_ruleXSubType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSubType"


    // $ANTLR start "ruleXSubType"
    // InternalXHDL.g:331:1: ruleXSubType returns [EObject current=null] : ( () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) ;
    public final EObject ruleXSubType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalXHDL.g:337:2: ( ( () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' ) )
            // InternalXHDL.g:338:2: ( () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            {
            // InternalXHDL.g:338:2: ( () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';' )
            // InternalXHDL.g:339:3: () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (otherlv_4= RULE_ID ) ) otherlv_5= ';'
            {
            // InternalXHDL.g:339:3: ()
            // InternalXHDL.g:340:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXSubTypeAccess().getXSubTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXSubTypeAccess().getSubtypeKeyword_1());
            		
            // InternalXHDL.g:350:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXHDL.g:351:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXHDL.g:351:4: (lv_name_2_0= RULE_ID )
            // InternalXHDL.g:352:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXSubTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXSubTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getXSubTypeAccess().getIsKeyword_3());
            		
            // InternalXHDL.g:372:3: ( (otherlv_4= RULE_ID ) )
            // InternalXHDL.g:373:4: (otherlv_4= RULE_ID )
            {
            // InternalXHDL.g:373:4: (otherlv_4= RULE_ID )
            // InternalXHDL.g:374:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXSubTypeRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_4, grammarAccess.getXSubTypeAccess().getXisXTypeRefCrossReference_4_0());
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getXSubTypeAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSubType"


    // $ANTLR start "entryRuleXSignal"
    // InternalXHDL.g:393:1: entryRuleXSignal returns [EObject current=null] : iv_ruleXSignal= ruleXSignal EOF ;
    public final EObject entryRuleXSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSignal = null;


        try {
            // InternalXHDL.g:393:48: (iv_ruleXSignal= ruleXSignal EOF )
            // InternalXHDL.g:394:2: iv_ruleXSignal= ruleXSignal EOF
            {
             newCompositeNode(grammarAccess.getXSignalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXSignal=ruleXSignal();

            state._fsp--;

             current =iv_ruleXSignal; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXSignal"


    // $ANTLR start "ruleXSignal"
    // InternalXHDL.g:400:1: ruleXSignal returns [EObject current=null] : ( () otherlv_1= 'signal' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ';=' this_ID_6= RULE_ID )? otherlv_7= ';' ) ;
    public final EObject ruleXSignal() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_ID_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalXHDL.g:406:2: ( ( () otherlv_1= 'signal' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ';=' this_ID_6= RULE_ID )? otherlv_7= ';' ) )
            // InternalXHDL.g:407:2: ( () otherlv_1= 'signal' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ';=' this_ID_6= RULE_ID )? otherlv_7= ';' )
            {
            // InternalXHDL.g:407:2: ( () otherlv_1= 'signal' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ';=' this_ID_6= RULE_ID )? otherlv_7= ';' )
            // InternalXHDL.g:408:3: () otherlv_1= 'signal' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ';=' this_ID_6= RULE_ID )? otherlv_7= ';'
            {
            // InternalXHDL.g:408:3: ()
            // InternalXHDL.g:409:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXSignalAccess().getXSignalAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXSignalAccess().getSignalKeyword_1());
            		
            // InternalXHDL.g:419:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXHDL.g:420:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXHDL.g:420:4: (lv_name_2_0= RULE_ID )
            // InternalXHDL.g:421:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXSignalAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXSignalRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getXSignalAccess().getColonKeyword_3());
            		
            // InternalXHDL.g:441:3: ( (otherlv_4= RULE_ID ) )
            // InternalXHDL.g:442:4: (otherlv_4= RULE_ID )
            {
            // InternalXHDL.g:442:4: (otherlv_4= RULE_ID )
            // InternalXHDL.g:443:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXSignalRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_9); 

            					newLeafNode(otherlv_4, grammarAccess.getXSignalAccess().getXtypeXTypeRefCrossReference_4_0());
            				

            }


            }

            // InternalXHDL.g:454:3: (otherlv_5= ';=' this_ID_6= RULE_ID )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalXHDL.g:455:4: otherlv_5= ';=' this_ID_6= RULE_ID
                    {
                    otherlv_5=(Token)match(input,20,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getXSignalAccess().getSemicolonEqualsSignKeyword_5_0());
                    			
                    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_7); 

                    				newLeafNode(this_ID_6, grammarAccess.getXSignalAccess().getIDTerminalRuleCall_5_1());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getXSignalAccess().getSemicolonKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXSignal"


    // $ANTLR start "entryRuleXType"
    // InternalXHDL.g:472:1: entryRuleXType returns [EObject current=null] : iv_ruleXType= ruleXType EOF ;
    public final EObject entryRuleXType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXType = null;


        try {
            // InternalXHDL.g:472:46: (iv_ruleXType= ruleXType EOF )
            // InternalXHDL.g:473:2: iv_ruleXType= ruleXType EOF
            {
             newCompositeNode(grammarAccess.getXTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXType=ruleXType();

            state._fsp--;

             current =iv_ruleXType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXType"


    // $ANTLR start "ruleXType"
    // InternalXHDL.g:479:1: ruleXType returns [EObject current=null] : ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xenums_4_0= ruleXEnums ) ) ) | ( (lv_xrange_5_0= ruleXRange ) ) | ( ( (lv_xarray_6_0= ruleXArray ) ) otherlv_7= ';' ) ) ;
    public final EObject ruleXType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_xenums_4_0 = null;

        EObject lv_xrange_5_0 = null;

        EObject lv_xarray_6_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:485:2: ( ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xenums_4_0= ruleXEnums ) ) ) | ( (lv_xrange_5_0= ruleXRange ) ) | ( ( (lv_xarray_6_0= ruleXArray ) ) otherlv_7= ';' ) ) )
            // InternalXHDL.g:486:2: ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xenums_4_0= ruleXEnums ) ) ) | ( (lv_xrange_5_0= ruleXRange ) ) | ( ( (lv_xarray_6_0= ruleXArray ) ) otherlv_7= ';' ) )
            {
            // InternalXHDL.g:486:2: ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xenums_4_0= ruleXEnums ) ) ) | ( (lv_xrange_5_0= ruleXRange ) ) | ( ( (lv_xarray_6_0= ruleXArray ) ) otherlv_7= ';' ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt5=1;
                }
                break;
            case 24:
                {
                alt5=2;
                }
                break;
            case 22:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalXHDL.g:487:3: ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xenums_4_0= ruleXEnums ) ) )
                    {
                    // InternalXHDL.g:487:3: ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xenums_4_0= ruleXEnums ) ) )
                    // InternalXHDL.g:488:4: () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( (lv_xenums_4_0= ruleXEnums ) )
                    {
                    // InternalXHDL.g:488:4: ()
                    // InternalXHDL.g:489:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getXTypeAccess().getXTypeAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,21,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getXTypeAccess().getTypeKeyword_0_1());
                    			
                    // InternalXHDL.g:499:4: ( (lv_name_2_0= RULE_ID ) )
                    // InternalXHDL.g:500:5: (lv_name_2_0= RULE_ID )
                    {
                    // InternalXHDL.g:500:5: (lv_name_2_0= RULE_ID )
                    // InternalXHDL.g:501:6: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

                    						newLeafNode(lv_name_2_0, grammarAccess.getXTypeAccess().getNameIDTerminalRuleCall_0_2_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getXTypeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.eclipse.xtext.common.Terminals.ID");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,13,FOLLOW_10); 

                    				newLeafNode(otherlv_3, grammarAccess.getXTypeAccess().getIsKeyword_0_3());
                    			
                    // InternalXHDL.g:521:4: ( (lv_xenums_4_0= ruleXEnums ) )
                    // InternalXHDL.g:522:5: (lv_xenums_4_0= ruleXEnums )
                    {
                    // InternalXHDL.g:522:5: (lv_xenums_4_0= ruleXEnums )
                    // InternalXHDL.g:523:6: lv_xenums_4_0= ruleXEnums
                    {

                    						newCompositeNode(grammarAccess.getXTypeAccess().getXenumsXEnumsParserRuleCall_0_4_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_xenums_4_0=ruleXEnums();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getXTypeRule());
                    						}
                    						set(
                    							current,
                    							"xenums",
                    							lv_xenums_4_0,
                    							"xproject.XHDL.XEnums");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXHDL.g:542:3: ( (lv_xrange_5_0= ruleXRange ) )
                    {
                    // InternalXHDL.g:542:3: ( (lv_xrange_5_0= ruleXRange ) )
                    // InternalXHDL.g:543:4: (lv_xrange_5_0= ruleXRange )
                    {
                    // InternalXHDL.g:543:4: (lv_xrange_5_0= ruleXRange )
                    // InternalXHDL.g:544:5: lv_xrange_5_0= ruleXRange
                    {

                    					newCompositeNode(grammarAccess.getXTypeAccess().getXrangeXRangeParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_xrange_5_0=ruleXRange();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getXTypeRule());
                    					}
                    					set(
                    						current,
                    						"xrange",
                    						lv_xrange_5_0,
                    						"xproject.XHDL.XRange");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalXHDL.g:562:3: ( ( (lv_xarray_6_0= ruleXArray ) ) otherlv_7= ';' )
                    {
                    // InternalXHDL.g:562:3: ( ( (lv_xarray_6_0= ruleXArray ) ) otherlv_7= ';' )
                    // InternalXHDL.g:563:4: ( (lv_xarray_6_0= ruleXArray ) ) otherlv_7= ';'
                    {
                    // InternalXHDL.g:563:4: ( (lv_xarray_6_0= ruleXArray ) )
                    // InternalXHDL.g:564:5: (lv_xarray_6_0= ruleXArray )
                    {
                    // InternalXHDL.g:564:5: (lv_xarray_6_0= ruleXArray )
                    // InternalXHDL.g:565:6: lv_xarray_6_0= ruleXArray
                    {

                    						newCompositeNode(grammarAccess.getXTypeAccess().getXarrayXArrayParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_xarray_6_0=ruleXArray();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getXTypeRule());
                    						}
                    						set(
                    							current,
                    							"xarray",
                    							lv_xarray_6_0,
                    							"xproject.XHDL.XArray");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,15,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getXTypeAccess().getSemicolonKeyword_2_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXType"


    // $ANTLR start "entryRuleXArray"
    // InternalXHDL.g:591:1: entryRuleXArray returns [EObject current=null] : iv_ruleXArray= ruleXArray EOF ;
    public final EObject entryRuleXArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXArray = null;


        try {
            // InternalXHDL.g:591:47: (iv_ruleXArray= ruleXArray EOF )
            // InternalXHDL.g:592:2: iv_ruleXArray= ruleXArray EOF
            {
             newCompositeNode(grammarAccess.getXArrayRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXArray=ruleXArray();

            state._fsp--;

             current =iv_ruleXArray; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXArray"


    // $ANTLR start "ruleXArray"
    // InternalXHDL.g:598:1: ruleXArray returns [EObject current=null] : ( () otherlv_1= 'array' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' ( (otherlv_8= RULE_ID ) ) ) ;
    public final EObject ruleXArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;


        	enterRule();

        try {
            // InternalXHDL.g:604:2: ( ( () otherlv_1= 'array' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' ( (otherlv_8= RULE_ID ) ) ) )
            // InternalXHDL.g:605:2: ( () otherlv_1= 'array' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' ( (otherlv_8= RULE_ID ) ) )
            {
            // InternalXHDL.g:605:2: ( () otherlv_1= 'array' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' ( (otherlv_8= RULE_ID ) ) )
            // InternalXHDL.g:606:3: () otherlv_1= 'array' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' ( (otherlv_8= RULE_ID ) )
            {
            // InternalXHDL.g:606:3: ()
            // InternalXHDL.g:607:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXArrayAccess().getXArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_10); 

            			newLeafNode(otherlv_1, grammarAccess.getXArrayAccess().getArrayKeyword_1());
            		
            otherlv_2=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getXArrayAccess().getLeftParenthesisKeyword_2());
            		
            // InternalXHDL.g:621:3: ( (otherlv_3= RULE_ID ) )
            // InternalXHDL.g:622:4: (otherlv_3= RULE_ID )
            {
            // InternalXHDL.g:622:4: (otherlv_3= RULE_ID )
            // InternalXHDL.g:623:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXArrayRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_11); 

            					newLeafNode(otherlv_3, grammarAccess.getXArrayAccess().getXrangeXTypeRefCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_12); 

            			newLeafNode(otherlv_4, grammarAccess.getXArrayAccess().getRangeKeyword_4());
            		
            otherlv_5=(Token)match(input,25,FOLLOW_13); 

            			newLeafNode(otherlv_5, grammarAccess.getXArrayAccess().getLessThanSignGreaterThanSignKeyword_5());
            		
            otherlv_6=(Token)match(input,26,FOLLOW_14); 

            			newLeafNode(otherlv_6, grammarAccess.getXArrayAccess().getRightParenthesisKeyword_6());
            		
            otherlv_7=(Token)match(input,27,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getXArrayAccess().getOfKeyword_7());
            		
            // InternalXHDL.g:650:3: ( (otherlv_8= RULE_ID ) )
            // InternalXHDL.g:651:4: (otherlv_8= RULE_ID )
            {
            // InternalXHDL.g:651:4: (otherlv_8= RULE_ID )
            // InternalXHDL.g:652:5: otherlv_8= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXArrayRule());
            					}
            				
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_8, grammarAccess.getXArrayAccess().getXofXTypeRefCrossReference_8_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXArray"


    // $ANTLR start "entryRuleXRange"
    // InternalXHDL.g:667:1: entryRuleXRange returns [EObject current=null] : iv_ruleXRange= ruleXRange EOF ;
    public final EObject entryRuleXRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRange = null;


        try {
            // InternalXHDL.g:667:47: (iv_ruleXRange= ruleXRange EOF )
            // InternalXHDL.g:668:2: iv_ruleXRange= ruleXRange EOF
            {
             newCompositeNode(grammarAccess.getXRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXRange=ruleXRange();

            state._fsp--;

             current =iv_ruleXRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXRange"


    // $ANTLR start "ruleXRange"
    // InternalXHDL.g:674:1: ruleXRange returns [EObject current=null] : ( () otherlv_1= 'range' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'to' ( (otherlv_4= RULE_ID ) ) ( (lv_xunits_5_0= ruleXUnits ) )? ) ;
    public final EObject ruleXRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_xunits_5_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:680:2: ( ( () otherlv_1= 'range' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'to' ( (otherlv_4= RULE_ID ) ) ( (lv_xunits_5_0= ruleXUnits ) )? ) )
            // InternalXHDL.g:681:2: ( () otherlv_1= 'range' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'to' ( (otherlv_4= RULE_ID ) ) ( (lv_xunits_5_0= ruleXUnits ) )? )
            {
            // InternalXHDL.g:681:2: ( () otherlv_1= 'range' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'to' ( (otherlv_4= RULE_ID ) ) ( (lv_xunits_5_0= ruleXUnits ) )? )
            // InternalXHDL.g:682:3: () otherlv_1= 'range' ( (otherlv_2= RULE_ID ) ) otherlv_3= 'to' ( (otherlv_4= RULE_ID ) ) ( (lv_xunits_5_0= ruleXUnits ) )?
            {
            // InternalXHDL.g:682:3: ()
            // InternalXHDL.g:683:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXRangeAccess().getXRangeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXRangeAccess().getRangeKeyword_1());
            		
            // InternalXHDL.g:693:3: ( (otherlv_2= RULE_ID ) )
            // InternalXHDL.g:694:4: (otherlv_2= RULE_ID )
            {
            // InternalXHDL.g:694:4: (otherlv_2= RULE_ID )
            // InternalXHDL.g:695:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXRangeRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(otherlv_2, grammarAccess.getXRangeAccess().getXfromXRangeValueCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getXRangeAccess().getToKeyword_3());
            		
            // InternalXHDL.g:710:3: ( (otherlv_4= RULE_ID ) )
            // InternalXHDL.g:711:4: (otherlv_4= RULE_ID )
            {
            // InternalXHDL.g:711:4: (otherlv_4= RULE_ID )
            // InternalXHDL.g:712:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXRangeRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getXRangeAccess().getXtoXRangeValueCrossReference_4_0());
            				

            }


            }

            // InternalXHDL.g:723:3: ( (lv_xunits_5_0= ruleXUnits ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==29) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalXHDL.g:724:4: (lv_xunits_5_0= ruleXUnits )
                    {
                    // InternalXHDL.g:724:4: (lv_xunits_5_0= ruleXUnits )
                    // InternalXHDL.g:725:5: lv_xunits_5_0= ruleXUnits
                    {

                    					newCompositeNode(grammarAccess.getXRangeAccess().getXunitsXUnitsParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_xunits_5_0=ruleXUnits();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getXRangeRule());
                    					}
                    					set(
                    						current,
                    						"xunits",
                    						lv_xunits_5_0,
                    						"xproject.XHDL.XUnits");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXRange"


    // $ANTLR start "entryRuleXUnits"
    // InternalXHDL.g:746:1: entryRuleXUnits returns [EObject current=null] : iv_ruleXUnits= ruleXUnits EOF ;
    public final EObject entryRuleXUnits() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnits = null;


        try {
            // InternalXHDL.g:746:47: (iv_ruleXUnits= ruleXUnits EOF )
            // InternalXHDL.g:747:2: iv_ruleXUnits= ruleXUnits EOF
            {
             newCompositeNode(grammarAccess.getXUnitsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXUnits=ruleXUnits();

            state._fsp--;

             current =iv_ruleXUnits; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXUnits"


    // $ANTLR start "ruleXUnits"
    // InternalXHDL.g:753:1: ruleXUnits returns [EObject current=null] : ( () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' ) ;
    public final EObject ruleXUnits() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_xunits_2_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:759:2: ( ( () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' ) )
            // InternalXHDL.g:760:2: ( () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' )
            {
            // InternalXHDL.g:760:2: ( () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' )
            // InternalXHDL.g:761:3: () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units'
            {
            // InternalXHDL.g:761:3: ()
            // InternalXHDL.g:762:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXUnitsAccess().getXUnitsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,29,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getXUnitsAccess().getUnitsKeyword_1());
            		
            // InternalXHDL.g:772:3: ( (lv_xunits_2_0= ruleXUnit ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXHDL.g:773:4: (lv_xunits_2_0= ruleXUnit )
            	    {
            	    // InternalXHDL.g:773:4: (lv_xunits_2_0= ruleXUnit )
            	    // InternalXHDL.g:774:5: lv_xunits_2_0= ruleXUnit
            	    {

            	    					newCompositeNode(grammarAccess.getXUnitsAccess().getXunitsXUnitParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_xunits_2_0=ruleXUnit();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getXUnitsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"xunits",
            	    						lv_xunits_2_0,
            	    						"xproject.XHDL.XUnit");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_3=(Token)match(input,14,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getXUnitsAccess().getEndKeyword_3());
            		
            otherlv_4=(Token)match(input,29,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getXUnitsAccess().getUnitsKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXUnits"


    // $ANTLR start "entryRuleXUnit"
    // InternalXHDL.g:803:1: entryRuleXUnit returns [EObject current=null] : iv_ruleXUnit= ruleXUnit EOF ;
    public final EObject entryRuleXUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnit = null;


        try {
            // InternalXHDL.g:803:46: (iv_ruleXUnit= ruleXUnit EOF )
            // InternalXHDL.g:804:2: iv_ruleXUnit= ruleXUnit EOF
            {
             newCompositeNode(grammarAccess.getXUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXUnit=ruleXUnit();

            state._fsp--;

             current =iv_ruleXUnit; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXUnit"


    // $ANTLR start "ruleXUnit"
    // InternalXHDL.g:810:1: ruleXUnit returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_xvalue_3_0= RULE_INT ) ) ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';' ) ;
    public final EObject ruleXUnit() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_xvalue_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalXHDL.g:816:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_xvalue_3_0= RULE_INT ) ) ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';' ) )
            // InternalXHDL.g:817:2: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_xvalue_3_0= RULE_INT ) ) ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';' )
            {
            // InternalXHDL.g:817:2: ( () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_xvalue_3_0= RULE_INT ) ) ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';' )
            // InternalXHDL.g:818:3: () ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '=' ( (lv_xvalue_3_0= RULE_INT ) ) ( (otherlv_4= RULE_ID ) ) )? otherlv_5= ';'
            {
            // InternalXHDL.g:818:3: ()
            // InternalXHDL.g:819:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXUnitAccess().getXUnitAction_0(),
            					current);
            			

            }

            // InternalXHDL.g:825:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXHDL.g:826:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXHDL.g:826:4: (lv_name_1_0= RULE_ID )
            // InternalXHDL.g:827:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(lv_name_1_0, grammarAccess.getXUnitAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXUnitRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalXHDL.g:843:3: (otherlv_2= '=' ( (lv_xvalue_3_0= RULE_INT ) ) ( (otherlv_4= RULE_ID ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==30) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalXHDL.g:844:4: otherlv_2= '=' ( (lv_xvalue_3_0= RULE_INT ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_20); 

                    				newLeafNode(otherlv_2, grammarAccess.getXUnitAccess().getEqualsSignKeyword_2_0());
                    			
                    // InternalXHDL.g:848:4: ( (lv_xvalue_3_0= RULE_INT ) )
                    // InternalXHDL.g:849:5: (lv_xvalue_3_0= RULE_INT )
                    {
                    // InternalXHDL.g:849:5: (lv_xvalue_3_0= RULE_INT )
                    // InternalXHDL.g:850:6: lv_xvalue_3_0= RULE_INT
                    {
                    lv_xvalue_3_0=(Token)match(input,RULE_INT,FOLLOW_4); 

                    						newLeafNode(lv_xvalue_3_0, grammarAccess.getXUnitAccess().getXvalueINTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getXUnitRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"xvalue",
                    							lv_xvalue_3_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalXHDL.g:866:4: ( (otherlv_4= RULE_ID ) )
                    // InternalXHDL.g:867:5: (otherlv_4= RULE_ID )
                    {
                    // InternalXHDL.g:867:5: (otherlv_4= RULE_ID )
                    // InternalXHDL.g:868:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getXUnitRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_7); 

                    						newLeafNode(otherlv_4, grammarAccess.getXUnitAccess().getXbasedXUnitRefCrossReference_2_2_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getXUnitAccess().getSemicolonKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXUnit"


    // $ANTLR start "entryRuleXEnums"
    // InternalXHDL.g:888:1: entryRuleXEnums returns [EObject current=null] : iv_ruleXEnums= ruleXEnums EOF ;
    public final EObject entryRuleXEnums() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEnums = null;


        try {
            // InternalXHDL.g:888:47: (iv_ruleXEnums= ruleXEnums EOF )
            // InternalXHDL.g:889:2: iv_ruleXEnums= ruleXEnums EOF
            {
             newCompositeNode(grammarAccess.getXEnumsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXEnums=ruleXEnums();

            state._fsp--;

             current =iv_ruleXEnums; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXEnums"


    // $ANTLR start "ruleXEnums"
    // InternalXHDL.g:895:1: ruleXEnums returns [EObject current=null] : ( () otherlv_1= '(' ( (otherlv_2= ',' )? ( (lv_xenums_3_0= RULE_ID ) ) )* otherlv_4= ')' ) ;
    public final EObject ruleXEnums() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_xenums_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalXHDL.g:901:2: ( ( () otherlv_1= '(' ( (otherlv_2= ',' )? ( (lv_xenums_3_0= RULE_ID ) ) )* otherlv_4= ')' ) )
            // InternalXHDL.g:902:2: ( () otherlv_1= '(' ( (otherlv_2= ',' )? ( (lv_xenums_3_0= RULE_ID ) ) )* otherlv_4= ')' )
            {
            // InternalXHDL.g:902:2: ( () otherlv_1= '(' ( (otherlv_2= ',' )? ( (lv_xenums_3_0= RULE_ID ) ) )* otherlv_4= ')' )
            // InternalXHDL.g:903:3: () otherlv_1= '(' ( (otherlv_2= ',' )? ( (lv_xenums_3_0= RULE_ID ) ) )* otherlv_4= ')'
            {
            // InternalXHDL.g:903:3: ()
            // InternalXHDL.g:904:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXEnumsAccess().getXEnumsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getXEnumsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalXHDL.g:914:3: ( (otherlv_2= ',' )? ( (lv_xenums_3_0= RULE_ID ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||LA10_0==31) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalXHDL.g:915:4: (otherlv_2= ',' )? ( (lv_xenums_3_0= RULE_ID ) )
            	    {
            	    // InternalXHDL.g:915:4: (otherlv_2= ',' )?
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==31) ) {
            	        alt9=1;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // InternalXHDL.g:916:5: otherlv_2= ','
            	            {
            	            otherlv_2=(Token)match(input,31,FOLLOW_4); 

            	            					newLeafNode(otherlv_2, grammarAccess.getXEnumsAccess().getCommaKeyword_2_0());
            	            				

            	            }
            	            break;

            	    }

            	    // InternalXHDL.g:921:4: ( (lv_xenums_3_0= RULE_ID ) )
            	    // InternalXHDL.g:922:5: (lv_xenums_3_0= RULE_ID )
            	    {
            	    // InternalXHDL.g:922:5: (lv_xenums_3_0= RULE_ID )
            	    // InternalXHDL.g:923:6: lv_xenums_3_0= RULE_ID
            	    {
            	    lv_xenums_3_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            	    						newLeafNode(lv_xenums_3_0, grammarAccess.getXEnumsAccess().getXenumsIDTerminalRuleCall_2_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getXEnumsRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"xenums",
            	    							lv_xenums_3_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_4=(Token)match(input,26,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getXEnumsAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXEnums"


    // $ANTLR start "entryRuleXImpure"
    // InternalXHDL.g:948:1: entryRuleXImpure returns [EObject current=null] : iv_ruleXImpure= ruleXImpure EOF ;
    public final EObject entryRuleXImpure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImpure = null;


        try {
            // InternalXHDL.g:948:48: (iv_ruleXImpure= ruleXImpure EOF )
            // InternalXHDL.g:949:2: iv_ruleXImpure= ruleXImpure EOF
            {
             newCompositeNode(grammarAccess.getXImpureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXImpure=ruleXImpure();

            state._fsp--;

             current =iv_ruleXImpure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXImpure"


    // $ANTLR start "ruleXImpure"
    // InternalXHDL.g:955:1: ruleXImpure returns [EObject current=null] : (otherlv_0= 'impure' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleXImpure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalXHDL.g:961:2: ( (otherlv_0= 'impure' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalXHDL.g:962:2: (otherlv_0= 'impure' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalXHDL.g:962:2: (otherlv_0= 'impure' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';' )
            // InternalXHDL.g:963:3: otherlv_0= 'impure' ( (otherlv_1= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getXImpureAccess().getImpureKeyword_0());
            		
            // InternalXHDL.g:967:3: ( (otherlv_1= RULE_ID ) )
            // InternalXHDL.g:968:4: (otherlv_1= RULE_ID )
            {
            // InternalXHDL.g:968:4: (otherlv_1= RULE_ID )
            // InternalXHDL.g:969:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXImpureRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(otherlv_1, grammarAccess.getXImpureAccess().getXfuncXFunctionRefCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getXImpureAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXImpure"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000001016D4000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000084000010L});

}
