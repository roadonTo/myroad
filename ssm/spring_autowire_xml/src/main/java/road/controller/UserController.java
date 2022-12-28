package road.controller;

import road.service.UserService;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void mSave() {
        userService.saveUser();
    }

}
