#include <iostream>
using namespace std;

int testCase, ant[1000001], antCnt, len;
int minResult, maxResult;

int min(int a, int b) { return (a < b ? a : b); }
int max(int a, int b) { return (a > b ? a : b); }

void init()
{
	cin >> len >> antCnt;
	for (int i = 0; i < antCnt; i++) cin >> ant[i];
	minResult = -1;
	maxResult = -1;
}

void solve()
{
	for (int i = 0; i < antCnt; i++)
	{
		if (ant[i] <= len / 2)
		{
			minResult = max(minResult, ant[i]);
			maxResult = max(maxResult, len - ant[i]);
		}
		else
		{
			minResult = max(minResult, len - ant[i]);
			maxResult = max(maxResult, ant[i]);
		}
	}
}

int main()
{
	cin >> testCase;
	for (int i = 0; i < testCase; i++)
	{
		init();
		solve();

		cout << minResult << " " << maxResult << '\n';
	}
	return 0;
}
