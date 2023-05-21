package pl.zajavka.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ExampleBeanServiceImplTest {

    @InjectMocks
    private ExampleBeanServiceImpl exampleBeanService;

    @Spy
    private List<String> sampleList = new ArrayList<>();

    @Test
    void thatSampleMethod_whenOneValueToAdd(){
        //given
        String testValue="testValue";

        //when
        exampleBeanService.sampleMethod(testValue);

        //then
        Mockito.verify(sampleList).add(Mockito.anyString()); //sprawadzamy czy został przekazany jakikolwiek String
        Mockito.verify(sampleList).add(testValue); // sprawdzamy czy została przekazana dokłądnie ta wartosc
        Assertions.assertEquals(1,sampleList.size()); //czy do listy zostł dodny 1 pozycja
    }

    @Test
    void thatSampleMethod_whenTwoValuesToAdd(){
        //given
        String testValue1="testValue1";
        String testValue2="testValue2";

        //when
        exampleBeanService.sampleMethod(testValue1,testValue2);

        //then 6:50 film #11 Mockowanie - Mockito - Spy
        Mockito.verify(sampleList, Mockito.times(2)).add(Mockito.anyString()); //sprawadzamy czy został przekazany jakikolwiek String oraz czy spy został wywołany x2
        Mockito.verify(sampleList).add(testValue1); // sprawdzamy czy została przekazana dokłądnie ta wartosc
        Mockito.verify(sampleList).add(testValue2); // sprawdzamy czy została przekazana dokłądnie ta wartosc
        Assertions.assertEquals(2,sampleList.size()); //czy do listy zostły dodne 2 pozycje
    }


}




