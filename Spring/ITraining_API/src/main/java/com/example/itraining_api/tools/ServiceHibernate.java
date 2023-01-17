package com.example.itraining_api.tools;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceHibernate {
    private Session _session;

    public ServiceHibernate() {
        try {
            _session = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public Session getSession() {
        return this._session;
    }
}
