#include <cstdio>
#define MAX_SIZE 1000005

int x, y, aftXidx, befYidx, arr[MAX_SIZE];
long long sum[MAX_SIZE], answer;

long long max(long long a, long long b) { return (a > b ? a : b); }

void init()
{
	sum[1] = 1;
	for (register int i = 2; i < MAX_SIZE; i++)
	{
		sum[i] = sum[i - 1] + i;
	}
	int idx = 1;
	for (register int i = 0; i < MAX_SIZE; i++)
	{
		if (i >= sum[idx]) idx++;
		arr[i] = idx;
	}
}

long long getCount(int val, int idx)
{
	long long ret = 0;
	int num, index, temp = val;
	while (1)
	{
		ret = 0;
		num = temp;
		index = idx;
		while (1)
		{
			if (num <= 2) {
				ret += num;
				return ret;
			}
			while (sum[index] > num) index--;
			num -= sum[index];
			if (num == 0) break;
			ret += index;
		}
		temp--;
	}
	
	return ret;
}

int main()
{
	int testCase;
	scanf("%d", &testCase);
	init();
	for (register int t = 1; t <= testCase; t++)
	{
		answer = 0;
		scanf("%d %d", &x, &y);
		for (register int i = 1; i < MAX_SIZE; i++) {
			if (sum[i] > x) {
				aftXidx = i;
				break;
			}
		}
		for (register int i = aftXidx - 1; i < MAX_SIZE; i++) {
			if (sum[i] > y) {
				befYidx = i - 1;
				break;
			}
			else if (sum[i] == y) {
				befYidx = i;
				break;
			}
		}

		answer = max(getCount(sum[aftXidx] -1, aftXidx-1), max(getCount(sum[befYidx] -1, befYidx-1), getCount(y, befYidx)));
		printf("Case #%d\n%lld\n", t, answer);
	}
	return 0;
}