package pl.zajavka.example;

import java.time.LocalTime;

public class StaticMethodExample {

    public int getNano(){
        LocalTime now = getNow();
        return now.getNano();
    }

    public LocalTime getNow() {
        return LocalTime.now();
    }
}
