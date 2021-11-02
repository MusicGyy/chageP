package datasqltest;

public class ModelTable {

    int id;

    String name,addess,phone;

    public ModelTable(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ModelTable(int id, String name, String addess, String phone) {
        this.id = id;
        this.name = name;
        this.addess = addess;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddess() {
        return addess;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
