/**
 */
package it.univaq.MDEProfiler.graph.model.graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.Graph#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getGraph()
 * @model
 * @generated
 */
public interface Graph extends Named {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link it.univaq.MDEProfiler.graph.model.graph.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackage#getGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

} // Graph
