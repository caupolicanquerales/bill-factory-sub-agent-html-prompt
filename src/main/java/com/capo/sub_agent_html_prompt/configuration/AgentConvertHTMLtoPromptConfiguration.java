package com.capo.sub_agent_html_prompt.configuration;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;


@Configuration
public class AgentConvertHTMLtoPromptConfiguration {
	
	@Value("classpath:prompts/system-prompt.md")
    private Resource systemPromptResource;
	
	@Bean
    public String systemPrompt() throws IOException {
        return systemPromptResource.getContentAsString(Charset.defaultCharset());
    }

	@Bean
    public ChatClient chatClientConverter(ChatClient.Builder builder) {
        return builder
    		.clone()
    		.defaultTools()
    		.defaultToolNames()
        	.defaultAdvisors()
            .build();
    }
}
