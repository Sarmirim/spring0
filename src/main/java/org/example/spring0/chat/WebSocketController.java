package org.example.spring0.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Slf4j
@Controller
public class WebSocketController {

    // this template will be used to send private message to a specific user
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message sendMessage(@Payload Message message) {
        System.out.println(message);
        return message;
    }

    // instead of using sendTo  we used the simpMessagingTemplate to deliver the
    // message to a specific user
    @MessageMapping("/private-message")
    public Message addUser(@Payload Message chatMessage) {
        simpMessagingTemplate.convertAndSendToUser(chatMessage.getReceiverName(),"/private", chatMessage);
        return chatMessage;
    }
//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//        chatMessage.setTimestamp(new Date()); // Set the current timestamp
//        return chatMessage;
//    }
////    final private SimpMessagingTemplate template;
////
////    public WebSocketController(SimpMessagingTemplate template) {
////        this.template = template;
////    }
////
////    //    //    @CrossOrigin
//////    @MessageMapping("/sendMessage")
//////    @SendTo("/topic/messages")
//////    public String sendMessage(String message) {
//////        return message; // Echo the message back
//////    }
////    @MessageMapping("/message")
////    @SendTo("/chatroom/public")
////    public Message receivePublicMessage(@Payload Message message) {
////        System.out.println(message);
////        return message;
////    }
////
////    @MessageMapping("/private-message")
////    @SendTo("/chat")
////    public Message sendPrivateMessage(@Payload Message message) {
////        template.convertAndSendToUser(message.getReceiverName(), "/private", message);  // /user/{username}/private
////        return message;
////    }
}