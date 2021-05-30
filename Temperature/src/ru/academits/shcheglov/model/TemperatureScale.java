package ru.academits.shcheglov.model;

public interface TemperatureScale {
    double convertToCelsius(double temperature);

    double convertFromCelsius(double temperature);
}