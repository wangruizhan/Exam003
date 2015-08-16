package com.hand.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.entity.Film;
import com.hand.util.RowMapper;



public class FilmRom implements RowMapper{

	
	public Object getEntity(ResultSet rs) throws SQLException {
		Film film = new Film();
		film.setFilm_id(rs.getInt("Film_id"));
		film.setTitle(rs.getString("Title"));
		film.setDescription(rs.getString("Description"));
		film.setLanguage_id(rs.getString("Language_id"));
		
		return film;
		
	}
	

}
