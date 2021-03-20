#include <iostream>
using namespace std;

typedef struct a{
	int x, y;
	a() {}
	a(int i_x, int i_y)
	{
		x = i_x;
		y = i_y;
	}
}pt;

pt home[51], chicken[51];
bool check[51];
int N, M, result = 2123456789;
int temp, homeIndex, chickenIndex;

void bruteForce(int cnt, int chickCnt)
{
	if (cnt > chickenIndex) return;

	if (chickCnt == M)
	{
		int temp;
		int sum = 0;
		int min;
		for (int i = 0; i < homeIndex; i++)
		{
			min = 2123456789;
			for (int j = 0; j < chickenIndex; j++)
			{
				if (check[j] == true)
				{
					temp = abs(chicken[j].x - home[i].x) + abs(chicken[j].y - home[i].y);
					if (temp < min)
					{
						min = temp;
					}
				}
			}

			sum += min;
		}
		if (sum < result)
		{
			result = sum;
		}
		return;
	}

	check[cnt] = true;
	bruteForce(cnt + 1, chickCnt + 1);

	check[cnt] = false;
	bruteForce(cnt + 1, chickCnt);

}

int main()
{
	scanf("%d %d ", &N, &M);
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			scanf("%d ", &temp);
			if (temp == 1)
			{
				home[homeIndex] = pt(i, j);
				homeIndex++;
			}
			else if (temp == 2)
			{
				chicken[chickenIndex] = pt(i, j);
				chickenIndex++;
			}
		}
	}

	bruteForce(0, 0);

	printf("%d\n", result);
	return 0;
}