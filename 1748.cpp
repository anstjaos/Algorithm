#include <iostream>
using namespace std;

int dp[10];
int input;

void init()
{
	dp[1] = 9;
	dp[2] = 90;

	for (int i = 3; i < 9; i++)
	{
		dp[i] = dp[i - 1] * 10 ;
	}
}

int checkNum(int num)
{
	int cnt = 1;
	while (num != 1)
	{
		num = num / 10;
		cnt++;
	}

	return cnt;
}

int findNum(int num)
{
	int val = 1;
	for (int i = 0; i < num-1; i++)
	{
		val = val * 10;
	}

	return val;
}

int main()
{
	init();
	scanf(" %d", &input);
	int num = checkNum(input);

	long long result = (input - findNum(num) +1)* num;

	for (int i = 1; i < num; i++) result = result + (dp[i] * i);

	printf("%d\n", result);
	return 0;
}