package com.sonnesen.productsapi.application.usecases.category.update;

public record CategoryUpdateUseCaseInput(String id, String name, String description, boolean isActive) {

}
