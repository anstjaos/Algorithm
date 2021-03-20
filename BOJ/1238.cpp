#include <iostream>
using namespace std;

int map[1001][1001], N, M, desti, revmap[1001][1001];
int from, to, cost, maxNum = -1;
int partyToHome[1001], homeToParty[1001];

int min(int a, int b) { return (a < b ? a : b); }

void goHome(int *arr, int road[1001][1001])
{
	bool visit[1001];

	for (int i = 1; i <= N; i++)
	{
		visit[i] = false;
		
		if (road[desti][i] != 0)
		{
			arr[i] = road[desti][i];
		}
		else arr[i] = 2123456789;
	}

	int minCost = 2123456789;
	int cur = desti;

	while (1)
	{
		minCost = 2123456789;
		cur = desti;
		for (int i = 1; i <= N; i++)
		{
			if (i == desti) continue;

			if (visit[i] == false && arr[i] != 0 && arr[i] < minCost)
			{
				minCost = arr[i];
				cur = i;
			}
		}
		if (cur == desti) break;

		visit[cur] = true;
		for (int i = 1; i <= N; i++)
		{
			if (road[cur][i] != 0)
			{
				arr[i] = min(arr[cur] + road[cur][i], arr[i]);
			}
		}
	}
	
}

int main()
{
	cin >> N >> M >> desti;
	for (int i = 0; i < M; i++)
	{
		cin >> from >> to >> cost;
		map[from][to] = cost;
		revmap[to][from] = cost;
	}

	goHome(partyToHome, map);
	goHome(homeToParty, revmap);
	for (int i = 1; i <= N; i++)
	{
		if (i == desti) continue;
		if (partyToHome[i] + homeToParty[i] > maxNum) maxNum = partyToHome[i] + homeToParty[i];
	}
	cout << maxNum << endl;
	return 0;
}