package org.telusko.mcpclient;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;

@Service
public class McpService {

    private final ChatClient chatclient;

    public McpService(ChatClient.Builder chatclient, ToolCallbackProvider mcpTools) {
        this.chatclient = chatclient.defaultTools(mcpTools).build();

    }

    public String chatService(String message)
    {
        return chatclient.prompt()
                .user(message)
                .call()
                .content();
    }
}
