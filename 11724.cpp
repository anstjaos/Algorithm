#include <iostream>
using namespace std;

int map[1001][1001];
bool visit[1001];
int edgeCnt, vertexCnt;
int from, to;
int result = 0;

void DFS(int start)
{
	visit[start] = true;

	for (int i = 1; i <= edgeCnt; i++)
	{
		if (map[start][i] == 1 && visit[i] == false)
		{
			DFS(i);
		}
	}
}

int main()
{
	cin >> edgeCnt >> vertexCnt;

	for (int i = 0; i < vertexCnt; i++)
	{
		cin >> from >> to;
		map[from][to] = 1;
		map[to][from] = 1;
	}

	for (int i = 1; i <= edgeCnt; i++)
	{
		if (visit[i] == false)
		{
			DFS(i);
			result++;
		}
	}

	for (int i = 1; i <= edgeCnt; i++) if (visit[i] == false) result++;

	cout << result << '\n';
	return 0;
}