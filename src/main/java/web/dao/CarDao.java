package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDao {
    private static int COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++COUNT, "Volvo", "S40", 2005));
        cars.add(new Car(++COUNT, "Toyota", "MarkII", 1998));
        cars.add(new Car(++COUNT, "Nissan", "Skyline", 2010));
        cars.add(new Car(++COUNT, "MMC", "PageroIV", 2012));
        cars.add(new Car(++COUNT, "Ford", "F150", 2016));
    }

    public List<Car> index() {
        return cars;
    }

    public List<Car> showNum(int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
