/*******************************************************************************
 *  Copyright (C) FlexiCore, Inc - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 *  Written by Avishay Ben Natan And Asaf Ben Natan, October 2015
 ******************************************************************************/
package com.flexicore.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flexicore.security.SecurityContext;


public class QueryInformationHolder<T extends Baseclass> {
	
	
	private int pageSize;
	private int currentPage;
	private Class<T> type;
	private List<String> batchFetchString; //hints for preventing n+1
	private SecurityContext securityContext;
	private FilteringInformationHolder filteringInformationHolder;
	private HashMap<String, Object> additionalOptions = new HashMap<>();
	

	public QueryInformationHolder() {
		
		filteringInformationHolder= new FilteringInformationHolder();
		
	}
	
	



	





	public QueryInformationHolder(Class<T> type,SecurityContext securityContext) {
		this();
		this.type = type;
		this.setSecurityContext(securityContext);
	}











	public QueryInformationHolder(FilteringInformationHolder filteringInformationHolder,Class<T> type,SecurityContext securityContext) {
		this(type,securityContext);
		this.setFilteringInformationHolder(filteringInformationHolder);
		this.pageSize = filteringInformationHolder.getPageSize()!=null?filteringInformationHolder.getPageSize():-1;
		this.currentPage = filteringInformationHolder.getCurrentPage()!=null?filteringInformationHolder.getCurrentPage():-1;

	}






	public QueryInformationHolder(FilteringInformationHolder filteringInformationHolder,int pageSize,int currentPage,Class<T> type,SecurityContext securityContext) {
		this(type,securityContext);
		this.setFilteringInformationHolder(filteringInformationHolder);
		this.pageSize = filteringInformationHolder.getPageSize()!=null?filteringInformationHolder.getPageSize():pageSize;
		this.currentPage = filteringInformationHolder.getCurrentPage()!=null?filteringInformationHolder.getCurrentPage():currentPage;
		
	}




	public QueryInformationHolder( List<CategoryIdFiltering> categories,
			List<SortParameter> sort, int pageSize, int currentPage, Class<T> type,SecurityContext securityContext) {
		this(type,securityContext);
		setFilteringInformationHolder(new FilteringInformationHolder(sort, categories));
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}











	







	public int getPageSize() {
		return pageSize;
	}











	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}











	public int getCurrentPage() {
		return currentPage;
	}











	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}











	public Class<T> getType() {
		return type;
	}











	public void setType(Class<T> type) {
		this.type = type;
	}











	public List<String> getBatchFetchString() {
		return batchFetchString;
	}











	public void setBatchFetchString(List<String> batchFetchString) {
		this.batchFetchString = batchFetchString;
	}











	public SecurityContext getSecurityContext() {
		return securityContext;
	}











	public void setSecurityContext(SecurityContext securityContext) {
		this.securityContext = securityContext;
	}











	public FilteringInformationHolder getFilteringInformationHolder() {
		return filteringInformationHolder;
	}











	public void setFilteringInformationHolder(FilteringInformationHolder filteringInformationHolder) {
		this.filteringInformationHolder = filteringInformationHolder;
	}











	public Object get(Object key) {
		return additionalOptions.get(key);
	}











	public Object put(String key, Object value) {
		return additionalOptions.put(key, value);
	}











	public void putAll(Map<? extends String, ?> m) {
		additionalOptions.putAll(m);
	}











	public Object remove(Object key) {
		return additionalOptions.remove(key);
	}

	
	



















	










	




}
