package com.hand.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.FilmDao;
import com.hand.dao.FilmDaoImpl;
import com.hand.entity.Film;





public class save_edit_film extends HttpServlet {
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
			String idStr = req.getParameter("id");
				Integer id = Integer.valueOf(idStr);				
				String Title = req.getParameter("title");
				String Description = req.getParameter("description");
				
				
				
				Film FL = new Film();
				
				FL.setTitle(Title);;
				FL.setDescription(Description);
			
				
				filmDao.save(FL);
				System.out.println();
				
			req.setAttribute("msg", "¹§Ï²Äã£¬ÐÞ¸Ä³É¹¦");
			req.setAttribute("nextUrl", "/back/chprfl");
			req.getRequestDispatcher("/film/gobal-msg.jsp").forward(req,resp);
	}
}
