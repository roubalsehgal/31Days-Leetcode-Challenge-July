class Solution {
	public List <List <Integer>> subsets(int[] nums) {
		List < List<Integer>> ans = new ArrayList <>();
		int length = nums.length;
		int total = 1 << length;
		int i = 0;
		while (i < total) {
			int curr = i;
			int pos = 0;
			List <Integer> list = new ArrayList <>();
			while (curr != 0) {
				if ((curr & 1) == 1) {
					list.add(nums[pos]);
				}
				curr = curr >> 1;
				pos += 1;
			}
			ans.add(list);
			i++;
		}
		return ans;
	}
}