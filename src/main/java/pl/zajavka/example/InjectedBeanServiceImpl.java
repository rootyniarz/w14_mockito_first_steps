package pl.zajavka.example;

public class InjectedBeanServiceImpl implements InjectedBeanService {
    @Override
    public String anotherSampleMethod() {
        return "my value ";
    }

    @Override
    public String someOtherMethod() {
        return "some other value";
    }
}
