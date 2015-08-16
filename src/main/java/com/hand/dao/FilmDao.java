package com.hand.dao;



import java.util.List;

import com.hand.entity.Film;


/**
 * 添加产品分类
 * @author Filmistrator
 *
 */
public interface FilmDao {
	public List<Film> query();

	public List<Film> query(String search);

	public List<Film> query(long page,long line);

	public long count();

	public void delete(int id);

	public List<Film> queryById(Integer id);

	public void save(Film FL);

	public void add(Film FL);
}
