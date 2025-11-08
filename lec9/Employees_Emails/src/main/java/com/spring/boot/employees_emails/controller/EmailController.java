package com.spring.boot.employees_emails.controller;

import com.spring.boot.employees_emails.dto.EmailDto;
import com.spring.boot.employees_emails.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<List<EmailDto>> getAllEmails() {
        return ResponseEntity.ok(emailService.getAllEmails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailDto> getEmailById(@PathVariable Long id) {
        return ResponseEntity.ok(emailService.getEmailById(id));
    }

    @PostMapping
    public ResponseEntity<EmailDto> createEmail(@RequestBody EmailDto dto) {
        return ResponseEntity.status(201).body(emailService.createEmail(dto));
    }

    @PutMapping
    public ResponseEntity<EmailDto> updateEmail(@RequestBody EmailDto dto) {
        return ResponseEntity.ok(emailService.updateEmail(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<List<EmailDto>> getEmailsByName(@PathVariable String name) {
        return ResponseEntity.ok(emailService.getEmailsByName(name));
    }

    @PostMapping("/by-names")
    public ResponseEntity<List<EmailDto>> getEmailsByNames(@RequestBody List<String> names) {
        return ResponseEntity.ok(emailService.getEmailsByNames(names));
    }

    @GetMapping("/by-content/{content}")
    public ResponseEntity<List<EmailDto>> getEmailsByContent(@PathVariable String content) {
        return ResponseEntity.ok(emailService.getEmailsByContent(content));
    }
}
