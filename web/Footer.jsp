<%-- 
    Document   : Footer
    Created on : 25-Dec-2019, 22:55:06
    /*copyright by fu hub*/
    /*link group https://www.facebook.com/groups/498752080529382/*/
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/footer.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="footer">
            <a href="#">Create with SimpleSite</a>
            <div id = "view" class="view">${view}</div>
        </div>
    </body>
    <script>
        function formatView(content) {
            while (content.length < 6) {
                content = "0" + content;
            }
            return content;
        }
        let view = document.getElementById("view");
        let content = "";

        let originContent = formatView(view.textContent);
        for (let i = 0; i < originContent.length; i++) {
            content += "<span class='view-number'>" + originContent[i] + "</span>";
        }

        view.innerHTML = content;

        

    </script>
</html>
