/**
 */
package it.univaq.MDEProfiler.graph.model.graph;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see it.univaq.MDEProfiler.graph.model.graph.GraphFactory
 * @model kind="package"
 * @generated
 */
public interface GraphPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graph";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://it.univaq.MDEProfiler/graph";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "graph";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphPackage eINSTANCE = it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl.init();

	/**
	 * The meta object id for the '{@link it.univaq.MDEProfiler.graph.model.graph.NamedImpl <em>Named</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.univaq.MDEProfiler.graph.model.graph.NamedImpl
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl#getNamed()
	 * @generated
	 */
	int NAMED = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link it.univaq.MDEProfiler.graph.model.graph.GraphImpl <em>Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphImpl
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl#getGraph()
	 * @generated
	 */
	int GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__NODES = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__EDGES = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH__OWNER = NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_FEATURE_COUNT = NAMED_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_OPERATION_COUNT = NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link it.univaq.MDEProfiler.graph.model.graph.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.univaq.MDEProfiler.graph.model.graph.NodeImpl
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__URI = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TYPE = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Derived Or Not Exists</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DERIVED_OR_NOT_EXISTS = NAMED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = NAMED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link it.univaq.MDEProfiler.graph.model.graph.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see it.univaq.MDEProfiler.graph.model.graph.EdgeImpl
	 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE = NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET = NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__EXACT = NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Discover By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__DISCOVER_BY = NAMED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Path Discovered By Heuristic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__PATH_DISCOVERED_BY_HEURISTIC = NAMED_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = NAMED_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = NAMED_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link it.univaq.MDEProfiler.graph.model.graph.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Named
	 * @generated
	 */
	EClass getNamed();

	/**
	 * Returns the meta object for the attribute '{@link it.univaq.MDEProfiler.graph.model.graph.Named#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Named#getName()
	 * @see #getNamed()
	 * @generated
	 */
	EAttribute getNamed_Name();

	/**
	 * Returns the meta object for class '{@link it.univaq.MDEProfiler.graph.model.graph.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Graph
	 * @generated
	 */
	EClass getGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link it.univaq.MDEProfiler.graph.model.graph.Graph#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Graph#getNodes()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link it.univaq.MDEProfiler.graph.model.graph.Graph#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Graph#getEdges()
	 * @see #getGraph()
	 * @generated
	 */
	EReference getGraph_Edges();

	/**
	 * Returns the meta object for the attribute '{@link it.univaq.MDEProfiler.graph.model.graph.Graph#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Graph#getOwner()
	 * @see #getGraph()
	 * @generated
	 */
	EAttribute getGraph_Owner();

	/**
	 * Returns the meta object for class '{@link it.univaq.MDEProfiler.graph.model.graph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link it.univaq.MDEProfiler.graph.model.graph.Node#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Node#getUri()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Uri();

	/**
	 * Returns the meta object for the attribute list '{@link it.univaq.MDEProfiler.graph.model.graph.Node#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Type</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Node#getType()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Type();

	/**
	 * Returns the meta object for the attribute '{@link it.univaq.MDEProfiler.graph.model.graph.Node#isDerivedOrNotExists <em>Derived Or Not Exists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derived Or Not Exists</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Node#isDerivedOrNotExists()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_DerivedOrNotExists();

	/**
	 * Returns the meta object for class '{@link it.univaq.MDEProfiler.graph.model.graph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the reference '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Edge#getSource()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Source();

	/**
	 * Returns the meta object for the reference '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Target();

	/**
	 * Returns the meta object for the attribute '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#isExact <em>Exact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exact</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Edge#isExact()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Exact();

	/**
	 * Returns the meta object for the reference '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getDiscoverBy <em>Discover By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Discover By</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Edge#getDiscoverBy()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_DiscoverBy();

	/**
	 * Returns the meta object for the attribute '{@link it.univaq.MDEProfiler.graph.model.graph.Edge#getPathDiscoveredByHeuristic <em>Path Discovered By Heuristic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path Discovered By Heuristic</em>'.
	 * @see it.univaq.MDEProfiler.graph.model.graph.Edge#getPathDiscoveredByHeuristic()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_PathDiscoveredByHeuristic();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphFactory getGraphFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link it.univaq.MDEProfiler.graph.model.graph.NamedImpl <em>Named</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.univaq.MDEProfiler.graph.model.graph.NamedImpl
		 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl#getNamed()
		 * @generated
		 */
		EClass NAMED = eINSTANCE.getNamed();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

		/**
		 * The meta object literal for the '{@link it.univaq.MDEProfiler.graph.model.graph.GraphImpl <em>Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.univaq.MDEProfiler.graph.model.graph.GraphImpl
		 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl#getGraph()
		 * @generated
		 */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GRAPH__OWNER = eINSTANCE.getGraph_Owner();

		/**
		 * The meta object literal for the '{@link it.univaq.MDEProfiler.graph.model.graph.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.univaq.MDEProfiler.graph.model.graph.NodeImpl
		 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__URI = eINSTANCE.getNode_Uri();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__TYPE = eINSTANCE.getNode_Type();

		/**
		 * The meta object literal for the '<em><b>Derived Or Not Exists</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__DERIVED_OR_NOT_EXISTS = eINSTANCE.getNode_DerivedOrNotExists();

		/**
		 * The meta object literal for the '{@link it.univaq.MDEProfiler.graph.model.graph.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see it.univaq.MDEProfiler.graph.model.graph.EdgeImpl
		 * @see it.univaq.MDEProfiler.graph.model.graph.GraphPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Exact</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__EXACT = eINSTANCE.getEdge_Exact();

		/**
		 * The meta object literal for the '<em><b>Discover By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__DISCOVER_BY = eINSTANCE.getEdge_DiscoverBy();

		/**
		 * The meta object literal for the '<em><b>Path Discovered By Heuristic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__PATH_DISCOVERED_BY_HEURISTIC = eINSTANCE.getEdge_PathDiscoveredByHeuristic();

	}

} //GraphPackage
