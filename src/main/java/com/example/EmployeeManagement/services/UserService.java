package com.example.EmployeeManagement.services;

import com.example.EmployeeManagement.Helpers.UserHelper;
import com.example.EmployeeManagement.model.User;
import com.example.EmployeeManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    EmailSendService emailSendService;
    @Autowired RandomPasswordGenerator randomPasswordGenerator;
    @Autowired OtpGenerator otpGenerator;

    public void addUser(UserHelper userHelper) {
        // generate random password
        String password=randomPasswordGenerator.generateRandomPassword();

//        to set email subject and body
        String  subject=" Your Account Has Been Created Successfully.";
        String  body="Dear "+ userHelper.getFirstName()+",  \n" +
                "\n" +
                "We are pleased to inform you that your account on EMS has been created successfully.  \n" +
                "\n" +
                "Here are your account details:  \n" +
                "\n" +
                "*Email:"+ userHelper.getEmail()+"  \n" +
                "*Username:"+ userHelper.getFirstName()+"  \n" +
                "\n" +
                "You can now log in to access your account and explore the features we provide.  \n" +
                "\n" +

                "If you have any questions or require assistance, feel free to contact us at prajapatijaimala556@gmail.com.  \n" +
                "\n" +
                "Thank you for choosing *[Your App/Company Name]*. We look forward to serving you.  \n" +
                "\n" +
                "Best regards,  \n" +
                "JaiMAla  \n";

        emailSendService.sendEmail(userHelper.getEmail(), subject,body); // send email

        User user=new User();
        user.setFirstname(userHelper.getFirstName());
        user.setEmail(userHelper.getEmail());
        user.setPassword(randomPasswordGenerator.hashPassword(password));
        userRepo.save(user);
    }

    public String login(String email,String password){
       Optional<User>  user=userRepo.findByEmail(email);
       if(user.isEmpty()){
           return "user not found";
       }
       if (user.get().getPassword().equals(randomPasswordGenerator.hashPassword(password))){
           return  randomPasswordGenerator.generateRandomPassword();
       }
       return "password not matched";
    }

    public  String forget(String email){
      User user=userRepo.findByEmail(email).orElse(null);
        if(user==null){
            return "user not found";
        }
        int otp=otpGenerator.generateOtp();
        String subject="";
        String body="";

        emailSendService.sendEmail(email,subject,body);
        user.setOtp(otp);
        user.setPassword("");
        userRepo.save(user);

        return "you received otp on your email ";
    }
    public String update(int otp,String email,String password){
        return "";
    }


}
