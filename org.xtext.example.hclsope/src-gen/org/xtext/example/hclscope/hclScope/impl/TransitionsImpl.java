/**
 * generated by Xtext 2.25.0
 */
package org.xtext.example.hclscope.hclScope.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.hclscope.hclScope.HclScopePackage;
import org.xtext.example.hclscope.hclScope.TransitionBody;
import org.xtext.example.hclscope.hclScope.Transitions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.hclscope.hclScope.impl.TransitionsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.hclscope.hclScope.impl.TransitionsImpl#getTransitionbody <em>Transitionbody</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionsImpl extends MinimalEObjectImpl.Container implements Transitions
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
	 * The cached value of the '{@link #getTransitionbody() <em>Transitionbody</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTransitionbody()
	 * @generated
	 * @ordered
	 */
  protected TransitionBody transitionbody;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TransitionsImpl()
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
		return HclScopePackage.Literals.TRANSITIONS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String getName()
  {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setName(String newName)
  {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HclScopePackage.TRANSITIONS__NAME, oldName, name));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public TransitionBody getTransitionbody()
  {
		return transitionbody;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTransitionbody(TransitionBody newTransitionbody, NotificationChain msgs)
  {
		TransitionBody oldTransitionbody = transitionbody;
		transitionbody = newTransitionbody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, HclScopePackage.TRANSITIONS__TRANSITIONBODY, oldTransitionbody, newTransitionbody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void setTransitionbody(TransitionBody newTransitionbody)
  {
		if (newTransitionbody != transitionbody) {
			NotificationChain msgs = null;
			if (transitionbody != null)
				msgs = ((InternalEObject)transitionbody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - HclScopePackage.TRANSITIONS__TRANSITIONBODY, null, msgs);
			if (newTransitionbody != null)
				msgs = ((InternalEObject)newTransitionbody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - HclScopePackage.TRANSITIONS__TRANSITIONBODY, null, msgs);
			msgs = basicSetTransitionbody(newTransitionbody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HclScopePackage.TRANSITIONS__TRANSITIONBODY, newTransitionbody, newTransitionbody));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case HclScopePackage.TRANSITIONS__TRANSITIONBODY:
				return basicSetTransitionbody(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case HclScopePackage.TRANSITIONS__NAME:
				return getName();
			case HclScopePackage.TRANSITIONS__TRANSITIONBODY:
				return getTransitionbody();
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
		switch (featureID) {
			case HclScopePackage.TRANSITIONS__NAME:
				setName((String)newValue);
				return;
			case HclScopePackage.TRANSITIONS__TRANSITIONBODY:
				setTransitionbody((TransitionBody)newValue);
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
		switch (featureID) {
			case HclScopePackage.TRANSITIONS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case HclScopePackage.TRANSITIONS__TRANSITIONBODY:
				setTransitionbody((TransitionBody)null);
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
		switch (featureID) {
			case HclScopePackage.TRANSITIONS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case HclScopePackage.TRANSITIONS__TRANSITIONBODY:
				return transitionbody != null;
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

} //TransitionsImpl
