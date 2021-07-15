package cn.sust.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置了Swagger的Docket实例
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    //配置Swagger信息 apiInfo
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "ylc的SwaggerAPI文档",
                "知道的越多，知道的越少",
                "v1.0",
                "https://www.bilibili.com/",
                new Contact("杨良晨",   //作者信息
                        "https://www.bilibili.com/",
                        "853703920@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
