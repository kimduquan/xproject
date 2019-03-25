/**
 * generated by Xtext 2.15.0
 */
package xproject.xhdl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import xproject.xhdl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XhdlFactoryImpl extends EFactoryImpl implements XhdlFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XhdlFactory init()
  {
    try
    {
      XhdlFactory theXhdlFactory = (XhdlFactory)EPackage.Registry.INSTANCE.getEFactory(XhdlPackage.eNS_URI);
      if (theXhdlFactory != null)
      {
        return theXhdlFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XhdlFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XhdlFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case XhdlPackage.XHDL: return createxhdl();
      case XhdlPackage.XPACKAGE_REF: return createXPackageRef();
      case XhdlPackage.XPACKAGE: return createXPackage();
      case XhdlPackage.XTYPE_REF: return createXTypeRef();
      case XhdlPackage.XELEMENT: return createXElement();
      case XhdlPackage.XATTRIBUTE: return createXAttribute();
      case XhdlPackage.XSUB_TYPE: return createXSubType();
      case XhdlPackage.XSIGNAL: return createXSignal();
      case XhdlPackage.XTYPE: return createXType();
      case XhdlPackage.XARRAY: return createXArray();
      case XhdlPackage.XRANGE: return createXRange();
      case XhdlPackage.XRANGE_VALUE: return createXRangeValue();
      case XhdlPackage.XUNITS: return createXUnits();
      case XhdlPackage.XUNIT_REF: return createXUnitRef();
      case XhdlPackage.XUNIT: return createXUnit();
      case XhdlPackage.XENUMS: return createXEnums();
      case XhdlPackage.XFUNCTION_REF: return createXFunctionRef();
      case XhdlPackage.XIMPURE: return createXImpure();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public xhdl createxhdl()
  {
    xhdlImpl xhdl = new xhdlImpl();
    return xhdl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XPackageRef createXPackageRef()
  {
    XPackageRefImpl xPackageRef = new XPackageRefImpl();
    return xPackageRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XPackage createXPackage()
  {
    XPackageImpl xPackage = new XPackageImpl();
    return xPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XTypeRef createXTypeRef()
  {
    XTypeRefImpl xTypeRef = new XTypeRefImpl();
    return xTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XElement createXElement()
  {
    XElementImpl xElement = new XElementImpl();
    return xElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XAttribute createXAttribute()
  {
    XAttributeImpl xAttribute = new XAttributeImpl();
    return xAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSubType createXSubType()
  {
    XSubTypeImpl xSubType = new XSubTypeImpl();
    return xSubType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSignal createXSignal()
  {
    XSignalImpl xSignal = new XSignalImpl();
    return xSignal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XType createXType()
  {
    XTypeImpl xType = new XTypeImpl();
    return xType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XArray createXArray()
  {
    XArrayImpl xArray = new XArrayImpl();
    return xArray;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XRange createXRange()
  {
    XRangeImpl xRange = new XRangeImpl();
    return xRange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XRangeValue createXRangeValue()
  {
    XRangeValueImpl xRangeValue = new XRangeValueImpl();
    return xRangeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XUnits createXUnits()
  {
    XUnitsImpl xUnits = new XUnitsImpl();
    return xUnits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XUnitRef createXUnitRef()
  {
    XUnitRefImpl xUnitRef = new XUnitRefImpl();
    return xUnitRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XUnit createXUnit()
  {
    XUnitImpl xUnit = new XUnitImpl();
    return xUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XEnums createXEnums()
  {
    XEnumsImpl xEnums = new XEnumsImpl();
    return xEnums;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XFunctionRef createXFunctionRef()
  {
    XFunctionRefImpl xFunctionRef = new XFunctionRefImpl();
    return xFunctionRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XImpure createXImpure()
  {
    XImpureImpl xImpure = new XImpureImpl();
    return xImpure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XhdlPackage getXhdlPackage()
  {
    return (XhdlPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XhdlPackage getPackage()
  {
    return XhdlPackage.eINSTANCE;
  }

} //XhdlFactoryImpl
