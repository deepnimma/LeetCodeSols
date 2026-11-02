public class Codec {
    String delimiter = "🔥";
    String emptySig = "🚀";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String finalString = (strs.get(0).isEmpty()) ? emptySig : strs.get(0); 

        for (int i = 1; i < strs.size(); i++) {
            if (strs.get(i).isEmpty()) finalString += delimiter + emptySig;
            else finalString += delimiter + strs.get(i);
        } // for

        return finalString;
    } // encode

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] split = s.split(delimiter);

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(emptySig)) split[i] = "";
        } // for

        return List.of(split);
    } // decode
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));