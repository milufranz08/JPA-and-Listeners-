package music.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import music.models.Product;

public class ProductDB {

    private static Product productFromResultSet(ResultSet rs) throws SQLException {
        Product product = new Product();
        
        product.setCode(rs.getString("code"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getDouble("price"));
        
        return product;
    }
    
    public static List<Product> getProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT u FROM Product u ";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        
        List<Product> products;
        try {
            products = q.getResultList();
            if (products == null || products.isEmpty()) {
                products = null;
            }   
        } finally {
            em.close();
        }
        
        return products;
    }

    public static Product getProduct(String code) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();

        String qString = "SELECT u FROM Product u " +
                            "WHERE u.code = :code";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("code", code);
        
        Product product = null;
        try {
            product = q.getSingleResult();
        } catch (NoResultException e){
            System.out.println(e);
        }finally {
            em.close();
        }
        
        return product;
    }

    public static void insertProduct(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void updateProduct(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        
        String productCode = product.getCode();
        Product pro = getProduct(productCode);
        Long productId = pro.getProductId();
        product.setProductId(productId);

        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void deleteProduct(String code) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();

        Product product = getProduct(code);
        Long productId = product.getProductId();
        
        try {
            product = em.find(Product.class, productId);
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }      
    }
}
