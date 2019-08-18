#include <iostream>
#include <cstdio>
#include <climits>

#define MAX 500002

using namespace std;

int totalBottom[MAX];
int totalTop[MAX];
int total[MAX];
int bottom[MAX];
int top[MAX];

int main()
{
	int n, h;
	int min = INT_MAX;
	int count = 1;

	scanf("%d %d", &n, &h);

	for (int i = 0; i < n / 2; i++)
	{
		int bVal, tVal;
		scanf("%d %d", &bVal, &tVal);

		top[tVal]++;
		bottom[bVal]++;
	}

	// Prefix Sum
	for (int i = h; i >= 1; i--)
	{
		totalBottom[i] = bottom[i] + totalBottom[i + 1];
		totalTop[i] = top[i] + totalTop[i + 1];
	}

	for (int i = 1; i <= h; i++)
	{
		// 길이 i의 석순을 파괴할때 파괴되는 모든 종유석과 석순의 수 계산
		total[i] = totalBottom[i] + totalTop[h - i + 1];

		// min과 count를 찾기위한 과정
		if (total[i] <= min)
			total[i] == min ? count++ : count = 1, min = total[i];
	}

	printf("%d %d\n", min, count);

	return 0;
}