package music.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.data.ProductDB;
import music.models.Product;

@WebServlet(urlPatterns = "/productMaint")
public class MusicServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/WEB-INF/displayProducts.jsp";
        
        if (action == null || action.equals("displayProducts")) {
            req.setAttribute("products", ProductDB.getProducts());
        }
        else if (action.equals("addProduct")) {
            url = "/WEB-INF/editProduct.jsp";
            req.setAttribute("isNew", Boolean.TRUE);
        }
        else if (action.equals("editProduct")) {
            String code = req.getParameter("productCode");
            req.setAttribute("product", ProductDB.getProduct(code));
            req.setAttribute("isNew", Boolean.FALSE);
            url = "/WEB-INF/editProduct.jsp";
        }
        else if (action.equals("updateProduct")) {
            boolean isNew = Boolean.parseBoolean(req.getParameter("isNew"));
            String code = req.getParameter("code");
            String desc = req.getParameter("description");

            double price;
            try {
                price = Double.parseDouble(req.getParameter("price"));
            }
            catch(Exception e) {
                price = 0.0;
            }
            
            Product p = new Product();
            p.setCode(code);
            p.setDescription(desc);
            p.setPrice(price);
            
            if (code != null && code.length() != 0 && 
                    desc != null && desc.length() != 0 && 
                    price != 0) {

                if (isNew) {
                    ProductDB.insertProduct(p);
                }
                else {
                    ProductDB.updateProduct(p);
                }
                
                resp.sendRedirect("productMaint?action=displayProducts");
                return;
            }
            
            req.setAttribute("product", p);
            req.setAttribute("isNew", isNew);
            req.setAttribute("error", "Invalid entry");
            url = "/WEB-INF/editProduct.jsp";
        }
        else if (action.equals("deleteProduct")) {
            String code = req.getParameter("productCode");
            req.setAttribute("product", ProductDB.getProduct(code));
            
            url = "/WEB-INF/confirmDelete.jsp";
        }
        else if (action.equals("confirmDelete")) {
            String code = req.getParameter("productCode");
            ProductDB.deleteProduct(code);
            
            resp.sendRedirect("productMaint?action=displayProducts");
            return;
        }
        
        req.getRequestDispatcher(url).forward(req, resp);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
