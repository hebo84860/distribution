package com.joyous.common.domain;

import com.joyous.common.entity.BaseQueryEntity;
import com.joyous.common.entity.Entity;

import java.util.List;

/**
 * 
 * @author mashengwen
 * mybatis 的mapper继承DomainEntityMapper
 * 实现相关方法，传入和传出参数需要实现Entity接口
 *
 */
public interface DomainEntityBaseMapper<I extends Entity,Q extends BaseQueryEntity<? extends Entity>> {

	/**
	 * @param i
	 * insert
	 */
	public int insertSelective(I i);

	/**
	 * @param id
	 * getById
	 */
	public I selectByPrimaryKey(Long id);

	/**
	 * @param id
	 * deleteById
	 */
	public int deleteByPrimaryKey(Long id);

	/**
	 * @param i
	 * updateById
	 */
	public int updateByPrimaryKeySelective(I i);

	/**
	 * @param q
	 * @return
	 * 查询返回多个对象
	 */
	public List<I> query(Q q);

	/**
	 * @param q
	 * @return
	 * 返回总数
	 */
	public int count(Q q);
	
}
