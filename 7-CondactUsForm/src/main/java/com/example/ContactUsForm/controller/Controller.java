package com.example.ContactUsForm.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ContactUsForm.model.ContactForm;


@org.springframework.stereotype.Controller
public class Controller {

	
	    @GetMapping("/contact")
	    public String showContactForm(Model model) {
	        model.addAttribute("contactForm", new ContactForm());
	        return "contact"; // This will render src/main/resources/templates/contact.html
	    }

	    @PostMapping("/contact")
	    public String submitContactForm(@ModelAttribute("contactForm") ContactForm contactForm) {
	        // Process the form submission (e.g., send an email, save to database, etc.)
	        System.out.println("Received contact form: " + contactForm);

	        // You can add further processing here, like sending an email
	        sendEmail(contactForm);

	        // Save the contact form data to a database (example: hypothetical save method)
	        saveToDatabase(contactForm);

	        // Redirect to a thank you page or show a success message
	        return "redirect:/contact/thankyou"; // Redirect to a thank you page
	    }

	    @GetMapping("/contact/thankyou")
	    public String showThankYouPage() {
	        return "thankyou"; // Create a thankyou.html page in templates folder
	    }

	    // Example method to send email (you need to implement this according to your email service)
	    private void sendEmail(ContactForm contactForm) {
	        // Implement email sending logic here
	        System.out.println("Sending email to: " + contactForm.getEmail() + " - Message: " + contactForm.getMessage());
	        // Example using JavaMailSender (you need to configure this bean in your Spring Boot application)
	        // mailSender.send(...);
	    }

	    // Example method to save form data to a database (you need to implement this according to your data access strategy)
	    private void saveToDatabase(ContactForm contactForm) {
	        // Implement database save logic here
	        System.out.println("Saving contact form data: " + contactForm);
	        // Example using JPA repository
	        // contactRepository.save(contactForm.toEntity()); // Assuming ContactForm has a corresponding JPA entity
	    }

}
