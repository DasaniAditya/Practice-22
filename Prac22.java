//Determine if string halves are alike

class Solution {
    public boolean halvesAreAlike(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        String a = s.substring(0, (s.length() / 2));
        String b = s.substring((s.length() / 2));
        HashSet<Character> set = new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count1 = 0;
        int count2 = 0;
        for(int i = 0 ; i < a.length(); i++) {
            if(set.contains(a.charAt(i))) {
                count1++;
            }
            if(set.contains(b.charAt(i))) {
                count2++;
            }
        }
        return count1 == count2;
    }
}

//Evaluate the bracket pairs off a string

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        if(s == null || s.length() == 0) {
            return "";
        }
        Map<String, String> map = new HashMap<>();
        for(List<String> k : knowledge) {
            String key = k.get(0);
            String val = k.get(1);
            map.put(key, val);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                i++;
                StringBuilder sb = new StringBuilder();
                while(s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }
                if(map.containsKey(sb.toString())) {
                    result.append(map.get(sb.toString()));
                } else {
                    result.append("?");
                }
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}