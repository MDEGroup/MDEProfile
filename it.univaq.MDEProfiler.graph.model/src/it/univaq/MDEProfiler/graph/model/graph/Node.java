/**
 */
package it.univaq.MDEProfiler.graph.model.graph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Node#getFilePath <em>File Path</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Node#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends Named {
	/**
	 * Returns the value of the '<em><b>File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Path</em>' attribute.
	 * @see #setFilePath(String)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getNode_FilePath()
	 * @model required="true"
	 * @generated
	 */
	String getFilePath();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Node#getFilePath <em>File Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Path</em>' attribute.
	 * @see #getFilePath()
	 * @generated
	 */
	void setFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link it.univaq.MDEProfiler.graph.model.graph.NodeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see it.univaq.MDEProfiler.graph.model.graph.NodeType
	 * @see #setType(NodeType)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getNode_Type()
	 * @model required="true"
	 * @generated
	 */
	NodeType getType();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Node#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see it.univaq.MDEProfiler.graph.model.graph.NodeType
	 * @see #getType()
	 * @generated
	 */
	void setType(NodeType value);

} // Node
