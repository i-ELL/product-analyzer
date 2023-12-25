package analyzer.controllers;

import java.util.List;

import analyzer.domain.models.Base;
import analyzer.services.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {
    private final BaseService baseService;

    @Autowired
    public BaseController(BaseService baseService) {
        this.baseService = baseService;
    }

    @PostMapping("/add")
    public void post(@RequestBody Base base) {
        baseService.addBase(base);
    }

    @GetMapping("/getAll")
    public @ResponseBody
    List<Base> getAll() {
        return baseService.findAll();
    }
}
