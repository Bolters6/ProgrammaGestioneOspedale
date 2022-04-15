package Ospedale.app.dao;

import java.util.List;

import Ospedale.app.dao.entities.Paziente;

public interface DAOconString<T>  {
	public void add(T p);
	public void update(T p);
	public T get(String cf);
	public List<T> findAll();
	public void delete(String cf);
}
