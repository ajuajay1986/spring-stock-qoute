package org.optimum.stocks.controllers;

import org.optimum.stocks.models.User;
import org.optimum.stocks.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 */
public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    private static final String errorTemplate = "error";
    private static final String errorMessageIdentifier = "message";

    public static final String userSessionKey = "user_id";

    public String displayError(String message, Model model) {
        model.addAttribute(errorMessageIdentifier, message);
        return errorTemplate;
    }

    public User getUserFromSession(HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute(userSessionKey);
        return userDao.findByUid(userId);
    }

}
