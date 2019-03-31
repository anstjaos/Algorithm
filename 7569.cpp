#include <iostream>
#include <queue>
using namespace std;

typedef struct {
	int value;
	bool isChange;
}tomato;

typedef struct {
	int x, y, z;
}mv;

queue<mv> q;
int M, N, H;
tomato tomatoArr[101][101][101];
int nextDir[6][3] = { {1,0,0}, {-1,0,0}, {0,-1,0}, {0,0,1}, {0,1,0}, {0,0,-1} };
int day = 0, cnt = 0;
bool visit[101][101][101];


int bfs()
{
	int ans = 1;
	while (!q.empty())
	{
		int size = q.size();
		for (int i = 0; i < size; i++)
		{
			mv cur = q.front();
			q.pop();

			if (visit[cur.x][cur.y][cur.z] == true) continue;

			visit[cur.x][cur.y][cur.z] = true;

			for (int i = 0; i < 6; i++)
			{
				int nextX = cur.x + nextDir[i][0];
				int nextY = cur.y + nextDir[i][1];
				int nextZ = cur.z + nextDir[i][2];

				if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= N || nextZ < 0 || nextZ >= M) continue;

				if (tomatoArr[nextX][nextY][nextZ].value == 0)
				{
					tomatoArr[nextX][nextY][nextZ].value = 1;
					q.push({ nextX,nextY,nextZ });
					cnt--;
				}

				if (cnt == 0) return ans;
			}
		}
		ans++;
	}

	return -1;
}
int main()
{
	cin >> M >> N >> H;

	for (int i = 0; i < H; i++)
	{
		for (int j = 0; j < N; j++)
		{
			for (int k = 0; k < M; k++)
			{
				cin >> tomatoArr[i][j][k].value;
				if (tomatoArr[i][j][k].value == 1) q.push({ i,j,k });
				else if (tomatoArr[i][j][k].value == 0) cnt++;
				tomatoArr[i][j][k].isChange = false;
			}
		}
	}

	if (cnt == 0) day = 0;
	else day = bfs();
	cout << day << '\n';
	return 0;
}