package com.spring.boot.employees_emails.service;

import com.spring.boot.employees_emails.dto.EmailDto;
import java.util.List;

public interface EmailService {
    List<EmailDto> getAllEmails();
    EmailDto getEmailById(Long id);
    EmailDto createEmail(EmailDto dto);
    EmailDto updateEmail(EmailDto dto);
    void deleteEmail(Long id);
    List<EmailDto> getEmailsByName(String name);
    List<EmailDto> getEmailsByNames(List<String> names);
    List<EmailDto> getEmailsByContent(String content);
}
