package road.on.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import road.on.interceptor.LoginInterceptor;

//@Configuration  注释掉 就不会被识别为配置类，就不会生效了
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)//添加拦截器
                .addPathPatterns("/**")  //配置拦截路径
                .excludePathPatterns("/sys_user/login");//配置排除路径
    }
}
