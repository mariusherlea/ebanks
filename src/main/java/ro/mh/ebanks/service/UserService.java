package ro.mh.ebanks.service;


import ro.mh.ebanks.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}