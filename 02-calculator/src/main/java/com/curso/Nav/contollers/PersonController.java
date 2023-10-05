package com.curso.Nav.contollers;

import com.curso.Nav.exception.UnsuportedMathOperationException;
import com.curso.Nav.model.Person;
import com.curso.Nav.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices services;

    @RequestMapping(method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return services.findAll();
    }

    @RequestMapping(value = "/{id}",
    method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findId(@PathVariable("id") String id){
        return services.findId(id);
    }

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person){
        return services.createPerson(person);
    }

    @RequestMapping(method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@RequestBody Person person){
        return services.UpdatePerson(person);
    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") String id){
        services.deletePerson(id);
    }



    @RequestMapping(value = "/sum/{number1}/{number2}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "number1") String numeber1, @PathVariable(value = "number2") String numeber2) throws Exception {
        if (!isNumeric(numeber1) || !isNumeric(numeber2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        Double sum = convertToDouble(numeber1) + convertToDouble(numeber2);
        return sum;
    }

    @RequestMapping(value = "/sub/{number1}/{number2}", method = RequestMethod.GET)
    public Double Ssub(@PathVariable(value = "number1") String numeber1, @PathVariable(value = "number2") String numeber2) throws Exception {
        if (!isNumeric(numeber1) || !isNumeric(numeber2)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        Double sub = convertToDouble(numeber1) - convertToDouble(numeber2);
        return sub;
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
