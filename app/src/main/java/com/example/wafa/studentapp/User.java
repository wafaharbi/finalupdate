package com.example.wafa.studentapp;


public class User {

    public String name,email , password , phone , username  , image , thumb_image  ,id,
            coursename, attendance;


    public User(String name, String email, String password,String username, String phone,String image , String thumb_image , String id){

        this.name= name;
        this.email= email;
        this.password= password;
        this.phone= phone;
        this.id=id;
        this.username=username;
        this.image=image;
        this.thumb_image= thumb_image;


    }

    public User(String name, String email, String password, String phone,String image , String thumb_image , String id
     ){
        this.name= name;
        this.email= email;
        this.password= password;
        this.phone= phone;
        this.id = id;
        this.image=image;
        this.thumb_image= thumb_image;

    }

    public  User(String name , String email , String phone){
        this.name= name;
        this.email= email;
        this.phone= phone;



    }

    public  User(String name, String email, String password, String phone){
        this.name= name;
        this.email= email;
        this.password= password;
        this.phone= phone;
    }

    public User(){

    }


    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String setPhone(String phone) {
        this.phone = phone;
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        this.username = username;
        return username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb_image() {
        return thumb_image;
    }

    public void setThumb_image(String thumb_image) {
        this.thumb_image = thumb_image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getAttendance() {
        return attendance;
    }

    public String setAttendance(String attendance) {
        this.attendance = attendance;
        return attendance;
    }


}
