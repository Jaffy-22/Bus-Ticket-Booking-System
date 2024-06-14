package com.ladera.registration;

import com.ladera.userlogin.Userlogin;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {
    public String userName;
    public String emailId;
    public String mobileNumber;
    public String userPassword;
    public String confirmPassword;
    public static ArrayList<Registration> userDetails = new ArrayList<>();

    public Registration()
    {
        
    }

    public Registration(String userName, String emailId, String mobileNumber, String userPassword, String confirmPassword) {
        this.userName = userName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.userPassword = userPassword;
        this.confirmPassword = confirmPassword;
    }

    public int passwordRegistration(int flag) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        userName = scanner.nextLine();

        System.out.print("Enter email ID: ");
        emailId = scanner.nextLine();

        System.out.print("Enter mobile number: ");
        mobileNumber = scanner.nextLine();

        System.out.print("Enter password: ");
        userPassword = scanner.nextLine();

        System.out.print("Confirm password: ");
        confirmPassword = scanner.nextLine();

        if (isUserRegistered(userName, emailId, mobileNumber)) {
            flag = 1;
            System.out.println("User already registered. Please try logging in.");
            
        } else if (!userPassword.equals(confirmPassword)) {
            flag = 0;
            System.out.println("Passwords do not match. Please try again.");
        } else {
            flag = 1;
            System.out.println("Registration successful!");
            Registration newUser = new Registration(userName, emailId, mobileNumber, userPassword, confirmPassword);
            userDetails.add(newUser);
        }
        return flag;
    }

    public boolean isUserRegistered(String userName, String emailId, String mobileNumber) {
        for (Registration user : userDetails) {
            if (user.userName.equals(userName) || user.emailId.equals(emailId) || user.mobileNumber.equals(mobileNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyRegisteredUsers(Userlogin user) {
        for (Registration regUser : userDetails) {
            if (regUser.userName.equals(user.userName) && regUser.mobileNumber.equals(user.mobileNumber) && regUser.userPassword.equals(user.userPassword)) {
                return true;
            }
        }
        return false;
    }
}
