/*
 * generated by Xtext 2.15.0
 */
package xproject.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import xproject.services.XHDLGrammarAccess;

@SuppressWarnings("all")
public class XHDLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected XHDLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_XUnits___UnitsKeyword_1_EndKeyword_3_UnitsKeyword_4__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (XHDLGrammarAccess) access;
		match_XUnits___UnitsKeyword_1_EndKeyword_3_UnitsKeyword_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXUnitsAccess().getUnitsKeyword_1()), new TokenAlias(false, false, grammarAccess.getXUnitsAccess().getEndKeyword_3()), new TokenAlias(false, false, grammarAccess.getXUnitsAccess().getUnitsKeyword_4()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getXEnumsRule())
			return getXEnumsToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ID: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * terminal INT returns ecore::EInt: ('0'..'9')+;
	 */
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * XEnums:
	 * 	'(' (','? ID)* ')'
	 * ;
	 */
	protected String getXEnumsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "()";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_XUnits___UnitsKeyword_1_EndKeyword_3_UnitsKeyword_4__q.equals(syntax))
				emit_XUnits___UnitsKeyword_1_EndKeyword_3_UnitsKeyword_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ('units' 'end' 'units')?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) 'range' INT 'to' INT (ambiguity) (rule start)
	 */
	protected void emit_XUnits___UnitsKeyword_1_EndKeyword_3_UnitsKeyword_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
