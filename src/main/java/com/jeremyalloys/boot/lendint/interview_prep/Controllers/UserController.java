package com.jeremyalloys.boot.lendint.interview_prep.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import com.jeremyalloys.boot.lendint.interview_prep.Models.User;
import com.jeremyalloys.boot.lendint.interview_prep.Services.UserServices;

@Controller
// This will house the logic of the whole User journey. Note
// that auth is not yet configured so don't be shocked to see 
// some adhoc functionality
public class UserController {
    private UserServices userServices;

    @Autowired
    public UserController(UserServices userServices){
        super();
        this.userServices = userServices;
    }

    // This posts user details to the db just to mimic a logged in user journey
    // We'll fetch the latest details in the table to represent the actor currently
    // touring our site
    // TODO: Implement LOGIN 
    @RequestMapping(value="api/users/post", method=RequestMethod.POST)
    public RedirectView processForm(@RequestParam(defaultValue="Guest") String email,
                              @RequestParam(required = false) String first_name, @ModelAttribute User user, Model model) {

        try{
        User user_object = new User();
        user_object.setEmail(email);
        user_object.setFirstName(first_name);

        userServices.save(user_object);
        model.addAttribute("user", user_object);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new RedirectView("home");
    }

    // This is how where our users are redirected after a successful 
    // login
    @RequestMapping("api/users/home")
    public String goHome(Model model){
        List<User> current_logged_in_user = userServices.getAllUsers();
        int user_id = current_logged_in_user.size();
        User user = current_logged_in_user.get(user_id-1);
        model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("userFirstName", user.getFirstName());


        return "home";
    }
}
