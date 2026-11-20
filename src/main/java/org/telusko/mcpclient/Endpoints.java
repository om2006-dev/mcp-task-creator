package org.telusko.mcpclient;

import io.modelcontextprotocol.client.McpClient;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class Endpoints {

    private final McpService mcpService;

    public  Endpoints(McpService mcpService) {
        this.mcpService = mcpService;
    }

    @PostMapping("/query")
    public String query(@RequestBody String message) {
        return mcpService.chatService(message);
    }

}
