#include <stdio.h>
#include <algorithm>

int arr[20], res[20];
int cnt;
bool visit[20];

bool permu(int depth)
{
	if (depth == cnt - 1)
	{
		arr[cnt-1]--;
		if (arr[cnt-1] == 0) return true;
		return false;
	}

	for (register int i = 0; i < cnt - 1; i++) {
		if (visit[i]) continue;

		visit[i] = true;
		res[depth] = arr[i];
		if(permu(depth + 1)) return true;
		visit[i] = false;
	}
	return false;
}

int main()
{
	while (scanf("%d", arr + cnt) != -1) {
		cnt++;
	}
	std::sort(arr, arr + cnt - 1);
	permu(0);

	for (register int i = 0; i < cnt - 1; i++) {
		printf("%d", res[i]);
	}
	printf("\n");
	return 0;
}