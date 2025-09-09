package csd.swdesign.book;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

   	private final ChatClient chatClient;

    // Inject the ChatClient.Builder and build the client
    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat")
    public String generate(@RequestParam(defaultValue = "Provide three facts about US tariffs") String prompt) {
        // Use the ChatClient to call the model
        return this.chatClient.prompt()
                .user(prompt) // Set the user's prompt
                .call()       // Make the API call
                .content();   // Get the response content as a String
    }
}
