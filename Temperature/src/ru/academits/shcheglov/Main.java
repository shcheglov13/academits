package ru.academits.shcheglov;

import ru.academits.shcheglov.model.CelsiusScale;
import ru.academits.shcheglov.model.FahrenheitScale;
import ru.academits.shcheglov.model.KelvinScale;
import ru.academits.shcheglov.model.TemperatureScale;
import ru.academits.shcheglov.view.TemperatureConverterView;

public class Main {
    public static void main(String[] args) {
        TemperatureScale[] scales = new TemperatureScale[]{new CelsiusScale(), new KelvinScale(), new FahrenheitScale()};
        TemperatureConverterView view = new TemperatureConverterView(scales);
        view.startView();
    }
}