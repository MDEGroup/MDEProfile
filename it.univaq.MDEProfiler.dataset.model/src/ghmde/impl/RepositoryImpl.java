/**
 */
package ghmde.impl;

import ghmde.File;
import ghmde.GhmdePackage;
import ghmde.Repository;
import ghmde.User;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ghmde.impl.RepositoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link ghmde.impl.RepositoryImpl#getStargazers <em>Stargazers</em>}</li>
 *   <li>{@link ghmde.impl.RepositoryImpl#getWatchers <em>Watchers</em>}</li>
 *   <li>{@link ghmde.impl.RepositoryImpl#getForks <em>Forks</em>}</li>
 *   <li>{@link ghmde.impl.RepositoryImpl#isFork <em>Fork</em>}</li>
 *   <li>{@link ghmde.impl.RepositoryImpl#getSize <em>Size</em>}</li>
 *   <li>{@link ghmde.impl.RepositoryImpl#getFiles <em>Files</em>}</li>
 *   <li>{@link ghmde.impl.RepositoryImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryImpl extends MinimalEObjectImpl.Container implements Repository {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStargazers() <em>Stargazers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStargazers()
	 * @generated
	 * @ordered
	 */
	protected static final int STARGAZERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStargazers() <em>Stargazers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStargazers()
	 * @generated
	 * @ordered
	 */
	protected int stargazers = STARGAZERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getWatchers() <em>Watchers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWatchers()
	 * @generated
	 * @ordered
	 */
	protected static final int WATCHERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWatchers() <em>Watchers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWatchers()
	 * @generated
	 * @ordered
	 */
	protected int watchers = WATCHERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getForks() <em>Forks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForks()
	 * @generated
	 * @ordered
	 */
	protected static final int FORKS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getForks() <em>Forks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForks()
	 * @generated
	 * @ordered
	 */
	protected int forks = FORKS_EDEFAULT;

	/**
	 * The default value of the '{@link #isFork() <em>Fork</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFork()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FORK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFork() <em>Fork</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFork()
	 * @generated
	 * @ordered
	 */
	protected boolean fork = FORK_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected int size = SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFiles() <em>Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiles()
	 * @generated
	 * @ordered
	 */
	protected EList<File> files;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GhmdePackage.Literals.REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GhmdePackage.REPOSITORY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStargazers() {
		return stargazers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStargazers(int newStargazers) {
		int oldStargazers = stargazers;
		stargazers = newStargazers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GhmdePackage.REPOSITORY__STARGAZERS, oldStargazers, stargazers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getWatchers() {
		return watchers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWatchers(int newWatchers) {
		int oldWatchers = watchers;
		watchers = newWatchers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GhmdePackage.REPOSITORY__WATCHERS, oldWatchers, watchers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getForks() {
		return forks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForks(int newForks) {
		int oldForks = forks;
		forks = newForks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GhmdePackage.REPOSITORY__FORKS, oldForks, forks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFork() {
		return fork;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFork(boolean newFork) {
		boolean oldFork = fork;
		fork = newFork;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GhmdePackage.REPOSITORY__FORK, oldFork, fork));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GhmdePackage.REPOSITORY__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<File> getFiles() {
		if (files == null) {
			files = new EObjectContainmentWithInverseEList<File>(File.class, this, GhmdePackage.REPOSITORY__FILES, GhmdePackage.FILE__REPOSITORY);
		}
		return files;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getOwner() {
		if (eContainerFeatureID() != GhmdePackage.REPOSITORY__OWNER) return null;
		return (User)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(User newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, GhmdePackage.REPOSITORY__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(User newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != GhmdePackage.REPOSITORY__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, GhmdePackage.USER__REPOSITORIES, User.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GhmdePackage.REPOSITORY__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GhmdePackage.REPOSITORY__FILES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFiles()).basicAdd(otherEnd, msgs);
			case GhmdePackage.REPOSITORY__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((User)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GhmdePackage.REPOSITORY__FILES:
				return ((InternalEList<?>)getFiles()).basicRemove(otherEnd, msgs);
			case GhmdePackage.REPOSITORY__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GhmdePackage.REPOSITORY__OWNER:
				return eInternalContainer().eInverseRemove(this, GhmdePackage.USER__REPOSITORIES, User.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GhmdePackage.REPOSITORY__NAME:
				return getName();
			case GhmdePackage.REPOSITORY__STARGAZERS:
				return getStargazers();
			case GhmdePackage.REPOSITORY__WATCHERS:
				return getWatchers();
			case GhmdePackage.REPOSITORY__FORKS:
				return getForks();
			case GhmdePackage.REPOSITORY__FORK:
				return isFork();
			case GhmdePackage.REPOSITORY__SIZE:
				return getSize();
			case GhmdePackage.REPOSITORY__FILES:
				return getFiles();
			case GhmdePackage.REPOSITORY__OWNER:
				return getOwner();
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
			case GhmdePackage.REPOSITORY__NAME:
				setName((String)newValue);
				return;
			case GhmdePackage.REPOSITORY__STARGAZERS:
				setStargazers((Integer)newValue);
				return;
			case GhmdePackage.REPOSITORY__WATCHERS:
				setWatchers((Integer)newValue);
				return;
			case GhmdePackage.REPOSITORY__FORKS:
				setForks((Integer)newValue);
				return;
			case GhmdePackage.REPOSITORY__FORK:
				setFork((Boolean)newValue);
				return;
			case GhmdePackage.REPOSITORY__SIZE:
				setSize((Integer)newValue);
				return;
			case GhmdePackage.REPOSITORY__FILES:
				getFiles().clear();
				getFiles().addAll((Collection<? extends File>)newValue);
				return;
			case GhmdePackage.REPOSITORY__OWNER:
				setOwner((User)newValue);
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
			case GhmdePackage.REPOSITORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GhmdePackage.REPOSITORY__STARGAZERS:
				setStargazers(STARGAZERS_EDEFAULT);
				return;
			case GhmdePackage.REPOSITORY__WATCHERS:
				setWatchers(WATCHERS_EDEFAULT);
				return;
			case GhmdePackage.REPOSITORY__FORKS:
				setForks(FORKS_EDEFAULT);
				return;
			case GhmdePackage.REPOSITORY__FORK:
				setFork(FORK_EDEFAULT);
				return;
			case GhmdePackage.REPOSITORY__SIZE:
				setSize(SIZE_EDEFAULT);
				return;
			case GhmdePackage.REPOSITORY__FILES:
				getFiles().clear();
				return;
			case GhmdePackage.REPOSITORY__OWNER:
				setOwner((User)null);
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
			case GhmdePackage.REPOSITORY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GhmdePackage.REPOSITORY__STARGAZERS:
				return stargazers != STARGAZERS_EDEFAULT;
			case GhmdePackage.REPOSITORY__WATCHERS:
				return watchers != WATCHERS_EDEFAULT;
			case GhmdePackage.REPOSITORY__FORKS:
				return forks != FORKS_EDEFAULT;
			case GhmdePackage.REPOSITORY__FORK:
				return fork != FORK_EDEFAULT;
			case GhmdePackage.REPOSITORY__SIZE:
				return size != SIZE_EDEFAULT;
			case GhmdePackage.REPOSITORY__FILES:
				return files != null && !files.isEmpty();
			case GhmdePackage.REPOSITORY__OWNER:
				return getOwner() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", stargazers: ");
		result.append(stargazers);
		result.append(", watchers: ");
		result.append(watchers);
		result.append(", forks: ");
		result.append(forks);
		result.append(", fork: ");
		result.append(fork);
		result.append(", size: ");
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //RepositoryImpl
