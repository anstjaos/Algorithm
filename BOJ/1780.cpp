#include <iostream>
using namespace std;

int paper[2200][2200], cnt[3], N;

void solve(int x, int y, int size)
{
	if (size == 1) {
		cnt[paper[x][y] + 1]++;
		return;
	}

	bool isSame = true;
	int num = paper[x][y];

	for (int i = 0; i < size; i++)
	{
		if (isSame == false) break;
		for (int j = 0; j < size; j++) {
			if (num != paper[x + i][y + j]) {
				isSame = false;
				break;
			}
		}
	}

	if (isSame)
	{
		cnt[num + 1]++;
		return;
	}

	size = size / 3;
	
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			solve(x + (size * i), y + (size * j), size);
		}
	}
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			scanf("%d", &paper[i][j]);
		}
	}

	solve(0, 0, N);
	printf("%d\n%d\n%d\n", cnt[0], cnt[1], cnt[2]);
	return 0;
}