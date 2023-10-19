package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 이건 설정정보다.
@ComponentScan(// 스프링 빈들을 다 긁어가지고 자동으로 저장해줌.
        //다 저장해주는데, 뺄거 지정.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
