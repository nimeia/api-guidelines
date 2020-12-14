package company.otherproject.client.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * 应该相关的spring 通用配置
 *
 * @author huang
 */
@Configuration
@ComponentScan({
        "company.otherproject.outapi"
})
public class AppConfig {

}
