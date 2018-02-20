package calcul.web.servlet;
import java.io.IOException;

import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
@WebServlet("/calculator")
public class CalculatorServlet extends AbstractGenericServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale.setDefault(Locale.ENGLISH);
        TemplateEngine templateEngine = this.createTemplateEngine(req);
        ServletContextTemplateResolver templateResolver= new ServletContextTemplateResolver(req.getServletContext());
        templateResolver.setCharacterEncoding("UTF-8");
        WebContext context = new WebContext(req, resp, req.getServletContext());


        templateEngine.process("calculMentalHTML", context, resp.getWriter());
    }
}