package dao;

import mapper.RowMapper;

import java.util.List;

public interface GenericDAO<T> {

	List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	
	Integer insert(String sql, Object... parameters);
	
	int update(String sql, Object... parameters);
	
	int count(String sql, Object... parameters);

}