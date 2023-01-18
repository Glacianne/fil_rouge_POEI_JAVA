package com.example.itraining_api.service;

import com.example.itraining_api.entity.Session;

import java.util.List;

public interface SessionService {
    Session saveSession(Session session);

    List<Session> findSessionList();

    Session updateSession(Session session, int id);

    void deleteSessionById(int id);

    Session findSessionById(int id);

}
