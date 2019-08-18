#include <stdio.h>
#include <algorithm>

int arr[15], k;
bool check[15];

void solve(int before, int cnt)
{
	if (cnt == 6) {
		for (register int i = 0; i < k; i++) {
			if (check[i]) {
				printf("%d ", arr[i]);
			}
		}
		printf("\n");
		return;
	}

	for (register int i = before + 1; i < k; i++) {
		if (!check[i]) {
			check[i] = true;
			solve(i, cnt + 1);
			check[i] = false;
		}
	}
}

int main()
{
	bool first = true;
	while (scanf("%d", &k))
	{
		if (k == 0) break;
		if (first == true) {
			first = false;
		}
		else printf("\n");

		for (register int i = 0; i < k; i++)
		{
			scanf("%d", arr + i);
			check[i] = false;
		}
		std::sort(arr, arr + k);
		solve(-1,0);
	}
	
	return 0;
}