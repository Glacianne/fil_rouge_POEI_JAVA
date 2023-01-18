package com.example.itraining_api.service;

import com.example.itraining_api.entity.LearnerAccount;
import com.example.itraining_api.entity.Session;
import com.example.itraining_api.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService{
    @Autowired
    private SessionRepository sessionRepository;
    @Override
    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public List<Session> findSessionList() {
        return (List<Session>)  sessionRepository.findAll();
    }

    @Override
    public Session updateSession(Session session, int id) {
        Session session1 = sessionRepository.findById(id).get();
        return sessionRepository.save(session1);

    }

    @Override
    public void deleteSessionById(int id) {
        sessionRepository.deleteById(id);
    }

    @Override
    public Session findSessionById(int id) {
        return null;
    }
}
