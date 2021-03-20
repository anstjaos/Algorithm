#include <iostream>
#include <vector>
using namespace std;

int map[1001][1001], vertexCnt, edgeCnt, degree[1001];
vector<int> path;

void dfs(int start)
{
	for (int i = 1; i <= vertexCnt; i++)
	{
		while (map[start][i] > 0)
		{
			map[start][i]--;
			map[i][start]--;
			dfs(i);
		}
	}

	path.push_back(start);
	return;
}

bool exist()
{
	for (int i = 1; i <= vertexCnt; i++)
	{
		degree[i] = degree[i] / 2;
		if (degree[i] % 2 == 1) return false;
	}

	return true;

}
int main()
{
	
	cin >> vertexCnt;
	for (int i = 1; i <= vertexCnt; i++)
	{
		for (int j = 1; j <= vertexCnt; j++)
		{
			cin >> map[i][j];
			degree[i] += map[i][j];
			degree[j] += map[i][j];
		}
	}

	if (!exist())
	{
		cout << "-1" << endl;
		return 0;
	}
	dfs(1);

	int size = path.size();

	for (int i = size - 1; i >= 0; i--) cout << path[i] << " ";

	cout << endl;
	return 0;
}