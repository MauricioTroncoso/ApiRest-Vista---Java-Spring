/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CONTROLLER;

import MODEL.categoria;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vermi
 */
public class servleteditcategoria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs,
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            try{
                Client client = ClientBuilder.newClient();
                WebTarget target = client.target("http://localhost:8090/api/categoria/"+ request.getParameter("id"));

                categoria cat = new categoria();
                cat.setNombre(request.getParameter("nombre_categoria"));
                Gson gson= new Gson();
                String jsonString = gson.toJson(cat);

                Invocation.Builder solicitud = target.request();
                Response post = solicitud.put(Entity.json(jsonString));
      
                request.getRequestDispatcher("categoria.jsp").forward(request,response);
            }
            catch(Exception e){
            System.out.println("Algo paso" + e.toString());
            }
    }
    }

