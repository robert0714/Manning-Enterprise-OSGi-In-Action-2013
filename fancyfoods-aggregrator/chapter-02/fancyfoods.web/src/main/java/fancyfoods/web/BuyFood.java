package fancyfoods.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import fancyfoods.food.*;

public class BuyFood extends HttpServlet {

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String foodName = request.getParameter("foodName");

		PrintWriter html = response.getWriter();
		html.append("<html>");
		html.append("<body>");

		html.append("You would like to buy " + foodName);
		html.append("<form method=post action=\"BuyFood\">");
		html.append("Customer name: <input type=text name=customerName> <br/>");
		html.append("How many would you like to buy?");
		html.append("<input type=text name=quantity><br/>");
		html.append("<input type=hidden name=foodName value=\"" + foodName
				+ "\">");
		html.append("<input type=submit value=Buy!>");
		html.append("</form>");

		html.append("</body>");
		html.append("</html>");
	}

	

	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter html = response.getWriter();

		html.append("<html>");

		String customerName = request.getParameter("customerName");
		String foodName = request.getParameter("foodName");
		String quantity = request.getParameter("quantity");

		try {
			InitialContext ctx = new InitialContext();
			Shop shop = (Shop) ctx.lookup("osgi:service/"
					+ Shop.class.getName());
			Inventory inventory = (Inventory) ctx.lookup("osgi:service/"
					+ Inventory.class.getName());
			Accounting accounting = (Accounting) ctx.lookup("osgi:service/"
					+ Accounting.class.getName());

			Customer customer = accounting.getCustomer(customerName);
			if (customer != null) {
				html.append(customer + "<br/>");
			} else {
				html.append(customerName + " is a new customer.<br/>");
			}

			Food food = inventory.getFood(foodName);
			html.append(food + "<br/>");

			html.append(customerName + " tried to buy " + quantity
					+ " packs of " + foodName + "<br/>");

			try {
				shop.purchase(foodName, customerName, Integer.valueOf(quantity));
				Customer refreshedCustomer = accounting
						.getCustomer(customerName);
				html.append("Afterwards, " + refreshedCustomer + "<br/>");
			} catch (Exception e) {
				html.append("A problem happened: " + e.getMessage() + "<br/>");
			}

			Food refreshedFood = inventory.getFood(foodName);
			html.append("And after? " + refreshedFood);
		} catch (NamingException e) {
			html.append("We have no shop today. Try again tomorrow.");
		}

		html.append("</body>");
		html.append("</html>");
	} 

}
