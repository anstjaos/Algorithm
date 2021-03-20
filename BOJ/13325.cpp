#include <iostream>
using namespace std;

int k, arr[(1 << 21) +1], check[(1<<21) +1];
int initSum, sum, temp , maxVal;

int max(int a, int b) { return (a > b ? a : b); }
int min(int a, int b) { return (a < b ? a : b); }

void setCheck(int cur, int val)
{
	if (1 << k <= cur && cur <= 1 << (k + 1)) return;

	check[cur * 2] -= val;
	check[cur * 2 + 1] -= val;

	setCheck(cur * 2, val);
	setCheck(cur * 2 + 1, val);
}

int main()
{
	scanf("%d", &k);

	for (int i = 0; i < (1 << (k + 1)) - 2; i++)
	{
		scanf("%d", &temp);
		initSum += temp;
		arr[i + 2] = arr[(i + 2) / 2] + temp;

		maxVal = max(maxVal, arr[i + 2]);
	}

	for (int i = 1 << k; i < 1 << (k + 1); i++) check[i] = maxVal - arr[i];

	for (int i = (1 << k) - 1; i >= 2; i--) check[i] = min(check[i * 2], check[i * 2 + 1]);

	for (int i = 2; i < 1 << (k + 1); i++)
	{
		sum += check[i];
		if (check[i] == 0) continue;

		setCheck(i, check[i]);
	}

	printf("%d\n", initSum + sum);
	return 0;
}