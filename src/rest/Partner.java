package rest;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import bean.UserBean;
import model.BookStoreModel;

@Path("partner")
public class Partner {

	@GET
	@Path("/read/getProductInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProductInfo(@QueryParam("email") String email, @QueryParam("password") String password, @QueryParam("productId") String productId)
			throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {

		String product = null;
		BookStoreModel model = BookStoreModel.getInstance();
		UserBean user = model.isUserExist(email, password);
		
		if (user != null && user.getUserType() == 1) {
		    
			if (model.retrieveInfoOfBook(productId) != null) {
				product = model.getProductInfo(productId);				
			} else {
				product = model.jsonErrorMessage();
			}
			
		} else {
			product = "Sorry we could not authetnticate your partner logins. Try Again!\n";
		}
		
		return product;
	}
	

	@GET
	@Path("/read/getOrdersByPartNumber")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOrdersByPartNumber(@QueryParam("email") String email, @QueryParam("password") String password, @QueryParam("productId") String productId)
			throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {

		String order = null;
		BookStoreModel model = BookStoreModel.getInstance();
		UserBean user = model.isUserExist(email, password);
		
		if (user != null && user.getUserType() == 1) {
			
			if (model.retrieveInfoOfBook(productId) != null) {
				order = model.getOrdersByPartNumber(productId);
			} else {
				order = model.jsonErrorMessage();
			}
		}

		else {
			order = "Sorry we could not authetnticate your partner logins. Try Again!\n";
		}

		return order;
	}
}
