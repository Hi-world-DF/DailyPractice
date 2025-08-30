package com.ai.dto;

import lombok.Data;

import java.util.List;

/**
 * @description: deepSeek 聊天请求 DTO
 * @author: laomao
 * @date: 2/3/2025 下午 4:00
 */
@Data
public class DeepSeekChatRequestDTO {
    /**
     * 模型
     */
    private String model;

    /**
     * 消息数组
     */
    private List<DeepSeekApiChatMessage> messages;

    /**
     * 流
     */
    private boolean stream;
}
