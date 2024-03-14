package com.cloudinn.backend.domain.service;

import com.cloudinn.backend.domain.exception.NotificationException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
public class EmailNotificationService implements NotificationService {

    private final JavaMailSender mailSender;
    private final Configuration freemarkerConfig;

    public EmailNotificationService(JavaMailSender mailSender, Configuration freemarkerConfig) {
        this.mailSender = mailSender;
        this.freemarkerConfig = freemarkerConfig;
    }

    @Override
    @Async
    public void send(Notification notification) {
        try {
            MimeMessage mimeMessage = createMimeMessage(notification);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new NotificationException("Não foi possível enviar o e-mail", e);
        }
    }

    private MimeMessage createMimeMessage(Notification notification) throws Exception {
        String body = processTemplate(notification);
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
        helper.setFrom("noreply@cloudinn.com");
        helper.setTo(notification.getReceiver());
        helper.setSubject(notification.getSubject());
        helper.setText(body, true);
        return mimeMessage;
    }

    protected String processTemplate(Notification notification) throws Exception {
        Template template = freemarkerConfig.getTemplate(notification.getBody());
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, notification.getVariables());
    }

}
