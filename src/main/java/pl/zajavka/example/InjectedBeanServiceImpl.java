package pl.zajavka.example;

public class InjectedBeanServiceImpl implements InjectedBeanService {
    @Override
    public String anotherSampleMethod(String someValue) {
        return "my value " + someValue;
    }
}
