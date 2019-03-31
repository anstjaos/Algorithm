#include <iostream>
using namespace std;

int stone[101], cur, cnt, total;
int blue, red, green;
char dir;

int main()
{
	blue = red = green = 0;
	cin >> total >> cnt;
	for (int i = 0; i < cnt; i++)
	{
		cin >> cur >> dir;

		if (dir == 'L')
		{
			for (int j = cur - 1; j > 0; j--) stone[j] = (stone[j] + 1) % 3;
		}
		else if (dir == 'R')
		{
			for (int j = cur + 1; j <= 100; j++) stone[j] = (stone[j] + 1) % 3;
		}
	}

	for (int i = 1; i <= 100; i++)
	{
		if (stone[i] == 0) blue++;
		else if (stone[i] == 1) red++;
		else if (stone[i] == 2) green++;
	}

	float blueCnt = total  * blue / 100.0;
	float redCnt = total* red / 100.0;
	float greenCnt = total* green / 100.0;
	printf("%.2f\n", blueCnt);
	printf("%.2f\n", redCnt);
	printf("%.2f\n", greenCnt);
	return 0;
}