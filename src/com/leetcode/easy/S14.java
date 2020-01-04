package com.leetcode.easy;

public class S14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            //since we are testing prefix, index of should always testing zero
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public String longestCommonPrefixV(String[] strs) {
        if (strs.length == 0 || strs == null)
            return "";

        StringBuffer prefix = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = ' ';
            for(int j=0; j<strs.length; j++) {
                if(j == 0) {
                    temp = strs[j].charAt(i);
                }
                if(strs[j].length() < i + 1) {
                    return prefix.toString();
                } else if(strs[j].charAt(i) != temp) {
                    return prefix.toString();
                } else if(j == strs.length - 1) {
                    prefix = prefix.append(temp);
                }
            }
        }

        return prefix.toString();
    }

    public String longestCommonPrefixVSimple(String[] strs) {
        if (strs.length == 0 || strs == null)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for(int j=0; j<strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != temp) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
