package Model;

public class Category {

    public String name;

    public int count = 0;

    public Category(String name) {

        this.name = name;
        count = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
