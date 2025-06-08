package models;

public class UserLogin {


    private String email;
    private String password;

    UserLogin(UserBuilder userBuilder){

        this.email = userBuilder.email;
        this.password = userBuilder.password;
    }
    //getters

    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    //builder
    public static class UserBuilder{


        private String email;
        private String password;
        //Setters

        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }
        public UserBuilder setPassword(String password){
            this.password = password;
            return this;
        }
        public UserLogin builder(){
            return new UserLogin(this);
        }

    }





}

