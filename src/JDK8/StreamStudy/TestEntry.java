package JDK8.StreamStudy;

public class TestEntry{

    public TestEntry(){

    }

    public TestEntry(int property1, String property2) {
        this.property1 = property1;
        this.property2 = property2;
    }

    public void testObjInstanceMethod(){
        System.out.println("Hello Obj - Instance Method " + getProperty2());
    }

    public int property1;
    public String property2;

    @Override
    public String toString() {
        return "TestEntry{" +
                "property1=" + property1 +
                ", property2='" + property2 + '\'' +
                '}';
    }

    public int getProperty1() {
        return property1;
    }

    public void setProperty1(int property1) {
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TestEntry)
            return this.getProperty2().equals(((TestEntry)obj).getProperty2()) && this.getProperty1() == ((TestEntry)obj).getProperty1();
        else return false;
    }

    @Override
    public int hashCode() {
        return this.getProperty2().hashCode();
    }
}
