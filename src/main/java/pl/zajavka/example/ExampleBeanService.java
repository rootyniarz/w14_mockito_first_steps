package pl.zajavka.example;

public interface ExampleBeanService {
    void setInjectedBeanService(InjectedBeanService injectedBeanService);
    String sampleMethod(String someValue);
}
