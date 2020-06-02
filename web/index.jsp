<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                  background-image: url(atardecer-rafondos.jpg);
                  
            }
.formulario{
                  
                  width: 30%;
                  transition: 2s;
                  margin-top: 20px;
                  box-shadow: 0px 0px 40px #33cc00, 0px 0px 50px #00ff99, 0px 0px 80px white;
                  background-color: rgba(0,0,0,.1);
                  color: white;
                 
            }
            h1{
                color: red;
            }
             .s{
                text-align: center;
               margin: 0 auto;
               color: white;
                                 
                  width: 30%;
                  transition: 2s;
                  margin-top: 20px;
                  box-shadow: 0px 0px 40px #33cc00, 0px 0px 50px #00ff99, 0px 0px 80px white;
                  background-color: rgba(0,0,0,.1);
                  color: white;
            }
</style>
    </head>
    <body>
        <h1 class="s">Productos</h1>
        <p class="s"><a href="Inicio?action=add">nuevo registro</a></p>
        <div >
            <table border="1" class="s">
            <tr>
                <th>ID</th>
                <th>DESCRIPCION</th>
                <th>STOCK</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${avisos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.stock}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}">editar</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="confirm('esta seguro')">Eliminar</td>
                </tr>
            </c:forEach>

        </table>
            </div>

    </body>
</html>
