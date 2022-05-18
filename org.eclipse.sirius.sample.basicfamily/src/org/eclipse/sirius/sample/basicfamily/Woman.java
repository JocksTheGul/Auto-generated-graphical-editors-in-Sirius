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
 * <em><b>Woman</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.sirius.sample.basicfamily.BasicfamilyPackage#getWoman()
 * @model annotation="sirius.node name='WomanNode' expression='feature:members' color='red' style='SquareDescription' height='5' width='5' container='default' domain='Woman'"
 *        annotation="sirius.tool type='DirectEditLabel' name='editWoman' feature='name' value='var:0' belongsto='WomanNode'"
 *        annotation="sirius.tool type='NodeCreationDescription' name='CreateWoman' label='Woman' feature='name' value='aql:\'Woman\'' reference='members' mappings='WomanNode' belongsto='WomanNode'"
 * @generated
 */
public interface Woman extends Person {
} // Woman
