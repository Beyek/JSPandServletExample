<!DOCTYPE html>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <meta charset="ISO-8859-1">
    <title>H+ Sport</title>


</head>
<body>
<header id="home" class="header">
    <nav class="nav" role="navigation">
        <div class="container nav-elements">
            <div class="branding">
                <a href="#home"><img src="images/hpluslogo.svg"
                                     alt="Logo - H Plus Sports"></a>
            </div>
            <!-- branding -->
            <ul class="navbar">
                <li><a href="home">home</a></li>
                <li><a href="redirect">linkedIn</a></li>

            </ul>
            <!-- navbar -->
        </div>
        <!-- container nav-elements -->
    </nav>
    <!-- <div class="container tagline">
<h1 class="headline">Our Mission</h1>
<p>We support and encourage <em>active and healthy</em> lifestyles, by offering <em>ethically sourced</em> and <em>eco-friendly</em> nutritional products for the <em>performance-driven</em> athlete.</p>
</div>container tagline -->
</header>
<!-- #home -->



</section>
<section id="login" class="section">
    <div class="container tagline">
        <% if (request.getAttribute("message") != null) { %>
        <em><%=request.getAttribute("message")%>
        </em><br/>
        <%} %>

        <em>LOGIN USER</em>
        <form action="login" method="post">
            <label>Username</label> <input type="text" name="username"
                                           id="username"><br/> <label>Password</label> <input
                type="password" name="password" id="password"><br/> <input
                type="submit" value="Login">
        </form>
    </div>
</section>
<!-- #products -->


<footer class="footer">
    <div class="container">

        <nav class="nav" role="navigation">
            <div class="container nav-elements">
                <div class="branding">
                    <a href="#home"><img src="images/hpluslogo.svg"
                                         alt="Logo - H Plus Sports"></a>
                    <p class="address">
                        100 Main Street<br> Seattle, WA 98144
                    </p>
                </div>
            </div>
        </nav>

    </div>
    <!-- container -->
</footer>
<!-- footer -->
<%!

    public String displayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd hh:mm");
        Date toDate = Calendar.getInstance().getTime();
        return dateFormat.format(toDate);
    }

%>
</body>
</html>