package pl.zajavka.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

class StaticMethodExampleTest {

    private StaticMethodExample staticMethodExample = new StaticMethodExample();

    @Test
    void testGetNanoNow() {
        //given
        var now = LocalTime.now();
        int nanoNow = now.getNano();
        LocalTime nowEarlier = now;//.minusNanos(100);
        int nanoEarlier = nowEarlier.getNano();


        int result;
        try (MockedStatic<LocalTime> timeMock = Mockito.mockStatic(LocalTime.class)){
            timeMock.when(LocalTime::now).thenReturn(nowEarlier);
            //when
            result = staticMethodExample.getNano();
        }

        //then
        Assertions.assertEquals(result, nanoEarlier);

    }
}