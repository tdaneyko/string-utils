package de.tuebingen.sfs.util.string;

import java.util.List;

/**
 * Faster String split() and join() implementations.
 */
public class StringUtils {
	
    public static String[] split(String s, char c) {
        String[] res = new String[count(s, c) + 1];
        int i = s.indexOf(c);
        int j = -1;
        int n = 0;
        while (i >= 0) {
            res[n] = s.substring(j+1, i);
            n++;
            j = i;
            i = s.indexOf(c, j+1);
        }
        res[n] = s.substring(j+1);

        return res;
    }

    public static String[] split(String s, String c) {
        String[] res = new String[count(s, c) + 1];
        int i = s.indexOf(c);
        int j = 0;
        int n = 0;
        while (i >= 0) {
            res[n] = s.substring(j, i);
            n++;
            j = i + c.length();
            i = s.indexOf(c, j);
        }
        res[n] = s.substring(j);

        return res;
    }

    public static String substringSep(String s, char c) {
        return substringSep(s, c, 0);
    }

    public static String substringSep(String s, char c, int start) {
        int i = s.indexOf(c, start);
        if (i < 0)
            return "";
        else
            return s.substring(start, i);
    }

    public static String lastSubstringSep(String s, char c) {
        return lastSubstringSep(s, c, s.length()-1);
    }

    public static String lastSubstringSep(String s, char c, int end) {
        int i = s.lastIndexOf(c, end);
        if (i < 0)
            return "";
        else
            return s.substring(i+1, end+1);
    }

    public static int count(String s, char c) {
        int n = 0;
        int i = s.indexOf(c);
        while (i >= 0) {
            n++;
            i = s.indexOf(c, i+1);
        }
        return n;
    }

    public static int count(String s, String c) {
        int n = 0;
        int i = s.indexOf(c);
        while (i >= 0) {
            n++;
            i = s.indexOf(c, i+1);
        }
        return n;
    }

    public static String join(String[] a, char c) {
        return join(a, c, 0, a.length);
    }

    public static String join(String[] a, char c, int from, int to) {
        StringBuilder s = new StringBuilder();
        for (int i = from; i < to; i++)
            s.append(a[i]).append(c);
        if (s.length() > 0) s.deleteCharAt(s.length()-1);
        return s.toString();
    }

    public static String join(Iterable<?> a, char c) {
        StringBuilder s = new StringBuilder();
        for (Object p : a)
            s.append(p.toString()).append(c);
        if (s.length() > 0) s.deleteCharAt(s.length()-1);
        return s.toString();
    }
    
    public static String join(Iterable<?> a, String c) {
        StringBuilder s = new StringBuilder();
        for (Object p : a)
            s.append(p.toString()).append(c);
        if (s.length() > 0) s.delete(s.length() - c.length(), s.length());
        return s.toString();
    }
    
    public static String join(String[] a, String c) {
        return join(a, c, 0, a.length);
    }

    public static String join(String[] a, String c, int from, int to) {
        if (from >= to)
            return "";
        StringBuilder s = new StringBuilder();
        for (int i = from; i < to; i++)
            s.append(a[i]).append(c);
        return s.delete(s.length()-c.length(), s.length()).toString();
    }

    public static String join(List<String> a, char c, int from, int to) {
        if (from >= to)
            return "";
        StringBuilder s = new StringBuilder();
        for (int i = from; i < to; i++)
            s.append(a.get(i)).append(c);
        return s.delete(s.length()-1, s.length()).toString();
    }

    public static String join(List<String> a, String c, int from, int to) {
        if (from >= to)
            return "";
        StringBuilder s = new StringBuilder();
        for (int i = from; i < to; i++)
            s.append(a.get(i)).append(c);
        return s.delete(s.length()-c.length(), s.length()).toString();
    }

    public static String join(int[] a, char c) {
        return join(a, c, 0, a.length);
    }

    public static String join(int[] a, char c, int from, int to) {
        if (from >= to)
            return "";
        StringBuilder s = new StringBuilder();
        for (int i = from; i < to; i++)
            s.append(a[i]).append(c);
        return s.deleteCharAt(s.length()-1).toString();
    }
}
