package partner;

import java.io.IOException;

public class FreemarkerTemplateRenderer {

    private final Configuration configuration;

    public FreemarkerTemplateRenderer() {
        configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setClasspathTemplateLoader();
    }

    @Override
    public String render(String templateName, Map<String, Object> context) {
        try {
            Template template = configuration.getTemplate(templateName);
            return template.process(context);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
