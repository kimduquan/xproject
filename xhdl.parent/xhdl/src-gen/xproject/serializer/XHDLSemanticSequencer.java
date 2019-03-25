/*
 * generated by Xtext 2.15.0
 */
package xproject.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import xproject.services.XHDLGrammarAccess;
import xproject.xhdl.XArray;
import xproject.xhdl.XAttribute;
import xproject.xhdl.XEnums;
import xproject.xhdl.XFunctionRef;
import xproject.xhdl.XImpure;
import xproject.xhdl.XPackage;
import xproject.xhdl.XPackageRef;
import xproject.xhdl.XRange;
import xproject.xhdl.XRangeValue;
import xproject.xhdl.XSignal;
import xproject.xhdl.XSubType;
import xproject.xhdl.XType;
import xproject.xhdl.XTypeRef;
import xproject.xhdl.XUnit;
import xproject.xhdl.XUnitRef;
import xproject.xhdl.XUnits;
import xproject.xhdl.XhdlPackage;
import xproject.xhdl.xhdl;

@SuppressWarnings("all")
public class XHDLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private XHDLGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == XhdlPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XhdlPackage.XARRAY:
				sequence_XArray(context, (XArray) semanticObject); 
				return; 
			case XhdlPackage.XATTRIBUTE:
				sequence_XAttribute(context, (XAttribute) semanticObject); 
				return; 
			case XhdlPackage.XENUMS:
				sequence_XEnums(context, (XEnums) semanticObject); 
				return; 
			case XhdlPackage.XFUNCTION_REF:
				sequence_XFunctionRef(context, (XFunctionRef) semanticObject); 
				return; 
			case XhdlPackage.XIMPURE:
				sequence_XImpure(context, (XImpure) semanticObject); 
				return; 
			case XhdlPackage.XPACKAGE:
				sequence_XPackage(context, (XPackage) semanticObject); 
				return; 
			case XhdlPackage.XPACKAGE_REF:
				sequence_XPackageRef(context, (XPackageRef) semanticObject); 
				return; 
			case XhdlPackage.XRANGE:
				sequence_XRange(context, (XRange) semanticObject); 
				return; 
			case XhdlPackage.XRANGE_VALUE:
				sequence_XRangeValue(context, (XRangeValue) semanticObject); 
				return; 
			case XhdlPackage.XSIGNAL:
				sequence_XSignal(context, (XSignal) semanticObject); 
				return; 
			case XhdlPackage.XSUB_TYPE:
				sequence_XSubType(context, (XSubType) semanticObject); 
				return; 
			case XhdlPackage.XTYPE:
				sequence_XType(context, (XType) semanticObject); 
				return; 
			case XhdlPackage.XTYPE_REF:
				sequence_XTypeRef(context, (XTypeRef) semanticObject); 
				return; 
			case XhdlPackage.XUNIT:
				sequence_XUnit(context, (XUnit) semanticObject); 
				return; 
			case XhdlPackage.XUNIT_REF:
				sequence_XUnitRef(context, (XUnitRef) semanticObject); 
				return; 
			case XhdlPackage.XUNITS:
				sequence_XUnits(context, (XUnits) semanticObject); 
				return; 
			case XhdlPackage.XHDL:
				sequence_xhdl(context, (xhdl) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     XArray returns XArray
	 *
	 * Constraint:
	 *     (xrange=[XTypeRef|ID] xof=[XTypeRef|ID])
	 */
	protected void sequence_XArray(ISerializationContext context, XArray semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XARRAY__XRANGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XARRAY__XRANGE));
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XARRAY__XOF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XARRAY__XOF));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXArrayAccess().getXrangeXTypeRefIDTerminalRuleCall_3_0_1(), semanticObject.eGet(XhdlPackage.Literals.XARRAY__XRANGE, false));
		feeder.accept(grammarAccess.getXArrayAccess().getXofXTypeRefIDTerminalRuleCall_8_0_1(), semanticObject.eGet(XhdlPackage.Literals.XARRAY__XOF, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XElement returns XAttribute
	 *     XAttribute returns XAttribute
	 *
	 * Constraint:
	 *     (name=ID xtype=[XTypeRef|ID])
	 */
	protected void sequence_XAttribute(ISerializationContext context, XAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XATTRIBUTE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XATTRIBUTE__NAME));
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XATTRIBUTE__XTYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XATTRIBUTE__XTYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXAttributeAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXAttributeAccess().getXtypeXTypeRefIDTerminalRuleCall_4_0_1(), semanticObject.eGet(XhdlPackage.Literals.XATTRIBUTE__XTYPE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XEnums returns XEnums
	 *
	 * Constraint:
	 *     xenums+=ID*
	 */
	protected void sequence_XEnums(ISerializationContext context, XEnums semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XFunctionRef returns XFunctionRef
	 *
	 * Constraint:
	 *     (name=ID xreturn=[XTypeRef|ID])
	 */
	protected void sequence_XFunctionRef(ISerializationContext context, XFunctionRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XFUNCTION_REF__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XFUNCTION_REF__NAME));
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XFUNCTION_REF__XRETURN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XFUNCTION_REF__XRETURN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXFunctionRefAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXFunctionRefAccess().getXreturnXTypeRefIDTerminalRuleCall_4_0_1(), semanticObject.eGet(XhdlPackage.Literals.XFUNCTION_REF__XRETURN, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XElement returns XImpure
	 *     XImpure returns XImpure
	 *
	 * Constraint:
	 *     xfunc=[XFunctionRef|ID]
	 */
	protected void sequence_XImpure(ISerializationContext context, XImpure semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XIMPURE__XFUNC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XIMPURE__XFUNC));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXImpureAccess().getXfuncXFunctionRefIDTerminalRuleCall_1_0_1(), semanticObject.eGet(XhdlPackage.Literals.XIMPURE__XFUNC, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XPackageRef returns XPackageRef
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_XPackageRef(ISerializationContext context, XPackageRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XPACKAGE_REF__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XPACKAGE_REF__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXPackageRefAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XPackage returns XPackage
	 *
	 * Constraint:
	 *     (name=ID xis+=XElement* xend=[XPackageRef|ID])
	 */
	protected void sequence_XPackage(ISerializationContext context, XPackage semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XRangeValue returns XRangeValue
	 *
	 * Constraint:
	 *     (xvalue=INT xunit=[XUnitRef|ID]?)?
	 */
	protected void sequence_XRangeValue(ISerializationContext context, XRangeValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XRange returns XRange
	 *
	 * Constraint:
	 *     (xfrom=[XRangeValue|ID] xto=[XRangeValue|ID] xunits=XUnits?)
	 */
	protected void sequence_XRange(ISerializationContext context, XRange semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XElement returns XSignal
	 *     XSignal returns XSignal
	 *
	 * Constraint:
	 *     (name=ID xtype=[XTypeRef|ID])
	 */
	protected void sequence_XSignal(ISerializationContext context, XSignal semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XSIGNAL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XSIGNAL__NAME));
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XSIGNAL__XTYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XSIGNAL__XTYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXSignalAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXSignalAccess().getXtypeXTypeRefIDTerminalRuleCall_4_0_1(), semanticObject.eGet(XhdlPackage.Literals.XSIGNAL__XTYPE, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XElement returns XSubType
	 *     XSubType returns XSubType
	 *
	 * Constraint:
	 *     (name=ID xis=[XTypeRef|ID])
	 */
	protected void sequence_XSubType(ISerializationContext context, XSubType semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XSUB_TYPE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XSUB_TYPE__NAME));
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XSUB_TYPE__XIS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XSUB_TYPE__XIS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXSubTypeAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXSubTypeAccess().getXisXTypeRefIDTerminalRuleCall_4_0_1(), semanticObject.eGet(XhdlPackage.Literals.XSUB_TYPE__XIS, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XTypeRef returns XTypeRef
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_XTypeRef(ISerializationContext context, XTypeRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XTYPE_REF__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XTYPE_REF__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXTypeRefAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XElement returns XType
	 *     XType returns XType
	 *
	 * Constraint:
	 *     ((name=ID xenums=XEnums) | xrange=XRange | xarray=XArray)
	 */
	protected void sequence_XType(ISerializationContext context, XType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XUnitRef returns XUnitRef
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_XUnitRef(ISerializationContext context, XUnitRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XhdlPackage.Literals.XUNIT_REF__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XhdlPackage.Literals.XUNIT_REF__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXUnitRefAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XUnit returns XUnit
	 *
	 * Constraint:
	 *     (name=ID (xvalue=INT xbased=[XUnitRef|ID])?)
	 */
	protected void sequence_XUnit(ISerializationContext context, XUnit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XUnits returns XUnits
	 *
	 * Constraint:
	 *     xunits+=XUnit*
	 */
	protected void sequence_XUnits(ISerializationContext context, XUnits semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     xhdl returns xhdl
	 *
	 * Constraint:
	 *     packages+=XPackage+
	 */
	protected void sequence_xhdl(ISerializationContext context, xhdl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
