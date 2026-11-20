package org.telusko.mcpserver;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskTools {

    private final List<String> tasks=new ArrayList<>();

    @McpTool(
            name="create_task",
            description = "Create a new task"
    )
    public String createTask(
            @McpToolParam(
                    description = "Title of the task",
                    required = true
            )
            String title
    )
    {
        tasks.add(title);
        return "Task created "+title;
    }

    @McpTool(
            name="list_tasks",
            description = "List the name of all tasks"
    )
    public String listTasks()
    {
        return List.copyOf(tasks).toString();
    }

    @McpTool(
            name="complete_task",
            description = "to finish a created task"
    )
    public String completeTask(
            @McpToolParam(
                    description = "name of the task to be created",
                    required = true
            )String title
    )
    {
        boolean done=tasks.remove(title);

        if(done)
        {
            return "Task completed "+title;
        }
        else
        {
            return "Task "+title+" not found";
        }
    }

}
