/**
 * Copyright (c) 2014 Obeo
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *  Obeo - initial API and implementation
 */
package org.eclipse.sirius.sample.basicfamily.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.sirius.sample.basicfamily.BasicfamilyFactory;
import org.eclipse.sirius.sample.basicfamily.BasicfamilyPackage;
import org.eclipse.sirius.sample.basicfamily.Family;
import org.eclipse.sirius.sample.basicfamily.Man;
import org.eclipse.sirius.sample.basicfamily.Person;
import org.eclipse.sirius.sample.basicfamily.Woman;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class BasicfamilyPackageImpl extends EPackageImpl implements BasicfamilyPackage {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass personEClass = null;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass familyEClass = null;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass manEClass = null;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private EClass womanEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.sirius.sample.basicfamily.BasicfamilyPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private BasicfamilyPackageImpl() {
		super(eNS_URI, BasicfamilyFactory.eINSTANCE);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link BasicfamilyPackage#eINSTANCE}
     * when that field is accessed. Clients should not invoke it directly.
     * Instead, they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static BasicfamilyPackage init() {
		if (isInited) return (BasicfamilyPackage)EPackage.Registry.INSTANCE.getEPackage(BasicfamilyPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBasicfamilyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BasicfamilyPackageImpl theBasicfamilyPackage = registeredBasicfamilyPackage instanceof BasicfamilyPackageImpl ? (BasicfamilyPackageImpl)registeredBasicfamilyPackage : new BasicfamilyPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theBasicfamilyPackage.createPackageContents();

		// Initialize created meta-data
		theBasicfamilyPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBasicfamilyPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BasicfamilyPackage.eNS_URI, theBasicfamilyPackage);
		return theBasicfamilyPackage;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EClass getPerson() {
		return personEClass;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EAttribute getPerson_Name() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EReference getPerson_Children() {
		return (EReference)personEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EReference getPerson_Parents() {
		return (EReference)personEClass.getEStructuralFeatures().get(2);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EReference getPerson_Mother() {
		return (EReference)personEClass.getEStructuralFeatures().get(3);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EReference getPerson_Father() {
		return (EReference)personEClass.getEStructuralFeatures().get(4);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EClass getFamily() {
		return familyEClass;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EAttribute getFamily_Name() {
		return (EAttribute)familyEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EReference getFamily_Members() {
		return (EReference)familyEClass.getEStructuralFeatures().get(1);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EClass getMan() {
		return manEClass;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EClass getWoman() {
		return womanEClass;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public BasicfamilyFactory getBasicfamilyFactory() {
		return (BasicfamilyFactory)getEFactoryInstance();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isCreated = false;

    /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__NAME);
		createEReference(personEClass, PERSON__CHILDREN);
		createEReference(personEClass, PERSON__PARENTS);
		createEReference(personEClass, PERSON__MOTHER);
		createEReference(personEClass, PERSON__FATHER);

		familyEClass = createEClass(FAMILY);
		createEAttribute(familyEClass, FAMILY__NAME);
		createEReference(familyEClass, FAMILY__MEMBERS);

		manEClass = createEClass(MAN);

		womanEClass = createEClass(WOMAN);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		manEClass.getESuperTypes().add(this.getPerson());
		womanEClass.getESuperTypes().add(this.getPerson());

		// Initialize classes and features; add operations and parameters
		initEClass(personEClass, Person.class, "Person", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPerson_Name(), ecorePackage.getEString(), "name", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPerson_Children(), this.getPerson(), this.getPerson_Parents(), "children", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPerson_Parents(), this.getPerson(), this.getPerson_Children(), "parents", null, 0, 2, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPerson_Mother(), this.getWoman(), null, "mother", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPerson_Father(), this.getMan(), null, "father", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(familyEClass, Family.class, "Family", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getFamily_Name(), ecorePackage.getEString(), "name", null, 0, 1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getFamily_Members(), this.getPerson(), null, "members", null, 0, -1, Family.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(manEClass, Man.class, "Man", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(womanEClass, Woman.class, "Woman", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// sirius
		createSiriusAnnotations();
		// sirius.edge
		createSirius_1Annotations();
		// sirius.tool
		createSirius_2Annotations();
		// sirius.node
		createSirius_3Annotations();
	}

				/**
	 * Initializes the annotations for <b>sirius</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSiriusAnnotations() {
		String source = "sirius"; //$NON-NLS-1$
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "name", "basicfamily", //$NON-NLS-1$ //$NON-NLS-2$
			   "mainclass", "Family", //$NON-NLS-1$ //$NON-NLS-2$
			   "viewpoint", "persons", //$NON-NLS-1$ //$NON-NLS-2$
			   "diagram", "family", //$NON-NLS-1$ //$NON-NLS-2$
			   "path", "org.eclipse.sirius.sample.basicfamily.starter.design" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

				/**
	 * Initializes the annotations for <b>sirius.edge</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSirius_1Annotations() {
		String source = "sirius.edge"; //$NON-NLS-1$
		addAnnotation
		  (getPerson_Mother(),
		   source,
		   new String[] {
			   "type", "relation", //$NON-NLS-1$ //$NON-NLS-2$
			   "source", "ManNode, WomanNode", //$NON-NLS-1$ //$NON-NLS-2$
			   "target", "WomanNode", //$NON-NLS-1$ //$NON-NLS-2$
			   "label", "", //$NON-NLS-1$ //$NON-NLS-2$
			   "color", "light_red", //$NON-NLS-1$ //$NON-NLS-2$
			   "labelcolor", "red", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "motherEdge", //$NON-NLS-1$ //$NON-NLS-2$
			   "targetFinderExpression", "feature:mother" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getPerson_Father(),
		   source,
		   new String[] {
			   "type", "relation", //$NON-NLS-1$ //$NON-NLS-2$
			   "source", "ManNode, WomanNode", //$NON-NLS-1$ //$NON-NLS-2$
			   "target", "ManNode", //$NON-NLS-1$ //$NON-NLS-2$
			   "color", "light_blue", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "fatherEdge", //$NON-NLS-1$ //$NON-NLS-2$
			   "targetFinderExpression", "feature:father" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

				/**
	 * Initializes the annotations for <b>sirius.tool</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSirius_2Annotations() {
		String source = "sirius.tool"; //$NON-NLS-1$
		addAnnotation
		  (getPerson_Mother(),
		   source,
		   new String[] {
			   "type", "EdgeCreationDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "setMother", //$NON-NLS-1$ //$NON-NLS-2$
			   "mappings", "motherEdge", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "mother", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "motherEdge" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getPerson_Mother(),
		   source,
		   new String[] {
			   "type", "DeleteElementDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "unsetMother", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "mother", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "motherEdge" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getPerson_Mother(),
		   source,
		   new String[] {
			   "type", "ReconnectEdgeDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "reconnectMother", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "mother", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "motherEdge" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getPerson_Father(),
		   source,
		   new String[] {
			   "type", "EdgeCreationDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "setFather", //$NON-NLS-1$ //$NON-NLS-2$
			   "mappings", "fatherEdge", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "father", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "fatherEdge" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getPerson_Father(),
		   source,
		   new String[] {
			   "type", "DeleteElementDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "unsetFather", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "father", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "fatherEdge" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (getPerson_Father(),
		   source,
		   new String[] {
			   "type", "ReconnectEdgeDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "reconnectFather", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "father", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "fatherEdge" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (manEClass,
		   source,
		   new String[] {
			   "type", "DirectEditLabel", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "editMan", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "name", //$NON-NLS-1$ //$NON-NLS-2$
			   "value", "var:0", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "ManNode" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (manEClass,
		   source,
		   new String[] {
			   "type", "NodeCreationDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "CreateMan", //$NON-NLS-1$ //$NON-NLS-2$
			   "label", "Man", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "name", //$NON-NLS-1$ //$NON-NLS-2$
			   "value", "aql:\'Man\'", //$NON-NLS-1$ //$NON-NLS-2$
			   "reference", "members", //$NON-NLS-1$ //$NON-NLS-2$
			   "mappings", "ManNode", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "ManNode" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (womanEClass,
		   source,
		   new String[] {
			   "type", "DirectEditLabel", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "editWoman", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "name", //$NON-NLS-1$ //$NON-NLS-2$
			   "value", "var:0", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "WomanNode" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (womanEClass,
		   source,
		   new String[] {
			   "type", "NodeCreationDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "name", "CreateWoman", //$NON-NLS-1$ //$NON-NLS-2$
			   "label", "Woman", //$NON-NLS-1$ //$NON-NLS-2$
			   "feature", "name", //$NON-NLS-1$ //$NON-NLS-2$
			   "value", "aql:\'Woman\'", //$NON-NLS-1$ //$NON-NLS-2$
			   "reference", "members", //$NON-NLS-1$ //$NON-NLS-2$
			   "mappings", "WomanNode", //$NON-NLS-1$ //$NON-NLS-2$
			   "belongsto", "WomanNode" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

				/**
	 * Initializes the annotations for <b>sirius.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSirius_3Annotations() {
		String source = "sirius.node"; //$NON-NLS-1$
		addAnnotation
		  (manEClass,
		   source,
		   new String[] {
			   "name", "ManNode", //$NON-NLS-1$ //$NON-NLS-2$
			   "expression", "feature:members", //$NON-NLS-1$ //$NON-NLS-2$
			   "color", "blue", //$NON-NLS-1$ //$NON-NLS-2$
			   "bordercolor", "light_blue", //$NON-NLS-1$ //$NON-NLS-2$
			   "labelcolor", "white", //$NON-NLS-1$ //$NON-NLS-2$
			   "style", "SquareDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "height", "5", //$NON-NLS-1$ //$NON-NLS-2$
			   "width", "5", //$NON-NLS-1$ //$NON-NLS-2$
			   "container", "default", //$NON-NLS-1$ //$NON-NLS-2$
			   "domain", "Man" //$NON-NLS-1$ //$NON-NLS-2$
		   });
		addAnnotation
		  (womanEClass,
		   source,
		   new String[] {
			   "name", "WomanNode", //$NON-NLS-1$ //$NON-NLS-2$
			   "expression", "feature:members", //$NON-NLS-1$ //$NON-NLS-2$
			   "color", "red", //$NON-NLS-1$ //$NON-NLS-2$
			   "style", "SquareDescription", //$NON-NLS-1$ //$NON-NLS-2$
			   "height", "5", //$NON-NLS-1$ //$NON-NLS-2$
			   "width", "5", //$NON-NLS-1$ //$NON-NLS-2$
			   "container", "default", //$NON-NLS-1$ //$NON-NLS-2$
			   "domain", "Woman" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} // BasicfamilyPackageImpl
