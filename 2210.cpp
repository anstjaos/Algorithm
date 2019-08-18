#include <iostream>
using namespace std;

int arr[5][5];
char result[1000001][6];
int resultCnt = 0;
int dirX[4] = { -1,0,1,0 }, dirY[4] = { 0,1,0,-1 };

int strlen1(char *src)
{
	int index = 0;
	while (src[index] != 'a') index++;
	return index;
}

void strcat1(char *dest, char *src)
{
	int srcLen = strlen1(src);

	for (int i = 0; i < srcLen; i++)
	{
		dest[ i] = src[i];
	}
}

bool strcmp1(char *src, char *src2)
{
	for (int i = 0; i < 6; i++)
	{
		if (src[i] != src2[i]) return false;
	}
	return true;
}

void dfs(char num[10], int x, int y, int count)
{
	if (count == 6)
	{
		bool alone = true;
		for (int i = 0; i < resultCnt; i++)
		{
			if (strcmp1(result[i], num) == true)
			{
				alone = false;
				break;
			}
		}

		if (alone == true) strcat1(result[resultCnt++], num);

		return;
	}
	
	char temp[10];
	for (int i = 0; i < 10; i++)
	{
		temp[i] = num[i];
	}

	for (int i = 0; i < 4; i++)
	{
		int nextX = x + dirX[i];
		int nextY = y + dirY[i];

		if (nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5) continue;

		temp[count] = (char)arr[nextX][nextY];
		dfs(temp, nextX, nextY, count + 1);
		temp[count] = 'a';
	}
}

int main()
{
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++) cin >> arr[i][j];
	}

	char temp[10];
	for (int i = 0; i < 10; i++)
	{
		temp[i] = 'a';
	}
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5; j++)
		{
			temp[0] = arr[i][j];
			dfs(temp, i, j, 1);
		}
	}

	cout << resultCnt << endl;
	return 0;
}