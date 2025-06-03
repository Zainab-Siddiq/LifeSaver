

class Responder extends User {
    private String department;

    public Responder(String name, String phone, String department) {
        super(name, phone);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

    
