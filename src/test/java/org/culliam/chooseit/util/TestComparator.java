package org.culliam.chooseit.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: caiwm
 * Date: 13-4-15
 * Time: AM 8:25
 */
public class TestComparator {
   // private transient static Logger log = Logger.getLogger(TestComparator.class);

    @Test
    public void TestStringComparator() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("String");
        list.add("abc");
        list.add("STring");

        Collections.sort(list, new SpellComparator());
        System.out.println(list);
        //log.debug(list);

        StringBuilder sb = new StringBuilder(20);
        for(int i= 0; i<list.size();i++){
            sb.append(list.get(i));
        }

        MessageDigest md = null;
        String outStr = StringUtils.EMPTY;
        try{
            md = MessageDigest.getInstance("SHA-1");
            outStr = bytetoString(md.digest(sb.toString().getBytes()));
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(outStr);
        System.out.println(StringUtils.substring(outStr, 2, outStr.length()));

    }

    private String bytetoString(byte[] digest) {
        String str = "";
        String tempStr = "";

        for (int i = 1; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            }
            else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }

}
