#include <cstdio>

typedef struct {
	int num;
	int a;
	int h;
}Info;

Info arr[123457];
int N, atk;
long long res;

bool solve(long long h)
{
	long long hp = h;
	long long attack = atk;

	for (register int i = 0; i < N; i++)
	{
		if (arr[i].num == 1)
		{
			if (((arr[i].h - 1) / attack) > ((hp - 1) / arr[i].a))
				return false;

			hp -= (arr[i].h - 1) / attack * arr[i].a;
			
		}
		else if (arr[i].num == 2) {
			attack += arr[i].a;
			hp = (hp + arr[i].h);
			if (hp >= h) hp = h;
		}
	}
	return true;
}

int main()
{
	scanf("%d %d", &N, &atk);
	for (register int i = 0; i < N; i++) {
		scanf("%d %d %d", &arr[i].num, &arr[i].a, &arr[i].h);
	}

	long long left = 1, right = 1e18;
	while (left <= right)
	{
		long long mid = (left + right) / 2;

		if (solve(mid))
		{
			res = mid;
			right = mid - 1;
		}
		else left = mid + 1;
	}

	printf("%lld\n", res);
	return 0;
}