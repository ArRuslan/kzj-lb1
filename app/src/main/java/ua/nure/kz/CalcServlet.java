package ua.nure.kz;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@WebServlet("/calculate")
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
            log.error("Failed to parse numbers!", e);
            return;
        }

        int result = 0;
        String error = null;
        switch (op) {
            case "add" -> result = Calc.add(a, b);
            case "subtract" -> result = Calc.subtract(a, b);
            case "multiply" -> result = Calc.multiply(a, b);
            case "divide" -> {
                if(b == 0) {
                    error = "Cannot divide by 0!";
                } else {
                    result = Calc.divide(a, b);
                }
            }
            default -> {
                log.error("Invalid operation: " + op);
                return;
            }
        }

        req.setAttribute("op", op);
        req.setAttribute("a", a);
        req.setAttribute("b", b);
        req.setAttribute("result", error != null ? error : String.valueOf(result));

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
