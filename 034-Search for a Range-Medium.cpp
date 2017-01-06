#include <vector>

using namespace std;

/*
	Given an array of integers sorted in ascending order, find the starting and ending position 
	of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).

	If the target is not found in the array, return [-1, -1].

	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
*/

class Solution {
public:
	vector<int> searchRange(vector<int>& nums, int target) {
		vector<int> ret;
		ret.push_back(-1);
		ret.push_back(-1);
		if (nums.empty()) return ret;

		int size = nums.size();
		for (int i = 0; i < size; i++)
		{
			if (nums[i] > target) break;
			if (nums[i] == target)
			{
				if (ret[0] == -1)
				{
					ret[0] = i;
				}
				else
				{
					ret[1] = i;
				}
			}
		}
		if (ret[0] != -1 && ret[1] == -1)
		{
			ret[1] = ret[0];
		}
		return ret;
	}
};