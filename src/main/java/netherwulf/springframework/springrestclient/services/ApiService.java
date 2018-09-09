package netherwulf.springframework.springrestclient.services;

import netherwulf.springframework.api.domain.User;

import java.util.List;

public interface ApiService {

    public List<User> getUsers(Integer limit);
}
