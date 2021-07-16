package cn.sust.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
    public Docket docket(Environment environment) {

        //设置显示swagger的环境
        Profiles profiles = Profiles.of("dev", "test");
        //获取项目环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)  //使swagger只在开发和测试环境有效
                .groupName("ylc")
                .select()
                //RequestHandl erSelectors 配置要扫描的接口方式
                //basePackage 指定要扫描的包
                //any()  扫描全部
                //none() 不扫描
                //withClassAnnotation 扫描类上的注解
                //withMethodAnnotation  扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("cn.sust.swagger.controller"))
                //paths过滤路径
                //  .paths(PathSelectors.ant("/sust/**"))
                .build();
    }

    //配置Swagger信息 apiInfo
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "ylc的SwaggerAPI文档",
                "知道的越多，知道的越少",
                "v1.0",
                "https://space.bilibili.com/19445530",
                new Contact("杨良晨",   //作者信息
                        "https://space.bilibili.com/19445530",
                        "853703920@qq.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket4() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
}
