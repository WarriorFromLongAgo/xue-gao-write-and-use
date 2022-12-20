package com.xuegao.config;

import com.xuegao.common.XueGaoConstant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = XueGaoConstant.XueGaoProperties.PROPERTIES_PREFIX)
public class XueGaoProperties {

    /**
     * enabled.
     */
    private boolean enabled = true;
    /**
     * If print banner.
     */
    private boolean enabledBanner = true;

    /**
     * Name.
     */
    private String name;

    private SimpleTpProperties tomcat;

    @Getter
    @Setter
    public static class SimpleTpProperties {
        /**
         * Name.
         */
        private String simpleName;
    }


}
