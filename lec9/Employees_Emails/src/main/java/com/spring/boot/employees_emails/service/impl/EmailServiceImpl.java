package com.spring.boot.employees_emails.service.impl;

import com.spring.boot.employees_emails.dto.EmailDto;
import com.spring.boot.employees_emails.mapper.EmailMapper;
import com.spring.boot.employees_emails.model.Email;
import com.spring.boot.employees_emails.repo.EmailRepo;
import com.spring.boot.employees_emails.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepo emailRepo;

    @Autowired
    private EmailMapper emailMapper;

    @Override
    public List<EmailDto> getAllEmails() {
        return emailRepo.findAll().stream().map(emailMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmailDto getEmailById(Long id) {
        return emailRepo.findById(id).map(emailMapper::toDto).orElse(null);
    }

    @Override
    public EmailDto createEmail(EmailDto dto) {
        return emailMapper.toDto(emailRepo.save(emailMapper.toEntity(dto)));
    }

    @Override
    public EmailDto updateEmail(EmailDto dto) {
        return emailMapper.toDto(emailRepo.save(emailMapper.toEntity(dto)));
    }

    @Override
    public void deleteEmail(Long id) {
        emailRepo.deleteById(id);
    }

    @Override
    public List<EmailDto> getEmailsByName(String name) {
        return emailRepo.findByName(name).stream().map(emailMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailsByNames(List<String> names) {
        return emailRepo.findByNameIn(names).stream().map(emailMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<EmailDto> getEmailsByContent(String content) {
        return emailRepo.findByContent(content).stream().map(emailMapper::toDto).collect(Collectors.toList());
    }
}
