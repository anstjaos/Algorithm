#include <stdio.h>
#include <algorithm>

int N, arr[55], pred[55], ans[55], ansCount, s;
bool prime[2000], visit[55];

void init()
{
	for (register int i = 2; i < 2000; i++) prime[i] = true;

	for (register int i = 2; i * i < 2000; i++) {
		if (prime[i]) {
			for (register int j = i * i; j < 2000; j += i) {
				prime[j] = false;
			}
		}
	}
}

bool dfs(int cur)
{
	if (cur == -1) return true;
	
	for (register int i = 1; i < N; i++) {
		if (cur == i || i == s) continue;
		if ((arr[cur] & 1) == (arr[i] & 1)) continue;
		if (!prime[arr[cur] + arr[i]]) continue;
		if (visit[i]) continue;

		visit[i] = true;
		if (dfs(pred[i])) {
			pred[i] = cur;
			return true;
		}
	}
	return false;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) scanf("%d", arr + i);
	init();
	
	for (register int i = 1; i < N; i++) {
		if ((arr[0] & 1) == (arr[i] & 1)) continue;
		if (!prime[arr[0] + arr[i]]) continue;

		int oddSize = 0, evenSize = 0;
		for (register int j = 0; j < N; j++) {
			pred[j] = -1;
			
			if (j != 0 && j != i) {
				if (arr[j] & 1) oddSize++;
				else evenSize++;
			}
		}

		if (evenSize != oddSize) continue;
		// pred[i] = 0;
		s = i;

		int res = 0;
		for (register int j = 1; j < N; j++) {
			if (j == i) continue;
			for (register int k = 0; k < N; k++) visit[k] = false;

			if (dfs(j)) {
				res+=1;
			}
		}

		
		if (evenSize + oddSize == res) {
			ans[ansCount] = arr[i];
			ansCount++;
		}
	}

	if (ansCount == 0) printf("-1\n");
	else {
		std::sort(ans, ans + ansCount);
		for (register int i = 0; i < ansCount; i++) {
			printf("%d ", ans[i]);
		}
		printf("\n");
	}

	return 0;
}