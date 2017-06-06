/**
 */
package ghmde.impl;

import ghmde.Developer;
import ghmde.GhmdePackage;
import ghmde.Model;
import ghmde.Technology;
import ghmde.User;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ghmde.impl.ModelImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link ghmde.impl.ModelImpl#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link ghmde.impl.ModelImpl#getDevelopers <em>Developers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends MinimalEObjectImpl.Container implements Model {
	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<User> users;

	/**
	 * The cached value of the '{@link #getTechnologies() <em>Technologies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnologies()
	 * @generated
	 * @ordered
	 */
	protected EList<Technology> technologies;

	/**
	 * The cached value of the '{@link #getDevelopers() <em>Developers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevelopers()
	 * @generated
	 * @ordered
	 */
	protected EList<Developer> developers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GhmdePackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<User> getUsers() {
		if (users == null) {
			users = new EObjectContainmentEList<User>(User.class, this, GhmdePackage.MODEL__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Technology> getTechnologies() {
		if (technologies == null) {
			technologies = new EObjectContainmentEList<Technology>(Technology.class, this, GhmdePackage.MODEL__TECHNOLOGIES);
		}
		return technologies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Developer> getDevelopers() {
		if (developers == null) {
			developers = new EObjectContainmentEList<Developer>(Developer.class, this, GhmdePackage.MODEL__DEVELOPERS);
		}
		return developers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GhmdePackage.MODEL__USERS:
				return ((InternalEList<?>)getUsers()).basicRemove(otherEnd, msgs);
			case GhmdePackage.MODEL__TECHNOLOGIES:
				return ((InternalEList<?>)getTechnologies()).basicRemove(otherEnd, msgs);
			case GhmdePackage.MODEL__DEVELOPERS:
				return ((InternalEList<?>)getDevelopers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GhmdePackage.MODEL__USERS:
				return getUsers();
			case GhmdePackage.MODEL__TECHNOLOGIES:
				return getTechnologies();
			case GhmdePackage.MODEL__DEVELOPERS:
				return getDevelopers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GhmdePackage.MODEL__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends User>)newValue);
				return;
			case GhmdePackage.MODEL__TECHNOLOGIES:
				getTechnologies().clear();
				getTechnologies().addAll((Collection<? extends Technology>)newValue);
				return;
			case GhmdePackage.MODEL__DEVELOPERS:
				getDevelopers().clear();
				getDevelopers().addAll((Collection<? extends Developer>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case GhmdePackage.MODEL__USERS:
				getUsers().clear();
				return;
			case GhmdePackage.MODEL__TECHNOLOGIES:
				getTechnologies().clear();
				return;
			case GhmdePackage.MODEL__DEVELOPERS:
				getDevelopers().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GhmdePackage.MODEL__USERS:
				return users != null && !users.isEmpty();
			case GhmdePackage.MODEL__TECHNOLOGIES:
				return technologies != null && !technologies.isEmpty();
			case GhmdePackage.MODEL__DEVELOPERS:
				return developers != null && !developers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelImpl
