package com.ai;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import com.ai.dto.DeepSeekApiChatMessage;
import com.ai.dto.DeepSeekChatRequestDTO;

import java.io.IOException;
import java.util.Arrays;

/**
 * @description:
 * @author: laomao
 * @date: 2/3/2025 下午 3:55
 */
public class DeepSeekApi {

    private static final String API_URL = "https://api.deepseek.com/chat/completions";
    private static final String API_KEY = "sk-0395f34732f940be91c0bcf42d998af8";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        DeepSeekChatRequestDTO chatRequest = getDeepSeekChatRequestDTO("如何接入 DeepSeek 接口, 项目中接入api能用来干嘛");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writeValueAsString(chatRequest);

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.Companion.create(jsonPayload, mediaType);
        // 创建请求
        Request request = new Request.Builder()
                .url(API_URL)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();
        // 发送请求并接收响应
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())  {
                throw new IOException("Unexpected code " + response);
            }
            // 输出响应体
            System.out.println(response.body().string());
        }
    }

    @NotNull
    private static DeepSeekChatRequestDTO getDeepSeekChatRequestDTO(String question) {
        DeepSeekApiChatMessage systemMessage = new DeepSeekApiChatMessage();
        systemMessage.setRole("system");
        systemMessage.setContent("你是一个优秀的架构师");
        DeepSeekApiChatMessage userMessage = new DeepSeekApiChatMessage();
        userMessage.setRole("user");
        userMessage.setContent(question);

        DeepSeekChatRequestDTO chatRequest = new DeepSeekChatRequestDTO();
        chatRequest.setModel("deepseek-chat");
        chatRequest.setMessages(Arrays.asList(systemMessage, userMessage));
        chatRequest.setStream(false);
        return chatRequest;
    }

}