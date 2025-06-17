package twopinter;

public class BackspaceStrings {
    public static void main(String[] args) {
        String s = "a", t = "aa#a";
        System.out.println(areStringsEqual(s, t));
//        System.out.println(getNextPointer("asbc##",1));
    }

    public static boolean areStringsEqual(String s, String t) {
        int p1 = s.length()-1;
        int p2 = t.length()-1;
        while(p1>=0 || p2>=0) {
            int backSpaces = 0;
            while(p1>=0) {
                if (s.charAt(p1)=='#') {
                    backSpaces++;
                    p1--;
                } else if (backSpaces>0) {
                    backSpaces--;
                    p1--;
                } else {
                    break;
                }
            }

            backSpaces = 0;
            while(p2>=0) {
                if (t.charAt(p2)=='#') {
                    backSpaces++;
                    p2--;
                } else if (backSpaces>0) {
                    backSpaces--;
                    p2--;
                } else {
                    break;
                }
            }
            if(p1 >=0 && p2>=0) {
                if (s.charAt(p1) != t.charAt(p2)) {
                    return false;
                }
            } else if (p1>=0 || p2>=0){
                return false;
            }
            p1--;
            p2--;
        }
        return true;
    }
}
