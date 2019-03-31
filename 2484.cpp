#include <iostream>
using namespace std;

int testCase, arr[4];
int maxNum = -1;

int solve()
{
	int max = -1;
	for (int i = 0; i < 4; i++)
	{
		if (arr[i] > max) max = arr[i];
	}

	if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) return (arr[0] * 5000) + 50000;
	else if ((arr[0] == arr[1] && arr[1] == arr[2]) || (arr[0] == arr[1] && arr[1] == arr[3]) || (arr[0] == arr[2] && arr[2] == arr[3])) return (arr[0] * 1000) + 10000;
	else if (arr[1] == arr[2] && arr[2] == arr[3]) return (arr[1] * 1000) + 10000;
	else if (arr[0] == arr[1] && arr[2] == arr[3]) return 2000 + (arr[0] * 500) + (arr[2] * 500);
	else if (arr[0] == arr[2] && arr[1] == arr[3]) return 2000 + (arr[0] * 500) + (arr[1] * 500);
	else if(arr[0] == arr[3] && arr[1] == arr[2]) return 2000 + (arr[0] * 500) + (arr[1] * 500);
	else if ((arr[0] == arr[1]) || (arr[0] == arr[2]) || (arr[0] == arr[3])) return 1000 + (arr[0] * 100);
	else if ((arr[1] == arr[2]) || (arr[1] == arr[3])) return 1000 + (arr[1] * 100);
	else if ((arr[2] == arr[3])) return 1000 + (arr[2] * 100);
	
	return max * 100;
}

int main()
{
	cin >> testCase;
	while (testCase--)
	{
		for (int i = 0; i < 4; i++) cin >> arr[i];

		int result = solve();
		if (result > maxNum) maxNum = result;
	}

	cout << maxNum << "\n";
	return 0;
}