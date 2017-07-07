/**
 */
package it.univaq.MDEProfiler.graph.model.graph;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Node#getUri <em>Uri</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Node#getType <em>Type</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Node#isDerivedOrNotExists <em>Derived Or Not Exists</em>}</li>
 * </ul>
 *
 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends Named {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getNode_Uri()
	 * @model required="true"
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Node#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute list.
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getNode_Type()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getType();

	/**
	 * Returns the value of the '<em><b>Derived Or Not Exists</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Or Not Exists</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Or Not Exists</em>' attribute.
	 * @see #setDerivedOrNotExists(boolean)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getNode_DerivedOrNotExists()
	 * @model
	 * @generated
	 */
	boolean isDerivedOrNotExists();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Node#isDerivedOrNotExists <em>Derived Or Not Exists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived Or Not Exists</em>' attribute.
	 * @see #isDerivedOrNotExists()
	 * @generated
	 */
	void setDerivedOrNotExists(boolean value);

} // Node
