#include <stdio.h>
#include <queue>
using namespace std;

typedef struct {
	int a;
	int b;
	int c;
	int cnt;
}Mutal;

int N, arr[3], result;
int attack[6][3] = { {9,3,1}, {9,1,3}, {3,9,1}, {3,1,9}, {1,3,9}, {1,9,3} };
bool visit[61][61][61][20];

int min(int a, int b) { return (a < b ? a : b); }
int max(int a, int b) { return (a > b ? a : b); }

void solve()
{
	queue<Mutal> q;
	q.push({ arr[0], arr[1], arr[2], 0 });

	while (!q.empty())
	{
		Mutal cur = q.front();
		q.pop();

		if (cur.a <= 0 && cur.b <= 0 && cur.c <= 0) {
			result = min(result, cur.cnt);
			continue;
		}

		for (register int i = 0; i < 6; i++) {
			int nextA = max(0, cur.a - attack[i][0]);
			int nextB = max(0, cur.b - attack[i][1]);
			int nextC = max(0, cur.c - attack[i][2]);

			if (!visit[nextA][nextB][nextC][cur.cnt+1]) {
				visit[nextA][nextB][nextC][cur.cnt+1] = true;
				q.push({ nextA, nextB, nextC, cur.cnt + 1 });
			}
		}
	}
}

int main()
{
	result = 2123456789;
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) scanf("%d", arr + i);

	solve();
	printf("%d\n", result);
	return 0;
}