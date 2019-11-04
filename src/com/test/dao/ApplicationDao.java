package com.test.dao;

import com.test.beans.Product;
import com.test.beans.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDao {

	public List<Product> searchProducts(String searchString){

		Product product = null;
		List<Product> products= new ArrayList<>();
		String sql = "select * from products where product_name like '%"+searchString.toLowerCase()+"%'";

		ResultSet resultSet = null;
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				product = new Product();
				product.setProductId(resultSet.getInt("product_id"));
				product.setProductName(resultSet.getString("product_name"));
				product.setProductImgPath(resultSet.getString("product_image_path"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;

	}

    public int registerUser(User user) {
        int rowsAffected = 0;
//todo add try...catch block for SQLException handling
            // todo get the connection for the database


            //todo write the insert query


            //todo set parameters with PreparedStatement


            //todo execute the statement and get the rowAffected


        return rowsAffected;
    }
}
