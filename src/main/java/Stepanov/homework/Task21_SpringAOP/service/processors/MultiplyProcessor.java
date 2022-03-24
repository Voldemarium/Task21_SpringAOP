package Stepanov.homework.Task21_SpringAOP.service.processors;

import Stepanov.homework.Task21_SpringAOP.service.Processor;
import org.springframework.stereotype.Component;

@Component
public class MultiplyProcessor implements Processor {

    @Override
    public double process(double arg1, double arg2) {
        return arg1 * arg2;
    }
}
