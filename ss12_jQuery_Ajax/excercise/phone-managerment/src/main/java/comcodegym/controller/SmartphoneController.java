package comcodegym.controller;


import comcodegym.model.Smartphone;
import comcodegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService iSmartphoneService;

    @PostMapping("/create")
    public ResponseEntity<Void> createSmartphone(@RequestBody Smartphone smartphone) {
        iSmartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Smartphone>> allPhones(Pageable pageable) {
        Page<Smartphone> smartphones = iSmartphoneService.findAll(pageable);
        if (!smartphones.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("smartphones", iSmartphoneService.findAll(pageable));
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iSmartphoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Optional<Smartphone>> getPhone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = iSmartphoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Iterable<Smartphone>> updateSmartphone(@RequestBody Smartphone smartphone,Pageable pageable) {
        iSmartphoneService.save(smartphone);
        return new ResponseEntity<>(iSmartphoneService.findAll(pageable), HttpStatus.NO_CONTENT);
    }
}