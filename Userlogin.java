package com.ladera.userlogin;

import com.ladera.registration.Registration;
import java.util.Random;
import java.util.Scanner;

public class Userlogin {
    public String userName;
    public String mobileNumber;
    public String userPassword;
    public int otp;

    public Userlogin(String userName, String mobileNumber, String userPassword, int otp) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.userPassword = userPassword;
        this.otp = otp;
    }

    public void passwordLogin(Registration reg) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        userName = scanner.nextLine();

        System.out.print("Enter mobile number: ");
        mobileNumber = scanner.nextLine();

        System.out.print("Enter password: ");
        userPassword = scanner.nextLine();

        Userlogin user = new Userlogin(userName, mobileNumber, userPassword, 0);
        boolean isVerified = reg.verifyRegisteredUsers(user);

        if (isVerified) {
            System.out.println("User Logged in Successfully!");
        } else {
            System.out.println("Password or Username Is Incorrect!!");
        }
    }

    public void otpLogin(Registration reg) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter mobile number: ");
        mobileNumber = scanner.nextLine();

        int systemOtp;
        Random random = new Random();
        systemOtp = 100000 + random.nextInt(900000);
        System.out.println("Your OTP is: " + systemOtp);

        System.out.print("Enter your OTP number: ");
        otp = scanner.nextInt();

        boolean isVerified = false;
        for (Registration regUser : Registration.userDetails) {
            if (regUser.mobileNumber.equals(mobileNumber) && systemOtp == otp) {
                isVerified = true;
                break;
            }
        }

        if (isVerified) {
            System.out.println("User Logged in Successfully!");
        } else {
            System.out.println("Mobile Number or OTP Is Invalid!!");
        }
    }
}
