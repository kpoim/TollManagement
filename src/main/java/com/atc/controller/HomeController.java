package com.atc.controller;

import com.atc.entity.Client;
import com.atc.entity.ProClient;
import com.atc.entity.RetailClient;
import com.atc.service.ClientService;
import com.atc.service.ProClientService;
import com.atc.service.RetailClientService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("persistantClient")
@RequestMapping(name = "/", method = {RequestMethod.GET, RequestMethod.POST})
public class HomeController {

    @Autowired
    ProClientService proClientService;

    @Autowired
    RetailClientService retailClientService;

    @Autowired
    ClientService clientService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Authentication authentication, Principal principal, Model m) {
//	UserDetails ud = (UserDetails) authentication.getPrincipal();
//	System.out.println(ud.getUsername());
//	System.out.println(principal.getName());
//	System.out.println(authentication.getAuthorities().toString());
//	m.addAttribute("ud", ud);
        return "misc/landing-page";
    }

    @GetMapping("/register")
    public String newClientForm(@ModelAttribute("proClient") ProClient proClient, @ModelAttribute("retailClient") RetailClient retailClient) {
        return "user/register";
    }

    @PostMapping("/newProClient")
    public String newProClient(ProClient proClient) {
//        if (result.hasErrors()) {
//            return "user/register";
//        }
        proClientService.create(proClient);
        return "redirect:/";
    }

    @PostMapping("/newRetailClient")
    public String newRetailClient(RetailClient retailClient) {
//        if (result.hasErrors()) {
//            return "user/register";
//        }
        retailClientService.create(retailClient);
        return "redirect:/";
    }

    @GetMapping("/paypal")
    public String paypal() {

        return "paypal";
    }

    @GetMapping("/forgotten-password")
    public String forgottenPasswordPage() {
        return "misc/change-password/change-password-step1";
    }

    @GetMapping("/change-password-form/{username}")
    public String securityQuestions(@PathVariable("username") String username, ModelMap modelMap) {
        Client client = clientService.findByUsername(username);
        //String username= client.getUsername();
        String question = client.getQuestion();
        String answer = "";
        modelMap.addAttribute("persistantClient", client);
        modelMap.addAttribute("username", username);
        modelMap.addAttribute("question", question);
        modelMap.addAttribute("newanswer", answer);
        return "misc/change-password/change-password-step2";
    }

    @PostMapping("/check-answer")
    public String changePassword(@ModelAttribute("persistantClient") Client client,
             @ModelAttribute("username") String username, BindingResult resultUsername,
             @ModelAttribute("question") String question, BindingResult resultQuestion,
             @ModelAttribute("newanswer") String answer, BindingResult resultAnswer) {

        String correctAnswer = client.getAnswer();
        //answer = passwordEncoder.encode(answer);
        System.out.println("CORRECT ANSWER " + correctAnswer);
        System.out.println("GIVEN ANSWER " + answer);

        System.out.println("-----------------------------" + ((passwordEncoder.matches(answer, correctAnswer))));
        if ((passwordEncoder.matches(answer, correctAnswer))) {

            return "misc/change-password/change-password-step3";
        } else {
            System.out.println("Didn't match");
            return "misc/change-password/change-password-step2";
        }
    }

    @PostMapping("/new-password")
    public String newPassword(@ModelAttribute("persistantClient") Client client,
             @ModelAttribute("newPassword") String newPassword, BindingResult resultQuestion
    ) {
        System.out.println("New password " + newPassword);
        System.out.println("CLIENT" + client);
        System.out.println("CLIENT" + client.getClass());
        client.setPassword(passwordEncoder.encode(newPassword));
        clientService.changePassword(client);

//        return "redirect:/user";
        return "misc/change-password/change-password-step4";
    }

}
