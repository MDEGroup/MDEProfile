/**
 */
package it.univaq.MDEProfiler.graph.model.graph;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.EdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.EdgeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.EdgeImpl#isExact <em>Exact</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.EdgeImpl#getDiscoverBy <em>Discover By</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.EdgeImpl#getPathDiscoveredByHeuristic <em>Path Discovered By Heuristic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EdgeImpl extends NamedImpl implements Edge {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Node source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Node target;

	/**
	 * The default value of the '{@link #isExact() <em>Exact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExact()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExact() <em>Exact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExact()
	 * @generated
	 * @ordered
	 */
	protected boolean exact = EXACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiscoverBy() <em>Discover By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiscoverBy()
	 * @generated
	 * @ordered
	 */
	protected Node discoverBy;

	/**
	 * The default value of the '{@link #getPathDiscoveredByHeuristic() <em>Path Discovered By Heuristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathDiscoveredByHeuristic()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_DISCOVERED_BY_HEURISTIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPathDiscoveredByHeuristic() <em>Path Discovered By Heuristic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPathDiscoveredByHeuristic()
	 * @generated
	 * @ordered
	 */
	protected String pathDiscoveredByHeuristic = PATH_DISCOVERED_BY_HEURISTIC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Node)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Node newSource) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Node)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Node newTarget) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExact() {
		return exact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExact(boolean newExact) {
		boolean oldExact = exact;
		exact = newExact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__EXACT, oldExact, exact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getDiscoverBy() {
		if (discoverBy != null && discoverBy.eIsProxy()) {
			InternalEObject oldDiscoverBy = (InternalEObject)discoverBy;
			discoverBy = (Node)eResolveProxy(oldDiscoverBy);
			if (discoverBy != oldDiscoverBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__DISCOVER_BY, oldDiscoverBy, discoverBy));
			}
		}
		return discoverBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetDiscoverBy() {
		return discoverBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiscoverBy(Node newDiscoverBy) {
		Node oldDiscoverBy = discoverBy;
		discoverBy = newDiscoverBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__DISCOVER_BY, oldDiscoverBy, discoverBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPathDiscoveredByHeuristic() {
		return pathDiscoveredByHeuristic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPathDiscoveredByHeuristic(String newPathDiscoveredByHeuristic) {
		String oldPathDiscoveredByHeuristic = pathDiscoveredByHeuristic;
		pathDiscoveredByHeuristic = newPathDiscoveredByHeuristic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__PATH_DISCOVERED_BY_HEURISTIC, oldPathDiscoveredByHeuristic, pathDiscoveredByHeuristic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.EDGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case GraphPackage.EDGE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case GraphPackage.EDGE__EXACT:
				return isExact();
			case GraphPackage.EDGE__DISCOVER_BY:
				if (resolve) return getDiscoverBy();
				return basicGetDiscoverBy();
			case GraphPackage.EDGE__PATH_DISCOVERED_BY_HEURISTIC:
				return getPathDiscoveredByHeuristic();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphPackage.EDGE__SOURCE:
				setSource((Node)newValue);
				return;
			case GraphPackage.EDGE__TARGET:
				setTarget((Node)newValue);
				return;
			case GraphPackage.EDGE__EXACT:
				setExact((Boolean)newValue);
				return;
			case GraphPackage.EDGE__DISCOVER_BY:
				setDiscoverBy((Node)newValue);
				return;
			case GraphPackage.EDGE__PATH_DISCOVERED_BY_HEURISTIC:
				setPathDiscoveredByHeuristic((String)newValue);
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
			case GraphPackage.EDGE__SOURCE:
				setSource((Node)null);
				return;
			case GraphPackage.EDGE__TARGET:
				setTarget((Node)null);
				return;
			case GraphPackage.EDGE__EXACT:
				setExact(EXACT_EDEFAULT);
				return;
			case GraphPackage.EDGE__DISCOVER_BY:
				setDiscoverBy((Node)null);
				return;
			case GraphPackage.EDGE__PATH_DISCOVERED_BY_HEURISTIC:
				setPathDiscoveredByHeuristic(PATH_DISCOVERED_BY_HEURISTIC_EDEFAULT);
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
			case GraphPackage.EDGE__SOURCE:
				return source != null;
			case GraphPackage.EDGE__TARGET:
				return target != null;
			case GraphPackage.EDGE__EXACT:
				return exact != EXACT_EDEFAULT;
			case GraphPackage.EDGE__DISCOVER_BY:
				return discoverBy != null;
			case GraphPackage.EDGE__PATH_DISCOVERED_BY_HEURISTIC:
				return PATH_DISCOVERED_BY_HEURISTIC_EDEFAULT == null ? pathDiscoveredByHeuristic != null : !PATH_DISCOVERED_BY_HEURISTIC_EDEFAULT.equals(pathDiscoveredByHeuristic);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (exact: ");
		result.append(exact);
		result.append(", pathDiscoveredByHeuristic: ");
		result.append(pathDiscoveredByHeuristic);
		result.append(')');
		return result.toString();
	}

} //EdgeImpl
