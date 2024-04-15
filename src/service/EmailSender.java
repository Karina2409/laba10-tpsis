package service;

import entity.Email;

public interface EmailSender {
    void send(Email email);
}
