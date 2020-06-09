/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@SuppressWarnings("serial")
@Entity
public class CurrentDatabaseTenant extends Baseclass {
	private static CurrentDatabaseTenant s_Singleton=new CurrentDatabaseTenant();
	public  static CurrentDatabaseTenant s() {return s_Singleton;}

	@Column(columnDefinition = "timestamp with time zone")
	private OffsetDateTime startTime;
	@Column(columnDefinition = "timestamp with time zone")
	private OffsetDateTime endTime;
	@ManyToOne(targetEntity = Tenant.class)
	private Tenant currentTenant;


	public OffsetDateTime getStartTime() {
		return startTime;
	}

	public CurrentDatabaseTenant setStartTime(OffsetDateTime start) {
		this.startTime = start;
		return this;
	}

	public OffsetDateTime getEndTime() {
		return endTime;
	}

	public CurrentDatabaseTenant setEndTime(OffsetDateTime end) {
		this.endTime = end;
		return this;
	}

	@ManyToOne(targetEntity = Tenant.class)
	public Tenant getCurrentTenant() {
		return currentTenant;
	}

	public CurrentDatabaseTenant setCurrentTenant(Tenant currentTenant) {
		this.currentTenant = currentTenant;
		return this;
	}
}
