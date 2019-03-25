/**
 * generated by Xtext 2.15.0
 */
package xproject.xhdl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import xproject.xhdl.XSubType;
import xproject.xhdl.XTypeRef;
import xproject.xhdl.XhdlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XSub Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link xproject.xhdl.impl.XSubTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link xproject.xhdl.impl.XSubTypeImpl#getXis <em>Xis</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XSubTypeImpl extends XElementImpl implements XSubType
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getXis() <em>Xis</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getXis()
   * @generated
   * @ordered
   */
  protected XTypeRef xis;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XSubTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return XhdlPackage.Literals.XSUB_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XhdlPackage.XSUB_TYPE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XTypeRef getXis()
  {
    if (xis != null && xis.eIsProxy())
    {
      InternalEObject oldXis = (InternalEObject)xis;
      xis = (XTypeRef)eResolveProxy(oldXis);
      if (xis != oldXis)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, XhdlPackage.XSUB_TYPE__XIS, oldXis, xis));
      }
    }
    return xis;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XTypeRef basicGetXis()
  {
    return xis;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setXis(XTypeRef newXis)
  {
    XTypeRef oldXis = xis;
    xis = newXis;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, XhdlPackage.XSUB_TYPE__XIS, oldXis, xis));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case XhdlPackage.XSUB_TYPE__NAME:
        return getName();
      case XhdlPackage.XSUB_TYPE__XIS:
        if (resolve) return getXis();
        return basicGetXis();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case XhdlPackage.XSUB_TYPE__NAME:
        setName((String)newValue);
        return;
      case XhdlPackage.XSUB_TYPE__XIS:
        setXis((XTypeRef)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case XhdlPackage.XSUB_TYPE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case XhdlPackage.XSUB_TYPE__XIS:
        setXis((XTypeRef)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case XhdlPackage.XSUB_TYPE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case XhdlPackage.XSUB_TYPE__XIS:
        return xis != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //XSubTypeImpl
