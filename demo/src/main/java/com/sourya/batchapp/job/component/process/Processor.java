package com.sourya.batchapp.job.component.process;

public interface Processor<T>{
	T process(T input);

}
