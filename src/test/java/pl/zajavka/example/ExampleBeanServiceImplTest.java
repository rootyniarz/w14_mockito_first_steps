package pl.zajavka.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExampleBeanServiceImplTest {

    @InjectMocks
    private ExampleBeanServiceImpl exampleBeanService;

    @Mock
    private InjectedBeanService injectedBeanService;

    @Test
    void sampleMethod() {
        //given
        Mockito.when(injectedBeanService.someOtherMethod()).thenReturn("val1");
        Mockito.when(injectedBeanService.anotherSampleMethod()).thenReturn("val2");

        //when
        String result = exampleBeanService.sampleMethod();

        //then
        Assertions.assertEquals("val1val2",result);

        Mockito.verify(injectedBeanService,Mockito.times(1)).someOtherMethod();
        Mockito.verify(injectedBeanService,Mockito.times(1)).anotherSampleMethod();

    }


}