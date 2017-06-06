/**
 */
package ghmde;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ghmde.Model#getUsers <em>Users</em>}</li>
 *   <li>{@link ghmde.Model#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link ghmde.Model#getDevelopers <em>Developers</em>}</li>
 * </ul>
 *
 * @see ghmde.GhmdePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject {
	/**
	 * Returns the value of the '<em><b>Users</b></em>' containment reference list.
	 * The list contents are of type {@link ghmde.User}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Users</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Users</em>' containment reference list.
	 * @see ghmde.GhmdePackage#getModel_Users()
	 * @model containment="true"
	 * @generated
	 */
	EList<User> getUsers();

	/**
	 * Returns the value of the '<em><b>Technologies</b></em>' containment reference list.
	 * The list contents are of type {@link ghmde.Technology}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Technologies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technologies</em>' containment reference list.
	 * @see ghmde.GhmdePackage#getModel_Technologies()
	 * @model containment="true"
	 * @generated
	 */
	EList<Technology> getTechnologies();

	/**
	 * Returns the value of the '<em><b>Developers</b></em>' containment reference list.
	 * The list contents are of type {@link ghmde.Developer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Developers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Developers</em>' containment reference list.
	 * @see ghmde.GhmdePackage#getModel_Developers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Developer> getDevelopers();

} // Model
