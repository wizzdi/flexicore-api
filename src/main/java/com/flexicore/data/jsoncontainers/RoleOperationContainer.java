/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.data.jsoncontainers;

import com.flexicore.model.Operation;
import com.flexicore.model.Role;

import java.io.Serializable;

public class RoleOperationContainer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Role leftside;
	private Operation rightside;
	public Operation getRightside() {
		return rightside;
	}
	public void setRightside(Operation rightside) {
		this.rightside = rightside;
	}
	public Role getLeftside() {
		return leftside;
	}
	public void setLeftside(Role leftside) {
		this.leftside = leftside;
	}
	public RoleOperationContainer() {
		super();
	}
	public RoleOperationContainer(Role left, Operation right) {
		super();
		this.setLeftside(left);
		this.setRightside(right);
	}
}
