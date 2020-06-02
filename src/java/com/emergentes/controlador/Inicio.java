
package com.emergentes.controlador;



import com.emergentes.dao.AvisoDAO;
import com.emergentes.dao.AvisoDAOi;
import com.emergentes.modelo.Aviso;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
         
            AvisoDAO dao = new AvisoDAOi();
            //para recibir el id
            int id;
            //para gestionar registros
            Aviso avi = new Aviso();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view" ;
            switch(action){
               case  "add":
                   //nuevo registro
                  request.setAttribute("aviso", avi);
                  request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                  break; 
               case "edit":
                   //para editar un registro
                   id = Integer.parseInt(request.getParameter("id"));
                   avi = dao.getById(id);
                   request.setAttribute("aviso", avi);
                   request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                  break;
               case "delete":
                   //para eliminar un rgistro
                  id = Integer.parseInt(request.getParameter("id"));
                   dao.delete(id);
                   //request.getRequestDispatcher("Inicio").forward(request, response);
                  response.sendRedirect(request.getContextPath()+"/Inicio");
                 break;
               case "view":
                   //listar los registros
                   List<Aviso> lista = dao.getAll();
                request.setAttribute("avisos", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                default:  
                break; 
                 
            }
                
            
            
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      // peticion desde el formulario metodo doPost
        // peticion desde el url metodo doGet
          AvisoDAO dao =  new AvisoDAOi();
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
       int stock = Integer.parseInt(request.getParameter("stock"));
   
    Aviso avi = new Aviso();
    
    avi.setId(id);
    avi.setDescripcion(descripcion);
    avi.setStock(stock);
    
    if(id == 0){
        //nuevo registro
        try {
            dao.insert(avi);
            response.sendRedirect("Inicio");
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
        
    }else{
        //actualizacion de un registro
         try {
            dao.update(avi);
            response.sendRedirect("Inicio");
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
    }
    }

   
  
}
