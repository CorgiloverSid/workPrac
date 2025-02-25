package org.example;

import com.sun.istack.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Stream;


public class UserRegistration extends HttpServlet {
    static Logger logger = Logger.getLogger(UserRegistration.class);
    private static Properties properties = new Properties();

    @Override
    public void init() throws ServletException {
        logger.info("Initialised");
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(req.getInputStream(),User.class);

        String userName = user.getUserName();
        String userPassword = user.getUserPassword();

        if (user==null) {
            res.setStatus(400);
            res.sendError(400, properties.getProperty("bodyEmpty"));

        } else if (userName.isEmpty() && userPassword.isEmpty()) {
            res.setStatus(400);
            res.sendError(400, (String) properties.get("userAndPassEmpty"));

        } else if (userName.isEmpty()) {
            res.setStatus(400);
            res.sendError(400, (String) properties.get("userNameEmpty"));

        } else if (userPassword.isEmpty()) {
            res.setStatus(400);
            res.sendError(400, (String) properties.get("passEmpty"));

        } else {
            PrintWriter out = res.getWriter();

    if (!userExists(userName)) {
        if (isValidPassword(userPassword)) {
            out.write("Created successfully!" + " " + "Username: " + userName + " " + "Password: " + userPassword);
            res.setStatus(200);
            addUsers(user);
        } else {

            out.write((String) properties.get("passConformMessage"));
            res.setStatus(400);
            res.sendError(400, properties.get("passConformMessage") +
                    "");
        }
    } else {
        res.setStatus(400);
        res.sendError(400, (String) properties.get("userExist"));
    }

        }
    }

    public static boolean userExists(String userName) {
        File reader = new File((String) properties.get("registeredUsersPath"));

        try {
            ObjectMapper mapper = new ObjectMapper();
            if (reader.exists() && reader.length() > 0) {
                FileInputStream fileInputStream = new FileInputStream(reader);
                User[] users = mapper.readValue(fileInputStream, User[].class);
                return Arrays.stream(users).anyMatch(user -> user.getUserName().equalsIgnoreCase(userName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private void addUsers(User user) {
        File file = new File((String) properties.get("registeredUsersPath"));

        try {
            ObjectMapper mapper = new ObjectMapper();
            if (file.exists() && file.length() > 0) {
                FileInputStream fileInputStream = new FileInputStream(file);
                User[] users = mapper.readValue(fileInputStream, User[].class);
                User[] newUsers = addNewUsers(user, users);

                mapper.writeValue(file,newUsers);
            }else{
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                User[] users = new User[0];
                users = addNewUsers(user,users);
                mapper.writeValue(fileOutputStream,users);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static User[] addNewUsers(User user, User[] users) {
        User[] newUsers = Arrays.copyOf(users, users.length+1);
        newUsers[users.length] = user;
        return newUsers;
    }

    public static boolean
    isValidPassword(String password) {
        // Regex to check valid password.
        String regex = (String) properties.get("passValidRegex");

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);

        // Return if the password
        // matched the ReGex
        return m.matches();
    }

    @Override
    public void destroy() {
        logger.info("Now destroyed");
    }
}
