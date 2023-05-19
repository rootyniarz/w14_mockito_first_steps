package pl.zajavka.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class ExampleBeanServiceImplTest {

//    @InjectMocks
    private ExampleBeanServiceImpl exampleBeanService;

//    @Mock
    private InjectedBeanService injectedBeanService;

    @BeforeEach
    void init(){
        this.injectedBeanService = Mockito.mock(InjectedBeanService.class);
        this.exampleBeanService = new ExampleBeanServiceImpl();
        this.exampleBeanService.setInjectedBeanService(injectedBeanService);
    }

    @ParameterizedTest
    @MethodSource
    void sampleMethod(String val1, String val2) {
        //given
        Mockito.when(injectedBeanService.someOtherMethod()).thenReturn(val1);
        Mockito.when(injectedBeanService.anotherSampleMethod()).thenReturn(val2);

        //when
        String result = exampleBeanService.sampleMethod();

        //then
        Assertions.assertEquals("val1val2",result);

        Mockito.verify(injectedBeanService,Mockito.times(1)).someOtherMethod();
        Mockito.verify(injectedBeanService,Mockito.times(1)).anotherSampleMethod();

    }

    static Stream<Arguments> sampleMethod(){
        return Stream.of(
                Arguments.of("val1","val2"),
                Arguments.of("val3","val4"),
                Arguments.of("val5","val6")
        );
    }


}