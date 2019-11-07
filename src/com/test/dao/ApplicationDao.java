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

        try {
            // get the connection for the database
            Connection connection = DBConnection.getConnectionToDatabase();

            // write the insert query
            String insertQuery = "insert into users(username,password,firstname,lastname,age,activity) values(?,?,?,?,?,?)";

            // set parameters with PreparedStatement
            java.sql.PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getAge());
            statement.setString(6, user.getActivity());

            // execute the statement
            rowsAffected = statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowsAffected;
    }
}
