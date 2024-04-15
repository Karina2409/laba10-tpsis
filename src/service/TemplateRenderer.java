package service;

import java.util.Map;

public interface TemplateRenderer {
    String render(String templateName, Map<String, Object> context);

}
