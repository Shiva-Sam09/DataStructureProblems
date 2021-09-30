class Solution {
        public String customSortString(String order, String str) {

                HashMap < Integer, Character > rankMap = new HashMap < > ();

                char orderArr[] = order.toCharArray();
                char strArr[] = str.toCharArray();

                int rankVal = 0;

                for (char ch: orderArr)
                        rankMap.put(++rankVal, ch);

                HashMap < Character, Integer > freqMap = new HashMap < > ();

                for (char val: strArr)
                        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);

                StringBuilder ans = new StringBuilder();

                for (int rank = 1; rank <= rankVal; ++rank) {
                        char ch = rankMap.get(rank);

                        // if(!freqMap.containsKey(ch))
                        //         continue;

                        for (int j = 0, len = freqMap.getOrDefault(ch, Integer.MIN_VALUE); j < len; ++j)
                                ans.append(ch);

                        freqMap.remove(ch);
                }

                Set < Character > keys_freqMap = freqMap.keySet();

                for (char key: keys_freqMap)
                        for (int j = 0, len = freqMap.get(key); j < len; ++j)
                                ans.append(key);

                return ans.toString();

        }
}
