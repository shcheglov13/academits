package ru.academits.shcheglov.controller;

import ru.academits.shcheglov.model.TemperatureScale;

public class TemperatureConverter {
    public double convert(TemperatureScale inputScale, TemperatureScale outputScale, double temperature) {
        return Math.round(outputScale.convertFromCelsius(inputScale.convertToCelsius(temperature)) * 100.0) / 100.0;
    }
}