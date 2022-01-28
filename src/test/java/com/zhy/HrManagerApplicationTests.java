package com.zhy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HrManagerApplicationTests {

    @Test
    void generateUsername() {

        String username = "zhy";

        String[] zhies = username.split("zhy1");
        System.out.println(zhies.length);
        for (String zhy : zhies) {
            System.out.println(zhy);
        }

        String username1 = "zhy12";

        String[] zhies1 = username1.split("zhy");
        System.out.println(zhies1.length);

        for (String s : zhies1) {
            System.out.println(s);
        }
    }

}
