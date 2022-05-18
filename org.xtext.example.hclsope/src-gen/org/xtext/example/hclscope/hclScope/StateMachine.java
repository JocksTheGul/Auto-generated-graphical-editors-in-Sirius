/**
 * generated by Xtext 2.25.0
 */
package org.xtext.example.hclscope.hclScope;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.hclscope.hclScope.StateMachine#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.hclscope.hclScope.StateMachine#getStates <em>States</em>}</li>
 *   <li>{@link org.xtext.example.hclscope.hclScope.StateMachine#getInitialtransition <em>Initialtransition</em>}</li>
 *   <li>{@link org.xtext.example.hclscope.hclScope.StateMachine#getJunction <em>Junction</em>}</li>
 *   <li>{@link org.xtext.example.hclscope.hclScope.StateMachine#getChoice <em>Choice</em>}</li>
 *   <li>{@link org.xtext.example.hclscope.hclScope.StateMachine#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.xtext.example.hclscope.hclScope.StateMachine#getInitialstate <em>Initialstate</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.hclscope.hclScope.HclScopePackage#getStateMachine()
 * @model annotation="sirius.tool name='editLabel' type='DirectEditLabel' feature='name' value='var:0' mappings='State, Junction, Choice, InitialState, ContainedState:State, ContainedJunction:State, ContainedChoice:State, ContainedInitialState:State, ExitPoint:State, EntryPoint:State, HistoryNode:State'"
 * @generated
 */
public interface StateMachine extends EObject
{
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.xtext.example.hclscope.hclScope.HclScopePackage#getStateMachine_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link org.xtext.example.hclscope.hclScope.StateMachine#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.xtext.example.hclscope.hclScope.State}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.xtext.example.hclscope.hclScope.HclScopePackage#getStateMachine_States()
	 * @model containment="true"
	 *        annotation="sirius.container name='State' expression='feature:states' background='purple' foreground='white' container='default' domain='State' icon='false'"
	 *        annotation="sirius.tool name='CreateState' type='ContainerCreationDescription' mappings='State, ContainedState:State' reference='states' belongsto='State'"
	 * @generated
	 */
  EList<State> getStates();

  /**
	 * Returns the value of the '<em><b>Initialtransition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialtransition</em>' containment reference.
	 * @see #setInitialtransition(InitialTransition)
	 * @see org.xtext.example.hclscope.hclScope.HclScopePackage#getStateMachine_Initialtransition()
	 * @model containment="true"
	 *        annotation="sirius.edge type='element' source='InitialState, ContainedInitialState:State' target='Junction, Choice, State, EntryPoint:State, ExitPoint:State, ContainedState:State, ContainedJunction:State, ContainedChoice:State' containerreuse='true' color='black' name='InitialTransition' label='aql:self.name' domain='InitialTransition' targetFinderExpression='aql:self.initialto' sourceFinderExpression='aql:self.initialState' targetStyle='InputFillClosedArrow' icon='false' expression='aql:self.eAllContents()'"
	 *        annotation="sirius.altedge belongsto='InitialTransition' condition='aql:self.transitionbody.transitionguard-&gt;notEmpty()' label='aql:self.name + \'[\' + self.transitionbody.transitionguard.name + \']\''"
	 *        annotation="sirius.tool name='CreateInitialTransition' type='EdgeCreationDescription' mappings='InitialTransition' source='initialState' target='initialto' reference='initialtransition' belongsto='InitialTransition' containerexpression='aql:source.eContainer()'"
	 *        annotation="sirius.tool type='ReconnectEdgeDescription' name='ReconnectInitialTransitionTarget' feature='initialto' belongsto='InitialTransition' kind='target'"
	 * @generated
	 */
  InitialTransition getInitialtransition();

  /**
	 * Sets the value of the '{@link org.xtext.example.hclscope.hclScope.StateMachine#getInitialtransition <em>Initialtransition</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialtransition</em>' containment reference.
	 * @see #getInitialtransition()
	 * @generated
	 */
  void setInitialtransition(InitialTransition value);

  /**
	 * Returns the value of the '<em><b>Junction</b></em>' containment reference list.
	 * The list contents are of type {@link org.xtext.example.hclscope.hclScope.Junction}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Junction</em>' containment reference list.
	 * @see org.xtext.example.hclscope.hclScope.HclScopePackage#getStateMachine_Junction()
	 * @model containment="true"
	 *        annotation="sirius.node name='Junction' expression='aql:self.junction' style='DotDescription' label='' icon='false' color='light_blue' container='default' height='3' width='3' domain='Junction'"
	 *        annotation="sirius.tool name='CreateJunction' type='NodeCreationDescription' label='' mappings='Junction, ContainedJunction:State' reference='junction' belongsto='Junction'"
	 * @generated
	 */
  EList<Junction> getJunction();

  /**
	 * Returns the value of the '<em><b>Choice</b></em>' containment reference list.
	 * The list contents are of type {@link org.xtext.example.hclscope.hclScope.Choice}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Choice</em>' containment reference list.
	 * @see org.xtext.example.hclscope.hclScope.HclScopePackage#getStateMachine_Choice()
	 * @model containment="true"
	 *        annotation="sirius.node name='Choice' expression='aql:self.choice' style='LozengeNodeDescription' label='' icon='false' color='light_blue' container='default' height='3' width='3' domain='Choice'"
	 *        annotation="sirius.tool name='CreateChoice' type='NodeCreationDescription' label='' mappings='Choice, ContainedChoice:State' reference='choice' belongsto='Choice'"
	 * @generated
	 */
  EList<Choice> getChoice();

  /**
	 * Returns the value of the '<em><b>Transition</b></em>' containment reference list.
	 * The list contents are of type {@link org.xtext.example.hclscope.hclScope.Transition}.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' containment reference list.
	 * @see org.xtext.example.hclscope.hclScope.HclScopePackage#getStateMachine_Transition()
	 * @model containment="true"
	 *        annotation="sirius.edge type='element' source='Junction, Choice, State, EntryPoint:State, ExitPoint:State, ContainedState:State, ContainedJunction:State, ContainedChoice:State' target='Junction, Choice, State, EntryPoint:State, ExitPoint:State, ContainedState:State, ContainedJunction:State, ContainedChoice:State' color='black' name='Transitions' label='aql:self.name' domain='Transition' targetFinderExpression='feature:to' sourceFinderExpression='feature:from' targetStyle='InputFillClosedArrow' icon='false' expression='aql:self.eAllContents()'"
	 *        annotation="sirius.altedge belongsto='Transitions' condition='aql:self.transitionbody.transitionguard-&gt;notEmpty()' label='aql:self.name + \'[\' + self.transitionbody.transitionguard.name + \']\''"
	 *        annotation="sirius.tool name='CreateTransition' type='EdgeCreationDescription' mappings='Transitions' source='from' target='to' reference='transition' belongsto='Transitions' containerexpression='aql:source.eContainer()'"
	 *        annotation="sirius.tool type='ReconnectEdgeDescription' name='ReconnectTransitionSource' feature='from' belongsto='Transitions' kind='source'"
	 *        annotation="sirius.tool type='ReconnectEdgeDescription' name='ReconnectTransitionTarget' feature='to' belongsto='Transitions' kind='target'"
	 * @generated
	 */
  EList<Transition> getTransition();

		/**
	 * Returns the value of the '<em><b>Initialstate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialstate</em>' containment reference.
	 * @see #setInitialstate(InitialState)
	 * @see org.xtext.example.hclscope.hclScope.HclScopePackage#getStateMachine_Initialstate()
	 * @model containment="true"
	 *        annotation="sirius.node name='InitialState' expression='feature:initialstate' style='DotDescription' label='' icon='false' color='light_blue' height='1' width='1' container='default' domain='InitialState'"
	 *        annotation="sirius.tool name='CreateInitialState' type='NodeCreationDescription' label='' mappings='InitialState, ContainedInitialState:State' reference='initialstate' belongsto='InitialState'"
	 * @generated
	 */
	InitialState getInitialstate();

		/**
	 * Sets the value of the '{@link org.xtext.example.hclscope.hclScope.StateMachine#getInitialstate <em>Initialstate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialstate</em>' containment reference.
	 * @see #getInitialstate()
	 * @generated
	 */
	void setInitialstate(InitialState value);

} // StateMachine