#include <iostream>
#include <algorithm>
using namespace std;

int arr[9], result[7];

bool solve(int cur, int sum)
{
	if (cur == 7)
	{
		if (sum == 100) return true;
		return false;
	}

	for (int i = cur; i < 9; i++)
	{
		result[cur] = arr[i];
		if (solve(cur + 1, sum + arr[i])) return true;
	}
	return false;
}

int main()
{
	for (int i = 0; i < 9; i++) cin >> arr[i];
	solve(0, 0);
	sort(result, result + 7);

	for (int i = 0; i < 7; i++) cout << result[i] << '\n';
	return 0;
}