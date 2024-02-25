class pengguna {
    private String username;
    private String password;

    public pengguna(String username, String password) {
    }

    public void User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return false;
    }

    public boolean isStudent() {
        return false;
    }

    public Object getNim() {
        return false;
    }
}