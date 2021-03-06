package com.foody.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foody.dao.FoodyDao;
import com.foody.pojoclasses.UpdateMenuBean;

/**
 * Servlet implementation class UpdateLunchMenu
 */
@WebServlet("/updateLunchMenu")
public class UpdateLunchMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLunchMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String item=request.getParameter("itemName");
		String price=request.getParameter("price");
		String time=request.getParameter("time");
		int itemid=Integer.parseInt(request.getParameter("itemId"));
		
		
		UpdateMenuBean addmenu=new UpdateMenuBean();
		
		addmenu.setItemId(itemid);
		addmenu.setItemName(item);
		addmenu.setPrice(price);
		addmenu.setTime(time);
		
		String check=null;
		FoodyDao fd=new FoodyDao();
	
			   try 
		        {
				  check=fd.updateLunchMenu(addmenu);
				  if(check.equals("updated"))
				  {
					 request.getRequestDispatcher("menu-updated.jsp").forward(request, response);
				  }
				  else
				  {
					  request.getRequestDispatcher("error-page.jsp").forward(request, response);
				  }
				} catch (Exception e) 
		        {
					System.out.println(e);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
