package com.firstservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static String VALID_NAME_PATTERN="[A-Z]{1}[a-z]{2,}$";
    static String VALID_PASSWORD_PATTERN="((?=.[a-z])(?=.\\\\d)(?=.[A-Z])(?=.[@#$%!]).{8,40}) ";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userName");
        String password = req.getParameter("userPassword");

        if(validateUserId(userId) && validatePassword(password)){
            req.setAttribute("user",userId);
            req.getRequestDispatcher("registrationsuccess.jsp").forward(req,resp);
        }
        else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Registration.html");
            PrintWriter writer = resp.getWriter();
            writer.println("<font color=red> Either userName or password is in invalid format. </font>");
            requestDispatcher.include(req,resp);
        }
    }

    private boolean validatePassword(String password) {
        Pattern pattern=Pattern.compile(VALID_PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
       // return matcher.matches();
        return true;
    }

    private boolean validateUserId(String userId) {
       // return userId.matches(VALID_NAME_PATTERN);
        return true;
    }
}
