class Person{
    private String name;
    private String password;
    private String address;
    
    Person(String name, String pass, String add){
        this.name = name;
        this.password = pass;
        this.address = add;
    }

    String getName(){
        return name;
    }
    String getPassword(){
        return password;
    }
    String getAddress(){
        return address;
    }
    public String toString() {
        return  "\nName : " + getName() +
                "\nPassword : " + getPassword() +
                "\nAddress : " + getAddress();
    }

}