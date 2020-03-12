package Demo03;

import java.time.LocalDateTime;

public class CalendarTest {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);
        System.out.println(tomorrow);
    }
}
