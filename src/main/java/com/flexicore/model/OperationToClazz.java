/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.flexicore.security.SecurityContext;

@SuppressWarnings("serial")

@Entity

public class OperationToClazz extends Baselink {
	private static OperationToClazz s_Singleton=new OperationToClazz();
	public  static OperationToClazz s() {return s_Singleton;}

	public OperationToClazz() {
	}

	public OperationToClazz(String name, SecurityContext securityContext) {
		super(name, securityContext);
	}

	@ManyToOne(targetEntity = Operation.class)
	//@JoinColumn(name = "leftside", referencedColumnName = "id")

	@Override
	public Operation getLeftside() {
		return (Operation) super.getLeftside();
	}

	@Override
	public void setLeftside(Baseclass leftside) {
		// TODO Auto-generated method stub
		super.setLeftside(leftside);
	}


	public void setOperation(Operation operation) {
		this.leftside=operation;
	}

	@ManyToOne(targetEntity = Clazz.class)
	//@JoinColumn(name = "rightside", referencedColumnName = "id")

	@Override
	public Clazz getRightside() {
		return (Clazz)super.getRightside();
	}

	@Override
	public void setRightside(Baseclass rightside) {
		// TODO Auto-generated method stub
		super.setRightside(rightside);
	}


	public void setClazz(Clazz clazz) {
		this.rightside=clazz;
	}





}
