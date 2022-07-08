package ru.project.main.desk.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/counters")
public class CounterController {

    private CounterDAO counterDAO;
    @Autowired
    public CounterController(CounterDAO counterDAO) {
        this.counterDAO = counterDAO;
    }

    @GetMapping()
    public String getListCounter(Model model){
        model.addAttribute("counters",counterDAO.getListCounterDAO());
        return "viewDesk/counter/viewCounter";
    }
}
