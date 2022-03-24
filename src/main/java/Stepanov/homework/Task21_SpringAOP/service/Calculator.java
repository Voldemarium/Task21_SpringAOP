package Stepanov.homework.Task21_SpringAOP.service;

import Stepanov.homework.Task21_SpringAOP.service.processors.DivideProcessor;
import Stepanov.homework.Task21_SpringAOP.service.processors.MultiplyProcessor;
import Stepanov.homework.Task21_SpringAOP.service.processors.SubtractProcessor;
import Stepanov.homework.Task21_SpringAOP.service.processors.SumProcessor;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
    private final SumProcessor sumProcessor;
    private final SubtractProcessor subtractProcessor;
    private final DivideProcessor divideProcessor;
    private final MultiplyProcessor multiplyProcessor;

    public Calculator(SumProcessor sumProcessor, SubtractProcessor subtractProcessor, DivideProcessor divideProcessor, MultiplyProcessor multiplyProcessor) {
        this.sumProcessor = sumProcessor;
        this.subtractProcessor = subtractProcessor;
        this.divideProcessor = divideProcessor;
        this.multiplyProcessor = multiplyProcessor;
    }

    @LogMethod
    public double sum(double arg1, double arg2) {
        return sumProcessor.process(arg1, arg2);
    }

    @LogMethod
    public double subtract(double arg1, double arg2) {
        return subtractProcessor.process(arg1, arg2);
    }

    @WorkTime
    public double divide(double arg1, double arg2) {
        return divideProcessor.process(arg1, arg2);
    }

    @WorkTime
    public double multiply(double arg1, double arg2) {
        return multiplyProcessor.process(arg1, arg2);
    }

}
