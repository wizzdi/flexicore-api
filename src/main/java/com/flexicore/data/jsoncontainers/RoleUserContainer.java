/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.data.jsoncontainers;

import com.flexicore.model.Role;
import com.flexicore.model.User;

import java.io.Serializable;

public class RoleUserContainer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Role leftside;
	private User rightside;
	public User getRightside() {
		return rightside;
	}
	public void setRightside(User rightside) {
		this.rightside = rightside;
	}
	public Role getLeftside() {
		return leftside;
	}
	public void setLeftside(Role leftside) {
		this.leftside = leftside;
	}
	public RoleUserContainer() {
		super();
	}
	public RoleUserContainer(Role left, User right) {
		super();
		this.setLeftside(left);
		this.setRightside(right);
	}
}
