/**
 */
package it.univaq.MDEProfiler.graph.model.graph;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getTarget <em>Target</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Edge#isExact <em>Exact</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getDiscoverBy <em>Discover By</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getPathDiscoveredByHeuristic <em>Path Discovered By Heuristic</em>}</li>
 * </ul>
 *
 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends Named {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getEdge_Source()
	 * @model required="true"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getEdge_Target()
	 * @model required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Exact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exact</em>' attribute.
	 * @see #setExact(boolean)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getEdge_Exact()
	 * @model
	 * @generated
	 */
	boolean isExact();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#isExact <em>Exact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exact</em>' attribute.
	 * @see #isExact()
	 * @generated
	 */
	void setExact(boolean value);

	/**
	 * Returns the value of the '<em><b>Discover By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discover By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discover By</em>' reference.
	 * @see #setDiscoverBy(Node)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getEdge_DiscoverBy()
	 * @model required="true"
	 * @generated
	 */
	Node getDiscoverBy();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getDiscoverBy <em>Discover By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discover By</em>' reference.
	 * @see #getDiscoverBy()
	 * @generated
	 */
	void setDiscoverBy(Node value);

	/**
	 * Returns the value of the '<em><b>Path Discovered By Heuristic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Discovered By Heuristic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Discovered By Heuristic</em>' attribute.
	 * @see #setPathDiscoveredByHeuristic(String)
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getEdge_PathDiscoveredByHeuristic()
	 * @model
	 * @generated
	 */
	String getPathDiscoveredByHeuristic();

	/**
	 * Sets the value of the '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getPathDiscoveredByHeuristic <em>Path Discovered By Heuristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Discovered By Heuristic</em>' attribute.
	 * @see #getPathDiscoveredByHeuristic()
	 * @generated
	 */
	void setPathDiscoveredByHeuristic(String value);

} // Edge
