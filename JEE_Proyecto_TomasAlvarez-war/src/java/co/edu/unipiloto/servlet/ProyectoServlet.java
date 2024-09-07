package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.proyecto.entity.Proyectos;
import co.edu.unipiloto.arquitectura.proyecto.session.ProyectosFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tomas
 */
@WebServlet(name = "ProyectoServlet", urlPatterns = {"/ProyectoServlet"})
public class ProyectoServlet extends HttpServlet {

    @EJB
    private ProyectosFacadeLocal proyectosFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
        String action = request.getParameter("action");
        String idStr = request.getParameter("Id");
        Integer id = null;
        if (idStr != null && !idStr.isEmpty()) {
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "El ID debe ser un número válido.");
                List<Proyectos> allProyectos = proyectosFacade.findAll();
                request.setAttribute("allProyectos", allProyectos);
                request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
                return;
            }
        }

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nombredelproyecto = request.getParameter("nombredelproyecto");
        String descripcion = request.getParameter("descripcion");
        String localidad = request.getParameter("localidad");
        String presupuesto = request.getParameter("presupuesto");

        String habitantesStr = request.getParameter("numerodehabitantes");
        Integer habitantes = null;
        
        if (habitantesStr != null && !habitantesStr.isEmpty()) {
            try {
                habitantes = Integer.parseInt(habitantesStr);
            } catch (NumberFormatException e) {
                request.setAttribute("error", "El número de habitantes debe ser un número válido.");
                List<Proyectos> allProyectos = proyectosFacade.findAll();
                request.setAttribute("allProyectos", allProyectos);
                request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
                return;
            }
        }

        Proyectos proyectos = new Proyectos(id, nombre, apellido, nombredelproyecto, descripcion, localidad, presupuesto, habitantes);

        if ("Add".equalsIgnoreCase(action)) {
            proyectosFacade.create(proyectos);
        } else if ("Edit".equalsIgnoreCase(action)) {
            proyectosFacade.edit(proyectos);
        } else if ("Delete".equalsIgnoreCase(action)) {
            proyectosFacade.remove(proyectos);
        } else if ("Search".equalsIgnoreCase(action)) {
            if (id != null) {
                Proyectos proyecto = proyectosFacade.find(id);

                if (proyecto != null) {
                    request.setAttribute("proyecto", proyecto);
                } else {
                    request.setAttribute("error", "No se encontró ningún proyecto con el ID proporcionado.");
                }
            } else {
                request.setAttribute("error", "Por favor, ingresa un ID válido para buscar.");
            }
        }

        List<Proyectos> allProyectos = proyectosFacade.findAll();
        request.setAttribute("allProyectos", allProyectos);
        request.getRequestDispatcher("proyectoInfo.jsp").forward(request, response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProyectoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ProyectoServlet se puede ver: " + id + " " + nombre + " " + apellido + " " + nombredelproyecto + " " + descripcion + " " + localidad + " " + presupuesto + " " + habitantes + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
