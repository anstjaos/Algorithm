#include <string>
#include <vector>
#include <algorithm>
using namespace std;

typedef struct {
	int idx;
	int sum;
}Food;

bool cmp(Food &a, Food &b)
{
	if (a.sum == b.sum) return a.idx < b.idx;
	return a.sum < b.sum;
}

Food foodArr[200005];

int solution(vector<int> food_times, long long k) {
	int answer = 0;
	int foodSize = food_times.size();
	for (register int i = 0; i < foodSize; i++) {
		foodArr[i] = { i + 1, food_times[i] };
	}
	sort(foodArr, foodArr + foodSize, cmp);

	int idx = 0, len = foodSize;

	while (foodSize != 0 && k > 0) {
		if (foodArr[idx].sum * foodSize <= k) {
			k -= foodArr[idx].sum * foodSize;
			for (register int i = idx; i < len; i++) foodArr[i].sum -= foodArr[idx].sum;

			foodSize--;
			idx++;
		}
		else {
			while (k - foodSize >= 0 && foodSize != 0) {
				k -= foodSize;
				for (register int i = idx; i < len; i++) foodArr[i].sum--;

				while (foodArr[idx].sum == 0&& foodSize != 0) {
					idx++;
					foodSize--;
				}
			}

			while (k > 0 && foodSize != 0) {
				k--;
				idx++;
			}
		}
	}

	if (k > 0) answer = -1;
	else answer = foodArr[idx].idx;

	return answer;
}

int main()
{
	vector<int> food_times = { 3, 1,2 };
	solution(food_times, 5);
}