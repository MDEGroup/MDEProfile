/**
 */
package ghmde;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ghmde.Repository#getName <em>Name</em>}</li>
 *   <li>{@link ghmde.Repository#getStargazers <em>Stargazers</em>}</li>
 *   <li>{@link ghmde.Repository#getWatchers <em>Watchers</em>}</li>
 *   <li>{@link ghmde.Repository#getForks <em>Forks</em>}</li>
 *   <li>{@link ghmde.Repository#isFork <em>Fork</em>}</li>
 *   <li>{@link ghmde.Repository#getSize <em>Size</em>}</li>
 *   <li>{@link ghmde.Repository#getFiles <em>Files</em>}</li>
 *   <li>{@link ghmde.Repository#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see ghmde.GhmdePackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ghmde.GhmdePackage#getRepository_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ghmde.Repository#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Stargazers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stargazers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stargazers</em>' attribute.
	 * @see #setStargazers(int)
	 * @see ghmde.GhmdePackage#getRepository_Stargazers()
	 * @model
	 * @generated
	 */
	int getStargazers();

	/**
	 * Sets the value of the '{@link ghmde.Repository#getStargazers <em>Stargazers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stargazers</em>' attribute.
	 * @see #getStargazers()
	 * @generated
	 */
	void setStargazers(int value);

	/**
	 * Returns the value of the '<em><b>Watchers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Watchers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Watchers</em>' attribute.
	 * @see #setWatchers(int)
	 * @see ghmde.GhmdePackage#getRepository_Watchers()
	 * @model
	 * @generated
	 */
	int getWatchers();

	/**
	 * Sets the value of the '{@link ghmde.Repository#getWatchers <em>Watchers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Watchers</em>' attribute.
	 * @see #getWatchers()
	 * @generated
	 */
	void setWatchers(int value);

	/**
	 * Returns the value of the '<em><b>Forks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forks</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forks</em>' attribute.
	 * @see #setForks(int)
	 * @see ghmde.GhmdePackage#getRepository_Forks()
	 * @model
	 * @generated
	 */
	int getForks();

	/**
	 * Sets the value of the '{@link ghmde.Repository#getForks <em>Forks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forks</em>' attribute.
	 * @see #getForks()
	 * @generated
	 */
	void setForks(int value);

	/**
	 * Returns the value of the '<em><b>Fork</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fork</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fork</em>' attribute.
	 * @see #setFork(boolean)
	 * @see ghmde.GhmdePackage#getRepository_Fork()
	 * @model
	 * @generated
	 */
	boolean isFork();

	/**
	 * Sets the value of the '{@link ghmde.Repository#isFork <em>Fork</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fork</em>' attribute.
	 * @see #isFork()
	 * @generated
	 */
	void setFork(boolean value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see ghmde.GhmdePackage#getRepository_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link ghmde.Repository#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * Returns the value of the '<em><b>Files</b></em>' containment reference list.
	 * The list contents are of type {@link ghmde.File}.
	 * It is bidirectional and its opposite is '{@link ghmde.File#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Files</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Files</em>' containment reference list.
	 * @see ghmde.GhmdePackage#getRepository_Files()
	 * @see ghmde.File#getRepository
	 * @model opposite="repository" containment="true"
	 * @generated
	 */
	EList<File> getFiles();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ghmde.User#getRepositories <em>Repositories</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(User)
	 * @see ghmde.GhmdePackage#getRepository_Owner()
	 * @see ghmde.User#getRepositories
	 * @model opposite="repositories" transient="false"
	 * @generated
	 */
	User getOwner();

	/**
	 * Sets the value of the '{@link ghmde.Repository#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(User value);

} // Repository
