public class Person implements Comparable {
    private String name;
    private int age;
    public Person (String name, int age) {
       this.name = name;
       this.age = age;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    /* compareTo by age
    public int compareTo(Object o) {
        int retVal = 1;
        if (!(o instanceof Person)) {
            System.err.println("Parameter supplied to compareTo() not of same Class");
            System.exit(1);
        }
        else {
            Person p = (Person) o;
            if (p.getAge() > age) {
                retVal = -1;
            }
            else if (p.getAge() == age) {
                retVal = 0;
            }
        }
        return retVal;
    }
    */
    // compareTo by name
    public int compareTo(Object o) {
        if (!(o instanceof Person)) {
            System.err.println("Parameter supplied to compareTo() not of same Class");
            System.exit(1);
        }
        Person p = (Person) o;
        return name.compareTo(p.getName());
    }
    public String toString() {
        return "Name: " + name + " Age: " + age;
    }

}
