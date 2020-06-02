<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        .s{
                
                                 
                  width: 30%;
                  transition: 2s;
                  margin-top: 20px;
                  box-shadow: 0px 0px 40px #33cc00, 0px 0px 50px #00ff99, 0px 0px 80px white;
                  background-color: rgba(0,0,0,.1);
                  
            }
            </style>
    </head>
    <body>
        <h1>
            <c:if test="${aviso.id == 0}">NUEVO</c:if>
   <c:if test="${aviso.id  !=0}"> Editar</c:if>
   registro</h1>
           <form action="Inicio" method="post">
               <table class="s">
                   
                   <tr>
                       <input type="hidden" name="id" value="${aviso.id}">
                   <td>   <label>Descripcion:</label></td>
                   <td><input type="text" name="descripcion" value="${aviso.descripcion}"></td>
                   
             
                   </tr>
                   <tr>
                    <td><label>Stock:</label></td>
                   <td> <input type="int" name="stock" value="${aviso.stock}"> </td>
                    </tr>
                   <tr>
                    <td><input type="submit" value="Enviar"></td>
                     
                   </tr>
               </table>
               
           </form>
    </body>
</html>
