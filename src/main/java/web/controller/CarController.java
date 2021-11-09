package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;

@Controller
public class CarController {

    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String showNum(@RequestParam(value="count", required = false) Integer count, Model model) {
        if(count != null) {
            model.addAttribute("cars", carDao.showNum(count));
        } else {
            model.addAttribute("cars", carDao.index());
        }
        return "/cars";
    }
}
