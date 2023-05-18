package pl.zajavka.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleBeanServiceImplTest {

    @Test
    void sampleMethod() {
        //given
        ExampleBeanService exampleBeanService = new ExampleBeanServiceImpl();
        exampleBeanService.setInjectedBeanService(new InjectedBeanService() {
            @Override
            public boolean anotherSampleMethod() {
                return true;
            }
        });

        //when
        boolean result = exampleBeanService.sampleMethod();

        //then
        Assertions.assertEquals(true,result);
    }

    static class StubInjectedBeanService implements InjectedBeanService{

        @Override
        public boolean anotherSampleMethod() {
            return false;
        }
    }
}