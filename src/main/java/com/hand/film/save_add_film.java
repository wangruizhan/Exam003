package com.hand.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.FilmDao;
import com.hand.dao.FilmDaoImpl;
import com.hand.entity.Film;



public class save_add_film extends HttpServlet {
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
		 String title = req.getParameter("title");
		 String description = req.getParameter("description");
		 String language_id = req.getParameter("language_id");
		
		 Film FL = new Film();
		 FL.setTitle(title);
		 FL.setDescription(description);
		 FL.setLanguage_id(language_id);
		 
		 filmDao.add(FL);
		 System.out.println("---------"+FL);
		 req.setAttribute("msg", "¹§Ï²Äã£¬Ìí¼Ó³É¹¦");
		req.setAttribute("nextUrl", "/back/chprfl");
		req.getRequestDispatcher("/film/gobal-msg.jsp").forward(req,resp);
	}
	

}
