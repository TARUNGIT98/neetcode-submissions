class Solution {
    final char DELIMITER = '#';
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }
    return sb.toString(); // sb back to string
    }

    public List<String> decode(String str) {
        //5#HELLO5#TARUN (Assuming the encoded string)
        List<String> result = new LinkedList<>();
        char[] arr = str.toCharArray();

        for(int i = 0;i<arr.length;i++) {
            // Finding no. of charaters
           StringBuilder sb = new StringBuilder();
           while(arr[i] != DELIMITER){
            sb.append(arr[i++]);
           }
           i++;

           int noc = Integer.valueOf(sb.toString());
           int end = i + noc;
           sb = new StringBuilder();
           while(i < end){
                sb.append(arr[i++]);
           }
           i--;
           result.add(sb.toString());
        }
        return result;
    }
}
