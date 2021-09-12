package ro.mh.ebanks.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
