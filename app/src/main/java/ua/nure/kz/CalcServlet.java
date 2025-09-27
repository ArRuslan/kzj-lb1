package ua.nure.kz;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@WebServlet("/test")
public class CalcServlet extends HttpServlet {
    private static final Log log = LogFactory.getLog(CalcServlet.class);

    public void init(ServletConfig config) {
        System.out.println("init btw");
    }

    public void destroy() {
        System.out.println("destroy btw");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.debug("Processing request with doGet...");

        String op = req.getParameter("op");
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");

        log.trace("op="+op);
        log.trace("a="+aStr);
        log.trace("b="+bStr);

        int a, b;

        try {
            a = Integer.parseInt(aStr);
            b = Integer.parseInt(bStr);
        } catch(NumberFormatException e) {
            log.error("Failed to parse numbers: {0}", e);
            return;
        }

        int result;
        switch (op) {
            case "add" -> result = Calc.add(a, b);
            case "subtract" -> result = Calc.subtract(a, b);
            case "multiply" -> result = Calc.multiply(a, b);
            case "divide" -> result = Calc.divide(a, b);
            default -> {
                log.error("Invalid operation: " + op);
                return;
            }
        }

        req.setAttribute("op", op);
        req.setAttribute("a", a);
        req.setAttribute("b", b);
        req.setAttribute("result", result);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
