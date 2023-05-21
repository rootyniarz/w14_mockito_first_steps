package pl.zajavka.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleBeanServiceImpl implements ExampleBeanService {

    private List<String> sampleList = new ArrayList<>();

    @Override
    public void sampleMethod(String... valuesToAdd) {
        for (String value : valuesToAdd) {
            sampleList.add(value);
        }

//        sampleList.addAll(Arrays.asList(valuesToAdd));
    }
}
