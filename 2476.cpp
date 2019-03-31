#include <iostream>
using namespace std;

int arr[3], testCase;
int maxNum = -1;

int solve()
{
	int max = -1;
	for (int i = 0; i < 3; i++)
	{
		if (arr[i] > max) max = arr[i];
	}

	if (arr[0] == arr[1] && arr[1] == arr[2]) return (arr[0] * 1000) + 10000;
	else if (arr[0] == arr[1] || arr[0] == arr[2]) return (arr[0] * 100) + 1000;
	else if (arr[1] == arr[2]) return (arr[1] * 100) + 1000;
	else return max * 100;
}

int main()
{
	cin >> testCase;
	while (testCase--)
	{
		for (int i = 0; i < 3; i++) cin >> arr[i];

		int result = solve();
		if (result > maxNum) maxNum = result;
	}

	cout << maxNum << "\n";
	return 0;
}