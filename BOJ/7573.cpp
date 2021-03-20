#include <iostream>
using namespace std;

typedef struct {
	int x;
	int y;
}fish;

fish sea[101];
int seaSize, l, M;
int maxFish = 0;

void solve(int x, int y, int cur)
{
	int half = l / 2;
	for (int i = 1; i < half; i++)
	{
		int cnt = 1;
		for (int j = 0; j < M; j++)
		{
			if (j == cur) continue;

			if (sea[j].x <= x + i && sea[j].y <= y + (half - i) && x + i <= seaSize && y+ (half - i) <= seaSize
				&& sea[j].x >= x && sea[j].y >= y) cnt++;
		}
		if (cnt > maxFish) maxFish = cnt;

		cnt = 1;
		for (int j = 0; j < M; j++)
		{
			if (j == cur) continue;
			if (sea[j].x <= x + (half - i) && sea[j].y <= y + i && x + (half - i) <= seaSize && y + i <= seaSize
				&& sea[j].x >= x && sea[j].y >= y) cnt++;
		}
		if (cnt > maxFish) maxFish = cnt;
	}
}

int main()
{
	cin >> seaSize >> l >> M;
	int x, y;
	for (int i = 0; i < M; i++)
	{
		cin >> x >> y;
		sea[i] = { x,y };
	}

	for (int i = 0; i < M; i++) solve(sea[i].x, sea[i].y,i);

	cout << maxFish << endl;
	return 0;
}