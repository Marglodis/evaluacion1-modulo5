package com.evaluacion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class OperacionesServlet
 */
@WebServlet("/OperacionesServlet")
public class OperacionesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OperacionesServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 10px; padding: 0; }");
        out.println("h2 { text-align: center; color: #333; }");
        out.println("form { width: 300px; margin: 20px auto; padding: 20px; background-color: #fff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }");
        out.println("input[type='number'] { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px; }");
        out.println("input[type='submit'] { width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; }");
        out.println("input[type='submit']:hover { background-color: #45a049; }");
        out.println("a { display: block; text-align: center; margin-top: 20px; color: #007BFF; text-decoration: none; font-size: 16px; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("p { text-align: center; font-size: 18px; color: #333; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<h2>Formulario para Sumar y Multiplicar</h2>");
        out.println("<form method='POST'>");
        
        //el atributo step='any' a los campos de entrada permite que el campo acepte cualquier número decimal, no solo enteros.
        out.println("Primer número: <input type='number' step='any' name='numero1' required><br>");
        out.println("Segundo número: <input type='number' step='any' name='numero2' required><br>");
        out.println("<input type='submit' value='Enviar'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("numero1");
        String num2 = request.getParameter("numero2");
        
        try {
            double numero1 = Double.parseDouble(num1);
            double numero2 = Double.parseDouble(num2);
            
            double suma = numero1 + numero2;
            double multiplicacion = numero1 * numero2;
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            out.println("<html><head>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 0; }");
            out.println("h2 { text-align: center; color: #333; }");
            out.println("p { text-align: center; font-size: 18px; color: #333; }");
            out.println("a { display: block; text-align: center; margin-top: 20px; color: #007BFF; text-decoration: none; font-size: 16px; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<h2>Resultados</h2>");
            out.println("<p>Suma: " + suma + "</p>");
            out.println("<p>Multiplicación: " + multiplicacion + "</p>");
            out.println("<a href='OperacionesServlet'>Volver al formulario</a>");
            out.println("</body></html>");
            
        } catch(NumberFormatException e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; padding: 0; }");
            out.println("h2 { text-align: center; color: #d9534f; }");
            out.println("p { text-align: center; font-size: 18px; color: #333; }");
            out.println("a { display: block; text-align: center; margin-top: 20px; color: #007BFF; text-decoration: none; font-size: 16px; }");
            out.println("a:hover { text-decoration: underline; }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<h2>Error: Ingrese números válidos</h2>");
            out.println("<a href='OperacionesServlet'>Volver al formulario</a>");
            out.println("</body></html>");
        }
    }
}
