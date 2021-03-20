#include <iostream>
using namespace std;

long long arr[10001], N, budget, maxNum, sum;

int solve()
{
	long long left = 0;
	long long right = maxNum;
	long long middle, sum;

	while (left <= right)
	{
		middle = (left + right) / 2;
		sum = 0;
		for (int i = 0; i < N; i++)
		{
			if (arr[i] > middle) sum += middle;
			else sum += arr[i];
		}

		if (sum > budget)
		{
			
			right = middle -1;
		}
		else
		{
			left = middle +1 ;
		}
	}

	return right;
}

int main()
{
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
		if (arr[i] > maxNum) maxNum = arr[i];

		sum = sum + arr[i];
	}
	cin >> budget;

	if (budget > sum)
	{
		cout << maxNum << endl;
		return 0;
	}

	cout << solve() << endl;
	return 0;
}