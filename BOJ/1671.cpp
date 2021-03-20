#include <stdio.h>

typedef struct Shark {
	int size;
	int speed;
	int inteli;

	bool operator==(const Shark& a)
	{
		return (a.size == size && a.speed == speed && a.inteli == inteli);
	}

	bool operator>=(const Shark& a)
	{
		return (size >= a.size && speed >= a.speed && inteli >= a.inteli);
	}
}Shark;

int N;
Shark sharkArr[55];
int feedCount[55], feedArr[55][55], pred[55];
bool visit[55];

bool dfs(int cur)
{
	if (cur == -1) return true;
	
	int count = feedCount[cur];
	for (register int i = 0; i < count; i++) {
		int next = feedArr[cur][i];
		if (visit[next]) continue;
		visit[next] = true;
		if (dfs(pred[next])) {
			pred[next] = cur;
			return true;
		}
	}
	return false;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%d %d %d", &sharkArr[i].size, &sharkArr[i].speed, &sharkArr[i].inteli);
	}

	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < N; j++) {
			if (i == j) continue;

			if (sharkArr[i] == sharkArr[j]) {
				if (i < j) {
					feedArr[i][feedCount[i]] = j;
					feedCount[i]++;
				}
			}
			else if (sharkArr[i] >= sharkArr[j]) {
				feedArr[i][feedCount[i]] = j;
				feedCount[i]++;
			}
		}
	}

	int ans = 0;
	for (register int i = 0; i < N; i++) pred[i] = -1;
	for (register int i = 0; i < N; i++) {
		for (register int j = 0; j < 2; j++) {
			for (register int k = 0; k < N; k++) visit[k] = false;

			if (dfs(i)) {
				ans += 1;
			}
		}
	}

	printf("%d\n", N- ans);
	return 0;
}