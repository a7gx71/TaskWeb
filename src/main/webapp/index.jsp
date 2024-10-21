<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Task Manager</title>
</head>

<body>
    <h1>Task Manager</h1>

    <form action="Task" method = "post">
        <input type="text" name="taskName" placeholder="Enter task name" required>
        <input type="submit" name="action" value="add">
    </form>
    <h2>Task:</h2>

    <ul>
        <c:forEach var="task" items="${tasks}">
            <li>
            ${task.name}
                <form action="Task" method="post" style="display:inline;">
                    <input type="hidden" name="taskId" value="${task.id}">
                    <input type="submit" name="action" value="delete">
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
