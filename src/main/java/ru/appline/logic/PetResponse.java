package ru.appline.logic;

public class PetResponse {
    String message;
    Pet pet;

    public PetResponse(String message, Pet pet) {
        this.message = message;
        this.pet = pet;
    }
}
