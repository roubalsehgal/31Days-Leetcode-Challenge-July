class Solution {
	private final Map < String,
	List < String >> cache = new HashMap < >();

	public List < String > wordBreak(String s, List < String > dict) {
		if (cache.containsKey(s)) return cache.get(s);
		List < String > result = new LinkedList < >();
		if (dict.contains(s)) result.add(s);
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i),
			right = s.substring(i);
			if (dict.contains(left) && containsSuffix(dict, right)) {
				for (String ss: wordBreak(right, dict)) {
					result.add(left + " " + ss);
				}
			}
		}
		cache.put(s, result);
		return result;
	}

	private boolean containsSuffix(List < String > dict, String str) {
		for (int i = 0; i < str.length(); i++) {
			if (dict.contains(str.substring(i))) return true;
		}
		return false;
	}
}