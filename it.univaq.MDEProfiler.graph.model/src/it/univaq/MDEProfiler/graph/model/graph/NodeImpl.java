/**
 */
package it.univaq.MDEProfiler.graph.model.graph;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.NodeImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.NodeImpl#getType <em>Type</em>}</li>
 *   <li>{@link it.univaq.MDEProfiler.graph.model.graph.NodeImpl#isDerivedOrNotExists <em>Derived Or Not Exists</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends NamedImpl implements Node {
	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EList<String> type;

	/**
	 * The default value of the '{@link #isDerivedOrNotExists() <em>Derived Or Not Exists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivedOrNotExists()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_OR_NOT_EXISTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerivedOrNotExists() <em>Derived Or Not Exists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivedOrNotExists()
	 * @generated
	 * @ordered
	 */
	protected boolean derivedOrNotExists = DERIVED_OR_NOT_EXISTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.NODE__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getType() {
		if (type == null) {
			type = new EDataTypeUniqueEList<String>(String.class, this, GraphPackage.NODE__TYPE);
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerivedOrNotExists() {
		return derivedOrNotExists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivedOrNotExists(boolean newDerivedOrNotExists) {
		boolean oldDerivedOrNotExists = derivedOrNotExists;
		derivedOrNotExists = newDerivedOrNotExists;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.NODE__DERIVED_OR_NOT_EXISTS, oldDerivedOrNotExists, derivedOrNotExists));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.NODE__URI:
				return getUri();
			case GraphPackage.NODE__TYPE:
				return getType();
			case GraphPackage.NODE__DERIVED_OR_NOT_EXISTS:
				return isDerivedOrNotExists();
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
			case GraphPackage.NODE__URI:
				setUri((String)newValue);
				return;
			case GraphPackage.NODE__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends String>)newValue);
				return;
			case GraphPackage.NODE__DERIVED_OR_NOT_EXISTS:
				setDerivedOrNotExists((Boolean)newValue);
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
			case GraphPackage.NODE__URI:
				setUri(URI_EDEFAULT);
				return;
			case GraphPackage.NODE__TYPE:
				getType().clear();
				return;
			case GraphPackage.NODE__DERIVED_OR_NOT_EXISTS:
				setDerivedOrNotExists(DERIVED_OR_NOT_EXISTS_EDEFAULT);
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
			case GraphPackage.NODE__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
			case GraphPackage.NODE__TYPE:
				return type != null && !type.isEmpty();
			case GraphPackage.NODE__DERIVED_OR_NOT_EXISTS:
				return derivedOrNotExists != DERIVED_OR_NOT_EXISTS_EDEFAULT;
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
		result.append(" (uri: ");
		result.append(uri);
		result.append(", type: ");
		result.append(type);
		result.append(", derivedOrNotExists: ");
		result.append(derivedOrNotExists);
		result.append(')');
		return result.toString();
	}

} //NodeImpl
