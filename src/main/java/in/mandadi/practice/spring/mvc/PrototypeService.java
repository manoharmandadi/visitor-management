package in.mandadi.practice.spring.mvc;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeService {

    private static int beanCount = 1;

    public void printCount(){
        System.out.println(beanCount);
        PrototypeService.beanCount++;
    }
}
