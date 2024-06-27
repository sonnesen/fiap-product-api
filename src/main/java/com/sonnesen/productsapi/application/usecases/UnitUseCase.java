package com.sonnesen.productsapi.application.usecases;

public abstract class UnitUseCase<IN> {

    public abstract void execute(IN input);
}
