#include <iostream>
using namespace std;

int city;
int cost[11][11];
bool visit[11];
int minNum = 2123456788;

void solve(int start, int cnt, int sum, int first)
{
	if (cnt == city-1)
	{
		if (cost[start][first] == 0) return;

		sum = sum + cost[start][first];
		if (sum < minNum) minNum = sum;

		return;
	}

	for (int i = 0; i < city; i++)
	{
		if (i == start) continue;
		if (visit[i] == false && cost[start][i] != 0)
		{
			visit[i] = true;
			solve(i, cnt + 1, sum + cost[start][i],first);
			visit[i] = false;
		}
	}
}

int main()
{
	cin >> city;

	for (int i = 0; i < city; i++)
	{
		for (int j = 0; j < city; j++) cin >> cost[i][j];
	}

	for (int i = 0; i < city; i++)
	{
		for (int j = 0; j < city; j++) visit[j] = false;
		
		visit[i] = true;
		solve(i,0, 0,i);
		visit[i] = false;
	}

	cout << minNum << "\n";
	return 0;
}