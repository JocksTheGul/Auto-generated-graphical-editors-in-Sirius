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
package org.eclipse.sirius.sample.basicfamily;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Man</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.sirius.sample.basicfamily.BasicfamilyPackage#getMan()
 * @model annotation="sirius.node name='ManNode' expression='feature:members' color='blue' bordercolor='light_blue' labelcolor='white' style='SquareDescription' height='5' width='5' container='default' domain='Man'"
 *        annotation="sirius.tool type='DirectEditLabel' name='editMan' feature='name' value='var:0' belongsto='ManNode'"
 *        annotation="sirius.tool type='NodeCreationDescription' name='CreateMan' label='Man' feature='name' value='aql:\'Man\'' reference='members' mappings='ManNode' belongsto='ManNode'"
 * @generated
 */
public interface Man extends Person {
} // Man
