package controller;

import DatabaseConnection.DatabaseConnection;
import Domain.User;
import Service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Avsek on 3/23/2017.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("log")) {

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new UserService().getUser(username, password);
            if(user == null){
                request.setAttribute("msg", "Incorrect Username Or Password");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            else{
                request.setAttribute("msg", "Logged in successfully");
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);

                RequestDispatcher rd = request.getRequestDispatcher("User/home.jsp");
                rd.forward(request, response);
            }
        }

        if (page.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();

            request.setAttribute("msg", "Logged out Successfully");

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
        if(page.equalsIgnoreCase("home")){
            // redirects to the homepage
            RequestDispatcher rd = request.getRequestDispatcher("User/home.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("signup")) {
            RequestDispatcher rd = request.getRequestDispatcher("User/signup.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("employeeList")) {        //for displaying list of employees
            List<User> userList =  new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("User/employee.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("addUser")) {
            RequestDispatcher rd = request.getRequestDispatcher("User/addUser.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("userByAdmin")) {
            String username = request.getParameter("username");  //add username
            String password = request.getParameter("password");   //add password
            String role = request.getParameter("role");             //add role

            new UserService().addUser(username, password, role);

            List<User> userList =  new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("User/employee.jsp");
            rd.forward(request, response);

        }

        if (page.equalsIgnoreCase("delete")) {
            String id = request.getParameter("id"); //retrieve username to be deleted

            new UserService().deleteUser(id);
            List<User> userList =  new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("User/employee.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("edit")) {       //get the id of the user to be edited
            int id = Integer.parseInt(request.getParameter("id"));
            User user = new UserService().editUser(id);
            //System.out.println(user.getUsername());
            request.setAttribute("user", user);

            RequestDispatcher rd = request.getRequestDispatcher("User/editUser.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("editByAdmin")) {
            User user = new User();
            int id = Integer.parseInt(request.getParameter("userId"));
            user.setId(id);
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));

            new UserService().updateUser(user);
            List<User> userList =  new UserService().getUserList();
            request.setAttribute("userList", userList);
            RequestDispatcher rd = request.getRequestDispatcher("User/employee.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}