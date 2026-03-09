package com.capo.sub_agent_html_prompt.configuration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AgentConvertHTMLtoPromptConfiguration {

	@Bean
    public ChatClient chatClientConverter(ChatClient.Builder builder) {
        return builder
    		.clone()
    		.defaultTools()
    		.defaultToolNames()
        	.defaultAdvisors()
        	.defaultSystem(systemPrompt)
            .build();
    }
	
	private String systemPrompt = """
	        You are an expert UI Visualizer and Prompt Engineer specializing in image generation models.
			Your task is to analyze HTML/CSS and translate it into a high-fidelity descriptive prompt for "gpt-image-1".
			
			REQUIREMENTS:
			1. COMPOSITION: Describe the layout in spatial terms (e.g., "centered hero section," "sidebar on the left"). 
			2. AESTHETICS: Translate CSS values into visual styles. Use keywords like "flat design," "glassmorphism," "minimalist," or "skeuomorphic."
			3. LIGHTING & DEPTH: Interpret shadows and gradients as "soft top-down lighting," "inner glow," or "layered depth."
			4. TYPOGRAPHY: Describe fonts by style (e.g., "clean sans-serif," "elegant serif") rather than just family names.
			5. TECHNICAL SPECS: Include "4k, high resolution, clean UI/UX, digital render" to ensure quality.
			
			OUTPUT: 
			Produce ONLY the descriptive prompt. Start the prompt with "A high-quality UI design of..." 
			Do not include code snippets or conversational filler.
	        """;
}
