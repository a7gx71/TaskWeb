package com.example.taskmanager.controller;

import com.example.taskmanager.dao.TaskDAO;
import com.example.taskmanager.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Task")
public class TaskController extends HttpServlet {
    private TaskDAO taskDAO = new TaskDAO();

    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Task> tasks = taskDAO.getAllTask();
        System.out.println("Tasks: " + tasks);
        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost method called");

        String action = request.getParameter("action");

        System.out.println("Action: " + action);

        if("add".equals(action)) {
            String taskName = request.getParameter("taskName");
            System.out.println("Task Name: " + taskName);
            taskDAO.addTask(taskName);
        } else if("delete".equals(action)) {
            int taskID = Integer.parseInt(request.getParameter("taskId"));
            taskDAO.deleteTask(taskID);
        }
        response.sendRedirect(request.getContextPath() + "/Task");
    }
}
