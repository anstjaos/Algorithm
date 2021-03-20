#include <stdio.h>
#include <queue>
#define MAX_SIZE 51
using namespace std;

typedef struct {
	int y;
	int x;
}Virus;

int arr[MAX_SIZE][MAX_SIZE], result, N, M, virusCnt, infect;
Virus virusArr[MAX_SIZE * MAX_SIZE + 2];
bool check[MAX_SIZE * MAX_SIZE + 2], visit[MAX_SIZE][MAX_SIZE];
int dirY[4] = { -1,0,1,0 }, dirX[4] = { 0,1,0,-1 };

int min(int a, int b) { return (a < b ? a : b); }

void solve()
{
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) visit[i][j] = false;
	}
	queue<Virus> q;
	for (register int i = 0; i < virusCnt; i++) {
		
		if (check[i])
		{
			q.push(virusArr[i]);
			visit[virusArr[i].y][virusArr[i].x] = true;
		}
	}

	int t = -1;
	int ife = infect;
	while (!q.empty())
	{
		int size = q.size();
		t++;
		if (ife == 0) break;
		for (register int i = 0; i < size; i++) {
			Virus cur = q.front();
			q.pop();

			for (register int j = 0; j < 4; j++) {
				int nextY = cur.y + dirY[j];
				int nextX = cur.x + dirX[j];

				if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N || visit[nextY][nextX] || arr[nextY][nextX] == 1) continue;

				q.push({ nextY,nextX });
				visit[nextY][nextX] = true;
				if (arr[nextY][nextX] == 0) ife--;
			}
		}
	}

	for (register int i = 0; i < N; i++)
	{
		for (register int j = 0; j < N; j++) {
			if (visit[i][j] == false && arr[i][j] == 0) return;
		}
	}
	result = min(result, t);
}

void dfs(int cnt, int bef)
{
	if (cnt == M) {
		solve();
		return;
	}

	for (register int i = bef + 1; i < virusCnt; i++) {
		if (check[i] == false) {
			check[i] = true;
			dfs(cnt + 1, i);
			check[i] = false;
		}
	}
}

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) {
			scanf("%d", &arr[i][j]);
			
			if (arr[i][j] == 2) {
				virusArr[virusCnt++] = { i,j };
			}
			else if (arr[i][j] == 0) infect++;
		}
	}
	result = 2123456789;
	dfs(0, -1);
	result == 2123456789? printf("-1\n") : printf("%d\n", result);
	return 0;
}