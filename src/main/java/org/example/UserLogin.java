package org.example;

import netscape.javascript.JSObject;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserLogin extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Initialised");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String usrName = req.getParameter("userName");
        String usrPass = req.getParameter("userPassword");

        // if request is invalid, return error response (user sends username and email to make acccount
        // return error response asking to send username and pass instead to make user
        if (usrName == null && usrPass == null) {
            String x = IOUtils.toString(req.getReader());
            JSONObject obj = new JSONObject(x);
            usrName = obj.get("userName").toString();
            usrPass = obj.get("userPassword").toString();

        }

        PrintWriter out = res.getWriter();
        res.setStatus(200);
        out.write("Created successfully!" + " " + "Username: " + usrName + " " + "Password: " + usrPass);
    }

    @Override
    public void destroy() {
        System.out.println("Now destroyed");
    }

}
