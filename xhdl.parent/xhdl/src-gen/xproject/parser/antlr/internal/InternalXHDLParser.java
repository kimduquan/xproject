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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_XLONG", "RULE_XDOUBLE", "RULE_INT", "RULE_STRING", "RULE_COMMENT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'is'", "'end'", "';'", "'attribute'", "':'", "'subtype'", "'signal'", "';='", "'type'", "'array'", "'('", "'range'", "'<>'", "')'", "'of'", "'to'", "'\\''", "'units'", "'='", "','", "'function'", "'return'", "'impure'"
    };
    public static final int RULE_STRING=8;
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
    public static final int RULE_XLONG=5;
    public static final int RULE_XDOUBLE=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=7;
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

                if ( (LA1_0==14) ) {
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


    // $ANTLR start "entryRuleXPackageRef"
    // InternalXHDL.g:100:1: entryRuleXPackageRef returns [EObject current=null] : iv_ruleXPackageRef= ruleXPackageRef EOF ;
    public final EObject entryRuleXPackageRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPackageRef = null;


        try {
            // InternalXHDL.g:100:52: (iv_ruleXPackageRef= ruleXPackageRef EOF )
            // InternalXHDL.g:101:2: iv_ruleXPackageRef= ruleXPackageRef EOF
            {
             newCompositeNode(grammarAccess.getXPackageRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXPackageRef=ruleXPackageRef();

            state._fsp--;

             current =iv_ruleXPackageRef; 
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
    // $ANTLR end "entryRuleXPackageRef"


    // $ANTLR start "ruleXPackageRef"
    // InternalXHDL.g:107:1: ruleXPackageRef returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleXPackageRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalXHDL.g:113:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalXHDL.g:114:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalXHDL.g:114:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalXHDL.g:115:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalXHDL.g:115:3: ()
            // InternalXHDL.g:116:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXPackageRefAccess().getXPackageRefAction_0(),
            					current);
            			

            }

            // InternalXHDL.g:122:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXHDL.g:123:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXHDL.g:123:4: (lv_name_1_0= RULE_ID )
            // InternalXHDL.g:124:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getXPackageRefAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXPackageRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleXPackageRef"


    // $ANTLR start "entryRuleXPackage"
    // InternalXHDL.g:144:1: entryRuleXPackage returns [EObject current=null] : iv_ruleXPackage= ruleXPackage EOF ;
    public final EObject entryRuleXPackage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXPackage = null;


        try {
            // InternalXHDL.g:144:49: (iv_ruleXPackage= ruleXPackage EOF )
            // InternalXHDL.g:145:2: iv_ruleXPackage= ruleXPackage EOF
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
    // InternalXHDL.g:151:1: ruleXPackage returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_xis_3_0= ruleXElement ) )* otherlv_4= 'end' ( ( ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleXPackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_xis_3_0 = null;

        EObject lv_xend_6_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:157:2: ( (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_xis_3_0= ruleXElement ) )* otherlv_4= 'end' ( ( ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) ) )
            // InternalXHDL.g:158:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_xis_3_0= ruleXElement ) )* otherlv_4= 'end' ( ( ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalXHDL.g:158:2: (otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_xis_3_0= ruleXElement ) )* otherlv_4= 'end' ( ( ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) )
            // InternalXHDL.g:159:3: otherlv_0= 'package' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'is' ( (lv_xis_3_0= ruleXElement ) )* otherlv_4= 'end' ( ( ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getXPackageAccess().getPackageKeyword_0());
            		
            // InternalXHDL.g:163:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXHDL.g:164:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXHDL.g:164:4: (lv_name_1_0= RULE_ID )
            // InternalXHDL.g:165:5: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getXPackageAccess().getIsKeyword_2());
            		
            // InternalXHDL.g:185:3: ( (lv_xis_3_0= ruleXElement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=17 && LA2_0<=18)||(LA2_0>=20 && LA2_0<=21)||LA2_0==23||LA2_0==37) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalXHDL.g:186:4: (lv_xis_3_0= ruleXElement )
            	    {
            	    // InternalXHDL.g:186:4: (lv_xis_3_0= ruleXElement )
            	    // InternalXHDL.g:187:5: lv_xis_3_0= ruleXElement
            	    {

            	    					newCompositeNode(grammarAccess.getXPackageAccess().getXisXElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_xis_3_0=ruleXElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getXPackageRule());
            	    					}
            	    					add(
            	    						current,
            	    						"xis",
            	    						lv_xis_3_0,
            	    						"xproject.XHDL.XElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_4=(Token)match(input,16,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getXPackageAccess().getEndKeyword_4());
            		
            // InternalXHDL.g:208:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:209:4: ( ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:209:4: ( ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:210:5: ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getXPackageAccess().getUnorderedGroup_5());
            				
            // InternalXHDL.g:213:5: ( ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:214:6: ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:214:6: ( ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( LA3_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getXPackageAccess().getUnorderedGroup_5(), 0) ) {
                    alt3=1;
                }
                else if ( LA3_0 == 17 && getUnorderedGroupHelper().canSelect(grammarAccess.getXPackageAccess().getUnorderedGroup_5(), 1) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalXHDL.g:215:4: ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) )
            	    {
            	    // InternalXHDL.g:215:4: ({...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) ) )
            	    // InternalXHDL.g:216:5: {...}? => ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXPackageAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXPackage", "getUnorderedGroupHelper().canSelect(grammarAccess.getXPackageAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // InternalXHDL.g:216:105: ( ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) ) )
            	    // InternalXHDL.g:217:6: ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXPackageAccess().getUnorderedGroup_5(), 0);
            	    					
            	    // InternalXHDL.g:220:9: ({...}? => ( (lv_xend_6_0= ruleXPackageRef ) ) )
            	    // InternalXHDL.g:220:10: {...}? => ( (lv_xend_6_0= ruleXPackageRef ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXPackage", "true");
            	    }
            	    // InternalXHDL.g:220:19: ( (lv_xend_6_0= ruleXPackageRef ) )
            	    // InternalXHDL.g:220:20: (lv_xend_6_0= ruleXPackageRef )
            	    {
            	    // InternalXHDL.g:220:20: (lv_xend_6_0= ruleXPackageRef )
            	    // InternalXHDL.g:221:10: lv_xend_6_0= ruleXPackageRef
            	    {

            	    										newCompositeNode(grammarAccess.getXPackageAccess().getXendXPackageRefParserRuleCall_5_0_0());
            	    									
            	    pushFollow(FOLLOW_8);
            	    lv_xend_6_0=ruleXPackageRef();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getXPackageRule());
            	    										}
            	    										set(
            	    											current,
            	    											"xend",
            	    											lv_xend_6_0,
            	    											"xproject.XHDL.XPackageRef");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXPackageAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:243:4: ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) )
            	    {
            	    // InternalXHDL.g:243:4: ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) )
            	    // InternalXHDL.g:244:5: {...}? => ( ({...}? => (otherlv_7= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXPackageAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXPackage", "getUnorderedGroupHelper().canSelect(grammarAccess.getXPackageAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // InternalXHDL.g:244:105: ( ({...}? => (otherlv_7= ';' ) ) )
            	    // InternalXHDL.g:245:6: ({...}? => (otherlv_7= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXPackageAccess().getUnorderedGroup_5(), 1);
            	    					
            	    // InternalXHDL.g:248:9: ({...}? => (otherlv_7= ';' ) )
            	    // InternalXHDL.g:248:10: {...}? => (otherlv_7= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXPackage", "true");
            	    }
            	    // InternalXHDL.g:248:19: (otherlv_7= ';' )
            	    // InternalXHDL.g:248:20: otherlv_7= ';'
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_8); 

            	    									newLeafNode(otherlv_7, grammarAccess.getXPackageAccess().getSemicolonKeyword_5_1());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXPackageAccess().getUnorderedGroup_5());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXPackageAccess().getUnorderedGroup_5()) ) {
                throw new FailedPredicateException(input, "ruleXPackage", "getUnorderedGroupHelper().canLeave(grammarAccess.getXPackageAccess().getUnorderedGroup_5())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getXPackageAccess().getUnorderedGroup_5());
            				

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
    // $ANTLR end "ruleXPackage"


    // $ANTLR start "entryRuleXTypeRef"
    // InternalXHDL.g:270:1: entryRuleXTypeRef returns [EObject current=null] : iv_ruleXTypeRef= ruleXTypeRef EOF ;
    public final EObject entryRuleXTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXTypeRef = null;


        try {
            // InternalXHDL.g:270:49: (iv_ruleXTypeRef= ruleXTypeRef EOF )
            // InternalXHDL.g:271:2: iv_ruleXTypeRef= ruleXTypeRef EOF
            {
             newCompositeNode(grammarAccess.getXTypeRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXTypeRef=ruleXTypeRef();

            state._fsp--;

             current =iv_ruleXTypeRef; 
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
    // $ANTLR end "entryRuleXTypeRef"


    // $ANTLR start "ruleXTypeRef"
    // InternalXHDL.g:277:1: ruleXTypeRef returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleXTypeRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalXHDL.g:283:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalXHDL.g:284:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalXHDL.g:284:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalXHDL.g:285:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalXHDL.g:285:3: ()
            // InternalXHDL.g:286:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXTypeRefAccess().getXTypeRefAction_0(),
            					current);
            			

            }

            // InternalXHDL.g:292:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXHDL.g:293:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXHDL.g:293:4: (lv_name_1_0= RULE_ID )
            // InternalXHDL.g:294:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getXTypeRefAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXTypeRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleXTypeRef"


    // $ANTLR start "entryRuleXElement"
    // InternalXHDL.g:314:1: entryRuleXElement returns [EObject current=null] : iv_ruleXElement= ruleXElement EOF ;
    public final EObject entryRuleXElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXElement = null;


        try {
            // InternalXHDL.g:314:49: (iv_ruleXElement= ruleXElement EOF )
            // InternalXHDL.g:315:2: iv_ruleXElement= ruleXElement EOF
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
    // InternalXHDL.g:321:1: ruleXElement returns [EObject current=null] : (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute | this_XImpure_4= ruleXImpure ) ;
    public final EObject ruleXElement() throws RecognitionException {
        EObject current = null;

        EObject this_XType_0 = null;

        EObject this_XSignal_1 = null;

        EObject this_XSubType_2 = null;

        EObject this_XAttribute_3 = null;

        EObject this_XImpure_4 = null;



        	enterRule();

        try {
            // InternalXHDL.g:327:2: ( (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute | this_XImpure_4= ruleXImpure ) )
            // InternalXHDL.g:328:2: (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute | this_XImpure_4= ruleXImpure )
            {
            // InternalXHDL.g:328:2: (this_XType_0= ruleXType | this_XSignal_1= ruleXSignal | this_XSubType_2= ruleXSubType | this_XAttribute_3= ruleXAttribute | this_XImpure_4= ruleXImpure )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt4=1;
                }
                break;
            case 21:
                {
                alt4=2;
                }
                break;
            case 20:
                {
                alt4=3;
                }
                break;
            case 18:
                {
                alt4=4;
                }
                break;
            case 17:
            case 37:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalXHDL.g:329:3: this_XType_0= ruleXType
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
                    // InternalXHDL.g:338:3: this_XSignal_1= ruleXSignal
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
                    // InternalXHDL.g:347:3: this_XSubType_2= ruleXSubType
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
                    // InternalXHDL.g:356:3: this_XAttribute_3= ruleXAttribute
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
                    // InternalXHDL.g:365:3: this_XImpure_4= ruleXImpure
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
    // InternalXHDL.g:377:1: entryRuleXAttribute returns [EObject current=null] : iv_ruleXAttribute= ruleXAttribute EOF ;
    public final EObject entryRuleXAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXAttribute = null;


        try {
            // InternalXHDL.g:377:51: (iv_ruleXAttribute= ruleXAttribute EOF )
            // InternalXHDL.g:378:2: iv_ruleXAttribute= ruleXAttribute EOF
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
    // InternalXHDL.g:384:1: ruleXAttribute returns [EObject current=null] : ( () otherlv_1= 'attribute' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleXAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_xtype_5_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:390:2: ( ( () otherlv_1= 'attribute' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?) ) ) ) )
            // InternalXHDL.g:391:2: ( () otherlv_1= 'attribute' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalXHDL.g:391:2: ( () otherlv_1= 'attribute' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?) ) ) )
            // InternalXHDL.g:392:3: () otherlv_1= 'attribute' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?) ) )
            {
            // InternalXHDL.g:392:3: ()
            // InternalXHDL.g:393:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXAttributeAccess().getXAttributeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getXAttributeAccess().getAttributeKeyword_1());
            		
            // InternalXHDL.g:403:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:404:4: ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:404:4: ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:405:5: ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getXAttributeAccess().getUnorderedGroup_2());
            				
            // InternalXHDL.g:408:5: ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:409:6: ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:409:6: ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=5;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    int LA5_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 3) ) {
                        alt5=4;
                    }


                }
                else if ( LA5_0 == RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 2) || getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 0) ) ) {
                    int LA5_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 0) ) {
                        alt5=1;
                    }
                    else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 2) ) {
                        alt5=3;
                    }


                }
                else if ( LA5_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 1) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalXHDL.g:410:4: ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) )
            	    {
            	    // InternalXHDL.g:410:4: ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) )
            	    // InternalXHDL.g:411:5: {...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXAttribute", "getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalXHDL.g:411:107: ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) )
            	    // InternalXHDL.g:412:6: ({...}? => ( (lv_name_3_0= RULE_ID ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalXHDL.g:415:9: ({...}? => ( (lv_name_3_0= RULE_ID ) ) )
            	    // InternalXHDL.g:415:10: {...}? => ( (lv_name_3_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXAttribute", "true");
            	    }
            	    // InternalXHDL.g:415:19: ( (lv_name_3_0= RULE_ID ) )
            	    // InternalXHDL.g:415:20: (lv_name_3_0= RULE_ID )
            	    {
            	    // InternalXHDL.g:415:20: (lv_name_3_0= RULE_ID )
            	    // InternalXHDL.g:416:10: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            	    										newLeafNode(lv_name_3_0, grammarAccess.getXAttributeAccess().getNameIDTerminalRuleCall_2_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getXAttributeRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"name",
            	    											lv_name_3_0,
            	    											"org.eclipse.xtext.common.Terminals.ID");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXAttributeAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:437:4: ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) )
            	    {
            	    // InternalXHDL.g:437:4: ({...}? => ( ({...}? => (otherlv_4= ':' ) ) ) )
            	    // InternalXHDL.g:438:5: {...}? => ( ({...}? => (otherlv_4= ':' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXAttribute", "getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalXHDL.g:438:107: ( ({...}? => (otherlv_4= ':' ) ) )
            	    // InternalXHDL.g:439:6: ({...}? => (otherlv_4= ':' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalXHDL.g:442:9: ({...}? => (otherlv_4= ':' ) )
            	    // InternalXHDL.g:442:10: {...}? => (otherlv_4= ':' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXAttribute", "true");
            	    }
            	    // InternalXHDL.g:442:19: (otherlv_4= ':' )
            	    // InternalXHDL.g:442:20: otherlv_4= ':'
            	    {
            	    otherlv_4=(Token)match(input,19,FOLLOW_10); 

            	    									newLeafNode(otherlv_4, grammarAccess.getXAttributeAccess().getColonKeyword_2_1());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXAttributeAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalXHDL.g:452:4: ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) )
            	    {
            	    // InternalXHDL.g:452:4: ({...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) )
            	    // InternalXHDL.g:453:5: {...}? => ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleXAttribute", "getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalXHDL.g:453:107: ( ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) ) )
            	    // InternalXHDL.g:454:6: ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalXHDL.g:457:9: ({...}? => ( (lv_xtype_5_0= ruleXTypeRef ) ) )
            	    // InternalXHDL.g:457:10: {...}? => ( (lv_xtype_5_0= ruleXTypeRef ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXAttribute", "true");
            	    }
            	    // InternalXHDL.g:457:19: ( (lv_xtype_5_0= ruleXTypeRef ) )
            	    // InternalXHDL.g:457:20: (lv_xtype_5_0= ruleXTypeRef )
            	    {
            	    // InternalXHDL.g:457:20: (lv_xtype_5_0= ruleXTypeRef )
            	    // InternalXHDL.g:458:10: lv_xtype_5_0= ruleXTypeRef
            	    {

            	    										newCompositeNode(grammarAccess.getXAttributeAccess().getXtypeXTypeRefParserRuleCall_2_2_0());
            	    									
            	    pushFollow(FOLLOW_10);
            	    lv_xtype_5_0=ruleXTypeRef();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getXAttributeRule());
            	    										}
            	    										set(
            	    											current,
            	    											"xtype",
            	    											lv_xtype_5_0,
            	    											"xproject.XHDL.XTypeRef");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXAttributeAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalXHDL.g:480:4: ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) )
            	    {
            	    // InternalXHDL.g:480:4: ({...}? => ( ({...}? => (otherlv_6= ';' ) ) ) )
            	    // InternalXHDL.g:481:5: {...}? => ( ({...}? => (otherlv_6= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleXAttribute", "getUnorderedGroupHelper().canSelect(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // InternalXHDL.g:481:107: ( ({...}? => (otherlv_6= ';' ) ) )
            	    // InternalXHDL.g:482:6: ({...}? => (otherlv_6= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXAttributeAccess().getUnorderedGroup_2(), 3);
            	    					
            	    // InternalXHDL.g:485:9: ({...}? => (otherlv_6= ';' ) )
            	    // InternalXHDL.g:485:10: {...}? => (otherlv_6= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXAttribute", "true");
            	    }
            	    // InternalXHDL.g:485:19: (otherlv_6= ';' )
            	    // InternalXHDL.g:485:20: otherlv_6= ';'
            	    {
            	    otherlv_6=(Token)match(input,17,FOLLOW_10); 

            	    									newLeafNode(otherlv_6, grammarAccess.getXAttributeAccess().getSemicolonKeyword_2_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXAttributeAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


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

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXAttributeAccess().getUnorderedGroup_2()) ) {
                throw new FailedPredicateException(input, "ruleXAttribute", "getUnorderedGroupHelper().canLeave(grammarAccess.getXAttributeAccess().getUnorderedGroup_2())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getXAttributeAccess().getUnorderedGroup_2());
            				

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
    // $ANTLR end "ruleXAttribute"


    // $ANTLR start "entryRuleXSubType"
    // InternalXHDL.g:507:1: entryRuleXSubType returns [EObject current=null] : iv_ruleXSubType= ruleXSubType EOF ;
    public final EObject entryRuleXSubType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSubType = null;


        try {
            // InternalXHDL.g:507:49: (iv_ruleXSubType= ruleXSubType EOF )
            // InternalXHDL.g:508:2: iv_ruleXSubType= ruleXSubType EOF
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
    // InternalXHDL.g:514:1: ruleXSubType returns [EObject current=null] : ( () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleXSubType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        EObject lv_xis_5_0 = null;

        EObject lv_xrange_6_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:520:2: ( ( () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) ) )
            // InternalXHDL.g:521:2: ( () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalXHDL.g:521:2: ( () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) )
            // InternalXHDL.g:522:3: () otherlv_1= 'subtype' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) )
            {
            // InternalXHDL.g:522:3: ()
            // InternalXHDL.g:523:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXSubTypeAccess().getXSubTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXSubTypeAccess().getSubtypeKeyword_1());
            		
            // InternalXHDL.g:533:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXHDL.g:534:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXHDL.g:534:4: (lv_name_2_0= RULE_ID )
            // InternalXHDL.g:535:5: lv_name_2_0= RULE_ID
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

            otherlv_3=(Token)match(input,15,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getXSubTypeAccess().getIsKeyword_3());
            		
            // InternalXHDL.g:555:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:556:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:556:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:557:5: ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4());
            				
            // InternalXHDL.g:560:5: ( ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:561:6: ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:561:6: ( ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==17) ) {
                    int LA7_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4(), 1) ) {
                        alt7=2;
                    }


                }
                else if ( LA7_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4(), 0) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalXHDL.g:562:4: ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) )
            	    {
            	    // InternalXHDL.g:562:4: ({...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) ) )
            	    // InternalXHDL.g:563:5: {...}? => ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXSubType", "getUnorderedGroupHelper().canSelect(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalXHDL.g:563:105: ( ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) ) )
            	    // InternalXHDL.g:564:6: ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalXHDL.g:567:9: ({...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? ) )
            	    // InternalXHDL.g:567:10: {...}? => ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXSubType", "true");
            	    }
            	    // InternalXHDL.g:567:19: ( ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )? )
            	    // InternalXHDL.g:567:20: ( (lv_xis_5_0= ruleXTypeRef ) ) ( (lv_xrange_6_0= ruleXRange ) )?
            	    {
            	    // InternalXHDL.g:567:20: ( (lv_xis_5_0= ruleXTypeRef ) )
            	    // InternalXHDL.g:568:10: (lv_xis_5_0= ruleXTypeRef )
            	    {
            	    // InternalXHDL.g:568:10: (lv_xis_5_0= ruleXTypeRef )
            	    // InternalXHDL.g:569:11: lv_xis_5_0= ruleXTypeRef
            	    {

            	    											newCompositeNode(grammarAccess.getXSubTypeAccess().getXisXTypeRefParserRuleCall_4_0_0_0());
            	    										
            	    pushFollow(FOLLOW_11);
            	    lv_xis_5_0=ruleXTypeRef();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getXSubTypeRule());
            	    											}
            	    											set(
            	    												current,
            	    												"xis",
            	    												lv_xis_5_0,
            	    												"xproject.XHDL.XTypeRef");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    // InternalXHDL.g:586:9: ( (lv_xrange_6_0= ruleXRange ) )?
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==26) ) {
            	        alt6=1;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // InternalXHDL.g:587:10: (lv_xrange_6_0= ruleXRange )
            	            {
            	            // InternalXHDL.g:587:10: (lv_xrange_6_0= ruleXRange )
            	            // InternalXHDL.g:588:11: lv_xrange_6_0= ruleXRange
            	            {

            	            											newCompositeNode(grammarAccess.getXSubTypeAccess().getXrangeXRangeParserRuleCall_4_0_1_0());
            	            										
            	            pushFollow(FOLLOW_8);
            	            lv_xrange_6_0=ruleXRange();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getXSubTypeRule());
            	            											}
            	            											set(
            	            												current,
            	            												"xrange",
            	            												lv_xrange_6_0,
            	            												"xproject.XHDL.XRange");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:611:4: ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) )
            	    {
            	    // InternalXHDL.g:611:4: ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) )
            	    // InternalXHDL.g:612:5: {...}? => ( ({...}? => (otherlv_7= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXSubType", "getUnorderedGroupHelper().canSelect(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalXHDL.g:612:105: ( ({...}? => (otherlv_7= ';' ) ) )
            	    // InternalXHDL.g:613:6: ({...}? => (otherlv_7= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalXHDL.g:616:9: ({...}? => (otherlv_7= ';' ) )
            	    // InternalXHDL.g:616:10: {...}? => (otherlv_7= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXSubType", "true");
            	    }
            	    // InternalXHDL.g:616:19: (otherlv_7= ';' )
            	    // InternalXHDL.g:616:20: otherlv_7= ';'
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_8); 

            	    									newLeafNode(otherlv_7, grammarAccess.getXSubTypeAccess().getSemicolonKeyword_4_1());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "ruleXSubType", "getUnorderedGroupHelper().canLeave(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getXSubTypeAccess().getUnorderedGroup_4());
            				

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
    // $ANTLR end "ruleXSubType"


    // $ANTLR start "entryRuleXSignal"
    // InternalXHDL.g:638:1: entryRuleXSignal returns [EObject current=null] : iv_ruleXSignal= ruleXSignal EOF ;
    public final EObject entryRuleXSignal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXSignal = null;


        try {
            // InternalXHDL.g:638:48: (iv_ruleXSignal= ruleXSignal EOF )
            // InternalXHDL.g:639:2: iv_ruleXSignal= ruleXSignal EOF
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
    // InternalXHDL.g:645:1: ruleXSignal returns [EObject current=null] : ( () otherlv_1= 'signal' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleXSignal() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token this_ID_8=null;
        Token otherlv_9=null;
        EObject lv_xtype_5_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:651:2: ( ( () otherlv_1= 'signal' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) ) )
            // InternalXHDL.g:652:2: ( () otherlv_1= 'signal' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalXHDL.g:652:2: ( () otherlv_1= 'signal' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?) ) ) )
            // InternalXHDL.g:653:3: () otherlv_1= 'signal' ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?) ) )
            {
            // InternalXHDL.g:653:3: ()
            // InternalXHDL.g:654:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXSignalAccess().getXSignalAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getXSignalAccess().getSignalKeyword_1());
            		
            // InternalXHDL.g:664:3: ( ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:665:4: ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:665:4: ( ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:666:5: ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getXSignalAccess().getUnorderedGroup_2());
            				
            // InternalXHDL.g:669:5: ( ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:670:6: ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:670:6: ( ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) ) )+
            int cnt9=0;
            loop9:
            do {
                int alt9=5;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==17) ) {
                    int LA9_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 3) ) {
                        alt9=4;
                    }


                }
                else if ( LA9_0 == RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 2) || getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 0) ) ) {
                    int LA9_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 0) ) {
                        alt9=1;
                    }
                    else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 2) ) {
                        alt9=3;
                    }


                }
                else if ( LA9_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 1) ) {
                    alt9=2;
                }
                else if ( LA9_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 2) ) {
                    alt9=3;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalXHDL.g:671:4: ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) )
            	    {
            	    // InternalXHDL.g:671:4: ({...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) ) )
            	    // InternalXHDL.g:672:5: {...}? => ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalXHDL.g:672:104: ( ({...}? => ( (lv_name_3_0= RULE_ID ) ) ) )
            	    // InternalXHDL.g:673:6: ({...}? => ( (lv_name_3_0= RULE_ID ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalXHDL.g:676:9: ({...}? => ( (lv_name_3_0= RULE_ID ) ) )
            	    // InternalXHDL.g:676:10: {...}? => ( (lv_name_3_0= RULE_ID ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "true");
            	    }
            	    // InternalXHDL.g:676:19: ( (lv_name_3_0= RULE_ID ) )
            	    // InternalXHDL.g:676:20: (lv_name_3_0= RULE_ID )
            	    {
            	    // InternalXHDL.g:676:20: (lv_name_3_0= RULE_ID )
            	    // InternalXHDL.g:677:10: lv_name_3_0= RULE_ID
            	    {
            	    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    										newLeafNode(lv_name_3_0, grammarAccess.getXSignalAccess().getNameIDTerminalRuleCall_2_0_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getXSignalRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"name",
            	    											lv_name_3_0,
            	    											"org.eclipse.xtext.common.Terminals.ID");
            	    									

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXSignalAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:698:4: ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) )
            	    {
            	    // InternalXHDL.g:698:4: ({...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) ) )
            	    // InternalXHDL.g:699:5: {...}? => ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalXHDL.g:699:104: ( ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) ) )
            	    // InternalXHDL.g:700:6: ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalXHDL.g:703:9: ({...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) ) )
            	    // InternalXHDL.g:703:10: {...}? => (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "true");
            	    }
            	    // InternalXHDL.g:703:19: (otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) ) )
            	    // InternalXHDL.g:703:20: otherlv_4= ':' ( (lv_xtype_5_0= ruleXTypeRef ) )
            	    {
            	    otherlv_4=(Token)match(input,19,FOLLOW_4); 

            	    									newLeafNode(otherlv_4, grammarAccess.getXSignalAccess().getColonKeyword_2_1_0());
            	    								
            	    // InternalXHDL.g:707:9: ( (lv_xtype_5_0= ruleXTypeRef ) )
            	    // InternalXHDL.g:708:10: (lv_xtype_5_0= ruleXTypeRef )
            	    {
            	    // InternalXHDL.g:708:10: (lv_xtype_5_0= ruleXTypeRef )
            	    // InternalXHDL.g:709:11: lv_xtype_5_0= ruleXTypeRef
            	    {

            	    											newCompositeNode(grammarAccess.getXSignalAccess().getXtypeXTypeRefParserRuleCall_2_1_1_0());
            	    										
            	    pushFollow(FOLLOW_13);
            	    lv_xtype_5_0=ruleXTypeRef();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getXSignalRule());
            	    											}
            	    											set(
            	    												current,
            	    												"xtype",
            	    												lv_xtype_5_0,
            	    												"xproject.XHDL.XTypeRef");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXSignalAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalXHDL.g:732:4: ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) )
            	    {
            	    // InternalXHDL.g:732:4: ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) )
            	    // InternalXHDL.g:733:5: {...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalXHDL.g:733:104: ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) ) )
            	    // InternalXHDL.g:734:6: ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalXHDL.g:737:9: ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) ) )
            	    // InternalXHDL.g:737:10: {...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "true");
            	    }
            	    // InternalXHDL.g:737:19: ( ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) ) )
            	    // InternalXHDL.g:737:20: ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) )
            	    {
            	    // InternalXHDL.g:737:20: ( ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?) )
            	    // InternalXHDL.g:738:10: ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?)
            	    {
            	     
            	    									  getUnorderedGroupHelper().enter(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2());
            	    									
            	    // InternalXHDL.g:741:10: ( ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?)
            	    // InternalXHDL.g:742:11: ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+ {...}?
            	    {
            	    // InternalXHDL.g:742:11: ( ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=3;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==RULE_ID) ) {
            	            int LA8_2 = input.LA(2);

            	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2(), 1) ) {
            	                alt8=2;
            	            }


            	        }
            	        else if ( (LA8_0==22) ) {
            	            int LA8_3 = input.LA(2);

            	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2(), 0) ) {
            	                alt8=1;
            	            }


            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalXHDL.g:743:9: ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) )
            	    	    {
            	    	    // InternalXHDL.g:743:9: ({...}? => ( ({...}? => (otherlv_7= ';=' ) ) ) )
            	    	    // InternalXHDL.g:744:10: {...}? => ( ({...}? => (otherlv_7= ';=' ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2(), 0) ) {
            	    	        throw new FailedPredicateException(input, "ruleXSignal", "getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2(), 0)");
            	    	    }
            	    	    // InternalXHDL.g:744:111: ( ({...}? => (otherlv_7= ';=' ) ) )
            	    	    // InternalXHDL.g:745:11: ({...}? => (otherlv_7= ';=' ) )
            	    	    {

            	    	    											getUnorderedGroupHelper().select(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2(), 0);
            	    	    										
            	    	    // InternalXHDL.g:748:14: ({...}? => (otherlv_7= ';=' ) )
            	    	    // InternalXHDL.g:748:15: {...}? => (otherlv_7= ';=' )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleXSignal", "true");
            	    	    }
            	    	    // InternalXHDL.g:748:24: (otherlv_7= ';=' )
            	    	    // InternalXHDL.g:748:25: otherlv_7= ';='
            	    	    {
            	    	    otherlv_7=(Token)match(input,22,FOLLOW_13); 

            	    	    														newLeafNode(otherlv_7, grammarAccess.getXSignalAccess().getSemicolonEqualsSignKeyword_2_2_0());
            	    	    													

            	    	    }


            	    	    }

            	    	     
            	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // InternalXHDL.g:758:9: ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) )
            	    	    {
            	    	    // InternalXHDL.g:758:9: ({...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) ) )
            	    	    // InternalXHDL.g:759:10: {...}? => ( ({...}? => (this_ID_8= RULE_ID ) ) )
            	    	    {
            	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2(), 1) ) {
            	    	        throw new FailedPredicateException(input, "ruleXSignal", "getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2(), 1)");
            	    	    }
            	    	    // InternalXHDL.g:759:111: ( ({...}? => (this_ID_8= RULE_ID ) ) )
            	    	    // InternalXHDL.g:760:11: ({...}? => (this_ID_8= RULE_ID ) )
            	    	    {

            	    	    											getUnorderedGroupHelper().select(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2(), 1);
            	    	    										
            	    	    // InternalXHDL.g:763:14: ({...}? => (this_ID_8= RULE_ID ) )
            	    	    // InternalXHDL.g:763:15: {...}? => (this_ID_8= RULE_ID )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleXSignal", "true");
            	    	    }
            	    	    // InternalXHDL.g:763:24: (this_ID_8= RULE_ID )
            	    	    // InternalXHDL.g:763:25: this_ID_8= RULE_ID
            	    	    {
            	    	    this_ID_8=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    	    														newLeafNode(this_ID_8, grammarAccess.getXSignalAccess().getIDTerminalRuleCall_2_2_1());
            	    	    													

            	    	    }


            	    	    }

            	    	     
            	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2());
            	    	    										

            	    	    }


            	    	    }


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

            	    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2()) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "getUnorderedGroupHelper().canLeave(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2())");
            	    }

            	    }


            	    }

            	     
            	    									  getUnorderedGroupHelper().leave(grammarAccess.getXSignalAccess().getUnorderedGroup_2_2());
            	    									

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXSignalAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalXHDL.g:786:4: ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) )
            	    {
            	    // InternalXHDL.g:786:4: ({...}? => ( ({...}? => (otherlv_9= ';' ) ) ) )
            	    // InternalXHDL.g:787:5: {...}? => ( ({...}? => (otherlv_9= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "getUnorderedGroupHelper().canSelect(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 3)");
            	    }
            	    // InternalXHDL.g:787:104: ( ({...}? => (otherlv_9= ';' ) ) )
            	    // InternalXHDL.g:788:6: ({...}? => (otherlv_9= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXSignalAccess().getUnorderedGroup_2(), 3);
            	    					
            	    // InternalXHDL.g:791:9: ({...}? => (otherlv_9= ';' ) )
            	    // InternalXHDL.g:791:10: {...}? => (otherlv_9= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXSignal", "true");
            	    }
            	    // InternalXHDL.g:791:19: (otherlv_9= ';' )
            	    // InternalXHDL.g:791:20: otherlv_9= ';'
            	    {
            	    otherlv_9=(Token)match(input,17,FOLLOW_13); 

            	    									newLeafNode(otherlv_9, grammarAccess.getXSignalAccess().getSemicolonKeyword_2_3());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXSignalAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXSignalAccess().getUnorderedGroup_2()) ) {
                throw new FailedPredicateException(input, "ruleXSignal", "getUnorderedGroupHelper().canLeave(grammarAccess.getXSignalAccess().getUnorderedGroup_2())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getXSignalAccess().getUnorderedGroup_2());
            				

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
    // $ANTLR end "ruleXSignal"


    // $ANTLR start "entryRuleXType"
    // InternalXHDL.g:813:1: entryRuleXType returns [EObject current=null] : iv_ruleXType= ruleXType EOF ;
    public final EObject entryRuleXType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXType = null;


        try {
            // InternalXHDL.g:813:46: (iv_ruleXType= ruleXType EOF )
            // InternalXHDL.g:814:2: iv_ruleXType= ruleXType EOF
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
    // InternalXHDL.g:820:1: ruleXType returns [EObject current=null] : ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleXType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_xenums_5_0 = null;

        EObject lv_xrange_6_0 = null;

        EObject lv_xarray_7_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:826:2: ( ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?) ) ) ) )
            // InternalXHDL.g:827:2: ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalXHDL.g:827:2: ( () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?) ) ) )
            // InternalXHDL.g:828:3: () otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'is' ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?) ) )
            {
            // InternalXHDL.g:828:3: ()
            // InternalXHDL.g:829:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXTypeAccess().getXTypeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXTypeAccess().getTypeKeyword_1());
            		
            // InternalXHDL.g:839:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXHDL.g:840:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXHDL.g:840:4: (lv_name_2_0= RULE_ID )
            // InternalXHDL.g:841:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXTypeAccess().getNameIDTerminalRuleCall_2_0());
            				

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

            otherlv_3=(Token)match(input,15,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getXTypeAccess().getIsKeyword_3());
            		
            // InternalXHDL.g:861:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:862:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:862:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:863:5: ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getXTypeAccess().getUnorderedGroup_4());
            				
            // InternalXHDL.g:866:5: ( ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:867:6: ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:867:6: ( ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==17) ) {
                    int LA11_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXTypeAccess().getUnorderedGroup_4(), 1) ) {
                        alt11=2;
                    }


                }
                else if ( ( LA11_0 == RULE_ID || LA11_0 == RULE_STRING || LA11_0 >= 24 && LA11_0 <= 26 || LA11_0 == 28 || LA11_0 == 34 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getXTypeAccess().getUnorderedGroup_4(), 0) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalXHDL.g:868:4: ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) )
            	    {
            	    // InternalXHDL.g:868:4: ({...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) ) )
            	    // InternalXHDL.g:869:5: {...}? => ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXTypeAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXType", "getUnorderedGroupHelper().canSelect(grammarAccess.getXTypeAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalXHDL.g:869:102: ( ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) ) )
            	    // InternalXHDL.g:870:6: ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXTypeAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalXHDL.g:873:9: ({...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) ) )
            	    // InternalXHDL.g:873:10: {...}? => ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXType", "true");
            	    }
            	    // InternalXHDL.g:873:19: ( ( (lv_xenums_5_0= ruleXEnums ) ) | ( (lv_xrange_6_0= ruleXRange ) ) | ( (lv_xarray_7_0= ruleXArray ) ) )
            	    int alt10=3;
            	    switch ( input.LA(1) ) {
            	    case RULE_ID:
            	    case RULE_STRING:
            	    case 25:
            	    case 28:
            	    case 34:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case 24:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // InternalXHDL.g:873:20: ( (lv_xenums_5_0= ruleXEnums ) )
            	            {
            	            // InternalXHDL.g:873:20: ( (lv_xenums_5_0= ruleXEnums ) )
            	            // InternalXHDL.g:874:10: (lv_xenums_5_0= ruleXEnums )
            	            {
            	            // InternalXHDL.g:874:10: (lv_xenums_5_0= ruleXEnums )
            	            // InternalXHDL.g:875:11: lv_xenums_5_0= ruleXEnums
            	            {

            	            											newCompositeNode(grammarAccess.getXTypeAccess().getXenumsXEnumsParserRuleCall_4_0_0_0());
            	            										
            	            pushFollow(FOLLOW_15);
            	            lv_xenums_5_0=ruleXEnums();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getXTypeRule());
            	            											}
            	            											set(
            	            												current,
            	            												"xenums",
            	            												lv_xenums_5_0,
            	            												"xproject.XHDL.XEnums");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalXHDL.g:893:9: ( (lv_xrange_6_0= ruleXRange ) )
            	            {
            	            // InternalXHDL.g:893:9: ( (lv_xrange_6_0= ruleXRange ) )
            	            // InternalXHDL.g:894:10: (lv_xrange_6_0= ruleXRange )
            	            {
            	            // InternalXHDL.g:894:10: (lv_xrange_6_0= ruleXRange )
            	            // InternalXHDL.g:895:11: lv_xrange_6_0= ruleXRange
            	            {

            	            											newCompositeNode(grammarAccess.getXTypeAccess().getXrangeXRangeParserRuleCall_4_0_1_0());
            	            										
            	            pushFollow(FOLLOW_15);
            	            lv_xrange_6_0=ruleXRange();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getXTypeRule());
            	            											}
            	            											set(
            	            												current,
            	            												"xrange",
            	            												lv_xrange_6_0,
            	            												"xproject.XHDL.XRange");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }
            	            break;
            	        case 3 :
            	            // InternalXHDL.g:913:9: ( (lv_xarray_7_0= ruleXArray ) )
            	            {
            	            // InternalXHDL.g:913:9: ( (lv_xarray_7_0= ruleXArray ) )
            	            // InternalXHDL.g:914:10: (lv_xarray_7_0= ruleXArray )
            	            {
            	            // InternalXHDL.g:914:10: (lv_xarray_7_0= ruleXArray )
            	            // InternalXHDL.g:915:11: lv_xarray_7_0= ruleXArray
            	            {

            	            											newCompositeNode(grammarAccess.getXTypeAccess().getXarrayXArrayParserRuleCall_4_0_2_0());
            	            										
            	            pushFollow(FOLLOW_15);
            	            lv_xarray_7_0=ruleXArray();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getXTypeRule());
            	            											}
            	            											set(
            	            												current,
            	            												"xarray",
            	            												lv_xarray_7_0,
            	            												"xproject.XHDL.XArray");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXTypeAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:938:4: ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) )
            	    {
            	    // InternalXHDL.g:938:4: ({...}? => ( ({...}? => (otherlv_8= ';' ) ) ) )
            	    // InternalXHDL.g:939:5: {...}? => ( ({...}? => (otherlv_8= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXTypeAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXType", "getUnorderedGroupHelper().canSelect(grammarAccess.getXTypeAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalXHDL.g:939:102: ( ({...}? => (otherlv_8= ';' ) ) )
            	    // InternalXHDL.g:940:6: ({...}? => (otherlv_8= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXTypeAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalXHDL.g:943:9: ({...}? => (otherlv_8= ';' ) )
            	    // InternalXHDL.g:943:10: {...}? => (otherlv_8= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXType", "true");
            	    }
            	    // InternalXHDL.g:943:19: (otherlv_8= ';' )
            	    // InternalXHDL.g:943:20: otherlv_8= ';'
            	    {
            	    otherlv_8=(Token)match(input,17,FOLLOW_15); 

            	    									newLeafNode(otherlv_8, grammarAccess.getXTypeAccess().getSemicolonKeyword_4_1());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXTypeAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXTypeAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "ruleXType", "getUnorderedGroupHelper().canLeave(grammarAccess.getXTypeAccess().getUnorderedGroup_4())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getXTypeAccess().getUnorderedGroup_4());
            				

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
    // $ANTLR end "ruleXType"


    // $ANTLR start "entryRuleXArray"
    // InternalXHDL.g:965:1: entryRuleXArray returns [EObject current=null] : iv_ruleXArray= ruleXArray EOF ;
    public final EObject entryRuleXArray() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXArray = null;


        try {
            // InternalXHDL.g:965:47: (iv_ruleXArray= ruleXArray EOF )
            // InternalXHDL.g:966:2: iv_ruleXArray= ruleXArray EOF
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
    // InternalXHDL.g:972:1: ruleXArray returns [EObject current=null] : ( () otherlv_1= 'array' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?) ) ) otherlv_8= 'of' ( (lv_xof_9_0= ruleXTypeRef ) ) ) ;
    public final EObject ruleXArray() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_xrange_4_0 = null;

        EObject lv_xof_9_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:978:2: ( ( () otherlv_1= 'array' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?) ) ) otherlv_8= 'of' ( (lv_xof_9_0= ruleXTypeRef ) ) ) )
            // InternalXHDL.g:979:2: ( () otherlv_1= 'array' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?) ) ) otherlv_8= 'of' ( (lv_xof_9_0= ruleXTypeRef ) ) )
            {
            // InternalXHDL.g:979:2: ( () otherlv_1= 'array' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?) ) ) otherlv_8= 'of' ( (lv_xof_9_0= ruleXTypeRef ) ) )
            // InternalXHDL.g:980:3: () otherlv_1= 'array' ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?) ) ) otherlv_8= 'of' ( (lv_xof_9_0= ruleXTypeRef ) )
            {
            // InternalXHDL.g:980:3: ()
            // InternalXHDL.g:981:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXArrayAccess().getXArrayAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,24,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getXArrayAccess().getArrayKeyword_1());
            		
            // InternalXHDL.g:991:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:992:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:992:4: ( ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:993:5: ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getXArrayAccess().getUnorderedGroup_2());
            				
            // InternalXHDL.g:996:5: ( ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:997:6: ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:997:6: ( ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=4;
                int LA12_0 = input.LA(1);

                if ( LA12_0 == 25 && getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 0) ) {
                    alt12=1;
                }
                else if ( LA12_0 == RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 1) ) {
                    alt12=2;
                }
                else if ( LA12_0 == 28 && getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 2) ) {
                    alt12=3;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalXHDL.g:998:4: ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) )
            	    {
            	    // InternalXHDL.g:998:4: ({...}? => ( ({...}? => (otherlv_3= '(' ) ) ) )
            	    // InternalXHDL.g:999:5: {...}? => ( ({...}? => (otherlv_3= '(' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXArray", "getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 0)");
            	    }
            	    // InternalXHDL.g:999:103: ( ({...}? => (otherlv_3= '(' ) ) )
            	    // InternalXHDL.g:1000:6: ({...}? => (otherlv_3= '(' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 0);
            	    					
            	    // InternalXHDL.g:1003:9: ({...}? => (otherlv_3= '(' ) )
            	    // InternalXHDL.g:1003:10: {...}? => (otherlv_3= '(' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXArray", "true");
            	    }
            	    // InternalXHDL.g:1003:19: (otherlv_3= '(' )
            	    // InternalXHDL.g:1003:20: otherlv_3= '('
            	    {
            	    otherlv_3=(Token)match(input,25,FOLLOW_17); 

            	    									newLeafNode(otherlv_3, grammarAccess.getXArrayAccess().getLeftParenthesisKeyword_2_0());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXArrayAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:1013:4: ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) )
            	    {
            	    // InternalXHDL.g:1013:4: ({...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) ) )
            	    // InternalXHDL.g:1014:5: {...}? => ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXArray", "getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 1)");
            	    }
            	    // InternalXHDL.g:1014:103: ( ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) ) )
            	    // InternalXHDL.g:1015:6: ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 1);
            	    					
            	    // InternalXHDL.g:1018:9: ({...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' ) )
            	    // InternalXHDL.g:1018:10: {...}? => ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXArray", "true");
            	    }
            	    // InternalXHDL.g:1018:19: ( ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>' )
            	    // InternalXHDL.g:1018:20: ( (lv_xrange_4_0= ruleXTypeRef ) ) otherlv_5= 'range' otherlv_6= '<>'
            	    {
            	    // InternalXHDL.g:1018:20: ( (lv_xrange_4_0= ruleXTypeRef ) )
            	    // InternalXHDL.g:1019:10: (lv_xrange_4_0= ruleXTypeRef )
            	    {
            	    // InternalXHDL.g:1019:10: (lv_xrange_4_0= ruleXTypeRef )
            	    // InternalXHDL.g:1020:11: lv_xrange_4_0= ruleXTypeRef
            	    {

            	    											newCompositeNode(grammarAccess.getXArrayAccess().getXrangeXTypeRefParserRuleCall_2_1_0_0());
            	    										
            	    pushFollow(FOLLOW_18);
            	    lv_xrange_4_0=ruleXTypeRef();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getXArrayRule());
            	    											}
            	    											set(
            	    												current,
            	    												"xrange",
            	    												lv_xrange_4_0,
            	    												"xproject.XHDL.XTypeRef");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    otherlv_5=(Token)match(input,26,FOLLOW_19); 

            	    									newLeafNode(otherlv_5, grammarAccess.getXArrayAccess().getRangeKeyword_2_1_1());
            	    								
            	    otherlv_6=(Token)match(input,27,FOLLOW_17); 

            	    									newLeafNode(otherlv_6, grammarAccess.getXArrayAccess().getLessThanSignGreaterThanSignKeyword_2_1_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXArrayAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalXHDL.g:1051:4: ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) )
            	    {
            	    // InternalXHDL.g:1051:4: ({...}? => ( ({...}? => (otherlv_7= ')' ) ) ) )
            	    // InternalXHDL.g:1052:5: {...}? => ( ({...}? => (otherlv_7= ')' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleXArray", "getUnorderedGroupHelper().canSelect(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 2)");
            	    }
            	    // InternalXHDL.g:1052:103: ( ({...}? => (otherlv_7= ')' ) ) )
            	    // InternalXHDL.g:1053:6: ({...}? => (otherlv_7= ')' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXArrayAccess().getUnorderedGroup_2(), 2);
            	    					
            	    // InternalXHDL.g:1056:9: ({...}? => (otherlv_7= ')' ) )
            	    // InternalXHDL.g:1056:10: {...}? => (otherlv_7= ')' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXArray", "true");
            	    }
            	    // InternalXHDL.g:1056:19: (otherlv_7= ')' )
            	    // InternalXHDL.g:1056:20: otherlv_7= ')'
            	    {
            	    otherlv_7=(Token)match(input,28,FOLLOW_17); 

            	    									newLeafNode(otherlv_7, grammarAccess.getXArrayAccess().getRightParenthesisKeyword_2_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXArrayAccess().getUnorderedGroup_2());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXArrayAccess().getUnorderedGroup_2()) ) {
                throw new FailedPredicateException(input, "ruleXArray", "getUnorderedGroupHelper().canLeave(grammarAccess.getXArrayAccess().getUnorderedGroup_2())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getXArrayAccess().getUnorderedGroup_2());
            				

            }

            otherlv_8=(Token)match(input,29,FOLLOW_4); 

            			newLeafNode(otherlv_8, grammarAccess.getXArrayAccess().getOfKeyword_3());
            		
            // InternalXHDL.g:1078:3: ( (lv_xof_9_0= ruleXTypeRef ) )
            // InternalXHDL.g:1079:4: (lv_xof_9_0= ruleXTypeRef )
            {
            // InternalXHDL.g:1079:4: (lv_xof_9_0= ruleXTypeRef )
            // InternalXHDL.g:1080:5: lv_xof_9_0= ruleXTypeRef
            {

            					newCompositeNode(grammarAccess.getXArrayAccess().getXofXTypeRefParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_xof_9_0=ruleXTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXArrayRule());
            					}
            					set(
            						current,
            						"xof",
            						lv_xof_9_0,
            						"xproject.XHDL.XTypeRef");
            					afterParserOrEnumRuleCall();
            				

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
    // InternalXHDL.g:1101:1: entryRuleXRange returns [EObject current=null] : iv_ruleXRange= ruleXRange EOF ;
    public final EObject entryRuleXRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRange = null;


        try {
            // InternalXHDL.g:1101:47: (iv_ruleXRange= ruleXRange EOF )
            // InternalXHDL.g:1102:2: iv_ruleXRange= ruleXRange EOF
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
    // InternalXHDL.g:1108:1: ruleXRange returns [EObject current=null] : ( () otherlv_1= 'range' ( (lv_xfrom_2_0= ruleXRangeValue ) ) otherlv_3= 'to' ( (lv_xto_4_0= ruleXRangeValue ) ) ( (lv_xunits_5_0= ruleXUnits ) )? ) ;
    public final EObject ruleXRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_xfrom_2_0 = null;

        EObject lv_xto_4_0 = null;

        EObject lv_xunits_5_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:1114:2: ( ( () otherlv_1= 'range' ( (lv_xfrom_2_0= ruleXRangeValue ) ) otherlv_3= 'to' ( (lv_xto_4_0= ruleXRangeValue ) ) ( (lv_xunits_5_0= ruleXUnits ) )? ) )
            // InternalXHDL.g:1115:2: ( () otherlv_1= 'range' ( (lv_xfrom_2_0= ruleXRangeValue ) ) otherlv_3= 'to' ( (lv_xto_4_0= ruleXRangeValue ) ) ( (lv_xunits_5_0= ruleXUnits ) )? )
            {
            // InternalXHDL.g:1115:2: ( () otherlv_1= 'range' ( (lv_xfrom_2_0= ruleXRangeValue ) ) otherlv_3= 'to' ( (lv_xto_4_0= ruleXRangeValue ) ) ( (lv_xunits_5_0= ruleXUnits ) )? )
            // InternalXHDL.g:1116:3: () otherlv_1= 'range' ( (lv_xfrom_2_0= ruleXRangeValue ) ) otherlv_3= 'to' ( (lv_xto_4_0= ruleXRangeValue ) ) ( (lv_xunits_5_0= ruleXUnits ) )?
            {
            // InternalXHDL.g:1116:3: ()
            // InternalXHDL.g:1117:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXRangeAccess().getXRangeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_1, grammarAccess.getXRangeAccess().getRangeKeyword_1());
            		
            // InternalXHDL.g:1127:3: ( (lv_xfrom_2_0= ruleXRangeValue ) )
            // InternalXHDL.g:1128:4: (lv_xfrom_2_0= ruleXRangeValue )
            {
            // InternalXHDL.g:1128:4: (lv_xfrom_2_0= ruleXRangeValue )
            // InternalXHDL.g:1129:5: lv_xfrom_2_0= ruleXRangeValue
            {

            					newCompositeNode(grammarAccess.getXRangeAccess().getXfromXRangeValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
            lv_xfrom_2_0=ruleXRangeValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXRangeRule());
            					}
            					set(
            						current,
            						"xfrom",
            						lv_xfrom_2_0,
            						"xproject.XHDL.XRangeValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_20); 

            			newLeafNode(otherlv_3, grammarAccess.getXRangeAccess().getToKeyword_3());
            		
            // InternalXHDL.g:1150:3: ( (lv_xto_4_0= ruleXRangeValue ) )
            // InternalXHDL.g:1151:4: (lv_xto_4_0= ruleXRangeValue )
            {
            // InternalXHDL.g:1151:4: (lv_xto_4_0= ruleXRangeValue )
            // InternalXHDL.g:1152:5: lv_xto_4_0= ruleXRangeValue
            {

            					newCompositeNode(grammarAccess.getXRangeAccess().getXtoXRangeValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_22);
            lv_xto_4_0=ruleXRangeValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXRangeRule());
            					}
            					set(
            						current,
            						"xto",
            						lv_xto_4_0,
            						"xproject.XHDL.XRangeValue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalXHDL.g:1169:3: ( (lv_xunits_5_0= ruleXUnits ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalXHDL.g:1170:4: (lv_xunits_5_0= ruleXUnits )
                    {
                    // InternalXHDL.g:1170:4: (lv_xunits_5_0= ruleXUnits )
                    // InternalXHDL.g:1171:5: lv_xunits_5_0= ruleXUnits
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


    // $ANTLR start "entryRuleXRangeValue"
    // InternalXHDL.g:1192:1: entryRuleXRangeValue returns [EObject current=null] : iv_ruleXRangeValue= ruleXRangeValue EOF ;
    public final EObject entryRuleXRangeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXRangeValue = null;


        try {
            // InternalXHDL.g:1192:52: (iv_ruleXRangeValue= ruleXRangeValue EOF )
            // InternalXHDL.g:1193:2: iv_ruleXRangeValue= ruleXRangeValue EOF
            {
             newCompositeNode(grammarAccess.getXRangeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXRangeValue=ruleXRangeValue();

            state._fsp--;

             current =iv_ruleXRangeValue; 
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
    // $ANTLR end "entryRuleXRangeValue"


    // $ANTLR start "ruleXRangeValue"
    // InternalXHDL.g:1199:1: ruleXRangeValue returns [EObject current=null] : ( () ( ( ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )? ) | ( ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) ;
    public final EObject ruleXRangeValue() throws RecognitionException {
        EObject current = null;

        Token lv_xlvalue_1_0=null;
        Token lv_xdvalue_2_0=null;
        Token this_ID_5=null;
        Token otherlv_6=null;
        Token this_ID_7=null;
        EObject lv_xunit_3_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:1205:2: ( ( () ( ( ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )? ) | ( ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) ) ) ) ) )
            // InternalXHDL.g:1206:2: ( () ( ( ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )? ) | ( ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) ) ) ) )
            {
            // InternalXHDL.g:1206:2: ( () ( ( ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )? ) | ( ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) ) ) ) )
            // InternalXHDL.g:1207:3: () ( ( ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )? ) | ( ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalXHDL.g:1207:3: ()
            // InternalXHDL.g:1208:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXRangeValueAccess().getXRangeValueAction_0(),
            					current);
            			

            }

            // InternalXHDL.g:1214:3: ( ( ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )? ) | ( ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_XLONG && LA17_0<=RULE_XDOUBLE)) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalXHDL.g:1215:4: ( ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )? )
                    {
                    // InternalXHDL.g:1215:4: ( ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )? )
                    // InternalXHDL.g:1216:5: ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) ) ( (lv_xunit_3_0= ruleXUnitRef ) )?
                    {
                    // InternalXHDL.g:1216:5: ( ( (lv_xlvalue_1_0= RULE_XLONG ) ) | ( (lv_xdvalue_2_0= RULE_XDOUBLE ) ) )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_XLONG) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==RULE_XDOUBLE) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalXHDL.g:1217:6: ( (lv_xlvalue_1_0= RULE_XLONG ) )
                            {
                            // InternalXHDL.g:1217:6: ( (lv_xlvalue_1_0= RULE_XLONG ) )
                            // InternalXHDL.g:1218:7: (lv_xlvalue_1_0= RULE_XLONG )
                            {
                            // InternalXHDL.g:1218:7: (lv_xlvalue_1_0= RULE_XLONG )
                            // InternalXHDL.g:1219:8: lv_xlvalue_1_0= RULE_XLONG
                            {
                            lv_xlvalue_1_0=(Token)match(input,RULE_XLONG,FOLLOW_23); 

                            								newLeafNode(lv_xlvalue_1_0, grammarAccess.getXRangeValueAccess().getXlvalueXLONGTerminalRuleCall_1_0_0_0_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getXRangeValueRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"xlvalue",
                            									lv_xlvalue_1_0,
                            									"xproject.XHDL.XLONG");
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalXHDL.g:1236:6: ( (lv_xdvalue_2_0= RULE_XDOUBLE ) )
                            {
                            // InternalXHDL.g:1236:6: ( (lv_xdvalue_2_0= RULE_XDOUBLE ) )
                            // InternalXHDL.g:1237:7: (lv_xdvalue_2_0= RULE_XDOUBLE )
                            {
                            // InternalXHDL.g:1237:7: (lv_xdvalue_2_0= RULE_XDOUBLE )
                            // InternalXHDL.g:1238:8: lv_xdvalue_2_0= RULE_XDOUBLE
                            {
                            lv_xdvalue_2_0=(Token)match(input,RULE_XDOUBLE,FOLLOW_23); 

                            								newLeafNode(lv_xdvalue_2_0, grammarAccess.getXRangeValueAccess().getXdvalueXDOUBLETerminalRuleCall_1_0_0_1_0());
                            							

                            								if (current==null) {
                            									current = createModelElement(grammarAccess.getXRangeValueRule());
                            								}
                            								setWithLastConsumed(
                            									current,
                            									"xdvalue",
                            									lv_xdvalue_2_0,
                            									"xproject.XHDL.XDOUBLE");
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalXHDL.g:1255:5: ( (lv_xunit_3_0= ruleXUnitRef ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalXHDL.g:1256:6: (lv_xunit_3_0= ruleXUnitRef )
                            {
                            // InternalXHDL.g:1256:6: (lv_xunit_3_0= ruleXUnitRef )
                            // InternalXHDL.g:1257:7: lv_xunit_3_0= ruleXUnitRef
                            {

                            							newCompositeNode(grammarAccess.getXRangeValueAccess().getXunitXUnitRefParserRuleCall_1_0_1_0());
                            						
                            pushFollow(FOLLOW_2);
                            lv_xunit_3_0=ruleXUnitRef();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getXRangeValueRule());
                            							}
                            							set(
                            								current,
                            								"xunit",
                            								lv_xunit_3_0,
                            								"xproject.XHDL.XUnitRef");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalXHDL.g:1276:4: ( ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) ) )
                    {
                    // InternalXHDL.g:1276:4: ( ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) ) )
                    // InternalXHDL.g:1277:5: ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) )
                    {
                    // InternalXHDL.g:1277:5: ( ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?) )
                    // InternalXHDL.g:1278:6: ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?)
                    {
                     
                    					  getUnorderedGroupHelper().enter(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1());
                    					
                    // InternalXHDL.g:1281:6: ( ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?)
                    // InternalXHDL.g:1282:7: ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+ {...}?
                    {
                    // InternalXHDL.g:1282:7: ( ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) ) | ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=3;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            int LA16_2 = input.LA(2);

                            if ( LA16_2 == 31 && getUnorderedGroupHelper().canSelect(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1(), 0) ) {
                                alt16=1;
                            }
                            else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1(), 1) ) {
                                alt16=2;
                            }


                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalXHDL.g:1283:5: ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) )
                    	    {
                    	    // InternalXHDL.g:1283:5: ({...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) ) )
                    	    // InternalXHDL.g:1284:6: {...}? => ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1(), 0) ) {
                    	        throw new FailedPredicateException(input, "ruleXRangeValue", "getUnorderedGroupHelper().canSelect(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1(), 0)");
                    	    }
                    	    // InternalXHDL.g:1284:111: ( ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) ) )
                    	    // InternalXHDL.g:1285:7: ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) )
                    	    {

                    	    							getUnorderedGroupHelper().select(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1(), 0);
                    	    						
                    	    // InternalXHDL.g:1288:10: ({...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' ) )
                    	    // InternalXHDL.g:1288:11: {...}? => (this_ID_5= RULE_ID otherlv_6= '\\'' )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleXRangeValue", "true");
                    	    }
                    	    // InternalXHDL.g:1288:20: (this_ID_5= RULE_ID otherlv_6= '\\'' )
                    	    // InternalXHDL.g:1288:21: this_ID_5= RULE_ID otherlv_6= '\\''
                    	    {
                    	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_24); 

                    	    										newLeafNode(this_ID_5, grammarAccess.getXRangeValueAccess().getIDTerminalRuleCall_1_1_0_0());
                    	    									
                    	    otherlv_6=(Token)match(input,31,FOLLOW_23); 

                    	    										newLeafNode(otherlv_6, grammarAccess.getXRangeValueAccess().getApostropheKeyword_1_1_0_1());
                    	    									

                    	    }


                    	    }

                    	     
                    	    							getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalXHDL.g:1302:5: ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) )
                    	    {
                    	    // InternalXHDL.g:1302:5: ({...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) ) )
                    	    // InternalXHDL.g:1303:6: {...}? => ( ({...}? => (this_ID_7= RULE_ID ) ) )
                    	    {
                    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1(), 1) ) {
                    	        throw new FailedPredicateException(input, "ruleXRangeValue", "getUnorderedGroupHelper().canSelect(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1(), 1)");
                    	    }
                    	    // InternalXHDL.g:1303:111: ( ({...}? => (this_ID_7= RULE_ID ) ) )
                    	    // InternalXHDL.g:1304:7: ({...}? => (this_ID_7= RULE_ID ) )
                    	    {

                    	    							getUnorderedGroupHelper().select(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1(), 1);
                    	    						
                    	    // InternalXHDL.g:1307:10: ({...}? => (this_ID_7= RULE_ID ) )
                    	    // InternalXHDL.g:1307:11: {...}? => (this_ID_7= RULE_ID )
                    	    {
                    	    if ( !((true)) ) {
                    	        throw new FailedPredicateException(input, "ruleXRangeValue", "true");
                    	    }
                    	    // InternalXHDL.g:1307:20: (this_ID_7= RULE_ID )
                    	    // InternalXHDL.g:1307:21: this_ID_7= RULE_ID
                    	    {
                    	    this_ID_7=(Token)match(input,RULE_ID,FOLLOW_23); 

                    	    										newLeafNode(this_ID_7, grammarAccess.getXRangeValueAccess().getIDTerminalRuleCall_1_1_1());
                    	    									

                    	    }


                    	    }

                    	     
                    	    							getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1());
                    	    						

                    	    }


                    	    }


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

                    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1()) ) {
                        throw new FailedPredicateException(input, "ruleXRangeValue", "getUnorderedGroupHelper().canLeave(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1())");
                    }

                    }


                    }

                     
                    					  getUnorderedGroupHelper().leave(grammarAccess.getXRangeValueAccess().getUnorderedGroup_1_1());
                    					

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
    // $ANTLR end "ruleXRangeValue"


    // $ANTLR start "entryRuleXUnits"
    // InternalXHDL.g:1330:1: entryRuleXUnits returns [EObject current=null] : iv_ruleXUnits= ruleXUnits EOF ;
    public final EObject entryRuleXUnits() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnits = null;


        try {
            // InternalXHDL.g:1330:47: (iv_ruleXUnits= ruleXUnits EOF )
            // InternalXHDL.g:1331:2: iv_ruleXUnits= ruleXUnits EOF
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
    // InternalXHDL.g:1337:1: ruleXUnits returns [EObject current=null] : ( () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' ) ;
    public final EObject ruleXUnits() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_xunits_2_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:1343:2: ( ( () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' ) )
            // InternalXHDL.g:1344:2: ( () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' )
            {
            // InternalXHDL.g:1344:2: ( () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units' )
            // InternalXHDL.g:1345:3: () otherlv_1= 'units' ( (lv_xunits_2_0= ruleXUnit ) )* otherlv_3= 'end' otherlv_4= 'units'
            {
            // InternalXHDL.g:1345:3: ()
            // InternalXHDL.g:1346:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXUnitsAccess().getXUnitsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,32,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getXUnitsAccess().getUnitsKeyword_1());
            		
            // InternalXHDL.g:1356:3: ( (lv_xunits_2_0= ruleXUnit ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID||LA18_0==17) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalXHDL.g:1357:4: (lv_xunits_2_0= ruleXUnit )
            	    {
            	    // InternalXHDL.g:1357:4: (lv_xunits_2_0= ruleXUnit )
            	    // InternalXHDL.g:1358:5: lv_xunits_2_0= ruleXUnit
            	    {

            	    					newCompositeNode(grammarAccess.getXUnitsAccess().getXunitsXUnitParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_25);
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
            	    break loop18;
                }
            } while (true);

            otherlv_3=(Token)match(input,16,FOLLOW_26); 

            			newLeafNode(otherlv_3, grammarAccess.getXUnitsAccess().getEndKeyword_3());
            		
            otherlv_4=(Token)match(input,32,FOLLOW_2); 

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


    // $ANTLR start "entryRuleXUnitRef"
    // InternalXHDL.g:1387:1: entryRuleXUnitRef returns [EObject current=null] : iv_ruleXUnitRef= ruleXUnitRef EOF ;
    public final EObject entryRuleXUnitRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnitRef = null;


        try {
            // InternalXHDL.g:1387:49: (iv_ruleXUnitRef= ruleXUnitRef EOF )
            // InternalXHDL.g:1388:2: iv_ruleXUnitRef= ruleXUnitRef EOF
            {
             newCompositeNode(grammarAccess.getXUnitRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXUnitRef=ruleXUnitRef();

            state._fsp--;

             current =iv_ruleXUnitRef; 
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
    // $ANTLR end "entryRuleXUnitRef"


    // $ANTLR start "ruleXUnitRef"
    // InternalXHDL.g:1394:1: ruleXUnitRef returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleXUnitRef() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalXHDL.g:1400:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalXHDL.g:1401:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalXHDL.g:1401:2: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // InternalXHDL.g:1402:3: () ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalXHDL.g:1402:3: ()
            // InternalXHDL.g:1403:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXUnitRefAccess().getXUnitRefAction_0(),
            					current);
            			

            }

            // InternalXHDL.g:1409:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalXHDL.g:1410:4: (lv_name_1_0= RULE_ID )
            {
            // InternalXHDL.g:1410:4: (lv_name_1_0= RULE_ID )
            // InternalXHDL.g:1411:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getXUnitRefAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXUnitRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

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
    // $ANTLR end "ruleXUnitRef"


    // $ANTLR start "entryRuleXUnit"
    // InternalXHDL.g:1431:1: entryRuleXUnit returns [EObject current=null] : iv_ruleXUnit= ruleXUnit EOF ;
    public final EObject entryRuleXUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXUnit = null;


        try {
            // InternalXHDL.g:1431:46: (iv_ruleXUnit= ruleXUnit EOF )
            // InternalXHDL.g:1432:2: iv_ruleXUnit= ruleXUnit EOF
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
    // InternalXHDL.g:1438:1: ruleXUnit returns [EObject current=null] : ( () ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleXUnit() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_4=null;
        Token lv_xvalue_5_0=null;
        Token otherlv_7=null;
        EObject lv_xbased_6_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:1444:2: ( ( () ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) ) )
            // InternalXHDL.g:1445:2: ( () ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalXHDL.g:1445:2: ( () ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) ) )
            // InternalXHDL.g:1446:3: () ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) )
            {
            // InternalXHDL.g:1446:3: ()
            // InternalXHDL.g:1447:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXUnitAccess().getXUnitAction_0(),
            					current);
            			

            }

            // InternalXHDL.g:1453:3: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:1454:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:1454:4: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:1455:5: ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getXUnitAccess().getUnorderedGroup_1());
            				
            // InternalXHDL.g:1458:5: ( ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:1459:6: ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:1459:6: ( ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    int LA21_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1(), 0) ) {
                        alt21=1;
                    }


                }
                else if ( (LA21_0==17) ) {
                    int LA21_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1(), 1) ) {
                        alt21=2;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // InternalXHDL.g:1460:4: ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) )
            	    {
            	    // InternalXHDL.g:1460:4: ({...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) ) )
            	    // InternalXHDL.g:1461:5: {...}? => ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalXHDL.g:1461:102: ( ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) ) )
            	    // InternalXHDL.g:1462:6: ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXUnitAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // InternalXHDL.g:1465:9: ({...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? ) )
            	    // InternalXHDL.g:1465:10: {...}? => ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXUnit", "true");
            	    }
            	    // InternalXHDL.g:1465:19: ( ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )? )
            	    // InternalXHDL.g:1465:20: ( (lv_name_2_0= RULE_ID ) ) ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )?
            	    {
            	    // InternalXHDL.g:1465:20: ( (lv_name_2_0= RULE_ID ) )
            	    // InternalXHDL.g:1466:10: (lv_name_2_0= RULE_ID )
            	    {
            	    // InternalXHDL.g:1466:10: (lv_name_2_0= RULE_ID )
            	    // InternalXHDL.g:1467:11: lv_name_2_0= RULE_ID
            	    {
            	    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_27); 

            	    											newLeafNode(lv_name_2_0, grammarAccess.getXUnitAccess().getNameIDTerminalRuleCall_1_0_0_0());
            	    										

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getXUnitRule());
            	    											}
            	    											setWithLastConsumed(
            	    												current,
            	    												"name",
            	    												lv_name_2_0,
            	    												"org.eclipse.xtext.common.Terminals.ID");
            	    										

            	    }


            	    }

            	    // InternalXHDL.g:1483:9: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) ) )?
            	    int alt20=2;
            	    int LA20_0 = input.LA(1);

            	    if ( (LA20_0==RULE_INT||LA20_0==33) ) {
            	        alt20=1;
            	    }
            	    switch (alt20) {
            	        case 1 :
            	            // InternalXHDL.g:1484:10: ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) )
            	            {
            	            // InternalXHDL.g:1484:10: ( ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?) )
            	            // InternalXHDL.g:1485:11: ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?)
            	            {
            	             
            	            										  getUnorderedGroupHelper().enter(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1());
            	            										
            	            // InternalXHDL.g:1488:11: ( ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?)
            	            // InternalXHDL.g:1489:12: ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+ {...}?
            	            {
            	            // InternalXHDL.g:1489:12: ( ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) ) )+
            	            int cnt19=0;
            	            loop19:
            	            do {
            	                int alt19=3;
            	                int LA19_0 = input.LA(1);

            	                if ( LA19_0 == 33 && getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1(), 0) ) {
            	                    alt19=1;
            	                }
            	                else if ( LA19_0 == RULE_INT && getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1(), 1) ) {
            	                    alt19=2;
            	                }


            	                switch (alt19) {
            	            	case 1 :
            	            	    // InternalXHDL.g:1490:10: ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) )
            	            	    {
            	            	    // InternalXHDL.g:1490:10: ({...}? => ( ({...}? => (otherlv_4= '=' ) ) ) )
            	            	    // InternalXHDL.g:1491:11: {...}? => ( ({...}? => (otherlv_4= '=' ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1(), 0) ) {
            	            	        throw new FailedPredicateException(input, "ruleXUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1(), 0)");
            	            	    }
            	            	    // InternalXHDL.g:1491:112: ( ({...}? => (otherlv_4= '=' ) ) )
            	            	    // InternalXHDL.g:1492:12: ({...}? => (otherlv_4= '=' ) )
            	            	    {

            	            	    												getUnorderedGroupHelper().select(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1(), 0);
            	            	    											
            	            	    // InternalXHDL.g:1495:15: ({...}? => (otherlv_4= '=' ) )
            	            	    // InternalXHDL.g:1495:16: {...}? => (otherlv_4= '=' )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleXUnit", "true");
            	            	    }
            	            	    // InternalXHDL.g:1495:25: (otherlv_4= '=' )
            	            	    // InternalXHDL.g:1495:26: otherlv_4= '='
            	            	    {
            	            	    otherlv_4=(Token)match(input,33,FOLLOW_27); 

            	            	    															newLeafNode(otherlv_4, grammarAccess.getXUnitAccess().getEqualsSignKeyword_1_0_1_0());
            	            	    														

            	            	    }


            	            	    }

            	            	     
            	            	    												getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1());
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;
            	            	case 2 :
            	            	    // InternalXHDL.g:1505:10: ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) )
            	            	    {
            	            	    // InternalXHDL.g:1505:10: ({...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) ) )
            	            	    // InternalXHDL.g:1506:11: {...}? => ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) )
            	            	    {
            	            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1(), 1) ) {
            	            	        throw new FailedPredicateException(input, "ruleXUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1(), 1)");
            	            	    }
            	            	    // InternalXHDL.g:1506:112: ( ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) ) )
            	            	    // InternalXHDL.g:1507:12: ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) )
            	            	    {

            	            	    												getUnorderedGroupHelper().select(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1(), 1);
            	            	    											
            	            	    // InternalXHDL.g:1510:15: ({...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) ) )
            	            	    // InternalXHDL.g:1510:16: {...}? => ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) )
            	            	    {
            	            	    if ( !((true)) ) {
            	            	        throw new FailedPredicateException(input, "ruleXUnit", "true");
            	            	    }
            	            	    // InternalXHDL.g:1510:25: ( ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) ) )
            	            	    // InternalXHDL.g:1510:26: ( (lv_xvalue_5_0= RULE_INT ) ) ( (lv_xbased_6_0= ruleXUnitRef ) )
            	            	    {
            	            	    // InternalXHDL.g:1510:26: ( (lv_xvalue_5_0= RULE_INT ) )
            	            	    // InternalXHDL.g:1511:16: (lv_xvalue_5_0= RULE_INT )
            	            	    {
            	            	    // InternalXHDL.g:1511:16: (lv_xvalue_5_0= RULE_INT )
            	            	    // InternalXHDL.g:1512:17: lv_xvalue_5_0= RULE_INT
            	            	    {
            	            	    lv_xvalue_5_0=(Token)match(input,RULE_INT,FOLLOW_4); 

            	            	    																	newLeafNode(lv_xvalue_5_0, grammarAccess.getXUnitAccess().getXvalueINTTerminalRuleCall_1_0_1_1_0_0());
            	            	    																

            	            	    																	if (current==null) {
            	            	    																		current = createModelElement(grammarAccess.getXUnitRule());
            	            	    																	}
            	            	    																	setWithLastConsumed(
            	            	    																		current,
            	            	    																		"xvalue",
            	            	    																		lv_xvalue_5_0,
            	            	    																		"org.eclipse.xtext.common.Terminals.INT");
            	            	    																

            	            	    }


            	            	    }

            	            	    // InternalXHDL.g:1528:15: ( (lv_xbased_6_0= ruleXUnitRef ) )
            	            	    // InternalXHDL.g:1529:16: (lv_xbased_6_0= ruleXUnitRef )
            	            	    {
            	            	    // InternalXHDL.g:1529:16: (lv_xbased_6_0= ruleXUnitRef )
            	            	    // InternalXHDL.g:1530:17: lv_xbased_6_0= ruleXUnitRef
            	            	    {

            	            	    																	newCompositeNode(grammarAccess.getXUnitAccess().getXbasedXUnitRefParserRuleCall_1_0_1_1_1_0());
            	            	    																
            	            	    pushFollow(FOLLOW_27);
            	            	    lv_xbased_6_0=ruleXUnitRef();

            	            	    state._fsp--;


            	            	    																	if (current==null) {
            	            	    																		current = createModelElementForParent(grammarAccess.getXUnitRule());
            	            	    																	}
            	            	    																	set(
            	            	    																		current,
            	            	    																		"xbased",
            	            	    																		lv_xbased_6_0,
            	            	    																		"xproject.XHDL.XUnitRef");
            	            	    																	afterParserOrEnumRuleCall();
            	            	    																

            	            	    }


            	            	    }


            	            	    }


            	            	    }

            	            	     
            	            	    												getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1());
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    if ( cnt19 >= 1 ) break loop19;
            	                        EarlyExitException eee =
            	                            new EarlyExitException(19, input);
            	                        throw eee;
            	                }
            	                cnt19++;
            	            } while (true);

            	            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1()) ) {
            	                throw new FailedPredicateException(input, "ruleXUnit", "getUnorderedGroupHelper().canLeave(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1())");
            	            }

            	            }


            	            }

            	             
            	            										  getUnorderedGroupHelper().leave(grammarAccess.getXUnitAccess().getUnorderedGroup_1_0_1());
            	            										

            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXUnitAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:1567:4: ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) )
            	    {
            	    // InternalXHDL.g:1567:4: ({...}? => ( ({...}? => (otherlv_7= ';' ) ) ) )
            	    // InternalXHDL.g:1568:5: {...}? => ( ({...}? => (otherlv_7= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXUnit", "getUnorderedGroupHelper().canSelect(grammarAccess.getXUnitAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalXHDL.g:1568:102: ( ({...}? => (otherlv_7= ';' ) ) )
            	    // InternalXHDL.g:1569:6: ({...}? => (otherlv_7= ';' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXUnitAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // InternalXHDL.g:1572:9: ({...}? => (otherlv_7= ';' ) )
            	    // InternalXHDL.g:1572:10: {...}? => (otherlv_7= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXUnit", "true");
            	    }
            	    // InternalXHDL.g:1572:19: (otherlv_7= ';' )
            	    // InternalXHDL.g:1572:20: otherlv_7= ';'
            	    {
            	    otherlv_7=(Token)match(input,17,FOLLOW_8); 

            	    									newLeafNode(otherlv_7, grammarAccess.getXUnitAccess().getSemicolonKeyword_1_1());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXUnitAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXUnitAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleXUnit", "getUnorderedGroupHelper().canLeave(grammarAccess.getXUnitAccess().getUnorderedGroup_1())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getXUnitAccess().getUnorderedGroup_1());
            				

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
    // $ANTLR end "ruleXUnit"


    // $ANTLR start "entryRuleXEnums"
    // InternalXHDL.g:1594:1: entryRuleXEnums returns [EObject current=null] : iv_ruleXEnums= ruleXEnums EOF ;
    public final EObject entryRuleXEnums() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXEnums = null;


        try {
            // InternalXHDL.g:1594:47: (iv_ruleXEnums= ruleXEnums EOF )
            // InternalXHDL.g:1595:2: iv_ruleXEnums= ruleXEnums EOF
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
    // InternalXHDL.g:1601:1: ruleXEnums returns [EObject current=null] : ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?) ) ) ) ;
    public final EObject ruleXEnums() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_xenums_5_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:1607:2: ( ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?) ) ) ) )
            // InternalXHDL.g:1608:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?) ) ) )
            {
            // InternalXHDL.g:1608:2: ( () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?) ) ) )
            // InternalXHDL.g:1609:3: () ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?) ) )
            {
            // InternalXHDL.g:1609:3: ()
            // InternalXHDL.g:1610:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXEnumsAccess().getXEnumsAction_0(),
            					current);
            			

            }

            // InternalXHDL.g:1616:3: ( ( ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:1617:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:1617:4: ( ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:1618:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getXEnumsAccess().getUnorderedGroup_1());
            				
            // InternalXHDL.g:1621:5: ( ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:1622:6: ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:1622:6: ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=4;
                alt24 = dfa24.predict(input);
                switch (alt24) {
            	case 1 :
            	    // InternalXHDL.g:1623:4: ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) )
            	    {
            	    // InternalXHDL.g:1623:4: ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) )
            	    // InternalXHDL.g:1624:5: {...}? => ( ({...}? => (otherlv_2= '(' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXEnums", "getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 0)");
            	    }
            	    // InternalXHDL.g:1624:103: ( ({...}? => (otherlv_2= '(' ) ) )
            	    // InternalXHDL.g:1625:6: ({...}? => (otherlv_2= '(' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 0);
            	    					
            	    // InternalXHDL.g:1628:9: ({...}? => (otherlv_2= '(' ) )
            	    // InternalXHDL.g:1628:10: {...}? => (otherlv_2= '(' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXEnums", "true");
            	    }
            	    // InternalXHDL.g:1628:19: (otherlv_2= '(' )
            	    // InternalXHDL.g:1628:20: otherlv_2= '('
            	    {
            	    otherlv_2=(Token)match(input,25,FOLLOW_28); 

            	    									newLeafNode(otherlv_2, grammarAccess.getXEnumsAccess().getLeftParenthesisKeyword_1_0());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXEnumsAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:1638:4: ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) )
            	    {
            	    // InternalXHDL.g:1638:4: ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) )
            	    // InternalXHDL.g:1639:5: {...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXEnums", "getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 1)");
            	    }
            	    // InternalXHDL.g:1639:103: ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ )
            	    // InternalXHDL.g:1640:6: ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 1);
            	    					
            	    // InternalXHDL.g:1643:9: ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+
            	    int cnt23=0;
            	    loop23:
            	    do {
            	        int alt23=2;
            	        switch ( input.LA(1) ) {
            	        case 34:
            	            {
            	            int LA23_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt23=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA23_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt23=1;
            	            }


            	            }
            	            break;
            	        case RULE_STRING:
            	            {
            	            int LA23_4 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt23=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt23) {
            	    	case 1 :
            	    	    // InternalXHDL.g:1643:10: {...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleXEnums", "true");
            	    	    }
            	    	    // InternalXHDL.g:1643:19: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) )
            	    	    // InternalXHDL.g:1643:20: ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) )
            	    	    {
            	    	    // InternalXHDL.g:1643:20: ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) )
            	    	    // InternalXHDL.g:1644:10: ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?)
            	    	    {
            	    	     
            	    	    									  getUnorderedGroupHelper().enter(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1());
            	    	    									
            	    	    // InternalXHDL.g:1647:10: ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?)
            	    	    // InternalXHDL.g:1648:11: ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?
            	    	    {
            	    	    // InternalXHDL.g:1648:11: ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+
            	    	    int cnt22=0;
            	    	    loop22:
            	    	    do {
            	    	        int alt22=3;
            	    	        switch ( input.LA(1) ) {
            	    	        case 34:
            	    	            {
            	    	            int LA22_2 = input.LA(2);

            	    	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 0) ) {
            	    	                alt22=1;
            	    	            }


            	    	            }
            	    	            break;
            	    	        case RULE_ID:
            	    	            {
            	    	            int LA22_3 = input.LA(2);

            	    	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 1) ) {
            	    	                alt22=2;
            	    	            }


            	    	            }
            	    	            break;
            	    	        case RULE_STRING:
            	    	            {
            	    	            int LA22_4 = input.LA(2);

            	    	            if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 1) ) {
            	    	                alt22=2;
            	    	            }


            	    	            }
            	    	            break;

            	    	        }

            	    	        switch (alt22) {
            	    	    	case 1 :
            	    	    	    // InternalXHDL.g:1649:9: ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) )
            	    	    	    {
            	    	    	    // InternalXHDL.g:1649:9: ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) )
            	    	    	    // InternalXHDL.g:1650:10: {...}? => ( ({...}? => (otherlv_4= ',' ) ) )
            	    	    	    {
            	    	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 0) ) {
            	    	    	        throw new FailedPredicateException(input, "ruleXEnums", "getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 0)");
            	    	    	    }
            	    	    	    // InternalXHDL.g:1650:110: ( ({...}? => (otherlv_4= ',' ) ) )
            	    	    	    // InternalXHDL.g:1651:11: ({...}? => (otherlv_4= ',' ) )
            	    	    	    {

            	    	    	    											getUnorderedGroupHelper().select(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 0);
            	    	    	    										
            	    	    	    // InternalXHDL.g:1654:14: ({...}? => (otherlv_4= ',' ) )
            	    	    	    // InternalXHDL.g:1654:15: {...}? => (otherlv_4= ',' )
            	    	    	    {
            	    	    	    if ( !((true)) ) {
            	    	    	        throw new FailedPredicateException(input, "ruleXEnums", "true");
            	    	    	    }
            	    	    	    // InternalXHDL.g:1654:24: (otherlv_4= ',' )
            	    	    	    // InternalXHDL.g:1654:25: otherlv_4= ','
            	    	    	    {
            	    	    	    otherlv_4=(Token)match(input,34,FOLLOW_28); 

            	    	    	    														newLeafNode(otherlv_4, grammarAccess.getXEnumsAccess().getCommaKeyword_1_1_0());
            	    	    	    													

            	    	    	    }


            	    	    	    }

            	    	    	     
            	    	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1());
            	    	    	    										

            	    	    	    }


            	    	    	    }


            	    	    	    }
            	    	    	    break;
            	    	    	case 2 :
            	    	    	    // InternalXHDL.g:1664:9: ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) )
            	    	    	    {
            	    	    	    // InternalXHDL.g:1664:9: ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) )
            	    	    	    // InternalXHDL.g:1665:10: {...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) )
            	    	    	    {
            	    	    	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 1) ) {
            	    	    	        throw new FailedPredicateException(input, "ruleXEnums", "getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 1)");
            	    	    	    }
            	    	    	    // InternalXHDL.g:1665:110: ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) )
            	    	    	    // InternalXHDL.g:1666:11: ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) )
            	    	    	    {

            	    	    	    											getUnorderedGroupHelper().select(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1(), 1);
            	    	    	    										
            	    	    	    // InternalXHDL.g:1669:14: ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) )
            	    	    	    // InternalXHDL.g:1669:15: {...}? => ( (lv_xenums_5_0= ruleXEnum ) )
            	    	    	    {
            	    	    	    if ( !((true)) ) {
            	    	    	        throw new FailedPredicateException(input, "ruleXEnums", "true");
            	    	    	    }
            	    	    	    // InternalXHDL.g:1669:24: ( (lv_xenums_5_0= ruleXEnum ) )
            	    	    	    // InternalXHDL.g:1669:25: (lv_xenums_5_0= ruleXEnum )
            	    	    	    {
            	    	    	    // InternalXHDL.g:1669:25: (lv_xenums_5_0= ruleXEnum )
            	    	    	    // InternalXHDL.g:1670:15: lv_xenums_5_0= ruleXEnum
            	    	    	    {

            	    	    	    															newCompositeNode(grammarAccess.getXEnumsAccess().getXenumsXEnumParserRuleCall_1_1_1_0());
            	    	    	    														
            	    	    	    pushFollow(FOLLOW_28);
            	    	    	    lv_xenums_5_0=ruleXEnum();

            	    	    	    state._fsp--;


            	    	    	    															if (current==null) {
            	    	    	    																current = createModelElementForParent(grammarAccess.getXEnumsRule());
            	    	    	    															}
            	    	    	    															add(
            	    	    	    																current,
            	    	    	    																"xenums",
            	    	    	    																lv_xenums_5_0,
            	    	    	    																"xproject.XHDL.XEnum");
            	    	    	    															afterParserOrEnumRuleCall();
            	    	    	    														

            	    	    	    }


            	    	    	    }


            	    	    	    }

            	    	    	     
            	    	    	    											getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1());
            	    	    	    										

            	    	    	    }


            	    	    	    }


            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    if ( cnt22 >= 1 ) break loop22;
            	    	                EarlyExitException eee =
            	    	                    new EarlyExitException(22, input);
            	    	                throw eee;
            	    	        }
            	    	        cnt22++;
            	    	    } while (true);

            	    	    if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1()) ) {
            	    	        throw new FailedPredicateException(input, "ruleXEnums", "getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1())");
            	    	    }

            	    	    }


            	    	    }

            	    	     
            	    	    									  getUnorderedGroupHelper().leave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1_1());
            	    	    									

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt23 >= 1 ) break loop23;
            	                EarlyExitException eee =
            	                    new EarlyExitException(23, input);
            	                throw eee;
            	        }
            	        cnt23++;
            	    } while (true);

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXEnumsAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalXHDL.g:1705:4: ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) )
            	    {
            	    // InternalXHDL.g:1705:4: ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) )
            	    // InternalXHDL.g:1706:5: {...}? => ( ({...}? => (otherlv_6= ')' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleXEnums", "getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 2)");
            	    }
            	    // InternalXHDL.g:1706:103: ( ({...}? => (otherlv_6= ')' ) ) )
            	    // InternalXHDL.g:1707:6: ({...}? => (otherlv_6= ')' ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 2);
            	    					
            	    // InternalXHDL.g:1710:9: ({...}? => (otherlv_6= ')' ) )
            	    // InternalXHDL.g:1710:10: {...}? => (otherlv_6= ')' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXEnums", "true");
            	    }
            	    // InternalXHDL.g:1710:19: (otherlv_6= ')' )
            	    // InternalXHDL.g:1710:20: otherlv_6= ')'
            	    {
            	    otherlv_6=(Token)match(input,28,FOLLOW_28); 

            	    									newLeafNode(otherlv_6, grammarAccess.getXEnumsAccess().getRightParenthesisKeyword_1_2());
            	    								

            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXEnumsAccess().getUnorderedGroup_1());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1()) ) {
                throw new FailedPredicateException(input, "ruleXEnums", "getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1());
            				

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
    // $ANTLR end "ruleXEnums"


    // $ANTLR start "entryRuleXFunctionRef"
    // InternalXHDL.g:1732:1: entryRuleXFunctionRef returns [EObject current=null] : iv_ruleXFunctionRef= ruleXFunctionRef EOF ;
    public final EObject entryRuleXFunctionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionRef = null;


        try {
            // InternalXHDL.g:1732:53: (iv_ruleXFunctionRef= ruleXFunctionRef EOF )
            // InternalXHDL.g:1733:2: iv_ruleXFunctionRef= ruleXFunctionRef EOF
            {
             newCompositeNode(grammarAccess.getXFunctionRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXFunctionRef=ruleXFunctionRef();

            state._fsp--;

             current =iv_ruleXFunctionRef; 
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
    // $ANTLR end "entryRuleXFunctionRef"


    // $ANTLR start "ruleXFunctionRef"
    // InternalXHDL.g:1739:1: ruleXFunctionRef returns [EObject current=null] : ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'return' ( (lv_xreturn_4_0= ruleXTypeRef ) ) ) ;
    public final EObject ruleXFunctionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        EObject lv_xreturn_4_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:1745:2: ( ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'return' ( (lv_xreturn_4_0= ruleXTypeRef ) ) ) )
            // InternalXHDL.g:1746:2: ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'return' ( (lv_xreturn_4_0= ruleXTypeRef ) ) )
            {
            // InternalXHDL.g:1746:2: ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'return' ( (lv_xreturn_4_0= ruleXTypeRef ) ) )
            // InternalXHDL.g:1747:3: () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'return' ( (lv_xreturn_4_0= ruleXTypeRef ) )
            {
            // InternalXHDL.g:1747:3: ()
            // InternalXHDL.g:1748:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getXFunctionRefAccess().getXFunctionRefAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,35,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getXFunctionRefAccess().getFunctionKeyword_1());
            		
            // InternalXHDL.g:1758:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalXHDL.g:1759:4: (lv_name_2_0= RULE_ID )
            {
            // InternalXHDL.g:1759:4: (lv_name_2_0= RULE_ID )
            // InternalXHDL.g:1760:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(lv_name_2_0, grammarAccess.getXFunctionRefAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getXFunctionRefRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,36,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getXFunctionRefAccess().getReturnKeyword_3());
            		
            // InternalXHDL.g:1780:3: ( (lv_xreturn_4_0= ruleXTypeRef ) )
            // InternalXHDL.g:1781:4: (lv_xreturn_4_0= ruleXTypeRef )
            {
            // InternalXHDL.g:1781:4: (lv_xreturn_4_0= ruleXTypeRef )
            // InternalXHDL.g:1782:5: lv_xreturn_4_0= ruleXTypeRef
            {

            					newCompositeNode(grammarAccess.getXFunctionRefAccess().getXreturnXTypeRefParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_xreturn_4_0=ruleXTypeRef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getXFunctionRefRule());
            					}
            					set(
            						current,
            						"xreturn",
            						lv_xreturn_4_0,
            						"xproject.XHDL.XTypeRef");
            					afterParserOrEnumRuleCall();
            				

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
    // $ANTLR end "ruleXFunctionRef"


    // $ANTLR start "entryRuleXImpure"
    // InternalXHDL.g:1803:1: entryRuleXImpure returns [EObject current=null] : iv_ruleXImpure= ruleXImpure EOF ;
    public final EObject entryRuleXImpure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImpure = null;


        try {
            // InternalXHDL.g:1803:48: (iv_ruleXImpure= ruleXImpure EOF )
            // InternalXHDL.g:1804:2: iv_ruleXImpure= ruleXImpure EOF
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
    // InternalXHDL.g:1810:1: ruleXImpure returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleXImpure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_xfunc_2_0 = null;



        	enterRule();

        try {
            // InternalXHDL.g:1816:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?) ) ) )
            // InternalXHDL.g:1817:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?) ) )
            {
            // InternalXHDL.g:1817:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?) ) )
            // InternalXHDL.g:1818:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?) )
            {
            // InternalXHDL.g:1818:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?) )
            // InternalXHDL.g:1819:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getXImpureAccess().getUnorderedGroup());
            			
            // InternalXHDL.g:1822:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?)
            // InternalXHDL.g:1823:5: ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+ {...}?
            {
            // InternalXHDL.g:1823:5: ( ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=3;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==37) ) {
                    int LA25_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXImpureAccess().getUnorderedGroup(), 0) ) {
                        alt25=1;
                    }


                }
                else if ( (LA25_0==17) ) {
                    int LA25_3 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXImpureAccess().getUnorderedGroup(), 1) ) {
                        alt25=2;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // InternalXHDL.g:1824:3: ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) )
            	    {
            	    // InternalXHDL.g:1824:3: ({...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) ) )
            	    // InternalXHDL.g:1825:4: {...}? => ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXImpureAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleXImpure", "getUnorderedGroupHelper().canSelect(grammarAccess.getXImpureAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalXHDL.g:1825:101: ( ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) ) )
            	    // InternalXHDL.g:1826:5: ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getXImpureAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalXHDL.g:1829:8: ({...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) ) )
            	    // InternalXHDL.g:1829:9: {...}? => (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXImpure", "true");
            	    }
            	    // InternalXHDL.g:1829:18: (otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) ) )
            	    // InternalXHDL.g:1829:19: otherlv_1= 'impure' ( (lv_xfunc_2_0= ruleXFunctionRef ) )
            	    {
            	    otherlv_1=(Token)match(input,37,FOLLOW_30); 

            	    								newLeafNode(otherlv_1, grammarAccess.getXImpureAccess().getImpureKeyword_0_0());
            	    							
            	    // InternalXHDL.g:1833:8: ( (lv_xfunc_2_0= ruleXFunctionRef ) )
            	    // InternalXHDL.g:1834:9: (lv_xfunc_2_0= ruleXFunctionRef )
            	    {
            	    // InternalXHDL.g:1834:9: (lv_xfunc_2_0= ruleXFunctionRef )
            	    // InternalXHDL.g:1835:10: lv_xfunc_2_0= ruleXFunctionRef
            	    {

            	    										newCompositeNode(grammarAccess.getXImpureAccess().getXfuncXFunctionRefParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_31);
            	    lv_xfunc_2_0=ruleXFunctionRef();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getXImpureRule());
            	    										}
            	    										set(
            	    											current,
            	    											"xfunc",
            	    											lv_xfunc_2_0,
            	    											"xproject.XHDL.XFunctionRef");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXImpureAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalXHDL.g:1858:3: ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) )
            	    {
            	    // InternalXHDL.g:1858:3: ({...}? => ( ({...}? => (otherlv_3= ';' ) ) ) )
            	    // InternalXHDL.g:1859:4: {...}? => ( ({...}? => (otherlv_3= ';' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getXImpureAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleXImpure", "getUnorderedGroupHelper().canSelect(grammarAccess.getXImpureAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalXHDL.g:1859:101: ( ({...}? => (otherlv_3= ';' ) ) )
            	    // InternalXHDL.g:1860:5: ({...}? => (otherlv_3= ';' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getXImpureAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalXHDL.g:1863:8: ({...}? => (otherlv_3= ';' ) )
            	    // InternalXHDL.g:1863:9: {...}? => (otherlv_3= ';' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleXImpure", "true");
            	    }
            	    // InternalXHDL.g:1863:18: (otherlv_3= ';' )
            	    // InternalXHDL.g:1863:19: otherlv_3= ';'
            	    {
            	    otherlv_3=(Token)match(input,17,FOLLOW_31); 

            	    								newLeafNode(otherlv_3, grammarAccess.getXImpureAccess().getSemicolonKeyword_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getXImpureAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getXImpureAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleXImpure", "getUnorderedGroupHelper().canLeave(grammarAccess.getXImpureAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getXImpureAccess().getUnorderedGroup());
            			

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


    // $ANTLR start "entryRuleXEnum"
    // InternalXHDL.g:1884:1: entryRuleXEnum returns [String current=null] : iv_ruleXEnum= ruleXEnum EOF ;
    public final String entryRuleXEnum() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXEnum = null;


        try {
            // InternalXHDL.g:1884:45: (iv_ruleXEnum= ruleXEnum EOF )
            // InternalXHDL.g:1885:2: iv_ruleXEnum= ruleXEnum EOF
            {
             newCompositeNode(grammarAccess.getXEnumRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXEnum=ruleXEnum();

            state._fsp--;

             current =iv_ruleXEnum.getText(); 
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
    // $ANTLR end "entryRuleXEnum"


    // $ANTLR start "ruleXEnum"
    // InternalXHDL.g:1891:1: ruleXEnum returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) ;
    public final AntlrDatatypeRuleToken ruleXEnum() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_STRING_1=null;


        	enterRule();

        try {
            // InternalXHDL.g:1897:2: ( (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING ) )
            // InternalXHDL.g:1898:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            {
            // InternalXHDL.g:1898:2: (this_ID_0= RULE_ID | this_STRING_1= RULE_STRING )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            else if ( (LA26_0==RULE_STRING) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalXHDL.g:1899:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getXEnumAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalXHDL.g:1907:3: this_STRING_1= RULE_STRING
                    {
                    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_1);
                    		

                    			newLeafNode(this_STRING_1, grammarAccess.getXEnumAccess().getSTRINGTerminalRuleCall_1());
                    		

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
    // $ANTLR end "ruleXEnum"

    // Delegated rules


    protected DFA24 dfa24 = new DFA24(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\1\1\11\uffff";
    static final String dfa_3s = "\1\4\1\uffff\5\0\3\uffff";
    static final String dfa_4s = "\1\45\1\uffff\5\0\3\uffff";
    static final String dfa_5s = "\1\uffff\1\4\5\uffff\1\1\1\2\1\3";
    static final String dfa_6s = "\2\uffff\1\2\1\0\1\3\1\1\1\4\3\uffff}>";
    static final String[] dfa_7s = {
            "\1\4\3\uffff\1\5\7\uffff\3\1\1\uffff\2\1\1\uffff\2\1\1\2\1\1\1\uffff\1\6\5\uffff\1\3\2\uffff\1\1",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 1622:6: ( ({...}? => ( ({...}? => (otherlv_2= '(' ) ) ) ) | ({...}? => ( ({...}? => ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= ',' ) ) ) ) | ({...}? => ( ({...}? => ( (lv_xenums_5_0= ruleXEnum ) ) ) ) ) )+ {...}?) ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_6= ')' ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_3 = input.LA(1);

                         
                        int index24_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 1) ) {s = 8;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1()) ) {s = 1;}

                         
                        input.seek(index24_3);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA24_5 = input.LA(1);

                         
                        int index24_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 1) ) {s = 8;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1()) ) {s = 1;}

                         
                        input.seek(index24_5);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA24_2 = input.LA(1);

                         
                        int index24_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 0) ) {s = 7;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1()) ) {s = 1;}

                         
                        input.seek(index24_2);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA24_4 = input.LA(1);

                         
                        int index24_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 1) ) {s = 8;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1()) ) {s = 1;}

                         
                        input.seek(index24_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA24_6 = input.LA(1);

                         
                        int index24_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getXEnumsAccess().getUnorderedGroup_1(), 2) ) {s = 9;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getXEnumsAccess().getUnorderedGroup_1()) ) {s = 1;}

                         
                        input.seek(index24_6);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000002000B70000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020012L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000A0012L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004020012L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000004A0010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000004A0012L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000417020110L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000417020112L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000012000010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000032000010L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000030010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200020092L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000412000112L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000002000020002L});

}
