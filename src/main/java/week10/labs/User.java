package week10.labs;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Annotations
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface CanSendMessage {}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface RequiresPermission {
    String level();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface UserPermission {
    String level();
}

// User Classes
abstract class User {
    protected String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

@UserPermission(level = "Admin")
class AdminUser extends User {
    public AdminUser(String username) {
        super(username);
    }
}

@UserPermission(level = "Regular")
class RegularUser extends User {
    public RegularUser(String username) {
        super(username);
    }
}

// Messaging System
class MessagingSystem {
    @CanSendMessage
    @RequiresPermission(level = "Admin")
    public void sendMessage(User user) {
        if (user instanceof AdminUser) {
            System.out.println(user.getUsername() + " sent a message!");
        } else {
            System.out.println(user.getUsername() + " is restricted from sending messages.");
        }
    }

    public static void main(String[] args) {
        MessagingSystem system = new MessagingSystem();
        AdminUser admin = new AdminUser("AdminAlice");
        RegularUser user = new RegularUser("UserBob");

        system.sendMessage(admin);
        system.sendMessage(user);
    }
}

