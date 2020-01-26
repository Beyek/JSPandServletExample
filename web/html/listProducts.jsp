<%@ page import="com.test.beans.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.test.dao.DBConnection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: crowz
  Date: १९/१२/२७
  Time: ०८:१९
  To change this template use File | Settings | File Templates.
--%>

<link rel="stylesheet" href="css/style.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<head>
    <title>List of Products</title>
</head>
<body>
<%@ include file="header.jsp" %>
<%!
    public Connection getDbConnection() {
        Connection connection = null;

        try {

            // load the driver class
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");

            // get hold of the DriverManager
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HPlus", "root", "root");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("Connection made to DB!");
        }
        return connection;
    }

    /**
     *
     * @return
     */
    public List<Product> getProductLists() {

        Product product = null;
        List<Product> products = new ArrayList<>();
        String sql = "select * from products";

        ResultSet resultSet = null;
        try {
            Connection connection = getDbConnection();
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
        System.out.println("resultSet === " + products);
        return products;

    }
%>


<section id="products" class="section">
    <div class="container">
        <h2 class="headline">List of Available Products</h2>
        <p>
            H+ Sport is <em>dedicated to creating</em> eco-friendly,
            high-quality, nutrient-rich, nutritional products that <em>enhance
            active lifestyles</em>.
        </p>

    </div>
    <div class="productContainer">
        <%
            List<Product> products = (ArrayList) getProductLists();
            Iterator iterator = products.iterator();
            while (iterator.hasNext()) {
                Product product = (Product) iterator.next();
        %>
        <div class="productContainerItem">
            <img id="pic1" src="<%=product.getProductImgPath()%>"> <input type="text" name="product"
                                                                          value="<%=product.getProductName()%>"><br/>

        </div>

        <% }%>

    </div>
    </div>
</section>
</body>
</html>
