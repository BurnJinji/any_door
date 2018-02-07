package com.burning8393.any_door.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.boot.autoconfigure.template.TemplateLocation;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@ConditionalOnClass({ freemarker.template.Configuration.class,
        FreeMarkerConfigurationFactory.class })
@EnableConfigurationProperties(FreeMarkerProperties.class)
@Import({  org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration.FreeMarkerNonWebConfiguration.class })
public class FreeMarkerAutoConfiguration {

    private static final Log logger = LogFactory
            .getLog(FreeMarkerAutoConfiguration.class);

    private final ApplicationContext applicationContext;

    private final FreeMarkerProperties properties;

    public FreeMarkerAutoConfiguration(ApplicationContext applicationContext,
                                       FreeMarkerProperties properties) {
        this.applicationContext = applicationContext;
        this.properties = properties;
    }

    @PostConstruct
    public void checkTemplateLocationExists() {
        if (this.properties.isCheckTemplateLocation()) {
            TemplateLocation templatePathLocation = null;
            List<TemplateLocation> locations = new ArrayList<>();
            for (String templateLoaderPath : this.properties.getTemplateLoaderPath()) {
                TemplateLocation location = new TemplateLocation(templateLoaderPath);
                locations.add(location);
                if (location.exists(this.applicationContext)) {
                    templatePathLocation = location;
                    break;
                }
            }
            if (templatePathLocation == null) {
                logger.warn("Cannot find template location(s): " + locations
                        + " (please add some templates, "
                        + "check your FreeMarker configuration, or set "
                        + "spring.freemarker.checkTemplateLocation=false)");
            }
        }
    }
}
