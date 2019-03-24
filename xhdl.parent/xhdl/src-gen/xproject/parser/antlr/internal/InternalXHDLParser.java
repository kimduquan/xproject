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

                if ( (LA1_0==11) ) {
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
    // InternalXHDL.g:107:1: ruleXPackage returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_elements_3_0= ruleXElement ) )* otherlv_4= 'end' this_ID_5= RULE_ID otherlv_6= ';' ) ;
    public final EObject ruleXPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token this_ID_5=null;
        Token otherlv_6=null;
        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:113:2: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_elements_3_0= ruleXElement ) )* otherlv_4= 'end' this_ID_5= RULE_ID otherlv_6= ';' ) )
            // InternalXHDL.g:114:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_elements_3_0= ruleXElement ) )* otherlv_4= 'end' this_ID_5= RULE_ID otherlv_6= ';' )
            {
            // InternalXHDL.g:114:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_elements_3_0= ruleXElement ) )* otherlv_4= 'end' this_ID_5= RULE_ID otherlv_6= ';' )
            // InternalXHDL.g:115:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_elements_3_0= ruleXElement ) )* otherlv_4= 'end' this_ID_5= RULE_ID otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getXPackageAccess().getPackageKeyword_0());
            		
            // InternalXHDL.g:119:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXHDL.g:120:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXHDL.g:120:4: (lv_name_1_0= RULE_ID )
            // InternalXHDL.g:121:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getXPackageAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXPackageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getXPackageAccess().getIsKeyword_2());
            		
            // InternalXHDL.g:141:3: ( (lv_elements_3_0= ruleXElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15||(LA2_0>=17 && LA2_0<=20)||LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalXHDL.g:142:4: (lv_elements_3_0= ruleXElement )
            	    {
            	    // InternalXHDL.g:142:4: (lv_elements_3_0= ruleXElement )
            	    // InternalXHDL.g:143:5: lv_elements_3_0= ruleXElement
            	    {

            	    					newCompositeNode(grammarAccess.getXPackageAccess().getElementsXElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_elements_3_0=ruleXElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getXPackageRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_3_0,
            	    						"xproject.XHDL.XElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getXPackageAccess().getEndKeyword_4());
            		
            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_7); 

            			newLeafNode(this_ID_5, grammarAccess.getXPackageAccess().getIDTerminalRuleCall_5());
            		
            otherlv_6=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getXPackageAccess().getSemicolonKeyword_6());
            		

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
    // InternalXHDL.g:176:1: entryRuleXElement returns [EObject current=null] : iv_ruleXElement= ruleXElement EOF ;
    public final EObject entryRuleXElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXElement = null;


        try {
            // InternalXHDL.g:176:49: (iv_ruleXElement= ruleXElement EOF )
            // InternalXHDL.g:177:2: iv_ruleXElement= ruleXElement EOF
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
    // InternalXHDL.g:183:1: ruleXElement returns [EObject current=null] : (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute ) ;
    public final EObject ruleXElement() throws RecognitionException {
        EObject current = null;

        EObject this_XType_0 = null;

        EObject this_XSignal_1 = null;

        EObject this_XSubType_2 = null;

        EObject this_XAttribute_3 = null;



        	enterRule();

        try {
            // InternalXHDL.g:189:2: ( (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute ) )
            // InternalXHDL.g:190:2: (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute )
            {
            // InternalXHDL.g:190:2: (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 19:
            case 20:
            case 22:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 17:
                {
                alt3=3;
                }
                break;
            case 15:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalXHDL.g:191:3: this_XType_0= ruleXType
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
                    // InternalXHDL.g:200:3: this_XSignal_1= ruleXSignal
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
                    // InternalXHDL.g:209:3: this_XSubType_2= ruleXSubType
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
                    // InternalXHDL.g:218:3: this_XAttribute_3= ruleXAttribute
                    {

                    			newCompositeNode(grammarAccess.getXElementAccess().getXAttributeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_XAttribute_3=ruleXAttribute();

                    state._fsp--;


                    			current = this_XAttribute_3;
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
    // InternalXHDL.g:230:1: entryRuleXAttribute returns [EObject current=null] : iv_ruleXAttribute= ruleXAttribute EOF ;
    public final EObject entryRuleXAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAttribute = null;


        try {
            // InternalXHDL.g:230:51: (iv_ruleXAttribute= ruleXAttribute EOF )
            // InternalXHDL.g:231:2: iv_ruleXAttribute= ruleXAttribute EOF
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
    // InternalXHDL.g:237:1: ruleXAttribute returns [EObject current=null] : ( () otherlv_1= 'attribute' this_ID_2= RULE_ID otherlv_3= ':' this_ID_4= RULE_ID otherlv_5= ';' ) ;
    public final EObject ruleXAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_3=null;
        Token this_ID_4=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalXHDL.g:243:2: ( ( () otherlv_1= 'attribute' this_ID_2= RULE_ID otherlv_3= ':' this_ID_4= RULE_ID otherlv_5= ';' ) )
            // InternalXHDL.g:244:2: ( () otherlv_1= 'attribute' this_ID_2= RULE_ID otherlv_3= ':' this_ID_4= RULE_ID otherlv_5= ';' )
            {
            // InternalXHDL.g:244:2: ( () otherlv_1= 'attribute' this_ID_2= RULE_ID otherlv_3= ':' this_ID_4= RULE_ID otherlv_5= ';' )
            // InternalXHDL.g:245:3: () otherlv_1= 'attribute' this_ID_2= RULE_ID otherlv_3= ':' this_ID_4= RULE_ID otherlv_5= ';'
            {
            // InternalXHDL.g:245:3: ()
            // InternalXHDL.g:246:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXAttributeAccess().getAttributeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,15,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXAttributeAccess().getAttributeKeyword_1());
            		
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(this_ID_2, grammarAccess.getXAttributeAccess().getIDTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getXAttributeAccess().getColonKeyword_3());
            		
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_7); 

            			newLeafNode(this_ID_4, grammarAccess.getXAttributeAccess().getIDTerminalRuleCall_4());
            		
            otherlv_5=(Token)match(input,14,FOLLOW_2); 

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
    // InternalXHDL.g:276:1: entryRuleXSubType returns [EObject current=null] : iv_ruleXSubType= ruleXSubType EOF ;
    public final EObject entryRuleXSubType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSubType = null;


        try {
            // InternalXHDL.g:276:49: (iv_ruleXSubType= ruleXSubType EOF )
            // InternalXHDL.g:277:2: iv_ruleXSubType= ruleXSubType EOF
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
    // InternalXHDL.g:283:1: ruleXSubType returns [EObject current=null] : ( () otherlv_1= 'subtype' this_ID_2= RULE_ID otherlv_3= ';' ) ;
    public final EObject ruleXSubType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalXHDL.g:289:2: ( ( () otherlv_1= 'subtype' this_ID_2= RULE_ID otherlv_3= ';' ) )
            // InternalXHDL.g:290:2: ( () otherlv_1= 'subtype' this_ID_2= RULE_ID otherlv_3= ';' )
            {
            // InternalXHDL.g:290:2: ( () otherlv_1= 'subtype' this_ID_2= RULE_ID otherlv_3= ';' )
            // InternalXHDL.g:291:3: () otherlv_1= 'subtype' this_ID_2= RULE_ID otherlv_3= ';'
            {
            // InternalXHDL.g:291:3: ()
            // InternalXHDL.g:292:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXSubTypeAccess().getSubtypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXSubTypeAccess().getSubtypeKeyword_1());
            		
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_7); 

            			newLeafNode(this_ID_2, grammarAccess.getXSubTypeAccess().getIDTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getXSubTypeAccess().getSemicolonKeyword_3());
            		

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
    // InternalXHDL.g:314:1: entryRuleXSignal returns [EObject current=null] : iv_ruleXSignal= ruleXSignal EOF ;
    public final EObject entryRuleXSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSignal = null;


        try {
            // InternalXHDL.g:314:48: (iv_ruleXSignal= ruleXSignal EOF )
            // InternalXHDL.g:315:2: iv_ruleXSignal= ruleXSignal EOF
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
    // InternalXHDL.g:321:1: ruleXSignal returns [EObject current=null] : ( () otherlv_1= 'signal' this_ID_2= RULE_ID otherlv_3= ';' ) ;
    public final EObject ruleXSignal() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_ID_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalXHDL.g:327:2: ( ( () otherlv_1= 'signal' this_ID_2= RULE_ID otherlv_3= ';' ) )
            // InternalXHDL.g:328:2: ( () otherlv_1= 'signal' this_ID_2= RULE_ID otherlv_3= ';' )
            {
            // InternalXHDL.g:328:2: ( () otherlv_1= 'signal' this_ID_2= RULE_ID otherlv_3= ';' )
            // InternalXHDL.g:329:3: () otherlv_1= 'signal' this_ID_2= RULE_ID otherlv_3= ';'
            {
            // InternalXHDL.g:329:3: ()
            // InternalXHDL.g:330:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXSignalAccess().getSignalAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXSignalAccess().getSignalKeyword_1());
            		
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_7); 

            			newLeafNode(this_ID_2, grammarAccess.getXSignalAccess().getIDTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getXSignalAccess().getSemicolonKeyword_3());
            		

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
    // InternalXHDL.g:352:1: entryRuleXType returns [EObject current=null] : iv_ruleXType= ruleXType EOF ;
    public final EObject entryRuleXType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXType = null;


        try {
            // InternalXHDL.g:352:46: (iv_ruleXType= ruleXType EOF )
            // InternalXHDL.g:353:2: iv_ruleXType= ruleXType EOF
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
    // InternalXHDL.g:359:1: ruleXType returns [EObject current=null] : ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ruleXEnums ) | this_XRange_5= ruleXRange | (this_XArray_6= ruleXArray otherlv_7= ';' ) ) ;
    public final EObject ruleXType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject this_XRange_5 = null;

        EObject this_XArray_6 = null;



        	enterRule();

        try {
            // InternalXHDL.g:365:2: ( ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ruleXEnums ) | this_XRange_5= ruleXRange | (this_XArray_6= ruleXArray otherlv_7= ';' ) ) )
            // InternalXHDL.g:366:2: ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ruleXEnums ) | this_XRange_5= ruleXRange | (this_XArray_6= ruleXArray otherlv_7= ';' ) )
            {
            // InternalXHDL.g:366:2: ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ruleXEnums ) | this_XRange_5= ruleXRange | (this_XArray_6= ruleXArray otherlv_7= ';' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt4=1;
                }
                break;
            case 22:
                {
                alt4=2;
                }
                break;
            case 20:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalXHDL.g:367:3: ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ruleXEnums )
                    {
                    // InternalXHDL.g:367:3: ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ruleXEnums )
                    // InternalXHDL.g:368:4: () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ruleXEnums
                    {
                    // InternalXHDL.g:368:4: ()
                    // InternalXHDL.g:369:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getXTypeAccess().getTypeAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,19,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getXTypeAccess().getTypeKeyword_0_1());
                    			
                    // InternalXHDL.g:379:4: ( (lv_name_2_0= RULE_ID ) )
                    // InternalXHDL.g:380:5: (lv_name_2_0= RULE_ID )
                    {
                    // InternalXHDL.g:380:5: (lv_name_2_0= RULE_ID )
                    // InternalXHDL.g:381:6: lv_name_2_0= RULE_ID
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

                    otherlv_3=(Token)match(input,12,FOLLOW_9); 

                    				newLeafNode(otherlv_3, grammarAccess.getXTypeAccess().getIsKeyword_0_3());
                    			

                    				newCompositeNode(grammarAccess.getXTypeAccess().getXEnumsParserRuleCall_0_4());
                    			
                    pushFollow(FOLLOW_2);
                    ruleXEnums();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalXHDL.g:410:3: this_XRange_5= ruleXRange
                    {

                    			newCompositeNode(grammarAccess.getXTypeAccess().getXRangeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_XRange_5=ruleXRange();

                    state._fsp--;


                    			current = this_XRange_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalXHDL.g:419:3: (this_XArray_6= ruleXArray otherlv_7= ';' )
                    {
                    // InternalXHDL.g:419:3: (this_XArray_6= ruleXArray otherlv_7= ';' )
                    // InternalXHDL.g:420:4: this_XArray_6= ruleXArray otherlv_7= ';'
                    {

                    				newCompositeNode(grammarAccess.getXTypeAccess().getXArrayParserRuleCall_2_0());
                    			
                    pushFollow(FOLLOW_7);
                    this_XArray_6=ruleXArray();

                    state._fsp--;


                    				current = this_XArray_6;
                    				afterParserOrEnumRuleCall();
                    			
                    otherlv_7=(Token)match(input,14,FOLLOW_2); 

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
    // InternalXHDL.g:437:1: entryRuleXArray returns [EObject current=null] : iv_ruleXArray= ruleXArray EOF ;
    public final EObject entryRuleXArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXArray = null;


        try {
            // InternalXHDL.g:437:47: (iv_ruleXArray= ruleXArray EOF )
            // InternalXHDL.g:438:2: iv_ruleXArray= ruleXArray EOF
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
    // InternalXHDL.g:444:1: ruleXArray returns [EObject current=null] : ( () otherlv_1= 'array' otherlv_2= '(' this_ID_3= RULE_ID otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' this_ID_8= RULE_ID ) ;
    public final EObject ruleXArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_ID_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token this_ID_8=null;


        	enterRule();

        try {
            // InternalXHDL.g:450:2: ( ( () otherlv_1= 'array' otherlv_2= '(' this_ID_3= RULE_ID otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' this_ID_8= RULE_ID ) )
            // InternalXHDL.g:451:2: ( () otherlv_1= 'array' otherlv_2= '(' this_ID_3= RULE_ID otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' this_ID_8= RULE_ID )
            {
            // InternalXHDL.g:451:2: ( () otherlv_1= 'array' otherlv_2= '(' this_ID_3= RULE_ID otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' this_ID_8= RULE_ID )
            // InternalXHDL.g:452:3: () otherlv_1= 'array' otherlv_2= '(' this_ID_3= RULE_ID otherlv_4= 'range' otherlv_5= '<>' otherlv_6= ')' otherlv_7= 'of' this_ID_8= RULE_ID
            {
            // InternalXHDL.g:452:3: ()
            // InternalXHDL.g:453:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXArrayAccess().getArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getXArrayAccess().getArrayKeyword_1());
            		
            otherlv_2=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getXArrayAccess().getLeftParenthesisKeyword_2());
            		
            this_ID_3=(Token)match(input,RULE_ID,FOLLOW_10); 

            			newLeafNode(this_ID_3, grammarAccess.getXArrayAccess().getIDTerminalRuleCall_3());
            		
            otherlv_4=(Token)match(input,22,FOLLOW_11); 

            			newLeafNode(otherlv_4, grammarAccess.getXArrayAccess().getRangeKeyword_4());
            		
            otherlv_5=(Token)match(input,23,FOLLOW_12); 

            			newLeafNode(otherlv_5, grammarAccess.getXArrayAccess().getLessThanSignGreaterThanSignKeyword_5());
            		
            otherlv_6=(Token)match(input,24,FOLLOW_13); 

            			newLeafNode(otherlv_6, grammarAccess.getXArrayAccess().getRightParenthesisKeyword_6());
            		
            otherlv_7=(Token)match(input,25,FOLLOW_4); 

            			newLeafNode(otherlv_7, grammarAccess.getXArrayAccess().getOfKeyword_7());
            		
            this_ID_8=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(this_ID_8, grammarAccess.getXArrayAccess().getIDTerminalRuleCall_8());
            		

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
    // InternalXHDL.g:495:1: entryRuleXRange returns [EObject current=null] : iv_ruleXRange= ruleXRange EOF ;
    public final EObject entryRuleXRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRange = null;


        try {
            // InternalXHDL.g:495:47: (iv_ruleXRange= ruleXRange EOF )
            // InternalXHDL.g:496:2: iv_ruleXRange= ruleXRange EOF
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
    // InternalXHDL.g:502:1: ruleXRange returns [EObject current=null] : ( () otherlv_1= 'range' this_INT_2= RULE_INT otherlv_3= 'to' this_INT_4= RULE_INT (this_XUnits_5= ruleXUnits )? ) ;
    public final EObject ruleXRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_INT_2=null;
        Token otherlv_3=null;
        Token this_INT_4=null;
        EObject this_XUnits_5 = null;



        	enterRule();

        try {
            // InternalXHDL.g:508:2: ( ( () otherlv_1= 'range' this_INT_2= RULE_INT otherlv_3= 'to' this_INT_4= RULE_INT (this_XUnits_5= ruleXUnits )? ) )
            // InternalXHDL.g:509:2: ( () otherlv_1= 'range' this_INT_2= RULE_INT otherlv_3= 'to' this_INT_4= RULE_INT (this_XUnits_5= ruleXUnits )? )
            {
            // InternalXHDL.g:509:2: ( () otherlv_1= 'range' this_INT_2= RULE_INT otherlv_3= 'to' this_INT_4= RULE_INT (this_XUnits_5= ruleXUnits )? )
            // InternalXHDL.g:510:3: () otherlv_1= 'range' this_INT_2= RULE_INT otherlv_3= 'to' this_INT_4= RULE_INT (this_XUnits_5= ruleXUnits )?
            {
            // InternalXHDL.g:510:3: ()
            // InternalXHDL.g:511:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXRangeAccess().getRangeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_14); 

            			newLeafNode(otherlv_1, grammarAccess.getXRangeAccess().getRangeKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_15); 

            			newLeafNode(this_INT_2, grammarAccess.getXRangeAccess().getINTTerminalRuleCall_2());
            		
            otherlv_3=(Token)match(input,26,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getXRangeAccess().getToKeyword_3());
            		
            this_INT_4=(Token)match(input,RULE_INT,FOLLOW_16); 

            			newLeafNode(this_INT_4, grammarAccess.getXRangeAccess().getINTTerminalRuleCall_4());
            		
            // InternalXHDL.g:533:3: (this_XUnits_5= ruleXUnits )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==27) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalXHDL.g:534:4: this_XUnits_5= ruleXUnits
                    {

                    				newCompositeNode(grammarAccess.getXRangeAccess().getXUnitsParserRuleCall_5());
                    			
                    pushFollow(FOLLOW_2);
                    this_XUnits_5=ruleXUnits();

                    state._fsp--;


                    				current = this_XUnits_5;
                    				afterParserOrEnumRuleCall();
                    			

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
    // InternalXHDL.g:547:1: entryRuleXUnits returns [EObject current=null] : iv_ruleXUnits= ruleXUnits EOF ;
    public final EObject entryRuleXUnits() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnits = null;


        try {
            // InternalXHDL.g:547:47: (iv_ruleXUnits= ruleXUnits EOF )
            // InternalXHDL.g:548:2: iv_ruleXUnits= ruleXUnits EOF
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
    // InternalXHDL.g:554:1: ruleXUnits returns [EObject current=null] : ( () otherlv_1= 'units' ( (lv_units_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' ) ;
    public final EObject ruleXUnits() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_units_2_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:560:2: ( ( () otherlv_1= 'units' ( (lv_units_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' ) )
            // InternalXHDL.g:561:2: ( () otherlv_1= 'units' ( (lv_units_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' )
            {
            // InternalXHDL.g:561:2: ( () otherlv_1= 'units' ( (lv_units_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' )
            // InternalXHDL.g:562:3: () otherlv_1= 'units' ( (lv_units_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units'
            {
            // InternalXHDL.g:562:3: ()
            // InternalXHDL.g:563:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXUnitsAccess().getUnitsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,27,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getXUnitsAccess().getUnitsKeyword_1());
            		
            // InternalXHDL.g:573:3: ( (lv_units_2_0= ruleXUnit ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalXHDL.g:574:4: (lv_units_2_0= ruleXUnit )
            	    {
            	    // InternalXHDL.g:574:4: (lv_units_2_0= ruleXUnit )
            	    // InternalXHDL.g:575:5: lv_units_2_0= ruleXUnit
            	    {

            	    					newCompositeNode(grammarAccess.getXUnitsAccess().getUnitsXUnitParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_17);
            	    lv_units_2_0=ruleXUnit();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getXUnitsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"units",
            	    						lv_units_2_0,
            	    						"xproject.XHDL.XUnit");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_3=(Token)match(input,13,FOLLOW_18); 

            			newLeafNode(otherlv_3, grammarAccess.getXUnitsAccess().getEndKeyword_3());
            		
            otherlv_4=(Token)match(input,27,FOLLOW_2); 

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
    // InternalXHDL.g:604:1: entryRuleXUnit returns [String current=null] : iv_ruleXUnit= ruleXUnit EOF ;
    public final String entryRuleXUnit() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXUnit = null;


        try {
            // InternalXHDL.g:604:45: (iv_ruleXUnit= ruleXUnit EOF )
            // InternalXHDL.g:605:2: iv_ruleXUnit= ruleXUnit EOF
            {
             newCompositeNode(grammarAccess.getXUnitRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXUnit=ruleXUnit();

            state._fsp--;

             current =iv_ruleXUnit.getText(); 
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
    // InternalXHDL.g:611:1: ruleXUnit returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '=' this_INT_2= RULE_INT this_ID_3= RULE_ID kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleXUnit() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_3=null;


        	enterRule();

        try {
            // InternalXHDL.g:617:2: ( (this_ID_0= RULE_ID kw= '=' this_INT_2= RULE_INT this_ID_3= RULE_ID kw= ';' ) )
            // InternalXHDL.g:618:2: (this_ID_0= RULE_ID kw= '=' this_INT_2= RULE_INT this_ID_3= RULE_ID kw= ';' )
            {
            // InternalXHDL.g:618:2: (this_ID_0= RULE_ID kw= '=' this_INT_2= RULE_INT this_ID_3= RULE_ID kw= ';' )
            // InternalXHDL.g:619:3: this_ID_0= RULE_ID kw= '=' this_INT_2= RULE_INT this_ID_3= RULE_ID kw= ';'
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_19); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getXUnitAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,28,FOLLOW_14); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getXUnitAccess().getEqualsSignKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_4); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getXUnitAccess().getINTTerminalRuleCall_2());
            		
            this_ID_3=(Token)match(input,RULE_ID,FOLLOW_7); 

            			current.merge(this_ID_3);
            		

            			newLeafNode(this_ID_3, grammarAccess.getXUnitAccess().getIDTerminalRuleCall_3());
            		
            kw=(Token)match(input,14,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getXUnitAccess().getSemicolonKeyword_4());
            		

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
    // InternalXHDL.g:654:1: entryRuleXEnums returns [String current=null] : iv_ruleXEnums= ruleXEnums EOF ;
    public final String entryRuleXEnums() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXEnums = null;


        try {
            // InternalXHDL.g:654:46: (iv_ruleXEnums= ruleXEnums EOF )
            // InternalXHDL.g:655:2: iv_ruleXEnums= ruleXEnums EOF
            {
             newCompositeNode(grammarAccess.getXEnumsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXEnums=ruleXEnums();

            state._fsp--;

             current =iv_ruleXEnums.getText(); 
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
    // InternalXHDL.g:661:1: ruleXEnums returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '(' ( (kw= ',' )? this_ID_2= RULE_ID )* kw= ')' ) ;
    public final AntlrDatatypeRuleToken ruleXEnums() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalXHDL.g:667:2: ( (kw= '(' ( (kw= ',' )? this_ID_2= RULE_ID )* kw= ')' ) )
            // InternalXHDL.g:668:2: (kw= '(' ( (kw= ',' )? this_ID_2= RULE_ID )* kw= ')' )
            {
            // InternalXHDL.g:668:2: (kw= '(' ( (kw= ',' )? this_ID_2= RULE_ID )* kw= ')' )
            // InternalXHDL.g:669:3: kw= '(' ( (kw= ',' )? this_ID_2= RULE_ID )* kw= ')'
            {
            kw=(Token)match(input,21,FOLLOW_20); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getXEnumsAccess().getLeftParenthesisKeyword_0());
            		
            // InternalXHDL.g:674:3: ( (kw= ',' )? this_ID_2= RULE_ID )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==29) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalXHDL.g:675:4: (kw= ',' )? this_ID_2= RULE_ID
            	    {
            	    // InternalXHDL.g:675:4: (kw= ',' )?
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==29) ) {
            	        alt7=1;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // InternalXHDL.g:676:5: kw= ','
            	            {
            	            kw=(Token)match(input,29,FOLLOW_4); 

            	            					current.merge(kw);
            	            					newLeafNode(kw, grammarAccess.getXEnumsAccess().getCommaKeyword_1_0());
            	            				

            	            }
            	            break;

            	    }

            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_20); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getXEnumsAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            kw=(Token)match(input,24,FOLLOW_2); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getXEnumsAccess().getRightParenthesisKeyword_2());
            		

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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000005EA000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000002010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000021000010L});

}