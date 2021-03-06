package Ospedale.app.dao;

import java.util.List;

public interface DAO<T> {
	
	public void add(T t);
	public void delete(int id);
	public void update(T t);
	public T get(int id);
	public List<T> findAll();
	
}
