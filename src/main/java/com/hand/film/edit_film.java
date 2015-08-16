package com.hand.film;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.FilmDao;
import com.hand.dao.FilmDaoImpl;
import com.hand.entity.Film;





public class edit_film extends HttpServlet {
	private FilmDao filmDao = new FilmDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idStr = req.getParameter("id");	
		Integer id = Integer.valueOf(idStr);
		List<Film> film = filmDao.queryById(id);
		req.setAttribute("film", film);
		req.setAttribute("id",id);
		req.getRequestDispatcher("/film/edit_film.jsp").forward(req,resp);
		
	}
}
