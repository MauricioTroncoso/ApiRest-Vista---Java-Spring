/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CONTROLLER;

import MODEL.usuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vermi
 */
public class servletlogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
        URL url = new URL("http://localhost:8090/api/usuario/get/usuario/"+request.getParameter("user")+"/"+request.getParameter("pass"));
    
	HttpURLConnection connect = (HttpURLConnection) url.openConnection();
	connect.setRequestMethod("GET");
	connect.setRequestProperty("Accept", "application/json");

        String Salida="";
        
            if (connect.getResponseCode()==200) {
            InputStreamReader entrada = new InputStreamReader(connect.getInputStream());
            BufferedReader lectura = new BufferedReader(entrada);
            Salida= lectura.readLine();
                
            
        }else{ 
            request.getRequestDispatcher("errorlogin.jsp").forward(request, response);    
            System.out.println("Algo paso" + connect.getResponseCode());
        }

        usuario user= new usuario();
        
         if ("ADMIN".equals(Salida)) {
            user.setRole("ADMIN");
            HttpSession session = request.getSession();
            session.setAttribute("role",user.getRole() );
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        }
         else if ("USER".equals(Salida)) {
            user.setRole("USER");
            user.setUser(request.getParameter("user"));
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getUser());
            session.setAttribute("role",user.getRole() );
            String mensaje = "Bienvenido/a "+user.getUser();
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("menu.jsp").forward(request, response);
            }
        connect.disconnect();
        }catch(Exception e){
            System.out.println("Algo paso" + e.getMessage());
        }
       

        
    }

}
