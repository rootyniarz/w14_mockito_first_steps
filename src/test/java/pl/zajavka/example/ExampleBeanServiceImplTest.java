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
        Mockito
                .doReturn("some value")
                .when(injectedBeanService)
                .anotherSampleMethod(ArgumentMatchers.anyString());

        //when
        String result = exampleBeanService.sampleMethod("");

        //then
        Assertions.assertEquals("some value",result);
    }


}