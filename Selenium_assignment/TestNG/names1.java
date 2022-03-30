import org.testng.annotations.Test;

public class names1{
    @Test(groups={"smoke"})
    public void a_testcase() {
        System.out.println("Charu Srivastava ");
    }

    @Test(priority = 4)
    public void b_testcase() {
        System.out.println("I have installed testng");
    }

    @Test(priority = 5)
    public void c_testcase() {
        System.out.println("This is my first code");
    }}
