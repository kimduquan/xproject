/**
 * generated by Xtext 2.15.0
 */
package xproject.xhdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XArray</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xproject.xhdl.XArray#getXrange <em>Xrange</em>}</li>
 *   <li>{@link xproject.xhdl.XArray#getXof <em>Xof</em>}</li>
 * </ul>
 *
 * @see xproject.xhdl.XhdlPackage#getXArray()
 * @model
 * @generated
 */
public interface XArray extends EObject
{
  /**
   * Returns the value of the '<em><b>Xrange</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xrange</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xrange</em>' containment reference.
   * @see #setXrange(XTypeRef)
   * @see xproject.xhdl.XhdlPackage#getXArray_Xrange()
   * @model containment="true"
   * @generated
   */
  XTypeRef getXrange();

  /**
   * Sets the value of the '{@link xproject.xhdl.XArray#getXrange <em>Xrange</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xrange</em>' containment reference.
   * @see #getXrange()
   * @generated
   */
  void setXrange(XTypeRef value);

  /**
   * Returns the value of the '<em><b>Xof</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xof</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xof</em>' containment reference.
   * @see #setXof(XTypeRef)
   * @see xproject.xhdl.XhdlPackage#getXArray_Xof()
   * @model containment="true"
   * @generated
   */
  XTypeRef getXof();

  /**
   * Sets the value of the '{@link xproject.xhdl.XArray#getXof <em>Xof</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xof</em>' containment reference.
   * @see #getXof()
   * @generated
   */
  void setXof(XTypeRef value);

} // XArray
