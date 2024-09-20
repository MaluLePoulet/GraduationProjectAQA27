package models;

public class User {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private User newUser;

        public Builder() {
            this.newUser = new User();
        }

        public Builder setEmail(String username) {
            newUser.email = username;
            return this;
        }

        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}