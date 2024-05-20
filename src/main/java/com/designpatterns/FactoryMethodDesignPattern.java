package com.designpatterns;

interface Notification {
    void notifyUser();
}

 class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}

 class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS Notification");
    }
}

 class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push Notification");
    }
}

 abstract class NotificationFactory {
    public abstract Notification createNotification();
}


 class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

 class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

 class PushNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new PushNotification();
    }
}


public class FactoryMethodDesignPattern {
    private NotificationFactory notificationFactory;

    public FactoryMethodDesignPattern(NotificationFactory factory) {
        this.notificationFactory = factory;
    }

    public void sendNotification() {
        Notification notification = notificationFactory.createNotification();
        notification.notifyUser();
    }

    public static void main(String[] args) {
        NotificationFactory emailFactory = new EmailNotificationFactory();
        FactoryMethodDesignPattern emailService = new FactoryMethodDesignPattern(emailFactory);
        emailService.sendNotification();

        NotificationFactory smsFactory = new SMSNotificationFactory();
        FactoryMethodDesignPattern smsService = new FactoryMethodDesignPattern(smsFactory);
        smsService.sendNotification();

        NotificationFactory pushFactory = new PushNotificationFactory();
        FactoryMethodDesignPattern pushService = new FactoryMethodDesignPattern(pushFactory);
        pushService.sendNotification();
    }
}
