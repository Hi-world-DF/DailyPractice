package src.com.ai.dto;

import lombok.Data;

/**
 * @description: 聊天消息
 * @author: laomao
 * @date: 2/3/2025 下午 4:05
 */
@Data
public class DeepSeekApiChatMessage {
    /**
     * 角色
     */
    private String role;

    /**
     * content
     */
    private String content;
}
