/**
 * generated by Xtext 2.15.0
 */
package xproject.xhdl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XImpure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link xproject.xhdl.XImpure#getXfunc <em>Xfunc</em>}</li>
 * </ul>
 *
 * @see xproject.xhdl.XhdlPackage#getXImpure()
 * @model
 * @generated
 */
public interface XImpure extends XElement
{
  /**
   * Returns the value of the '<em><b>Xfunc</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Xfunc</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Xfunc</em>' containment reference.
   * @see #setXfunc(XFunction)
   * @see xproject.xhdl.XhdlPackage#getXImpure_Xfunc()
   * @model containment="true"
   * @generated
   */
  XFunction getXfunc();

  /**
   * Sets the value of the '{@link xproject.xhdl.XImpure#getXfunc <em>Xfunc</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Xfunc</em>' containment reference.
   * @see #getXfunc()
   * @generated
   */
  void setXfunc(XFunction value);

} // XImpure
