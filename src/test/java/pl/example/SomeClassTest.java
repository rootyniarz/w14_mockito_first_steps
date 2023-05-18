package pl.example;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zajavka.example.SomeClass;
import pl.zajavka.example.SomeOtherClass;

@ExtendWith(MockitoExtension.class)
public class SomeClassTest {

    @InjectMocks
    private SomeClass someClass;

    @Mock
    private SomeOtherClass someOtherClass;
}
