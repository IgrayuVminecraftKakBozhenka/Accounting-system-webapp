package ru.sibadi.demowebapp.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sibadi.demowebapp.domain.Payment;
import ru.sibadi.demowebapp.domain.Person;
import ru.sibadi.demowebapp.repository.PaymentRepository;
import ru.sibadi.demowebapp.repository.PersonRepository;


@Controller
public class PagesController {
    private final PersonRepository personRepository;
    private final PaymentRepository paymentRepository;

    public PagesController(PersonRepository personRepository, PaymentRepository paymentRepository) {
        this.personRepository = personRepository;
        this.paymentRepository = paymentRepository;
    }

    // GET http://localhost:8080/
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personRepository.findAllPersons());
        return "index"; // index.html
    }

    // GET http://localhost:8080/person/200
    @GetMapping("/person/{id}")
    public String personPage(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("person", personRepository.findPersonById(id));
        model.addAttribute("payments", paymentRepository.findPaymentsByPersonId(id));
        return "person"; // person.html
    }

    // GET http://localhost:8080/person/payment/200
    @GetMapping("/payment/{id}")
    public String paymentPage(
            @PathVariable("id") int id,
            Model model
    ) {
        model.addAttribute("payment", paymentRepository.findPaymentById(id));
        return "payment";
    }

    @PostMapping("/person/{id}")
    public String personEdit(
            @PathVariable("id") int id,
            @RequestParam("name") String name,
            @RequestParam("salary") int salary
    ) {
        Person person = personRepository.findPersonById(id);
        person.setName(name);
        person.setSalary(salary);
        return "redirect:/person/" + id;
    }



    @PostMapping("/person")
    public String personSave(
            @RequestParam("name") String name,
            @RequestParam("salary") int salary
    ) {
        personRepository.addPerson(name, salary);
        return "redirect:/";
    }

    @RequestMapping(value="/delete", method=RequestMethod.GET)
    public String deletePayment(@RequestParam("paymentId") int paymentId, Model model) {
        Payment payment = paymentRepository.findPaymentById(paymentId);
        int personId = payment.getPersonId();
        paymentRepository.deletePaymentById(paymentId);
        return "redirect:/person/" + personId;
    }

    @PostMapping("/payment/{id}")
    public String paymentEdit(
            @PathVariable("id") int id,
            @RequestParam("salary") int salary,
            @RequestParam("prize") int prize
    ) {
        Payment payment = paymentRepository.findPaymentById(id);
        payment.setSalary(salary);
        payment.setPrize(prize);
        return "redirect:/payment/" + id;
    }

    @PostMapping("/person/{personId}/payment")
    public String paymentSave(
            @PathVariable("personId") int personId,
            @RequestParam("salary") int salary,
            @RequestParam("prize") int prize,
            @RequestParam("date") String date
    ) {
        paymentRepository.addPayment(salary, prize, personId, date);
        return "redirect:/person/" + personId;
    }
}
