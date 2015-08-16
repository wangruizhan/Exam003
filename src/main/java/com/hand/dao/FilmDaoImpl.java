package com.hand.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.entity.Film;
import com.hand.rowmapper.FilmRom;
import com.hand.util.JdbcUtils;



public class FilmDaoImpl implements FilmDao{

	public List<Film> query() {
		// TODO Auto-generated method stub
		return query(-1,-1);
	}

	public List<Film> query(String search) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from film where film_id like ?";
			Object[] params = {"%"+search+"%"}; 
			List<Film> productFenLei = JdbcUtils.executeQuery(conn, sql, params, new FilmRom());
			return productFenLei;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return new ArrayList();
	
	}

	public List<Film> query(long page, long line) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from film where 1=1";
			Object[] params = null; 
			if (page>0 && line>0){
				sql = sql+" limit ?,?";
				long start = (page-1)*line;
				params =new Object[] {start,line};
			}
			List<Film> productFenLei = JdbcUtils.executeQuery(conn, sql, params, new FilmRom());
			return productFenLei;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		return new ArrayList();
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(int id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "delete from film where id=?";
			JdbcUtils.executeUpdate(conn, sql, new Object[]{id});//这个数组是存放问号的值
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
	}

	public List<Film> queryById(Integer id) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from film where id=?";
			List<Film> productFenLei = JdbcUtils.executeQuery(conn, sql, new Object[]{id},new FilmRom());
			return productFenLei;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.close(conn);
		}
		return new ArrayList();
	}

	public void save(Film FL) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update film set title=?,description=?,language_id=? where id=?";
			Object[] params = {FL.getTitle(),FL.getDescription(),FL.getLanguage_id()};
			JdbcUtils.executeUpdate(conn, sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		
		
	}

	public void add(Film FL) {
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into film(Title,Description,language_id) values (?,?,?)";
			Object[] params = {FL.getTitle(),FL.getDescription(),FL.getLanguage_id()};
			JdbcUtils.executeUpdate(conn,sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.close(conn);
		}
		}
		
	}
	

