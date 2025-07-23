package src;

public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean isAcitve;

    public UserInfo(String name, int age, String email, boolean isAcitve) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isAcitve = isAcitve;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public boolean getActivityStatus(){
        return isAcitve;
    }

    public void setActivityStatus(boolean isAcitve){
        this.isAcitve= isAcitve;
    }

    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Email: "+email);
        System.out.println("isAcitve: "+isAcitve);
        System.out.println("\n -------------------------------- \n");
    }

    public static void main(String[] Args){
        UserInfo user1= new UserInfo("Ahmed", 19, "Ahmed@zyx.com", true);
        UserInfo user2= new UserInfo("Mohammed", 23, "Mohammed@zyx.com", false);
        UserInfo user3= new UserInfo("Hamed", 26, "Hamed@zyx.com", true);

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        System.out.println("user name:" + user2.getName());
        user2.setName("Mohd");
        System.out.println("user name updated to:" + user2.getName());

        System.out.println("user email:" +user3.getEmail());
        user3.setEmail("Hmd@xyz.com");
        System.out.println("user email updated to:" +user3.getEmail());

        System.out.println("user status:" + user2.getActivityStatus());
        user2.setActivityStatus(true);
        System.out.println("user status updated to:" +user2.getActivityStatus());

        System.out.println("user age:" + user1.getAge());
        user1.setAge(20);
        System.out.println("user age updated to:" +user1.getAge());
    }
}