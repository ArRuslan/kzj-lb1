package ua.nure.kz;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class CalcServlet extends HttpServlet {

    public void init(ServletConfig config) {
        System.out.println("init btw");
    }

    public void destroy() {
        System.out.println("destroy btw");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String op = req.getParameter("op");
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        resp.getWriter().write("hfs it works yay\n");
        resp.getWriter().write(String.valueOf(op) + "\n");
        resp.getWriter().write(String.valueOf(a) + "\n");
        resp.getWriter().write(String.valueOf(b) + "\n");
        
    }

}
