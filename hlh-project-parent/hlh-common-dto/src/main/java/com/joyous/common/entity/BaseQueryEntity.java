package com.joyous.common.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 查询泛型对象
 * 
 * @author mashengwen
 */
@XmlRootElement
public class BaseQueryEntity<T> implements Serializable,Entity {

	private static final long serialVersionUID = -689667730283333557L;

	private Paging paging;

	private T condition;

	private String queryKey;

	public BaseQueryEntity() {

	}

	public BaseQueryEntity(T condition) {
		super();
		this.paging=new Paging(0,50000,null,null);
		this.condition = condition;
	}

	public BaseQueryEntity(Paging paging, T condition) {
		this.paging = paging;
		this.condition = condition;
	}
	
	public String getQueryKey() {
		return queryKey;
	}

	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
		this.condition = condition;
	}
//	@JsonIgnore
	public int getStartRow() {
		return paging.getStartRow();
	}
//	@JsonIgnore
	public int getEndRow() {
		return paging.getEndRow();
	}
//	@JsonIgnore
	public String getSidx() {
		return paging.getSidx();
	}
//	@JsonIgnore
	public String getSord() {
		return paging.getSord();
	}

//	@JsonIgnore
	@Override
	public Integer getId() {
		return null;
	}

}
