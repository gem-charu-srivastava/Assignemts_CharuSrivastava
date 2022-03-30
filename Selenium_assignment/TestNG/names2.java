import org.testng.annotations.Test;

public class names2 {
    @Test
        public void d_testcase() {
            System.out.println("My profile is");
        }

        @Test(groups={"smoke"})
        public void e_testcase() {
            System.out.println("I am in gemini solution");
        }

        @Test(priority = 3)
        public void f_testcase() {
            System.out.println("My designation is GET");
        }}
