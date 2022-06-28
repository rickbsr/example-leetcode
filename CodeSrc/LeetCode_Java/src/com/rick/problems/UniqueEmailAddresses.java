package com.rick.problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        int res = new UniqueEmailAddresses().numUniqueEmails(emails);
        System.out.println(res);
    }

    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for (String s : emails) {

            // 將 email 分成 local name 和 domain name
            String[] strings = s.split("@");

            // 將 local name 中 + 號後的字串濾掉
            String local = strings[0].split("\\+")[0];

            // 將 local name 中 . 號濾掉
            local = local.replace(".", "");

            // 將 local + domain 拼成完整的 email
            String eamil = local + strings[1];

            // 將 eamil 放進 set 中，set 不重覆特性來過濾
            set.add(eamil);
        }
        return set.size();
    }
}
