package cn.footman.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kokio
 * @create 2019-03-05 14:28
 */
@Component
@ConfigurationProperties(prefix = "projectUrl")
@Data
public class ProjectUrlConfig {

    public String sell;
}
