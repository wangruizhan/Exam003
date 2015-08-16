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
import com.hand.util.PageUtils;



public class check_film extends HttpServlet {
	private FilmDao filmDao = new FilmDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String search = req.getParameter("search");
		
		List<Film> list = null;
		if(search!=null && !search.isEmpty()){
			list = filmDao.query(search);
		}
		 long totalcount =filmDao.count(); 
		 long totalpage = PageUtils.checkTotalcount(totalcount);
		long page = 1;
		try {
			  page = Integer.parseInt(req.getParameter("page"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}	
		 page = PageUtils.checkpage(page,totalpage);
		long size = PageUtils.checksize();
		
		 List<Film> film = filmDao.query(page,size);
		
		 req.setAttribute("totalpage", totalpage);
		 req.setAttribute("search", list);
		 req.setAttribute("page", page);
		 req.setAttribute("film", film);
		 req.getRequestDispatcher("/film/film_list.jsp").forward(req,resp);
		
	}
	

}
