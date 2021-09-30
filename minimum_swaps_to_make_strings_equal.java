class Solution {
        public int minimumSwap(String s1, String s2) {

                if (s1.equals(s2))
                        return 0;

                int len = s1.length();

                int sumX = 0, sumY = 0, xy = 0, yx = 0;

                for (int i = 0; i < len; ++i) {

                        if (s1.charAt(i) == 'x')
                                ++sumX;

                        if (s2.charAt(i) == 'x')
                                ++sumX;

                        if (s1.charAt(i) == 'y')
                                ++sumY;

                        if (s2.charAt(i) == 'y')
                                ++sumY;

                }

                if (sumX % 2 != 0 || sumY % 2 != 0)
                        return -1;

                int ans = 0;

                for (int i = 0; i < len; ++i) {

                        char ch1 = s1.charAt(i);
                        char ch2 = s2.charAt(i);

                        if (ch1 == ch2)
                                continue;

                        if (ch1 == 'x' && ch2 == 'y')
                                ++xy;
                        else if (ch1 == 'y' && ch2 == 'x')
                                ++yx;

                }

                ans = xy / 2 + yx / 2;

                xy = xy % 2;

                ans += xy * 2;

                return ans;

        }
}
